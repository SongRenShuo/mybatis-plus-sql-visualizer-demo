package cn.song.sqlvis.repro;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Recon 0：对 agent fat jar 做静态取证（不加载 agent 任何一个类）。
 *
 * <p>要证伪的假设（主控提出）：「删掉 {@code implements Opcodes} 就能把失败点后移到真正需要
 * ASM 的 {@code weave()}」。取证分三步：
 * <ol>
 *   <li>jar 条目是否齐全（排除「打包漏类」）；</li>
 *   <li>{@code StatementWeaver} 的接口表里是否只有重定位后的 {@code Opcodes}（编译期常量内联后，
 *       {@code implements Opcodes} 是运行期额外的解析要求）；</li>
 *   <li>{@code Opcodes} 的引用是否**只有**接口表这一处——若不是（例如还有非 final 静态字段
 *       {@code getstatic}），删接口不能消除解析要求，只能把失败时点推后。</li>
 * </ol>
 * 第 3 步是判据关键，所以用「活引用闭包」而不是简单的字符串搜索：{@code ClassWriter(ClassReader,
 * flags)} 会把原常量池整份拷贝进产物，留下大量**永不解析**的死条目，字符串搜索会把它们误当成
 * 真实依赖。
 */
public final class AgentJarProbe {

    static final String ASM_NEW = "cn/song/mybatisplus/sqlvis/agent/asm/";
    static final String ASM_OLD = "org/objectweb/asm/";

    private final File jar;

    public AgentJarProbe(File jar) {
        this.jar = jar;
    }

    public Report run() throws Exception {
        final Report r = new Report();
        final Map<String, byte[]> entries = readAll();

        // ---- 1) 条目齐全性 ----
        String[] required = {
                "cn/song/mybatisplus/sqlvis/agent/AgentMain.class",
                "cn/song/mybatisplus/sqlvis/agent/DriverRegistry.class",
                "cn/song/mybatisplus/sqlvis/agent/StatementWeaver.class",
                "cn/song/mybatisplus/sqlvis/agent/asm/Opcodes.class",
                "cn/song/mybatisplus/sqlvis/agent/asm/ClassReader.class",
                "cn/song/mybatisplus/sqlvis/agent/asm/ClassWriter.class",
                "cn/song/mybatisplus/sqlvis/agent/asm/tree/ClassNode.class",
        };
        for (String name : required) {
            r.check("jar-entry:" + name, entries.containsKey(name), entries.containsKey(name) ? "present" : "MISSING");
        }
        r.note("jar-entries-total", String.valueOf(entries.size()));

        // A 面：未重定位的 org/objectweb/asm 是否也被打进来了（若是，说明 jar 里同时存在两套 ASM 命名）
        int oldAsmEntries = 0;
        for (String name : entries.keySet()) {
            if (name.startsWith(ASM_OLD) && name.endsWith(".class")) {
                oldAsmEntries++;
            }
        }
        r.note("jar-entries-original-asm-prefix", String.valueOf(oldAsmEntries));

        // ---- 2)+3) StatementWeaver 的引用面 ----
        byte[] swBytes = entries.get("cn/song/mybatisplus/sqlvis/agent/StatementWeaver.class");
        ClassFileModel sw = ClassFileModel.parse(swBytes);

        List<String> ifaces = sw.interfaceNames();
        r.note("StatementWeaver.interfaces", ifaces.toString());
        r.check("StatementWeaver.implements-exactly-relocated-Opcodes",
                ifaces.size() == 1 && (ASM_NEW + "Opcodes").equals(ifaces.get(0)),
                "interfaces=" + ifaces);
        r.check("StatementWeaver.super-is-Object",
                "java/lang/Object".equals(sw.className(sw.superClass)),
                "super=" + sw.className(sw.superClass));

        // 活引用：真正会在运行期解析的 asm 类
        List<String> liveNewAsm = sorted(sw.liveClassRefs(ASM_NEW));
        r.note("StatementWeaver.live-asm-classRefs", liveNewAsm.toString());
        r.check("live-refs.contain-Opcodes", liveNewAsm.contains(ASM_NEW + "Opcodes"), "见上");
        for (String needed : new String[]{"ClassReader", "ClassWriter", "tree/ClassNode", "tree/MethodNode"}) {
            r.check("live-refs.contain-" + needed, liveNewAsm.contains(ASM_NEW + needed), "");
        }

        // 死条目：来自 ClassWriter 拷贝常量池的残留，永不解析
        List<String> deadOld = sorted(sw.deadClassEntries(ASM_OLD));
        r.note("StatementWeaver.dead-original-asm-entries", deadOld.toString());
        r.check("dead-entries.are-Not-the-cause",
                !deadOld.isEmpty(),
                "存在 " + deadOld.size() + " 个未重定位死条目（证明字节串搜索会产生假阳性）");

        // 成员引用：Opcodes.LONG/DOUBLE/TOP 是否为「非 final 静态字段」（不可被 javac 内联）
        List<String> opMemberRefs = sorted(sw.liveMemberRefsOwnedBy(ASM_NEW + "Opcodes"));
        r.note("StatementWeaver.live-memberRefs-on-Opcodes", opMemberRefs.toString());
        boolean nonInlinableFieldRefs = false;
        for (String ref : opMemberRefs) {
            // 形如 owner.NAME:Ljava/lang/Integer;
            if (ref.endsWith(":Ljava/lang/Integer;")) {
                nonInlinableFieldRefs = true;
            }
        }
        r.check("Opcodes-has-non-inlinable-field-refs", nonInlinableFieldRefs,
                nonInlinableFieldRefs
                        ? "存在 getstatic Opcodes.X:Ljava/lang/Integer; —— 删 implements 只能推后失败时点，不能消除依赖"
                        : "无字段引用：删 implements 即可完全消除该类对 Opcodes 的解析要求");

        // 哪个方法持有这些字段引用（供 README 说明「后移到哪一步」）
        List<String> holders = new ArrayList<String>();
        for (String member : opMemberRefs) {
            String memberName = member.substring(member.indexOf('.') + 1, member.indexOf(':'));
            for (String m : sw.methodsTouchingMember(ASM_NEW + "Opcodes", memberName)) {
                if (!holders.contains(m)) {
                    holders.add(m);
                }
            }
        }
        r.note("Opcodes-memberref-holders(methods)", holders.toString());

        // 关键判据：specOf 这一跳本身是否需要 Opcodes
        boolean specOfTouchesOpcodes = false;
        boolean weaveEntryTouchesOpcodes = false;
        for (String m : sw.methodsTouching(ASM_NEW + "Opcodes")) {
            if (m.startsWith("specOf")) {
                specOfTouchesOpcodes = true;
            }
            if (m.startsWith("weave(") || m.startsWith("weaveSpec")) {
                weaveEntryTouchesOpcodes = true;
            }
        }
        r.check("specOf-does-not-touch-Opcodes", !specOfTouchesOpcodes,
                "specOf 只查 Map —— 删 implements 后 specOf 这一跳不再需要 Opcodes");
        r.note("weave-entry-touches-Opcodes", String.valueOf(weaveEntryTouchesOpcodes));

        // 顺带确认 ConnectWeaver 同形（第二条同源失败面）
        byte[] cwBytes = entries.get("cn/song/mybatisplus/sqlvis/agent/ConnectWeaver.class");
        if (cwBytes != null) {
            ClassFileModel cw = ClassFileModel.parse(cwBytes);
            r.note("ConnectWeaver.interfaces", cw.interfaceNames().toString());
        }
        return r;
    }

    private Map<String, byte[]> readAll() throws Exception {
        final Map<String, byte[]> out = new LinkedHashMap<String, byte[]>();
        try (JarFile jf = new JarFile(jar)) {
            List<String> names = new ArrayList<String>();
            for (JarEntry e : Collections.list(jf.entries())) {
                if (!e.isDirectory()) {
                    names.add(e.getName());
                }
            }
            Collections.sort(names);
            for (String n : names) {
                try (InputStream in = jf.getInputStream(jf.getEntry(n))) {
                    out.put(n, readAll(in));
                }
            }
        }
        return out;
    }

    private static byte[] readAll(InputStream in) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int n;
        while ((n = in.read(buf)) > 0) {
            bos.write(buf, 0, n);
        }
        return bos.toByteArray();
    }

    private static List<String> sorted(List<String> in) {
        List<String> out = new ArrayList<String>(in);
        Collections.sort(out);
        return out;
    }

    /** 结果容器：check 累积失败，note 只记录读数。 */
    public static final class Report {
        public final List<String> lines = new ArrayList<String>();
        public final List<String> failures = new ArrayList<String>();
        public final Map<String, String> notes = new LinkedHashMap<String, String>();

        void check(String name, boolean ok, String detail) {
            lines.add((ok ? "[PASS] " : "[FAIL] ") + name + (detail.isEmpty() ? "" : "  -> " + detail));
            if (!ok) {
                failures.add(name);
            }
        }

        void note(String name, String value) {
            notes.put(name, value);
            lines.add("[NOTE] " + name + " = " + value);
        }
    }
}

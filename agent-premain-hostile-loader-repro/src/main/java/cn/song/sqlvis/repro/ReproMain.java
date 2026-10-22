package cn.song.sqlvis.repro;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * 复现入口。一次只跑一个「格」，由 run.ps1 串起来（每格独立 JVM，避免静态状态互相污染）。
 *
 * <p>用法：{@code java -cp <classes> cn.song.sqlvis.repro.ReproMain <cell> <agentJar>}
 * <ul>
 *   <li>{@code recon0} —— 静态取证，不加载 agent</li>
 *   <li>{@code reproA} —— hostile loader + 反射 premain（核心），内含 hideAsm=false 正对照</li>
 *   <li>{@code reproC} —— 守卫形态：premain 不得外抛（当前预期 FAIL）</li>
 * </ul>
 */
public final class ReproMain {

    private static final String AGENT_MAIN = "cn.song.mybatisplus.sqlvis.agent.AgentMain";
    private static final String DRIVER_REGISTRY = "cn.song.mybatisplus.sqlvis.agent.DriverRegistry";
    private static final String ACTIVE_MARKER = "sqlvis.agent.active";

    private static int failures = 0;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("usage: ReproMain <recon0|reproA|hypothesis|linkage|reproC> [agentJar]");
            System.exit(2);
        }
        final String cell = args[0];
        final File jar = args.length > 1 ? new File(args[1]) : null;
        if (!"linkage".equals(cell)) {
            if (jar == null) {
                System.err.println("[FATAL] missing agentJar argument for cell " + cell);
                System.exit(2);
            }
            if (!jar.isFile()) {
                System.err.println("[FATAL] agent jar not found: " + jar.getAbsolutePath());
                System.exit(2);
            }
        }
        header(cell, jar);

        switch (cell) {
            case "recon0" -> recon0(jar);
            case "reproA" -> reproA(jar);
            case "hypothesis" -> hypothesis(jar);
            case "linkage" -> linkage();
            case "reproC" -> reproC(jar);
            default -> {
                System.err.println("[FATAL] unknown cell: " + cell);
                System.exit(2);
            }
        }

        System.out.println();
        if (failures == 0) {
            System.out.println("RESULT[" + cell + "] = PASS");
        } else {
            System.out.println("RESULT[" + cell + "] = FAIL  failedChecks=" + failures);
        }
        // reproC 的失败是「当前行为的预期读数」，不算本格退出码失败；由调用方按 RESULT 行判读。
        System.exit(failures == 0 ? 0 : 1);
    }

    // ------------------------------------------------------------------ Recon 0

    private static void recon0(File jar) throws Exception {
        AgentJarProbe.Report r = new AgentJarProbe(jar).run();
        for (String line : r.lines) {
            System.out.println(line);
        }
        failures += r.failures.size();
    }

    // ------------------------------------------------------------------ Repro A

    private static void reproA(File jar) throws Exception {
        System.out.println("\n--- A1: hideAsm=false（正对照：asm 可见时 premain 应正常返回） ---");
        FakeInstrumentation controlInst = FakeInstrumentation.withStatementStub();
        boolean controlOk = runPremain(jar, false, controlInst);
        check("A1.control-premain-returns-normally", controlOk, "asm 可见 → 无 NCDFE，证明失败由 asm 不可见引起");
        check("A1.control-reached-retransform-loop(matched>=1)",
                controlInst.retransformCalls() >= 1,
                "retransformCalls=" + controlInst.retransformCalls()
                        + "（0 表示循环没走到谓词，读数无效——正是假绿坑）");

        System.out.println("\n--- A2: hideAsm=true（现场形态：asm 不可见） ---");
        // 现场顺序：先成功加载 DriverRegistry（静态块），再在 retransform 循环里触发 StatementWeaver。
        clearActiveMarker();
        FakeInstrumentation hostileInst = FakeInstrumentation.withStatementStub();
        Throwable thrown = runPremainCapturing(jar, true, hostileInst);
        // T-JRebelPremainCrash 修复后预期：premain **不得外抛**。
        //  - B 案把名单查询移出 implements Opcodes 的 StatementWeaver ⇒ 谓词路径不再需要 ASM；
        //  - A 案再兜住任何残余 Throwable ⇒ 即便真失败也只降级。
        // 修复前基线（2026-10-22 现场）：此处抛 NoClassDefFoundError ...asm/Opcodes，
        // 栈顶 DriverRegistry.isStatementWeavable:61，最终 JVM 报 processJavaStart failed。
        check("A2.premain-must-not-throw(fixed)",
                thrown == null,
                thrown == null ? "premain 正常返回（修复生效）"
                        : "仍外抛 " + thrown + " —— 修复被破坏或前提已变");

        if (thrown != null) {
            // 修复被破坏时，尽量把现场信息打出来（便于归因），但本格已判红
            Throwable cause = thrown instanceof InvocationTargetException
                    ? ((InvocationTargetException) thrown).getTargetException()
                    : thrown;
            System.out.println("[NOTE] target exception = " + cause.getClass().getName() + ": " + cause.getMessage());
            for (String f : agentFrames(cause)) {
                System.out.println("        at " + f);
            }
            return;
        }
        // 修复后必须留下「名单仍然工作」的正证据：循环走到了谓词（matched>=1）
        check("A2.retransform-loop-still-reached-under-hostile-loader",
                hostileInst.retransformCalls() >= 1,
                "retransformCalls=" + hostileInst.retransformCalls()
                        + "（>=1 证明谓词在 ASM 不可见时仍能正常判定）");
        // （修复前的 A2 断言链已移除：它们在修复后已不可达；历史基线见本方法上方注释）
        System.out.println("[NOTE] denied class loads are printed by the loader above (DENY lines)");
    }

    // ------------------------------------------------------------------ Hypothesis

    /**
     * 实测证伪「删掉 implements Opcodes 就能把失败点后移到 weave()」。
     *
     * <p>做法：不动主仓源码，只在复现目录里造一份 {@code StatementWeaver.interfaces=0} 的 jar 副本，
     * 用它跑同一个 premain 场景，再单独调 weave()。三格读数构成完整链条：
     * <ol>
     *   <li>原 jar + asm 不可见 → premain 抛 NCDFE（复现现场）；</li>
     *   <li>删接口 jar + asm 不可见 → premain **正常返回**（说明 implements 确实是这一跳的唯一解析点）；</li>
     *   <li>但 weave() 一被调用就 NCDFE（说明删接口只是把失败推后，没有消除依赖）。</li>
     * </ol>
     * 结论不是「删接口没用」，而是「删接口把崩溃面换成静默降级面」——这比崩溃更隐蔽，不是等效修复。
     */
    private static void hypothesis(File jar) throws Exception {
        final String entry = "cn/song/mybatisplus/sqlvis/agent/StatementWeaver.class";
        // 输出必须落在复现工程自己的 build 目录：主仓 build/dist 只读引用，不得写入。
        final File outDir = new File("build/tmp/hypothesis");
        final File stripped = new File(outDir, "mps-sql-agent-stripped-interfaces.jar");
        File made = InterfaceStripper.strip(jar, entry, stripped);
        check("H0.strip-succeeded", made != null, made == null ? "无接口可删" : made.getAbsolutePath());
        if (made == null) {
            return;
        }
        ClassFileModel strippedModel = ClassFileModel.parse(
                HostileLoader.readJar(made).get(entry));
        check("H0.stripped-interfaces-count-is-zero",
                strippedModel.interfaces.length == 0,
                "interfaces=" + strippedModel.interfaceNames());
        check("H0.stripped-still-references-Opcodes-fields",
                !strippedModel.liveMemberRefsOwnedBy("cn/song/mybatisplus/sqlvis/agent/asm/Opcodes").isEmpty(),
                strippedModel.liveMemberRefsOwnedBy("cn/song/mybatisplus/sqlvis/agent/asm/Opcodes").toString());

        System.out.println("\n--- H1: 删接口 jar + asm 不可见 → premain 是否还抛 ---");
        Throwable t = runPremainCapturing(made, true);
        // 断言的是「实测结论」，不是「主控假设」：假设说删接口能把失败点后移到 weave()，
        // 实测是**仍在原位、只是换了被拒的 ASM 类名**。若哪天实测变成「正常返回」，本格会红，
        // 提示结论需要重写。
        // T-JRebelPremainCrash 修复后预期：删接口 jar 在 asm 不可见时**同样正常返回**
        //（B 案下 premain 的谓词路径已不需要 ASM；A 案再兜住残余异常）。
        // 修复前基线：仍在 isStatementWeavable:61 抛，只是被拒的 ASM 类名从 Opcodes 换成别的。
        // 「H0.stripped-still-references-Opcodes-fields」仍是有效证据：删接口无法消除该字段依赖，
        // 所以 B 案采用的是「名单外移到 WeaveSpecs」而非「删 implements」。
        check("H1.premain-must-not-throw-after-strip(fixed)",
                t == null,
                t == null ? "premain 正常返回（修复生效；删接口仍无法消除 Opcodes 字段依赖 → 故 B 案用名单外移）"
                        : "仍抛 " + describeRoot(t) + " —— 修复被破坏");
        if (t != null) {
            Throwable target = t instanceof InvocationTargetException
                    ? ((InvocationTargetException) t).getTargetException()
                    : t;
            System.out.println("[NOTE] H1 顶层异常 = " + target.getClass().getName() + ": " + target.getMessage());
            Throwable c = target.getCause();
            int depth = 0;
            while (c != null && c != target && depth++ < 5) {
                System.out.println("[NOTE] H1 cause[" + depth + "] = " + c.getClass().getName() + ": " + c.getMessage());
                c = c.getCause();
            }
            List<String> frames = agentFrames(target);
            System.out.println("[NOTE] H1 agent stack frames:");
            for (String f : frames) {
                System.out.println("        " + f);
            }
            boolean sameCallSite = !frames.isEmpty() && frames.get(0).contains("DriverRegistry.isStatementWeavable");
            check("H1.failure-stays-in-premain-at-same-call-site", sameCallSite,
                    sameCallSite
                            ? "失败点仍是 isStatementWeavable —— 只是换了被拒的 ASM 类名"
                            : "失败点已移走：" + (frames.isEmpty() ? "<无 agent 帧>" : frames.get(0)));
        }

        System.out.println("\n--- H2: 再显式调用 weave() → 真正的 ASM 需求面 ---");
        Throwable weaveFailure = invokeWeave(made);
        System.out.println("[NOTE] weave() failure = "
                + (weaveFailure == null ? "<none>" : describeRoot(weaveFailure)));
        // 注意：这里拿到的通常是 AbstractInsnNode/ClassNode 而非 Opcodes —— 因为类链接在第一处
        // 不可见的 ASM 类型就已失败，Opcodes 不再是「第一个」坏引用。所以只断言「asm 前缀」。
        check("H2.weave-also-fails-on-asm", isAsmLinkageFailure(weaveFailure),
                weaveFailure == null ? "weave 未失败（说明 ASM 其实可见）" : describeRoot(weaveFailure));
        if (weaveFailure != null) {
            String m = String.valueOf(weaveFailure.getMessage()).replace('/', '.');
            check("H2.weave-failure-names-asm-class",
                    m.contains("cn.song.mybatisplus.sqlvis.agent.asm."), m);
        }
    }

    /** NCDFE 或 CNFE，且 message 指向重定位后的 asm 包。 */
    private static boolean isAsmLinkageFailure(Throwable t) {
        if (t == null) {
            return false;
        }
        boolean linkage = t instanceof NoClassDefFoundError || t instanceof ClassNotFoundException;
        if (!linkage) {
            return false;
        }
        String m = String.valueOf(t.getMessage()).replace('/', '.');
        return m.contains("cn.song.mybatisplus.sqlvis.agent.asm.");
    }

    /** 在同一 hostile loader 下反射调 StatementWeaver.weave(null, name, bytes)，捕获 Throwable。 */
    private static Throwable invokeWeave(File jar) throws Exception {
        final HostileLoader loader = HostileLoader.of(jar, true, ClassLoader.getPlatformClassLoader());
        final byte[] probe = HostileLoader.readJar(jar)
                .get("cn/song/mybatisplus/sqlvis/agent/DriverRegistry.class");
        try {
            // 注意：getMethod 本身就会解析方法签名里的类型（这里会先撞上 AbstractInsnNode），
            // 所以「反射查找」也在 try 内——否则复现进程会直接被 NCDFE 打死。
            final Class<?> sw = loader.loadClass("cn.song.mybatisplus.sqlvis.agent.StatementWeaver");
            final Method weave = sw.getMethod("weave", ClassLoader.class, String.class, byte[].class);
            weave.invoke(null, null, "com.mysql.cj.jdbc.StatementImpl", probe);
            return null;
        } catch (Throwable t) {
            return t instanceof InvocationTargetException
                    ? ((InvocationTargetException) t).getTargetException()
                    : t;
        }
    }

    // ------------------------------------------------------------------ Linkage

    private static void linkage() {
        LinkageProbe.run();
    }

    // ------------------------------------------------------------------ Repro C

    /**
     * 守卫形态（供后续立项）：premain 在任何 Throwable 下都不得向外抛，且应在 stderr 留一行降级说明。
     *
     * <p>本格分两半，避免「断言 premain 正常返回」在装置无效时天然成立（无鉴别力）：
     * <ul>
     *   <li><b>C-before</b>（现状，预期红）：同一装置下必须抛 NCDFE 且消息含 {@code asm/Opcodes}，
     *       并且 {@code matched>=1} 证明循环真的走到了谓词。这三条一起成立才说明装置有鉴别力。</li>
     *   <li><b>C-after</b>（修复后，预期绿）：{@code premain} 正常返回 + stderr 有降级说明。
     *       现状下这条断言为红（KNOWN-FAIL）。</li>
     * </ul>
     * 修复落地后，把本方法的 {@code assertBeforeFix} 改成 false（或直接删掉 C-before 分支），
     * C-after 就会成为唯一的判据。反向验证：把修复摘掉必须让 C-after 变红。
     */
    private static void reproC(File jar) throws Exception {
        // T-JRebelPremainCrash 修复已落地（2026-10-22）：翻转为 false —— C-after 成为唯一判据。
        // 反向验证：把 A 案的 install 兜底摘掉，C-after 必须变红（实测过：摘掉 → 2 项红）。
        final boolean assertBeforeFix = false;

        clearActiveMarker();
        FakeInstrumentation inst = FakeInstrumentation.withStatementStub();
        Throwable thrown = runPremainCapturing(jar, true, inst);

        System.out.println("\n--- C-before: 装置鉴别力（必须先证明循环走到了谓词） ---");
        // 判据说明：在 asm 不可见时，失败发生在**谓词内部**，retransformClasses 根本还没被调用，
        // 所以「retransformCalls>=1」在这条路径上必然为 0，不能用作有效性证明。
        // 正确的证据是：异常的最内层 agent 帧就是 isStatementWeavable —— 它只能由
        // retransformLoadedDrivers 的 for 循环 + 三连谓词产生，证明循环确实进入了。
        List<String> frames = new ArrayList<String>();
        Throwable target = thrown instanceof InvocationTargetException
                ? ((InvocationTargetException) thrown).getTargetException()
                : thrown;
        if (thrown != null) {
            frames = agentFrames(target);
        }
        // 装置鉴别力：修复后 premain 不再抛，故不能再用「栈帧落在谓词」当证据；
        // 改用 FakeInstrumentation 的 retransformCalls —— 它只有在循环内三连谓词判定为
        // weavable 之后才会被调用，>=1 即证明循环确实进入了并走完了谓词。
        boolean reachedPredicate = inst.retransformCalls() >= 1;
        check("C.装置有效: retransform 循环已进入谓词（retransformCalls>=1）",
                reachedPredicate,
                "retransformCalls=" + inst.retransformCalls()
                        + "；getAllLoadedClasses=" + inst.getAllLoadedClasses().length + " 个"
                        + (frames.isEmpty() ? "" : "；innermost=" + frames.get(0)));
        check("C.装置有效: getAllLoadedClasses 含登记表桩类",
                containsClass(inst.getAllLoadedClasses(), "com.mysql.cj.jdbc.StatementImpl"),
                "否则循环 matched=0，任何「不抛」都是假绿");

        if (assertBeforeFix) {
            check("C-before.premain-目前外抛", thrown != null,
                    thrown == null ? "未抛 —— 装置或前提已变" : describeRoot(thrown));
            check("C-before.异常是-NoClassDefFoundError",
                    target instanceof NoClassDefFoundError,
                    target == null ? "<none>" : target.getClass().getName());
            String m = target == null ? "" : String.valueOf(target.getMessage()).replace('/', '.');
            check("C-before.消息含-asm.Opcodes",
                    m.contains("cn.song.mybatisplus.sqlvis.agent.asm.Opcodes"), m);
        }

        System.out.println("\n--- C-after: 修复后判据（premain 不得外抛 + 有降级说明） ---");
        check("[C-after] premain-must-not-throw", thrown == null,
                thrown == null ? "premain 未外抛" : "现状外抛 " + describeRoot(thrown)
                        + " → 修复后此处应变绿");
        if (thrown != null) {
            check("[C-after] stderr-should-have-degradation-notice", false,
                    "抛异常时根本走不到降级路径，stderr 无降级说明 → 修复后此处应变绿");
        }
    }

    // ------------------------------------------------------------------ helpers

    /** 在当前线程触发一次 premain。返回是否正常返回（不抛）。 */
    private static boolean runPremain(File jar, boolean hideAsm, FakeInstrumentation inst) throws Exception {
        return runPremainCapturing(jar, hideAsm, inst) == null;
    }

    /** 用全新 hostile loader 载入 AgentMain 并调 premain；返回抛出的 Throwable（正常返回为 null）。 */
    private static Throwable runPremainCapturing(File jar, boolean hideAsm) throws Exception {
        return runPremainCapturing(jar, hideAsm, FakeInstrumentation.withStatementStub());
    }

    /**
     * @param inst 必须能给出「命中登记表」的已加载类；否则 retransform 循环 matched=0，
     *             三连谓词不被调用，会得到假绿（详见 FakeInstrumentation 与 README）。
     */
    private static Throwable runPremainCapturing(File jar, boolean hideAsm, FakeInstrumentation inst)
            throws Exception {
        clearActiveMarker();
        // parent 用 platform loader：模拟第三方加载器「只认 JDK 与自己可见的模块」
        final ClassLoader platform = ClassLoader.getPlatformClassLoader();
        final HostileLoader loader = HostileLoader.of(jar, hideAsm, platform);
        System.out.println("[NOTE] hostile loader created (hideAsm=" + hideAsm + ", parent="
                + platform.getClass().getName() + ")");
        System.out.println("[NOTE] instrumentation.getAllLoadedClasses() = "
                + java.util.Arrays.toString(classNameArray(inst.getAllLoadedClasses())));

        final Class<?> agentMain = loader.loadClass(AGENT_MAIN);
        System.out.println("[NOTE] loaded " + agentMain.getName() + " via " + agentMain.getClassLoader());

        final Method premain = agentMain.getMethod("premain", String.class,
                java.lang.instrument.Instrumentation.class);
        final String argPort = "port=" + freePort();
        System.out.println("[NOTE] premain args = " + argPort);

        try {
            premain.invoke(null, argPort, inst);
            System.out.println("[NOTE] premain returned normally");
            return null;
        } catch (Throwable t) {
            return t;
        }
    }

    private static String[] classNameArray(Class<?>[] classes) {
        String[] out = new String[classes.length];
        for (int i = 0; i < classes.length; i++) {
            out[i] = classes[i].getName();
        }
        return out;
    }

    private static void clearActiveMarker() {
        System.clearProperty(ACTIVE_MARKER);
    }

    private static int freePort() throws IOException {
        try (ServerSocket s = new ServerSocket(0)) {
            s.setReuseAddress(true);
            return s.getLocalPort();
        }
    }

    private static List<String> agentFrames(Throwable t) {
        List<String> out = new ArrayList<String>();
        for (StackTraceElement e : t.getStackTrace()) {
            String s = e.getClassName() + "." + e.getMethodName()
                    + (e.getFileName() != null ? "(" + e.getFileName() + ":" + e.getLineNumber() + ")" : "");
            if (e.getClassName().startsWith("cn.song.mybatisplus.sqlvis.agent.")) {
                out.add(s);
            }
        }
        return out;
    }

    private static String describeRoot(Throwable t) {
        Throwable cur = t;
        while (cur.getCause() != null && cur.getCause() != cur) {
            cur = cur.getCause();
        }
        return cur.getClass().getName() + ": " + cur.getMessage();
    }

    private static void check(String name, boolean ok, String detail) {
        System.out.println((ok ? "[PASS] " : "[FAIL] ") + name + (detail == null || detail.isEmpty() ? "" : "  -> " + detail));
        if (!ok) {
            failures++;
        }
    }

    static void bumpFailure() {
        failures++;
    }

    private static boolean containsClass(Class<?>[] classes, String name) {
        for (Class<?> c : classes) {
            if (name.equals(c.getName())) {
                return true;
            }
        }
        return false;
    }

    private static void header(String cell, File jar) {
        System.out.println("================================================================");
        System.out.println("cell    : " + cell);
        System.out.println("agentJar: " + (jar == null ? "<not required>" : jar.getAbsolutePath() + "  (" + jar.length() + " bytes)"));
        System.out.println("java    : " + System.getProperty("java.version")
                + " @ " + System.getProperty("java.home"));
        System.out.println("================================================================");
    }

    private ReproMain() {
    }
}

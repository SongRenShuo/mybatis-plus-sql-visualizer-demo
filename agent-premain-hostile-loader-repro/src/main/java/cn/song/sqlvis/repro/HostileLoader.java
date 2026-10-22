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
 * 「第三方类加载器」替身：只看得见 agent 自身的类，看不见重定位后的 asm 包。
 *
 * <p>现场形态（JRebel 2026.3.0）：它的 reorder/模块加载器把 {@code -javaagent} 交给它的类按自己的
 * 可见性图加载，{@code cn.song.mybatisplus.sqlvis.agent.asm.*} 不在它的图里 → 加载
 * {@code StatementWeaver} 时解析 {@code implements Opcodes} 失败。JRebel 把该失败包成自己的
 * {@code com.zeroturnaround.javarebel.yo} 类型再抛出，所以现场栈顶显示的是 {@code yo} 而不是
 * {@code NoClassDefFoundError}——本质仍是 NCDFE。
 *
 * <p>本类刻意做成 child-first：agent 前缀的类一律从 jar 自己读，其余交父加载器。这样
 * 「asm 不可见」是本加载器自己的策略，而不是靠父加载器碰巧也没这个包。
 */
public final class HostileLoader extends ClassLoader {

    public static final String AGENT_PREFIX = "cn.song.mybatisplus.sqlvis.agent.";
    public static final String ASM_PREFIX = AGENT_PREFIX + "asm.";

    private final Map<String, byte[]> jarEntries;
    private final boolean hideAsm;
    private final List<String> denied = new ArrayList<String>();
    private final List<String> servedFromJar = new ArrayList<String>();

    private HostileLoader(ClassLoader parent, Map<String, byte[]> jarEntries, boolean hideAsm) {
        super(parent);
        this.jarEntries = jarEntries;
        this.hideAsm = hideAsm;
    }

    /**
     * @param jar     agent fat jar
     * @param hideAsm true = 现场形态（asm 包不可见）；false = 正对照（asm 可见）
     * @param parent  父加载器；现场用 platform loader（模拟「只认 JDK + agent 自身」的第三方加载器）
     */
    public static HostileLoader of(File jar, boolean hideAsm, ClassLoader parent) throws Exception {
        return new HostileLoader(parent, readJar(jar), hideAsm);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                if (name.startsWith(AGENT_PREFIX)) {
                    if (hideAsm && name.startsWith(ASM_PREFIX)) {
                        denied.add(name);
                        System.err.println("[HostileLoader] DENY " + name);
                        throw new ClassNotFoundException(name);
                    }
                    c = loadFromJar(name);
                }
                if (c == null) {
                    c = super.loadClass(name, false);
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    private Class<?> loadFromJar(String dottedName) {
        byte[] bytes = jarEntries.get(dottedName.replace('.', '/') + ".class");
        if (bytes == null) {
            return null;
        }
        servedFromJar.add(dottedName);
        return defineClass(dottedName, bytes, 0, bytes.length);
    }

    public List<String> deniedClasses() {
        return new ArrayList<String>(denied);
    }

    public List<String> servedFromJar() {
        return new ArrayList<String>(servedFromJar);
    }

    public static Map<String, byte[]> readJar(File jar) throws Exception {
        Map<String, byte[]> out = new LinkedHashMap<String, byte[]>();
        try (JarFile jf = new JarFile(jar)) {
            List<String> names = new ArrayList<String>();
            for (JarEntry e : Collections.list(jf.entries())) {
                if (!e.isDirectory() && e.getName().endsWith(".class")) {
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
}

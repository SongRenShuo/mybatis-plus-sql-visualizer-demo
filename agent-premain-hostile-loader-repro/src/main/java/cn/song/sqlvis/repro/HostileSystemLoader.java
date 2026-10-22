package cn.song.sqlvis.repro;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 「第三方加载器」的系统态替身：通过 {@code -Djava.system.class.loader=...} 成为 JVM 的 system
 * class loader，**自己** define agent 的类，并对 {@code cn.song.mybatisplus.sqlvis.agent.asm.*}
 * 抛出 {@link ClassNotFoundException}。
 *
 * <p>与 {@link HostileLoader} 的区别：那个是「进程内手动加载 + 反射调 premain」；这个是**真 JVM 启动
 * 时由 JVM 自己调 premain**，因此能复现现场最后一行：
 * {@code FATAL ERROR in native method: processing of -javaagent failed}。
 *
 * <p>两点 JDK 硬约束：
 * <ul>
 *   <li>JVM 只认 {@code (ClassLoader)} 构造器；</li>
 *   <li>JVM 会用 {@code appendToClassPathForInstrumentation(String)} 把 -javaagent 的 jar 塞进
 *       system class path，缺这个方法就直接
 *       {@code FATAL ERROR ... appending to system class path failed}（先踩过一次，记在此处）。</li>
 * </ul>
 * 本类实现该方法后**不用**父加载器搜索，而是自己按路径读字节 define——这样可见性完全由本类控制。
 *
 * <p>开关 {@code -Drepro.hideAsm=false} 可关掉拒绝逻辑（作正对照）。
 */
public final class HostileSystemLoader extends ClassLoader {

    private static final String AGENT_PREFIX = "cn.song.mybatisplus.sqlvis.agent.";
    private static final String ASM_PREFIX = AGENT_PREFIX + "asm.";

    /** 搜索根：-javaagent 的 jar + 常规 classpath（JVM 对自定义 system loader 不走内置 AppClassLoader）。 */
    private static final List<File> ROOTS = Collections.synchronizedList(new ArrayList<File>());
    private static final Map<File, Map<String, byte[]>> JAR_CACHE =
            Collections.synchronizedMap(new LinkedHashMap<File, Map<String, byte[]>>());

    /** JVM 只认这个构造器签名。 */
    public HostileSystemLoader(ClassLoader parent) {
        super(parent);
    }

    /**
     * 方法名与签名由 JDK 硬编码，JVM 反射调用；{@code (String)V} 不可改。
     */
    @SuppressWarnings("unused")
    public void appendToClassPathForInstrumentation(String path) {
        addRoot(new File(path));
        System.err.println("[HostileSystemLoader] search root added: " + path);
    }

    private static void addRoot(File f) {
        synchronized (ROOTS) {
            if (!ROOTS.contains(f)) {
                ROOTS.add(f);
            }
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                if (name.startsWith(ASM_PREFIX) && hideAsm()) {
                    System.err.println("[HostileSystemLoader] DENY " + name);
                    throw new ClassNotFoundException(name);
                }
                if (name.startsWith(AGENT_PREFIX)) {
                    c = defineFromRoots(name);
                }
                if (c == null) {
                    try {
                        c = super.loadClass(name, false);
                    } catch (ClassNotFoundException ignored) {
                        // 自定义 system loader 拿不到内置 AppClassLoader 的 classpath，自己兜底
                    }
                }
                if (c == null) {
                    c = defineFromRoots(name);
                }
                if (c == null) {
                    throw new ClassNotFoundException(name);
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    private static boolean hideAsm() {
        return !"false".equalsIgnoreCase(System.getProperty("repro.hideAsm", "true"));
    }

    private Class<?> defineFromRoots(String dottedName) {
        byte[] bytes = findClassBytes(dottedName);
        if (bytes == null) {
            return null;
        }
        return defineClass(dottedName, bytes, 0, bytes.length);
    }

    private static byte[] findClassBytes(String dottedName) {
        final String entry = dottedName.replace('.', '/') + ".class";
        bootstrapRootsFromClassPath();
        synchronized (ROOTS) {
            for (File root : ROOTS) {
                if (root.isDirectory()) {
                    File f = new File(root, entry);
                    if (f.isFile()) {
                        try (InputStream in = new FileInputStream(f)) {
                            return readAll(in);
                        } catch (Exception ignored) {
                            // 继续找下一个根
                        }
                    }
                } else if (root.isFile()) {
                    Map<String, byte[]> entries = JAR_CACHE.get(root);
                    if (entries == null) {
                        entries = readJar(root);
                        JAR_CACHE.put(root, entries);
                    }
                    byte[] b = entries.get(entry);
                    if (b != null) {
                        return b;
                    }
                }
            }
        }
        return null;
    }

    private static volatile boolean classPathBootstrapped;

    private static void bootstrapRootsFromClassPath() {
        if (classPathBootstrapped) {
            return;
        }
        classPathBootstrapped = true;
        String cp = System.getProperty("java.class.path", "");
        for (String part : cp.split(File.pathSeparator)) {
            if (!part.isEmpty()) {
                addRoot(new File(part));
            }
        }
    }

    private static Map<String, byte[]> readJar(File jar) {
        Map<String, byte[]> out = new LinkedHashMap<String, byte[]>();
        try (JarFile jf = new JarFile(jar)) {
            for (JarEntry e : Collections.list(jf.entries())) {
                if (e.isDirectory() || !e.getName().endsWith(".class")) {
                    continue;
                }
                try (InputStream in = jf.getInputStream(e)) {
                    out.put(e.getName(), readAll(in));
                }
            }
        } catch (Exception e) {
            // 非 jar（比如目录或坏文件）：静默跳过，不阻断启动
            return out;
        }
        return out;
    }

    private static byte[] readAll(InputStream in) throws java.io.IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int n;
        while ((n = in.read(buf)) > 0) {
            bos.write(buf, 0, n);
        }
        return bos.toByteArray();
    }
}

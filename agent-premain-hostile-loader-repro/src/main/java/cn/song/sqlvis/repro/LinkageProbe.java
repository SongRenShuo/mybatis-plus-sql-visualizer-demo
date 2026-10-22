package cn.song.sqlvis.repro;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 机制对照：证明「类链接期」而非「方法执行期」就需要可见性。
 *
 * <p>用一个只看得到 {@link cn.song.sqlvis.repro.fixture.Holder} 的加载器 define Holder，然后只调
 * 与不可见类型无关的 {@code untouched(String)}。若仍抛 NCDFE，则「删掉 implements Opcodes 就能把
 * 失败后移到 weave()」的假设在机制上就不成立——{@code patchFrames} 的方法体里那些
 * {@code Opcodes.LONG/DOUBLE/TOP} 与 {@code FrameNode/AbstractInsnNode} 的局部变量，已经让整个类
 * 的链接依赖 ASM。
 */
public final class LinkageProbe {

    private static final String HOLDER = "cn.song.sqlvis.repro.fixture.Holder";
    private static final String INVISIBLE = "cn.song.sqlvis.repro.fixture.Invisible";

    public static void run() {
        System.out.println("\n--- M1: 链接期可见性（不依赖 agent jar 的最小对照） ---");
        final ClassLoader onlyHolder = new ClassLoader(ClassLoader.getPlatformClassLoader()) {
            @Override
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                if (name.equals(INVISIBLE)) {
                    throw new ClassNotFoundException(name);
                }
                if (name.equals(HOLDER)) {
                    Class<?> c = findLoadedClass(name);
                    if (c == null) {
                        InputStream in = HolderResource.open();
                        byte[] bytes = HolderResource.read(in);
                        c = defineClass(name, bytes, 0, bytes.length);
                    }
                    return c;
                }
                // 其余（String 等）走 platform
                try {
                    return ClassLoader.getPlatformClassLoader().loadClass(name);
                } catch (ClassNotFoundException e) {
                    return ClassLoader.getSystemClassLoader().loadClass(name);
                }
            }
        };

        boolean loaded = true;
        Throwable loadFailure = null;
        Class<?> holder = null;
        try {
            holder = onlyHolder.loadClass(HOLDER);
        } catch (Throwable t) {
            loaded = false;
            loadFailure = t;
        }
        check("M1.holder-loads-without-invisible", loaded,
                loaded ? "defineClass 成功（类型检查延迟到链接期）" : describe(loadFailure));
        if (!loaded) {
            return;
        }

        Throwable untouchedFailure = null;
        try {
            Method m = holder.getMethod("untouched", String.class);
            Object out = m.invoke(null, "x");
            System.out.println("[NOTE] untouched() returned: " + out);
        } catch (Throwable t) {
            untouchedFailure = t instanceof InvocationTargetException
                    ? ((InvocationTargetException) t).getTargetException()
                    : t;
        }
        check("M1.untouched-method-still-fails", untouchedFailure instanceof NoClassDefFoundError,
                untouchedFailure == null
                        ? "未失败——字节码校验在此 JDK 上是惰性的（结论需修正）"
                        : describe(untouchedFailure));
        if (untouchedFailure != null) {
            Throwable root = untouchedFailure;
            while (root.getCause() != null && root.getCause() != root) {
                root = root.getCause();
            }
            System.out.println("[NOTE] M1 root = " + root.getClass().getName() + ": " + root.getMessage());
            System.out.println("[NOTE] M1 结论：只要类里任一处引用不可见类型（含 StackMapTable 帧），"
                    + "整个类的链接就要求它可见——与具体调用哪个方法无关。");
        }
    }

    private static String describe(Throwable t) {
        return t == null ? "<none>" : t.getClass().getName() + ": " + t.getMessage();
    }

    private static void check(String name, boolean ok, String detail) {
        System.out.println((ok ? "[PASS] " : "[FAIL] ") + name + (detail == null || detail.isEmpty() ? "" : "  -> " + detail));
        if (!ok) {
            ReproMain.bumpFailure();
        }
    }

    /** 读 fixture 的 class 资源。 */
    private static final class HolderResource {
        static InputStream open() {
            return LinkageProbe.class.getResourceAsStream("/cn/song/sqlvis/repro/fixture/Holder.class");
        }

        static byte[] read(InputStream in) {
            try (InputStream i = in) {
                java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
                byte[] buf = new byte[8192];
                int n;
                while ((n = i.read(buf)) > 0) {
                    bos.write(buf, 0, n);
                }
                return bos.toByteArray();
            } catch (java.io.IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}

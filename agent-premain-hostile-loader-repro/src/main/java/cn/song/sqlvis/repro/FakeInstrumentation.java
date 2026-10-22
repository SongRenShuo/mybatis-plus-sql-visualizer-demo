package cn.song.sqlvis.repro;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;

/**
 * 手写 {@link Instrumentation}，让 premain 可以在普通 JVM 里被直接调用（不依赖 attach / agent 加载）。
 *
 * <p>行为刻意做成「最宽松」：所有类都报告为可重转换、retransform 空实现成功、已加载类只给两个
 * 与驱动名单无关的类。这样任何失败都只可能来自 agent 自身的类加载，不会来自我们这个替身。
 *
 * <p>注意 {@code getAllLoadedClasses()} 必须非空——空数组会让 retransform 循环一次都不走，
 * 于是「本复现」会因为没跑到断言点而假绿。
 */
public final class FakeInstrumentation implements Instrumentation {

    private final Class<?>[] loadedClasses;
    private int transformerCount;
    private int retransformCalls;

    public FakeInstrumentation(Class<?>... loadedClasses) {
        this.loadedClasses = loadedClasses;
    }

    public int transformerCount() {
        return transformerCount;
    }

    public int retransformCalls() {
        return retransformCalls;
    }

    public Class<?>[] loadedClasses() {
        return loadedClasses.clone();
    }

    @Override
    public void addTransformer(ClassFileTransformer transformer, boolean canRetransform) {
        transformerCount++;
    }

    @Override
    public void addTransformer(ClassFileTransformer transformer) {
        transformerCount++;
    }

    @Override
    public boolean removeTransformer(ClassFileTransformer transformer) {
        return true;
    }

    @Override
    public boolean isRetransformClassesSupported() {
        return true;
    }

    @Override
    public void retransformClasses(Class<?>... classes) throws UnmodifiableClassException {
        retransformCalls += classes.length;
    }

    @Override
    public boolean isRedefineClassesSupported() {
        return true;
    }

    @Override
    public void redefineClasses(java.lang.instrument.ClassDefinition... definitions) {
    }

    @Override
    public boolean isModifiableClass(Class<?> theClass) {
        return true;
    }

    @Override
    public Class<?>[] getAllLoadedClasses() {
        return loadedClasses.clone();
    }

    @Override
    public Class<?>[] getInitiatedClasses(ClassLoader loader) {
        return new Class<?>[0];
    }

    @Override
    public long getObjectSize(Object objectToSize) {
        return 16L;
    }

    @Override
    public void appendToBootstrapClassLoaderSearch(JarFile jarfile) {
    }

    @Override
    public void appendToSystemClassLoaderSearch(JarFile jarfile) {
    }

    @Override
    public boolean isNativeMethodPrefixSupported() {
        return false;
    }

    @Override
    public void setNativeMethodPrefix(ClassFileTransformer transformer, String prefix) {
    }

    @Override
    public void redefineModule(Module module,
                               Set<Module> extraReads,
                               Map<String, Set<Module>> extraExports,
                               Map<String, Set<Module>> extraOpens,
                               Set<Class<?>> extraUses,
                               Map<Class<?>, List<Class<?>>> extraProvides) {
    }

    @Override
    public boolean isModifiableModule(Module module) {
        return true;
    }

    /**
     * 语句面桩：返回一个名字命中 {@code StatementWeaver.SPECS} 的已加载类，
     * 保证 retransform 循环真的走到三连谓词（否则得到的是假绿，见 README「判据有效性前提」）。
     *
     * <p>注意 {@code retransformClasses} 是空实现——本复现只关心「名单判定这一跳是否要求 ASM 可见」，
     * 不关心织入本身。
     */
    public static FakeInstrumentation withStatementStub() {
        return new FakeInstrumentation(com.mysql.cj.jdbc.StatementImpl.class, String.class);
    }

    private FakeInstrumentation() {
        this(new Class<?>[0]);
    }
}

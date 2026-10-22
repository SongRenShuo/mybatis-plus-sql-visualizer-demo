package cn.song.sqlvis.repro.fixture;

/**
 * 机制对照样本：本类有一个方法引用 {@link Invisible}，但另有一个方法**完全不碰它**。
 *
 * <p>实验做两件事：
 * <ol>
 *   <li>用一个「看不见 Invisible」的加载器 define 本类；</li>
 *   <li>只调用 {@link #untouched(String)}——这个方法的字节码、描述符、帧里都没有 Invisible。</li>
 * </ol>
 * 若第 2 步仍然抛 {@code NoClassDefFoundError: Invisible}，就说明**类链接期**的字节码校验
 * 已经要求 StackMapTable 帧里出现的类型可见——不需要任何方法真的去用到它。
 *
 * <p>这正是 agent 现场的形状：{@code DriverRegistry.isStatementWeavable} 只查一个 HashMap，
 * 却因为 {@code StatementWeaver} 这个类整体链接不过而抛 NCDFE。
 */
public final class Holder {

    /** 与 {@link Invisible} 无关的方法：描述符、字节码、栈帧里都没有它。 */
    public static String untouched(String s) {
        return "ok:" + s;
    }

    /** 制造一个 StackMapTable 帧，其 locals 含 {@code Invisible}。 */
    public static String usesInvisible(Invisible v) {
        if (v == null) {
            return "null";
        }
        return v.toString();
    }

    private Holder() {
    }
}

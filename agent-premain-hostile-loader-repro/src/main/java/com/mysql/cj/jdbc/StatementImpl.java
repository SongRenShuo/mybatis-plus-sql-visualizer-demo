package com.mysql.cj.jdbc;

/**
 * 语句面登记表桩：类名必须在 {@code StatementWeaver.SPECS} 里，否则复现装置会假绿。
 *
 * <p>为什么必须有它：
 * {@code AgentMain.retransformLoadedDrivers} 对 {@code inst.getAllLoadedClasses()} 逐个判定
 * {@code isWeavable || isStatementWeavable || isPrepareWeavable}。若桩返回的已加载类一个都不在
 * 登记表里，循环虽然会跑，但 {@code matched=0}——看着「没崩」，其实是没走到目标断言点。
 * 更糟的是 {@code getAllLoadedClasses()} 返回**空数组**时循环一次都不进，连谓词都不调用，
 * {@code premain} 必然正常返回，得到的是彻底的假绿。
 *
 * <p>因此判据有效性前提有两条，缺一不可：
 * <ol>
 *   <li>{@code getAllLoadedClasses()} 非空；</li>
 *   <li>其中至少一个类的名字命中登记表（本类即此用），并断言 {@code matched>=1}。</li>
 * </ol>
 *
 * <p>本类不实现任何 JDBC 接口——复现只需要「名字」，不需要行为；且 {@code retransformClasses}
 * 在替身里是空实现。
 */
public class StatementImpl {

    // 无成员：仅作为类名字面量存在。
}

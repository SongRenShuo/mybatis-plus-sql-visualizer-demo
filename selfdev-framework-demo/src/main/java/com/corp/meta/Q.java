package com.corp.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 自研框架条件工厂（模拟真实项目中的 {@code Q.it(field, op, value)} 书写形态）。
 *
 * <p>业务侧只与 {@link FilterExpression} 打交道，不接触任何 SQL 文本——
 * 这正是自研框架场景下「静态不可见 SQL、只能靠运行期捕获」的成因。
 *
 * @author SongRenShuo
 */
public final class Q {

    private Q() {
    }

    /** 单条件：{@code Q.it("status", Op.EQ, 1)}。 */
    public static FilterExpression it(String field, FilterExpression.Op op, Object value) {
        return FilterExpression.leaf(field, op, value);
    }

    /** IN 条件。 */
    public static FilterExpression in(String field, Collection<?> values) {
        return FilterExpression.inList(field, FilterExpression.Op.IN, toList(values));
    }

    /** NOT IN 条件。 */
    public static FilterExpression notIn(String field, Collection<?> values) {
        return FilterExpression.inList(field, FilterExpression.Op.NOT_IN, toList(values));
    }

    /** BETWEEN 条件。 */
    public static FilterExpression between(String field, Object low, Object high) {
        return FilterExpression.between(field, low, high);
    }

    /** IS NULL 条件。 */
    public static FilterExpression isNull(String field) {
        return FilterExpression.leaf(field, FilterExpression.Op.IS_NULL, null);
    }

    /** IS NOT NULL 条件。 */
    public static FilterExpression isNotNull(String field) {
        return FilterExpression.leaf(field, FilterExpression.Op.IS_NOT_NULL, null);
    }

    /** AND 分组。 */
    public static FilterExpression and(FilterExpression... children) {
        return FilterExpression.group(false, Arrays.asList(children));
    }

    /** OR 分组。 */
    public static FilterExpression or(FilterExpression... children) {
        return FilterExpression.group(true, Arrays.asList(children));
    }

    private static List<Object> toList(Collection<?> values) {
        List<Object> list = new ArrayList<Object>();
        if (values != null) {
            list.addAll(values);
        }
        return list;
    }
}

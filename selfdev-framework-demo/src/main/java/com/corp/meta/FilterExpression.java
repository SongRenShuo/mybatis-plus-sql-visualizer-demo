package com.corp.meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自研框架条件表达式（模拟公司自研数据访问框架的 FilterExpression 条件树）。
 *
 * <p>两种节点形态：
 * <ul>
 *   <li><b>叶子节点</b>：{@code field + op + value}（BETWEEN 另有 secondValue，IN/NOT_IN 用 values）；</li>
 *   <li><b>分组节点</b>：children 列表 + {@link #isOrGroup()} 决定组内以 AND 还是 OR 连接。</li>
 * </ul>
 *
 * <p>本类刻意保持不可变、无框架依赖——它是引擎与业务之间唯一的条件契约，
 * 也是 {@link SqlRenderer} 递归渲染的输入。
 *
 * @author SongRenShuo
 */
public final class FilterExpression {

    /** 比较运算符。 */
    public enum Op {
        EQ, NE, GT, GE, LT, LE, LIKE, IN, NOT_IN, IS_NULL, IS_NOT_NULL, BETWEEN
    }

    private final String field;
    private final Op op;
    private final Object value;
    private final Object secondValue;
    private final List<Object> values;
    private final List<FilterExpression> children;
    private final boolean orGroup;

    private FilterExpression(String field, Op op, Object value, Object secondValue,
                             List<Object> values, List<FilterExpression> children, boolean orGroup) {
        this.field = field;
        this.op = op;
        this.value = value;
        this.secondValue = secondValue;
        this.values = values;
        this.children = children;
        this.orGroup = orGroup;
    }

    /** 叶子节点。 */
    public static FilterExpression leaf(String field, Op op, Object value) {
        return new FilterExpression(field, op, value, null, null, null, false);
    }

    /** BETWEEN 叶子节点。 */
    public static FilterExpression between(String field, Object low, Object high) {
        return new FilterExpression(field, Op.BETWEEN, low, high, null, null, false);
    }

    /** IN / NOT_IN 叶子节点。 */
    public static FilterExpression inList(String field, Op op, List<Object> values) {
        return new FilterExpression(field, op, null, null, values, null, false);
    }

    /** 分组节点。 */
    public static FilterExpression group(boolean orGroup, List<FilterExpression> children) {
        return new FilterExpression(null, null, null, null, null,
                children == null ? new ArrayList<FilterExpression>() : children, orGroup);
    }

    public boolean isGroup() {
        return children != null;
    }

    public boolean isOrGroup() {
        return orGroup;
    }

    public String getField() {
        return field;
    }

    public Op getOp() {
        return op;
    }

    public Object getValue() {
        return value;
    }

    public Object getSecondValue() {
        return secondValue;
    }

    public List<Object> getValues() {
        return values == null ? Collections.emptyList() : values;
    }

    public List<FilterExpression> getChildren() {
        return children == null ? Collections.emptyList() : children;
    }
}

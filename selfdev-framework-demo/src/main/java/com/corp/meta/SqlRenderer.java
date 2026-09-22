package com.corp.meta;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 自研框架 SQL 渲染器：把 {@link FilterExpression} 条件树递归渲染为 WHERE 子句 + 命名参数。
 *
 * <p>渲染期递归下降（分组节点递归、叶子节点按运算符出参），生成的参数名形如 {@code :p0}
 * 且每次渲染从 0 起算——保证同一条语句的参数名稳定，便于与日志/面板对照。
 *
 * @author SongRenShuo
 */
public final class SqlRenderer {

    private SqlRenderer() {
    }

    /** 渲染条件树 → WHERE 子句（不含 WHERE 关键字；条件为空返回 null）+ 命名参数。 */
    public static SqlFragment render(TableMeta meta, FilterExpression filter) {
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        int[] seq = new int[]{0};
        String where = renderNode(meta, filter, params, seq);
        return new SqlFragment(where, params);
    }

    private static String renderNode(TableMeta meta, FilterExpression node,
                                     Map<String, Object> params, int[] seq) {
        if (node == null) {
            return null;
        }
        if (node.isGroup()) {
            List<FilterExpression> children = node.getChildren();
            StringBuilder sb = new StringBuilder();
            for (FilterExpression child : children) {
                String part = renderNode(meta, child, params, seq);
                if (part == null) {
                    continue;
                }
                if (sb.length() > 0) {
                    sb.append(node.isOrGroup() ? " OR " : " AND ");
                }
                sb.append(part);
            }
            return sb.length() == 0 ? null : "(" + sb + ")";
        }

        String column = meta.columnOf(node.getField());
        switch (node.getOp()) {
            case IS_NULL:
                return column + " IS NULL";
            case IS_NOT_NULL:
                return column + " IS NOT NULL";
            case IN:
            case NOT_IN: {
                List<Object> values = node.getValues();
                if (values.isEmpty()) {
                    // 空集合语义：IN 恒假、NOT IN 恒真（与主流框架一致）
                    return node.getOp() == FilterExpression.Op.IN ? "1 = 0" : "1 = 1";
                }
                StringBuilder names = new StringBuilder();
                for (Object value : values) {
                    String name = "p" + seq[0]++;
                    params.put(name, value);
                    if (names.length() > 0) {
                        names.append(", ");
                    }
                    names.append(":").append(name);
                }
                return column + (node.getOp() == FilterExpression.Op.IN ? " IN (" : " NOT IN (")
                        + names + ")";
            }
            case BETWEEN: {
                String low = "p" + seq[0]++;
                String high = "p" + seq[0]++;
                params.put(low, node.getValue());
                params.put(high, node.getSecondValue());
                return column + " BETWEEN :" + low + " AND :" + high;
            }
            default: {
                String name = "p" + seq[0]++;
                params.put(name, node.getValue());
                return column + " " + operatorText(node.getOp()) + " :" + name;
            }
        }
    }

    private static String operatorText(FilterExpression.Op op) {
        switch (op) {
            case EQ:
                return "=";
            case NE:
                return "<>";
            case GT:
                return ">";
            case GE:
                return ">=";
            case LT:
                return "<";
            case LE:
                return "<=";
            case LIKE:
                return "LIKE";
            default:
                return "=";
        }
    }
}

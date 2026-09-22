package com.corp.meta;

/**
 * 自研框架分页入参：页码（1 起算）+ 每页条数 + 可选排序子句。
 *
 * <p>真实项目中该对象由业务组装后经门面透传，SQL 全程以「对象字段」形态流转、静态不可见。
 *
 * @author SongRenShuo
 */
public final class PaginQuery {

    private final int index;
    private final int size;
    private final String orderBy;

    public PaginQuery(int index, int size, String orderBy) {
        this.index = index;
        this.size = size;
        this.orderBy = orderBy;
    }

    public PaginQuery(int index, int size) {
        this(index, size, null);
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }

    public String getOrderBy() {
        return orderBy;
    }

    /** 偏移量（MySQL LIMIT offset, size 语义）。 */
    public int offset() {
        return Math.max(index - 1, 0) * Math.max(size, 0);
    }
}

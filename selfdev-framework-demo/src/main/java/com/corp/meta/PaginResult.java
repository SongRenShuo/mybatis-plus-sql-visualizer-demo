package com.corp.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * 自研框架分页出参。
 *
 * @author SongRenShuo
 * @param <T> 行类型
 */
public final class PaginResult<T> {

    private List<T> dataList = new ArrayList<T>();
    private int index;
    private int size;
    private long rowCount;
    private long totalRowCount;
    private long pageCount;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList == null ? new ArrayList<T>() : dataList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getRowCount() {
        return rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    public long getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(long totalRowCount) {
        this.totalRowCount = totalRowCount;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }
}

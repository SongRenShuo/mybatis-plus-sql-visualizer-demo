package cn.song.custcommon.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页响应载荷。
 */
public class ApiPage<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long pageNo = 1L;

    private long pageSize = 20L;

    private long total;

    private List<T> records = new ArrayList<T>();

    public ApiPage() {
    }

    public ApiPage(long pageNo, long pageSize, long total, List<T> records) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        this.records = records;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}

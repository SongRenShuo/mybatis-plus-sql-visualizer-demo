package cn.song.mybatisplusdemo.common;

import java.util.List;

/**
 * 分页查询结果壳（对齐用户真实项目中 PaginResult 的字段形态）
 *
 * @author SongRenShuo
 */
public class PaginResult<T> {

    /** 当前页数据 */
    private List<T> dataList;

    /** 页序 */
    private int index;

    /** 页大小 */
    private int size;

    /** 本页行数 */
    private int rowCount;

    /** 总行数 */
    private int totalRowCount;

    /** 总页数 */
    private int pageCount;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
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

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(int totalRowCount) {
        this.totalRowCount = totalRowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}

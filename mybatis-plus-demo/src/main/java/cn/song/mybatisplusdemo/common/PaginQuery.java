package cn.song.mybatisplusdemo.common;

/**
 * 分页查询参数壳（对齐用户真实项目中 PaginQuery 的消费形态）
 * <p>
 * SQL 字符串经 {@link #setQuery(String)} 存入，执行层经 {@link #getQuery()} 取出——
 * 即「SQL 以对象字段形态跨层流转」的真实场景。
 *
 * @author SongRenShuo
 */
public class PaginQuery {

    /** SQL 字符串（跨层流转载体） */
    private String query;

    /** 命名参数表 */
    private java.util.Map<String, ?> parameterMap;

    /** 页序（从 1 开始） */
    private int index;

    /** 页大小（&lt;=0 表示不分页） */
    private int size;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public java.util.Map<String, ?> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(java.util.Map<String, ?> parameterMap) {
        this.parameterMap = parameterMap;
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
}

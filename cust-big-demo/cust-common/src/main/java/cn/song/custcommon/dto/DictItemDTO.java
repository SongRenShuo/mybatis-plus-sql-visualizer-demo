package cn.song.custcommon.dto;

import java.io.Serializable;

/**
 * 字典项。
 */
public class DictItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 字典类型 */
    private String dictType;

    /** 字典标签 */
    private String dictLabel;

    /** 字典值 */
    private String dictValue;

    /** 排序号 */
    private Integer sortNo;

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DictItemDTO{");
        sb.append("dictType=").append(dictType).append(", ");
        sb.append("dictLabel=").append(dictLabel).append(", ");
        sb.append("dictValue=").append(dictValue).append(", ");
        sb.append("sortNo=").append(sortNo).append(", ");
        sb.append('}');
        return sb.toString();
    }
}

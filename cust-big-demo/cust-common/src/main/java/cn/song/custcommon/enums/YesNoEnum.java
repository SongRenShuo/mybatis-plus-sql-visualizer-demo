package cn.song.custcommon.enums;

/**
 * 是否枚举。
 */
public enum YesNoEnum {

    NO("0", "否"),

    YES("1", "是");

    private final String code;

    private final String label;

    YesNoEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}

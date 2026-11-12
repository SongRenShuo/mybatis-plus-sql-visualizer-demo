package cn.song.custcommon.enums;

/**
 * 启停状态。
 */
public enum StatusEnum {

    DISABLED("0", "停用"),

    ENABLED("1", "启用");

    private final String code;

    private final String label;

    StatusEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static StatusEnum fromCode(String code) {
        for (StatusEnum item : values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        return DISABLED;
    }
}

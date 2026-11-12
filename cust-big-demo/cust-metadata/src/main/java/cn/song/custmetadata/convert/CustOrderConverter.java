package cn.song.custmetadata.convert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * 客户订单Converter 字段适配器。
 *
 * <p>把上游系统的宽松入参收敛成统一形态，空值与非法值一律回落到默认值。
 */
public final class CustOrderConverter {

    private CustOrderConverter() {
    }

    /** 归一化附件比率（保留两位小数）。 */
    public static BigDecimal adaptAttachRate(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 复制附件日期（防御 Date 可变性）。 */
    public static Date adaptAttachDate(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 复制附件时间（防御 Date 可变性）。 */
    public static Date adaptAttachTime(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 归一化附件标记。 */
    public static Boolean adaptAttachFlag(Boolean value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化附件说明。 */
    public static String adaptAttachRemark(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化附件来源。 */
    public static String adaptAttachSource(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化附件版本。 */
    public static Integer adaptAttachVersion(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化附件区域。 */
    public static String adaptAttachRegion(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化附件渠道。 */
    public static String adaptAttachChannel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化附件分组。 */
    public static String adaptAttachGroup(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化附件标签。 */
    public static String adaptAttachTag(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化附件负责人。 */
    public static String adaptAttachOwner(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注编号。 */
    public static String adaptNoteNo(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注名称。 */
    public static String adaptNoteName(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注类型。 */
    public static String adaptNoteType(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注编码。 */
    public static String adaptNoteCode(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注级别。 */
    public static String adaptNoteLevel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注状态。 */
    public static String adaptNoteStatus(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注金额（保留两位小数）。 */
    public static BigDecimal adaptNoteAmount(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 归一化备注数量。 */
    public static Integer adaptNoteCount(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化备注比率（保留两位小数）。 */
    public static BigDecimal adaptNoteRate(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 复制备注日期（防御 Date 可变性）。 */
    public static Date adaptNoteDate(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 复制备注时间（防御 Date 可变性）。 */
    public static Date adaptNoteTime(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 归一化备注标记。 */
    public static Boolean adaptNoteFlag(Boolean value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化备注说明。 */
    public static String adaptNoteRemark(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注来源。 */
    public static String adaptNoteSource(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注版本。 */
    public static Integer adaptNoteVersion(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化备注区域。 */
    public static String adaptNoteRegion(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注渠道。 */
    public static String adaptNoteChannel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注分组。 */
    public static String adaptNoteGroup(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注标签。 */
    public static String adaptNoteTag(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化备注负责人。 */
    public static String adaptNoteOwner(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化偏好编号。 */
    public static String adaptPreferNo(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化偏好名称。 */
    public static String adaptPreferName(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化偏好类型。 */
    public static String adaptPreferType(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

}

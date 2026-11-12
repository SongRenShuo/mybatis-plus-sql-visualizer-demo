package cn.song.custmetadata.convert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * 客户行业Assembler 字段适配器。
 *
 * <p>把上游系统的宽松入参收敛成统一形态，空值与非法值一律回落到默认值。
 */
public final class CustIndustryAssembler {

    private CustIndustryAssembler() {
    }

    /** 归一化证件类型。 */
    public static String adaptCertType(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件编码。 */
    public static String adaptCertCode(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件级别。 */
    public static String adaptCertLevel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件状态。 */
    public static String adaptCertStatus(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件金额（保留两位小数）。 */
    public static BigDecimal adaptCertAmount(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 归一化证件数量。 */
    public static Integer adaptCertCount(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化证件比率（保留两位小数）。 */
    public static BigDecimal adaptCertRate(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 复制证件日期（防御 Date 可变性）。 */
    public static Date adaptCertDate(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 复制证件时间（防御 Date 可变性）。 */
    public static Date adaptCertTime(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 归一化证件标记。 */
    public static Boolean adaptCertFlag(Boolean value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化证件说明。 */
    public static String adaptCertRemark(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件来源。 */
    public static String adaptCertSource(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件版本。 */
    public static Integer adaptCertVersion(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化证件区域。 */
    public static String adaptCertRegion(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件渠道。 */
    public static String adaptCertChannel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件分组。 */
    public static String adaptCertGroup(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件标签。 */
    public static String adaptCertTag(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化证件负责人。 */
    public static String adaptCertOwner(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行编号。 */
    public static String adaptBankNo(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行名称。 */
    public static String adaptBankName(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行类型。 */
    public static String adaptBankType(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行编码。 */
    public static String adaptBankCode(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行级别。 */
    public static String adaptBankLevel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行状态。 */
    public static String adaptBankStatus(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行金额（保留两位小数）。 */
    public static BigDecimal adaptBankAmount(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 归一化银行数量。 */
    public static Integer adaptBankCount(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化银行比率（保留两位小数）。 */
    public static BigDecimal adaptBankRate(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 复制银行日期（防御 Date 可变性）。 */
    public static Date adaptBankDate(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 复制银行时间（防御 Date 可变性）。 */
    public static Date adaptBankTime(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 归一化银行标记。 */
    public static Boolean adaptBankFlag(Boolean value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化银行说明。 */
    public static String adaptBankRemark(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行来源。 */
    public static String adaptBankSource(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行版本。 */
    public static Integer adaptBankVersion(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化银行区域。 */
    public static String adaptBankRegion(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行渠道。 */
    public static String adaptBankChannel(String value, String defaultValue) {
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

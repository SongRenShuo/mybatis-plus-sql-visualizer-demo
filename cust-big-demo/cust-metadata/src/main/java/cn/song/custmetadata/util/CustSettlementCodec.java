package cn.song.custmetadata.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 客户结算Codec 相关字符串/数值工具。
 */
public final class CustSettlementCodec {

    private CustSettlementCodec() {
    }

    /** 校验风险编码。 */
    public static String validateRiskCode(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验风险级别。 */
    public static String validateRiskLevel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验风险状态。 */
    public static String validateRiskStatus(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验风险金额。 */
    public static BigDecimal validateRiskAmount(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 校验风险数量。 */
    public static Integer validateRiskCount(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 校验风险比率。 */
    public static BigDecimal validateRiskRate(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 校验风险日期。 */
    public static Date validateRiskDate(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 校验风险时间。 */
    public static Date validateRiskTime(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 校验风险标记。 */
    public static Boolean validateRiskFlag(String value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        String text = value.trim();
        return Boolean.valueOf("1".equals(text) || "true".equalsIgnoreCase(text));
    }

    /** 校验风险说明。 */
    public static String validateRiskRemark(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验风险来源。 */
    public static String validateRiskSource(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验风险版本。 */
    public static Integer validateRiskVersion(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 校验风险区域。 */
    public static String validateRiskRegion(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验风险渠道。 */
    public static String validateRiskChannel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验风险分组。 */
    public static String validateRiskGroup(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验风险标签。 */
    public static String validateRiskTag(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验风险负责人。 */
    public static String validateRiskOwner(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用编号。 */
    public static String validateCreditNo(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用名称。 */
    public static String validateCreditName(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用类型。 */
    public static String validateCreditType(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用编码。 */
    public static String validateCreditCode(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用级别。 */
    public static String validateCreditLevel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用状态。 */
    public static String validateCreditStatus(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用金额。 */
    public static BigDecimal validateCreditAmount(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 校验信用数量。 */
    public static Integer validateCreditCount(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 校验信用比率。 */
    public static BigDecimal validateCreditRate(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 校验信用日期。 */
    public static Date validateCreditDate(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 校验信用时间。 */
    public static Date validateCreditTime(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 校验信用标记。 */
    public static Boolean validateCreditFlag(String value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        String text = value.trim();
        return Boolean.valueOf("1".equals(text) || "true".equalsIgnoreCase(text));
    }

    /** 校验信用说明。 */
    public static String validateCreditRemark(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用来源。 */
    public static String validateCreditSource(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用版本。 */
    public static Integer validateCreditVersion(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 校验信用区域。 */
    public static String validateCreditRegion(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用渠道。 */
    public static String validateCreditChannel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用分组。 */
    public static String validateCreditGroup(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用标签。 */
    public static String validateCreditTag(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验信用负责人。 */
    public static String validateCreditOwner(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验行业编号。 */
    public static String validateIndustryNo(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验行业名称。 */
    public static String validateIndustryName(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 校验行业类型。 */
    public static String validateIndustryType(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

}

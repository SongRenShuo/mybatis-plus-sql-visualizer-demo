package cn.song.custmetadata.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 客户行业关系Formatter 相关字符串/数值工具。
 */
public final class CustIndustryRelFormatter {

    private CustIndustryRelFormatter() {
    }

    /** 解析资产标签。 */
    public static String parseAssetTag(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析资产负责人。 */
    public static String parseAssetOwner(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险编号。 */
    public static String parseRiskNo(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险名称。 */
    public static String parseRiskName(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险类型。 */
    public static String parseRiskType(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险编码。 */
    public static String parseRiskCode(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险级别。 */
    public static String parseRiskLevel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险状态。 */
    public static String parseRiskStatus(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险金额。 */
    public static BigDecimal parseRiskAmount(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 解析风险数量。 */
    public static Integer parseRiskCount(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 解析风险比率。 */
    public static BigDecimal parseRiskRate(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 解析风险日期。 */
    public static Date parseRiskDate(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 解析风险时间。 */
    public static Date parseRiskTime(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 解析风险标记。 */
    public static Boolean parseRiskFlag(String value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        String text = value.trim();
        return Boolean.valueOf("1".equals(text) || "true".equalsIgnoreCase(text));
    }

    /** 解析风险说明。 */
    public static String parseRiskRemark(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险来源。 */
    public static String parseRiskSource(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险版本。 */
    public static Integer parseRiskVersion(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 解析风险区域。 */
    public static String parseRiskRegion(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险渠道。 */
    public static String parseRiskChannel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险分组。 */
    public static String parseRiskGroup(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险标签。 */
    public static String parseRiskTag(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析风险负责人。 */
    public static String parseRiskOwner(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用编号。 */
    public static String parseCreditNo(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用名称。 */
    public static String parseCreditName(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用类型。 */
    public static String parseCreditType(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用编码。 */
    public static String parseCreditCode(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用级别。 */
    public static String parseCreditLevel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用状态。 */
    public static String parseCreditStatus(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用金额。 */
    public static BigDecimal parseCreditAmount(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 解析信用数量。 */
    public static Integer parseCreditCount(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 解析信用比率。 */
    public static BigDecimal parseCreditRate(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 解析信用日期。 */
    public static Date parseCreditDate(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 解析信用时间。 */
    public static Date parseCreditTime(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 解析信用标记。 */
    public static Boolean parseCreditFlag(String value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        String text = value.trim();
        return Boolean.valueOf("1".equals(text) || "true".equalsIgnoreCase(text));
    }

    /** 解析信用说明。 */
    public static String parseCreditRemark(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用来源。 */
    public static String parseCreditSource(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用版本。 */
    public static Integer parseCreditVersion(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 解析信用区域。 */
    public static String parseCreditRegion(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用渠道。 */
    public static String parseCreditChannel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 解析信用分组。 */
    public static String parseCreditGroup(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

}

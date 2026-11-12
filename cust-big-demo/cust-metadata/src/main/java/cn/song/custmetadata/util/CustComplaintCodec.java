package cn.song.custmetadata.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 客户投诉Codec 相关字符串/数值工具。
 */
public final class CustComplaintCodec {

    private CustComplaintCodec() {
    }

    /** 格式化资产区域。 */
    public static String formatAssetRegion(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产渠道。 */
    public static String formatAssetChannel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产分组。 */
    public static String formatAssetGroup(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产标签。 */
    public static String formatAssetTag(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产负责人。 */
    public static String formatAssetOwner(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险编号。 */
    public static String formatRiskNo(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险名称。 */
    public static String formatRiskName(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险类型。 */
    public static String formatRiskType(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险编码。 */
    public static String formatRiskCode(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险级别。 */
    public static String formatRiskLevel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险状态。 */
    public static String formatRiskStatus(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险金额。 */
    public static BigDecimal formatRiskAmount(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 格式化风险数量。 */
    public static Integer formatRiskCount(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 格式化风险比率。 */
    public static BigDecimal formatRiskRate(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 格式化风险日期。 */
    public static Date formatRiskDate(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 格式化风险时间。 */
    public static Date formatRiskTime(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 格式化风险标记。 */
    public static Boolean formatRiskFlag(String value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        String text = value.trim();
        return Boolean.valueOf("1".equals(text) || "true".equalsIgnoreCase(text));
    }

    /** 格式化风险说明。 */
    public static String formatRiskRemark(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险来源。 */
    public static String formatRiskSource(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险版本。 */
    public static Integer formatRiskVersion(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 格式化风险区域。 */
    public static String formatRiskRegion(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险渠道。 */
    public static String formatRiskChannel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险分组。 */
    public static String formatRiskGroup(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险标签。 */
    public static String formatRiskTag(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化风险负责人。 */
    public static String formatRiskOwner(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化信用编号。 */
    public static String formatCreditNo(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化信用名称。 */
    public static String formatCreditName(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化信用类型。 */
    public static String formatCreditType(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化信用编码。 */
    public static String formatCreditCode(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化信用级别。 */
    public static String formatCreditLevel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化信用状态。 */
    public static String formatCreditStatus(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化信用金额。 */
    public static BigDecimal formatCreditAmount(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 格式化信用数量。 */
    public static Integer formatCreditCount(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 格式化信用比率。 */
    public static BigDecimal formatCreditRate(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 格式化信用日期。 */
    public static Date formatCreditDate(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 格式化信用时间。 */
    public static Date formatCreditTime(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 格式化信用标记。 */
    public static Boolean formatCreditFlag(String value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        String text = value.trim();
        return Boolean.valueOf("1".equals(text) || "true".equalsIgnoreCase(text));
    }

    /** 格式化信用说明。 */
    public static String formatCreditRemark(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化信用来源。 */
    public static String formatCreditSource(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化信用版本。 */
    public static Integer formatCreditVersion(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

}

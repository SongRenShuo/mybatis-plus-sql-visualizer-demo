package cn.song.custmetadata.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 客户跟进Helper 相关字符串/数值工具。
 */
public final class CustFollowUpHelper {

    private CustFollowUpHelper() {
    }

    /** 格式化银行分组。 */
    public static String formatBankGroup(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化银行标签。 */
    public static String formatBankTag(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化银行负责人。 */
    public static String formatBankOwner(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产编号。 */
    public static String formatAssetNo(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产名称。 */
    public static String formatAssetName(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产类型。 */
    public static String formatAssetType(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产编码。 */
    public static String formatAssetCode(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产级别。 */
    public static String formatAssetLevel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产状态。 */
    public static String formatAssetStatus(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产金额。 */
    public static BigDecimal formatAssetAmount(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 格式化资产数量。 */
    public static Integer formatAssetCount(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 格式化资产比率。 */
    public static BigDecimal formatAssetRate(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 格式化资产日期。 */
    public static Date formatAssetDate(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 格式化资产时间。 */
    public static Date formatAssetTime(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 格式化资产标记。 */
    public static Boolean formatAssetFlag(String value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        String text = value.trim();
        return Boolean.valueOf("1".equals(text) || "true".equalsIgnoreCase(text));
    }

    /** 格式化资产说明。 */
    public static String formatAssetRemark(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产来源。 */
    public static String formatAssetSource(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 格式化资产版本。 */
    public static Integer formatAssetVersion(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
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

}

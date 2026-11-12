package cn.song.custmetadata.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 客户标签关系Helper 相关字符串/数值工具。
 */
public final class CustTagRelHelper {

    private CustTagRelHelper() {
    }

    /** 归一化结算比率。 */
    public static BigDecimal normalizeSettleRate(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 归一化结算日期。 */
    public static Date normalizeSettleDate(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 归一化结算时间。 */
    public static Date normalizeSettleTime(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 归一化结算标记。 */
    public static Boolean normalizeSettleFlag(String value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        String text = value.trim();
        return Boolean.valueOf("1".equals(text) || "true".equalsIgnoreCase(text));
    }

    /** 归一化结算说明。 */
    public static String normalizeSettleRemark(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化结算来源。 */
    public static String normalizeSettleSource(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化结算版本。 */
    public static Integer normalizeSettleVersion(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 归一化结算区域。 */
    public static String normalizeSettleRegion(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化结算渠道。 */
    public static String normalizeSettleChannel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化结算分组。 */
    public static String normalizeSettleGroup(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化结算标签。 */
    public static String normalizeSettleTag(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化结算负责人。 */
    public static String normalizeSettleOwner(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计编号。 */
    public static String normalizeAuditNo(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计名称。 */
    public static String normalizeAuditName(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计类型。 */
    public static String normalizeAuditType(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计编码。 */
    public static String normalizeAuditCode(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计级别。 */
    public static String normalizeAuditLevel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计状态。 */
    public static String normalizeAuditStatus(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计金额。 */
    public static BigDecimal normalizeAuditAmount(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 归一化审计数量。 */
    public static Integer normalizeAuditCount(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 归一化审计比率。 */
    public static BigDecimal normalizeAuditRate(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 归一化审计日期。 */
    public static Date normalizeAuditDate(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 归一化审计时间。 */
    public static Date normalizeAuditTime(String value) {
        if (value == null || value.trim().length() == 0) {
            return new Date(0L);
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value.trim());
        } catch (ParseException ex) {
            return new Date(0L);
        }
    }

    /** 归一化审计标记。 */
    public static Boolean normalizeAuditFlag(String value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        String text = value.trim();
        return Boolean.valueOf("1".equals(text) || "true".equalsIgnoreCase(text));
    }

    /** 归一化审计说明。 */
    public static String normalizeAuditRemark(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计来源。 */
    public static String normalizeAuditSource(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计版本。 */
    public static Integer normalizeAuditVersion(String value) {
        if (value == null || value.trim().length() == 0) {
            return Integer.valueOf(0);
        }
        try {
            return Integer.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return Integer.valueOf(0);
        }
    }

    /** 归一化审计区域。 */
    public static String normalizeAuditRegion(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计渠道。 */
    public static String normalizeAuditChannel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计分组。 */
    public static String normalizeAuditGroup(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计标签。 */
    public static String normalizeAuditTag(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化审计负责人。 */
    public static String normalizeAuditOwner(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化附件编号。 */
    public static String normalizeAttachNo(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化附件名称。 */
    public static String normalizeAttachName(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化附件类型。 */
    public static String normalizeAttachType(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化附件编码。 */
    public static String normalizeAttachCode(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化附件级别。 */
    public static String normalizeAttachLevel(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化附件状态。 */
    public static String normalizeAttachStatus(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    /** 归一化附件金额。 */
    public static BigDecimal normalizeAttachAmount(String value) {
        if (value == null || value.trim().length() == 0) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /** 归一化附件数量。 */
    public static Integer normalizeAttachCount(String value) {
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

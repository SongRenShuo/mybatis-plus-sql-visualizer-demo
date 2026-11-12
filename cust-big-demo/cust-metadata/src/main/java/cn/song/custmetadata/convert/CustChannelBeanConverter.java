package cn.song.custmetadata.convert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * 客户渠道BeanConverter 字段适配器。
 *
 * <p>把上游系统的宽松入参收敛成统一形态，空值与非法值一律回落到默认值。
 */
public final class CustChannelBeanConverter {

    private CustChannelBeanConverter() {
    }

    /** 归一化行业编码。 */
    public static String adaptIndustryCode(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化行业级别。 */
    public static String adaptIndustryLevel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化行业状态。 */
    public static String adaptIndustryStatus(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化行业金额（保留两位小数）。 */
    public static BigDecimal adaptIndustryAmount(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 归一化行业数量。 */
    public static Integer adaptIndustryCount(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化行业比率（保留两位小数）。 */
    public static BigDecimal adaptIndustryRate(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 复制行业日期（防御 Date 可变性）。 */
    public static Date adaptIndustryDate(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 复制行业时间（防御 Date 可变性）。 */
    public static Date adaptIndustryTime(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 归一化行业标记。 */
    public static Boolean adaptIndustryFlag(Boolean value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化行业说明。 */
    public static String adaptIndustryRemark(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化行业来源。 */
    public static String adaptIndustrySource(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化行业版本。 */
    public static Integer adaptIndustryVersion(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化行业区域。 */
    public static String adaptIndustryRegion(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化行业渠道。 */
    public static String adaptIndustryChannel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化行业分组。 */
    public static String adaptIndustryGroup(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化行业标签。 */
    public static String adaptIndustryTag(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化行业负责人。 */
    public static String adaptIndustryOwner(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道编号。 */
    public static String adaptChannelNo(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道名称。 */
    public static String adaptChannelName(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道类型。 */
    public static String adaptChannelType(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道编码。 */
    public static String adaptChannelCode(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道级别。 */
    public static String adaptChannelLevel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道状态。 */
    public static String adaptChannelStatus(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道金额（保留两位小数）。 */
    public static BigDecimal adaptChannelAmount(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 归一化渠道数量。 */
    public static Integer adaptChannelCount(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化渠道比率（保留两位小数）。 */
    public static BigDecimal adaptChannelRate(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 复制渠道日期（防御 Date 可变性）。 */
    public static Date adaptChannelDate(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 复制渠道时间（防御 Date 可变性）。 */
    public static Date adaptChannelTime(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 归一化渠道标记。 */
    public static Boolean adaptChannelFlag(Boolean value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化渠道说明。 */
    public static String adaptChannelRemark(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道来源。 */
    public static String adaptChannelSource(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道版本。 */
    public static Integer adaptChannelVersion(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化渠道区域。 */
    public static String adaptChannelRegion(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道渠道。 */
    public static String adaptChannelChannel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化渠道分组。 */
    public static String adaptChannelGroup(String value, String defaultValue) {
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

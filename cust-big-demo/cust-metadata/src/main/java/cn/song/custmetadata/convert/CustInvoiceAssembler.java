package cn.song.custmetadata.convert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * 客户发票Assembler 字段适配器。
 *
 * <p>把上游系统的宽松入参收敛成统一形态，空值与非法值一律回落到默认值。
 */
public final class CustInvoiceAssembler {

    private CustInvoiceAssembler() {
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

    /** 归一化银行分组。 */
    public static String adaptBankGroup(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行标签。 */
    public static String adaptBankTag(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化银行负责人。 */
    public static String adaptBankOwner(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化资产编号。 */
    public static String adaptAssetNo(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化资产名称。 */
    public static String adaptAssetName(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化资产类型。 */
    public static String adaptAssetType(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化资产编码。 */
    public static String adaptAssetCode(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化资产级别。 */
    public static String adaptAssetLevel(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化资产状态。 */
    public static String adaptAssetStatus(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        String text = value.trim();
        if (text.length() == 0) {
            return defaultValue;
        }
        return text;
    }

    /** 归一化资产金额（保留两位小数）。 */
    public static BigDecimal adaptAssetAmount(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 归一化资产数量。 */
    public static Integer adaptAssetCount(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.intValue() < 0) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化资产比率（保留两位小数）。 */
    public static BigDecimal adaptAssetRate(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value.signum() < 0) {
            return defaultValue;
        }
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    /** 复制资产日期（防御 Date 可变性）。 */
    public static Date adaptAssetDate(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 复制资产时间（防御 Date 可变性）。 */
    public static Date adaptAssetTime(Date value, Date defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return new Date(value.getTime());
    }

    /** 归一化资产标记。 */
    public static Boolean adaptAssetFlag(Boolean value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /** 归一化资产说明。 */
    public static String adaptAssetRemark(String value, String defaultValue) {
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

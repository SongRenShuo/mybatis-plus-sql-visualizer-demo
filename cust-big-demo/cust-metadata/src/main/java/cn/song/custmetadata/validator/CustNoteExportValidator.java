package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户备注ExportValidator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustNoteExportValidator {

    private CustNoteExportValidator() {
    }

    /** 校验发票比率。 */
    public static void validateInvoiceRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceRate 长度不能超过 128");
        }
    }

    /** 校验发票日期。 */
    public static void validateInvoiceDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceDate 长度不能超过 128");
        }
    }

    /** 校验发票时间。 */
    public static void validateInvoiceTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceTime 长度不能超过 128");
        }
    }

    /** 校验发票标记。 */
    public static void validateInvoiceFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceFlag 长度不能超过 128");
        }
    }

    /** 校验发票说明。 */
    public static void validateInvoiceRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceRemark 长度不能超过 128");
        }
    }

    /** 校验发票来源。 */
    public static void validateInvoiceSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceSource 长度不能超过 128");
        }
    }

    /** 校验发票版本。 */
    public static void validateInvoiceVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceVersion 长度不能超过 128");
        }
    }

    /** 校验发票区域。 */
    public static void validateInvoiceRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceRegion 长度不能超过 128");
        }
    }

    /** 校验发票渠道。 */
    public static void validateInvoiceChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceChannel 长度不能超过 128");
        }
    }

    /** 校验发票分组。 */
    public static void validateInvoiceGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceGroup 长度不能超过 128");
        }
    }

    /** 校验发票标签。 */
    public static void validateInvoiceTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceTag 长度不能超过 128");
        }
    }

    /** 校验发票负责人。 */
    public static void validateInvoiceOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceOwner 长度不能超过 128");
        }
    }

    /** 校验结算编号。 */
    public static void validateSettleNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleNo 长度不能超过 128");
        }
    }

    /** 校验结算名称。 */
    public static void validateSettleName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleName 长度不能超过 128");
        }
    }

    /** 校验结算类型。 */
    public static void validateSettleType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleType 长度不能超过 128");
        }
    }

    /** 校验结算编码。 */
    public static void validateSettleCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleCode 长度不能超过 128");
        }
    }

    /** 校验结算级别。 */
    public static void validateSettleLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleLevel 长度不能超过 128");
        }
    }

    /** 校验结算状态。 */
    public static void validateSettleStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleStatus 长度不能超过 128");
        }
    }

    /** 校验结算金额。 */
    public static void validateSettleAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleAmount 长度不能超过 128");
        }
    }

    /** 校验结算数量。 */
    public static void validateSettleCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleCount 长度不能超过 128");
        }
    }

    /** 校验结算比率。 */
    public static void validateSettleRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleRate 长度不能超过 128");
        }
    }

    /** 校验结算日期。 */
    public static void validateSettleDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleDate 长度不能超过 128");
        }
    }

    /** 校验结算时间。 */
    public static void validateSettleTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleTime 长度不能超过 128");
        }
    }

    /** 校验结算标记。 */
    public static void validateSettleFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleFlag 长度不能超过 128");
        }
    }

    /** 校验结算说明。 */
    public static void validateSettleRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleRemark 长度不能超过 128");
        }
    }

    /** 校验结算来源。 */
    public static void validateSettleSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleSource 长度不能超过 128");
        }
    }

    /** 校验结算版本。 */
    public static void validateSettleVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleVersion 长度不能超过 128");
        }
    }

    /** 校验结算区域。 */
    public static void validateSettleRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleRegion 长度不能超过 128");
        }
    }

    /** 校验结算渠道。 */
    public static void validateSettleChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleChannel 长度不能超过 128");
        }
    }

    /** 校验结算分组。 */
    public static void validateSettleGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("settleGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("settleGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("settleGroup 长度不能超过 128");
        }
    }

}

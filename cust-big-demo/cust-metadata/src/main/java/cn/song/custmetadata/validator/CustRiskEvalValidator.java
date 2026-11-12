package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户风险评估Validator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustRiskEvalValidator {

    private CustRiskEvalValidator() {
    }

    /** 校验付款时间。 */
    public static void validatePaymentTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentTime 长度不能超过 128");
        }
    }

    /** 校验付款标记。 */
    public static void validatePaymentFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentFlag 长度不能超过 128");
        }
    }

    /** 校验付款说明。 */
    public static void validatePaymentRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentRemark 长度不能超过 128");
        }
    }

    /** 校验付款来源。 */
    public static void validatePaymentSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentSource 长度不能超过 128");
        }
    }

    /** 校验付款版本。 */
    public static void validatePaymentVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentVersion 长度不能超过 128");
        }
    }

    /** 校验付款区域。 */
    public static void validatePaymentRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentRegion 长度不能超过 128");
        }
    }

    /** 校验付款渠道。 */
    public static void validatePaymentChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentChannel 长度不能超过 128");
        }
    }

    /** 校验付款分组。 */
    public static void validatePaymentGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentGroup 长度不能超过 128");
        }
    }

    /** 校验付款标签。 */
    public static void validatePaymentTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentTag 长度不能超过 128");
        }
    }

    /** 校验付款负责人。 */
    public static void validatePaymentOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentOwner 长度不能超过 128");
        }
    }

    /** 校验发票编号。 */
    public static void validateInvoiceNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceNo 长度不能超过 128");
        }
    }

    /** 校验发票名称。 */
    public static void validateInvoiceName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceName 长度不能超过 128");
        }
    }

    /** 校验发票类型。 */
    public static void validateInvoiceType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceType 长度不能超过 128");
        }
    }

    /** 校验发票编码。 */
    public static void validateInvoiceCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceCode 长度不能超过 128");
        }
    }

    /** 校验发票级别。 */
    public static void validateInvoiceLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceLevel 长度不能超过 128");
        }
    }

    /** 校验发票状态。 */
    public static void validateInvoiceStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceStatus 长度不能超过 128");
        }
    }

    /** 校验发票金额。 */
    public static void validateInvoiceAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceAmount 长度不能超过 128");
        }
    }

    /** 校验发票数量。 */
    public static void validateInvoiceCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("invoiceCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("invoiceCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("invoiceCount 长度不能超过 128");
        }
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

}

package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户订单ExportValidator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustOrderExportValidator {

    private CustOrderExportValidator() {
    }

    /** 校验合同标签。 */
    public static void validateContractTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("contractTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("contractTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("contractTag 长度不能超过 128");
        }
    }

    /** 校验合同负责人。 */
    public static void validateContractOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("contractOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("contractOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("contractOwner 长度不能超过 128");
        }
    }

    /** 校验订单编号。 */
    public static void validateOrderNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderNo 长度不能超过 128");
        }
    }

    /** 校验订单名称。 */
    public static void validateOrderName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderName 长度不能超过 128");
        }
    }

    /** 校验订单类型。 */
    public static void validateOrderType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderType 长度不能超过 128");
        }
    }

    /** 校验订单编码。 */
    public static void validateOrderCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderCode 长度不能超过 128");
        }
    }

    /** 校验订单级别。 */
    public static void validateOrderLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderLevel 长度不能超过 128");
        }
    }

    /** 校验订单状态。 */
    public static void validateOrderStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderStatus 长度不能超过 128");
        }
    }

    /** 校验订单金额。 */
    public static void validateOrderAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderAmount 长度不能超过 128");
        }
    }

    /** 校验订单数量。 */
    public static void validateOrderCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderCount 长度不能超过 128");
        }
    }

    /** 校验订单比率。 */
    public static void validateOrderRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderRate 长度不能超过 128");
        }
    }

    /** 校验订单日期。 */
    public static void validateOrderDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderDate 长度不能超过 128");
        }
    }

    /** 校验订单时间。 */
    public static void validateOrderTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderTime 长度不能超过 128");
        }
    }

    /** 校验订单标记。 */
    public static void validateOrderFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderFlag 长度不能超过 128");
        }
    }

    /** 校验订单说明。 */
    public static void validateOrderRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderRemark 长度不能超过 128");
        }
    }

    /** 校验订单来源。 */
    public static void validateOrderSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderSource 长度不能超过 128");
        }
    }

    /** 校验订单版本。 */
    public static void validateOrderVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderVersion 长度不能超过 128");
        }
    }

    /** 校验订单区域。 */
    public static void validateOrderRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderRegion 长度不能超过 128");
        }
    }

    /** 校验订单渠道。 */
    public static void validateOrderChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderChannel 长度不能超过 128");
        }
    }

    /** 校验订单分组。 */
    public static void validateOrderGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderGroup 长度不能超过 128");
        }
    }

    /** 校验订单标签。 */
    public static void validateOrderTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderTag 长度不能超过 128");
        }
    }

    /** 校验订单负责人。 */
    public static void validateOrderOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("orderOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("orderOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("orderOwner 长度不能超过 128");
        }
    }

    /** 校验付款编号。 */
    public static void validatePaymentNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentNo 长度不能超过 128");
        }
    }

    /** 校验付款名称。 */
    public static void validatePaymentName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentName 长度不能超过 128");
        }
    }

    /** 校验付款类型。 */
    public static void validatePaymentType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentType 长度不能超过 128");
        }
    }

    /** 校验付款编码。 */
    public static void validatePaymentCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentCode 长度不能超过 128");
        }
    }

    /** 校验付款级别。 */
    public static void validatePaymentLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentLevel 长度不能超过 128");
        }
    }

    /** 校验付款状态。 */
    public static void validatePaymentStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentStatus 长度不能超过 128");
        }
    }

    /** 校验付款金额。 */
    public static void validatePaymentAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentAmount 长度不能超过 128");
        }
    }

    /** 校验付款数量。 */
    public static void validatePaymentCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("paymentCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("paymentCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("paymentCount 长度不能超过 128");
        }
    }

}

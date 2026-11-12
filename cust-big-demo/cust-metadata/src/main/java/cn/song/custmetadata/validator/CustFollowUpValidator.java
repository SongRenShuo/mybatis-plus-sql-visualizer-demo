package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户跟进Validator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustFollowUpValidator {

    private CustFollowUpValidator() {
    }

    /** 校验客户编号。 */
    public static void validateCustNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custNo 长度不能超过 128");
        }
    }

    /** 校验客户名称。 */
    public static void validateCustName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custName 长度不能超过 128");
        }
    }

    /** 校验客户类型。 */
    public static void validateCustType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custType 长度不能超过 128");
        }
    }

    /** 校验客户编码。 */
    public static void validateCustCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custCode 长度不能超过 128");
        }
    }

    /** 校验客户级别。 */
    public static void validateCustLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custLevel 长度不能超过 128");
        }
    }

    /** 校验客户状态。 */
    public static void validateCustStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custStatus 长度不能超过 128");
        }
    }

    /** 校验客户金额。 */
    public static void validateCustAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custAmount 长度不能超过 128");
        }
    }

    /** 校验客户数量。 */
    public static void validateCustCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custCount 长度不能超过 128");
        }
    }

    /** 校验客户比率。 */
    public static void validateCustRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custRate 长度不能超过 128");
        }
    }

    /** 校验客户日期。 */
    public static void validateCustDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custDate 长度不能超过 128");
        }
    }

    /** 校验客户时间。 */
    public static void validateCustTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custTime 长度不能超过 128");
        }
    }

    /** 校验客户标记。 */
    public static void validateCustFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custFlag 长度不能超过 128");
        }
    }

    /** 校验客户说明。 */
    public static void validateCustRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custRemark 长度不能超过 128");
        }
    }

    /** 校验客户来源。 */
    public static void validateCustSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custSource 长度不能超过 128");
        }
    }

    /** 校验客户版本。 */
    public static void validateCustVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custVersion 长度不能超过 128");
        }
    }

    /** 校验客户区域。 */
    public static void validateCustRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custRegion 长度不能超过 128");
        }
    }

    /** 校验客户渠道。 */
    public static void validateCustChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custChannel 长度不能超过 128");
        }
    }

    /** 校验客户分组。 */
    public static void validateCustGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custGroup 长度不能超过 128");
        }
    }

    /** 校验客户标签。 */
    public static void validateCustTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custTag 长度不能超过 128");
        }
    }

    /** 校验客户负责人。 */
    public static void validateCustOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("custOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("custOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("custOwner 长度不能超过 128");
        }
    }

    /** 校验证件编号。 */
    public static void validateCertNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certNo 长度不能超过 128");
        }
    }

    /** 校验证件名称。 */
    public static void validateCertName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certName 长度不能超过 128");
        }
    }

    /** 校验证件类型。 */
    public static void validateCertType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certType 长度不能超过 128");
        }
    }

    /** 校验证件编码。 */
    public static void validateCertCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certCode 长度不能超过 128");
        }
    }

    /** 校验证件级别。 */
    public static void validateCertLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certLevel 长度不能超过 128");
        }
    }

    /** 校验证件状态。 */
    public static void validateCertStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certStatus 长度不能超过 128");
        }
    }

    /** 校验证件金额。 */
    public static void validateCertAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certAmount 长度不能超过 128");
        }
    }

    /** 校验证件数量。 */
    public static void validateCertCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certCount 长度不能超过 128");
        }
    }

    /** 校验证件比率。 */
    public static void validateCertRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certRate 长度不能超过 128");
        }
    }

    /** 校验证件日期。 */
    public static void validateCertDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certDate 长度不能超过 128");
        }
    }

}

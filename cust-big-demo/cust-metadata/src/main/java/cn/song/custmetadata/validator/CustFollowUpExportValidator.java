package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户跟进ExportValidator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustFollowUpExportValidator {

    private CustFollowUpExportValidator() {
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

    /** 校验证件时间。 */
    public static void validateCertTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certTime 长度不能超过 128");
        }
    }

    /** 校验证件标记。 */
    public static void validateCertFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certFlag 长度不能超过 128");
        }
    }

    /** 校验证件说明。 */
    public static void validateCertRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certRemark 长度不能超过 128");
        }
    }

    /** 校验证件来源。 */
    public static void validateCertSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certSource 长度不能超过 128");
        }
    }

    /** 校验证件版本。 */
    public static void validateCertVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certVersion 长度不能超过 128");
        }
    }

    /** 校验证件区域。 */
    public static void validateCertRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certRegion 长度不能超过 128");
        }
    }

    /** 校验证件渠道。 */
    public static void validateCertChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certChannel 长度不能超过 128");
        }
    }

    /** 校验证件分组。 */
    public static void validateCertGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certGroup 长度不能超过 128");
        }
    }

    /** 校验证件标签。 */
    public static void validateCertTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certTag 长度不能超过 128");
        }
    }

    /** 校验证件负责人。 */
    public static void validateCertOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("certOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("certOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("certOwner 长度不能超过 128");
        }
    }

    /** 校验银行编号。 */
    public static void validateBankNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankNo 长度不能超过 128");
        }
    }

    /** 校验银行名称。 */
    public static void validateBankName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankName 长度不能超过 128");
        }
    }

    /** 校验银行类型。 */
    public static void validateBankType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankType 长度不能超过 128");
        }
    }

    /** 校验银行编码。 */
    public static void validateBankCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankCode 长度不能超过 128");
        }
    }

    /** 校验银行级别。 */
    public static void validateBankLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankLevel 长度不能超过 128");
        }
    }

    /** 校验银行状态。 */
    public static void validateBankStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankStatus 长度不能超过 128");
        }
    }

    /** 校验银行金额。 */
    public static void validateBankAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankAmount 长度不能超过 128");
        }
    }

    /** 校验银行数量。 */
    public static void validateBankCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankCount 长度不能超过 128");
        }
    }

}

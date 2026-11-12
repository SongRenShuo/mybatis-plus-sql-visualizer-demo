package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户群组Validator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustGroupValidator {

    private CustGroupValidator() {
    }

    /** 校验审计编号。 */
    public static void validateAuditNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditNo 长度不能超过 128");
        }
    }

    /** 校验审计名称。 */
    public static void validateAuditName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditName 长度不能超过 128");
        }
    }

    /** 校验审计类型。 */
    public static void validateAuditType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditType 长度不能超过 128");
        }
    }

    /** 校验审计编码。 */
    public static void validateAuditCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditCode 长度不能超过 128");
        }
    }

    /** 校验审计级别。 */
    public static void validateAuditLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditLevel 长度不能超过 128");
        }
    }

    /** 校验审计状态。 */
    public static void validateAuditStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditStatus 长度不能超过 128");
        }
    }

    /** 校验审计金额。 */
    public static void validateAuditAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditAmount 长度不能超过 128");
        }
    }

    /** 校验审计数量。 */
    public static void validateAuditCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditCount 长度不能超过 128");
        }
    }

    /** 校验审计比率。 */
    public static void validateAuditRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditRate 长度不能超过 128");
        }
    }

    /** 校验审计日期。 */
    public static void validateAuditDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditDate 长度不能超过 128");
        }
    }

    /** 校验审计时间。 */
    public static void validateAuditTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditTime 长度不能超过 128");
        }
    }

    /** 校验审计标记。 */
    public static void validateAuditFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditFlag 长度不能超过 128");
        }
    }

    /** 校验审计说明。 */
    public static void validateAuditRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditRemark 长度不能超过 128");
        }
    }

    /** 校验审计来源。 */
    public static void validateAuditSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditSource 长度不能超过 128");
        }
    }

    /** 校验审计版本。 */
    public static void validateAuditVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditVersion 长度不能超过 128");
        }
    }

    /** 校验审计区域。 */
    public static void validateAuditRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditRegion 长度不能超过 128");
        }
    }

    /** 校验审计渠道。 */
    public static void validateAuditChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditChannel 长度不能超过 128");
        }
    }

    /** 校验审计分组。 */
    public static void validateAuditGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditGroup 长度不能超过 128");
        }
    }

    /** 校验审计标签。 */
    public static void validateAuditTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditTag 长度不能超过 128");
        }
    }

    /** 校验审计负责人。 */
    public static void validateAuditOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("auditOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("auditOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("auditOwner 长度不能超过 128");
        }
    }

    /** 校验附件编号。 */
    public static void validateAttachNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachNo 长度不能超过 128");
        }
    }

    /** 校验附件名称。 */
    public static void validateAttachName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachName 长度不能超过 128");
        }
    }

    /** 校验附件类型。 */
    public static void validateAttachType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachType 长度不能超过 128");
        }
    }

    /** 校验附件编码。 */
    public static void validateAttachCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachCode 长度不能超过 128");
        }
    }

    /** 校验附件级别。 */
    public static void validateAttachLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachLevel 长度不能超过 128");
        }
    }

    /** 校验附件状态。 */
    public static void validateAttachStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachStatus 长度不能超过 128");
        }
    }

    /** 校验附件金额。 */
    public static void validateAttachAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachAmount 长度不能超过 128");
        }
    }

    /** 校验附件数量。 */
    public static void validateAttachCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachCount 长度不能超过 128");
        }
    }

    /** 校验附件比率。 */
    public static void validateAttachRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachRate 长度不能超过 128");
        }
    }

    /** 校验附件日期。 */
    public static void validateAttachDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachDate 长度不能超过 128");
        }
    }

}

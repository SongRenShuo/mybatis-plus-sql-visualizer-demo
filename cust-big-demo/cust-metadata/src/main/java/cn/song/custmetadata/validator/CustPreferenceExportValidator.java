package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户偏好ExportValidator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustPreferenceExportValidator {

    private CustPreferenceExportValidator() {
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

    /** 校验附件时间。 */
    public static void validateAttachTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachTime 长度不能超过 128");
        }
    }

    /** 校验附件标记。 */
    public static void validateAttachFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachFlag 长度不能超过 128");
        }
    }

    /** 校验附件说明。 */
    public static void validateAttachRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachRemark 长度不能超过 128");
        }
    }

    /** 校验附件来源。 */
    public static void validateAttachSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachSource 长度不能超过 128");
        }
    }

    /** 校验附件版本。 */
    public static void validateAttachVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachVersion 长度不能超过 128");
        }
    }

    /** 校验附件区域。 */
    public static void validateAttachRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachRegion 长度不能超过 128");
        }
    }

    /** 校验附件渠道。 */
    public static void validateAttachChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachChannel 长度不能超过 128");
        }
    }

    /** 校验附件分组。 */
    public static void validateAttachGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachGroup 长度不能超过 128");
        }
    }

    /** 校验附件标签。 */
    public static void validateAttachTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachTag 长度不能超过 128");
        }
    }

    /** 校验附件负责人。 */
    public static void validateAttachOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("attachOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("attachOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("attachOwner 长度不能超过 128");
        }
    }

    /** 校验备注编号。 */
    public static void validateNoteNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteNo 长度不能超过 128");
        }
    }

    /** 校验备注名称。 */
    public static void validateNoteName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteName 长度不能超过 128");
        }
    }

    /** 校验备注类型。 */
    public static void validateNoteType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteType 长度不能超过 128");
        }
    }

    /** 校验备注编码。 */
    public static void validateNoteCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteCode 长度不能超过 128");
        }
    }

    /** 校验备注级别。 */
    public static void validateNoteLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteLevel 长度不能超过 128");
        }
    }

    /** 校验备注状态。 */
    public static void validateNoteStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteStatus 长度不能超过 128");
        }
    }

    /** 校验备注金额。 */
    public static void validateNoteAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteAmount 长度不能超过 128");
        }
    }

    /** 校验备注数量。 */
    public static void validateNoteCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteCount 长度不能超过 128");
        }
    }

}

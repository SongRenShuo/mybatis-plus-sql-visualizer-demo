package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户信用评分Validator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustCreditScoreValidator {

    private CustCreditScoreValidator() {
    }

    /** 校验备注时间。 */
    public static void validateNoteTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteTime 长度不能超过 128");
        }
    }

    /** 校验备注标记。 */
    public static void validateNoteFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteFlag 长度不能超过 128");
        }
    }

    /** 校验备注说明。 */
    public static void validateNoteRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteRemark 长度不能超过 128");
        }
    }

    /** 校验备注来源。 */
    public static void validateNoteSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteSource 长度不能超过 128");
        }
    }

    /** 校验备注版本。 */
    public static void validateNoteVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteVersion 长度不能超过 128");
        }
    }

    /** 校验备注区域。 */
    public static void validateNoteRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteRegion 长度不能超过 128");
        }
    }

    /** 校验备注渠道。 */
    public static void validateNoteChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteChannel 长度不能超过 128");
        }
    }

    /** 校验备注分组。 */
    public static void validateNoteGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteGroup 长度不能超过 128");
        }
    }

    /** 校验备注标签。 */
    public static void validateNoteTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteTag 长度不能超过 128");
        }
    }

    /** 校验备注负责人。 */
    public static void validateNoteOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("noteOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("noteOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("noteOwner 长度不能超过 128");
        }
    }

    /** 校验偏好编号。 */
    public static void validatePreferNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferNo 长度不能超过 128");
        }
    }

    /** 校验偏好名称。 */
    public static void validatePreferName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferName 长度不能超过 128");
        }
    }

    /** 校验偏好类型。 */
    public static void validatePreferType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferType 长度不能超过 128");
        }
    }

    /** 校验偏好编码。 */
    public static void validatePreferCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferCode 长度不能超过 128");
        }
    }

    /** 校验偏好级别。 */
    public static void validatePreferLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferLevel 长度不能超过 128");
        }
    }

    /** 校验偏好状态。 */
    public static void validatePreferStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferStatus 长度不能超过 128");
        }
    }

    /** 校验偏好金额。 */
    public static void validatePreferAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferAmount 长度不能超过 128");
        }
    }

    /** 校验偏好数量。 */
    public static void validatePreferCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferCount 长度不能超过 128");
        }
    }

    /** 校验偏好比率。 */
    public static void validatePreferRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferRate 长度不能超过 128");
        }
    }

    /** 校验偏好日期。 */
    public static void validatePreferDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferDate 长度不能超过 128");
        }
    }

    /** 校验偏好时间。 */
    public static void validatePreferTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferTime 长度不能超过 128");
        }
    }

    /** 校验偏好标记。 */
    public static void validatePreferFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferFlag 长度不能超过 128");
        }
    }

    /** 校验偏好说明。 */
    public static void validatePreferRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferRemark 长度不能超过 128");
        }
    }

    /** 校验偏好来源。 */
    public static void validatePreferSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferSource 长度不能超过 128");
        }
    }

    /** 校验偏好版本。 */
    public static void validatePreferVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferVersion 长度不能超过 128");
        }
    }

    /** 校验偏好区域。 */
    public static void validatePreferRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferRegion 长度不能超过 128");
        }
    }

    /** 校验偏好渠道。 */
    public static void validatePreferChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferChannel 长度不能超过 128");
        }
    }

    /** 校验偏好分组。 */
    public static void validatePreferGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferGroup 长度不能超过 128");
        }
    }

    /** 校验偏好标签。 */
    public static void validatePreferTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferTag 长度不能超过 128");
        }
    }

    /** 校验偏好负责人。 */
    public static void validatePreferOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("preferOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("preferOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("preferOwner 长度不能超过 128");
        }
    }

}

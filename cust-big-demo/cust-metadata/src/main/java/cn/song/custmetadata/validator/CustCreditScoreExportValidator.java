package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户信用评分ExportValidator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustCreditScoreExportValidator {

    private CustCreditScoreExportValidator() {
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

    /** 校验评分编号。 */
    public static void validateScoreNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreNo 长度不能超过 128");
        }
    }

    /** 校验评分名称。 */
    public static void validateScoreName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreName 长度不能超过 128");
        }
    }

    /** 校验评分类型。 */
    public static void validateScoreType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreType 长度不能超过 128");
        }
    }

    /** 校验评分编码。 */
    public static void validateScoreCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreCode 长度不能超过 128");
        }
    }

    /** 校验评分级别。 */
    public static void validateScoreLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreLevel 长度不能超过 128");
        }
    }

    /** 校验评分状态。 */
    public static void validateScoreStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreStatus 长度不能超过 128");
        }
    }

    /** 校验评分金额。 */
    public static void validateScoreAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreAmount 长度不能超过 128");
        }
    }

    /** 校验评分数量。 */
    public static void validateScoreCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreCount 长度不能超过 128");
        }
    }

    /** 校验评分比率。 */
    public static void validateScoreRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreRate 长度不能超过 128");
        }
    }

    /** 校验评分日期。 */
    public static void validateScoreDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreDate 长度不能超过 128");
        }
    }

    /** 校验评分时间。 */
    public static void validateScoreTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreTime 长度不能超过 128");
        }
    }

    /** 校验评分标记。 */
    public static void validateScoreFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreFlag 长度不能超过 128");
        }
    }

    /** 校验评分说明。 */
    public static void validateScoreRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreRemark 长度不能超过 128");
        }
    }

    /** 校验评分来源。 */
    public static void validateScoreSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreSource 长度不能超过 128");
        }
    }

    /** 校验评分版本。 */
    public static void validateScoreVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreVersion 长度不能超过 128");
        }
    }

    /** 校验评分区域。 */
    public static void validateScoreRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreRegion 长度不能超过 128");
        }
    }

    /** 校验评分渠道。 */
    public static void validateScoreChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreChannel 长度不能超过 128");
        }
    }

    /** 校验评分分组。 */
    public static void validateScoreGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("scoreGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("scoreGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("scoreGroup 长度不能超过 128");
        }
    }

}

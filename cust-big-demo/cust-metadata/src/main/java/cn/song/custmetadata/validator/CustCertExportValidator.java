package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户证件ExportValidator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustCertExportValidator {

    private CustCertExportValidator() {
    }

    /** 校验经理比率。 */
    public static void validateManagerRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerRate 长度不能超过 128");
        }
    }

    /** 校验经理日期。 */
    public static void validateManagerDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerDate 长度不能超过 128");
        }
    }

    /** 校验经理时间。 */
    public static void validateManagerTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerTime 长度不能超过 128");
        }
    }

    /** 校验经理标记。 */
    public static void validateManagerFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerFlag 长度不能超过 128");
        }
    }

    /** 校验经理说明。 */
    public static void validateManagerRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerRemark 长度不能超过 128");
        }
    }

    /** 校验经理来源。 */
    public static void validateManagerSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerSource 长度不能超过 128");
        }
    }

    /** 校验经理版本。 */
    public static void validateManagerVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerVersion 长度不能超过 128");
        }
    }

    /** 校验经理区域。 */
    public static void validateManagerRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerRegion 长度不能超过 128");
        }
    }

    /** 校验经理渠道。 */
    public static void validateManagerChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerChannel 长度不能超过 128");
        }
    }

    /** 校验经理分组。 */
    public static void validateManagerGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerGroup 长度不能超过 128");
        }
    }

    /** 校验经理标签。 */
    public static void validateManagerTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerTag 长度不能超过 128");
        }
    }

    /** 校验经理负责人。 */
    public static void validateManagerOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerOwner 长度不能超过 128");
        }
    }

    /** 校验拜访编号。 */
    public static void validateVisitNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitNo 长度不能超过 128");
        }
    }

    /** 校验拜访名称。 */
    public static void validateVisitName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitName 长度不能超过 128");
        }
    }

    /** 校验拜访类型。 */
    public static void validateVisitType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitType 长度不能超过 128");
        }
    }

    /** 校验拜访编码。 */
    public static void validateVisitCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitCode 长度不能超过 128");
        }
    }

    /** 校验拜访级别。 */
    public static void validateVisitLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitLevel 长度不能超过 128");
        }
    }

    /** 校验拜访状态。 */
    public static void validateVisitStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitStatus 长度不能超过 128");
        }
    }

    /** 校验拜访金额。 */
    public static void validateVisitAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitAmount 长度不能超过 128");
        }
    }

    /** 校验拜访数量。 */
    public static void validateVisitCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitCount 长度不能超过 128");
        }
    }

    /** 校验拜访比率。 */
    public static void validateVisitRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitRate 长度不能超过 128");
        }
    }

    /** 校验拜访日期。 */
    public static void validateVisitDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitDate 长度不能超过 128");
        }
    }

    /** 校验拜访时间。 */
    public static void validateVisitTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitTime 长度不能超过 128");
        }
    }

    /** 校验拜访标记。 */
    public static void validateVisitFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitFlag 长度不能超过 128");
        }
    }

    /** 校验拜访说明。 */
    public static void validateVisitRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitRemark 长度不能超过 128");
        }
    }

    /** 校验拜访来源。 */
    public static void validateVisitSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitSource 长度不能超过 128");
        }
    }

    /** 校验拜访版本。 */
    public static void validateVisitVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitVersion 长度不能超过 128");
        }
    }

    /** 校验拜访区域。 */
    public static void validateVisitRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitRegion 长度不能超过 128");
        }
    }

    /** 校验拜访渠道。 */
    public static void validateVisitChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitChannel 长度不能超过 128");
        }
    }

    /** 校验拜访分组。 */
    public static void validateVisitGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("visitGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("visitGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("visitGroup 长度不能超过 128");
        }
    }

}

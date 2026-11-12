package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户规模ExportValidator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustScaleExportValidator {

    private CustScaleExportValidator() {
    }

    /** 校验信用标签。 */
    public static void validateCreditTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditTag 长度不能超过 128");
        }
    }

    /** 校验信用负责人。 */
    public static void validateCreditOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditOwner 长度不能超过 128");
        }
    }

    /** 校验行业编号。 */
    public static void validateIndustryNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryNo 长度不能超过 128");
        }
    }

    /** 校验行业名称。 */
    public static void validateIndustryName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryName 长度不能超过 128");
        }
    }

    /** 校验行业类型。 */
    public static void validateIndustryType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryType 长度不能超过 128");
        }
    }

    /** 校验行业编码。 */
    public static void validateIndustryCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryCode 长度不能超过 128");
        }
    }

    /** 校验行业级别。 */
    public static void validateIndustryLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryLevel 长度不能超过 128");
        }
    }

    /** 校验行业状态。 */
    public static void validateIndustryStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryStatus 长度不能超过 128");
        }
    }

    /** 校验行业金额。 */
    public static void validateIndustryAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryAmount 长度不能超过 128");
        }
    }

    /** 校验行业数量。 */
    public static void validateIndustryCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryCount 长度不能超过 128");
        }
    }

    /** 校验行业比率。 */
    public static void validateIndustryRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryRate 长度不能超过 128");
        }
    }

    /** 校验行业日期。 */
    public static void validateIndustryDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryDate 长度不能超过 128");
        }
    }

    /** 校验行业时间。 */
    public static void validateIndustryTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryTime 长度不能超过 128");
        }
    }

    /** 校验行业标记。 */
    public static void validateIndustryFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryFlag 长度不能超过 128");
        }
    }

    /** 校验行业说明。 */
    public static void validateIndustryRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryRemark 长度不能超过 128");
        }
    }

    /** 校验行业来源。 */
    public static void validateIndustrySource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industrySource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industrySource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industrySource 长度不能超过 128");
        }
    }

    /** 校验行业版本。 */
    public static void validateIndustryVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryVersion 长度不能超过 128");
        }
    }

    /** 校验行业区域。 */
    public static void validateIndustryRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryRegion 长度不能超过 128");
        }
    }

    /** 校验行业渠道。 */
    public static void validateIndustryChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryChannel 长度不能超过 128");
        }
    }

    /** 校验行业分组。 */
    public static void validateIndustryGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryGroup 长度不能超过 128");
        }
    }

    /** 校验行业标签。 */
    public static void validateIndustryTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryTag 长度不能超过 128");
        }
    }

    /** 校验行业负责人。 */
    public static void validateIndustryOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("industryOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("industryOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("industryOwner 长度不能超过 128");
        }
    }

    /** 校验渠道编号。 */
    public static void validateChannelNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelNo 长度不能超过 128");
        }
    }

    /** 校验渠道名称。 */
    public static void validateChannelName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelName 长度不能超过 128");
        }
    }

    /** 校验渠道类型。 */
    public static void validateChannelType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelType 长度不能超过 128");
        }
    }

    /** 校验渠道编码。 */
    public static void validateChannelCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelCode 长度不能超过 128");
        }
    }

    /** 校验渠道级别。 */
    public static void validateChannelLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelLevel 长度不能超过 128");
        }
    }

    /** 校验渠道状态。 */
    public static void validateChannelStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelStatus 长度不能超过 128");
        }
    }

    /** 校验渠道金额。 */
    public static void validateChannelAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelAmount 长度不能超过 128");
        }
    }

    /** 校验渠道数量。 */
    public static void validateChannelCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelCount 长度不能超过 128");
        }
    }

}

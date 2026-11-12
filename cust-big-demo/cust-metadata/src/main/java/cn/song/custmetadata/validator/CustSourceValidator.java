package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户来源Validator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustSourceValidator {

    private CustSourceValidator() {
    }

    /** 校验渠道时间。 */
    public static void validateChannelTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelTime 长度不能超过 128");
        }
    }

    /** 校验渠道标记。 */
    public static void validateChannelFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelFlag 长度不能超过 128");
        }
    }

    /** 校验渠道说明。 */
    public static void validateChannelRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelRemark 长度不能超过 128");
        }
    }

    /** 校验渠道来源。 */
    public static void validateChannelSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelSource 长度不能超过 128");
        }
    }

    /** 校验渠道版本。 */
    public static void validateChannelVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelVersion 长度不能超过 128");
        }
    }

    /** 校验渠道区域。 */
    public static void validateChannelRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelRegion 长度不能超过 128");
        }
    }

    /** 校验渠道渠道。 */
    public static void validateChannelChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelChannel 长度不能超过 128");
        }
    }

    /** 校验渠道分组。 */
    public static void validateChannelGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelGroup 长度不能超过 128");
        }
    }

    /** 校验渠道标签。 */
    public static void validateChannelTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelTag 长度不能超过 128");
        }
    }

    /** 校验渠道负责人。 */
    public static void validateChannelOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("channelOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("channelOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("channelOwner 长度不能超过 128");
        }
    }

    /** 校验经理编号。 */
    public static void validateManagerNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerNo 长度不能超过 128");
        }
    }

    /** 校验经理名称。 */
    public static void validateManagerName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerName 长度不能超过 128");
        }
    }

    /** 校验经理类型。 */
    public static void validateManagerType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerType 长度不能超过 128");
        }
    }

    /** 校验经理编码。 */
    public static void validateManagerCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerCode 长度不能超过 128");
        }
    }

    /** 校验经理级别。 */
    public static void validateManagerLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerLevel 长度不能超过 128");
        }
    }

    /** 校验经理状态。 */
    public static void validateManagerStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerStatus 长度不能超过 128");
        }
    }

    /** 校验经理金额。 */
    public static void validateManagerAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerAmount 长度不能超过 128");
        }
    }

    /** 校验经理数量。 */
    public static void validateManagerCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("managerCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("managerCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("managerCount 长度不能超过 128");
        }
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

}

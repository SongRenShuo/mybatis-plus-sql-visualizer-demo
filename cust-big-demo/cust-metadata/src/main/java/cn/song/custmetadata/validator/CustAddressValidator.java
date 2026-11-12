package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户地址Validator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustAddressValidator {

    private CustAddressValidator() {
    }

    /** 校验信用编号。 */
    public static void validateCreditNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditNo 长度不能超过 128");
        }
    }

    /** 校验信用名称。 */
    public static void validateCreditName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditName 长度不能超过 128");
        }
    }

    /** 校验信用类型。 */
    public static void validateCreditType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditType 长度不能超过 128");
        }
    }

    /** 校验信用编码。 */
    public static void validateCreditCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditCode 长度不能超过 128");
        }
    }

    /** 校验信用级别。 */
    public static void validateCreditLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditLevel 长度不能超过 128");
        }
    }

    /** 校验信用状态。 */
    public static void validateCreditStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditStatus 长度不能超过 128");
        }
    }

    /** 校验信用金额。 */
    public static void validateCreditAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditAmount 长度不能超过 128");
        }
    }

    /** 校验信用数量。 */
    public static void validateCreditCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditCount 长度不能超过 128");
        }
    }

    /** 校验信用比率。 */
    public static void validateCreditRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditRate 长度不能超过 128");
        }
    }

    /** 校验信用日期。 */
    public static void validateCreditDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditDate 长度不能超过 128");
        }
    }

    /** 校验信用时间。 */
    public static void validateCreditTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditTime 长度不能超过 128");
        }
    }

    /** 校验信用标记。 */
    public static void validateCreditFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditFlag 长度不能超过 128");
        }
    }

    /** 校验信用说明。 */
    public static void validateCreditRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditRemark 长度不能超过 128");
        }
    }

    /** 校验信用来源。 */
    public static void validateCreditSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditSource 长度不能超过 128");
        }
    }

    /** 校验信用版本。 */
    public static void validateCreditVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditVersion 长度不能超过 128");
        }
    }

    /** 校验信用区域。 */
    public static void validateCreditRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditRegion 长度不能超过 128");
        }
    }

    /** 校验信用渠道。 */
    public static void validateCreditChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditChannel 长度不能超过 128");
        }
    }

    /** 校验信用分组。 */
    public static void validateCreditGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("creditGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("creditGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("creditGroup 长度不能超过 128");
        }
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

}

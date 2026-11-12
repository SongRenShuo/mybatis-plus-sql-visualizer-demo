package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户联系方式Validator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustContactValidator {

    private CustContactValidator() {
    }

    /** 校验银行时间。 */
    public static void validateBankTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankTime 长度不能超过 128");
        }
    }

    /** 校验银行标记。 */
    public static void validateBankFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankFlag 长度不能超过 128");
        }
    }

    /** 校验银行说明。 */
    public static void validateBankRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankRemark 长度不能超过 128");
        }
    }

    /** 校验银行来源。 */
    public static void validateBankSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankSource 长度不能超过 128");
        }
    }

    /** 校验银行版本。 */
    public static void validateBankVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankVersion 长度不能超过 128");
        }
    }

    /** 校验银行区域。 */
    public static void validateBankRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankRegion 长度不能超过 128");
        }
    }

    /** 校验银行渠道。 */
    public static void validateBankChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankChannel 长度不能超过 128");
        }
    }

    /** 校验银行分组。 */
    public static void validateBankGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankGroup 长度不能超过 128");
        }
    }

    /** 校验银行标签。 */
    public static void validateBankTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankTag 长度不能超过 128");
        }
    }

    /** 校验银行负责人。 */
    public static void validateBankOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("bankOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("bankOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("bankOwner 长度不能超过 128");
        }
    }

    /** 校验资产编号。 */
    public static void validateAssetNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetNo 长度不能超过 128");
        }
    }

    /** 校验资产名称。 */
    public static void validateAssetName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetName 长度不能超过 128");
        }
    }

    /** 校验资产类型。 */
    public static void validateAssetType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetType 长度不能超过 128");
        }
    }

    /** 校验资产编码。 */
    public static void validateAssetCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetCode 长度不能超过 128");
        }
    }

    /** 校验资产级别。 */
    public static void validateAssetLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetLevel 长度不能超过 128");
        }
    }

    /** 校验资产状态。 */
    public static void validateAssetStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetStatus 长度不能超过 128");
        }
    }

    /** 校验资产金额。 */
    public static void validateAssetAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetAmount 长度不能超过 128");
        }
    }

    /** 校验资产数量。 */
    public static void validateAssetCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetCount 长度不能超过 128");
        }
    }

    /** 校验资产比率。 */
    public static void validateAssetRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetRate 长度不能超过 128");
        }
    }

    /** 校验资产日期。 */
    public static void validateAssetDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetDate 长度不能超过 128");
        }
    }

    /** 校验资产时间。 */
    public static void validateAssetTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetTime 长度不能超过 128");
        }
    }

    /** 校验资产标记。 */
    public static void validateAssetFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetFlag 长度不能超过 128");
        }
    }

    /** 校验资产说明。 */
    public static void validateAssetRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetRemark 长度不能超过 128");
        }
    }

    /** 校验资产来源。 */
    public static void validateAssetSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetSource 长度不能超过 128");
        }
    }

    /** 校验资产版本。 */
    public static void validateAssetVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetVersion 长度不能超过 128");
        }
    }

    /** 校验资产区域。 */
    public static void validateAssetRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetRegion 长度不能超过 128");
        }
    }

    /** 校验资产渠道。 */
    public static void validateAssetChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetChannel 长度不能超过 128");
        }
    }

    /** 校验资产分组。 */
    public static void validateAssetGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetGroup 长度不能超过 128");
        }
    }

    /** 校验资产标签。 */
    public static void validateAssetTag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetTag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetTag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetTag 长度不能超过 128");
        }
    }

    /** 校验资产负责人。 */
    public static void validateAssetOwner(Object value, List<String> errors) {
        if (value == null) {
            errors.add("assetOwner 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("assetOwner 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("assetOwner 长度不能超过 128");
        }
    }

}

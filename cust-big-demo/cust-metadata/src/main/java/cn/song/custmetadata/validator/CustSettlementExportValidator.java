package cn.song.custmetadata.validator;

import java.util.List;

/**
 * 客户结算ExportValidator 字段校验器。
 *
 * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。
 */
public final class CustSettlementExportValidator {

    private CustSettlementExportValidator() {
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

    /** 校验风险编号。 */
    public static void validateRiskNo(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskNo 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskNo 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskNo 长度不能超过 128");
        }
    }

    /** 校验风险名称。 */
    public static void validateRiskName(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskName 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskName 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskName 长度不能超过 128");
        }
    }

    /** 校验风险类型。 */
    public static void validateRiskType(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskType 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskType 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskType 长度不能超过 128");
        }
    }

    /** 校验风险编码。 */
    public static void validateRiskCode(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskCode 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskCode 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskCode 长度不能超过 128");
        }
    }

    /** 校验风险级别。 */
    public static void validateRiskLevel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskLevel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskLevel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskLevel 长度不能超过 128");
        }
    }

    /** 校验风险状态。 */
    public static void validateRiskStatus(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskStatus 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskStatus 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskStatus 长度不能超过 128");
        }
    }

    /** 校验风险金额。 */
    public static void validateRiskAmount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskAmount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskAmount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskAmount 长度不能超过 128");
        }
    }

    /** 校验风险数量。 */
    public static void validateRiskCount(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskCount 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskCount 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskCount 长度不能超过 128");
        }
    }

    /** 校验风险比率。 */
    public static void validateRiskRate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskRate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskRate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskRate 长度不能超过 128");
        }
    }

    /** 校验风险日期。 */
    public static void validateRiskDate(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskDate 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskDate 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskDate 长度不能超过 128");
        }
    }

    /** 校验风险时间。 */
    public static void validateRiskTime(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskTime 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskTime 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskTime 长度不能超过 128");
        }
    }

    /** 校验风险标记。 */
    public static void validateRiskFlag(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskFlag 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskFlag 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskFlag 长度不能超过 128");
        }
    }

    /** 校验风险说明。 */
    public static void validateRiskRemark(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskRemark 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskRemark 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskRemark 长度不能超过 128");
        }
    }

    /** 校验风险来源。 */
    public static void validateRiskSource(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskSource 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskSource 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskSource 长度不能超过 128");
        }
    }

    /** 校验风险版本。 */
    public static void validateRiskVersion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskVersion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskVersion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskVersion 长度不能超过 128");
        }
    }

    /** 校验风险区域。 */
    public static void validateRiskRegion(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskRegion 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskRegion 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskRegion 长度不能超过 128");
        }
    }

    /** 校验风险渠道。 */
    public static void validateRiskChannel(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskChannel 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskChannel 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskChannel 长度不能超过 128");
        }
    }

    /** 校验风险分组。 */
    public static void validateRiskGroup(Object value, List<String> errors) {
        if (value == null) {
            errors.add("riskGroup 不能为空");
            return;
        }
        String text = String.valueOf(value).trim();
        if (text.length() == 0) {
            errors.add("riskGroup 不能为空白");
            return;
        }
        if (text.length() > 128) {
            errors.add("riskGroup 长度不能超过 128");
        }
    }

}

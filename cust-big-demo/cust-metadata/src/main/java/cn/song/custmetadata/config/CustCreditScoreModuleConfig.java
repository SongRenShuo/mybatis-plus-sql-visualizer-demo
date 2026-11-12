package cn.song.custmetadata.config;

/**
 * 客户信用评分ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustCreditScoreModuleConfig {

    public static final String MODULE_CODE = "CUST_CREDIT_SCORE";

    /** 重试次数（资产时间） */
    public static final long RETRY_ASSET_TIME = 5L;

    /** 重试次数（资产标记） */
    public static final long RETRY_ASSET_FLAG = 10L;

    /** 重试次数（资产说明） */
    public static final long RETRY_ASSET_REMARK = 15L;

    /** 重试次数（资产来源） */
    public static final long RETRY_ASSET_SOURCE = 20L;

    /** 重试次数（资产版本） */
    public static final long RETRY_ASSET_VERSION = 25L;

    /** 重试次数（资产区域） */
    public static final long RETRY_ASSET_REGION = 30L;

    /** 重试次数（资产渠道） */
    public static final long RETRY_ASSET_CHANNEL = 35L;

    /** 重试次数（资产分组） */
    public static final long RETRY_ASSET_GROUP = 40L;

    /** 重试次数（资产标签） */
    public static final long RETRY_ASSET_TAG = 45L;

    /** 重试次数（资产负责人） */
    public static final long RETRY_ASSET_OWNER = 50L;

    /** 重试次数（风险编号） */
    public static final long RETRY_RISK_NO = 55L;

    /** 重试次数（风险名称） */
    public static final long RETRY_RISK_NAME = 60L;

    /** 重试次数（风险类型） */
    public static final long RETRY_RISK_TYPE = 65L;

    /** 重试次数（风险编码） */
    public static final long RETRY_RISK_CODE = 70L;

    /** 重试次数（风险级别） */
    public static final long RETRY_RISK_LEVEL = 75L;

    /** 重试次数（风险状态） */
    public static final long RETRY_RISK_STATUS = 80L;

    /** 重试次数（风险金额） */
    public static final long RETRY_RISK_AMOUNT = 85L;

    /** 重试次数（风险数量） */
    public static final long RETRY_RISK_COUNT = 90L;

    /** 重试次数（风险比率） */
    public static final long RETRY_RISK_RATE = 95L;

    /** 重试次数（风险日期） */
    public static final long RETRY_RISK_DATE = 100L;

    /** 重试次数（风险时间） */
    public static final long RETRY_RISK_TIME = 105L;

    /** 重试次数（风险标记） */
    public static final long RETRY_RISK_FLAG = 110L;

    /** 重试次数（风险说明） */
    public static final long RETRY_RISK_REMARK = 115L;

    /** 重试次数（风险来源） */
    public static final long RETRY_RISK_SOURCE = 120L;

    /** 重试次数（风险版本） */
    public static final long RETRY_RISK_VERSION = 125L;

    /** 重试次数（风险区域） */
    public static final long RETRY_RISK_REGION = 130L;

    /** 重试次数（风险渠道） */
    public static final long RETRY_RISK_CHANNEL = 135L;

    /** 重试次数（风险分组） */
    public static final long RETRY_RISK_GROUP = 140L;

    /** 重试次数（风险标签） */
    public static final long RETRY_RISK_TAG = 145L;

    /** 重试次数（风险负责人） */
    public static final long RETRY_RISK_OWNER = 150L;

    /** 重试次数（信用编号） */
    public static final long RETRY_CREDIT_NO = 155L;

    /** 重试次数（信用名称） */
    public static final long RETRY_CREDIT_NAME = 160L;

    /** 重试次数（信用类型） */
    public static final long RETRY_CREDIT_TYPE = 165L;

    /** 重试次数（信用编码） */
    public static final long RETRY_CREDIT_CODE = 170L;

    /** 重试次数（信用级别） */
    public static final long RETRY_CREDIT_LEVEL = 175L;

    /** 重试次数（信用状态） */
    public static final long RETRY_CREDIT_STATUS = 180L;

    /** 重试次数（信用金额） */
    public static final long RETRY_CREDIT_AMOUNT = 185L;

    /** 重试次数（信用数量） */
    public static final long RETRY_CREDIT_COUNT = 190L;

    /** 重试次数（信用比率） */
    public static final long RETRY_CREDIT_RATE = 195L;

    /** 重试次数（信用日期） */
    public static final long RETRY_CREDIT_DATE = 200L;

    /** 重试次数（信用时间） */
    public static final long RETRY_CREDIT_TIME = 205L;

    /** 重试次数（信用标记） */
    public static final long RETRY_CREDIT_FLAG = 210L;

    /** 重试次数（信用说明） */
    public static final long RETRY_CREDIT_REMARK = 215L;

    /** 重试次数（信用来源） */
    public static final long RETRY_CREDIT_SOURCE = 220L;

    /** 重试次数（信用版本） */
    public static final long RETRY_CREDIT_VERSION = 225L;

    /** 重试次数（信用区域） */
    public static final long RETRY_CREDIT_REGION = 230L;

    /** 重试次数（信用渠道） */
    public static final long RETRY_CREDIT_CHANNEL = 235L;

    /** 重试次数（信用分组） */
    public static final long RETRY_CREDIT_GROUP = 240L;

    /** 重试次数（信用标签） */
    public static final long RETRY_CREDIT_TAG = 245L;

    /** 重试次数（信用负责人） */
    public static final long RETRY_CREDIT_OWNER = 250L;

    /** 重试次数（行业编号） */
    public static final long RETRY_INDUSTRY_NO = 255L;

    /** 重试次数（行业名称） */
    public static final long RETRY_INDUSTRY_NAME = 260L;

    /** 重试次数（行业类型） */
    public static final long RETRY_INDUSTRY_TYPE = 265L;

    /** 重试次数（行业编码） */
    public static final long RETRY_INDUSTRY_CODE = 270L;

    /** 重试次数（行业级别） */
    public static final long RETRY_INDUSTRY_LEVEL = 275L;

    /** 重试次数（行业状态） */
    public static final long RETRY_INDUSTRY_STATUS = 280L;

    /** 重试次数（行业金额） */
    public static final long RETRY_INDUSTRY_AMOUNT = 285L;

    /** 重试次数（行业数量） */
    public static final long RETRY_INDUSTRY_COUNT = 290L;

    /** 重试次数（行业比率） */
    public static final long RETRY_INDUSTRY_RATE = 295L;

    /** 重试次数（行业日期） */
    public static final long RETRY_INDUSTRY_DATE = 300L;

    private CustCreditScoreModuleConfig() {
    }

    /** 重试次数（资产时间）。 */
    public static long resolveRetryAssetTime(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_TIME;
        }
        if (requested > RETRY_ASSET_TIME) {
            return RETRY_ASSET_TIME;
        }
        return requested;
    }

    /** 重试次数（资产标记）。 */
    public static long resolveRetryAssetFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_FLAG;
        }
        if (requested > RETRY_ASSET_FLAG) {
            return RETRY_ASSET_FLAG;
        }
        return requested;
    }

    /** 重试次数（资产说明）。 */
    public static long resolveRetryAssetRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_REMARK;
        }
        if (requested > RETRY_ASSET_REMARK) {
            return RETRY_ASSET_REMARK;
        }
        return requested;
    }

    /** 重试次数（资产来源）。 */
    public static long resolveRetryAssetSource(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_SOURCE;
        }
        if (requested > RETRY_ASSET_SOURCE) {
            return RETRY_ASSET_SOURCE;
        }
        return requested;
    }

    /** 重试次数（资产版本）。 */
    public static long resolveRetryAssetVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_VERSION;
        }
        if (requested > RETRY_ASSET_VERSION) {
            return RETRY_ASSET_VERSION;
        }
        return requested;
    }

    /** 重试次数（资产区域）。 */
    public static long resolveRetryAssetRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_REGION;
        }
        if (requested > RETRY_ASSET_REGION) {
            return RETRY_ASSET_REGION;
        }
        return requested;
    }

    /** 重试次数（资产渠道）。 */
    public static long resolveRetryAssetChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_CHANNEL;
        }
        if (requested > RETRY_ASSET_CHANNEL) {
            return RETRY_ASSET_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（资产分组）。 */
    public static long resolveRetryAssetGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_GROUP;
        }
        if (requested > RETRY_ASSET_GROUP) {
            return RETRY_ASSET_GROUP;
        }
        return requested;
    }

    /** 重试次数（资产标签）。 */
    public static long resolveRetryAssetTag(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_TAG;
        }
        if (requested > RETRY_ASSET_TAG) {
            return RETRY_ASSET_TAG;
        }
        return requested;
    }

    /** 重试次数（资产负责人）。 */
    public static long resolveRetryAssetOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_ASSET_OWNER;
        }
        if (requested > RETRY_ASSET_OWNER) {
            return RETRY_ASSET_OWNER;
        }
        return requested;
    }

    /** 重试次数（风险编号）。 */
    public static long resolveRetryRiskNo(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_NO;
        }
        if (requested > RETRY_RISK_NO) {
            return RETRY_RISK_NO;
        }
        return requested;
    }

    /** 重试次数（风险名称）。 */
    public static long resolveRetryRiskName(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_NAME;
        }
        if (requested > RETRY_RISK_NAME) {
            return RETRY_RISK_NAME;
        }
        return requested;
    }

    /** 重试次数（风险类型）。 */
    public static long resolveRetryRiskType(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_TYPE;
        }
        if (requested > RETRY_RISK_TYPE) {
            return RETRY_RISK_TYPE;
        }
        return requested;
    }

    /** 重试次数（风险编码）。 */
    public static long resolveRetryRiskCode(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_CODE;
        }
        if (requested > RETRY_RISK_CODE) {
            return RETRY_RISK_CODE;
        }
        return requested;
    }

    /** 重试次数（风险级别）。 */
    public static long resolveRetryRiskLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_LEVEL;
        }
        if (requested > RETRY_RISK_LEVEL) {
            return RETRY_RISK_LEVEL;
        }
        return requested;
    }

    /** 重试次数（风险状态）。 */
    public static long resolveRetryRiskStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_STATUS;
        }
        if (requested > RETRY_RISK_STATUS) {
            return RETRY_RISK_STATUS;
        }
        return requested;
    }

    /** 重试次数（风险金额）。 */
    public static long resolveRetryRiskAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_AMOUNT;
        }
        if (requested > RETRY_RISK_AMOUNT) {
            return RETRY_RISK_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（风险数量）。 */
    public static long resolveRetryRiskCount(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_COUNT;
        }
        if (requested > RETRY_RISK_COUNT) {
            return RETRY_RISK_COUNT;
        }
        return requested;
    }

    /** 重试次数（风险比率）。 */
    public static long resolveRetryRiskRate(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_RATE;
        }
        if (requested > RETRY_RISK_RATE) {
            return RETRY_RISK_RATE;
        }
        return requested;
    }

    /** 重试次数（风险日期）。 */
    public static long resolveRetryRiskDate(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_DATE;
        }
        if (requested > RETRY_RISK_DATE) {
            return RETRY_RISK_DATE;
        }
        return requested;
    }

}

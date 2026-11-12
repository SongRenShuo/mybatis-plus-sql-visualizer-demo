package cn.song.custmetadata.config;

/**
 * 客户信用评分CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustCreditScoreCacheConfig {

    public static final String MODULE_CODE = "CUST_CREDIT_SCORE_CACHE_CONFIG";

    /** 重试次数（风险编码） */
    public static final long RETRY_RISK_CODE = 5L;

    /** 重试次数（风险级别） */
    public static final long RETRY_RISK_LEVEL = 10L;

    /** 重试次数（风险状态） */
    public static final long RETRY_RISK_STATUS = 15L;

    /** 重试次数（风险金额） */
    public static final long RETRY_RISK_AMOUNT = 20L;

    /** 重试次数（风险数量） */
    public static final long RETRY_RISK_COUNT = 25L;

    /** 重试次数（风险比率） */
    public static final long RETRY_RISK_RATE = 30L;

    /** 重试次数（风险日期） */
    public static final long RETRY_RISK_DATE = 35L;

    /** 重试次数（风险时间） */
    public static final long RETRY_RISK_TIME = 40L;

    /** 重试次数（风险标记） */
    public static final long RETRY_RISK_FLAG = 45L;

    /** 重试次数（风险说明） */
    public static final long RETRY_RISK_REMARK = 50L;

    /** 重试次数（风险来源） */
    public static final long RETRY_RISK_SOURCE = 55L;

    /** 重试次数（风险版本） */
    public static final long RETRY_RISK_VERSION = 60L;

    /** 重试次数（风险区域） */
    public static final long RETRY_RISK_REGION = 65L;

    /** 重试次数（风险渠道） */
    public static final long RETRY_RISK_CHANNEL = 70L;

    /** 重试次数（风险分组） */
    public static final long RETRY_RISK_GROUP = 75L;

    /** 重试次数（风险标签） */
    public static final long RETRY_RISK_TAG = 80L;

    /** 重试次数（风险负责人） */
    public static final long RETRY_RISK_OWNER = 85L;

    /** 重试次数（信用编号） */
    public static final long RETRY_CREDIT_NO = 90L;

    /** 重试次数（信用名称） */
    public static final long RETRY_CREDIT_NAME = 95L;

    /** 重试次数（信用类型） */
    public static final long RETRY_CREDIT_TYPE = 100L;

    /** 重试次数（信用编码） */
    public static final long RETRY_CREDIT_CODE = 105L;

    /** 重试次数（信用级别） */
    public static final long RETRY_CREDIT_LEVEL = 110L;

    /** 重试次数（信用状态） */
    public static final long RETRY_CREDIT_STATUS = 115L;

    /** 重试次数（信用金额） */
    public static final long RETRY_CREDIT_AMOUNT = 120L;

    /** 重试次数（信用数量） */
    public static final long RETRY_CREDIT_COUNT = 125L;

    /** 重试次数（信用比率） */
    public static final long RETRY_CREDIT_RATE = 130L;

    /** 重试次数（信用日期） */
    public static final long RETRY_CREDIT_DATE = 135L;

    /** 重试次数（信用时间） */
    public static final long RETRY_CREDIT_TIME = 140L;

    /** 重试次数（信用标记） */
    public static final long RETRY_CREDIT_FLAG = 145L;

    /** 重试次数（信用说明） */
    public static final long RETRY_CREDIT_REMARK = 150L;

    /** 重试次数（信用来源） */
    public static final long RETRY_CREDIT_SOURCE = 155L;

    /** 重试次数（信用版本） */
    public static final long RETRY_CREDIT_VERSION = 160L;

    /** 重试次数（信用区域） */
    public static final long RETRY_CREDIT_REGION = 165L;

    /** 重试次数（信用渠道） */
    public static final long RETRY_CREDIT_CHANNEL = 170L;

    /** 重试次数（信用分组） */
    public static final long RETRY_CREDIT_GROUP = 175L;

    /** 重试次数（信用标签） */
    public static final long RETRY_CREDIT_TAG = 180L;

    /** 重试次数（信用负责人） */
    public static final long RETRY_CREDIT_OWNER = 185L;

    /** 重试次数（行业编号） */
    public static final long RETRY_INDUSTRY_NO = 190L;

    /** 重试次数（行业名称） */
    public static final long RETRY_INDUSTRY_NAME = 195L;

    /** 重试次数（行业类型） */
    public static final long RETRY_INDUSTRY_TYPE = 200L;

    /** 重试次数（行业编码） */
    public static final long RETRY_INDUSTRY_CODE = 205L;

    /** 重试次数（行业级别） */
    public static final long RETRY_INDUSTRY_LEVEL = 210L;

    /** 重试次数（行业状态） */
    public static final long RETRY_INDUSTRY_STATUS = 215L;

    /** 重试次数（行业金额） */
    public static final long RETRY_INDUSTRY_AMOUNT = 220L;

    /** 重试次数（行业数量） */
    public static final long RETRY_INDUSTRY_COUNT = 225L;

    /** 重试次数（行业比率） */
    public static final long RETRY_INDUSTRY_RATE = 230L;

    /** 重试次数（行业日期） */
    public static final long RETRY_INDUSTRY_DATE = 235L;

    /** 重试次数（行业时间） */
    public static final long RETRY_INDUSTRY_TIME = 240L;

    /** 重试次数（行业标记） */
    public static final long RETRY_INDUSTRY_FLAG = 245L;

    /** 重试次数（行业说明） */
    public static final long RETRY_INDUSTRY_REMARK = 250L;

    /** 重试次数（行业来源） */
    public static final long RETRY_INDUSTRY_SOURCE = 255L;

    /** 重试次数（行业版本） */
    public static final long RETRY_INDUSTRY_VERSION = 260L;

    /** 重试次数（行业区域） */
    public static final long RETRY_INDUSTRY_REGION = 265L;

    /** 重试次数（行业渠道） */
    public static final long RETRY_INDUSTRY_CHANNEL = 270L;

    /** 重试次数（行业分组） */
    public static final long RETRY_INDUSTRY_GROUP = 275L;

    /** 重试次数（行业标签） */
    public static final long RETRY_INDUSTRY_TAG = 280L;

    /** 重试次数（行业负责人） */
    public static final long RETRY_INDUSTRY_OWNER = 285L;

    /** 重试次数（渠道编号） */
    public static final long RETRY_CHANNEL_NO = 290L;

    /** 重试次数（渠道名称） */
    public static final long RETRY_CHANNEL_NAME = 295L;

    /** 重试次数（渠道类型） */
    public static final long RETRY_CHANNEL_TYPE = 300L;

    private CustCreditScoreCacheConfig() {
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

    /** 重试次数（风险时间）。 */
    public static long resolveRetryRiskTime(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_TIME;
        }
        if (requested > RETRY_RISK_TIME) {
            return RETRY_RISK_TIME;
        }
        return requested;
    }

    /** 重试次数（风险标记）。 */
    public static long resolveRetryRiskFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_FLAG;
        }
        if (requested > RETRY_RISK_FLAG) {
            return RETRY_RISK_FLAG;
        }
        return requested;
    }

    /** 重试次数（风险说明）。 */
    public static long resolveRetryRiskRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_REMARK;
        }
        if (requested > RETRY_RISK_REMARK) {
            return RETRY_RISK_REMARK;
        }
        return requested;
    }

    /** 重试次数（风险来源）。 */
    public static long resolveRetryRiskSource(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_SOURCE;
        }
        if (requested > RETRY_RISK_SOURCE) {
            return RETRY_RISK_SOURCE;
        }
        return requested;
    }

    /** 重试次数（风险版本）。 */
    public static long resolveRetryRiskVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_VERSION;
        }
        if (requested > RETRY_RISK_VERSION) {
            return RETRY_RISK_VERSION;
        }
        return requested;
    }

    /** 重试次数（风险区域）。 */
    public static long resolveRetryRiskRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_REGION;
        }
        if (requested > RETRY_RISK_REGION) {
            return RETRY_RISK_REGION;
        }
        return requested;
    }

    /** 重试次数（风险渠道）。 */
    public static long resolveRetryRiskChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_CHANNEL;
        }
        if (requested > RETRY_RISK_CHANNEL) {
            return RETRY_RISK_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（风险分组）。 */
    public static long resolveRetryRiskGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_GROUP;
        }
        if (requested > RETRY_RISK_GROUP) {
            return RETRY_RISK_GROUP;
        }
        return requested;
    }

    /** 重试次数（风险标签）。 */
    public static long resolveRetryRiskTag(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_TAG;
        }
        if (requested > RETRY_RISK_TAG) {
            return RETRY_RISK_TAG;
        }
        return requested;
    }

    /** 重试次数（风险负责人）。 */
    public static long resolveRetryRiskOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_RISK_OWNER;
        }
        if (requested > RETRY_RISK_OWNER) {
            return RETRY_RISK_OWNER;
        }
        return requested;
    }

    /** 重试次数（信用编号）。 */
    public static long resolveRetryCreditNo(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_NO;
        }
        if (requested > RETRY_CREDIT_NO) {
            return RETRY_CREDIT_NO;
        }
        return requested;
    }

    /** 重试次数（信用名称）。 */
    public static long resolveRetryCreditName(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_NAME;
        }
        if (requested > RETRY_CREDIT_NAME) {
            return RETRY_CREDIT_NAME;
        }
        return requested;
    }

    /** 重试次数（信用类型）。 */
    public static long resolveRetryCreditType(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_TYPE;
        }
        if (requested > RETRY_CREDIT_TYPE) {
            return RETRY_CREDIT_TYPE;
        }
        return requested;
    }

}

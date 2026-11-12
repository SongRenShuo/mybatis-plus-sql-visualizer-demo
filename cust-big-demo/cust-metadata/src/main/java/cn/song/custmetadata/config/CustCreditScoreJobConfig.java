package cn.song.custmetadata.config;

/**
 * 客户信用评分JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustCreditScoreJobConfig {

    public static final String MODULE_CODE = "CUST_CREDIT_SCORE_JOB_CONFIG";

    /** 重试次数（风险渠道） */
    public static final long RETRY_RISK_CHANNEL = 5L;

    /** 重试次数（风险分组） */
    public static final long RETRY_RISK_GROUP = 10L;

    /** 重试次数（风险标签） */
    public static final long RETRY_RISK_TAG = 15L;

    /** 重试次数（风险负责人） */
    public static final long RETRY_RISK_OWNER = 20L;

    /** 重试次数（信用编号） */
    public static final long RETRY_CREDIT_NO = 25L;

    /** 重试次数（信用名称） */
    public static final long RETRY_CREDIT_NAME = 30L;

    /** 重试次数（信用类型） */
    public static final long RETRY_CREDIT_TYPE = 35L;

    /** 重试次数（信用编码） */
    public static final long RETRY_CREDIT_CODE = 40L;

    /** 重试次数（信用级别） */
    public static final long RETRY_CREDIT_LEVEL = 45L;

    /** 重试次数（信用状态） */
    public static final long RETRY_CREDIT_STATUS = 50L;

    /** 重试次数（信用金额） */
    public static final long RETRY_CREDIT_AMOUNT = 55L;

    /** 重试次数（信用数量） */
    public static final long RETRY_CREDIT_COUNT = 60L;

    /** 重试次数（信用比率） */
    public static final long RETRY_CREDIT_RATE = 65L;

    /** 重试次数（信用日期） */
    public static final long RETRY_CREDIT_DATE = 70L;

    /** 重试次数（信用时间） */
    public static final long RETRY_CREDIT_TIME = 75L;

    /** 重试次数（信用标记） */
    public static final long RETRY_CREDIT_FLAG = 80L;

    /** 重试次数（信用说明） */
    public static final long RETRY_CREDIT_REMARK = 85L;

    /** 重试次数（信用来源） */
    public static final long RETRY_CREDIT_SOURCE = 90L;

    /** 重试次数（信用版本） */
    public static final long RETRY_CREDIT_VERSION = 95L;

    /** 重试次数（信用区域） */
    public static final long RETRY_CREDIT_REGION = 100L;

    /** 重试次数（信用渠道） */
    public static final long RETRY_CREDIT_CHANNEL = 105L;

    /** 重试次数（信用分组） */
    public static final long RETRY_CREDIT_GROUP = 110L;

    /** 重试次数（信用标签） */
    public static final long RETRY_CREDIT_TAG = 115L;

    /** 重试次数（信用负责人） */
    public static final long RETRY_CREDIT_OWNER = 120L;

    /** 重试次数（行业编号） */
    public static final long RETRY_INDUSTRY_NO = 125L;

    /** 重试次数（行业名称） */
    public static final long RETRY_INDUSTRY_NAME = 130L;

    /** 重试次数（行业类型） */
    public static final long RETRY_INDUSTRY_TYPE = 135L;

    /** 重试次数（行业编码） */
    public static final long RETRY_INDUSTRY_CODE = 140L;

    /** 重试次数（行业级别） */
    public static final long RETRY_INDUSTRY_LEVEL = 145L;

    /** 重试次数（行业状态） */
    public static final long RETRY_INDUSTRY_STATUS = 150L;

    /** 重试次数（行业金额） */
    public static final long RETRY_INDUSTRY_AMOUNT = 155L;

    /** 重试次数（行业数量） */
    public static final long RETRY_INDUSTRY_COUNT = 160L;

    /** 重试次数（行业比率） */
    public static final long RETRY_INDUSTRY_RATE = 165L;

    /** 重试次数（行业日期） */
    public static final long RETRY_INDUSTRY_DATE = 170L;

    /** 重试次数（行业时间） */
    public static final long RETRY_INDUSTRY_TIME = 175L;

    /** 重试次数（行业标记） */
    public static final long RETRY_INDUSTRY_FLAG = 180L;

    /** 重试次数（行业说明） */
    public static final long RETRY_INDUSTRY_REMARK = 185L;

    /** 重试次数（行业来源） */
    public static final long RETRY_INDUSTRY_SOURCE = 190L;

    /** 重试次数（行业版本） */
    public static final long RETRY_INDUSTRY_VERSION = 195L;

    /** 重试次数（行业区域） */
    public static final long RETRY_INDUSTRY_REGION = 200L;

    /** 重试次数（行业渠道） */
    public static final long RETRY_INDUSTRY_CHANNEL = 205L;

    /** 重试次数（行业分组） */
    public static final long RETRY_INDUSTRY_GROUP = 210L;

    /** 重试次数（行业标签） */
    public static final long RETRY_INDUSTRY_TAG = 215L;

    /** 重试次数（行业负责人） */
    public static final long RETRY_INDUSTRY_OWNER = 220L;

    /** 重试次数（渠道编号） */
    public static final long RETRY_CHANNEL_NO = 225L;

    /** 重试次数（渠道名称） */
    public static final long RETRY_CHANNEL_NAME = 230L;

    /** 重试次数（渠道类型） */
    public static final long RETRY_CHANNEL_TYPE = 235L;

    /** 重试次数（渠道编码） */
    public static final long RETRY_CHANNEL_CODE = 240L;

    /** 重试次数（渠道级别） */
    public static final long RETRY_CHANNEL_LEVEL = 245L;

    /** 重试次数（渠道状态） */
    public static final long RETRY_CHANNEL_STATUS = 250L;

    /** 重试次数（渠道金额） */
    public static final long RETRY_CHANNEL_AMOUNT = 255L;

    /** 重试次数（渠道数量） */
    public static final long RETRY_CHANNEL_COUNT = 260L;

    /** 重试次数（渠道比率） */
    public static final long RETRY_CHANNEL_RATE = 265L;

    /** 重试次数（渠道日期） */
    public static final long RETRY_CHANNEL_DATE = 270L;

    /** 重试次数（渠道时间） */
    public static final long RETRY_CHANNEL_TIME = 275L;

    /** 重试次数（渠道标记） */
    public static final long RETRY_CHANNEL_FLAG = 280L;

    /** 重试次数（渠道说明） */
    public static final long RETRY_CHANNEL_REMARK = 285L;

    /** 重试次数（渠道来源） */
    public static final long RETRY_CHANNEL_SOURCE = 290L;

    /** 重试次数（渠道版本） */
    public static final long RETRY_CHANNEL_VERSION = 295L;

    /** 重试次数（渠道区域） */
    public static final long RETRY_CHANNEL_REGION = 300L;

    private CustCreditScoreJobConfig() {
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

    /** 重试次数（信用编码）。 */
    public static long resolveRetryCreditCode(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_CODE;
        }
        if (requested > RETRY_CREDIT_CODE) {
            return RETRY_CREDIT_CODE;
        }
        return requested;
    }

    /** 重试次数（信用级别）。 */
    public static long resolveRetryCreditLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_LEVEL;
        }
        if (requested > RETRY_CREDIT_LEVEL) {
            return RETRY_CREDIT_LEVEL;
        }
        return requested;
    }

    /** 重试次数（信用状态）。 */
    public static long resolveRetryCreditStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_STATUS;
        }
        if (requested > RETRY_CREDIT_STATUS) {
            return RETRY_CREDIT_STATUS;
        }
        return requested;
    }

    /** 重试次数（信用金额）。 */
    public static long resolveRetryCreditAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_AMOUNT;
        }
        if (requested > RETRY_CREDIT_AMOUNT) {
            return RETRY_CREDIT_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（信用数量）。 */
    public static long resolveRetryCreditCount(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_COUNT;
        }
        if (requested > RETRY_CREDIT_COUNT) {
            return RETRY_CREDIT_COUNT;
        }
        return requested;
    }

    /** 重试次数（信用比率）。 */
    public static long resolveRetryCreditRate(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_RATE;
        }
        if (requested > RETRY_CREDIT_RATE) {
            return RETRY_CREDIT_RATE;
        }
        return requested;
    }

    /** 重试次数（信用日期）。 */
    public static long resolveRetryCreditDate(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_DATE;
        }
        if (requested > RETRY_CREDIT_DATE) {
            return RETRY_CREDIT_DATE;
        }
        return requested;
    }

    /** 重试次数（信用时间）。 */
    public static long resolveRetryCreditTime(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_TIME;
        }
        if (requested > RETRY_CREDIT_TIME) {
            return RETRY_CREDIT_TIME;
        }
        return requested;
    }

    /** 重试次数（信用标记）。 */
    public static long resolveRetryCreditFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_FLAG;
        }
        if (requested > RETRY_CREDIT_FLAG) {
            return RETRY_CREDIT_FLAG;
        }
        return requested;
    }

    /** 重试次数（信用说明）。 */
    public static long resolveRetryCreditRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_REMARK;
        }
        if (requested > RETRY_CREDIT_REMARK) {
            return RETRY_CREDIT_REMARK;
        }
        return requested;
    }

    /** 重试次数（信用来源）。 */
    public static long resolveRetryCreditSource(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_SOURCE;
        }
        if (requested > RETRY_CREDIT_SOURCE) {
            return RETRY_CREDIT_SOURCE;
        }
        return requested;
    }

    /** 重试次数（信用版本）。 */
    public static long resolveRetryCreditVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_VERSION;
        }
        if (requested > RETRY_CREDIT_VERSION) {
            return RETRY_CREDIT_VERSION;
        }
        return requested;
    }

    /** 重试次数（信用区域）。 */
    public static long resolveRetryCreditRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_CREDIT_REGION;
        }
        if (requested > RETRY_CREDIT_REGION) {
            return RETRY_CREDIT_REGION;
        }
        return requested;
    }

}

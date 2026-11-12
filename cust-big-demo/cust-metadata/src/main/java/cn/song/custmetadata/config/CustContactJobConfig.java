package cn.song.custmetadata.config;

/**
 * 客户联系方式JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustContactJobConfig {

    public static final String MODULE_CODE = "CUST_CONTACT_JOB_CONFIG";

    /** 单次查询上限（风险级别） */
    public static final long LIMIT_RISK_LEVEL = 5L;

    /** 单次查询上限（风险状态） */
    public static final long LIMIT_RISK_STATUS = 10L;

    /** 单次查询上限（风险金额） */
    public static final long LIMIT_RISK_AMOUNT = 15L;

    /** 单次查询上限（风险数量） */
    public static final long LIMIT_RISK_COUNT = 20L;

    /** 单次查询上限（风险比率） */
    public static final long LIMIT_RISK_RATE = 25L;

    /** 单次查询上限（风险日期） */
    public static final long LIMIT_RISK_DATE = 30L;

    /** 单次查询上限（风险时间） */
    public static final long LIMIT_RISK_TIME = 35L;

    /** 单次查询上限（风险标记） */
    public static final long LIMIT_RISK_FLAG = 40L;

    /** 单次查询上限（风险说明） */
    public static final long LIMIT_RISK_REMARK = 45L;

    /** 单次查询上限（风险来源） */
    public static final long LIMIT_RISK_SOURCE = 50L;

    /** 单次查询上限（风险版本） */
    public static final long LIMIT_RISK_VERSION = 55L;

    /** 单次查询上限（风险区域） */
    public static final long LIMIT_RISK_REGION = 60L;

    /** 单次查询上限（风险渠道） */
    public static final long LIMIT_RISK_CHANNEL = 65L;

    /** 单次查询上限（风险分组） */
    public static final long LIMIT_RISK_GROUP = 70L;

    /** 单次查询上限（风险标签） */
    public static final long LIMIT_RISK_TAG = 75L;

    /** 单次查询上限（风险负责人） */
    public static final long LIMIT_RISK_OWNER = 80L;

    /** 单次查询上限（信用编号） */
    public static final long LIMIT_CREDIT_NO = 85L;

    /** 单次查询上限（信用名称） */
    public static final long LIMIT_CREDIT_NAME = 90L;

    /** 单次查询上限（信用类型） */
    public static final long LIMIT_CREDIT_TYPE = 95L;

    /** 单次查询上限（信用编码） */
    public static final long LIMIT_CREDIT_CODE = 100L;

    /** 单次查询上限（信用级别） */
    public static final long LIMIT_CREDIT_LEVEL = 105L;

    /** 单次查询上限（信用状态） */
    public static final long LIMIT_CREDIT_STATUS = 110L;

    /** 单次查询上限（信用金额） */
    public static final long LIMIT_CREDIT_AMOUNT = 115L;

    /** 单次查询上限（信用数量） */
    public static final long LIMIT_CREDIT_COUNT = 120L;

    /** 单次查询上限（信用比率） */
    public static final long LIMIT_CREDIT_RATE = 125L;

    /** 单次查询上限（信用日期） */
    public static final long LIMIT_CREDIT_DATE = 130L;

    /** 单次查询上限（信用时间） */
    public static final long LIMIT_CREDIT_TIME = 135L;

    /** 单次查询上限（信用标记） */
    public static final long LIMIT_CREDIT_FLAG = 140L;

    /** 单次查询上限（信用说明） */
    public static final long LIMIT_CREDIT_REMARK = 145L;

    /** 单次查询上限（信用来源） */
    public static final long LIMIT_CREDIT_SOURCE = 150L;

    /** 单次查询上限（信用版本） */
    public static final long LIMIT_CREDIT_VERSION = 155L;

    /** 单次查询上限（信用区域） */
    public static final long LIMIT_CREDIT_REGION = 160L;

    /** 单次查询上限（信用渠道） */
    public static final long LIMIT_CREDIT_CHANNEL = 165L;

    /** 单次查询上限（信用分组） */
    public static final long LIMIT_CREDIT_GROUP = 170L;

    /** 单次查询上限（信用标签） */
    public static final long LIMIT_CREDIT_TAG = 175L;

    /** 单次查询上限（信用负责人） */
    public static final long LIMIT_CREDIT_OWNER = 180L;

    /** 单次查询上限（行业编号） */
    public static final long LIMIT_INDUSTRY_NO = 185L;

    /** 单次查询上限（行业名称） */
    public static final long LIMIT_INDUSTRY_NAME = 190L;

    /** 单次查询上限（行业类型） */
    public static final long LIMIT_INDUSTRY_TYPE = 195L;

    /** 单次查询上限（行业编码） */
    public static final long LIMIT_INDUSTRY_CODE = 200L;

    /** 单次查询上限（行业级别） */
    public static final long LIMIT_INDUSTRY_LEVEL = 205L;

    /** 单次查询上限（行业状态） */
    public static final long LIMIT_INDUSTRY_STATUS = 210L;

    /** 单次查询上限（行业金额） */
    public static final long LIMIT_INDUSTRY_AMOUNT = 215L;

    /** 单次查询上限（行业数量） */
    public static final long LIMIT_INDUSTRY_COUNT = 220L;

    /** 单次查询上限（行业比率） */
    public static final long LIMIT_INDUSTRY_RATE = 225L;

    /** 单次查询上限（行业日期） */
    public static final long LIMIT_INDUSTRY_DATE = 230L;

    /** 单次查询上限（行业时间） */
    public static final long LIMIT_INDUSTRY_TIME = 235L;

    /** 单次查询上限（行业标记） */
    public static final long LIMIT_INDUSTRY_FLAG = 240L;

    /** 单次查询上限（行业说明） */
    public static final long LIMIT_INDUSTRY_REMARK = 245L;

    /** 单次查询上限（行业来源） */
    public static final long LIMIT_INDUSTRY_SOURCE = 250L;

    /** 单次查询上限（行业版本） */
    public static final long LIMIT_INDUSTRY_VERSION = 255L;

    /** 单次查询上限（行业区域） */
    public static final long LIMIT_INDUSTRY_REGION = 260L;

    /** 单次查询上限（行业渠道） */
    public static final long LIMIT_INDUSTRY_CHANNEL = 265L;

    /** 单次查询上限（行业分组） */
    public static final long LIMIT_INDUSTRY_GROUP = 270L;

    /** 单次查询上限（行业标签） */
    public static final long LIMIT_INDUSTRY_TAG = 275L;

    /** 单次查询上限（行业负责人） */
    public static final long LIMIT_INDUSTRY_OWNER = 280L;

    /** 单次查询上限（渠道编号） */
    public static final long LIMIT_CHANNEL_NO = 285L;

    /** 单次查询上限（渠道名称） */
    public static final long LIMIT_CHANNEL_NAME = 290L;

    /** 单次查询上限（渠道类型） */
    public static final long LIMIT_CHANNEL_TYPE = 295L;

    /** 单次查询上限（渠道编码） */
    public static final long LIMIT_CHANNEL_CODE = 300L;

    private CustContactJobConfig() {
    }

    /** 单次查询上限（风险级别）。 */
    public static long resolveLimitRiskLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_LEVEL;
        }
        if (requested > LIMIT_RISK_LEVEL) {
            return LIMIT_RISK_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（风险状态）。 */
    public static long resolveLimitRiskStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_STATUS;
        }
        if (requested > LIMIT_RISK_STATUS) {
            return LIMIT_RISK_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（风险金额）。 */
    public static long resolveLimitRiskAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_AMOUNT;
        }
        if (requested > LIMIT_RISK_AMOUNT) {
            return LIMIT_RISK_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（风险数量）。 */
    public static long resolveLimitRiskCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_COUNT;
        }
        if (requested > LIMIT_RISK_COUNT) {
            return LIMIT_RISK_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（风险比率）。 */
    public static long resolveLimitRiskRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_RATE;
        }
        if (requested > LIMIT_RISK_RATE) {
            return LIMIT_RISK_RATE;
        }
        return requested;
    }

    /** 单次查询上限（风险日期）。 */
    public static long resolveLimitRiskDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_DATE;
        }
        if (requested > LIMIT_RISK_DATE) {
            return LIMIT_RISK_DATE;
        }
        return requested;
    }

    /** 单次查询上限（风险时间）。 */
    public static long resolveLimitRiskTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_TIME;
        }
        if (requested > LIMIT_RISK_TIME) {
            return LIMIT_RISK_TIME;
        }
        return requested;
    }

    /** 单次查询上限（风险标记）。 */
    public static long resolveLimitRiskFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_FLAG;
        }
        if (requested > LIMIT_RISK_FLAG) {
            return LIMIT_RISK_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（风险说明）。 */
    public static long resolveLimitRiskRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_REMARK;
        }
        if (requested > LIMIT_RISK_REMARK) {
            return LIMIT_RISK_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（风险来源）。 */
    public static long resolveLimitRiskSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_SOURCE;
        }
        if (requested > LIMIT_RISK_SOURCE) {
            return LIMIT_RISK_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（风险版本）。 */
    public static long resolveLimitRiskVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_VERSION;
        }
        if (requested > LIMIT_RISK_VERSION) {
            return LIMIT_RISK_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（风险区域）。 */
    public static long resolveLimitRiskRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_REGION;
        }
        if (requested > LIMIT_RISK_REGION) {
            return LIMIT_RISK_REGION;
        }
        return requested;
    }

    /** 单次查询上限（风险渠道）。 */
    public static long resolveLimitRiskChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_CHANNEL;
        }
        if (requested > LIMIT_RISK_CHANNEL) {
            return LIMIT_RISK_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（风险分组）。 */
    public static long resolveLimitRiskGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_GROUP;
        }
        if (requested > LIMIT_RISK_GROUP) {
            return LIMIT_RISK_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（风险标签）。 */
    public static long resolveLimitRiskTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_TAG;
        }
        if (requested > LIMIT_RISK_TAG) {
            return LIMIT_RISK_TAG;
        }
        return requested;
    }

    /** 单次查询上限（风险负责人）。 */
    public static long resolveLimitRiskOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_OWNER;
        }
        if (requested > LIMIT_RISK_OWNER) {
            return LIMIT_RISK_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（信用编号）。 */
    public static long resolveLimitCreditNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_CREDIT_NO;
        }
        if (requested > LIMIT_CREDIT_NO) {
            return LIMIT_CREDIT_NO;
        }
        return requested;
    }

    /** 单次查询上限（信用名称）。 */
    public static long resolveLimitCreditName(long requested) {
        if (requested <= 0L) {
            return LIMIT_CREDIT_NAME;
        }
        if (requested > LIMIT_CREDIT_NAME) {
            return LIMIT_CREDIT_NAME;
        }
        return requested;
    }

    /** 单次查询上限（信用类型）。 */
    public static long resolveLimitCreditType(long requested) {
        if (requested <= 0L) {
            return LIMIT_CREDIT_TYPE;
        }
        if (requested > LIMIT_CREDIT_TYPE) {
            return LIMIT_CREDIT_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（信用编码）。 */
    public static long resolveLimitCreditCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_CREDIT_CODE;
        }
        if (requested > LIMIT_CREDIT_CODE) {
            return LIMIT_CREDIT_CODE;
        }
        return requested;
    }

}

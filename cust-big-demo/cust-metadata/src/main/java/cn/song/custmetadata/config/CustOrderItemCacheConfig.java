package cn.song.custmetadata.config;

/**
 * 客户订单明细CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustOrderItemCacheConfig {

    public static final String MODULE_CODE = "CUST_ORDER_ITEM_CACHE_CONFIG";

    /** 批处理条数（风险区域） */
    public static final long BATCH_RISK_REGION = 5L;

    /** 批处理条数（风险渠道） */
    public static final long BATCH_RISK_CHANNEL = 10L;

    /** 批处理条数（风险分组） */
    public static final long BATCH_RISK_GROUP = 15L;

    /** 批处理条数（风险标签） */
    public static final long BATCH_RISK_TAG = 20L;

    /** 批处理条数（风险负责人） */
    public static final long BATCH_RISK_OWNER = 25L;

    /** 批处理条数（信用编号） */
    public static final long BATCH_CREDIT_NO = 30L;

    /** 批处理条数（信用名称） */
    public static final long BATCH_CREDIT_NAME = 35L;

    /** 批处理条数（信用类型） */
    public static final long BATCH_CREDIT_TYPE = 40L;

    /** 批处理条数（信用编码） */
    public static final long BATCH_CREDIT_CODE = 45L;

    /** 批处理条数（信用级别） */
    public static final long BATCH_CREDIT_LEVEL = 50L;

    /** 批处理条数（信用状态） */
    public static final long BATCH_CREDIT_STATUS = 55L;

    /** 批处理条数（信用金额） */
    public static final long BATCH_CREDIT_AMOUNT = 60L;

    /** 批处理条数（信用数量） */
    public static final long BATCH_CREDIT_COUNT = 65L;

    /** 批处理条数（信用比率） */
    public static final long BATCH_CREDIT_RATE = 70L;

    /** 批处理条数（信用日期） */
    public static final long BATCH_CREDIT_DATE = 75L;

    /** 批处理条数（信用时间） */
    public static final long BATCH_CREDIT_TIME = 80L;

    /** 批处理条数（信用标记） */
    public static final long BATCH_CREDIT_FLAG = 85L;

    /** 批处理条数（信用说明） */
    public static final long BATCH_CREDIT_REMARK = 90L;

    /** 批处理条数（信用来源） */
    public static final long BATCH_CREDIT_SOURCE = 95L;

    /** 批处理条数（信用版本） */
    public static final long BATCH_CREDIT_VERSION = 100L;

    /** 批处理条数（信用区域） */
    public static final long BATCH_CREDIT_REGION = 105L;

    /** 批处理条数（信用渠道） */
    public static final long BATCH_CREDIT_CHANNEL = 110L;

    /** 批处理条数（信用分组） */
    public static final long BATCH_CREDIT_GROUP = 115L;

    /** 批处理条数（信用标签） */
    public static final long BATCH_CREDIT_TAG = 120L;

    /** 批处理条数（信用负责人） */
    public static final long BATCH_CREDIT_OWNER = 125L;

    /** 批处理条数（行业编号） */
    public static final long BATCH_INDUSTRY_NO = 130L;

    /** 批处理条数（行业名称） */
    public static final long BATCH_INDUSTRY_NAME = 135L;

    /** 批处理条数（行业类型） */
    public static final long BATCH_INDUSTRY_TYPE = 140L;

    /** 批处理条数（行业编码） */
    public static final long BATCH_INDUSTRY_CODE = 145L;

    /** 批处理条数（行业级别） */
    public static final long BATCH_INDUSTRY_LEVEL = 150L;

    /** 批处理条数（行业状态） */
    public static final long BATCH_INDUSTRY_STATUS = 155L;

    /** 批处理条数（行业金额） */
    public static final long BATCH_INDUSTRY_AMOUNT = 160L;

    /** 批处理条数（行业数量） */
    public static final long BATCH_INDUSTRY_COUNT = 165L;

    /** 批处理条数（行业比率） */
    public static final long BATCH_INDUSTRY_RATE = 170L;

    /** 批处理条数（行业日期） */
    public static final long BATCH_INDUSTRY_DATE = 175L;

    /** 批处理条数（行业时间） */
    public static final long BATCH_INDUSTRY_TIME = 180L;

    /** 批处理条数（行业标记） */
    public static final long BATCH_INDUSTRY_FLAG = 185L;

    /** 批处理条数（行业说明） */
    public static final long BATCH_INDUSTRY_REMARK = 190L;

    /** 批处理条数（行业来源） */
    public static final long BATCH_INDUSTRY_SOURCE = 195L;

    /** 批处理条数（行业版本） */
    public static final long BATCH_INDUSTRY_VERSION = 200L;

    /** 批处理条数（行业区域） */
    public static final long BATCH_INDUSTRY_REGION = 205L;

    /** 批处理条数（行业渠道） */
    public static final long BATCH_INDUSTRY_CHANNEL = 210L;

    /** 批处理条数（行业分组） */
    public static final long BATCH_INDUSTRY_GROUP = 215L;

    /** 批处理条数（行业标签） */
    public static final long BATCH_INDUSTRY_TAG = 220L;

    /** 批处理条数（行业负责人） */
    public static final long BATCH_INDUSTRY_OWNER = 225L;

    /** 批处理条数（渠道编号） */
    public static final long BATCH_CHANNEL_NO = 230L;

    /** 批处理条数（渠道名称） */
    public static final long BATCH_CHANNEL_NAME = 235L;

    /** 批处理条数（渠道类型） */
    public static final long BATCH_CHANNEL_TYPE = 240L;

    /** 批处理条数（渠道编码） */
    public static final long BATCH_CHANNEL_CODE = 245L;

    /** 批处理条数（渠道级别） */
    public static final long BATCH_CHANNEL_LEVEL = 250L;

    /** 批处理条数（渠道状态） */
    public static final long BATCH_CHANNEL_STATUS = 255L;

    /** 批处理条数（渠道金额） */
    public static final long BATCH_CHANNEL_AMOUNT = 260L;

    /** 批处理条数（渠道数量） */
    public static final long BATCH_CHANNEL_COUNT = 265L;

    /** 批处理条数（渠道比率） */
    public static final long BATCH_CHANNEL_RATE = 270L;

    /** 批处理条数（渠道日期） */
    public static final long BATCH_CHANNEL_DATE = 275L;

    /** 批处理条数（渠道时间） */
    public static final long BATCH_CHANNEL_TIME = 280L;

    /** 批处理条数（渠道标记） */
    public static final long BATCH_CHANNEL_FLAG = 285L;

    /** 批处理条数（渠道说明） */
    public static final long BATCH_CHANNEL_REMARK = 290L;

    /** 批处理条数（渠道来源） */
    public static final long BATCH_CHANNEL_SOURCE = 295L;

    /** 批处理条数（渠道版本） */
    public static final long BATCH_CHANNEL_VERSION = 300L;

    private CustOrderItemCacheConfig() {
    }

    /** 批处理条数（风险区域）。 */
    public static long resolveBatchRiskRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_RISK_REGION;
        }
        if (requested > BATCH_RISK_REGION) {
            return BATCH_RISK_REGION;
        }
        return requested;
    }

    /** 批处理条数（风险渠道）。 */
    public static long resolveBatchRiskChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_RISK_CHANNEL;
        }
        if (requested > BATCH_RISK_CHANNEL) {
            return BATCH_RISK_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（风险分组）。 */
    public static long resolveBatchRiskGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_RISK_GROUP;
        }
        if (requested > BATCH_RISK_GROUP) {
            return BATCH_RISK_GROUP;
        }
        return requested;
    }

    /** 批处理条数（风险标签）。 */
    public static long resolveBatchRiskTag(long requested) {
        if (requested <= 0L) {
            return BATCH_RISK_TAG;
        }
        if (requested > BATCH_RISK_TAG) {
            return BATCH_RISK_TAG;
        }
        return requested;
    }

    /** 批处理条数（风险负责人）。 */
    public static long resolveBatchRiskOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_RISK_OWNER;
        }
        if (requested > BATCH_RISK_OWNER) {
            return BATCH_RISK_OWNER;
        }
        return requested;
    }

    /** 批处理条数（信用编号）。 */
    public static long resolveBatchCreditNo(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_NO;
        }
        if (requested > BATCH_CREDIT_NO) {
            return BATCH_CREDIT_NO;
        }
        return requested;
    }

    /** 批处理条数（信用名称）。 */
    public static long resolveBatchCreditName(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_NAME;
        }
        if (requested > BATCH_CREDIT_NAME) {
            return BATCH_CREDIT_NAME;
        }
        return requested;
    }

    /** 批处理条数（信用类型）。 */
    public static long resolveBatchCreditType(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_TYPE;
        }
        if (requested > BATCH_CREDIT_TYPE) {
            return BATCH_CREDIT_TYPE;
        }
        return requested;
    }

    /** 批处理条数（信用编码）。 */
    public static long resolveBatchCreditCode(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_CODE;
        }
        if (requested > BATCH_CREDIT_CODE) {
            return BATCH_CREDIT_CODE;
        }
        return requested;
    }

    /** 批处理条数（信用级别）。 */
    public static long resolveBatchCreditLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_LEVEL;
        }
        if (requested > BATCH_CREDIT_LEVEL) {
            return BATCH_CREDIT_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（信用状态）。 */
    public static long resolveBatchCreditStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_STATUS;
        }
        if (requested > BATCH_CREDIT_STATUS) {
            return BATCH_CREDIT_STATUS;
        }
        return requested;
    }

    /** 批处理条数（信用金额）。 */
    public static long resolveBatchCreditAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_AMOUNT;
        }
        if (requested > BATCH_CREDIT_AMOUNT) {
            return BATCH_CREDIT_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（信用数量）。 */
    public static long resolveBatchCreditCount(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_COUNT;
        }
        if (requested > BATCH_CREDIT_COUNT) {
            return BATCH_CREDIT_COUNT;
        }
        return requested;
    }

    /** 批处理条数（信用比率）。 */
    public static long resolveBatchCreditRate(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_RATE;
        }
        if (requested > BATCH_CREDIT_RATE) {
            return BATCH_CREDIT_RATE;
        }
        return requested;
    }

    /** 批处理条数（信用日期）。 */
    public static long resolveBatchCreditDate(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_DATE;
        }
        if (requested > BATCH_CREDIT_DATE) {
            return BATCH_CREDIT_DATE;
        }
        return requested;
    }

    /** 批处理条数（信用时间）。 */
    public static long resolveBatchCreditTime(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_TIME;
        }
        if (requested > BATCH_CREDIT_TIME) {
            return BATCH_CREDIT_TIME;
        }
        return requested;
    }

    /** 批处理条数（信用标记）。 */
    public static long resolveBatchCreditFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_FLAG;
        }
        if (requested > BATCH_CREDIT_FLAG) {
            return BATCH_CREDIT_FLAG;
        }
        return requested;
    }

    /** 批处理条数（信用说明）。 */
    public static long resolveBatchCreditRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_REMARK;
        }
        if (requested > BATCH_CREDIT_REMARK) {
            return BATCH_CREDIT_REMARK;
        }
        return requested;
    }

    /** 批处理条数（信用来源）。 */
    public static long resolveBatchCreditSource(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_SOURCE;
        }
        if (requested > BATCH_CREDIT_SOURCE) {
            return BATCH_CREDIT_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（信用版本）。 */
    public static long resolveBatchCreditVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_VERSION;
        }
        if (requested > BATCH_CREDIT_VERSION) {
            return BATCH_CREDIT_VERSION;
        }
        return requested;
    }

}

package cn.song.custmetadata.config;

/**
 * 客户订单明细JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustOrderItemJobConfig {

    public static final String MODULE_CODE = "CUST_ORDER_ITEM_JOB_CONFIG";

    /** 批处理条数（信用比率） */
    public static final long BATCH_CREDIT_RATE = 5L;

    /** 批处理条数（信用日期） */
    public static final long BATCH_CREDIT_DATE = 10L;

    /** 批处理条数（信用时间） */
    public static final long BATCH_CREDIT_TIME = 15L;

    /** 批处理条数（信用标记） */
    public static final long BATCH_CREDIT_FLAG = 20L;

    /** 批处理条数（信用说明） */
    public static final long BATCH_CREDIT_REMARK = 25L;

    /** 批处理条数（信用来源） */
    public static final long BATCH_CREDIT_SOURCE = 30L;

    /** 批处理条数（信用版本） */
    public static final long BATCH_CREDIT_VERSION = 35L;

    /** 批处理条数（信用区域） */
    public static final long BATCH_CREDIT_REGION = 40L;

    /** 批处理条数（信用渠道） */
    public static final long BATCH_CREDIT_CHANNEL = 45L;

    /** 批处理条数（信用分组） */
    public static final long BATCH_CREDIT_GROUP = 50L;

    /** 批处理条数（信用标签） */
    public static final long BATCH_CREDIT_TAG = 55L;

    /** 批处理条数（信用负责人） */
    public static final long BATCH_CREDIT_OWNER = 60L;

    /** 批处理条数（行业编号） */
    public static final long BATCH_INDUSTRY_NO = 65L;

    /** 批处理条数（行业名称） */
    public static final long BATCH_INDUSTRY_NAME = 70L;

    /** 批处理条数（行业类型） */
    public static final long BATCH_INDUSTRY_TYPE = 75L;

    /** 批处理条数（行业编码） */
    public static final long BATCH_INDUSTRY_CODE = 80L;

    /** 批处理条数（行业级别） */
    public static final long BATCH_INDUSTRY_LEVEL = 85L;

    /** 批处理条数（行业状态） */
    public static final long BATCH_INDUSTRY_STATUS = 90L;

    /** 批处理条数（行业金额） */
    public static final long BATCH_INDUSTRY_AMOUNT = 95L;

    /** 批处理条数（行业数量） */
    public static final long BATCH_INDUSTRY_COUNT = 100L;

    /** 批处理条数（行业比率） */
    public static final long BATCH_INDUSTRY_RATE = 105L;

    /** 批处理条数（行业日期） */
    public static final long BATCH_INDUSTRY_DATE = 110L;

    /** 批处理条数（行业时间） */
    public static final long BATCH_INDUSTRY_TIME = 115L;

    /** 批处理条数（行业标记） */
    public static final long BATCH_INDUSTRY_FLAG = 120L;

    /** 批处理条数（行业说明） */
    public static final long BATCH_INDUSTRY_REMARK = 125L;

    /** 批处理条数（行业来源） */
    public static final long BATCH_INDUSTRY_SOURCE = 130L;

    /** 批处理条数（行业版本） */
    public static final long BATCH_INDUSTRY_VERSION = 135L;

    /** 批处理条数（行业区域） */
    public static final long BATCH_INDUSTRY_REGION = 140L;

    /** 批处理条数（行业渠道） */
    public static final long BATCH_INDUSTRY_CHANNEL = 145L;

    /** 批处理条数（行业分组） */
    public static final long BATCH_INDUSTRY_GROUP = 150L;

    /** 批处理条数（行业标签） */
    public static final long BATCH_INDUSTRY_TAG = 155L;

    /** 批处理条数（行业负责人） */
    public static final long BATCH_INDUSTRY_OWNER = 160L;

    /** 批处理条数（渠道编号） */
    public static final long BATCH_CHANNEL_NO = 165L;

    /** 批处理条数（渠道名称） */
    public static final long BATCH_CHANNEL_NAME = 170L;

    /** 批处理条数（渠道类型） */
    public static final long BATCH_CHANNEL_TYPE = 175L;

    /** 批处理条数（渠道编码） */
    public static final long BATCH_CHANNEL_CODE = 180L;

    /** 批处理条数（渠道级别） */
    public static final long BATCH_CHANNEL_LEVEL = 185L;

    /** 批处理条数（渠道状态） */
    public static final long BATCH_CHANNEL_STATUS = 190L;

    /** 批处理条数（渠道金额） */
    public static final long BATCH_CHANNEL_AMOUNT = 195L;

    /** 批处理条数（渠道数量） */
    public static final long BATCH_CHANNEL_COUNT = 200L;

    /** 批处理条数（渠道比率） */
    public static final long BATCH_CHANNEL_RATE = 205L;

    /** 批处理条数（渠道日期） */
    public static final long BATCH_CHANNEL_DATE = 210L;

    /** 批处理条数（渠道时间） */
    public static final long BATCH_CHANNEL_TIME = 215L;

    /** 批处理条数（渠道标记） */
    public static final long BATCH_CHANNEL_FLAG = 220L;

    /** 批处理条数（渠道说明） */
    public static final long BATCH_CHANNEL_REMARK = 225L;

    /** 批处理条数（渠道来源） */
    public static final long BATCH_CHANNEL_SOURCE = 230L;

    /** 批处理条数（渠道版本） */
    public static final long BATCH_CHANNEL_VERSION = 235L;

    /** 批处理条数（渠道区域） */
    public static final long BATCH_CHANNEL_REGION = 240L;

    /** 批处理条数（渠道渠道） */
    public static final long BATCH_CHANNEL_CHANNEL = 245L;

    /** 批处理条数（渠道分组） */
    public static final long BATCH_CHANNEL_GROUP = 250L;

    /** 批处理条数（渠道标签） */
    public static final long BATCH_CHANNEL_TAG = 255L;

    /** 批处理条数（渠道负责人） */
    public static final long BATCH_CHANNEL_OWNER = 260L;

    /** 批处理条数（经理编号） */
    public static final long BATCH_MANAGER_NO = 265L;

    /** 批处理条数（经理名称） */
    public static final long BATCH_MANAGER_NAME = 270L;

    /** 批处理条数（经理类型） */
    public static final long BATCH_MANAGER_TYPE = 275L;

    /** 批处理条数（经理编码） */
    public static final long BATCH_MANAGER_CODE = 280L;

    /** 批处理条数（经理级别） */
    public static final long BATCH_MANAGER_LEVEL = 285L;

    /** 批处理条数（经理状态） */
    public static final long BATCH_MANAGER_STATUS = 290L;

    /** 批处理条数（经理金额） */
    public static final long BATCH_MANAGER_AMOUNT = 295L;

    /** 批处理条数（经理数量） */
    public static final long BATCH_MANAGER_COUNT = 300L;

    private CustOrderItemJobConfig() {
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

    /** 批处理条数（信用区域）。 */
    public static long resolveBatchCreditRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_REGION;
        }
        if (requested > BATCH_CREDIT_REGION) {
            return BATCH_CREDIT_REGION;
        }
        return requested;
    }

    /** 批处理条数（信用渠道）。 */
    public static long resolveBatchCreditChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_CHANNEL;
        }
        if (requested > BATCH_CREDIT_CHANNEL) {
            return BATCH_CREDIT_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（信用分组）。 */
    public static long resolveBatchCreditGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_GROUP;
        }
        if (requested > BATCH_CREDIT_GROUP) {
            return BATCH_CREDIT_GROUP;
        }
        return requested;
    }

    /** 批处理条数（信用标签）。 */
    public static long resolveBatchCreditTag(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_TAG;
        }
        if (requested > BATCH_CREDIT_TAG) {
            return BATCH_CREDIT_TAG;
        }
        return requested;
    }

    /** 批处理条数（信用负责人）。 */
    public static long resolveBatchCreditOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_CREDIT_OWNER;
        }
        if (requested > BATCH_CREDIT_OWNER) {
            return BATCH_CREDIT_OWNER;
        }
        return requested;
    }

    /** 批处理条数（行业编号）。 */
    public static long resolveBatchIndustryNo(long requested) {
        if (requested <= 0L) {
            return BATCH_INDUSTRY_NO;
        }
        if (requested > BATCH_INDUSTRY_NO) {
            return BATCH_INDUSTRY_NO;
        }
        return requested;
    }

    /** 批处理条数（行业名称）。 */
    public static long resolveBatchIndustryName(long requested) {
        if (requested <= 0L) {
            return BATCH_INDUSTRY_NAME;
        }
        if (requested > BATCH_INDUSTRY_NAME) {
            return BATCH_INDUSTRY_NAME;
        }
        return requested;
    }

    /** 批处理条数（行业类型）。 */
    public static long resolveBatchIndustryType(long requested) {
        if (requested <= 0L) {
            return BATCH_INDUSTRY_TYPE;
        }
        if (requested > BATCH_INDUSTRY_TYPE) {
            return BATCH_INDUSTRY_TYPE;
        }
        return requested;
    }

    /** 批处理条数（行业编码）。 */
    public static long resolveBatchIndustryCode(long requested) {
        if (requested <= 0L) {
            return BATCH_INDUSTRY_CODE;
        }
        if (requested > BATCH_INDUSTRY_CODE) {
            return BATCH_INDUSTRY_CODE;
        }
        return requested;
    }

    /** 批处理条数（行业级别）。 */
    public static long resolveBatchIndustryLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_INDUSTRY_LEVEL;
        }
        if (requested > BATCH_INDUSTRY_LEVEL) {
            return BATCH_INDUSTRY_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（行业状态）。 */
    public static long resolveBatchIndustryStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_INDUSTRY_STATUS;
        }
        if (requested > BATCH_INDUSTRY_STATUS) {
            return BATCH_INDUSTRY_STATUS;
        }
        return requested;
    }

    /** 批处理条数（行业金额）。 */
    public static long resolveBatchIndustryAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_INDUSTRY_AMOUNT;
        }
        if (requested > BATCH_INDUSTRY_AMOUNT) {
            return BATCH_INDUSTRY_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（行业数量）。 */
    public static long resolveBatchIndustryCount(long requested) {
        if (requested <= 0L) {
            return BATCH_INDUSTRY_COUNT;
        }
        if (requested > BATCH_INDUSTRY_COUNT) {
            return BATCH_INDUSTRY_COUNT;
        }
        return requested;
    }

}

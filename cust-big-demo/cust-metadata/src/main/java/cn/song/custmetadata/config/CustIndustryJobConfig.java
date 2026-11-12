package cn.song.custmetadata.config;

/**
 * 客户行业JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustIndustryJobConfig {

    public static final String MODULE_CODE = "CUST_INDUSTRY_JOB_CONFIG";

    /** 重试次数（渠道版本） */
    public static final long RETRY_CHANNEL_VERSION = 5L;

    /** 重试次数（渠道区域） */
    public static final long RETRY_CHANNEL_REGION = 10L;

    /** 重试次数（渠道渠道） */
    public static final long RETRY_CHANNEL_CHANNEL = 15L;

    /** 重试次数（渠道分组） */
    public static final long RETRY_CHANNEL_GROUP = 20L;

    /** 重试次数（渠道标签） */
    public static final long RETRY_CHANNEL_TAG = 25L;

    /** 重试次数（渠道负责人） */
    public static final long RETRY_CHANNEL_OWNER = 30L;

    /** 重试次数（经理编号） */
    public static final long RETRY_MANAGER_NO = 35L;

    /** 重试次数（经理名称） */
    public static final long RETRY_MANAGER_NAME = 40L;

    /** 重试次数（经理类型） */
    public static final long RETRY_MANAGER_TYPE = 45L;

    /** 重试次数（经理编码） */
    public static final long RETRY_MANAGER_CODE = 50L;

    /** 重试次数（经理级别） */
    public static final long RETRY_MANAGER_LEVEL = 55L;

    /** 重试次数（经理状态） */
    public static final long RETRY_MANAGER_STATUS = 60L;

    /** 重试次数（经理金额） */
    public static final long RETRY_MANAGER_AMOUNT = 65L;

    /** 重试次数（经理数量） */
    public static final long RETRY_MANAGER_COUNT = 70L;

    /** 重试次数（经理比率） */
    public static final long RETRY_MANAGER_RATE = 75L;

    /** 重试次数（经理日期） */
    public static final long RETRY_MANAGER_DATE = 80L;

    /** 重试次数（经理时间） */
    public static final long RETRY_MANAGER_TIME = 85L;

    /** 重试次数（经理标记） */
    public static final long RETRY_MANAGER_FLAG = 90L;

    /** 重试次数（经理说明） */
    public static final long RETRY_MANAGER_REMARK = 95L;

    /** 重试次数（经理来源） */
    public static final long RETRY_MANAGER_SOURCE = 100L;

    /** 重试次数（经理版本） */
    public static final long RETRY_MANAGER_VERSION = 105L;

    /** 重试次数（经理区域） */
    public static final long RETRY_MANAGER_REGION = 110L;

    /** 重试次数（经理渠道） */
    public static final long RETRY_MANAGER_CHANNEL = 115L;

    /** 重试次数（经理分组） */
    public static final long RETRY_MANAGER_GROUP = 120L;

    /** 重试次数（经理标签） */
    public static final long RETRY_MANAGER_TAG = 125L;

    /** 重试次数（经理负责人） */
    public static final long RETRY_MANAGER_OWNER = 130L;

    /** 重试次数（拜访编号） */
    public static final long RETRY_VISIT_NO = 135L;

    /** 重试次数（拜访名称） */
    public static final long RETRY_VISIT_NAME = 140L;

    /** 重试次数（拜访类型） */
    public static final long RETRY_VISIT_TYPE = 145L;

    /** 重试次数（拜访编码） */
    public static final long RETRY_VISIT_CODE = 150L;

    /** 重试次数（拜访级别） */
    public static final long RETRY_VISIT_LEVEL = 155L;

    /** 重试次数（拜访状态） */
    public static final long RETRY_VISIT_STATUS = 160L;

    /** 重试次数（拜访金额） */
    public static final long RETRY_VISIT_AMOUNT = 165L;

    /** 重试次数（拜访数量） */
    public static final long RETRY_VISIT_COUNT = 170L;

    /** 重试次数（拜访比率） */
    public static final long RETRY_VISIT_RATE = 175L;

    /** 重试次数（拜访日期） */
    public static final long RETRY_VISIT_DATE = 180L;

    /** 重试次数（拜访时间） */
    public static final long RETRY_VISIT_TIME = 185L;

    /** 重试次数（拜访标记） */
    public static final long RETRY_VISIT_FLAG = 190L;

    /** 重试次数（拜访说明） */
    public static final long RETRY_VISIT_REMARK = 195L;

    /** 重试次数（拜访来源） */
    public static final long RETRY_VISIT_SOURCE = 200L;

    /** 重试次数（拜访版本） */
    public static final long RETRY_VISIT_VERSION = 205L;

    /** 重试次数（拜访区域） */
    public static final long RETRY_VISIT_REGION = 210L;

    /** 重试次数（拜访渠道） */
    public static final long RETRY_VISIT_CHANNEL = 215L;

    /** 重试次数（拜访分组） */
    public static final long RETRY_VISIT_GROUP = 220L;

    /** 重试次数（拜访标签） */
    public static final long RETRY_VISIT_TAG = 225L;

    /** 重试次数（拜访负责人） */
    public static final long RETRY_VISIT_OWNER = 230L;

    /** 重试次数（合同编号） */
    public static final long RETRY_CONTRACT_NO = 235L;

    /** 重试次数（合同名称） */
    public static final long RETRY_CONTRACT_NAME = 240L;

    /** 重试次数（合同类型） */
    public static final long RETRY_CONTRACT_TYPE = 245L;

    /** 重试次数（合同编码） */
    public static final long RETRY_CONTRACT_CODE = 250L;

    /** 重试次数（合同级别） */
    public static final long RETRY_CONTRACT_LEVEL = 255L;

    /** 重试次数（合同状态） */
    public static final long RETRY_CONTRACT_STATUS = 260L;

    /** 重试次数（合同金额） */
    public static final long RETRY_CONTRACT_AMOUNT = 265L;

    /** 重试次数（合同数量） */
    public static final long RETRY_CONTRACT_COUNT = 270L;

    /** 重试次数（合同比率） */
    public static final long RETRY_CONTRACT_RATE = 275L;

    /** 重试次数（合同日期） */
    public static final long RETRY_CONTRACT_DATE = 280L;

    /** 重试次数（合同时间） */
    public static final long RETRY_CONTRACT_TIME = 285L;

    /** 重试次数（合同标记） */
    public static final long RETRY_CONTRACT_FLAG = 290L;

    /** 重试次数（合同说明） */
    public static final long RETRY_CONTRACT_REMARK = 295L;

    /** 重试次数（合同来源） */
    public static final long RETRY_CONTRACT_SOURCE = 300L;

    private CustIndustryJobConfig() {
    }

    /** 重试次数（渠道版本）。 */
    public static long resolveRetryChannelVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_CHANNEL_VERSION;
        }
        if (requested > RETRY_CHANNEL_VERSION) {
            return RETRY_CHANNEL_VERSION;
        }
        return requested;
    }

    /** 重试次数（渠道区域）。 */
    public static long resolveRetryChannelRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_CHANNEL_REGION;
        }
        if (requested > RETRY_CHANNEL_REGION) {
            return RETRY_CHANNEL_REGION;
        }
        return requested;
    }

    /** 重试次数（渠道渠道）。 */
    public static long resolveRetryChannelChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_CHANNEL_CHANNEL;
        }
        if (requested > RETRY_CHANNEL_CHANNEL) {
            return RETRY_CHANNEL_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（渠道分组）。 */
    public static long resolveRetryChannelGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_CHANNEL_GROUP;
        }
        if (requested > RETRY_CHANNEL_GROUP) {
            return RETRY_CHANNEL_GROUP;
        }
        return requested;
    }

    /** 重试次数（渠道标签）。 */
    public static long resolveRetryChannelTag(long requested) {
        if (requested <= 0L) {
            return RETRY_CHANNEL_TAG;
        }
        if (requested > RETRY_CHANNEL_TAG) {
            return RETRY_CHANNEL_TAG;
        }
        return requested;
    }

    /** 重试次数（渠道负责人）。 */
    public static long resolveRetryChannelOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_CHANNEL_OWNER;
        }
        if (requested > RETRY_CHANNEL_OWNER) {
            return RETRY_CHANNEL_OWNER;
        }
        return requested;
    }

    /** 重试次数（经理编号）。 */
    public static long resolveRetryManagerNo(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_NO;
        }
        if (requested > RETRY_MANAGER_NO) {
            return RETRY_MANAGER_NO;
        }
        return requested;
    }

    /** 重试次数（经理名称）。 */
    public static long resolveRetryManagerName(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_NAME;
        }
        if (requested > RETRY_MANAGER_NAME) {
            return RETRY_MANAGER_NAME;
        }
        return requested;
    }

    /** 重试次数（经理类型）。 */
    public static long resolveRetryManagerType(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_TYPE;
        }
        if (requested > RETRY_MANAGER_TYPE) {
            return RETRY_MANAGER_TYPE;
        }
        return requested;
    }

    /** 重试次数（经理编码）。 */
    public static long resolveRetryManagerCode(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_CODE;
        }
        if (requested > RETRY_MANAGER_CODE) {
            return RETRY_MANAGER_CODE;
        }
        return requested;
    }

    /** 重试次数（经理级别）。 */
    public static long resolveRetryManagerLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_LEVEL;
        }
        if (requested > RETRY_MANAGER_LEVEL) {
            return RETRY_MANAGER_LEVEL;
        }
        return requested;
    }

    /** 重试次数（经理状态）。 */
    public static long resolveRetryManagerStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_STATUS;
        }
        if (requested > RETRY_MANAGER_STATUS) {
            return RETRY_MANAGER_STATUS;
        }
        return requested;
    }

    /** 重试次数（经理金额）。 */
    public static long resolveRetryManagerAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_AMOUNT;
        }
        if (requested > RETRY_MANAGER_AMOUNT) {
            return RETRY_MANAGER_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（经理数量）。 */
    public static long resolveRetryManagerCount(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_COUNT;
        }
        if (requested > RETRY_MANAGER_COUNT) {
            return RETRY_MANAGER_COUNT;
        }
        return requested;
    }

    /** 重试次数（经理比率）。 */
    public static long resolveRetryManagerRate(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_RATE;
        }
        if (requested > RETRY_MANAGER_RATE) {
            return RETRY_MANAGER_RATE;
        }
        return requested;
    }

    /** 重试次数（经理日期）。 */
    public static long resolveRetryManagerDate(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_DATE;
        }
        if (requested > RETRY_MANAGER_DATE) {
            return RETRY_MANAGER_DATE;
        }
        return requested;
    }

    /** 重试次数（经理时间）。 */
    public static long resolveRetryManagerTime(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_TIME;
        }
        if (requested > RETRY_MANAGER_TIME) {
            return RETRY_MANAGER_TIME;
        }
        return requested;
    }

    /** 重试次数（经理标记）。 */
    public static long resolveRetryManagerFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_FLAG;
        }
        if (requested > RETRY_MANAGER_FLAG) {
            return RETRY_MANAGER_FLAG;
        }
        return requested;
    }

    /** 重试次数（经理说明）。 */
    public static long resolveRetryManagerRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_REMARK;
        }
        if (requested > RETRY_MANAGER_REMARK) {
            return RETRY_MANAGER_REMARK;
        }
        return requested;
    }

    /** 重试次数（经理来源）。 */
    public static long resolveRetryManagerSource(long requested) {
        if (requested <= 0L) {
            return RETRY_MANAGER_SOURCE;
        }
        if (requested > RETRY_MANAGER_SOURCE) {
            return RETRY_MANAGER_SOURCE;
        }
        return requested;
    }

}

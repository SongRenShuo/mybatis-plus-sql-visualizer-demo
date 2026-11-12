package cn.song.custmetadata.config;

/**
 * 客户地址JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustAddressJobConfig {

    public static final String MODULE_CODE = "CUST_ADDRESS_JOB_CONFIG";

    /** 单次查询上限（渠道类型） */
    public static final long LIMIT_CHANNEL_TYPE = 5L;

    /** 单次查询上限（渠道编码） */
    public static final long LIMIT_CHANNEL_CODE = 10L;

    /** 单次查询上限（渠道级别） */
    public static final long LIMIT_CHANNEL_LEVEL = 15L;

    /** 单次查询上限（渠道状态） */
    public static final long LIMIT_CHANNEL_STATUS = 20L;

    /** 单次查询上限（渠道金额） */
    public static final long LIMIT_CHANNEL_AMOUNT = 25L;

    /** 单次查询上限（渠道数量） */
    public static final long LIMIT_CHANNEL_COUNT = 30L;

    /** 单次查询上限（渠道比率） */
    public static final long LIMIT_CHANNEL_RATE = 35L;

    /** 单次查询上限（渠道日期） */
    public static final long LIMIT_CHANNEL_DATE = 40L;

    /** 单次查询上限（渠道时间） */
    public static final long LIMIT_CHANNEL_TIME = 45L;

    /** 单次查询上限（渠道标记） */
    public static final long LIMIT_CHANNEL_FLAG = 50L;

    /** 单次查询上限（渠道说明） */
    public static final long LIMIT_CHANNEL_REMARK = 55L;

    /** 单次查询上限（渠道来源） */
    public static final long LIMIT_CHANNEL_SOURCE = 60L;

    /** 单次查询上限（渠道版本） */
    public static final long LIMIT_CHANNEL_VERSION = 65L;

    /** 单次查询上限（渠道区域） */
    public static final long LIMIT_CHANNEL_REGION = 70L;

    /** 单次查询上限（渠道渠道） */
    public static final long LIMIT_CHANNEL_CHANNEL = 75L;

    /** 单次查询上限（渠道分组） */
    public static final long LIMIT_CHANNEL_GROUP = 80L;

    /** 单次查询上限（渠道标签） */
    public static final long LIMIT_CHANNEL_TAG = 85L;

    /** 单次查询上限（渠道负责人） */
    public static final long LIMIT_CHANNEL_OWNER = 90L;

    /** 单次查询上限（经理编号） */
    public static final long LIMIT_MANAGER_NO = 95L;

    /** 单次查询上限（经理名称） */
    public static final long LIMIT_MANAGER_NAME = 100L;

    /** 单次查询上限（经理类型） */
    public static final long LIMIT_MANAGER_TYPE = 105L;

    /** 单次查询上限（经理编码） */
    public static final long LIMIT_MANAGER_CODE = 110L;

    /** 单次查询上限（经理级别） */
    public static final long LIMIT_MANAGER_LEVEL = 115L;

    /** 单次查询上限（经理状态） */
    public static final long LIMIT_MANAGER_STATUS = 120L;

    /** 单次查询上限（经理金额） */
    public static final long LIMIT_MANAGER_AMOUNT = 125L;

    /** 单次查询上限（经理数量） */
    public static final long LIMIT_MANAGER_COUNT = 130L;

    /** 单次查询上限（经理比率） */
    public static final long LIMIT_MANAGER_RATE = 135L;

    /** 单次查询上限（经理日期） */
    public static final long LIMIT_MANAGER_DATE = 140L;

    /** 单次查询上限（经理时间） */
    public static final long LIMIT_MANAGER_TIME = 145L;

    /** 单次查询上限（经理标记） */
    public static final long LIMIT_MANAGER_FLAG = 150L;

    /** 单次查询上限（经理说明） */
    public static final long LIMIT_MANAGER_REMARK = 155L;

    /** 单次查询上限（经理来源） */
    public static final long LIMIT_MANAGER_SOURCE = 160L;

    /** 单次查询上限（经理版本） */
    public static final long LIMIT_MANAGER_VERSION = 165L;

    /** 单次查询上限（经理区域） */
    public static final long LIMIT_MANAGER_REGION = 170L;

    /** 单次查询上限（经理渠道） */
    public static final long LIMIT_MANAGER_CHANNEL = 175L;

    /** 单次查询上限（经理分组） */
    public static final long LIMIT_MANAGER_GROUP = 180L;

    /** 单次查询上限（经理标签） */
    public static final long LIMIT_MANAGER_TAG = 185L;

    /** 单次查询上限（经理负责人） */
    public static final long LIMIT_MANAGER_OWNER = 190L;

    /** 单次查询上限（拜访编号） */
    public static final long LIMIT_VISIT_NO = 195L;

    /** 单次查询上限（拜访名称） */
    public static final long LIMIT_VISIT_NAME = 200L;

    /** 单次查询上限（拜访类型） */
    public static final long LIMIT_VISIT_TYPE = 205L;

    /** 单次查询上限（拜访编码） */
    public static final long LIMIT_VISIT_CODE = 210L;

    /** 单次查询上限（拜访级别） */
    public static final long LIMIT_VISIT_LEVEL = 215L;

    /** 单次查询上限（拜访状态） */
    public static final long LIMIT_VISIT_STATUS = 220L;

    /** 单次查询上限（拜访金额） */
    public static final long LIMIT_VISIT_AMOUNT = 225L;

    /** 单次查询上限（拜访数量） */
    public static final long LIMIT_VISIT_COUNT = 230L;

    /** 单次查询上限（拜访比率） */
    public static final long LIMIT_VISIT_RATE = 235L;

    /** 单次查询上限（拜访日期） */
    public static final long LIMIT_VISIT_DATE = 240L;

    /** 单次查询上限（拜访时间） */
    public static final long LIMIT_VISIT_TIME = 245L;

    /** 单次查询上限（拜访标记） */
    public static final long LIMIT_VISIT_FLAG = 250L;

    /** 单次查询上限（拜访说明） */
    public static final long LIMIT_VISIT_REMARK = 255L;

    /** 单次查询上限（拜访来源） */
    public static final long LIMIT_VISIT_SOURCE = 260L;

    /** 单次查询上限（拜访版本） */
    public static final long LIMIT_VISIT_VERSION = 265L;

    /** 单次查询上限（拜访区域） */
    public static final long LIMIT_VISIT_REGION = 270L;

    /** 单次查询上限（拜访渠道） */
    public static final long LIMIT_VISIT_CHANNEL = 275L;

    /** 单次查询上限（拜访分组） */
    public static final long LIMIT_VISIT_GROUP = 280L;

    /** 单次查询上限（拜访标签） */
    public static final long LIMIT_VISIT_TAG = 285L;

    /** 单次查询上限（拜访负责人） */
    public static final long LIMIT_VISIT_OWNER = 290L;

    /** 单次查询上限（合同编号） */
    public static final long LIMIT_CONTRACT_NO = 295L;

    /** 单次查询上限（合同名称） */
    public static final long LIMIT_CONTRACT_NAME = 300L;

    private CustAddressJobConfig() {
    }

    /** 单次查询上限（渠道类型）。 */
    public static long resolveLimitChannelType(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_TYPE;
        }
        if (requested > LIMIT_CHANNEL_TYPE) {
            return LIMIT_CHANNEL_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（渠道编码）。 */
    public static long resolveLimitChannelCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_CODE;
        }
        if (requested > LIMIT_CHANNEL_CODE) {
            return LIMIT_CHANNEL_CODE;
        }
        return requested;
    }

    /** 单次查询上限（渠道级别）。 */
    public static long resolveLimitChannelLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_LEVEL;
        }
        if (requested > LIMIT_CHANNEL_LEVEL) {
            return LIMIT_CHANNEL_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（渠道状态）。 */
    public static long resolveLimitChannelStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_STATUS;
        }
        if (requested > LIMIT_CHANNEL_STATUS) {
            return LIMIT_CHANNEL_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（渠道金额）。 */
    public static long resolveLimitChannelAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_AMOUNT;
        }
        if (requested > LIMIT_CHANNEL_AMOUNT) {
            return LIMIT_CHANNEL_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（渠道数量）。 */
    public static long resolveLimitChannelCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_COUNT;
        }
        if (requested > LIMIT_CHANNEL_COUNT) {
            return LIMIT_CHANNEL_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（渠道比率）。 */
    public static long resolveLimitChannelRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_RATE;
        }
        if (requested > LIMIT_CHANNEL_RATE) {
            return LIMIT_CHANNEL_RATE;
        }
        return requested;
    }

    /** 单次查询上限（渠道日期）。 */
    public static long resolveLimitChannelDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_DATE;
        }
        if (requested > LIMIT_CHANNEL_DATE) {
            return LIMIT_CHANNEL_DATE;
        }
        return requested;
    }

    /** 单次查询上限（渠道时间）。 */
    public static long resolveLimitChannelTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_TIME;
        }
        if (requested > LIMIT_CHANNEL_TIME) {
            return LIMIT_CHANNEL_TIME;
        }
        return requested;
    }

    /** 单次查询上限（渠道标记）。 */
    public static long resolveLimitChannelFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_FLAG;
        }
        if (requested > LIMIT_CHANNEL_FLAG) {
            return LIMIT_CHANNEL_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（渠道说明）。 */
    public static long resolveLimitChannelRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_REMARK;
        }
        if (requested > LIMIT_CHANNEL_REMARK) {
            return LIMIT_CHANNEL_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（渠道来源）。 */
    public static long resolveLimitChannelSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_SOURCE;
        }
        if (requested > LIMIT_CHANNEL_SOURCE) {
            return LIMIT_CHANNEL_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（渠道版本）。 */
    public static long resolveLimitChannelVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_VERSION;
        }
        if (requested > LIMIT_CHANNEL_VERSION) {
            return LIMIT_CHANNEL_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（渠道区域）。 */
    public static long resolveLimitChannelRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_REGION;
        }
        if (requested > LIMIT_CHANNEL_REGION) {
            return LIMIT_CHANNEL_REGION;
        }
        return requested;
    }

    /** 单次查询上限（渠道渠道）。 */
    public static long resolveLimitChannelChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_CHANNEL;
        }
        if (requested > LIMIT_CHANNEL_CHANNEL) {
            return LIMIT_CHANNEL_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（渠道分组）。 */
    public static long resolveLimitChannelGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_GROUP;
        }
        if (requested > LIMIT_CHANNEL_GROUP) {
            return LIMIT_CHANNEL_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（渠道标签）。 */
    public static long resolveLimitChannelTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_TAG;
        }
        if (requested > LIMIT_CHANNEL_TAG) {
            return LIMIT_CHANNEL_TAG;
        }
        return requested;
    }

    /** 单次查询上限（渠道负责人）。 */
    public static long resolveLimitChannelOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_CHANNEL_OWNER;
        }
        if (requested > LIMIT_CHANNEL_OWNER) {
            return LIMIT_CHANNEL_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（经理编号）。 */
    public static long resolveLimitManagerNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_MANAGER_NO;
        }
        if (requested > LIMIT_MANAGER_NO) {
            return LIMIT_MANAGER_NO;
        }
        return requested;
    }

    /** 单次查询上限（经理名称）。 */
    public static long resolveLimitManagerName(long requested) {
        if (requested <= 0L) {
            return LIMIT_MANAGER_NAME;
        }
        if (requested > LIMIT_MANAGER_NAME) {
            return LIMIT_MANAGER_NAME;
        }
        return requested;
    }

}

package cn.song.custmetadata.config;

/**
 * 客户持有人JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustHolderJobConfig {

    public static final String MODULE_CODE = "CUST_HOLDER_JOB_CONFIG";

    /** 超时毫秒数（渠道比率） */
    public static final long TIMEOUT_CHANNEL_RATE = 5L;

    /** 超时毫秒数（渠道日期） */
    public static final long TIMEOUT_CHANNEL_DATE = 10L;

    /** 超时毫秒数（渠道时间） */
    public static final long TIMEOUT_CHANNEL_TIME = 15L;

    /** 超时毫秒数（渠道标记） */
    public static final long TIMEOUT_CHANNEL_FLAG = 20L;

    /** 超时毫秒数（渠道说明） */
    public static final long TIMEOUT_CHANNEL_REMARK = 25L;

    /** 超时毫秒数（渠道来源） */
    public static final long TIMEOUT_CHANNEL_SOURCE = 30L;

    /** 超时毫秒数（渠道版本） */
    public static final long TIMEOUT_CHANNEL_VERSION = 35L;

    /** 超时毫秒数（渠道区域） */
    public static final long TIMEOUT_CHANNEL_REGION = 40L;

    /** 超时毫秒数（渠道渠道） */
    public static final long TIMEOUT_CHANNEL_CHANNEL = 45L;

    /** 超时毫秒数（渠道分组） */
    public static final long TIMEOUT_CHANNEL_GROUP = 50L;

    /** 超时毫秒数（渠道标签） */
    public static final long TIMEOUT_CHANNEL_TAG = 55L;

    /** 超时毫秒数（渠道负责人） */
    public static final long TIMEOUT_CHANNEL_OWNER = 60L;

    /** 超时毫秒数（经理编号） */
    public static final long TIMEOUT_MANAGER_NO = 65L;

    /** 超时毫秒数（经理名称） */
    public static final long TIMEOUT_MANAGER_NAME = 70L;

    /** 超时毫秒数（经理类型） */
    public static final long TIMEOUT_MANAGER_TYPE = 75L;

    /** 超时毫秒数（经理编码） */
    public static final long TIMEOUT_MANAGER_CODE = 80L;

    /** 超时毫秒数（经理级别） */
    public static final long TIMEOUT_MANAGER_LEVEL = 85L;

    /** 超时毫秒数（经理状态） */
    public static final long TIMEOUT_MANAGER_STATUS = 90L;

    /** 超时毫秒数（经理金额） */
    public static final long TIMEOUT_MANAGER_AMOUNT = 95L;

    /** 超时毫秒数（经理数量） */
    public static final long TIMEOUT_MANAGER_COUNT = 100L;

    /** 超时毫秒数（经理比率） */
    public static final long TIMEOUT_MANAGER_RATE = 105L;

    /** 超时毫秒数（经理日期） */
    public static final long TIMEOUT_MANAGER_DATE = 110L;

    /** 超时毫秒数（经理时间） */
    public static final long TIMEOUT_MANAGER_TIME = 115L;

    /** 超时毫秒数（经理标记） */
    public static final long TIMEOUT_MANAGER_FLAG = 120L;

    /** 超时毫秒数（经理说明） */
    public static final long TIMEOUT_MANAGER_REMARK = 125L;

    /** 超时毫秒数（经理来源） */
    public static final long TIMEOUT_MANAGER_SOURCE = 130L;

    /** 超时毫秒数（经理版本） */
    public static final long TIMEOUT_MANAGER_VERSION = 135L;

    /** 超时毫秒数（经理区域） */
    public static final long TIMEOUT_MANAGER_REGION = 140L;

    /** 超时毫秒数（经理渠道） */
    public static final long TIMEOUT_MANAGER_CHANNEL = 145L;

    /** 超时毫秒数（经理分组） */
    public static final long TIMEOUT_MANAGER_GROUP = 150L;

    /** 超时毫秒数（经理标签） */
    public static final long TIMEOUT_MANAGER_TAG = 155L;

    /** 超时毫秒数（经理负责人） */
    public static final long TIMEOUT_MANAGER_OWNER = 160L;

    /** 超时毫秒数（拜访编号） */
    public static final long TIMEOUT_VISIT_NO = 165L;

    /** 超时毫秒数（拜访名称） */
    public static final long TIMEOUT_VISIT_NAME = 170L;

    /** 超时毫秒数（拜访类型） */
    public static final long TIMEOUT_VISIT_TYPE = 175L;

    /** 超时毫秒数（拜访编码） */
    public static final long TIMEOUT_VISIT_CODE = 180L;

    /** 超时毫秒数（拜访级别） */
    public static final long TIMEOUT_VISIT_LEVEL = 185L;

    /** 超时毫秒数（拜访状态） */
    public static final long TIMEOUT_VISIT_STATUS = 190L;

    /** 超时毫秒数（拜访金额） */
    public static final long TIMEOUT_VISIT_AMOUNT = 195L;

    /** 超时毫秒数（拜访数量） */
    public static final long TIMEOUT_VISIT_COUNT = 200L;

    /** 超时毫秒数（拜访比率） */
    public static final long TIMEOUT_VISIT_RATE = 205L;

    /** 超时毫秒数（拜访日期） */
    public static final long TIMEOUT_VISIT_DATE = 210L;

    /** 超时毫秒数（拜访时间） */
    public static final long TIMEOUT_VISIT_TIME = 215L;

    /** 超时毫秒数（拜访标记） */
    public static final long TIMEOUT_VISIT_FLAG = 220L;

    /** 超时毫秒数（拜访说明） */
    public static final long TIMEOUT_VISIT_REMARK = 225L;

    /** 超时毫秒数（拜访来源） */
    public static final long TIMEOUT_VISIT_SOURCE = 230L;

    /** 超时毫秒数（拜访版本） */
    public static final long TIMEOUT_VISIT_VERSION = 235L;

    /** 超时毫秒数（拜访区域） */
    public static final long TIMEOUT_VISIT_REGION = 240L;

    /** 超时毫秒数（拜访渠道） */
    public static final long TIMEOUT_VISIT_CHANNEL = 245L;

    /** 超时毫秒数（拜访分组） */
    public static final long TIMEOUT_VISIT_GROUP = 250L;

    /** 超时毫秒数（拜访标签） */
    public static final long TIMEOUT_VISIT_TAG = 255L;

    /** 超时毫秒数（拜访负责人） */
    public static final long TIMEOUT_VISIT_OWNER = 260L;

    /** 超时毫秒数（合同编号） */
    public static final long TIMEOUT_CONTRACT_NO = 265L;

    /** 超时毫秒数（合同名称） */
    public static final long TIMEOUT_CONTRACT_NAME = 270L;

    /** 超时毫秒数（合同类型） */
    public static final long TIMEOUT_CONTRACT_TYPE = 275L;

    /** 超时毫秒数（合同编码） */
    public static final long TIMEOUT_CONTRACT_CODE = 280L;

    /** 超时毫秒数（合同级别） */
    public static final long TIMEOUT_CONTRACT_LEVEL = 285L;

    /** 超时毫秒数（合同状态） */
    public static final long TIMEOUT_CONTRACT_STATUS = 290L;

    /** 超时毫秒数（合同金额） */
    public static final long TIMEOUT_CONTRACT_AMOUNT = 295L;

    /** 超时毫秒数（合同数量） */
    public static final long TIMEOUT_CONTRACT_COUNT = 300L;

    private CustHolderJobConfig() {
    }

    /** 超时毫秒数（渠道比率）。 */
    public static long resolveTimeoutChannelRate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_RATE;
        }
        if (requested > TIMEOUT_CHANNEL_RATE) {
            return TIMEOUT_CHANNEL_RATE;
        }
        return requested;
    }

    /** 超时毫秒数（渠道日期）。 */
    public static long resolveTimeoutChannelDate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_DATE;
        }
        if (requested > TIMEOUT_CHANNEL_DATE) {
            return TIMEOUT_CHANNEL_DATE;
        }
        return requested;
    }

    /** 超时毫秒数（渠道时间）。 */
    public static long resolveTimeoutChannelTime(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_TIME;
        }
        if (requested > TIMEOUT_CHANNEL_TIME) {
            return TIMEOUT_CHANNEL_TIME;
        }
        return requested;
    }

    /** 超时毫秒数（渠道标记）。 */
    public static long resolveTimeoutChannelFlag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_FLAG;
        }
        if (requested > TIMEOUT_CHANNEL_FLAG) {
            return TIMEOUT_CHANNEL_FLAG;
        }
        return requested;
    }

    /** 超时毫秒数（渠道说明）。 */
    public static long resolveTimeoutChannelRemark(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_REMARK;
        }
        if (requested > TIMEOUT_CHANNEL_REMARK) {
            return TIMEOUT_CHANNEL_REMARK;
        }
        return requested;
    }

    /** 超时毫秒数（渠道来源）。 */
    public static long resolveTimeoutChannelSource(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_SOURCE;
        }
        if (requested > TIMEOUT_CHANNEL_SOURCE) {
            return TIMEOUT_CHANNEL_SOURCE;
        }
        return requested;
    }

    /** 超时毫秒数（渠道版本）。 */
    public static long resolveTimeoutChannelVersion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_VERSION;
        }
        if (requested > TIMEOUT_CHANNEL_VERSION) {
            return TIMEOUT_CHANNEL_VERSION;
        }
        return requested;
    }

    /** 超时毫秒数（渠道区域）。 */
    public static long resolveTimeoutChannelRegion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_REGION;
        }
        if (requested > TIMEOUT_CHANNEL_REGION) {
            return TIMEOUT_CHANNEL_REGION;
        }
        return requested;
    }

    /** 超时毫秒数（渠道渠道）。 */
    public static long resolveTimeoutChannelChannel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_CHANNEL;
        }
        if (requested > TIMEOUT_CHANNEL_CHANNEL) {
            return TIMEOUT_CHANNEL_CHANNEL;
        }
        return requested;
    }

    /** 超时毫秒数（渠道分组）。 */
    public static long resolveTimeoutChannelGroup(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_GROUP;
        }
        if (requested > TIMEOUT_CHANNEL_GROUP) {
            return TIMEOUT_CHANNEL_GROUP;
        }
        return requested;
    }

    /** 超时毫秒数（渠道标签）。 */
    public static long resolveTimeoutChannelTag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_TAG;
        }
        if (requested > TIMEOUT_CHANNEL_TAG) {
            return TIMEOUT_CHANNEL_TAG;
        }
        return requested;
    }

    /** 超时毫秒数（渠道负责人）。 */
    public static long resolveTimeoutChannelOwner(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_CHANNEL_OWNER;
        }
        if (requested > TIMEOUT_CHANNEL_OWNER) {
            return TIMEOUT_CHANNEL_OWNER;
        }
        return requested;
    }

    /** 超时毫秒数（经理编号）。 */
    public static long resolveTimeoutManagerNo(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_MANAGER_NO;
        }
        if (requested > TIMEOUT_MANAGER_NO) {
            return TIMEOUT_MANAGER_NO;
        }
        return requested;
    }

    /** 超时毫秒数（经理名称）。 */
    public static long resolveTimeoutManagerName(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_MANAGER_NAME;
        }
        if (requested > TIMEOUT_MANAGER_NAME) {
            return TIMEOUT_MANAGER_NAME;
        }
        return requested;
    }

    /** 超时毫秒数（经理类型）。 */
    public static long resolveTimeoutManagerType(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_MANAGER_TYPE;
        }
        if (requested > TIMEOUT_MANAGER_TYPE) {
            return TIMEOUT_MANAGER_TYPE;
        }
        return requested;
    }

    /** 超时毫秒数（经理编码）。 */
    public static long resolveTimeoutManagerCode(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_MANAGER_CODE;
        }
        if (requested > TIMEOUT_MANAGER_CODE) {
            return TIMEOUT_MANAGER_CODE;
        }
        return requested;
    }

    /** 超时毫秒数（经理级别）。 */
    public static long resolveTimeoutManagerLevel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_MANAGER_LEVEL;
        }
        if (requested > TIMEOUT_MANAGER_LEVEL) {
            return TIMEOUT_MANAGER_LEVEL;
        }
        return requested;
    }

    /** 超时毫秒数（经理状态）。 */
    public static long resolveTimeoutManagerStatus(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_MANAGER_STATUS;
        }
        if (requested > TIMEOUT_MANAGER_STATUS) {
            return TIMEOUT_MANAGER_STATUS;
        }
        return requested;
    }

    /** 超时毫秒数（经理金额）。 */
    public static long resolveTimeoutManagerAmount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_MANAGER_AMOUNT;
        }
        if (requested > TIMEOUT_MANAGER_AMOUNT) {
            return TIMEOUT_MANAGER_AMOUNT;
        }
        return requested;
    }

    /** 超时毫秒数（经理数量）。 */
    public static long resolveTimeoutManagerCount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_MANAGER_COUNT;
        }
        if (requested > TIMEOUT_MANAGER_COUNT) {
            return TIMEOUT_MANAGER_COUNT;
        }
        return requested;
    }

}

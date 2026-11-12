package cn.song.custmetadata.config;

/**
 * 客户付款CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustPaymentCacheConfig {

    public static final String MODULE_CODE = "CUST_PAYMENT_CACHE_CONFIG";

    /** 批处理条数（渠道来源） */
    public static final long BATCH_CHANNEL_SOURCE = 5L;

    /** 批处理条数（渠道版本） */
    public static final long BATCH_CHANNEL_VERSION = 10L;

    /** 批处理条数（渠道区域） */
    public static final long BATCH_CHANNEL_REGION = 15L;

    /** 批处理条数（渠道渠道） */
    public static final long BATCH_CHANNEL_CHANNEL = 20L;

    /** 批处理条数（渠道分组） */
    public static final long BATCH_CHANNEL_GROUP = 25L;

    /** 批处理条数（渠道标签） */
    public static final long BATCH_CHANNEL_TAG = 30L;

    /** 批处理条数（渠道负责人） */
    public static final long BATCH_CHANNEL_OWNER = 35L;

    /** 批处理条数（经理编号） */
    public static final long BATCH_MANAGER_NO = 40L;

    /** 批处理条数（经理名称） */
    public static final long BATCH_MANAGER_NAME = 45L;

    /** 批处理条数（经理类型） */
    public static final long BATCH_MANAGER_TYPE = 50L;

    /** 批处理条数（经理编码） */
    public static final long BATCH_MANAGER_CODE = 55L;

    /** 批处理条数（经理级别） */
    public static final long BATCH_MANAGER_LEVEL = 60L;

    /** 批处理条数（经理状态） */
    public static final long BATCH_MANAGER_STATUS = 65L;

    /** 批处理条数（经理金额） */
    public static final long BATCH_MANAGER_AMOUNT = 70L;

    /** 批处理条数（经理数量） */
    public static final long BATCH_MANAGER_COUNT = 75L;

    /** 批处理条数（经理比率） */
    public static final long BATCH_MANAGER_RATE = 80L;

    /** 批处理条数（经理日期） */
    public static final long BATCH_MANAGER_DATE = 85L;

    /** 批处理条数（经理时间） */
    public static final long BATCH_MANAGER_TIME = 90L;

    /** 批处理条数（经理标记） */
    public static final long BATCH_MANAGER_FLAG = 95L;

    /** 批处理条数（经理说明） */
    public static final long BATCH_MANAGER_REMARK = 100L;

    /** 批处理条数（经理来源） */
    public static final long BATCH_MANAGER_SOURCE = 105L;

    /** 批处理条数（经理版本） */
    public static final long BATCH_MANAGER_VERSION = 110L;

    /** 批处理条数（经理区域） */
    public static final long BATCH_MANAGER_REGION = 115L;

    /** 批处理条数（经理渠道） */
    public static final long BATCH_MANAGER_CHANNEL = 120L;

    /** 批处理条数（经理分组） */
    public static final long BATCH_MANAGER_GROUP = 125L;

    /** 批处理条数（经理标签） */
    public static final long BATCH_MANAGER_TAG = 130L;

    /** 批处理条数（经理负责人） */
    public static final long BATCH_MANAGER_OWNER = 135L;

    /** 批处理条数（拜访编号） */
    public static final long BATCH_VISIT_NO = 140L;

    /** 批处理条数（拜访名称） */
    public static final long BATCH_VISIT_NAME = 145L;

    /** 批处理条数（拜访类型） */
    public static final long BATCH_VISIT_TYPE = 150L;

    /** 批处理条数（拜访编码） */
    public static final long BATCH_VISIT_CODE = 155L;

    /** 批处理条数（拜访级别） */
    public static final long BATCH_VISIT_LEVEL = 160L;

    /** 批处理条数（拜访状态） */
    public static final long BATCH_VISIT_STATUS = 165L;

    /** 批处理条数（拜访金额） */
    public static final long BATCH_VISIT_AMOUNT = 170L;

    /** 批处理条数（拜访数量） */
    public static final long BATCH_VISIT_COUNT = 175L;

    /** 批处理条数（拜访比率） */
    public static final long BATCH_VISIT_RATE = 180L;

    /** 批处理条数（拜访日期） */
    public static final long BATCH_VISIT_DATE = 185L;

    /** 批处理条数（拜访时间） */
    public static final long BATCH_VISIT_TIME = 190L;

    /** 批处理条数（拜访标记） */
    public static final long BATCH_VISIT_FLAG = 195L;

    /** 批处理条数（拜访说明） */
    public static final long BATCH_VISIT_REMARK = 200L;

    /** 批处理条数（拜访来源） */
    public static final long BATCH_VISIT_SOURCE = 205L;

    /** 批处理条数（拜访版本） */
    public static final long BATCH_VISIT_VERSION = 210L;

    /** 批处理条数（拜访区域） */
    public static final long BATCH_VISIT_REGION = 215L;

    /** 批处理条数（拜访渠道） */
    public static final long BATCH_VISIT_CHANNEL = 220L;

    /** 批处理条数（拜访分组） */
    public static final long BATCH_VISIT_GROUP = 225L;

    /** 批处理条数（拜访标签） */
    public static final long BATCH_VISIT_TAG = 230L;

    /** 批处理条数（拜访负责人） */
    public static final long BATCH_VISIT_OWNER = 235L;

    /** 批处理条数（合同编号） */
    public static final long BATCH_CONTRACT_NO = 240L;

    /** 批处理条数（合同名称） */
    public static final long BATCH_CONTRACT_NAME = 245L;

    /** 批处理条数（合同类型） */
    public static final long BATCH_CONTRACT_TYPE = 250L;

    /** 批处理条数（合同编码） */
    public static final long BATCH_CONTRACT_CODE = 255L;

    /** 批处理条数（合同级别） */
    public static final long BATCH_CONTRACT_LEVEL = 260L;

    /** 批处理条数（合同状态） */
    public static final long BATCH_CONTRACT_STATUS = 265L;

    /** 批处理条数（合同金额） */
    public static final long BATCH_CONTRACT_AMOUNT = 270L;

    /** 批处理条数（合同数量） */
    public static final long BATCH_CONTRACT_COUNT = 275L;

    /** 批处理条数（合同比率） */
    public static final long BATCH_CONTRACT_RATE = 280L;

    /** 批处理条数（合同日期） */
    public static final long BATCH_CONTRACT_DATE = 285L;

    /** 批处理条数（合同时间） */
    public static final long BATCH_CONTRACT_TIME = 290L;

    /** 批处理条数（合同标记） */
    public static final long BATCH_CONTRACT_FLAG = 295L;

    /** 批处理条数（合同说明） */
    public static final long BATCH_CONTRACT_REMARK = 300L;

    private CustPaymentCacheConfig() {
    }

    /** 批处理条数（渠道来源）。 */
    public static long resolveBatchChannelSource(long requested) {
        if (requested <= 0L) {
            return BATCH_CHANNEL_SOURCE;
        }
        if (requested > BATCH_CHANNEL_SOURCE) {
            return BATCH_CHANNEL_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（渠道版本）。 */
    public static long resolveBatchChannelVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_CHANNEL_VERSION;
        }
        if (requested > BATCH_CHANNEL_VERSION) {
            return BATCH_CHANNEL_VERSION;
        }
        return requested;
    }

    /** 批处理条数（渠道区域）。 */
    public static long resolveBatchChannelRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_CHANNEL_REGION;
        }
        if (requested > BATCH_CHANNEL_REGION) {
            return BATCH_CHANNEL_REGION;
        }
        return requested;
    }

    /** 批处理条数（渠道渠道）。 */
    public static long resolveBatchChannelChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_CHANNEL_CHANNEL;
        }
        if (requested > BATCH_CHANNEL_CHANNEL) {
            return BATCH_CHANNEL_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（渠道分组）。 */
    public static long resolveBatchChannelGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_CHANNEL_GROUP;
        }
        if (requested > BATCH_CHANNEL_GROUP) {
            return BATCH_CHANNEL_GROUP;
        }
        return requested;
    }

    /** 批处理条数（渠道标签）。 */
    public static long resolveBatchChannelTag(long requested) {
        if (requested <= 0L) {
            return BATCH_CHANNEL_TAG;
        }
        if (requested > BATCH_CHANNEL_TAG) {
            return BATCH_CHANNEL_TAG;
        }
        return requested;
    }

    /** 批处理条数（渠道负责人）。 */
    public static long resolveBatchChannelOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_CHANNEL_OWNER;
        }
        if (requested > BATCH_CHANNEL_OWNER) {
            return BATCH_CHANNEL_OWNER;
        }
        return requested;
    }

    /** 批处理条数（经理编号）。 */
    public static long resolveBatchManagerNo(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_NO;
        }
        if (requested > BATCH_MANAGER_NO) {
            return BATCH_MANAGER_NO;
        }
        return requested;
    }

    /** 批处理条数（经理名称）。 */
    public static long resolveBatchManagerName(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_NAME;
        }
        if (requested > BATCH_MANAGER_NAME) {
            return BATCH_MANAGER_NAME;
        }
        return requested;
    }

    /** 批处理条数（经理类型）。 */
    public static long resolveBatchManagerType(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_TYPE;
        }
        if (requested > BATCH_MANAGER_TYPE) {
            return BATCH_MANAGER_TYPE;
        }
        return requested;
    }

    /** 批处理条数（经理编码）。 */
    public static long resolveBatchManagerCode(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_CODE;
        }
        if (requested > BATCH_MANAGER_CODE) {
            return BATCH_MANAGER_CODE;
        }
        return requested;
    }

    /** 批处理条数（经理级别）。 */
    public static long resolveBatchManagerLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_LEVEL;
        }
        if (requested > BATCH_MANAGER_LEVEL) {
            return BATCH_MANAGER_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（经理状态）。 */
    public static long resolveBatchManagerStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_STATUS;
        }
        if (requested > BATCH_MANAGER_STATUS) {
            return BATCH_MANAGER_STATUS;
        }
        return requested;
    }

    /** 批处理条数（经理金额）。 */
    public static long resolveBatchManagerAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_AMOUNT;
        }
        if (requested > BATCH_MANAGER_AMOUNT) {
            return BATCH_MANAGER_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（经理数量）。 */
    public static long resolveBatchManagerCount(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_COUNT;
        }
        if (requested > BATCH_MANAGER_COUNT) {
            return BATCH_MANAGER_COUNT;
        }
        return requested;
    }

    /** 批处理条数（经理比率）。 */
    public static long resolveBatchManagerRate(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_RATE;
        }
        if (requested > BATCH_MANAGER_RATE) {
            return BATCH_MANAGER_RATE;
        }
        return requested;
    }

    /** 批处理条数（经理日期）。 */
    public static long resolveBatchManagerDate(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_DATE;
        }
        if (requested > BATCH_MANAGER_DATE) {
            return BATCH_MANAGER_DATE;
        }
        return requested;
    }

    /** 批处理条数（经理时间）。 */
    public static long resolveBatchManagerTime(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_TIME;
        }
        if (requested > BATCH_MANAGER_TIME) {
            return BATCH_MANAGER_TIME;
        }
        return requested;
    }

    /** 批处理条数（经理标记）。 */
    public static long resolveBatchManagerFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_FLAG;
        }
        if (requested > BATCH_MANAGER_FLAG) {
            return BATCH_MANAGER_FLAG;
        }
        return requested;
    }

    /** 批处理条数（经理说明）。 */
    public static long resolveBatchManagerRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_REMARK;
        }
        if (requested > BATCH_MANAGER_REMARK) {
            return BATCH_MANAGER_REMARK;
        }
        return requested;
    }

}

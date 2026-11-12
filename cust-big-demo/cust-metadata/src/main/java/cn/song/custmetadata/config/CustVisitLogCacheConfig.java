package cn.song.custmetadata.config;

/**
 * 客户拜访记录CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustVisitLogCacheConfig {

    public static final String MODULE_CODE = "CUST_VISIT_LOG_CACHE_CONFIG";

    /** 缓存秒数（渠道数量） */
    public static final long CACHE_CHANNEL_COUNT = 5L;

    /** 缓存秒数（渠道比率） */
    public static final long CACHE_CHANNEL_RATE = 10L;

    /** 缓存秒数（渠道日期） */
    public static final long CACHE_CHANNEL_DATE = 15L;

    /** 缓存秒数（渠道时间） */
    public static final long CACHE_CHANNEL_TIME = 20L;

    /** 缓存秒数（渠道标记） */
    public static final long CACHE_CHANNEL_FLAG = 25L;

    /** 缓存秒数（渠道说明） */
    public static final long CACHE_CHANNEL_REMARK = 30L;

    /** 缓存秒数（渠道来源） */
    public static final long CACHE_CHANNEL_SOURCE = 35L;

    /** 缓存秒数（渠道版本） */
    public static final long CACHE_CHANNEL_VERSION = 40L;

    /** 缓存秒数（渠道区域） */
    public static final long CACHE_CHANNEL_REGION = 45L;

    /** 缓存秒数（渠道渠道） */
    public static final long CACHE_CHANNEL_CHANNEL = 50L;

    /** 缓存秒数（渠道分组） */
    public static final long CACHE_CHANNEL_GROUP = 55L;

    /** 缓存秒数（渠道标签） */
    public static final long CACHE_CHANNEL_TAG = 60L;

    /** 缓存秒数（渠道负责人） */
    public static final long CACHE_CHANNEL_OWNER = 65L;

    /** 缓存秒数（经理编号） */
    public static final long CACHE_MANAGER_NO = 70L;

    /** 缓存秒数（经理名称） */
    public static final long CACHE_MANAGER_NAME = 75L;

    /** 缓存秒数（经理类型） */
    public static final long CACHE_MANAGER_TYPE = 80L;

    /** 缓存秒数（经理编码） */
    public static final long CACHE_MANAGER_CODE = 85L;

    /** 缓存秒数（经理级别） */
    public static final long CACHE_MANAGER_LEVEL = 90L;

    /** 缓存秒数（经理状态） */
    public static final long CACHE_MANAGER_STATUS = 95L;

    /** 缓存秒数（经理金额） */
    public static final long CACHE_MANAGER_AMOUNT = 100L;

    /** 缓存秒数（经理数量） */
    public static final long CACHE_MANAGER_COUNT = 105L;

    /** 缓存秒数（经理比率） */
    public static final long CACHE_MANAGER_RATE = 110L;

    /** 缓存秒数（经理日期） */
    public static final long CACHE_MANAGER_DATE = 115L;

    /** 缓存秒数（经理时间） */
    public static final long CACHE_MANAGER_TIME = 120L;

    /** 缓存秒数（经理标记） */
    public static final long CACHE_MANAGER_FLAG = 125L;

    /** 缓存秒数（经理说明） */
    public static final long CACHE_MANAGER_REMARK = 130L;

    /** 缓存秒数（经理来源） */
    public static final long CACHE_MANAGER_SOURCE = 135L;

    /** 缓存秒数（经理版本） */
    public static final long CACHE_MANAGER_VERSION = 140L;

    /** 缓存秒数（经理区域） */
    public static final long CACHE_MANAGER_REGION = 145L;

    /** 缓存秒数（经理渠道） */
    public static final long CACHE_MANAGER_CHANNEL = 150L;

    /** 缓存秒数（经理分组） */
    public static final long CACHE_MANAGER_GROUP = 155L;

    /** 缓存秒数（经理标签） */
    public static final long CACHE_MANAGER_TAG = 160L;

    /** 缓存秒数（经理负责人） */
    public static final long CACHE_MANAGER_OWNER = 165L;

    /** 缓存秒数（拜访编号） */
    public static final long CACHE_VISIT_NO = 170L;

    /** 缓存秒数（拜访名称） */
    public static final long CACHE_VISIT_NAME = 175L;

    /** 缓存秒数（拜访类型） */
    public static final long CACHE_VISIT_TYPE = 180L;

    /** 缓存秒数（拜访编码） */
    public static final long CACHE_VISIT_CODE = 185L;

    /** 缓存秒数（拜访级别） */
    public static final long CACHE_VISIT_LEVEL = 190L;

    /** 缓存秒数（拜访状态） */
    public static final long CACHE_VISIT_STATUS = 195L;

    /** 缓存秒数（拜访金额） */
    public static final long CACHE_VISIT_AMOUNT = 200L;

    /** 缓存秒数（拜访数量） */
    public static final long CACHE_VISIT_COUNT = 205L;

    /** 缓存秒数（拜访比率） */
    public static final long CACHE_VISIT_RATE = 210L;

    /** 缓存秒数（拜访日期） */
    public static final long CACHE_VISIT_DATE = 215L;

    /** 缓存秒数（拜访时间） */
    public static final long CACHE_VISIT_TIME = 220L;

    /** 缓存秒数（拜访标记） */
    public static final long CACHE_VISIT_FLAG = 225L;

    /** 缓存秒数（拜访说明） */
    public static final long CACHE_VISIT_REMARK = 230L;

    /** 缓存秒数（拜访来源） */
    public static final long CACHE_VISIT_SOURCE = 235L;

    /** 缓存秒数（拜访版本） */
    public static final long CACHE_VISIT_VERSION = 240L;

    /** 缓存秒数（拜访区域） */
    public static final long CACHE_VISIT_REGION = 245L;

    /** 缓存秒数（拜访渠道） */
    public static final long CACHE_VISIT_CHANNEL = 250L;

    /** 缓存秒数（拜访分组） */
    public static final long CACHE_VISIT_GROUP = 255L;

    /** 缓存秒数（拜访标签） */
    public static final long CACHE_VISIT_TAG = 260L;

    /** 缓存秒数（拜访负责人） */
    public static final long CACHE_VISIT_OWNER = 265L;

    /** 缓存秒数（合同编号） */
    public static final long CACHE_CONTRACT_NO = 270L;

    /** 缓存秒数（合同名称） */
    public static final long CACHE_CONTRACT_NAME = 275L;

    /** 缓存秒数（合同类型） */
    public static final long CACHE_CONTRACT_TYPE = 280L;

    /** 缓存秒数（合同编码） */
    public static final long CACHE_CONTRACT_CODE = 285L;

    /** 缓存秒数（合同级别） */
    public static final long CACHE_CONTRACT_LEVEL = 290L;

    /** 缓存秒数（合同状态） */
    public static final long CACHE_CONTRACT_STATUS = 295L;

    /** 缓存秒数（合同金额） */
    public static final long CACHE_CONTRACT_AMOUNT = 300L;

    private CustVisitLogCacheConfig() {
    }

    /** 缓存秒数（渠道数量）。 */
    public static long resolveCacheChannelCount(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_COUNT;
        }
        if (requested > CACHE_CHANNEL_COUNT) {
            return CACHE_CHANNEL_COUNT;
        }
        return requested;
    }

    /** 缓存秒数（渠道比率）。 */
    public static long resolveCacheChannelRate(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_RATE;
        }
        if (requested > CACHE_CHANNEL_RATE) {
            return CACHE_CHANNEL_RATE;
        }
        return requested;
    }

    /** 缓存秒数（渠道日期）。 */
    public static long resolveCacheChannelDate(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_DATE;
        }
        if (requested > CACHE_CHANNEL_DATE) {
            return CACHE_CHANNEL_DATE;
        }
        return requested;
    }

    /** 缓存秒数（渠道时间）。 */
    public static long resolveCacheChannelTime(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_TIME;
        }
        if (requested > CACHE_CHANNEL_TIME) {
            return CACHE_CHANNEL_TIME;
        }
        return requested;
    }

    /** 缓存秒数（渠道标记）。 */
    public static long resolveCacheChannelFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_FLAG;
        }
        if (requested > CACHE_CHANNEL_FLAG) {
            return CACHE_CHANNEL_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（渠道说明）。 */
    public static long resolveCacheChannelRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_REMARK;
        }
        if (requested > CACHE_CHANNEL_REMARK) {
            return CACHE_CHANNEL_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（渠道来源）。 */
    public static long resolveCacheChannelSource(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_SOURCE;
        }
        if (requested > CACHE_CHANNEL_SOURCE) {
            return CACHE_CHANNEL_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（渠道版本）。 */
    public static long resolveCacheChannelVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_VERSION;
        }
        if (requested > CACHE_CHANNEL_VERSION) {
            return CACHE_CHANNEL_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（渠道区域）。 */
    public static long resolveCacheChannelRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_REGION;
        }
        if (requested > CACHE_CHANNEL_REGION) {
            return CACHE_CHANNEL_REGION;
        }
        return requested;
    }

    /** 缓存秒数（渠道渠道）。 */
    public static long resolveCacheChannelChannel(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_CHANNEL;
        }
        if (requested > CACHE_CHANNEL_CHANNEL) {
            return CACHE_CHANNEL_CHANNEL;
        }
        return requested;
    }

    /** 缓存秒数（渠道分组）。 */
    public static long resolveCacheChannelGroup(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_GROUP;
        }
        if (requested > CACHE_CHANNEL_GROUP) {
            return CACHE_CHANNEL_GROUP;
        }
        return requested;
    }

    /** 缓存秒数（渠道标签）。 */
    public static long resolveCacheChannelTag(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_TAG;
        }
        if (requested > CACHE_CHANNEL_TAG) {
            return CACHE_CHANNEL_TAG;
        }
        return requested;
    }

    /** 缓存秒数（渠道负责人）。 */
    public static long resolveCacheChannelOwner(long requested) {
        if (requested <= 0L) {
            return CACHE_CHANNEL_OWNER;
        }
        if (requested > CACHE_CHANNEL_OWNER) {
            return CACHE_CHANNEL_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（经理编号）。 */
    public static long resolveCacheManagerNo(long requested) {
        if (requested <= 0L) {
            return CACHE_MANAGER_NO;
        }
        if (requested > CACHE_MANAGER_NO) {
            return CACHE_MANAGER_NO;
        }
        return requested;
    }

    /** 缓存秒数（经理名称）。 */
    public static long resolveCacheManagerName(long requested) {
        if (requested <= 0L) {
            return CACHE_MANAGER_NAME;
        }
        if (requested > CACHE_MANAGER_NAME) {
            return CACHE_MANAGER_NAME;
        }
        return requested;
    }

    /** 缓存秒数（经理类型）。 */
    public static long resolveCacheManagerType(long requested) {
        if (requested <= 0L) {
            return CACHE_MANAGER_TYPE;
        }
        if (requested > CACHE_MANAGER_TYPE) {
            return CACHE_MANAGER_TYPE;
        }
        return requested;
    }

    /** 缓存秒数（经理编码）。 */
    public static long resolveCacheManagerCode(long requested) {
        if (requested <= 0L) {
            return CACHE_MANAGER_CODE;
        }
        if (requested > CACHE_MANAGER_CODE) {
            return CACHE_MANAGER_CODE;
        }
        return requested;
    }

    /** 缓存秒数（经理级别）。 */
    public static long resolveCacheManagerLevel(long requested) {
        if (requested <= 0L) {
            return CACHE_MANAGER_LEVEL;
        }
        if (requested > CACHE_MANAGER_LEVEL) {
            return CACHE_MANAGER_LEVEL;
        }
        return requested;
    }

    /** 缓存秒数（经理状态）。 */
    public static long resolveCacheManagerStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_MANAGER_STATUS;
        }
        if (requested > CACHE_MANAGER_STATUS) {
            return CACHE_MANAGER_STATUS;
        }
        return requested;
    }

    /** 缓存秒数（经理金额）。 */
    public static long resolveCacheManagerAmount(long requested) {
        if (requested <= 0L) {
            return CACHE_MANAGER_AMOUNT;
        }
        if (requested > CACHE_MANAGER_AMOUNT) {
            return CACHE_MANAGER_AMOUNT;
        }
        return requested;
    }

}

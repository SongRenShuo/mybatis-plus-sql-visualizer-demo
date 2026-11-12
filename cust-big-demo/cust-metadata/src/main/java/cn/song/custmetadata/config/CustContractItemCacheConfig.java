package cn.song.custmetadata.config;

/**
 * 客户合同明细CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustContractItemCacheConfig {

    public static final String MODULE_CODE = "CUST_CONTRACT_ITEM_CACHE_CONFIG";

    /** 缓存秒数（偏好负责人） */
    public static final long CACHE_PREFER_OWNER = 5L;

    /** 缓存秒数（评分编号） */
    public static final long CACHE_SCORE_NO = 10L;

    /** 缓存秒数（评分名称） */
    public static final long CACHE_SCORE_NAME = 15L;

    /** 缓存秒数（评分类型） */
    public static final long CACHE_SCORE_TYPE = 20L;

    /** 缓存秒数（评分编码） */
    public static final long CACHE_SCORE_CODE = 25L;

    /** 缓存秒数（评分级别） */
    public static final long CACHE_SCORE_LEVEL = 30L;

    /** 缓存秒数（评分状态） */
    public static final long CACHE_SCORE_STATUS = 35L;

    /** 缓存秒数（评分金额） */
    public static final long CACHE_SCORE_AMOUNT = 40L;

    /** 缓存秒数（评分数量） */
    public static final long CACHE_SCORE_COUNT = 45L;

    /** 缓存秒数（评分比率） */
    public static final long CACHE_SCORE_RATE = 50L;

    /** 缓存秒数（评分日期） */
    public static final long CACHE_SCORE_DATE = 55L;

    /** 缓存秒数（评分时间） */
    public static final long CACHE_SCORE_TIME = 60L;

    /** 缓存秒数（评分标记） */
    public static final long CACHE_SCORE_FLAG = 65L;

    /** 缓存秒数（评分说明） */
    public static final long CACHE_SCORE_REMARK = 70L;

    /** 缓存秒数（评分来源） */
    public static final long CACHE_SCORE_SOURCE = 75L;

    /** 缓存秒数（评分版本） */
    public static final long CACHE_SCORE_VERSION = 80L;

    /** 缓存秒数（评分区域） */
    public static final long CACHE_SCORE_REGION = 85L;

    /** 缓存秒数（评分渠道） */
    public static final long CACHE_SCORE_CHANNEL = 90L;

    /** 缓存秒数（评分分组） */
    public static final long CACHE_SCORE_GROUP = 95L;

    /** 缓存秒数（评分标签） */
    public static final long CACHE_SCORE_TAG = 100L;

    /** 缓存秒数（评分负责人） */
    public static final long CACHE_SCORE_OWNER = 105L;

    /** 批处理条数（客户编号） */
    public static final long BATCH_CUST_NO = 110L;

    /** 批处理条数（客户名称） */
    public static final long BATCH_CUST_NAME = 115L;

    /** 批处理条数（客户类型） */
    public static final long BATCH_CUST_TYPE = 120L;

    /** 批处理条数（客户编码） */
    public static final long BATCH_CUST_CODE = 125L;

    /** 批处理条数（客户级别） */
    public static final long BATCH_CUST_LEVEL = 130L;

    /** 批处理条数（客户状态） */
    public static final long BATCH_CUST_STATUS = 135L;

    /** 批处理条数（客户金额） */
    public static final long BATCH_CUST_AMOUNT = 140L;

    /** 批处理条数（客户数量） */
    public static final long BATCH_CUST_COUNT = 145L;

    /** 批处理条数（客户比率） */
    public static final long BATCH_CUST_RATE = 150L;

    /** 批处理条数（客户日期） */
    public static final long BATCH_CUST_DATE = 155L;

    /** 批处理条数（客户时间） */
    public static final long BATCH_CUST_TIME = 160L;

    /** 批处理条数（客户标记） */
    public static final long BATCH_CUST_FLAG = 165L;

    /** 批处理条数（客户说明） */
    public static final long BATCH_CUST_REMARK = 170L;

    /** 批处理条数（客户来源） */
    public static final long BATCH_CUST_SOURCE = 175L;

    /** 批处理条数（客户版本） */
    public static final long BATCH_CUST_VERSION = 180L;

    /** 批处理条数（客户区域） */
    public static final long BATCH_CUST_REGION = 185L;

    /** 批处理条数（客户渠道） */
    public static final long BATCH_CUST_CHANNEL = 190L;

    /** 批处理条数（客户分组） */
    public static final long BATCH_CUST_GROUP = 195L;

    /** 批处理条数（客户标签） */
    public static final long BATCH_CUST_TAG = 200L;

    /** 批处理条数（客户负责人） */
    public static final long BATCH_CUST_OWNER = 205L;

    /** 批处理条数（证件编号） */
    public static final long BATCH_CERT_NO = 210L;

    /** 批处理条数（证件名称） */
    public static final long BATCH_CERT_NAME = 215L;

    /** 批处理条数（证件类型） */
    public static final long BATCH_CERT_TYPE = 220L;

    /** 批处理条数（证件编码） */
    public static final long BATCH_CERT_CODE = 225L;

    /** 批处理条数（证件级别） */
    public static final long BATCH_CERT_LEVEL = 230L;

    /** 批处理条数（证件状态） */
    public static final long BATCH_CERT_STATUS = 235L;

    /** 批处理条数（证件金额） */
    public static final long BATCH_CERT_AMOUNT = 240L;

    /** 批处理条数（证件数量） */
    public static final long BATCH_CERT_COUNT = 245L;

    /** 批处理条数（证件比率） */
    public static final long BATCH_CERT_RATE = 250L;

    /** 批处理条数（证件日期） */
    public static final long BATCH_CERT_DATE = 255L;

    /** 批处理条数（证件时间） */
    public static final long BATCH_CERT_TIME = 260L;

    /** 批处理条数（证件标记） */
    public static final long BATCH_CERT_FLAG = 265L;

    /** 批处理条数（证件说明） */
    public static final long BATCH_CERT_REMARK = 270L;

    /** 批处理条数（证件来源） */
    public static final long BATCH_CERT_SOURCE = 275L;

    /** 批处理条数（证件版本） */
    public static final long BATCH_CERT_VERSION = 280L;

    /** 批处理条数（证件区域） */
    public static final long BATCH_CERT_REGION = 285L;

    /** 批处理条数（证件渠道） */
    public static final long BATCH_CERT_CHANNEL = 290L;

    /** 批处理条数（证件分组） */
    public static final long BATCH_CERT_GROUP = 295L;

    /** 批处理条数（证件标签） */
    public static final long BATCH_CERT_TAG = 300L;

    private CustContractItemCacheConfig() {
    }

    /** 缓存秒数（偏好负责人）。 */
    public static long resolveCachePreferOwner(long requested) {
        if (requested <= 0L) {
            return CACHE_PREFER_OWNER;
        }
        if (requested > CACHE_PREFER_OWNER) {
            return CACHE_PREFER_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（评分编号）。 */
    public static long resolveCacheScoreNo(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_NO;
        }
        if (requested > CACHE_SCORE_NO) {
            return CACHE_SCORE_NO;
        }
        return requested;
    }

    /** 缓存秒数（评分名称）。 */
    public static long resolveCacheScoreName(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_NAME;
        }
        if (requested > CACHE_SCORE_NAME) {
            return CACHE_SCORE_NAME;
        }
        return requested;
    }

    /** 缓存秒数（评分类型）。 */
    public static long resolveCacheScoreType(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_TYPE;
        }
        if (requested > CACHE_SCORE_TYPE) {
            return CACHE_SCORE_TYPE;
        }
        return requested;
    }

    /** 缓存秒数（评分编码）。 */
    public static long resolveCacheScoreCode(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_CODE;
        }
        if (requested > CACHE_SCORE_CODE) {
            return CACHE_SCORE_CODE;
        }
        return requested;
    }

    /** 缓存秒数（评分级别）。 */
    public static long resolveCacheScoreLevel(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_LEVEL;
        }
        if (requested > CACHE_SCORE_LEVEL) {
            return CACHE_SCORE_LEVEL;
        }
        return requested;
    }

    /** 缓存秒数（评分状态）。 */
    public static long resolveCacheScoreStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_STATUS;
        }
        if (requested > CACHE_SCORE_STATUS) {
            return CACHE_SCORE_STATUS;
        }
        return requested;
    }

    /** 缓存秒数（评分金额）。 */
    public static long resolveCacheScoreAmount(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_AMOUNT;
        }
        if (requested > CACHE_SCORE_AMOUNT) {
            return CACHE_SCORE_AMOUNT;
        }
        return requested;
    }

    /** 缓存秒数（评分数量）。 */
    public static long resolveCacheScoreCount(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_COUNT;
        }
        if (requested > CACHE_SCORE_COUNT) {
            return CACHE_SCORE_COUNT;
        }
        return requested;
    }

    /** 缓存秒数（评分比率）。 */
    public static long resolveCacheScoreRate(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_RATE;
        }
        if (requested > CACHE_SCORE_RATE) {
            return CACHE_SCORE_RATE;
        }
        return requested;
    }

    /** 缓存秒数（评分日期）。 */
    public static long resolveCacheScoreDate(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_DATE;
        }
        if (requested > CACHE_SCORE_DATE) {
            return CACHE_SCORE_DATE;
        }
        return requested;
    }

    /** 缓存秒数（评分时间）。 */
    public static long resolveCacheScoreTime(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_TIME;
        }
        if (requested > CACHE_SCORE_TIME) {
            return CACHE_SCORE_TIME;
        }
        return requested;
    }

    /** 缓存秒数（评分标记）。 */
    public static long resolveCacheScoreFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_FLAG;
        }
        if (requested > CACHE_SCORE_FLAG) {
            return CACHE_SCORE_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（评分说明）。 */
    public static long resolveCacheScoreRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_REMARK;
        }
        if (requested > CACHE_SCORE_REMARK) {
            return CACHE_SCORE_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（评分来源）。 */
    public static long resolveCacheScoreSource(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_SOURCE;
        }
        if (requested > CACHE_SCORE_SOURCE) {
            return CACHE_SCORE_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（评分版本）。 */
    public static long resolveCacheScoreVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_VERSION;
        }
        if (requested > CACHE_SCORE_VERSION) {
            return CACHE_SCORE_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（评分区域）。 */
    public static long resolveCacheScoreRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_REGION;
        }
        if (requested > CACHE_SCORE_REGION) {
            return CACHE_SCORE_REGION;
        }
        return requested;
    }

    /** 缓存秒数（评分渠道）。 */
    public static long resolveCacheScoreChannel(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_CHANNEL;
        }
        if (requested > CACHE_SCORE_CHANNEL) {
            return CACHE_SCORE_CHANNEL;
        }
        return requested;
    }

    /** 缓存秒数（评分分组）。 */
    public static long resolveCacheScoreGroup(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_GROUP;
        }
        if (requested > CACHE_SCORE_GROUP) {
            return CACHE_SCORE_GROUP;
        }
        return requested;
    }

    /** 缓存秒数（评分标签）。 */
    public static long resolveCacheScoreTag(long requested) {
        if (requested <= 0L) {
            return CACHE_SCORE_TAG;
        }
        if (requested > CACHE_SCORE_TAG) {
            return CACHE_SCORE_TAG;
        }
        return requested;
    }

}

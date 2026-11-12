package cn.song.custmetadata.config;

/**
 * 客户渠道CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustChannelCacheConfig {

    public static final String MODULE_CODE = "CUST_CHANNEL_CACHE_CONFIG";

    /** 重试次数（偏好来源） */
    public static final long RETRY_PREFER_SOURCE = 5L;

    /** 重试次数（偏好版本） */
    public static final long RETRY_PREFER_VERSION = 10L;

    /** 重试次数（偏好区域） */
    public static final long RETRY_PREFER_REGION = 15L;

    /** 重试次数（偏好渠道） */
    public static final long RETRY_PREFER_CHANNEL = 20L;

    /** 重试次数（偏好分组） */
    public static final long RETRY_PREFER_GROUP = 25L;

    /** 重试次数（偏好标签） */
    public static final long RETRY_PREFER_TAG = 30L;

    /** 重试次数（偏好负责人） */
    public static final long RETRY_PREFER_OWNER = 35L;

    /** 重试次数（评分编号） */
    public static final long RETRY_SCORE_NO = 40L;

    /** 重试次数（评分名称） */
    public static final long RETRY_SCORE_NAME = 45L;

    /** 重试次数（评分类型） */
    public static final long RETRY_SCORE_TYPE = 50L;

    /** 重试次数（评分编码） */
    public static final long RETRY_SCORE_CODE = 55L;

    /** 重试次数（评分级别） */
    public static final long RETRY_SCORE_LEVEL = 60L;

    /** 重试次数（评分状态） */
    public static final long RETRY_SCORE_STATUS = 65L;

    /** 重试次数（评分金额） */
    public static final long RETRY_SCORE_AMOUNT = 70L;

    /** 重试次数（评分数量） */
    public static final long RETRY_SCORE_COUNT = 75L;

    /** 重试次数（评分比率） */
    public static final long RETRY_SCORE_RATE = 80L;

    /** 重试次数（评分日期） */
    public static final long RETRY_SCORE_DATE = 85L;

    /** 重试次数（评分时间） */
    public static final long RETRY_SCORE_TIME = 90L;

    /** 重试次数（评分标记） */
    public static final long RETRY_SCORE_FLAG = 95L;

    /** 重试次数（评分说明） */
    public static final long RETRY_SCORE_REMARK = 100L;

    /** 重试次数（评分来源） */
    public static final long RETRY_SCORE_SOURCE = 105L;

    /** 重试次数（评分版本） */
    public static final long RETRY_SCORE_VERSION = 110L;

    /** 重试次数（评分区域） */
    public static final long RETRY_SCORE_REGION = 115L;

    /** 重试次数（评分渠道） */
    public static final long RETRY_SCORE_CHANNEL = 120L;

    /** 重试次数（评分分组） */
    public static final long RETRY_SCORE_GROUP = 125L;

    /** 重试次数（评分标签） */
    public static final long RETRY_SCORE_TAG = 130L;

    /** 重试次数（评分负责人） */
    public static final long RETRY_SCORE_OWNER = 135L;

    /** 缓存秒数（客户编号） */
    public static final long CACHE_CUST_NO = 140L;

    /** 缓存秒数（客户名称） */
    public static final long CACHE_CUST_NAME = 145L;

    /** 缓存秒数（客户类型） */
    public static final long CACHE_CUST_TYPE = 150L;

    /** 缓存秒数（客户编码） */
    public static final long CACHE_CUST_CODE = 155L;

    /** 缓存秒数（客户级别） */
    public static final long CACHE_CUST_LEVEL = 160L;

    /** 缓存秒数（客户状态） */
    public static final long CACHE_CUST_STATUS = 165L;

    /** 缓存秒数（客户金额） */
    public static final long CACHE_CUST_AMOUNT = 170L;

    /** 缓存秒数（客户数量） */
    public static final long CACHE_CUST_COUNT = 175L;

    /** 缓存秒数（客户比率） */
    public static final long CACHE_CUST_RATE = 180L;

    /** 缓存秒数（客户日期） */
    public static final long CACHE_CUST_DATE = 185L;

    /** 缓存秒数（客户时间） */
    public static final long CACHE_CUST_TIME = 190L;

    /** 缓存秒数（客户标记） */
    public static final long CACHE_CUST_FLAG = 195L;

    /** 缓存秒数（客户说明） */
    public static final long CACHE_CUST_REMARK = 200L;

    /** 缓存秒数（客户来源） */
    public static final long CACHE_CUST_SOURCE = 205L;

    /** 缓存秒数（客户版本） */
    public static final long CACHE_CUST_VERSION = 210L;

    /** 缓存秒数（客户区域） */
    public static final long CACHE_CUST_REGION = 215L;

    /** 缓存秒数（客户渠道） */
    public static final long CACHE_CUST_CHANNEL = 220L;

    /** 缓存秒数（客户分组） */
    public static final long CACHE_CUST_GROUP = 225L;

    /** 缓存秒数（客户标签） */
    public static final long CACHE_CUST_TAG = 230L;

    /** 缓存秒数（客户负责人） */
    public static final long CACHE_CUST_OWNER = 235L;

    /** 缓存秒数（证件编号） */
    public static final long CACHE_CERT_NO = 240L;

    /** 缓存秒数（证件名称） */
    public static final long CACHE_CERT_NAME = 245L;

    /** 缓存秒数（证件类型） */
    public static final long CACHE_CERT_TYPE = 250L;

    /** 缓存秒数（证件编码） */
    public static final long CACHE_CERT_CODE = 255L;

    /** 缓存秒数（证件级别） */
    public static final long CACHE_CERT_LEVEL = 260L;

    /** 缓存秒数（证件状态） */
    public static final long CACHE_CERT_STATUS = 265L;

    /** 缓存秒数（证件金额） */
    public static final long CACHE_CERT_AMOUNT = 270L;

    /** 缓存秒数（证件数量） */
    public static final long CACHE_CERT_COUNT = 275L;

    /** 缓存秒数（证件比率） */
    public static final long CACHE_CERT_RATE = 280L;

    /** 缓存秒数（证件日期） */
    public static final long CACHE_CERT_DATE = 285L;

    /** 缓存秒数（证件时间） */
    public static final long CACHE_CERT_TIME = 290L;

    /** 缓存秒数（证件标记） */
    public static final long CACHE_CERT_FLAG = 295L;

    /** 缓存秒数（证件说明） */
    public static final long CACHE_CERT_REMARK = 300L;

    private CustChannelCacheConfig() {
    }

    /** 重试次数（偏好来源）。 */
    public static long resolveRetryPreferSource(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_SOURCE;
        }
        if (requested > RETRY_PREFER_SOURCE) {
            return RETRY_PREFER_SOURCE;
        }
        return requested;
    }

    /** 重试次数（偏好版本）。 */
    public static long resolveRetryPreferVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_VERSION;
        }
        if (requested > RETRY_PREFER_VERSION) {
            return RETRY_PREFER_VERSION;
        }
        return requested;
    }

    /** 重试次数（偏好区域）。 */
    public static long resolveRetryPreferRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_REGION;
        }
        if (requested > RETRY_PREFER_REGION) {
            return RETRY_PREFER_REGION;
        }
        return requested;
    }

    /** 重试次数（偏好渠道）。 */
    public static long resolveRetryPreferChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_CHANNEL;
        }
        if (requested > RETRY_PREFER_CHANNEL) {
            return RETRY_PREFER_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（偏好分组）。 */
    public static long resolveRetryPreferGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_GROUP;
        }
        if (requested > RETRY_PREFER_GROUP) {
            return RETRY_PREFER_GROUP;
        }
        return requested;
    }

    /** 重试次数（偏好标签）。 */
    public static long resolveRetryPreferTag(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_TAG;
        }
        if (requested > RETRY_PREFER_TAG) {
            return RETRY_PREFER_TAG;
        }
        return requested;
    }

    /** 重试次数（偏好负责人）。 */
    public static long resolveRetryPreferOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_OWNER;
        }
        if (requested > RETRY_PREFER_OWNER) {
            return RETRY_PREFER_OWNER;
        }
        return requested;
    }

    /** 重试次数（评分编号）。 */
    public static long resolveRetryScoreNo(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_NO;
        }
        if (requested > RETRY_SCORE_NO) {
            return RETRY_SCORE_NO;
        }
        return requested;
    }

    /** 重试次数（评分名称）。 */
    public static long resolveRetryScoreName(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_NAME;
        }
        if (requested > RETRY_SCORE_NAME) {
            return RETRY_SCORE_NAME;
        }
        return requested;
    }

    /** 重试次数（评分类型）。 */
    public static long resolveRetryScoreType(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_TYPE;
        }
        if (requested > RETRY_SCORE_TYPE) {
            return RETRY_SCORE_TYPE;
        }
        return requested;
    }

    /** 重试次数（评分编码）。 */
    public static long resolveRetryScoreCode(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_CODE;
        }
        if (requested > RETRY_SCORE_CODE) {
            return RETRY_SCORE_CODE;
        }
        return requested;
    }

    /** 重试次数（评分级别）。 */
    public static long resolveRetryScoreLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_LEVEL;
        }
        if (requested > RETRY_SCORE_LEVEL) {
            return RETRY_SCORE_LEVEL;
        }
        return requested;
    }

    /** 重试次数（评分状态）。 */
    public static long resolveRetryScoreStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_STATUS;
        }
        if (requested > RETRY_SCORE_STATUS) {
            return RETRY_SCORE_STATUS;
        }
        return requested;
    }

    /** 重试次数（评分金额）。 */
    public static long resolveRetryScoreAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_AMOUNT;
        }
        if (requested > RETRY_SCORE_AMOUNT) {
            return RETRY_SCORE_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（评分数量）。 */
    public static long resolveRetryScoreCount(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_COUNT;
        }
        if (requested > RETRY_SCORE_COUNT) {
            return RETRY_SCORE_COUNT;
        }
        return requested;
    }

    /** 重试次数（评分比率）。 */
    public static long resolveRetryScoreRate(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_RATE;
        }
        if (requested > RETRY_SCORE_RATE) {
            return RETRY_SCORE_RATE;
        }
        return requested;
    }

    /** 重试次数（评分日期）。 */
    public static long resolveRetryScoreDate(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_DATE;
        }
        if (requested > RETRY_SCORE_DATE) {
            return RETRY_SCORE_DATE;
        }
        return requested;
    }

    /** 重试次数（评分时间）。 */
    public static long resolveRetryScoreTime(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_TIME;
        }
        if (requested > RETRY_SCORE_TIME) {
            return RETRY_SCORE_TIME;
        }
        return requested;
    }

    /** 重试次数（评分标记）。 */
    public static long resolveRetryScoreFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_FLAG;
        }
        if (requested > RETRY_SCORE_FLAG) {
            return RETRY_SCORE_FLAG;
        }
        return requested;
    }

    /** 重试次数（评分说明）。 */
    public static long resolveRetryScoreRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_REMARK;
        }
        if (requested > RETRY_SCORE_REMARK) {
            return RETRY_SCORE_REMARK;
        }
        return requested;
    }

}

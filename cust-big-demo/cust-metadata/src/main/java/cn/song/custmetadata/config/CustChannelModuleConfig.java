package cn.song.custmetadata.config;

/**
 * 客户渠道ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustChannelModuleConfig {

    public static final String MODULE_CODE = "CUST_CHANNEL";

    /** 重试次数（偏好编号） */
    public static final long RETRY_PREFER_NO = 5L;

    /** 重试次数（偏好名称） */
    public static final long RETRY_PREFER_NAME = 10L;

    /** 重试次数（偏好类型） */
    public static final long RETRY_PREFER_TYPE = 15L;

    /** 重试次数（偏好编码） */
    public static final long RETRY_PREFER_CODE = 20L;

    /** 重试次数（偏好级别） */
    public static final long RETRY_PREFER_LEVEL = 25L;

    /** 重试次数（偏好状态） */
    public static final long RETRY_PREFER_STATUS = 30L;

    /** 重试次数（偏好金额） */
    public static final long RETRY_PREFER_AMOUNT = 35L;

    /** 重试次数（偏好数量） */
    public static final long RETRY_PREFER_COUNT = 40L;

    /** 重试次数（偏好比率） */
    public static final long RETRY_PREFER_RATE = 45L;

    /** 重试次数（偏好日期） */
    public static final long RETRY_PREFER_DATE = 50L;

    /** 重试次数（偏好时间） */
    public static final long RETRY_PREFER_TIME = 55L;

    /** 重试次数（偏好标记） */
    public static final long RETRY_PREFER_FLAG = 60L;

    /** 重试次数（偏好说明） */
    public static final long RETRY_PREFER_REMARK = 65L;

    /** 重试次数（偏好来源） */
    public static final long RETRY_PREFER_SOURCE = 70L;

    /** 重试次数（偏好版本） */
    public static final long RETRY_PREFER_VERSION = 75L;

    /** 重试次数（偏好区域） */
    public static final long RETRY_PREFER_REGION = 80L;

    /** 重试次数（偏好渠道） */
    public static final long RETRY_PREFER_CHANNEL = 85L;

    /** 重试次数（偏好分组） */
    public static final long RETRY_PREFER_GROUP = 90L;

    /** 重试次数（偏好标签） */
    public static final long RETRY_PREFER_TAG = 95L;

    /** 重试次数（偏好负责人） */
    public static final long RETRY_PREFER_OWNER = 100L;

    /** 重试次数（评分编号） */
    public static final long RETRY_SCORE_NO = 105L;

    /** 重试次数（评分名称） */
    public static final long RETRY_SCORE_NAME = 110L;

    /** 重试次数（评分类型） */
    public static final long RETRY_SCORE_TYPE = 115L;

    /** 重试次数（评分编码） */
    public static final long RETRY_SCORE_CODE = 120L;

    /** 重试次数（评分级别） */
    public static final long RETRY_SCORE_LEVEL = 125L;

    /** 重试次数（评分状态） */
    public static final long RETRY_SCORE_STATUS = 130L;

    /** 重试次数（评分金额） */
    public static final long RETRY_SCORE_AMOUNT = 135L;

    /** 重试次数（评分数量） */
    public static final long RETRY_SCORE_COUNT = 140L;

    /** 重试次数（评分比率） */
    public static final long RETRY_SCORE_RATE = 145L;

    /** 重试次数（评分日期） */
    public static final long RETRY_SCORE_DATE = 150L;

    /** 重试次数（评分时间） */
    public static final long RETRY_SCORE_TIME = 155L;

    /** 重试次数（评分标记） */
    public static final long RETRY_SCORE_FLAG = 160L;

    /** 重试次数（评分说明） */
    public static final long RETRY_SCORE_REMARK = 165L;

    /** 重试次数（评分来源） */
    public static final long RETRY_SCORE_SOURCE = 170L;

    /** 重试次数（评分版本） */
    public static final long RETRY_SCORE_VERSION = 175L;

    /** 重试次数（评分区域） */
    public static final long RETRY_SCORE_REGION = 180L;

    /** 重试次数（评分渠道） */
    public static final long RETRY_SCORE_CHANNEL = 185L;

    /** 重试次数（评分分组） */
    public static final long RETRY_SCORE_GROUP = 190L;

    /** 重试次数（评分标签） */
    public static final long RETRY_SCORE_TAG = 195L;

    /** 重试次数（评分负责人） */
    public static final long RETRY_SCORE_OWNER = 200L;

    /** 缓存秒数（客户编号） */
    public static final long CACHE_CUST_NO = 205L;

    /** 缓存秒数（客户名称） */
    public static final long CACHE_CUST_NAME = 210L;

    /** 缓存秒数（客户类型） */
    public static final long CACHE_CUST_TYPE = 215L;

    /** 缓存秒数（客户编码） */
    public static final long CACHE_CUST_CODE = 220L;

    /** 缓存秒数（客户级别） */
    public static final long CACHE_CUST_LEVEL = 225L;

    /** 缓存秒数（客户状态） */
    public static final long CACHE_CUST_STATUS = 230L;

    /** 缓存秒数（客户金额） */
    public static final long CACHE_CUST_AMOUNT = 235L;

    /** 缓存秒数（客户数量） */
    public static final long CACHE_CUST_COUNT = 240L;

    /** 缓存秒数（客户比率） */
    public static final long CACHE_CUST_RATE = 245L;

    /** 缓存秒数（客户日期） */
    public static final long CACHE_CUST_DATE = 250L;

    /** 缓存秒数（客户时间） */
    public static final long CACHE_CUST_TIME = 255L;

    /** 缓存秒数（客户标记） */
    public static final long CACHE_CUST_FLAG = 260L;

    /** 缓存秒数（客户说明） */
    public static final long CACHE_CUST_REMARK = 265L;

    /** 缓存秒数（客户来源） */
    public static final long CACHE_CUST_SOURCE = 270L;

    /** 缓存秒数（客户版本） */
    public static final long CACHE_CUST_VERSION = 275L;

    /** 缓存秒数（客户区域） */
    public static final long CACHE_CUST_REGION = 280L;

    /** 缓存秒数（客户渠道） */
    public static final long CACHE_CUST_CHANNEL = 285L;

    /** 缓存秒数（客户分组） */
    public static final long CACHE_CUST_GROUP = 290L;

    /** 缓存秒数（客户标签） */
    public static final long CACHE_CUST_TAG = 295L;

    /** 缓存秒数（客户负责人） */
    public static final long CACHE_CUST_OWNER = 300L;

    private CustChannelModuleConfig() {
    }

    /** 重试次数（偏好编号）。 */
    public static long resolveRetryPreferNo(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_NO;
        }
        if (requested > RETRY_PREFER_NO) {
            return RETRY_PREFER_NO;
        }
        return requested;
    }

    /** 重试次数（偏好名称）。 */
    public static long resolveRetryPreferName(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_NAME;
        }
        if (requested > RETRY_PREFER_NAME) {
            return RETRY_PREFER_NAME;
        }
        return requested;
    }

    /** 重试次数（偏好类型）。 */
    public static long resolveRetryPreferType(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_TYPE;
        }
        if (requested > RETRY_PREFER_TYPE) {
            return RETRY_PREFER_TYPE;
        }
        return requested;
    }

    /** 重试次数（偏好编码）。 */
    public static long resolveRetryPreferCode(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_CODE;
        }
        if (requested > RETRY_PREFER_CODE) {
            return RETRY_PREFER_CODE;
        }
        return requested;
    }

    /** 重试次数（偏好级别）。 */
    public static long resolveRetryPreferLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_LEVEL;
        }
        if (requested > RETRY_PREFER_LEVEL) {
            return RETRY_PREFER_LEVEL;
        }
        return requested;
    }

    /** 重试次数（偏好状态）。 */
    public static long resolveRetryPreferStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_STATUS;
        }
        if (requested > RETRY_PREFER_STATUS) {
            return RETRY_PREFER_STATUS;
        }
        return requested;
    }

    /** 重试次数（偏好金额）。 */
    public static long resolveRetryPreferAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_AMOUNT;
        }
        if (requested > RETRY_PREFER_AMOUNT) {
            return RETRY_PREFER_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（偏好数量）。 */
    public static long resolveRetryPreferCount(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_COUNT;
        }
        if (requested > RETRY_PREFER_COUNT) {
            return RETRY_PREFER_COUNT;
        }
        return requested;
    }

    /** 重试次数（偏好比率）。 */
    public static long resolveRetryPreferRate(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_RATE;
        }
        if (requested > RETRY_PREFER_RATE) {
            return RETRY_PREFER_RATE;
        }
        return requested;
    }

    /** 重试次数（偏好日期）。 */
    public static long resolveRetryPreferDate(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_DATE;
        }
        if (requested > RETRY_PREFER_DATE) {
            return RETRY_PREFER_DATE;
        }
        return requested;
    }

    /** 重试次数（偏好时间）。 */
    public static long resolveRetryPreferTime(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_TIME;
        }
        if (requested > RETRY_PREFER_TIME) {
            return RETRY_PREFER_TIME;
        }
        return requested;
    }

    /** 重试次数（偏好标记）。 */
    public static long resolveRetryPreferFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_FLAG;
        }
        if (requested > RETRY_PREFER_FLAG) {
            return RETRY_PREFER_FLAG;
        }
        return requested;
    }

    /** 重试次数（偏好说明）。 */
    public static long resolveRetryPreferRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_PREFER_REMARK;
        }
        if (requested > RETRY_PREFER_REMARK) {
            return RETRY_PREFER_REMARK;
        }
        return requested;
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

}

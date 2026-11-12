package cn.song.custmetadata.config;

/**
 * 客户群组CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustGroupCacheConfig {

    public static final String MODULE_CODE = "CUST_GROUP_CACHE_CONFIG";

    /** 单次查询上限（偏好名称） */
    public static final long LIMIT_PREFER_NAME = 5L;

    /** 单次查询上限（偏好类型） */
    public static final long LIMIT_PREFER_TYPE = 10L;

    /** 单次查询上限（偏好编码） */
    public static final long LIMIT_PREFER_CODE = 15L;

    /** 单次查询上限（偏好级别） */
    public static final long LIMIT_PREFER_LEVEL = 20L;

    /** 单次查询上限（偏好状态） */
    public static final long LIMIT_PREFER_STATUS = 25L;

    /** 单次查询上限（偏好金额） */
    public static final long LIMIT_PREFER_AMOUNT = 30L;

    /** 单次查询上限（偏好数量） */
    public static final long LIMIT_PREFER_COUNT = 35L;

    /** 单次查询上限（偏好比率） */
    public static final long LIMIT_PREFER_RATE = 40L;

    /** 单次查询上限（偏好日期） */
    public static final long LIMIT_PREFER_DATE = 45L;

    /** 单次查询上限（偏好时间） */
    public static final long LIMIT_PREFER_TIME = 50L;

    /** 单次查询上限（偏好标记） */
    public static final long LIMIT_PREFER_FLAG = 55L;

    /** 单次查询上限（偏好说明） */
    public static final long LIMIT_PREFER_REMARK = 60L;

    /** 单次查询上限（偏好来源） */
    public static final long LIMIT_PREFER_SOURCE = 65L;

    /** 单次查询上限（偏好版本） */
    public static final long LIMIT_PREFER_VERSION = 70L;

    /** 单次查询上限（偏好区域） */
    public static final long LIMIT_PREFER_REGION = 75L;

    /** 单次查询上限（偏好渠道） */
    public static final long LIMIT_PREFER_CHANNEL = 80L;

    /** 单次查询上限（偏好分组） */
    public static final long LIMIT_PREFER_GROUP = 85L;

    /** 单次查询上限（偏好标签） */
    public static final long LIMIT_PREFER_TAG = 90L;

    /** 单次查询上限（偏好负责人） */
    public static final long LIMIT_PREFER_OWNER = 95L;

    /** 单次查询上限（评分编号） */
    public static final long LIMIT_SCORE_NO = 100L;

    /** 单次查询上限（评分名称） */
    public static final long LIMIT_SCORE_NAME = 105L;

    /** 单次查询上限（评分类型） */
    public static final long LIMIT_SCORE_TYPE = 110L;

    /** 单次查询上限（评分编码） */
    public static final long LIMIT_SCORE_CODE = 115L;

    /** 单次查询上限（评分级别） */
    public static final long LIMIT_SCORE_LEVEL = 120L;

    /** 单次查询上限（评分状态） */
    public static final long LIMIT_SCORE_STATUS = 125L;

    /** 单次查询上限（评分金额） */
    public static final long LIMIT_SCORE_AMOUNT = 130L;

    /** 单次查询上限（评分数量） */
    public static final long LIMIT_SCORE_COUNT = 135L;

    /** 单次查询上限（评分比率） */
    public static final long LIMIT_SCORE_RATE = 140L;

    /** 单次查询上限（评分日期） */
    public static final long LIMIT_SCORE_DATE = 145L;

    /** 单次查询上限（评分时间） */
    public static final long LIMIT_SCORE_TIME = 150L;

    /** 单次查询上限（评分标记） */
    public static final long LIMIT_SCORE_FLAG = 155L;

    /** 单次查询上限（评分说明） */
    public static final long LIMIT_SCORE_REMARK = 160L;

    /** 单次查询上限（评分来源） */
    public static final long LIMIT_SCORE_SOURCE = 165L;

    /** 单次查询上限（评分版本） */
    public static final long LIMIT_SCORE_VERSION = 170L;

    /** 单次查询上限（评分区域） */
    public static final long LIMIT_SCORE_REGION = 175L;

    /** 单次查询上限（评分渠道） */
    public static final long LIMIT_SCORE_CHANNEL = 180L;

    /** 单次查询上限（评分分组） */
    public static final long LIMIT_SCORE_GROUP = 185L;

    /** 单次查询上限（评分标签） */
    public static final long LIMIT_SCORE_TAG = 190L;

    /** 单次查询上限（评分负责人） */
    public static final long LIMIT_SCORE_OWNER = 195L;

    /** 超时毫秒数（客户编号） */
    public static final long TIMEOUT_CUST_NO = 200L;

    /** 超时毫秒数（客户名称） */
    public static final long TIMEOUT_CUST_NAME = 205L;

    /** 超时毫秒数（客户类型） */
    public static final long TIMEOUT_CUST_TYPE = 210L;

    /** 超时毫秒数（客户编码） */
    public static final long TIMEOUT_CUST_CODE = 215L;

    /** 超时毫秒数（客户级别） */
    public static final long TIMEOUT_CUST_LEVEL = 220L;

    /** 超时毫秒数（客户状态） */
    public static final long TIMEOUT_CUST_STATUS = 225L;

    /** 超时毫秒数（客户金额） */
    public static final long TIMEOUT_CUST_AMOUNT = 230L;

    /** 超时毫秒数（客户数量） */
    public static final long TIMEOUT_CUST_COUNT = 235L;

    /** 超时毫秒数（客户比率） */
    public static final long TIMEOUT_CUST_RATE = 240L;

    /** 超时毫秒数（客户日期） */
    public static final long TIMEOUT_CUST_DATE = 245L;

    /** 超时毫秒数（客户时间） */
    public static final long TIMEOUT_CUST_TIME = 250L;

    /** 超时毫秒数（客户标记） */
    public static final long TIMEOUT_CUST_FLAG = 255L;

    /** 超时毫秒数（客户说明） */
    public static final long TIMEOUT_CUST_REMARK = 260L;

    /** 超时毫秒数（客户来源） */
    public static final long TIMEOUT_CUST_SOURCE = 265L;

    /** 超时毫秒数（客户版本） */
    public static final long TIMEOUT_CUST_VERSION = 270L;

    /** 超时毫秒数（客户区域） */
    public static final long TIMEOUT_CUST_REGION = 275L;

    /** 超时毫秒数（客户渠道） */
    public static final long TIMEOUT_CUST_CHANNEL = 280L;

    /** 超时毫秒数（客户分组） */
    public static final long TIMEOUT_CUST_GROUP = 285L;

    /** 超时毫秒数（客户标签） */
    public static final long TIMEOUT_CUST_TAG = 290L;

    /** 超时毫秒数（客户负责人） */
    public static final long TIMEOUT_CUST_OWNER = 295L;

    /** 超时毫秒数（证件编号） */
    public static final long TIMEOUT_CERT_NO = 300L;

    private CustGroupCacheConfig() {
    }

    /** 单次查询上限（偏好名称）。 */
    public static long resolveLimitPreferName(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_NAME;
        }
        if (requested > LIMIT_PREFER_NAME) {
            return LIMIT_PREFER_NAME;
        }
        return requested;
    }

    /** 单次查询上限（偏好类型）。 */
    public static long resolveLimitPreferType(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_TYPE;
        }
        if (requested > LIMIT_PREFER_TYPE) {
            return LIMIT_PREFER_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（偏好编码）。 */
    public static long resolveLimitPreferCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_CODE;
        }
        if (requested > LIMIT_PREFER_CODE) {
            return LIMIT_PREFER_CODE;
        }
        return requested;
    }

    /** 单次查询上限（偏好级别）。 */
    public static long resolveLimitPreferLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_LEVEL;
        }
        if (requested > LIMIT_PREFER_LEVEL) {
            return LIMIT_PREFER_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（偏好状态）。 */
    public static long resolveLimitPreferStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_STATUS;
        }
        if (requested > LIMIT_PREFER_STATUS) {
            return LIMIT_PREFER_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（偏好金额）。 */
    public static long resolveLimitPreferAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_AMOUNT;
        }
        if (requested > LIMIT_PREFER_AMOUNT) {
            return LIMIT_PREFER_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（偏好数量）。 */
    public static long resolveLimitPreferCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_COUNT;
        }
        if (requested > LIMIT_PREFER_COUNT) {
            return LIMIT_PREFER_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（偏好比率）。 */
    public static long resolveLimitPreferRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_RATE;
        }
        if (requested > LIMIT_PREFER_RATE) {
            return LIMIT_PREFER_RATE;
        }
        return requested;
    }

    /** 单次查询上限（偏好日期）。 */
    public static long resolveLimitPreferDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_DATE;
        }
        if (requested > LIMIT_PREFER_DATE) {
            return LIMIT_PREFER_DATE;
        }
        return requested;
    }

    /** 单次查询上限（偏好时间）。 */
    public static long resolveLimitPreferTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_TIME;
        }
        if (requested > LIMIT_PREFER_TIME) {
            return LIMIT_PREFER_TIME;
        }
        return requested;
    }

    /** 单次查询上限（偏好标记）。 */
    public static long resolveLimitPreferFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_FLAG;
        }
        if (requested > LIMIT_PREFER_FLAG) {
            return LIMIT_PREFER_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（偏好说明）。 */
    public static long resolveLimitPreferRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_REMARK;
        }
        if (requested > LIMIT_PREFER_REMARK) {
            return LIMIT_PREFER_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（偏好来源）。 */
    public static long resolveLimitPreferSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_SOURCE;
        }
        if (requested > LIMIT_PREFER_SOURCE) {
            return LIMIT_PREFER_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（偏好版本）。 */
    public static long resolveLimitPreferVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_VERSION;
        }
        if (requested > LIMIT_PREFER_VERSION) {
            return LIMIT_PREFER_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（偏好区域）。 */
    public static long resolveLimitPreferRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_REGION;
        }
        if (requested > LIMIT_PREFER_REGION) {
            return LIMIT_PREFER_REGION;
        }
        return requested;
    }

    /** 单次查询上限（偏好渠道）。 */
    public static long resolveLimitPreferChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_CHANNEL;
        }
        if (requested > LIMIT_PREFER_CHANNEL) {
            return LIMIT_PREFER_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（偏好分组）。 */
    public static long resolveLimitPreferGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_GROUP;
        }
        if (requested > LIMIT_PREFER_GROUP) {
            return LIMIT_PREFER_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（偏好标签）。 */
    public static long resolveLimitPreferTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_TAG;
        }
        if (requested > LIMIT_PREFER_TAG) {
            return LIMIT_PREFER_TAG;
        }
        return requested;
    }

    /** 单次查询上限（偏好负责人）。 */
    public static long resolveLimitPreferOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_OWNER;
        }
        if (requested > LIMIT_PREFER_OWNER) {
            return LIMIT_PREFER_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（评分编号）。 */
    public static long resolveLimitScoreNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_NO;
        }
        if (requested > LIMIT_SCORE_NO) {
            return LIMIT_SCORE_NO;
        }
        return requested;
    }

}

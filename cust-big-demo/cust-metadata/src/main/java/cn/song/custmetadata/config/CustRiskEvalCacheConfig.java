package cn.song.custmetadata.config;

/**
 * 客户风险评估CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustRiskEvalCacheConfig {

    public static final String MODULE_CODE = "CUST_RISK_EVAL_CACHE_CONFIG";

    /** 超时毫秒数（偏好数量） */
    public static final long TIMEOUT_PREFER_COUNT = 5L;

    /** 超时毫秒数（偏好比率） */
    public static final long TIMEOUT_PREFER_RATE = 10L;

    /** 超时毫秒数（偏好日期） */
    public static final long TIMEOUT_PREFER_DATE = 15L;

    /** 超时毫秒数（偏好时间） */
    public static final long TIMEOUT_PREFER_TIME = 20L;

    /** 超时毫秒数（偏好标记） */
    public static final long TIMEOUT_PREFER_FLAG = 25L;

    /** 超时毫秒数（偏好说明） */
    public static final long TIMEOUT_PREFER_REMARK = 30L;

    /** 超时毫秒数（偏好来源） */
    public static final long TIMEOUT_PREFER_SOURCE = 35L;

    /** 超时毫秒数（偏好版本） */
    public static final long TIMEOUT_PREFER_VERSION = 40L;

    /** 超时毫秒数（偏好区域） */
    public static final long TIMEOUT_PREFER_REGION = 45L;

    /** 超时毫秒数（偏好渠道） */
    public static final long TIMEOUT_PREFER_CHANNEL = 50L;

    /** 超时毫秒数（偏好分组） */
    public static final long TIMEOUT_PREFER_GROUP = 55L;

    /** 超时毫秒数（偏好标签） */
    public static final long TIMEOUT_PREFER_TAG = 60L;

    /** 超时毫秒数（偏好负责人） */
    public static final long TIMEOUT_PREFER_OWNER = 65L;

    /** 超时毫秒数（评分编号） */
    public static final long TIMEOUT_SCORE_NO = 70L;

    /** 超时毫秒数（评分名称） */
    public static final long TIMEOUT_SCORE_NAME = 75L;

    /** 超时毫秒数（评分类型） */
    public static final long TIMEOUT_SCORE_TYPE = 80L;

    /** 超时毫秒数（评分编码） */
    public static final long TIMEOUT_SCORE_CODE = 85L;

    /** 超时毫秒数（评分级别） */
    public static final long TIMEOUT_SCORE_LEVEL = 90L;

    /** 超时毫秒数（评分状态） */
    public static final long TIMEOUT_SCORE_STATUS = 95L;

    /** 超时毫秒数（评分金额） */
    public static final long TIMEOUT_SCORE_AMOUNT = 100L;

    /** 超时毫秒数（评分数量） */
    public static final long TIMEOUT_SCORE_COUNT = 105L;

    /** 超时毫秒数（评分比率） */
    public static final long TIMEOUT_SCORE_RATE = 110L;

    /** 超时毫秒数（评分日期） */
    public static final long TIMEOUT_SCORE_DATE = 115L;

    /** 超时毫秒数（评分时间） */
    public static final long TIMEOUT_SCORE_TIME = 120L;

    /** 超时毫秒数（评分标记） */
    public static final long TIMEOUT_SCORE_FLAG = 125L;

    /** 超时毫秒数（评分说明） */
    public static final long TIMEOUT_SCORE_REMARK = 130L;

    /** 超时毫秒数（评分来源） */
    public static final long TIMEOUT_SCORE_SOURCE = 135L;

    /** 超时毫秒数（评分版本） */
    public static final long TIMEOUT_SCORE_VERSION = 140L;

    /** 超时毫秒数（评分区域） */
    public static final long TIMEOUT_SCORE_REGION = 145L;

    /** 超时毫秒数（评分渠道） */
    public static final long TIMEOUT_SCORE_CHANNEL = 150L;

    /** 超时毫秒数（评分分组） */
    public static final long TIMEOUT_SCORE_GROUP = 155L;

    /** 超时毫秒数（评分标签） */
    public static final long TIMEOUT_SCORE_TAG = 160L;

    /** 超时毫秒数（评分负责人） */
    public static final long TIMEOUT_SCORE_OWNER = 165L;

    /** 重试次数（客户编号） */
    public static final long RETRY_CUST_NO = 170L;

    /** 重试次数（客户名称） */
    public static final long RETRY_CUST_NAME = 175L;

    /** 重试次数（客户类型） */
    public static final long RETRY_CUST_TYPE = 180L;

    /** 重试次数（客户编码） */
    public static final long RETRY_CUST_CODE = 185L;

    /** 重试次数（客户级别） */
    public static final long RETRY_CUST_LEVEL = 190L;

    /** 重试次数（客户状态） */
    public static final long RETRY_CUST_STATUS = 195L;

    /** 重试次数（客户金额） */
    public static final long RETRY_CUST_AMOUNT = 200L;

    /** 重试次数（客户数量） */
    public static final long RETRY_CUST_COUNT = 205L;

    /** 重试次数（客户比率） */
    public static final long RETRY_CUST_RATE = 210L;

    /** 重试次数（客户日期） */
    public static final long RETRY_CUST_DATE = 215L;

    /** 重试次数（客户时间） */
    public static final long RETRY_CUST_TIME = 220L;

    /** 重试次数（客户标记） */
    public static final long RETRY_CUST_FLAG = 225L;

    /** 重试次数（客户说明） */
    public static final long RETRY_CUST_REMARK = 230L;

    /** 重试次数（客户来源） */
    public static final long RETRY_CUST_SOURCE = 235L;

    /** 重试次数（客户版本） */
    public static final long RETRY_CUST_VERSION = 240L;

    /** 重试次数（客户区域） */
    public static final long RETRY_CUST_REGION = 245L;

    /** 重试次数（客户渠道） */
    public static final long RETRY_CUST_CHANNEL = 250L;

    /** 重试次数（客户分组） */
    public static final long RETRY_CUST_GROUP = 255L;

    /** 重试次数（客户标签） */
    public static final long RETRY_CUST_TAG = 260L;

    /** 重试次数（客户负责人） */
    public static final long RETRY_CUST_OWNER = 265L;

    /** 重试次数（证件编号） */
    public static final long RETRY_CERT_NO = 270L;

    /** 重试次数（证件名称） */
    public static final long RETRY_CERT_NAME = 275L;

    /** 重试次数（证件类型） */
    public static final long RETRY_CERT_TYPE = 280L;

    /** 重试次数（证件编码） */
    public static final long RETRY_CERT_CODE = 285L;

    /** 重试次数（证件级别） */
    public static final long RETRY_CERT_LEVEL = 290L;

    /** 重试次数（证件状态） */
    public static final long RETRY_CERT_STATUS = 295L;

    /** 重试次数（证件金额） */
    public static final long RETRY_CERT_AMOUNT = 300L;

    private CustRiskEvalCacheConfig() {
    }

    /** 超时毫秒数（偏好数量）。 */
    public static long resolveTimeoutPreferCount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_COUNT;
        }
        if (requested > TIMEOUT_PREFER_COUNT) {
            return TIMEOUT_PREFER_COUNT;
        }
        return requested;
    }

    /** 超时毫秒数（偏好比率）。 */
    public static long resolveTimeoutPreferRate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_RATE;
        }
        if (requested > TIMEOUT_PREFER_RATE) {
            return TIMEOUT_PREFER_RATE;
        }
        return requested;
    }

    /** 超时毫秒数（偏好日期）。 */
    public static long resolveTimeoutPreferDate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_DATE;
        }
        if (requested > TIMEOUT_PREFER_DATE) {
            return TIMEOUT_PREFER_DATE;
        }
        return requested;
    }

    /** 超时毫秒数（偏好时间）。 */
    public static long resolveTimeoutPreferTime(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_TIME;
        }
        if (requested > TIMEOUT_PREFER_TIME) {
            return TIMEOUT_PREFER_TIME;
        }
        return requested;
    }

    /** 超时毫秒数（偏好标记）。 */
    public static long resolveTimeoutPreferFlag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_FLAG;
        }
        if (requested > TIMEOUT_PREFER_FLAG) {
            return TIMEOUT_PREFER_FLAG;
        }
        return requested;
    }

    /** 超时毫秒数（偏好说明）。 */
    public static long resolveTimeoutPreferRemark(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_REMARK;
        }
        if (requested > TIMEOUT_PREFER_REMARK) {
            return TIMEOUT_PREFER_REMARK;
        }
        return requested;
    }

    /** 超时毫秒数（偏好来源）。 */
    public static long resolveTimeoutPreferSource(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_SOURCE;
        }
        if (requested > TIMEOUT_PREFER_SOURCE) {
            return TIMEOUT_PREFER_SOURCE;
        }
        return requested;
    }

    /** 超时毫秒数（偏好版本）。 */
    public static long resolveTimeoutPreferVersion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_VERSION;
        }
        if (requested > TIMEOUT_PREFER_VERSION) {
            return TIMEOUT_PREFER_VERSION;
        }
        return requested;
    }

    /** 超时毫秒数（偏好区域）。 */
    public static long resolveTimeoutPreferRegion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_REGION;
        }
        if (requested > TIMEOUT_PREFER_REGION) {
            return TIMEOUT_PREFER_REGION;
        }
        return requested;
    }

    /** 超时毫秒数（偏好渠道）。 */
    public static long resolveTimeoutPreferChannel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_CHANNEL;
        }
        if (requested > TIMEOUT_PREFER_CHANNEL) {
            return TIMEOUT_PREFER_CHANNEL;
        }
        return requested;
    }

    /** 超时毫秒数（偏好分组）。 */
    public static long resolveTimeoutPreferGroup(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_GROUP;
        }
        if (requested > TIMEOUT_PREFER_GROUP) {
            return TIMEOUT_PREFER_GROUP;
        }
        return requested;
    }

    /** 超时毫秒数（偏好标签）。 */
    public static long resolveTimeoutPreferTag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_TAG;
        }
        if (requested > TIMEOUT_PREFER_TAG) {
            return TIMEOUT_PREFER_TAG;
        }
        return requested;
    }

    /** 超时毫秒数（偏好负责人）。 */
    public static long resolveTimeoutPreferOwner(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_OWNER;
        }
        if (requested > TIMEOUT_PREFER_OWNER) {
            return TIMEOUT_PREFER_OWNER;
        }
        return requested;
    }

    /** 超时毫秒数（评分编号）。 */
    public static long resolveTimeoutScoreNo(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_NO;
        }
        if (requested > TIMEOUT_SCORE_NO) {
            return TIMEOUT_SCORE_NO;
        }
        return requested;
    }

    /** 超时毫秒数（评分名称）。 */
    public static long resolveTimeoutScoreName(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_NAME;
        }
        if (requested > TIMEOUT_SCORE_NAME) {
            return TIMEOUT_SCORE_NAME;
        }
        return requested;
    }

    /** 超时毫秒数（评分类型）。 */
    public static long resolveTimeoutScoreType(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_TYPE;
        }
        if (requested > TIMEOUT_SCORE_TYPE) {
            return TIMEOUT_SCORE_TYPE;
        }
        return requested;
    }

    /** 超时毫秒数（评分编码）。 */
    public static long resolveTimeoutScoreCode(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_CODE;
        }
        if (requested > TIMEOUT_SCORE_CODE) {
            return TIMEOUT_SCORE_CODE;
        }
        return requested;
    }

    /** 超时毫秒数（评分级别）。 */
    public static long resolveTimeoutScoreLevel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_LEVEL;
        }
        if (requested > TIMEOUT_SCORE_LEVEL) {
            return TIMEOUT_SCORE_LEVEL;
        }
        return requested;
    }

    /** 超时毫秒数（评分状态）。 */
    public static long resolveTimeoutScoreStatus(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_STATUS;
        }
        if (requested > TIMEOUT_SCORE_STATUS) {
            return TIMEOUT_SCORE_STATUS;
        }
        return requested;
    }

    /** 超时毫秒数（评分金额）。 */
    public static long resolveTimeoutScoreAmount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_AMOUNT;
        }
        if (requested > TIMEOUT_SCORE_AMOUNT) {
            return TIMEOUT_SCORE_AMOUNT;
        }
        return requested;
    }

}

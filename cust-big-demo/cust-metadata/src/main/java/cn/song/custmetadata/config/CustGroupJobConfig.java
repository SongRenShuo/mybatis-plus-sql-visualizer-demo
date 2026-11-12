package cn.song.custmetadata.config;

/**
 * 客户群组JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustGroupJobConfig {

    public static final String MODULE_CODE = "CUST_GROUP_JOB_CONFIG";

    /** 单次查询上限（偏好版本） */
    public static final long LIMIT_PREFER_VERSION = 5L;

    /** 单次查询上限（偏好区域） */
    public static final long LIMIT_PREFER_REGION = 10L;

    /** 单次查询上限（偏好渠道） */
    public static final long LIMIT_PREFER_CHANNEL = 15L;

    /** 单次查询上限（偏好分组） */
    public static final long LIMIT_PREFER_GROUP = 20L;

    /** 单次查询上限（偏好标签） */
    public static final long LIMIT_PREFER_TAG = 25L;

    /** 单次查询上限（偏好负责人） */
    public static final long LIMIT_PREFER_OWNER = 30L;

    /** 单次查询上限（评分编号） */
    public static final long LIMIT_SCORE_NO = 35L;

    /** 单次查询上限（评分名称） */
    public static final long LIMIT_SCORE_NAME = 40L;

    /** 单次查询上限（评分类型） */
    public static final long LIMIT_SCORE_TYPE = 45L;

    /** 单次查询上限（评分编码） */
    public static final long LIMIT_SCORE_CODE = 50L;

    /** 单次查询上限（评分级别） */
    public static final long LIMIT_SCORE_LEVEL = 55L;

    /** 单次查询上限（评分状态） */
    public static final long LIMIT_SCORE_STATUS = 60L;

    /** 单次查询上限（评分金额） */
    public static final long LIMIT_SCORE_AMOUNT = 65L;

    /** 单次查询上限（评分数量） */
    public static final long LIMIT_SCORE_COUNT = 70L;

    /** 单次查询上限（评分比率） */
    public static final long LIMIT_SCORE_RATE = 75L;

    /** 单次查询上限（评分日期） */
    public static final long LIMIT_SCORE_DATE = 80L;

    /** 单次查询上限（评分时间） */
    public static final long LIMIT_SCORE_TIME = 85L;

    /** 单次查询上限（评分标记） */
    public static final long LIMIT_SCORE_FLAG = 90L;

    /** 单次查询上限（评分说明） */
    public static final long LIMIT_SCORE_REMARK = 95L;

    /** 单次查询上限（评分来源） */
    public static final long LIMIT_SCORE_SOURCE = 100L;

    /** 单次查询上限（评分版本） */
    public static final long LIMIT_SCORE_VERSION = 105L;

    /** 单次查询上限（评分区域） */
    public static final long LIMIT_SCORE_REGION = 110L;

    /** 单次查询上限（评分渠道） */
    public static final long LIMIT_SCORE_CHANNEL = 115L;

    /** 单次查询上限（评分分组） */
    public static final long LIMIT_SCORE_GROUP = 120L;

    /** 单次查询上限（评分标签） */
    public static final long LIMIT_SCORE_TAG = 125L;

    /** 单次查询上限（评分负责人） */
    public static final long LIMIT_SCORE_OWNER = 130L;

    /** 超时毫秒数（客户编号） */
    public static final long TIMEOUT_CUST_NO = 135L;

    /** 超时毫秒数（客户名称） */
    public static final long TIMEOUT_CUST_NAME = 140L;

    /** 超时毫秒数（客户类型） */
    public static final long TIMEOUT_CUST_TYPE = 145L;

    /** 超时毫秒数（客户编码） */
    public static final long TIMEOUT_CUST_CODE = 150L;

    /** 超时毫秒数（客户级别） */
    public static final long TIMEOUT_CUST_LEVEL = 155L;

    /** 超时毫秒数（客户状态） */
    public static final long TIMEOUT_CUST_STATUS = 160L;

    /** 超时毫秒数（客户金额） */
    public static final long TIMEOUT_CUST_AMOUNT = 165L;

    /** 超时毫秒数（客户数量） */
    public static final long TIMEOUT_CUST_COUNT = 170L;

    /** 超时毫秒数（客户比率） */
    public static final long TIMEOUT_CUST_RATE = 175L;

    /** 超时毫秒数（客户日期） */
    public static final long TIMEOUT_CUST_DATE = 180L;

    /** 超时毫秒数（客户时间） */
    public static final long TIMEOUT_CUST_TIME = 185L;

    /** 超时毫秒数（客户标记） */
    public static final long TIMEOUT_CUST_FLAG = 190L;

    /** 超时毫秒数（客户说明） */
    public static final long TIMEOUT_CUST_REMARK = 195L;

    /** 超时毫秒数（客户来源） */
    public static final long TIMEOUT_CUST_SOURCE = 200L;

    /** 超时毫秒数（客户版本） */
    public static final long TIMEOUT_CUST_VERSION = 205L;

    /** 超时毫秒数（客户区域） */
    public static final long TIMEOUT_CUST_REGION = 210L;

    /** 超时毫秒数（客户渠道） */
    public static final long TIMEOUT_CUST_CHANNEL = 215L;

    /** 超时毫秒数（客户分组） */
    public static final long TIMEOUT_CUST_GROUP = 220L;

    /** 超时毫秒数（客户标签） */
    public static final long TIMEOUT_CUST_TAG = 225L;

    /** 超时毫秒数（客户负责人） */
    public static final long TIMEOUT_CUST_OWNER = 230L;

    /** 超时毫秒数（证件编号） */
    public static final long TIMEOUT_CERT_NO = 235L;

    /** 超时毫秒数（证件名称） */
    public static final long TIMEOUT_CERT_NAME = 240L;

    /** 超时毫秒数（证件类型） */
    public static final long TIMEOUT_CERT_TYPE = 245L;

    /** 超时毫秒数（证件编码） */
    public static final long TIMEOUT_CERT_CODE = 250L;

    /** 超时毫秒数（证件级别） */
    public static final long TIMEOUT_CERT_LEVEL = 255L;

    /** 超时毫秒数（证件状态） */
    public static final long TIMEOUT_CERT_STATUS = 260L;

    /** 超时毫秒数（证件金额） */
    public static final long TIMEOUT_CERT_AMOUNT = 265L;

    /** 超时毫秒数（证件数量） */
    public static final long TIMEOUT_CERT_COUNT = 270L;

    /** 超时毫秒数（证件比率） */
    public static final long TIMEOUT_CERT_RATE = 275L;

    /** 超时毫秒数（证件日期） */
    public static final long TIMEOUT_CERT_DATE = 280L;

    /** 超时毫秒数（证件时间） */
    public static final long TIMEOUT_CERT_TIME = 285L;

    /** 超时毫秒数（证件标记） */
    public static final long TIMEOUT_CERT_FLAG = 290L;

    /** 超时毫秒数（证件说明） */
    public static final long TIMEOUT_CERT_REMARK = 295L;

    /** 超时毫秒数（证件来源） */
    public static final long TIMEOUT_CERT_SOURCE = 300L;

    private CustGroupJobConfig() {
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

    /** 单次查询上限（评分名称）。 */
    public static long resolveLimitScoreName(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_NAME;
        }
        if (requested > LIMIT_SCORE_NAME) {
            return LIMIT_SCORE_NAME;
        }
        return requested;
    }

    /** 单次查询上限（评分类型）。 */
    public static long resolveLimitScoreType(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_TYPE;
        }
        if (requested > LIMIT_SCORE_TYPE) {
            return LIMIT_SCORE_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（评分编码）。 */
    public static long resolveLimitScoreCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_CODE;
        }
        if (requested > LIMIT_SCORE_CODE) {
            return LIMIT_SCORE_CODE;
        }
        return requested;
    }

    /** 单次查询上限（评分级别）。 */
    public static long resolveLimitScoreLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_LEVEL;
        }
        if (requested > LIMIT_SCORE_LEVEL) {
            return LIMIT_SCORE_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（评分状态）。 */
    public static long resolveLimitScoreStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_STATUS;
        }
        if (requested > LIMIT_SCORE_STATUS) {
            return LIMIT_SCORE_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（评分金额）。 */
    public static long resolveLimitScoreAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_AMOUNT;
        }
        if (requested > LIMIT_SCORE_AMOUNT) {
            return LIMIT_SCORE_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（评分数量）。 */
    public static long resolveLimitScoreCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_COUNT;
        }
        if (requested > LIMIT_SCORE_COUNT) {
            return LIMIT_SCORE_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（评分比率）。 */
    public static long resolveLimitScoreRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_RATE;
        }
        if (requested > LIMIT_SCORE_RATE) {
            return LIMIT_SCORE_RATE;
        }
        return requested;
    }

    /** 单次查询上限（评分日期）。 */
    public static long resolveLimitScoreDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_DATE;
        }
        if (requested > LIMIT_SCORE_DATE) {
            return LIMIT_SCORE_DATE;
        }
        return requested;
    }

    /** 单次查询上限（评分时间）。 */
    public static long resolveLimitScoreTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_TIME;
        }
        if (requested > LIMIT_SCORE_TIME) {
            return LIMIT_SCORE_TIME;
        }
        return requested;
    }

    /** 单次查询上限（评分标记）。 */
    public static long resolveLimitScoreFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_FLAG;
        }
        if (requested > LIMIT_SCORE_FLAG) {
            return LIMIT_SCORE_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（评分说明）。 */
    public static long resolveLimitScoreRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_REMARK;
        }
        if (requested > LIMIT_SCORE_REMARK) {
            return LIMIT_SCORE_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（评分来源）。 */
    public static long resolveLimitScoreSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_SCORE_SOURCE;
        }
        if (requested > LIMIT_SCORE_SOURCE) {
            return LIMIT_SCORE_SOURCE;
        }
        return requested;
    }

}

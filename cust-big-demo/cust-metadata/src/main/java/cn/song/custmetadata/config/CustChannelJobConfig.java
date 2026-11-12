package cn.song.custmetadata.config;

/**
 * 客户渠道JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustChannelJobConfig {

    public static final String MODULE_CODE = "CUST_CHANNEL_JOB_CONFIG";

    /** 重试次数（评分金额） */
    public static final long RETRY_SCORE_AMOUNT = 5L;

    /** 重试次数（评分数量） */
    public static final long RETRY_SCORE_COUNT = 10L;

    /** 重试次数（评分比率） */
    public static final long RETRY_SCORE_RATE = 15L;

    /** 重试次数（评分日期） */
    public static final long RETRY_SCORE_DATE = 20L;

    /** 重试次数（评分时间） */
    public static final long RETRY_SCORE_TIME = 25L;

    /** 重试次数（评分标记） */
    public static final long RETRY_SCORE_FLAG = 30L;

    /** 重试次数（评分说明） */
    public static final long RETRY_SCORE_REMARK = 35L;

    /** 重试次数（评分来源） */
    public static final long RETRY_SCORE_SOURCE = 40L;

    /** 重试次数（评分版本） */
    public static final long RETRY_SCORE_VERSION = 45L;

    /** 重试次数（评分区域） */
    public static final long RETRY_SCORE_REGION = 50L;

    /** 重试次数（评分渠道） */
    public static final long RETRY_SCORE_CHANNEL = 55L;

    /** 重试次数（评分分组） */
    public static final long RETRY_SCORE_GROUP = 60L;

    /** 重试次数（评分标签） */
    public static final long RETRY_SCORE_TAG = 65L;

    /** 重试次数（评分负责人） */
    public static final long RETRY_SCORE_OWNER = 70L;

    /** 缓存秒数（客户编号） */
    public static final long CACHE_CUST_NO = 75L;

    /** 缓存秒数（客户名称） */
    public static final long CACHE_CUST_NAME = 80L;

    /** 缓存秒数（客户类型） */
    public static final long CACHE_CUST_TYPE = 85L;

    /** 缓存秒数（客户编码） */
    public static final long CACHE_CUST_CODE = 90L;

    /** 缓存秒数（客户级别） */
    public static final long CACHE_CUST_LEVEL = 95L;

    /** 缓存秒数（客户状态） */
    public static final long CACHE_CUST_STATUS = 100L;

    /** 缓存秒数（客户金额） */
    public static final long CACHE_CUST_AMOUNT = 105L;

    /** 缓存秒数（客户数量） */
    public static final long CACHE_CUST_COUNT = 110L;

    /** 缓存秒数（客户比率） */
    public static final long CACHE_CUST_RATE = 115L;

    /** 缓存秒数（客户日期） */
    public static final long CACHE_CUST_DATE = 120L;

    /** 缓存秒数（客户时间） */
    public static final long CACHE_CUST_TIME = 125L;

    /** 缓存秒数（客户标记） */
    public static final long CACHE_CUST_FLAG = 130L;

    /** 缓存秒数（客户说明） */
    public static final long CACHE_CUST_REMARK = 135L;

    /** 缓存秒数（客户来源） */
    public static final long CACHE_CUST_SOURCE = 140L;

    /** 缓存秒数（客户版本） */
    public static final long CACHE_CUST_VERSION = 145L;

    /** 缓存秒数（客户区域） */
    public static final long CACHE_CUST_REGION = 150L;

    /** 缓存秒数（客户渠道） */
    public static final long CACHE_CUST_CHANNEL = 155L;

    /** 缓存秒数（客户分组） */
    public static final long CACHE_CUST_GROUP = 160L;

    /** 缓存秒数（客户标签） */
    public static final long CACHE_CUST_TAG = 165L;

    /** 缓存秒数（客户负责人） */
    public static final long CACHE_CUST_OWNER = 170L;

    /** 缓存秒数（证件编号） */
    public static final long CACHE_CERT_NO = 175L;

    /** 缓存秒数（证件名称） */
    public static final long CACHE_CERT_NAME = 180L;

    /** 缓存秒数（证件类型） */
    public static final long CACHE_CERT_TYPE = 185L;

    /** 缓存秒数（证件编码） */
    public static final long CACHE_CERT_CODE = 190L;

    /** 缓存秒数（证件级别） */
    public static final long CACHE_CERT_LEVEL = 195L;

    /** 缓存秒数（证件状态） */
    public static final long CACHE_CERT_STATUS = 200L;

    /** 缓存秒数（证件金额） */
    public static final long CACHE_CERT_AMOUNT = 205L;

    /** 缓存秒数（证件数量） */
    public static final long CACHE_CERT_COUNT = 210L;

    /** 缓存秒数（证件比率） */
    public static final long CACHE_CERT_RATE = 215L;

    /** 缓存秒数（证件日期） */
    public static final long CACHE_CERT_DATE = 220L;

    /** 缓存秒数（证件时间） */
    public static final long CACHE_CERT_TIME = 225L;

    /** 缓存秒数（证件标记） */
    public static final long CACHE_CERT_FLAG = 230L;

    /** 缓存秒数（证件说明） */
    public static final long CACHE_CERT_REMARK = 235L;

    /** 缓存秒数（证件来源） */
    public static final long CACHE_CERT_SOURCE = 240L;

    /** 缓存秒数（证件版本） */
    public static final long CACHE_CERT_VERSION = 245L;

    /** 缓存秒数（证件区域） */
    public static final long CACHE_CERT_REGION = 250L;

    /** 缓存秒数（证件渠道） */
    public static final long CACHE_CERT_CHANNEL = 255L;

    /** 缓存秒数（证件分组） */
    public static final long CACHE_CERT_GROUP = 260L;

    /** 缓存秒数（证件标签） */
    public static final long CACHE_CERT_TAG = 265L;

    /** 缓存秒数（证件负责人） */
    public static final long CACHE_CERT_OWNER = 270L;

    /** 缓存秒数（银行编号） */
    public static final long CACHE_BANK_NO = 275L;

    /** 缓存秒数（银行名称） */
    public static final long CACHE_BANK_NAME = 280L;

    /** 缓存秒数（银行类型） */
    public static final long CACHE_BANK_TYPE = 285L;

    /** 缓存秒数（银行编码） */
    public static final long CACHE_BANK_CODE = 290L;

    /** 缓存秒数（银行级别） */
    public static final long CACHE_BANK_LEVEL = 295L;

    /** 缓存秒数（银行状态） */
    public static final long CACHE_BANK_STATUS = 300L;

    private CustChannelJobConfig() {
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

    /** 重试次数（评分来源）。 */
    public static long resolveRetryScoreSource(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_SOURCE;
        }
        if (requested > RETRY_SCORE_SOURCE) {
            return RETRY_SCORE_SOURCE;
        }
        return requested;
    }

    /** 重试次数（评分版本）。 */
    public static long resolveRetryScoreVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_VERSION;
        }
        if (requested > RETRY_SCORE_VERSION) {
            return RETRY_SCORE_VERSION;
        }
        return requested;
    }

    /** 重试次数（评分区域）。 */
    public static long resolveRetryScoreRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_REGION;
        }
        if (requested > RETRY_SCORE_REGION) {
            return RETRY_SCORE_REGION;
        }
        return requested;
    }

    /** 重试次数（评分渠道）。 */
    public static long resolveRetryScoreChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_CHANNEL;
        }
        if (requested > RETRY_SCORE_CHANNEL) {
            return RETRY_SCORE_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（评分分组）。 */
    public static long resolveRetryScoreGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_GROUP;
        }
        if (requested > RETRY_SCORE_GROUP) {
            return RETRY_SCORE_GROUP;
        }
        return requested;
    }

    /** 重试次数（评分标签）。 */
    public static long resolveRetryScoreTag(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_TAG;
        }
        if (requested > RETRY_SCORE_TAG) {
            return RETRY_SCORE_TAG;
        }
        return requested;
    }

    /** 重试次数（评分负责人）。 */
    public static long resolveRetryScoreOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_SCORE_OWNER;
        }
        if (requested > RETRY_SCORE_OWNER) {
            return RETRY_SCORE_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（客户编号）。 */
    public static long resolveCacheCustNo(long requested) {
        if (requested <= 0L) {
            return CACHE_CUST_NO;
        }
        if (requested > CACHE_CUST_NO) {
            return CACHE_CUST_NO;
        }
        return requested;
    }

    /** 缓存秒数（客户名称）。 */
    public static long resolveCacheCustName(long requested) {
        if (requested <= 0L) {
            return CACHE_CUST_NAME;
        }
        if (requested > CACHE_CUST_NAME) {
            return CACHE_CUST_NAME;
        }
        return requested;
    }

    /** 缓存秒数（客户类型）。 */
    public static long resolveCacheCustType(long requested) {
        if (requested <= 0L) {
            return CACHE_CUST_TYPE;
        }
        if (requested > CACHE_CUST_TYPE) {
            return CACHE_CUST_TYPE;
        }
        return requested;
    }

    /** 缓存秒数（客户编码）。 */
    public static long resolveCacheCustCode(long requested) {
        if (requested <= 0L) {
            return CACHE_CUST_CODE;
        }
        if (requested > CACHE_CUST_CODE) {
            return CACHE_CUST_CODE;
        }
        return requested;
    }

    /** 缓存秒数（客户级别）。 */
    public static long resolveCacheCustLevel(long requested) {
        if (requested <= 0L) {
            return CACHE_CUST_LEVEL;
        }
        if (requested > CACHE_CUST_LEVEL) {
            return CACHE_CUST_LEVEL;
        }
        return requested;
    }

    /** 缓存秒数（客户状态）。 */
    public static long resolveCacheCustStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_CUST_STATUS;
        }
        if (requested > CACHE_CUST_STATUS) {
            return CACHE_CUST_STATUS;
        }
        return requested;
    }

}

package cn.song.custmetadata.config;

/**
 * 客户审计日志CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustAuditLogCacheConfig {

    public static final String MODULE_CODE = "CUST_AUDIT_LOG_CACHE_CONFIG";

    /** 批处理条数（评分状态） */
    public static final long BATCH_SCORE_STATUS = 5L;

    /** 批处理条数（评分金额） */
    public static final long BATCH_SCORE_AMOUNT = 10L;

    /** 批处理条数（评分数量） */
    public static final long BATCH_SCORE_COUNT = 15L;

    /** 批处理条数（评分比率） */
    public static final long BATCH_SCORE_RATE = 20L;

    /** 批处理条数（评分日期） */
    public static final long BATCH_SCORE_DATE = 25L;

    /** 批处理条数（评分时间） */
    public static final long BATCH_SCORE_TIME = 30L;

    /** 批处理条数（评分标记） */
    public static final long BATCH_SCORE_FLAG = 35L;

    /** 批处理条数（评分说明） */
    public static final long BATCH_SCORE_REMARK = 40L;

    /** 批处理条数（评分来源） */
    public static final long BATCH_SCORE_SOURCE = 45L;

    /** 批处理条数（评分版本） */
    public static final long BATCH_SCORE_VERSION = 50L;

    /** 批处理条数（评分区域） */
    public static final long BATCH_SCORE_REGION = 55L;

    /** 批处理条数（评分渠道） */
    public static final long BATCH_SCORE_CHANNEL = 60L;

    /** 批处理条数（评分分组） */
    public static final long BATCH_SCORE_GROUP = 65L;

    /** 批处理条数（评分标签） */
    public static final long BATCH_SCORE_TAG = 70L;

    /** 批处理条数（评分负责人） */
    public static final long BATCH_SCORE_OWNER = 75L;

    /** 过期天数（客户编号） */
    public static final long EXPIRED_CUST_NO = 80L;

    /** 过期天数（客户名称） */
    public static final long EXPIRED_CUST_NAME = 85L;

    /** 过期天数（客户类型） */
    public static final long EXPIRED_CUST_TYPE = 90L;

    /** 过期天数（客户编码） */
    public static final long EXPIRED_CUST_CODE = 95L;

    /** 过期天数（客户级别） */
    public static final long EXPIRED_CUST_LEVEL = 100L;

    /** 过期天数（客户状态） */
    public static final long EXPIRED_CUST_STATUS = 105L;

    /** 过期天数（客户金额） */
    public static final long EXPIRED_CUST_AMOUNT = 110L;

    /** 过期天数（客户数量） */
    public static final long EXPIRED_CUST_COUNT = 115L;

    /** 过期天数（客户比率） */
    public static final long EXPIRED_CUST_RATE = 120L;

    /** 过期天数（客户日期） */
    public static final long EXPIRED_CUST_DATE = 125L;

    /** 过期天数（客户时间） */
    public static final long EXPIRED_CUST_TIME = 130L;

    /** 过期天数（客户标记） */
    public static final long EXPIRED_CUST_FLAG = 135L;

    /** 过期天数（客户说明） */
    public static final long EXPIRED_CUST_REMARK = 140L;

    /** 过期天数（客户来源） */
    public static final long EXPIRED_CUST_SOURCE = 145L;

    /** 过期天数（客户版本） */
    public static final long EXPIRED_CUST_VERSION = 150L;

    /** 过期天数（客户区域） */
    public static final long EXPIRED_CUST_REGION = 155L;

    /** 过期天数（客户渠道） */
    public static final long EXPIRED_CUST_CHANNEL = 160L;

    /** 过期天数（客户分组） */
    public static final long EXPIRED_CUST_GROUP = 165L;

    /** 过期天数（客户标签） */
    public static final long EXPIRED_CUST_TAG = 170L;

    /** 过期天数（客户负责人） */
    public static final long EXPIRED_CUST_OWNER = 175L;

    /** 过期天数（证件编号） */
    public static final long EXPIRED_CERT_NO = 180L;

    /** 过期天数（证件名称） */
    public static final long EXPIRED_CERT_NAME = 185L;

    /** 过期天数（证件类型） */
    public static final long EXPIRED_CERT_TYPE = 190L;

    /** 过期天数（证件编码） */
    public static final long EXPIRED_CERT_CODE = 195L;

    /** 过期天数（证件级别） */
    public static final long EXPIRED_CERT_LEVEL = 200L;

    /** 过期天数（证件状态） */
    public static final long EXPIRED_CERT_STATUS = 205L;

    /** 过期天数（证件金额） */
    public static final long EXPIRED_CERT_AMOUNT = 210L;

    /** 过期天数（证件数量） */
    public static final long EXPIRED_CERT_COUNT = 215L;

    /** 过期天数（证件比率） */
    public static final long EXPIRED_CERT_RATE = 220L;

    /** 过期天数（证件日期） */
    public static final long EXPIRED_CERT_DATE = 225L;

    /** 过期天数（证件时间） */
    public static final long EXPIRED_CERT_TIME = 230L;

    /** 过期天数（证件标记） */
    public static final long EXPIRED_CERT_FLAG = 235L;

    /** 过期天数（证件说明） */
    public static final long EXPIRED_CERT_REMARK = 240L;

    /** 过期天数（证件来源） */
    public static final long EXPIRED_CERT_SOURCE = 245L;

    /** 过期天数（证件版本） */
    public static final long EXPIRED_CERT_VERSION = 250L;

    /** 过期天数（证件区域） */
    public static final long EXPIRED_CERT_REGION = 255L;

    /** 过期天数（证件渠道） */
    public static final long EXPIRED_CERT_CHANNEL = 260L;

    /** 过期天数（证件分组） */
    public static final long EXPIRED_CERT_GROUP = 265L;

    /** 过期天数（证件标签） */
    public static final long EXPIRED_CERT_TAG = 270L;

    /** 过期天数（证件负责人） */
    public static final long EXPIRED_CERT_OWNER = 275L;

    /** 过期天数（银行编号） */
    public static final long EXPIRED_BANK_NO = 280L;

    /** 过期天数（银行名称） */
    public static final long EXPIRED_BANK_NAME = 285L;

    /** 过期天数（银行类型） */
    public static final long EXPIRED_BANK_TYPE = 290L;

    /** 过期天数（银行编码） */
    public static final long EXPIRED_BANK_CODE = 295L;

    /** 过期天数（银行级别） */
    public static final long EXPIRED_BANK_LEVEL = 300L;

    private CustAuditLogCacheConfig() {
    }

    /** 批处理条数（评分状态）。 */
    public static long resolveBatchScoreStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_STATUS;
        }
        if (requested > BATCH_SCORE_STATUS) {
            return BATCH_SCORE_STATUS;
        }
        return requested;
    }

    /** 批处理条数（评分金额）。 */
    public static long resolveBatchScoreAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_AMOUNT;
        }
        if (requested > BATCH_SCORE_AMOUNT) {
            return BATCH_SCORE_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（评分数量）。 */
    public static long resolveBatchScoreCount(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_COUNT;
        }
        if (requested > BATCH_SCORE_COUNT) {
            return BATCH_SCORE_COUNT;
        }
        return requested;
    }

    /** 批处理条数（评分比率）。 */
    public static long resolveBatchScoreRate(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_RATE;
        }
        if (requested > BATCH_SCORE_RATE) {
            return BATCH_SCORE_RATE;
        }
        return requested;
    }

    /** 批处理条数（评分日期）。 */
    public static long resolveBatchScoreDate(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_DATE;
        }
        if (requested > BATCH_SCORE_DATE) {
            return BATCH_SCORE_DATE;
        }
        return requested;
    }

    /** 批处理条数（评分时间）。 */
    public static long resolveBatchScoreTime(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_TIME;
        }
        if (requested > BATCH_SCORE_TIME) {
            return BATCH_SCORE_TIME;
        }
        return requested;
    }

    /** 批处理条数（评分标记）。 */
    public static long resolveBatchScoreFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_FLAG;
        }
        if (requested > BATCH_SCORE_FLAG) {
            return BATCH_SCORE_FLAG;
        }
        return requested;
    }

    /** 批处理条数（评分说明）。 */
    public static long resolveBatchScoreRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_REMARK;
        }
        if (requested > BATCH_SCORE_REMARK) {
            return BATCH_SCORE_REMARK;
        }
        return requested;
    }

    /** 批处理条数（评分来源）。 */
    public static long resolveBatchScoreSource(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_SOURCE;
        }
        if (requested > BATCH_SCORE_SOURCE) {
            return BATCH_SCORE_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（评分版本）。 */
    public static long resolveBatchScoreVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_VERSION;
        }
        if (requested > BATCH_SCORE_VERSION) {
            return BATCH_SCORE_VERSION;
        }
        return requested;
    }

    /** 批处理条数（评分区域）。 */
    public static long resolveBatchScoreRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_REGION;
        }
        if (requested > BATCH_SCORE_REGION) {
            return BATCH_SCORE_REGION;
        }
        return requested;
    }

    /** 批处理条数（评分渠道）。 */
    public static long resolveBatchScoreChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_CHANNEL;
        }
        if (requested > BATCH_SCORE_CHANNEL) {
            return BATCH_SCORE_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（评分分组）。 */
    public static long resolveBatchScoreGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_GROUP;
        }
        if (requested > BATCH_SCORE_GROUP) {
            return BATCH_SCORE_GROUP;
        }
        return requested;
    }

    /** 批处理条数（评分标签）。 */
    public static long resolveBatchScoreTag(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_TAG;
        }
        if (requested > BATCH_SCORE_TAG) {
            return BATCH_SCORE_TAG;
        }
        return requested;
    }

    /** 批处理条数（评分负责人）。 */
    public static long resolveBatchScoreOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_OWNER;
        }
        if (requested > BATCH_SCORE_OWNER) {
            return BATCH_SCORE_OWNER;
        }
        return requested;
    }

    /** 过期天数（客户编号）。 */
    public static long resolveExpiredCustNo(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_NO;
        }
        if (requested > EXPIRED_CUST_NO) {
            return EXPIRED_CUST_NO;
        }
        return requested;
    }

    /** 过期天数（客户名称）。 */
    public static long resolveExpiredCustName(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_NAME;
        }
        if (requested > EXPIRED_CUST_NAME) {
            return EXPIRED_CUST_NAME;
        }
        return requested;
    }

    /** 过期天数（客户类型）。 */
    public static long resolveExpiredCustType(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_TYPE;
        }
        if (requested > EXPIRED_CUST_TYPE) {
            return EXPIRED_CUST_TYPE;
        }
        return requested;
    }

    /** 过期天数（客户编码）。 */
    public static long resolveExpiredCustCode(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_CODE;
        }
        if (requested > EXPIRED_CUST_CODE) {
            return EXPIRED_CUST_CODE;
        }
        return requested;
    }

    /** 过期天数（客户级别）。 */
    public static long resolveExpiredCustLevel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_LEVEL;
        }
        if (requested > EXPIRED_CUST_LEVEL) {
            return EXPIRED_CUST_LEVEL;
        }
        return requested;
    }

}

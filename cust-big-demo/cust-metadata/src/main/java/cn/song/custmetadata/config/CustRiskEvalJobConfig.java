package cn.song.custmetadata.config;

/**
 * 客户风险评估JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustRiskEvalJobConfig {

    public static final String MODULE_CODE = "CUST_RISK_EVAL_JOB_CONFIG";

    /** 超时毫秒数（评分编号） */
    public static final long TIMEOUT_SCORE_NO = 5L;

    /** 超时毫秒数（评分名称） */
    public static final long TIMEOUT_SCORE_NAME = 10L;

    /** 超时毫秒数（评分类型） */
    public static final long TIMEOUT_SCORE_TYPE = 15L;

    /** 超时毫秒数（评分编码） */
    public static final long TIMEOUT_SCORE_CODE = 20L;

    /** 超时毫秒数（评分级别） */
    public static final long TIMEOUT_SCORE_LEVEL = 25L;

    /** 超时毫秒数（评分状态） */
    public static final long TIMEOUT_SCORE_STATUS = 30L;

    /** 超时毫秒数（评分金额） */
    public static final long TIMEOUT_SCORE_AMOUNT = 35L;

    /** 超时毫秒数（评分数量） */
    public static final long TIMEOUT_SCORE_COUNT = 40L;

    /** 超时毫秒数（评分比率） */
    public static final long TIMEOUT_SCORE_RATE = 45L;

    /** 超时毫秒数（评分日期） */
    public static final long TIMEOUT_SCORE_DATE = 50L;

    /** 超时毫秒数（评分时间） */
    public static final long TIMEOUT_SCORE_TIME = 55L;

    /** 超时毫秒数（评分标记） */
    public static final long TIMEOUT_SCORE_FLAG = 60L;

    /** 超时毫秒数（评分说明） */
    public static final long TIMEOUT_SCORE_REMARK = 65L;

    /** 超时毫秒数（评分来源） */
    public static final long TIMEOUT_SCORE_SOURCE = 70L;

    /** 超时毫秒数（评分版本） */
    public static final long TIMEOUT_SCORE_VERSION = 75L;

    /** 超时毫秒数（评分区域） */
    public static final long TIMEOUT_SCORE_REGION = 80L;

    /** 超时毫秒数（评分渠道） */
    public static final long TIMEOUT_SCORE_CHANNEL = 85L;

    /** 超时毫秒数（评分分组） */
    public static final long TIMEOUT_SCORE_GROUP = 90L;

    /** 超时毫秒数（评分标签） */
    public static final long TIMEOUT_SCORE_TAG = 95L;

    /** 超时毫秒数（评分负责人） */
    public static final long TIMEOUT_SCORE_OWNER = 100L;

    /** 重试次数（客户编号） */
    public static final long RETRY_CUST_NO = 105L;

    /** 重试次数（客户名称） */
    public static final long RETRY_CUST_NAME = 110L;

    /** 重试次数（客户类型） */
    public static final long RETRY_CUST_TYPE = 115L;

    /** 重试次数（客户编码） */
    public static final long RETRY_CUST_CODE = 120L;

    /** 重试次数（客户级别） */
    public static final long RETRY_CUST_LEVEL = 125L;

    /** 重试次数（客户状态） */
    public static final long RETRY_CUST_STATUS = 130L;

    /** 重试次数（客户金额） */
    public static final long RETRY_CUST_AMOUNT = 135L;

    /** 重试次数（客户数量） */
    public static final long RETRY_CUST_COUNT = 140L;

    /** 重试次数（客户比率） */
    public static final long RETRY_CUST_RATE = 145L;

    /** 重试次数（客户日期） */
    public static final long RETRY_CUST_DATE = 150L;

    /** 重试次数（客户时间） */
    public static final long RETRY_CUST_TIME = 155L;

    /** 重试次数（客户标记） */
    public static final long RETRY_CUST_FLAG = 160L;

    /** 重试次数（客户说明） */
    public static final long RETRY_CUST_REMARK = 165L;

    /** 重试次数（客户来源） */
    public static final long RETRY_CUST_SOURCE = 170L;

    /** 重试次数（客户版本） */
    public static final long RETRY_CUST_VERSION = 175L;

    /** 重试次数（客户区域） */
    public static final long RETRY_CUST_REGION = 180L;

    /** 重试次数（客户渠道） */
    public static final long RETRY_CUST_CHANNEL = 185L;

    /** 重试次数（客户分组） */
    public static final long RETRY_CUST_GROUP = 190L;

    /** 重试次数（客户标签） */
    public static final long RETRY_CUST_TAG = 195L;

    /** 重试次数（客户负责人） */
    public static final long RETRY_CUST_OWNER = 200L;

    /** 重试次数（证件编号） */
    public static final long RETRY_CERT_NO = 205L;

    /** 重试次数（证件名称） */
    public static final long RETRY_CERT_NAME = 210L;

    /** 重试次数（证件类型） */
    public static final long RETRY_CERT_TYPE = 215L;

    /** 重试次数（证件编码） */
    public static final long RETRY_CERT_CODE = 220L;

    /** 重试次数（证件级别） */
    public static final long RETRY_CERT_LEVEL = 225L;

    /** 重试次数（证件状态） */
    public static final long RETRY_CERT_STATUS = 230L;

    /** 重试次数（证件金额） */
    public static final long RETRY_CERT_AMOUNT = 235L;

    /** 重试次数（证件数量） */
    public static final long RETRY_CERT_COUNT = 240L;

    /** 重试次数（证件比率） */
    public static final long RETRY_CERT_RATE = 245L;

    /** 重试次数（证件日期） */
    public static final long RETRY_CERT_DATE = 250L;

    /** 重试次数（证件时间） */
    public static final long RETRY_CERT_TIME = 255L;

    /** 重试次数（证件标记） */
    public static final long RETRY_CERT_FLAG = 260L;

    /** 重试次数（证件说明） */
    public static final long RETRY_CERT_REMARK = 265L;

    /** 重试次数（证件来源） */
    public static final long RETRY_CERT_SOURCE = 270L;

    /** 重试次数（证件版本） */
    public static final long RETRY_CERT_VERSION = 275L;

    /** 重试次数（证件区域） */
    public static final long RETRY_CERT_REGION = 280L;

    /** 重试次数（证件渠道） */
    public static final long RETRY_CERT_CHANNEL = 285L;

    /** 重试次数（证件分组） */
    public static final long RETRY_CERT_GROUP = 290L;

    /** 重试次数（证件标签） */
    public static final long RETRY_CERT_TAG = 295L;

    /** 重试次数（证件负责人） */
    public static final long RETRY_CERT_OWNER = 300L;

    private CustRiskEvalJobConfig() {
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

    /** 超时毫秒数（评分数量）。 */
    public static long resolveTimeoutScoreCount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_COUNT;
        }
        if (requested > TIMEOUT_SCORE_COUNT) {
            return TIMEOUT_SCORE_COUNT;
        }
        return requested;
    }

    /** 超时毫秒数（评分比率）。 */
    public static long resolveTimeoutScoreRate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_RATE;
        }
        if (requested > TIMEOUT_SCORE_RATE) {
            return TIMEOUT_SCORE_RATE;
        }
        return requested;
    }

    /** 超时毫秒数（评分日期）。 */
    public static long resolveTimeoutScoreDate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_DATE;
        }
        if (requested > TIMEOUT_SCORE_DATE) {
            return TIMEOUT_SCORE_DATE;
        }
        return requested;
    }

    /** 超时毫秒数（评分时间）。 */
    public static long resolveTimeoutScoreTime(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_TIME;
        }
        if (requested > TIMEOUT_SCORE_TIME) {
            return TIMEOUT_SCORE_TIME;
        }
        return requested;
    }

    /** 超时毫秒数（评分标记）。 */
    public static long resolveTimeoutScoreFlag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_FLAG;
        }
        if (requested > TIMEOUT_SCORE_FLAG) {
            return TIMEOUT_SCORE_FLAG;
        }
        return requested;
    }

    /** 超时毫秒数（评分说明）。 */
    public static long resolveTimeoutScoreRemark(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_REMARK;
        }
        if (requested > TIMEOUT_SCORE_REMARK) {
            return TIMEOUT_SCORE_REMARK;
        }
        return requested;
    }

    /** 超时毫秒数（评分来源）。 */
    public static long resolveTimeoutScoreSource(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_SOURCE;
        }
        if (requested > TIMEOUT_SCORE_SOURCE) {
            return TIMEOUT_SCORE_SOURCE;
        }
        return requested;
    }

    /** 超时毫秒数（评分版本）。 */
    public static long resolveTimeoutScoreVersion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_VERSION;
        }
        if (requested > TIMEOUT_SCORE_VERSION) {
            return TIMEOUT_SCORE_VERSION;
        }
        return requested;
    }

    /** 超时毫秒数（评分区域）。 */
    public static long resolveTimeoutScoreRegion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_REGION;
        }
        if (requested > TIMEOUT_SCORE_REGION) {
            return TIMEOUT_SCORE_REGION;
        }
        return requested;
    }

    /** 超时毫秒数（评分渠道）。 */
    public static long resolveTimeoutScoreChannel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_CHANNEL;
        }
        if (requested > TIMEOUT_SCORE_CHANNEL) {
            return TIMEOUT_SCORE_CHANNEL;
        }
        return requested;
    }

    /** 超时毫秒数（评分分组）。 */
    public static long resolveTimeoutScoreGroup(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_GROUP;
        }
        if (requested > TIMEOUT_SCORE_GROUP) {
            return TIMEOUT_SCORE_GROUP;
        }
        return requested;
    }

    /** 超时毫秒数（评分标签）。 */
    public static long resolveTimeoutScoreTag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_TAG;
        }
        if (requested > TIMEOUT_SCORE_TAG) {
            return TIMEOUT_SCORE_TAG;
        }
        return requested;
    }

    /** 超时毫秒数（评分负责人）。 */
    public static long resolveTimeoutScoreOwner(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SCORE_OWNER;
        }
        if (requested > TIMEOUT_SCORE_OWNER) {
            return TIMEOUT_SCORE_OWNER;
        }
        return requested;
    }

}

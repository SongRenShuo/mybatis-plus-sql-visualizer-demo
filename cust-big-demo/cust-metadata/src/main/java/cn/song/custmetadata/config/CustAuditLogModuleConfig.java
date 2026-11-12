package cn.song.custmetadata.config;

/**
 * 客户审计日志ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustAuditLogModuleConfig {

    public static final String MODULE_CODE = "CUST_AUDIT_LOG";

    /** 批处理条数（偏好说明） */
    public static final long BATCH_PREFER_REMARK = 5L;

    /** 批处理条数（偏好来源） */
    public static final long BATCH_PREFER_SOURCE = 10L;

    /** 批处理条数（偏好版本） */
    public static final long BATCH_PREFER_VERSION = 15L;

    /** 批处理条数（偏好区域） */
    public static final long BATCH_PREFER_REGION = 20L;

    /** 批处理条数（偏好渠道） */
    public static final long BATCH_PREFER_CHANNEL = 25L;

    /** 批处理条数（偏好分组） */
    public static final long BATCH_PREFER_GROUP = 30L;

    /** 批处理条数（偏好标签） */
    public static final long BATCH_PREFER_TAG = 35L;

    /** 批处理条数（偏好负责人） */
    public static final long BATCH_PREFER_OWNER = 40L;

    /** 批处理条数（评分编号） */
    public static final long BATCH_SCORE_NO = 45L;

    /** 批处理条数（评分名称） */
    public static final long BATCH_SCORE_NAME = 50L;

    /** 批处理条数（评分类型） */
    public static final long BATCH_SCORE_TYPE = 55L;

    /** 批处理条数（评分编码） */
    public static final long BATCH_SCORE_CODE = 60L;

    /** 批处理条数（评分级别） */
    public static final long BATCH_SCORE_LEVEL = 65L;

    /** 批处理条数（评分状态） */
    public static final long BATCH_SCORE_STATUS = 70L;

    /** 批处理条数（评分金额） */
    public static final long BATCH_SCORE_AMOUNT = 75L;

    /** 批处理条数（评分数量） */
    public static final long BATCH_SCORE_COUNT = 80L;

    /** 批处理条数（评分比率） */
    public static final long BATCH_SCORE_RATE = 85L;

    /** 批处理条数（评分日期） */
    public static final long BATCH_SCORE_DATE = 90L;

    /** 批处理条数（评分时间） */
    public static final long BATCH_SCORE_TIME = 95L;

    /** 批处理条数（评分标记） */
    public static final long BATCH_SCORE_FLAG = 100L;

    /** 批处理条数（评分说明） */
    public static final long BATCH_SCORE_REMARK = 105L;

    /** 批处理条数（评分来源） */
    public static final long BATCH_SCORE_SOURCE = 110L;

    /** 批处理条数（评分版本） */
    public static final long BATCH_SCORE_VERSION = 115L;

    /** 批处理条数（评分区域） */
    public static final long BATCH_SCORE_REGION = 120L;

    /** 批处理条数（评分渠道） */
    public static final long BATCH_SCORE_CHANNEL = 125L;

    /** 批处理条数（评分分组） */
    public static final long BATCH_SCORE_GROUP = 130L;

    /** 批处理条数（评分标签） */
    public static final long BATCH_SCORE_TAG = 135L;

    /** 批处理条数（评分负责人） */
    public static final long BATCH_SCORE_OWNER = 140L;

    /** 过期天数（客户编号） */
    public static final long EXPIRED_CUST_NO = 145L;

    /** 过期天数（客户名称） */
    public static final long EXPIRED_CUST_NAME = 150L;

    /** 过期天数（客户类型） */
    public static final long EXPIRED_CUST_TYPE = 155L;

    /** 过期天数（客户编码） */
    public static final long EXPIRED_CUST_CODE = 160L;

    /** 过期天数（客户级别） */
    public static final long EXPIRED_CUST_LEVEL = 165L;

    /** 过期天数（客户状态） */
    public static final long EXPIRED_CUST_STATUS = 170L;

    /** 过期天数（客户金额） */
    public static final long EXPIRED_CUST_AMOUNT = 175L;

    /** 过期天数（客户数量） */
    public static final long EXPIRED_CUST_COUNT = 180L;

    /** 过期天数（客户比率） */
    public static final long EXPIRED_CUST_RATE = 185L;

    /** 过期天数（客户日期） */
    public static final long EXPIRED_CUST_DATE = 190L;

    /** 过期天数（客户时间） */
    public static final long EXPIRED_CUST_TIME = 195L;

    /** 过期天数（客户标记） */
    public static final long EXPIRED_CUST_FLAG = 200L;

    /** 过期天数（客户说明） */
    public static final long EXPIRED_CUST_REMARK = 205L;

    /** 过期天数（客户来源） */
    public static final long EXPIRED_CUST_SOURCE = 210L;

    /** 过期天数（客户版本） */
    public static final long EXPIRED_CUST_VERSION = 215L;

    /** 过期天数（客户区域） */
    public static final long EXPIRED_CUST_REGION = 220L;

    /** 过期天数（客户渠道） */
    public static final long EXPIRED_CUST_CHANNEL = 225L;

    /** 过期天数（客户分组） */
    public static final long EXPIRED_CUST_GROUP = 230L;

    /** 过期天数（客户标签） */
    public static final long EXPIRED_CUST_TAG = 235L;

    /** 过期天数（客户负责人） */
    public static final long EXPIRED_CUST_OWNER = 240L;

    /** 过期天数（证件编号） */
    public static final long EXPIRED_CERT_NO = 245L;

    /** 过期天数（证件名称） */
    public static final long EXPIRED_CERT_NAME = 250L;

    /** 过期天数（证件类型） */
    public static final long EXPIRED_CERT_TYPE = 255L;

    /** 过期天数（证件编码） */
    public static final long EXPIRED_CERT_CODE = 260L;

    /** 过期天数（证件级别） */
    public static final long EXPIRED_CERT_LEVEL = 265L;

    /** 过期天数（证件状态） */
    public static final long EXPIRED_CERT_STATUS = 270L;

    /** 过期天数（证件金额） */
    public static final long EXPIRED_CERT_AMOUNT = 275L;

    /** 过期天数（证件数量） */
    public static final long EXPIRED_CERT_COUNT = 280L;

    /** 过期天数（证件比率） */
    public static final long EXPIRED_CERT_RATE = 285L;

    /** 过期天数（证件日期） */
    public static final long EXPIRED_CERT_DATE = 290L;

    /** 过期天数（证件时间） */
    public static final long EXPIRED_CERT_TIME = 295L;

    /** 过期天数（证件标记） */
    public static final long EXPIRED_CERT_FLAG = 300L;

    private CustAuditLogModuleConfig() {
    }

    /** 批处理条数（偏好说明）。 */
    public static long resolveBatchPreferRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_PREFER_REMARK;
        }
        if (requested > BATCH_PREFER_REMARK) {
            return BATCH_PREFER_REMARK;
        }
        return requested;
    }

    /** 批处理条数（偏好来源）。 */
    public static long resolveBatchPreferSource(long requested) {
        if (requested <= 0L) {
            return BATCH_PREFER_SOURCE;
        }
        if (requested > BATCH_PREFER_SOURCE) {
            return BATCH_PREFER_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（偏好版本）。 */
    public static long resolveBatchPreferVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_PREFER_VERSION;
        }
        if (requested > BATCH_PREFER_VERSION) {
            return BATCH_PREFER_VERSION;
        }
        return requested;
    }

    /** 批处理条数（偏好区域）。 */
    public static long resolveBatchPreferRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_PREFER_REGION;
        }
        if (requested > BATCH_PREFER_REGION) {
            return BATCH_PREFER_REGION;
        }
        return requested;
    }

    /** 批处理条数（偏好渠道）。 */
    public static long resolveBatchPreferChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_PREFER_CHANNEL;
        }
        if (requested > BATCH_PREFER_CHANNEL) {
            return BATCH_PREFER_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（偏好分组）。 */
    public static long resolveBatchPreferGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_PREFER_GROUP;
        }
        if (requested > BATCH_PREFER_GROUP) {
            return BATCH_PREFER_GROUP;
        }
        return requested;
    }

    /** 批处理条数（偏好标签）。 */
    public static long resolveBatchPreferTag(long requested) {
        if (requested <= 0L) {
            return BATCH_PREFER_TAG;
        }
        if (requested > BATCH_PREFER_TAG) {
            return BATCH_PREFER_TAG;
        }
        return requested;
    }

    /** 批处理条数（偏好负责人）。 */
    public static long resolveBatchPreferOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_PREFER_OWNER;
        }
        if (requested > BATCH_PREFER_OWNER) {
            return BATCH_PREFER_OWNER;
        }
        return requested;
    }

    /** 批处理条数（评分编号）。 */
    public static long resolveBatchScoreNo(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_NO;
        }
        if (requested > BATCH_SCORE_NO) {
            return BATCH_SCORE_NO;
        }
        return requested;
    }

    /** 批处理条数（评分名称）。 */
    public static long resolveBatchScoreName(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_NAME;
        }
        if (requested > BATCH_SCORE_NAME) {
            return BATCH_SCORE_NAME;
        }
        return requested;
    }

    /** 批处理条数（评分类型）。 */
    public static long resolveBatchScoreType(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_TYPE;
        }
        if (requested > BATCH_SCORE_TYPE) {
            return BATCH_SCORE_TYPE;
        }
        return requested;
    }

    /** 批处理条数（评分编码）。 */
    public static long resolveBatchScoreCode(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_CODE;
        }
        if (requested > BATCH_SCORE_CODE) {
            return BATCH_SCORE_CODE;
        }
        return requested;
    }

    /** 批处理条数（评分级别）。 */
    public static long resolveBatchScoreLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_SCORE_LEVEL;
        }
        if (requested > BATCH_SCORE_LEVEL) {
            return BATCH_SCORE_LEVEL;
        }
        return requested;
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

}

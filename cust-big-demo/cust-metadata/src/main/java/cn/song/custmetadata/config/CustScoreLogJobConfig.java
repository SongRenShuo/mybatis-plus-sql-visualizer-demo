package cn.song.custmetadata.config;

/**
 * 客户评分日志JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustScoreLogJobConfig {

    public static final String MODULE_CODE = "CUST_SCORE_LOG_JOB_CONFIG";

    /** 过期天数（结算比率） */
    public static final long EXPIRED_SETTLE_RATE = 5L;

    /** 过期天数（结算日期） */
    public static final long EXPIRED_SETTLE_DATE = 10L;

    /** 过期天数（结算时间） */
    public static final long EXPIRED_SETTLE_TIME = 15L;

    /** 过期天数（结算标记） */
    public static final long EXPIRED_SETTLE_FLAG = 20L;

    /** 过期天数（结算说明） */
    public static final long EXPIRED_SETTLE_REMARK = 25L;

    /** 过期天数（结算来源） */
    public static final long EXPIRED_SETTLE_SOURCE = 30L;

    /** 过期天数（结算版本） */
    public static final long EXPIRED_SETTLE_VERSION = 35L;

    /** 过期天数（结算区域） */
    public static final long EXPIRED_SETTLE_REGION = 40L;

    /** 过期天数（结算渠道） */
    public static final long EXPIRED_SETTLE_CHANNEL = 45L;

    /** 过期天数（结算分组） */
    public static final long EXPIRED_SETTLE_GROUP = 50L;

    /** 过期天数（结算标签） */
    public static final long EXPIRED_SETTLE_TAG = 55L;

    /** 过期天数（结算负责人） */
    public static final long EXPIRED_SETTLE_OWNER = 60L;

    /** 过期天数（审计编号） */
    public static final long EXPIRED_AUDIT_NO = 65L;

    /** 过期天数（审计名称） */
    public static final long EXPIRED_AUDIT_NAME = 70L;

    /** 过期天数（审计类型） */
    public static final long EXPIRED_AUDIT_TYPE = 75L;

    /** 过期天数（审计编码） */
    public static final long EXPIRED_AUDIT_CODE = 80L;

    /** 过期天数（审计级别） */
    public static final long EXPIRED_AUDIT_LEVEL = 85L;

    /** 过期天数（审计状态） */
    public static final long EXPIRED_AUDIT_STATUS = 90L;

    /** 过期天数（审计金额） */
    public static final long EXPIRED_AUDIT_AMOUNT = 95L;

    /** 过期天数（审计数量） */
    public static final long EXPIRED_AUDIT_COUNT = 100L;

    /** 过期天数（审计比率） */
    public static final long EXPIRED_AUDIT_RATE = 105L;

    /** 过期天数（审计日期） */
    public static final long EXPIRED_AUDIT_DATE = 110L;

    /** 过期天数（审计时间） */
    public static final long EXPIRED_AUDIT_TIME = 115L;

    /** 过期天数（审计标记） */
    public static final long EXPIRED_AUDIT_FLAG = 120L;

    /** 过期天数（审计说明） */
    public static final long EXPIRED_AUDIT_REMARK = 125L;

    /** 过期天数（审计来源） */
    public static final long EXPIRED_AUDIT_SOURCE = 130L;

    /** 过期天数（审计版本） */
    public static final long EXPIRED_AUDIT_VERSION = 135L;

    /** 过期天数（审计区域） */
    public static final long EXPIRED_AUDIT_REGION = 140L;

    /** 过期天数（审计渠道） */
    public static final long EXPIRED_AUDIT_CHANNEL = 145L;

    /** 过期天数（审计分组） */
    public static final long EXPIRED_AUDIT_GROUP = 150L;

    /** 过期天数（审计标签） */
    public static final long EXPIRED_AUDIT_TAG = 155L;

    /** 过期天数（审计负责人） */
    public static final long EXPIRED_AUDIT_OWNER = 160L;

    /** 过期天数（附件编号） */
    public static final long EXPIRED_ATTACH_NO = 165L;

    /** 过期天数（附件名称） */
    public static final long EXPIRED_ATTACH_NAME = 170L;

    /** 过期天数（附件类型） */
    public static final long EXPIRED_ATTACH_TYPE = 175L;

    /** 过期天数（附件编码） */
    public static final long EXPIRED_ATTACH_CODE = 180L;

    /** 过期天数（附件级别） */
    public static final long EXPIRED_ATTACH_LEVEL = 185L;

    /** 过期天数（附件状态） */
    public static final long EXPIRED_ATTACH_STATUS = 190L;

    /** 过期天数（附件金额） */
    public static final long EXPIRED_ATTACH_AMOUNT = 195L;

    /** 过期天数（附件数量） */
    public static final long EXPIRED_ATTACH_COUNT = 200L;

    /** 过期天数（附件比率） */
    public static final long EXPIRED_ATTACH_RATE = 205L;

    /** 过期天数（附件日期） */
    public static final long EXPIRED_ATTACH_DATE = 210L;

    /** 过期天数（附件时间） */
    public static final long EXPIRED_ATTACH_TIME = 215L;

    /** 过期天数（附件标记） */
    public static final long EXPIRED_ATTACH_FLAG = 220L;

    /** 过期天数（附件说明） */
    public static final long EXPIRED_ATTACH_REMARK = 225L;

    /** 过期天数（附件来源） */
    public static final long EXPIRED_ATTACH_SOURCE = 230L;

    /** 过期天数（附件版本） */
    public static final long EXPIRED_ATTACH_VERSION = 235L;

    /** 过期天数（附件区域） */
    public static final long EXPIRED_ATTACH_REGION = 240L;

    /** 过期天数（附件渠道） */
    public static final long EXPIRED_ATTACH_CHANNEL = 245L;

    /** 过期天数（附件分组） */
    public static final long EXPIRED_ATTACH_GROUP = 250L;

    /** 过期天数（附件标签） */
    public static final long EXPIRED_ATTACH_TAG = 255L;

    /** 过期天数（附件负责人） */
    public static final long EXPIRED_ATTACH_OWNER = 260L;

    /** 过期天数（备注编号） */
    public static final long EXPIRED_NOTE_NO = 265L;

    /** 过期天数（备注名称） */
    public static final long EXPIRED_NOTE_NAME = 270L;

    /** 过期天数（备注类型） */
    public static final long EXPIRED_NOTE_TYPE = 275L;

    /** 过期天数（备注编码） */
    public static final long EXPIRED_NOTE_CODE = 280L;

    /** 过期天数（备注级别） */
    public static final long EXPIRED_NOTE_LEVEL = 285L;

    /** 过期天数（备注状态） */
    public static final long EXPIRED_NOTE_STATUS = 290L;

    /** 过期天数（备注金额） */
    public static final long EXPIRED_NOTE_AMOUNT = 295L;

    /** 过期天数（备注数量） */
    public static final long EXPIRED_NOTE_COUNT = 300L;

    private CustScoreLogJobConfig() {
    }

    /** 过期天数（结算比率）。 */
    public static long resolveExpiredSettleRate(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_RATE;
        }
        if (requested > EXPIRED_SETTLE_RATE) {
            return EXPIRED_SETTLE_RATE;
        }
        return requested;
    }

    /** 过期天数（结算日期）。 */
    public static long resolveExpiredSettleDate(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_DATE;
        }
        if (requested > EXPIRED_SETTLE_DATE) {
            return EXPIRED_SETTLE_DATE;
        }
        return requested;
    }

    /** 过期天数（结算时间）。 */
    public static long resolveExpiredSettleTime(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_TIME;
        }
        if (requested > EXPIRED_SETTLE_TIME) {
            return EXPIRED_SETTLE_TIME;
        }
        return requested;
    }

    /** 过期天数（结算标记）。 */
    public static long resolveExpiredSettleFlag(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_FLAG;
        }
        if (requested > EXPIRED_SETTLE_FLAG) {
            return EXPIRED_SETTLE_FLAG;
        }
        return requested;
    }

    /** 过期天数（结算说明）。 */
    public static long resolveExpiredSettleRemark(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_REMARK;
        }
        if (requested > EXPIRED_SETTLE_REMARK) {
            return EXPIRED_SETTLE_REMARK;
        }
        return requested;
    }

    /** 过期天数（结算来源）。 */
    public static long resolveExpiredSettleSource(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_SOURCE;
        }
        if (requested > EXPIRED_SETTLE_SOURCE) {
            return EXPIRED_SETTLE_SOURCE;
        }
        return requested;
    }

    /** 过期天数（结算版本）。 */
    public static long resolveExpiredSettleVersion(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_VERSION;
        }
        if (requested > EXPIRED_SETTLE_VERSION) {
            return EXPIRED_SETTLE_VERSION;
        }
        return requested;
    }

    /** 过期天数（结算区域）。 */
    public static long resolveExpiredSettleRegion(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_REGION;
        }
        if (requested > EXPIRED_SETTLE_REGION) {
            return EXPIRED_SETTLE_REGION;
        }
        return requested;
    }

    /** 过期天数（结算渠道）。 */
    public static long resolveExpiredSettleChannel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_CHANNEL;
        }
        if (requested > EXPIRED_SETTLE_CHANNEL) {
            return EXPIRED_SETTLE_CHANNEL;
        }
        return requested;
    }

    /** 过期天数（结算分组）。 */
    public static long resolveExpiredSettleGroup(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_GROUP;
        }
        if (requested > EXPIRED_SETTLE_GROUP) {
            return EXPIRED_SETTLE_GROUP;
        }
        return requested;
    }

    /** 过期天数（结算标签）。 */
    public static long resolveExpiredSettleTag(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_TAG;
        }
        if (requested > EXPIRED_SETTLE_TAG) {
            return EXPIRED_SETTLE_TAG;
        }
        return requested;
    }

    /** 过期天数（结算负责人）。 */
    public static long resolveExpiredSettleOwner(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_OWNER;
        }
        if (requested > EXPIRED_SETTLE_OWNER) {
            return EXPIRED_SETTLE_OWNER;
        }
        return requested;
    }

    /** 过期天数（审计编号）。 */
    public static long resolveExpiredAuditNo(long requested) {
        if (requested <= 0L) {
            return EXPIRED_AUDIT_NO;
        }
        if (requested > EXPIRED_AUDIT_NO) {
            return EXPIRED_AUDIT_NO;
        }
        return requested;
    }

    /** 过期天数（审计名称）。 */
    public static long resolveExpiredAuditName(long requested) {
        if (requested <= 0L) {
            return EXPIRED_AUDIT_NAME;
        }
        if (requested > EXPIRED_AUDIT_NAME) {
            return EXPIRED_AUDIT_NAME;
        }
        return requested;
    }

    /** 过期天数（审计类型）。 */
    public static long resolveExpiredAuditType(long requested) {
        if (requested <= 0L) {
            return EXPIRED_AUDIT_TYPE;
        }
        if (requested > EXPIRED_AUDIT_TYPE) {
            return EXPIRED_AUDIT_TYPE;
        }
        return requested;
    }

    /** 过期天数（审计编码）。 */
    public static long resolveExpiredAuditCode(long requested) {
        if (requested <= 0L) {
            return EXPIRED_AUDIT_CODE;
        }
        if (requested > EXPIRED_AUDIT_CODE) {
            return EXPIRED_AUDIT_CODE;
        }
        return requested;
    }

    /** 过期天数（审计级别）。 */
    public static long resolveExpiredAuditLevel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_AUDIT_LEVEL;
        }
        if (requested > EXPIRED_AUDIT_LEVEL) {
            return EXPIRED_AUDIT_LEVEL;
        }
        return requested;
    }

    /** 过期天数（审计状态）。 */
    public static long resolveExpiredAuditStatus(long requested) {
        if (requested <= 0L) {
            return EXPIRED_AUDIT_STATUS;
        }
        if (requested > EXPIRED_AUDIT_STATUS) {
            return EXPIRED_AUDIT_STATUS;
        }
        return requested;
    }

    /** 过期天数（审计金额）。 */
    public static long resolveExpiredAuditAmount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_AUDIT_AMOUNT;
        }
        if (requested > EXPIRED_AUDIT_AMOUNT) {
            return EXPIRED_AUDIT_AMOUNT;
        }
        return requested;
    }

    /** 过期天数（审计数量）。 */
    public static long resolveExpiredAuditCount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_AUDIT_COUNT;
        }
        if (requested > EXPIRED_AUDIT_COUNT) {
            return EXPIRED_AUDIT_COUNT;
        }
        return requested;
    }

}

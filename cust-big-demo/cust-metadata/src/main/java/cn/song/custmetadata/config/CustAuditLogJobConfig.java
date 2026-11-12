package cn.song.custmetadata.config;

/**
 * 客户审计日志JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustAuditLogJobConfig {

    public static final String MODULE_CODE = "CUST_AUDIT_LOG_JOB_CONFIG";

    /** 批处理条数（评分标签） */
    public static final long BATCH_SCORE_TAG = 5L;

    /** 批处理条数（评分负责人） */
    public static final long BATCH_SCORE_OWNER = 10L;

    /** 过期天数（客户编号） */
    public static final long EXPIRED_CUST_NO = 15L;

    /** 过期天数（客户名称） */
    public static final long EXPIRED_CUST_NAME = 20L;

    /** 过期天数（客户类型） */
    public static final long EXPIRED_CUST_TYPE = 25L;

    /** 过期天数（客户编码） */
    public static final long EXPIRED_CUST_CODE = 30L;

    /** 过期天数（客户级别） */
    public static final long EXPIRED_CUST_LEVEL = 35L;

    /** 过期天数（客户状态） */
    public static final long EXPIRED_CUST_STATUS = 40L;

    /** 过期天数（客户金额） */
    public static final long EXPIRED_CUST_AMOUNT = 45L;

    /** 过期天数（客户数量） */
    public static final long EXPIRED_CUST_COUNT = 50L;

    /** 过期天数（客户比率） */
    public static final long EXPIRED_CUST_RATE = 55L;

    /** 过期天数（客户日期） */
    public static final long EXPIRED_CUST_DATE = 60L;

    /** 过期天数（客户时间） */
    public static final long EXPIRED_CUST_TIME = 65L;

    /** 过期天数（客户标记） */
    public static final long EXPIRED_CUST_FLAG = 70L;

    /** 过期天数（客户说明） */
    public static final long EXPIRED_CUST_REMARK = 75L;

    /** 过期天数（客户来源） */
    public static final long EXPIRED_CUST_SOURCE = 80L;

    /** 过期天数（客户版本） */
    public static final long EXPIRED_CUST_VERSION = 85L;

    /** 过期天数（客户区域） */
    public static final long EXPIRED_CUST_REGION = 90L;

    /** 过期天数（客户渠道） */
    public static final long EXPIRED_CUST_CHANNEL = 95L;

    /** 过期天数（客户分组） */
    public static final long EXPIRED_CUST_GROUP = 100L;

    /** 过期天数（客户标签） */
    public static final long EXPIRED_CUST_TAG = 105L;

    /** 过期天数（客户负责人） */
    public static final long EXPIRED_CUST_OWNER = 110L;

    /** 过期天数（证件编号） */
    public static final long EXPIRED_CERT_NO = 115L;

    /** 过期天数（证件名称） */
    public static final long EXPIRED_CERT_NAME = 120L;

    /** 过期天数（证件类型） */
    public static final long EXPIRED_CERT_TYPE = 125L;

    /** 过期天数（证件编码） */
    public static final long EXPIRED_CERT_CODE = 130L;

    /** 过期天数（证件级别） */
    public static final long EXPIRED_CERT_LEVEL = 135L;

    /** 过期天数（证件状态） */
    public static final long EXPIRED_CERT_STATUS = 140L;

    /** 过期天数（证件金额） */
    public static final long EXPIRED_CERT_AMOUNT = 145L;

    /** 过期天数（证件数量） */
    public static final long EXPIRED_CERT_COUNT = 150L;

    /** 过期天数（证件比率） */
    public static final long EXPIRED_CERT_RATE = 155L;

    /** 过期天数（证件日期） */
    public static final long EXPIRED_CERT_DATE = 160L;

    /** 过期天数（证件时间） */
    public static final long EXPIRED_CERT_TIME = 165L;

    /** 过期天数（证件标记） */
    public static final long EXPIRED_CERT_FLAG = 170L;

    /** 过期天数（证件说明） */
    public static final long EXPIRED_CERT_REMARK = 175L;

    /** 过期天数（证件来源） */
    public static final long EXPIRED_CERT_SOURCE = 180L;

    /** 过期天数（证件版本） */
    public static final long EXPIRED_CERT_VERSION = 185L;

    /** 过期天数（证件区域） */
    public static final long EXPIRED_CERT_REGION = 190L;

    /** 过期天数（证件渠道） */
    public static final long EXPIRED_CERT_CHANNEL = 195L;

    /** 过期天数（证件分组） */
    public static final long EXPIRED_CERT_GROUP = 200L;

    /** 过期天数（证件标签） */
    public static final long EXPIRED_CERT_TAG = 205L;

    /** 过期天数（证件负责人） */
    public static final long EXPIRED_CERT_OWNER = 210L;

    /** 过期天数（银行编号） */
    public static final long EXPIRED_BANK_NO = 215L;

    /** 过期天数（银行名称） */
    public static final long EXPIRED_BANK_NAME = 220L;

    /** 过期天数（银行类型） */
    public static final long EXPIRED_BANK_TYPE = 225L;

    /** 过期天数（银行编码） */
    public static final long EXPIRED_BANK_CODE = 230L;

    /** 过期天数（银行级别） */
    public static final long EXPIRED_BANK_LEVEL = 235L;

    /** 过期天数（银行状态） */
    public static final long EXPIRED_BANK_STATUS = 240L;

    /** 过期天数（银行金额） */
    public static final long EXPIRED_BANK_AMOUNT = 245L;

    /** 过期天数（银行数量） */
    public static final long EXPIRED_BANK_COUNT = 250L;

    /** 过期天数（银行比率） */
    public static final long EXPIRED_BANK_RATE = 255L;

    /** 过期天数（银行日期） */
    public static final long EXPIRED_BANK_DATE = 260L;

    /** 过期天数（银行时间） */
    public static final long EXPIRED_BANK_TIME = 265L;

    /** 过期天数（银行标记） */
    public static final long EXPIRED_BANK_FLAG = 270L;

    /** 过期天数（银行说明） */
    public static final long EXPIRED_BANK_REMARK = 275L;

    /** 过期天数（银行来源） */
    public static final long EXPIRED_BANK_SOURCE = 280L;

    /** 过期天数（银行版本） */
    public static final long EXPIRED_BANK_VERSION = 285L;

    /** 过期天数（银行区域） */
    public static final long EXPIRED_BANK_REGION = 290L;

    /** 过期天数（银行渠道） */
    public static final long EXPIRED_BANK_CHANNEL = 295L;

    /** 过期天数（银行分组） */
    public static final long EXPIRED_BANK_GROUP = 300L;

    private CustAuditLogJobConfig() {
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

    /** 过期天数（客户状态）。 */
    public static long resolveExpiredCustStatus(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_STATUS;
        }
        if (requested > EXPIRED_CUST_STATUS) {
            return EXPIRED_CUST_STATUS;
        }
        return requested;
    }

    /** 过期天数（客户金额）。 */
    public static long resolveExpiredCustAmount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_AMOUNT;
        }
        if (requested > EXPIRED_CUST_AMOUNT) {
            return EXPIRED_CUST_AMOUNT;
        }
        return requested;
    }

    /** 过期天数（客户数量）。 */
    public static long resolveExpiredCustCount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_COUNT;
        }
        if (requested > EXPIRED_CUST_COUNT) {
            return EXPIRED_CUST_COUNT;
        }
        return requested;
    }

    /** 过期天数（客户比率）。 */
    public static long resolveExpiredCustRate(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_RATE;
        }
        if (requested > EXPIRED_CUST_RATE) {
            return EXPIRED_CUST_RATE;
        }
        return requested;
    }

    /** 过期天数（客户日期）。 */
    public static long resolveExpiredCustDate(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_DATE;
        }
        if (requested > EXPIRED_CUST_DATE) {
            return EXPIRED_CUST_DATE;
        }
        return requested;
    }

    /** 过期天数（客户时间）。 */
    public static long resolveExpiredCustTime(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_TIME;
        }
        if (requested > EXPIRED_CUST_TIME) {
            return EXPIRED_CUST_TIME;
        }
        return requested;
    }

    /** 过期天数（客户标记）。 */
    public static long resolveExpiredCustFlag(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_FLAG;
        }
        if (requested > EXPIRED_CUST_FLAG) {
            return EXPIRED_CUST_FLAG;
        }
        return requested;
    }

    /** 过期天数（客户说明）。 */
    public static long resolveExpiredCustRemark(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_REMARK;
        }
        if (requested > EXPIRED_CUST_REMARK) {
            return EXPIRED_CUST_REMARK;
        }
        return requested;
    }

    /** 过期天数（客户来源）。 */
    public static long resolveExpiredCustSource(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_SOURCE;
        }
        if (requested > EXPIRED_CUST_SOURCE) {
            return EXPIRED_CUST_SOURCE;
        }
        return requested;
    }

    /** 过期天数（客户版本）。 */
    public static long resolveExpiredCustVersion(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_VERSION;
        }
        if (requested > EXPIRED_CUST_VERSION) {
            return EXPIRED_CUST_VERSION;
        }
        return requested;
    }

    /** 过期天数（客户区域）。 */
    public static long resolveExpiredCustRegion(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_REGION;
        }
        if (requested > EXPIRED_CUST_REGION) {
            return EXPIRED_CUST_REGION;
        }
        return requested;
    }

    /** 过期天数（客户渠道）。 */
    public static long resolveExpiredCustChannel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_CHANNEL;
        }
        if (requested > EXPIRED_CUST_CHANNEL) {
            return EXPIRED_CUST_CHANNEL;
        }
        return requested;
    }

    /** 过期天数（客户分组）。 */
    public static long resolveExpiredCustGroup(long requested) {
        if (requested <= 0L) {
            return EXPIRED_CUST_GROUP;
        }
        if (requested > EXPIRED_CUST_GROUP) {
            return EXPIRED_CUST_GROUP;
        }
        return requested;
    }

}

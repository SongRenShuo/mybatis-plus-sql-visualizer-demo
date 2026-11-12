package cn.song.custmetadata.config;

/**
 * 客户评分日志CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustScoreLogCacheConfig {

    public static final String MODULE_CODE = "CUST_SCORE_LOG_CACHE_CONFIG";

    /** 过期天数（发票区域） */
    public static final long EXPIRED_INVOICE_REGION = 5L;

    /** 过期天数（发票渠道） */
    public static final long EXPIRED_INVOICE_CHANNEL = 10L;

    /** 过期天数（发票分组） */
    public static final long EXPIRED_INVOICE_GROUP = 15L;

    /** 过期天数（发票标签） */
    public static final long EXPIRED_INVOICE_TAG = 20L;

    /** 过期天数（发票负责人） */
    public static final long EXPIRED_INVOICE_OWNER = 25L;

    /** 过期天数（结算编号） */
    public static final long EXPIRED_SETTLE_NO = 30L;

    /** 过期天数（结算名称） */
    public static final long EXPIRED_SETTLE_NAME = 35L;

    /** 过期天数（结算类型） */
    public static final long EXPIRED_SETTLE_TYPE = 40L;

    /** 过期天数（结算编码） */
    public static final long EXPIRED_SETTLE_CODE = 45L;

    /** 过期天数（结算级别） */
    public static final long EXPIRED_SETTLE_LEVEL = 50L;

    /** 过期天数（结算状态） */
    public static final long EXPIRED_SETTLE_STATUS = 55L;

    /** 过期天数（结算金额） */
    public static final long EXPIRED_SETTLE_AMOUNT = 60L;

    /** 过期天数（结算数量） */
    public static final long EXPIRED_SETTLE_COUNT = 65L;

    /** 过期天数（结算比率） */
    public static final long EXPIRED_SETTLE_RATE = 70L;

    /** 过期天数（结算日期） */
    public static final long EXPIRED_SETTLE_DATE = 75L;

    /** 过期天数（结算时间） */
    public static final long EXPIRED_SETTLE_TIME = 80L;

    /** 过期天数（结算标记） */
    public static final long EXPIRED_SETTLE_FLAG = 85L;

    /** 过期天数（结算说明） */
    public static final long EXPIRED_SETTLE_REMARK = 90L;

    /** 过期天数（结算来源） */
    public static final long EXPIRED_SETTLE_SOURCE = 95L;

    /** 过期天数（结算版本） */
    public static final long EXPIRED_SETTLE_VERSION = 100L;

    /** 过期天数（结算区域） */
    public static final long EXPIRED_SETTLE_REGION = 105L;

    /** 过期天数（结算渠道） */
    public static final long EXPIRED_SETTLE_CHANNEL = 110L;

    /** 过期天数（结算分组） */
    public static final long EXPIRED_SETTLE_GROUP = 115L;

    /** 过期天数（结算标签） */
    public static final long EXPIRED_SETTLE_TAG = 120L;

    /** 过期天数（结算负责人） */
    public static final long EXPIRED_SETTLE_OWNER = 125L;

    /** 过期天数（审计编号） */
    public static final long EXPIRED_AUDIT_NO = 130L;

    /** 过期天数（审计名称） */
    public static final long EXPIRED_AUDIT_NAME = 135L;

    /** 过期天数（审计类型） */
    public static final long EXPIRED_AUDIT_TYPE = 140L;

    /** 过期天数（审计编码） */
    public static final long EXPIRED_AUDIT_CODE = 145L;

    /** 过期天数（审计级别） */
    public static final long EXPIRED_AUDIT_LEVEL = 150L;

    /** 过期天数（审计状态） */
    public static final long EXPIRED_AUDIT_STATUS = 155L;

    /** 过期天数（审计金额） */
    public static final long EXPIRED_AUDIT_AMOUNT = 160L;

    /** 过期天数（审计数量） */
    public static final long EXPIRED_AUDIT_COUNT = 165L;

    /** 过期天数（审计比率） */
    public static final long EXPIRED_AUDIT_RATE = 170L;

    /** 过期天数（审计日期） */
    public static final long EXPIRED_AUDIT_DATE = 175L;

    /** 过期天数（审计时间） */
    public static final long EXPIRED_AUDIT_TIME = 180L;

    /** 过期天数（审计标记） */
    public static final long EXPIRED_AUDIT_FLAG = 185L;

    /** 过期天数（审计说明） */
    public static final long EXPIRED_AUDIT_REMARK = 190L;

    /** 过期天数（审计来源） */
    public static final long EXPIRED_AUDIT_SOURCE = 195L;

    /** 过期天数（审计版本） */
    public static final long EXPIRED_AUDIT_VERSION = 200L;

    /** 过期天数（审计区域） */
    public static final long EXPIRED_AUDIT_REGION = 205L;

    /** 过期天数（审计渠道） */
    public static final long EXPIRED_AUDIT_CHANNEL = 210L;

    /** 过期天数（审计分组） */
    public static final long EXPIRED_AUDIT_GROUP = 215L;

    /** 过期天数（审计标签） */
    public static final long EXPIRED_AUDIT_TAG = 220L;

    /** 过期天数（审计负责人） */
    public static final long EXPIRED_AUDIT_OWNER = 225L;

    /** 过期天数（附件编号） */
    public static final long EXPIRED_ATTACH_NO = 230L;

    /** 过期天数（附件名称） */
    public static final long EXPIRED_ATTACH_NAME = 235L;

    /** 过期天数（附件类型） */
    public static final long EXPIRED_ATTACH_TYPE = 240L;

    /** 过期天数（附件编码） */
    public static final long EXPIRED_ATTACH_CODE = 245L;

    /** 过期天数（附件级别） */
    public static final long EXPIRED_ATTACH_LEVEL = 250L;

    /** 过期天数（附件状态） */
    public static final long EXPIRED_ATTACH_STATUS = 255L;

    /** 过期天数（附件金额） */
    public static final long EXPIRED_ATTACH_AMOUNT = 260L;

    /** 过期天数（附件数量） */
    public static final long EXPIRED_ATTACH_COUNT = 265L;

    /** 过期天数（附件比率） */
    public static final long EXPIRED_ATTACH_RATE = 270L;

    /** 过期天数（附件日期） */
    public static final long EXPIRED_ATTACH_DATE = 275L;

    /** 过期天数（附件时间） */
    public static final long EXPIRED_ATTACH_TIME = 280L;

    /** 过期天数（附件标记） */
    public static final long EXPIRED_ATTACH_FLAG = 285L;

    /** 过期天数（附件说明） */
    public static final long EXPIRED_ATTACH_REMARK = 290L;

    /** 过期天数（附件来源） */
    public static final long EXPIRED_ATTACH_SOURCE = 295L;

    /** 过期天数（附件版本） */
    public static final long EXPIRED_ATTACH_VERSION = 300L;

    private CustScoreLogCacheConfig() {
    }

    /** 过期天数（发票区域）。 */
    public static long resolveExpiredInvoiceRegion(long requested) {
        if (requested <= 0L) {
            return EXPIRED_INVOICE_REGION;
        }
        if (requested > EXPIRED_INVOICE_REGION) {
            return EXPIRED_INVOICE_REGION;
        }
        return requested;
    }

    /** 过期天数（发票渠道）。 */
    public static long resolveExpiredInvoiceChannel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_INVOICE_CHANNEL;
        }
        if (requested > EXPIRED_INVOICE_CHANNEL) {
            return EXPIRED_INVOICE_CHANNEL;
        }
        return requested;
    }

    /** 过期天数（发票分组）。 */
    public static long resolveExpiredInvoiceGroup(long requested) {
        if (requested <= 0L) {
            return EXPIRED_INVOICE_GROUP;
        }
        if (requested > EXPIRED_INVOICE_GROUP) {
            return EXPIRED_INVOICE_GROUP;
        }
        return requested;
    }

    /** 过期天数（发票标签）。 */
    public static long resolveExpiredInvoiceTag(long requested) {
        if (requested <= 0L) {
            return EXPIRED_INVOICE_TAG;
        }
        if (requested > EXPIRED_INVOICE_TAG) {
            return EXPIRED_INVOICE_TAG;
        }
        return requested;
    }

    /** 过期天数（发票负责人）。 */
    public static long resolveExpiredInvoiceOwner(long requested) {
        if (requested <= 0L) {
            return EXPIRED_INVOICE_OWNER;
        }
        if (requested > EXPIRED_INVOICE_OWNER) {
            return EXPIRED_INVOICE_OWNER;
        }
        return requested;
    }

    /** 过期天数（结算编号）。 */
    public static long resolveExpiredSettleNo(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_NO;
        }
        if (requested > EXPIRED_SETTLE_NO) {
            return EXPIRED_SETTLE_NO;
        }
        return requested;
    }

    /** 过期天数（结算名称）。 */
    public static long resolveExpiredSettleName(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_NAME;
        }
        if (requested > EXPIRED_SETTLE_NAME) {
            return EXPIRED_SETTLE_NAME;
        }
        return requested;
    }

    /** 过期天数（结算类型）。 */
    public static long resolveExpiredSettleType(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_TYPE;
        }
        if (requested > EXPIRED_SETTLE_TYPE) {
            return EXPIRED_SETTLE_TYPE;
        }
        return requested;
    }

    /** 过期天数（结算编码）。 */
    public static long resolveExpiredSettleCode(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_CODE;
        }
        if (requested > EXPIRED_SETTLE_CODE) {
            return EXPIRED_SETTLE_CODE;
        }
        return requested;
    }

    /** 过期天数（结算级别）。 */
    public static long resolveExpiredSettleLevel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_LEVEL;
        }
        if (requested > EXPIRED_SETTLE_LEVEL) {
            return EXPIRED_SETTLE_LEVEL;
        }
        return requested;
    }

    /** 过期天数（结算状态）。 */
    public static long resolveExpiredSettleStatus(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_STATUS;
        }
        if (requested > EXPIRED_SETTLE_STATUS) {
            return EXPIRED_SETTLE_STATUS;
        }
        return requested;
    }

    /** 过期天数（结算金额）。 */
    public static long resolveExpiredSettleAmount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_AMOUNT;
        }
        if (requested > EXPIRED_SETTLE_AMOUNT) {
            return EXPIRED_SETTLE_AMOUNT;
        }
        return requested;
    }

    /** 过期天数（结算数量）。 */
    public static long resolveExpiredSettleCount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_SETTLE_COUNT;
        }
        if (requested > EXPIRED_SETTLE_COUNT) {
            return EXPIRED_SETTLE_COUNT;
        }
        return requested;
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

}

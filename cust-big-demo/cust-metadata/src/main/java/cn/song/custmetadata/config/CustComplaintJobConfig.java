package cn.song.custmetadata.config;

/**
 * 客户投诉JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustComplaintJobConfig {

    public static final String MODULE_CODE = "CUST_COMPLAINT_JOB_CONFIG";

    /** 缓存秒数（发票渠道） */
    public static final long CACHE_INVOICE_CHANNEL = 5L;

    /** 缓存秒数（发票分组） */
    public static final long CACHE_INVOICE_GROUP = 10L;

    /** 缓存秒数（发票标签） */
    public static final long CACHE_INVOICE_TAG = 15L;

    /** 缓存秒数（发票负责人） */
    public static final long CACHE_INVOICE_OWNER = 20L;

    /** 缓存秒数（结算编号） */
    public static final long CACHE_SETTLE_NO = 25L;

    /** 缓存秒数（结算名称） */
    public static final long CACHE_SETTLE_NAME = 30L;

    /** 缓存秒数（结算类型） */
    public static final long CACHE_SETTLE_TYPE = 35L;

    /** 缓存秒数（结算编码） */
    public static final long CACHE_SETTLE_CODE = 40L;

    /** 缓存秒数（结算级别） */
    public static final long CACHE_SETTLE_LEVEL = 45L;

    /** 缓存秒数（结算状态） */
    public static final long CACHE_SETTLE_STATUS = 50L;

    /** 缓存秒数（结算金额） */
    public static final long CACHE_SETTLE_AMOUNT = 55L;

    /** 缓存秒数（结算数量） */
    public static final long CACHE_SETTLE_COUNT = 60L;

    /** 缓存秒数（结算比率） */
    public static final long CACHE_SETTLE_RATE = 65L;

    /** 缓存秒数（结算日期） */
    public static final long CACHE_SETTLE_DATE = 70L;

    /** 缓存秒数（结算时间） */
    public static final long CACHE_SETTLE_TIME = 75L;

    /** 缓存秒数（结算标记） */
    public static final long CACHE_SETTLE_FLAG = 80L;

    /** 缓存秒数（结算说明） */
    public static final long CACHE_SETTLE_REMARK = 85L;

    /** 缓存秒数（结算来源） */
    public static final long CACHE_SETTLE_SOURCE = 90L;

    /** 缓存秒数（结算版本） */
    public static final long CACHE_SETTLE_VERSION = 95L;

    /** 缓存秒数（结算区域） */
    public static final long CACHE_SETTLE_REGION = 100L;

    /** 缓存秒数（结算渠道） */
    public static final long CACHE_SETTLE_CHANNEL = 105L;

    /** 缓存秒数（结算分组） */
    public static final long CACHE_SETTLE_GROUP = 110L;

    /** 缓存秒数（结算标签） */
    public static final long CACHE_SETTLE_TAG = 115L;

    /** 缓存秒数（结算负责人） */
    public static final long CACHE_SETTLE_OWNER = 120L;

    /** 缓存秒数（审计编号） */
    public static final long CACHE_AUDIT_NO = 125L;

    /** 缓存秒数（审计名称） */
    public static final long CACHE_AUDIT_NAME = 130L;

    /** 缓存秒数（审计类型） */
    public static final long CACHE_AUDIT_TYPE = 135L;

    /** 缓存秒数（审计编码） */
    public static final long CACHE_AUDIT_CODE = 140L;

    /** 缓存秒数（审计级别） */
    public static final long CACHE_AUDIT_LEVEL = 145L;

    /** 缓存秒数（审计状态） */
    public static final long CACHE_AUDIT_STATUS = 150L;

    /** 缓存秒数（审计金额） */
    public static final long CACHE_AUDIT_AMOUNT = 155L;

    /** 缓存秒数（审计数量） */
    public static final long CACHE_AUDIT_COUNT = 160L;

    /** 缓存秒数（审计比率） */
    public static final long CACHE_AUDIT_RATE = 165L;

    /** 缓存秒数（审计日期） */
    public static final long CACHE_AUDIT_DATE = 170L;

    /** 缓存秒数（审计时间） */
    public static final long CACHE_AUDIT_TIME = 175L;

    /** 缓存秒数（审计标记） */
    public static final long CACHE_AUDIT_FLAG = 180L;

    /** 缓存秒数（审计说明） */
    public static final long CACHE_AUDIT_REMARK = 185L;

    /** 缓存秒数（审计来源） */
    public static final long CACHE_AUDIT_SOURCE = 190L;

    /** 缓存秒数（审计版本） */
    public static final long CACHE_AUDIT_VERSION = 195L;

    /** 缓存秒数（审计区域） */
    public static final long CACHE_AUDIT_REGION = 200L;

    /** 缓存秒数（审计渠道） */
    public static final long CACHE_AUDIT_CHANNEL = 205L;

    /** 缓存秒数（审计分组） */
    public static final long CACHE_AUDIT_GROUP = 210L;

    /** 缓存秒数（审计标签） */
    public static final long CACHE_AUDIT_TAG = 215L;

    /** 缓存秒数（审计负责人） */
    public static final long CACHE_AUDIT_OWNER = 220L;

    /** 缓存秒数（附件编号） */
    public static final long CACHE_ATTACH_NO = 225L;

    /** 缓存秒数（附件名称） */
    public static final long CACHE_ATTACH_NAME = 230L;

    /** 缓存秒数（附件类型） */
    public static final long CACHE_ATTACH_TYPE = 235L;

    /** 缓存秒数（附件编码） */
    public static final long CACHE_ATTACH_CODE = 240L;

    /** 缓存秒数（附件级别） */
    public static final long CACHE_ATTACH_LEVEL = 245L;

    /** 缓存秒数（附件状态） */
    public static final long CACHE_ATTACH_STATUS = 250L;

    /** 缓存秒数（附件金额） */
    public static final long CACHE_ATTACH_AMOUNT = 255L;

    /** 缓存秒数（附件数量） */
    public static final long CACHE_ATTACH_COUNT = 260L;

    /** 缓存秒数（附件比率） */
    public static final long CACHE_ATTACH_RATE = 265L;

    /** 缓存秒数（附件日期） */
    public static final long CACHE_ATTACH_DATE = 270L;

    /** 缓存秒数（附件时间） */
    public static final long CACHE_ATTACH_TIME = 275L;

    /** 缓存秒数（附件标记） */
    public static final long CACHE_ATTACH_FLAG = 280L;

    /** 缓存秒数（附件说明） */
    public static final long CACHE_ATTACH_REMARK = 285L;

    /** 缓存秒数（附件来源） */
    public static final long CACHE_ATTACH_SOURCE = 290L;

    /** 缓存秒数（附件版本） */
    public static final long CACHE_ATTACH_VERSION = 295L;

    /** 缓存秒数（附件区域） */
    public static final long CACHE_ATTACH_REGION = 300L;

    private CustComplaintJobConfig() {
    }

    /** 缓存秒数（发票渠道）。 */
    public static long resolveCacheInvoiceChannel(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_CHANNEL;
        }
        if (requested > CACHE_INVOICE_CHANNEL) {
            return CACHE_INVOICE_CHANNEL;
        }
        return requested;
    }

    /** 缓存秒数（发票分组）。 */
    public static long resolveCacheInvoiceGroup(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_GROUP;
        }
        if (requested > CACHE_INVOICE_GROUP) {
            return CACHE_INVOICE_GROUP;
        }
        return requested;
    }

    /** 缓存秒数（发票标签）。 */
    public static long resolveCacheInvoiceTag(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_TAG;
        }
        if (requested > CACHE_INVOICE_TAG) {
            return CACHE_INVOICE_TAG;
        }
        return requested;
    }

    /** 缓存秒数（发票负责人）。 */
    public static long resolveCacheInvoiceOwner(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_OWNER;
        }
        if (requested > CACHE_INVOICE_OWNER) {
            return CACHE_INVOICE_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（结算编号）。 */
    public static long resolveCacheSettleNo(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_NO;
        }
        if (requested > CACHE_SETTLE_NO) {
            return CACHE_SETTLE_NO;
        }
        return requested;
    }

    /** 缓存秒数（结算名称）。 */
    public static long resolveCacheSettleName(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_NAME;
        }
        if (requested > CACHE_SETTLE_NAME) {
            return CACHE_SETTLE_NAME;
        }
        return requested;
    }

    /** 缓存秒数（结算类型）。 */
    public static long resolveCacheSettleType(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_TYPE;
        }
        if (requested > CACHE_SETTLE_TYPE) {
            return CACHE_SETTLE_TYPE;
        }
        return requested;
    }

    /** 缓存秒数（结算编码）。 */
    public static long resolveCacheSettleCode(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_CODE;
        }
        if (requested > CACHE_SETTLE_CODE) {
            return CACHE_SETTLE_CODE;
        }
        return requested;
    }

    /** 缓存秒数（结算级别）。 */
    public static long resolveCacheSettleLevel(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_LEVEL;
        }
        if (requested > CACHE_SETTLE_LEVEL) {
            return CACHE_SETTLE_LEVEL;
        }
        return requested;
    }

    /** 缓存秒数（结算状态）。 */
    public static long resolveCacheSettleStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_STATUS;
        }
        if (requested > CACHE_SETTLE_STATUS) {
            return CACHE_SETTLE_STATUS;
        }
        return requested;
    }

    /** 缓存秒数（结算金额）。 */
    public static long resolveCacheSettleAmount(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_AMOUNT;
        }
        if (requested > CACHE_SETTLE_AMOUNT) {
            return CACHE_SETTLE_AMOUNT;
        }
        return requested;
    }

    /** 缓存秒数（结算数量）。 */
    public static long resolveCacheSettleCount(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_COUNT;
        }
        if (requested > CACHE_SETTLE_COUNT) {
            return CACHE_SETTLE_COUNT;
        }
        return requested;
    }

    /** 缓存秒数（结算比率）。 */
    public static long resolveCacheSettleRate(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_RATE;
        }
        if (requested > CACHE_SETTLE_RATE) {
            return CACHE_SETTLE_RATE;
        }
        return requested;
    }

    /** 缓存秒数（结算日期）。 */
    public static long resolveCacheSettleDate(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_DATE;
        }
        if (requested > CACHE_SETTLE_DATE) {
            return CACHE_SETTLE_DATE;
        }
        return requested;
    }

    /** 缓存秒数（结算时间）。 */
    public static long resolveCacheSettleTime(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_TIME;
        }
        if (requested > CACHE_SETTLE_TIME) {
            return CACHE_SETTLE_TIME;
        }
        return requested;
    }

    /** 缓存秒数（结算标记）。 */
    public static long resolveCacheSettleFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_FLAG;
        }
        if (requested > CACHE_SETTLE_FLAG) {
            return CACHE_SETTLE_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（结算说明）。 */
    public static long resolveCacheSettleRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_REMARK;
        }
        if (requested > CACHE_SETTLE_REMARK) {
            return CACHE_SETTLE_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（结算来源）。 */
    public static long resolveCacheSettleSource(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_SOURCE;
        }
        if (requested > CACHE_SETTLE_SOURCE) {
            return CACHE_SETTLE_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（结算版本）。 */
    public static long resolveCacheSettleVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_VERSION;
        }
        if (requested > CACHE_SETTLE_VERSION) {
            return CACHE_SETTLE_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（结算区域）。 */
    public static long resolveCacheSettleRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_SETTLE_REGION;
        }
        if (requested > CACHE_SETTLE_REGION) {
            return CACHE_SETTLE_REGION;
        }
        return requested;
    }

}

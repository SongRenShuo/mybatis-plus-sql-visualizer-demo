package cn.song.custmetadata.config;

/**
 * 客户投诉CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustComplaintCacheConfig {

    public static final String MODULE_CODE = "CUST_COMPLAINT_CACHE_CONFIG";

    /** 缓存秒数（发票编码） */
    public static final long CACHE_INVOICE_CODE = 5L;

    /** 缓存秒数（发票级别） */
    public static final long CACHE_INVOICE_LEVEL = 10L;

    /** 缓存秒数（发票状态） */
    public static final long CACHE_INVOICE_STATUS = 15L;

    /** 缓存秒数（发票金额） */
    public static final long CACHE_INVOICE_AMOUNT = 20L;

    /** 缓存秒数（发票数量） */
    public static final long CACHE_INVOICE_COUNT = 25L;

    /** 缓存秒数（发票比率） */
    public static final long CACHE_INVOICE_RATE = 30L;

    /** 缓存秒数（发票日期） */
    public static final long CACHE_INVOICE_DATE = 35L;

    /** 缓存秒数（发票时间） */
    public static final long CACHE_INVOICE_TIME = 40L;

    /** 缓存秒数（发票标记） */
    public static final long CACHE_INVOICE_FLAG = 45L;

    /** 缓存秒数（发票说明） */
    public static final long CACHE_INVOICE_REMARK = 50L;

    /** 缓存秒数（发票来源） */
    public static final long CACHE_INVOICE_SOURCE = 55L;

    /** 缓存秒数（发票版本） */
    public static final long CACHE_INVOICE_VERSION = 60L;

    /** 缓存秒数（发票区域） */
    public static final long CACHE_INVOICE_REGION = 65L;

    /** 缓存秒数（发票渠道） */
    public static final long CACHE_INVOICE_CHANNEL = 70L;

    /** 缓存秒数（发票分组） */
    public static final long CACHE_INVOICE_GROUP = 75L;

    /** 缓存秒数（发票标签） */
    public static final long CACHE_INVOICE_TAG = 80L;

    /** 缓存秒数（发票负责人） */
    public static final long CACHE_INVOICE_OWNER = 85L;

    /** 缓存秒数（结算编号） */
    public static final long CACHE_SETTLE_NO = 90L;

    /** 缓存秒数（结算名称） */
    public static final long CACHE_SETTLE_NAME = 95L;

    /** 缓存秒数（结算类型） */
    public static final long CACHE_SETTLE_TYPE = 100L;

    /** 缓存秒数（结算编码） */
    public static final long CACHE_SETTLE_CODE = 105L;

    /** 缓存秒数（结算级别） */
    public static final long CACHE_SETTLE_LEVEL = 110L;

    /** 缓存秒数（结算状态） */
    public static final long CACHE_SETTLE_STATUS = 115L;

    /** 缓存秒数（结算金额） */
    public static final long CACHE_SETTLE_AMOUNT = 120L;

    /** 缓存秒数（结算数量） */
    public static final long CACHE_SETTLE_COUNT = 125L;

    /** 缓存秒数（结算比率） */
    public static final long CACHE_SETTLE_RATE = 130L;

    /** 缓存秒数（结算日期） */
    public static final long CACHE_SETTLE_DATE = 135L;

    /** 缓存秒数（结算时间） */
    public static final long CACHE_SETTLE_TIME = 140L;

    /** 缓存秒数（结算标记） */
    public static final long CACHE_SETTLE_FLAG = 145L;

    /** 缓存秒数（结算说明） */
    public static final long CACHE_SETTLE_REMARK = 150L;

    /** 缓存秒数（结算来源） */
    public static final long CACHE_SETTLE_SOURCE = 155L;

    /** 缓存秒数（结算版本） */
    public static final long CACHE_SETTLE_VERSION = 160L;

    /** 缓存秒数（结算区域） */
    public static final long CACHE_SETTLE_REGION = 165L;

    /** 缓存秒数（结算渠道） */
    public static final long CACHE_SETTLE_CHANNEL = 170L;

    /** 缓存秒数（结算分组） */
    public static final long CACHE_SETTLE_GROUP = 175L;

    /** 缓存秒数（结算标签） */
    public static final long CACHE_SETTLE_TAG = 180L;

    /** 缓存秒数（结算负责人） */
    public static final long CACHE_SETTLE_OWNER = 185L;

    /** 缓存秒数（审计编号） */
    public static final long CACHE_AUDIT_NO = 190L;

    /** 缓存秒数（审计名称） */
    public static final long CACHE_AUDIT_NAME = 195L;

    /** 缓存秒数（审计类型） */
    public static final long CACHE_AUDIT_TYPE = 200L;

    /** 缓存秒数（审计编码） */
    public static final long CACHE_AUDIT_CODE = 205L;

    /** 缓存秒数（审计级别） */
    public static final long CACHE_AUDIT_LEVEL = 210L;

    /** 缓存秒数（审计状态） */
    public static final long CACHE_AUDIT_STATUS = 215L;

    /** 缓存秒数（审计金额） */
    public static final long CACHE_AUDIT_AMOUNT = 220L;

    /** 缓存秒数（审计数量） */
    public static final long CACHE_AUDIT_COUNT = 225L;

    /** 缓存秒数（审计比率） */
    public static final long CACHE_AUDIT_RATE = 230L;

    /** 缓存秒数（审计日期） */
    public static final long CACHE_AUDIT_DATE = 235L;

    /** 缓存秒数（审计时间） */
    public static final long CACHE_AUDIT_TIME = 240L;

    /** 缓存秒数（审计标记） */
    public static final long CACHE_AUDIT_FLAG = 245L;

    /** 缓存秒数（审计说明） */
    public static final long CACHE_AUDIT_REMARK = 250L;

    /** 缓存秒数（审计来源） */
    public static final long CACHE_AUDIT_SOURCE = 255L;

    /** 缓存秒数（审计版本） */
    public static final long CACHE_AUDIT_VERSION = 260L;

    /** 缓存秒数（审计区域） */
    public static final long CACHE_AUDIT_REGION = 265L;

    /** 缓存秒数（审计渠道） */
    public static final long CACHE_AUDIT_CHANNEL = 270L;

    /** 缓存秒数（审计分组） */
    public static final long CACHE_AUDIT_GROUP = 275L;

    /** 缓存秒数（审计标签） */
    public static final long CACHE_AUDIT_TAG = 280L;

    /** 缓存秒数（审计负责人） */
    public static final long CACHE_AUDIT_OWNER = 285L;

    /** 缓存秒数（附件编号） */
    public static final long CACHE_ATTACH_NO = 290L;

    /** 缓存秒数（附件名称） */
    public static final long CACHE_ATTACH_NAME = 295L;

    /** 缓存秒数（附件类型） */
    public static final long CACHE_ATTACH_TYPE = 300L;

    private CustComplaintCacheConfig() {
    }

    /** 缓存秒数（发票编码）。 */
    public static long resolveCacheInvoiceCode(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_CODE;
        }
        if (requested > CACHE_INVOICE_CODE) {
            return CACHE_INVOICE_CODE;
        }
        return requested;
    }

    /** 缓存秒数（发票级别）。 */
    public static long resolveCacheInvoiceLevel(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_LEVEL;
        }
        if (requested > CACHE_INVOICE_LEVEL) {
            return CACHE_INVOICE_LEVEL;
        }
        return requested;
    }

    /** 缓存秒数（发票状态）。 */
    public static long resolveCacheInvoiceStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_STATUS;
        }
        if (requested > CACHE_INVOICE_STATUS) {
            return CACHE_INVOICE_STATUS;
        }
        return requested;
    }

    /** 缓存秒数（发票金额）。 */
    public static long resolveCacheInvoiceAmount(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_AMOUNT;
        }
        if (requested > CACHE_INVOICE_AMOUNT) {
            return CACHE_INVOICE_AMOUNT;
        }
        return requested;
    }

    /** 缓存秒数（发票数量）。 */
    public static long resolveCacheInvoiceCount(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_COUNT;
        }
        if (requested > CACHE_INVOICE_COUNT) {
            return CACHE_INVOICE_COUNT;
        }
        return requested;
    }

    /** 缓存秒数（发票比率）。 */
    public static long resolveCacheInvoiceRate(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_RATE;
        }
        if (requested > CACHE_INVOICE_RATE) {
            return CACHE_INVOICE_RATE;
        }
        return requested;
    }

    /** 缓存秒数（发票日期）。 */
    public static long resolveCacheInvoiceDate(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_DATE;
        }
        if (requested > CACHE_INVOICE_DATE) {
            return CACHE_INVOICE_DATE;
        }
        return requested;
    }

    /** 缓存秒数（发票时间）。 */
    public static long resolveCacheInvoiceTime(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_TIME;
        }
        if (requested > CACHE_INVOICE_TIME) {
            return CACHE_INVOICE_TIME;
        }
        return requested;
    }

    /** 缓存秒数（发票标记）。 */
    public static long resolveCacheInvoiceFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_FLAG;
        }
        if (requested > CACHE_INVOICE_FLAG) {
            return CACHE_INVOICE_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（发票说明）。 */
    public static long resolveCacheInvoiceRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_REMARK;
        }
        if (requested > CACHE_INVOICE_REMARK) {
            return CACHE_INVOICE_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（发票来源）。 */
    public static long resolveCacheInvoiceSource(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_SOURCE;
        }
        if (requested > CACHE_INVOICE_SOURCE) {
            return CACHE_INVOICE_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（发票版本）。 */
    public static long resolveCacheInvoiceVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_VERSION;
        }
        if (requested > CACHE_INVOICE_VERSION) {
            return CACHE_INVOICE_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（发票区域）。 */
    public static long resolveCacheInvoiceRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_REGION;
        }
        if (requested > CACHE_INVOICE_REGION) {
            return CACHE_INVOICE_REGION;
        }
        return requested;
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

}

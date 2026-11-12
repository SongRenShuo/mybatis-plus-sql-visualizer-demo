package cn.song.custmetadata.config;

/**
 * 客户投诉ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustComplaintModuleConfig {

    public static final String MODULE_CODE = "CUST_COMPLAINT";

    /** 缓存秒数（付款时间） */
    public static final long CACHE_PAYMENT_TIME = 5L;

    /** 缓存秒数（付款标记） */
    public static final long CACHE_PAYMENT_FLAG = 10L;

    /** 缓存秒数（付款说明） */
    public static final long CACHE_PAYMENT_REMARK = 15L;

    /** 缓存秒数（付款来源） */
    public static final long CACHE_PAYMENT_SOURCE = 20L;

    /** 缓存秒数（付款版本） */
    public static final long CACHE_PAYMENT_VERSION = 25L;

    /** 缓存秒数（付款区域） */
    public static final long CACHE_PAYMENT_REGION = 30L;

    /** 缓存秒数（付款渠道） */
    public static final long CACHE_PAYMENT_CHANNEL = 35L;

    /** 缓存秒数（付款分组） */
    public static final long CACHE_PAYMENT_GROUP = 40L;

    /** 缓存秒数（付款标签） */
    public static final long CACHE_PAYMENT_TAG = 45L;

    /** 缓存秒数（付款负责人） */
    public static final long CACHE_PAYMENT_OWNER = 50L;

    /** 缓存秒数（发票编号） */
    public static final long CACHE_INVOICE_NO = 55L;

    /** 缓存秒数（发票名称） */
    public static final long CACHE_INVOICE_NAME = 60L;

    /** 缓存秒数（发票类型） */
    public static final long CACHE_INVOICE_TYPE = 65L;

    /** 缓存秒数（发票编码） */
    public static final long CACHE_INVOICE_CODE = 70L;

    /** 缓存秒数（发票级别） */
    public static final long CACHE_INVOICE_LEVEL = 75L;

    /** 缓存秒数（发票状态） */
    public static final long CACHE_INVOICE_STATUS = 80L;

    /** 缓存秒数（发票金额） */
    public static final long CACHE_INVOICE_AMOUNT = 85L;

    /** 缓存秒数（发票数量） */
    public static final long CACHE_INVOICE_COUNT = 90L;

    /** 缓存秒数（发票比率） */
    public static final long CACHE_INVOICE_RATE = 95L;

    /** 缓存秒数（发票日期） */
    public static final long CACHE_INVOICE_DATE = 100L;

    /** 缓存秒数（发票时间） */
    public static final long CACHE_INVOICE_TIME = 105L;

    /** 缓存秒数（发票标记） */
    public static final long CACHE_INVOICE_FLAG = 110L;

    /** 缓存秒数（发票说明） */
    public static final long CACHE_INVOICE_REMARK = 115L;

    /** 缓存秒数（发票来源） */
    public static final long CACHE_INVOICE_SOURCE = 120L;

    /** 缓存秒数（发票版本） */
    public static final long CACHE_INVOICE_VERSION = 125L;

    /** 缓存秒数（发票区域） */
    public static final long CACHE_INVOICE_REGION = 130L;

    /** 缓存秒数（发票渠道） */
    public static final long CACHE_INVOICE_CHANNEL = 135L;

    /** 缓存秒数（发票分组） */
    public static final long CACHE_INVOICE_GROUP = 140L;

    /** 缓存秒数（发票标签） */
    public static final long CACHE_INVOICE_TAG = 145L;

    /** 缓存秒数（发票负责人） */
    public static final long CACHE_INVOICE_OWNER = 150L;

    /** 缓存秒数（结算编号） */
    public static final long CACHE_SETTLE_NO = 155L;

    /** 缓存秒数（结算名称） */
    public static final long CACHE_SETTLE_NAME = 160L;

    /** 缓存秒数（结算类型） */
    public static final long CACHE_SETTLE_TYPE = 165L;

    /** 缓存秒数（结算编码） */
    public static final long CACHE_SETTLE_CODE = 170L;

    /** 缓存秒数（结算级别） */
    public static final long CACHE_SETTLE_LEVEL = 175L;

    /** 缓存秒数（结算状态） */
    public static final long CACHE_SETTLE_STATUS = 180L;

    /** 缓存秒数（结算金额） */
    public static final long CACHE_SETTLE_AMOUNT = 185L;

    /** 缓存秒数（结算数量） */
    public static final long CACHE_SETTLE_COUNT = 190L;

    /** 缓存秒数（结算比率） */
    public static final long CACHE_SETTLE_RATE = 195L;

    /** 缓存秒数（结算日期） */
    public static final long CACHE_SETTLE_DATE = 200L;

    /** 缓存秒数（结算时间） */
    public static final long CACHE_SETTLE_TIME = 205L;

    /** 缓存秒数（结算标记） */
    public static final long CACHE_SETTLE_FLAG = 210L;

    /** 缓存秒数（结算说明） */
    public static final long CACHE_SETTLE_REMARK = 215L;

    /** 缓存秒数（结算来源） */
    public static final long CACHE_SETTLE_SOURCE = 220L;

    /** 缓存秒数（结算版本） */
    public static final long CACHE_SETTLE_VERSION = 225L;

    /** 缓存秒数（结算区域） */
    public static final long CACHE_SETTLE_REGION = 230L;

    /** 缓存秒数（结算渠道） */
    public static final long CACHE_SETTLE_CHANNEL = 235L;

    /** 缓存秒数（结算分组） */
    public static final long CACHE_SETTLE_GROUP = 240L;

    /** 缓存秒数（结算标签） */
    public static final long CACHE_SETTLE_TAG = 245L;

    /** 缓存秒数（结算负责人） */
    public static final long CACHE_SETTLE_OWNER = 250L;

    /** 缓存秒数（审计编号） */
    public static final long CACHE_AUDIT_NO = 255L;

    /** 缓存秒数（审计名称） */
    public static final long CACHE_AUDIT_NAME = 260L;

    /** 缓存秒数（审计类型） */
    public static final long CACHE_AUDIT_TYPE = 265L;

    /** 缓存秒数（审计编码） */
    public static final long CACHE_AUDIT_CODE = 270L;

    /** 缓存秒数（审计级别） */
    public static final long CACHE_AUDIT_LEVEL = 275L;

    /** 缓存秒数（审计状态） */
    public static final long CACHE_AUDIT_STATUS = 280L;

    /** 缓存秒数（审计金额） */
    public static final long CACHE_AUDIT_AMOUNT = 285L;

    /** 缓存秒数（审计数量） */
    public static final long CACHE_AUDIT_COUNT = 290L;

    /** 缓存秒数（审计比率） */
    public static final long CACHE_AUDIT_RATE = 295L;

    /** 缓存秒数（审计日期） */
    public static final long CACHE_AUDIT_DATE = 300L;

    private CustComplaintModuleConfig() {
    }

    /** 缓存秒数（付款时间）。 */
    public static long resolveCachePaymentTime(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_TIME;
        }
        if (requested > CACHE_PAYMENT_TIME) {
            return CACHE_PAYMENT_TIME;
        }
        return requested;
    }

    /** 缓存秒数（付款标记）。 */
    public static long resolveCachePaymentFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_FLAG;
        }
        if (requested > CACHE_PAYMENT_FLAG) {
            return CACHE_PAYMENT_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（付款说明）。 */
    public static long resolveCachePaymentRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_REMARK;
        }
        if (requested > CACHE_PAYMENT_REMARK) {
            return CACHE_PAYMENT_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（付款来源）。 */
    public static long resolveCachePaymentSource(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_SOURCE;
        }
        if (requested > CACHE_PAYMENT_SOURCE) {
            return CACHE_PAYMENT_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（付款版本）。 */
    public static long resolveCachePaymentVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_VERSION;
        }
        if (requested > CACHE_PAYMENT_VERSION) {
            return CACHE_PAYMENT_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（付款区域）。 */
    public static long resolveCachePaymentRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_REGION;
        }
        if (requested > CACHE_PAYMENT_REGION) {
            return CACHE_PAYMENT_REGION;
        }
        return requested;
    }

    /** 缓存秒数（付款渠道）。 */
    public static long resolveCachePaymentChannel(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_CHANNEL;
        }
        if (requested > CACHE_PAYMENT_CHANNEL) {
            return CACHE_PAYMENT_CHANNEL;
        }
        return requested;
    }

    /** 缓存秒数（付款分组）。 */
    public static long resolveCachePaymentGroup(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_GROUP;
        }
        if (requested > CACHE_PAYMENT_GROUP) {
            return CACHE_PAYMENT_GROUP;
        }
        return requested;
    }

    /** 缓存秒数（付款标签）。 */
    public static long resolveCachePaymentTag(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_TAG;
        }
        if (requested > CACHE_PAYMENT_TAG) {
            return CACHE_PAYMENT_TAG;
        }
        return requested;
    }

    /** 缓存秒数（付款负责人）。 */
    public static long resolveCachePaymentOwner(long requested) {
        if (requested <= 0L) {
            return CACHE_PAYMENT_OWNER;
        }
        if (requested > CACHE_PAYMENT_OWNER) {
            return CACHE_PAYMENT_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（发票编号）。 */
    public static long resolveCacheInvoiceNo(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_NO;
        }
        if (requested > CACHE_INVOICE_NO) {
            return CACHE_INVOICE_NO;
        }
        return requested;
    }

    /** 缓存秒数（发票名称）。 */
    public static long resolveCacheInvoiceName(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_NAME;
        }
        if (requested > CACHE_INVOICE_NAME) {
            return CACHE_INVOICE_NAME;
        }
        return requested;
    }

    /** 缓存秒数（发票类型）。 */
    public static long resolveCacheInvoiceType(long requested) {
        if (requested <= 0L) {
            return CACHE_INVOICE_TYPE;
        }
        if (requested > CACHE_INVOICE_TYPE) {
            return CACHE_INVOICE_TYPE;
        }
        return requested;
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

}

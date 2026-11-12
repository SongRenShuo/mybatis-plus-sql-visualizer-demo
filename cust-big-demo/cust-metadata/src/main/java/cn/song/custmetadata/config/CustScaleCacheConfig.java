package cn.song.custmetadata.config;

/**
 * 客户规模CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustScaleCacheConfig {

    public static final String MODULE_CODE = "CUST_SCALE_CACHE_CONFIG";

    /** 重试次数（付款分组） */
    public static final long RETRY_PAYMENT_GROUP = 5L;

    /** 重试次数（付款标签） */
    public static final long RETRY_PAYMENT_TAG = 10L;

    /** 重试次数（付款负责人） */
    public static final long RETRY_PAYMENT_OWNER = 15L;

    /** 重试次数（发票编号） */
    public static final long RETRY_INVOICE_NO = 20L;

    /** 重试次数（发票名称） */
    public static final long RETRY_INVOICE_NAME = 25L;

    /** 重试次数（发票类型） */
    public static final long RETRY_INVOICE_TYPE = 30L;

    /** 重试次数（发票编码） */
    public static final long RETRY_INVOICE_CODE = 35L;

    /** 重试次数（发票级别） */
    public static final long RETRY_INVOICE_LEVEL = 40L;

    /** 重试次数（发票状态） */
    public static final long RETRY_INVOICE_STATUS = 45L;

    /** 重试次数（发票金额） */
    public static final long RETRY_INVOICE_AMOUNT = 50L;

    /** 重试次数（发票数量） */
    public static final long RETRY_INVOICE_COUNT = 55L;

    /** 重试次数（发票比率） */
    public static final long RETRY_INVOICE_RATE = 60L;

    /** 重试次数（发票日期） */
    public static final long RETRY_INVOICE_DATE = 65L;

    /** 重试次数（发票时间） */
    public static final long RETRY_INVOICE_TIME = 70L;

    /** 重试次数（发票标记） */
    public static final long RETRY_INVOICE_FLAG = 75L;

    /** 重试次数（发票说明） */
    public static final long RETRY_INVOICE_REMARK = 80L;

    /** 重试次数（发票来源） */
    public static final long RETRY_INVOICE_SOURCE = 85L;

    /** 重试次数（发票版本） */
    public static final long RETRY_INVOICE_VERSION = 90L;

    /** 重试次数（发票区域） */
    public static final long RETRY_INVOICE_REGION = 95L;

    /** 重试次数（发票渠道） */
    public static final long RETRY_INVOICE_CHANNEL = 100L;

    /** 重试次数（发票分组） */
    public static final long RETRY_INVOICE_GROUP = 105L;

    /** 重试次数（发票标签） */
    public static final long RETRY_INVOICE_TAG = 110L;

    /** 重试次数（发票负责人） */
    public static final long RETRY_INVOICE_OWNER = 115L;

    /** 重试次数（结算编号） */
    public static final long RETRY_SETTLE_NO = 120L;

    /** 重试次数（结算名称） */
    public static final long RETRY_SETTLE_NAME = 125L;

    /** 重试次数（结算类型） */
    public static final long RETRY_SETTLE_TYPE = 130L;

    /** 重试次数（结算编码） */
    public static final long RETRY_SETTLE_CODE = 135L;

    /** 重试次数（结算级别） */
    public static final long RETRY_SETTLE_LEVEL = 140L;

    /** 重试次数（结算状态） */
    public static final long RETRY_SETTLE_STATUS = 145L;

    /** 重试次数（结算金额） */
    public static final long RETRY_SETTLE_AMOUNT = 150L;

    /** 重试次数（结算数量） */
    public static final long RETRY_SETTLE_COUNT = 155L;

    /** 重试次数（结算比率） */
    public static final long RETRY_SETTLE_RATE = 160L;

    /** 重试次数（结算日期） */
    public static final long RETRY_SETTLE_DATE = 165L;

    /** 重试次数（结算时间） */
    public static final long RETRY_SETTLE_TIME = 170L;

    /** 重试次数（结算标记） */
    public static final long RETRY_SETTLE_FLAG = 175L;

    /** 重试次数（结算说明） */
    public static final long RETRY_SETTLE_REMARK = 180L;

    /** 重试次数（结算来源） */
    public static final long RETRY_SETTLE_SOURCE = 185L;

    /** 重试次数（结算版本） */
    public static final long RETRY_SETTLE_VERSION = 190L;

    /** 重试次数（结算区域） */
    public static final long RETRY_SETTLE_REGION = 195L;

    /** 重试次数（结算渠道） */
    public static final long RETRY_SETTLE_CHANNEL = 200L;

    /** 重试次数（结算分组） */
    public static final long RETRY_SETTLE_GROUP = 205L;

    /** 重试次数（结算标签） */
    public static final long RETRY_SETTLE_TAG = 210L;

    /** 重试次数（结算负责人） */
    public static final long RETRY_SETTLE_OWNER = 215L;

    /** 重试次数（审计编号） */
    public static final long RETRY_AUDIT_NO = 220L;

    /** 重试次数（审计名称） */
    public static final long RETRY_AUDIT_NAME = 225L;

    /** 重试次数（审计类型） */
    public static final long RETRY_AUDIT_TYPE = 230L;

    /** 重试次数（审计编码） */
    public static final long RETRY_AUDIT_CODE = 235L;

    /** 重试次数（审计级别） */
    public static final long RETRY_AUDIT_LEVEL = 240L;

    /** 重试次数（审计状态） */
    public static final long RETRY_AUDIT_STATUS = 245L;

    /** 重试次数（审计金额） */
    public static final long RETRY_AUDIT_AMOUNT = 250L;

    /** 重试次数（审计数量） */
    public static final long RETRY_AUDIT_COUNT = 255L;

    /** 重试次数（审计比率） */
    public static final long RETRY_AUDIT_RATE = 260L;

    /** 重试次数（审计日期） */
    public static final long RETRY_AUDIT_DATE = 265L;

    /** 重试次数（审计时间） */
    public static final long RETRY_AUDIT_TIME = 270L;

    /** 重试次数（审计标记） */
    public static final long RETRY_AUDIT_FLAG = 275L;

    /** 重试次数（审计说明） */
    public static final long RETRY_AUDIT_REMARK = 280L;

    /** 重试次数（审计来源） */
    public static final long RETRY_AUDIT_SOURCE = 285L;

    /** 重试次数（审计版本） */
    public static final long RETRY_AUDIT_VERSION = 290L;

    /** 重试次数（审计区域） */
    public static final long RETRY_AUDIT_REGION = 295L;

    /** 重试次数（审计渠道） */
    public static final long RETRY_AUDIT_CHANNEL = 300L;

    private CustScaleCacheConfig() {
    }

    /** 重试次数（付款分组）。 */
    public static long resolveRetryPaymentGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_GROUP;
        }
        if (requested > RETRY_PAYMENT_GROUP) {
            return RETRY_PAYMENT_GROUP;
        }
        return requested;
    }

    /** 重试次数（付款标签）。 */
    public static long resolveRetryPaymentTag(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_TAG;
        }
        if (requested > RETRY_PAYMENT_TAG) {
            return RETRY_PAYMENT_TAG;
        }
        return requested;
    }

    /** 重试次数（付款负责人）。 */
    public static long resolveRetryPaymentOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_OWNER;
        }
        if (requested > RETRY_PAYMENT_OWNER) {
            return RETRY_PAYMENT_OWNER;
        }
        return requested;
    }

    /** 重试次数（发票编号）。 */
    public static long resolveRetryInvoiceNo(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_NO;
        }
        if (requested > RETRY_INVOICE_NO) {
            return RETRY_INVOICE_NO;
        }
        return requested;
    }

    /** 重试次数（发票名称）。 */
    public static long resolveRetryInvoiceName(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_NAME;
        }
        if (requested > RETRY_INVOICE_NAME) {
            return RETRY_INVOICE_NAME;
        }
        return requested;
    }

    /** 重试次数（发票类型）。 */
    public static long resolveRetryInvoiceType(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_TYPE;
        }
        if (requested > RETRY_INVOICE_TYPE) {
            return RETRY_INVOICE_TYPE;
        }
        return requested;
    }

    /** 重试次数（发票编码）。 */
    public static long resolveRetryInvoiceCode(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_CODE;
        }
        if (requested > RETRY_INVOICE_CODE) {
            return RETRY_INVOICE_CODE;
        }
        return requested;
    }

    /** 重试次数（发票级别）。 */
    public static long resolveRetryInvoiceLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_LEVEL;
        }
        if (requested > RETRY_INVOICE_LEVEL) {
            return RETRY_INVOICE_LEVEL;
        }
        return requested;
    }

    /** 重试次数（发票状态）。 */
    public static long resolveRetryInvoiceStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_STATUS;
        }
        if (requested > RETRY_INVOICE_STATUS) {
            return RETRY_INVOICE_STATUS;
        }
        return requested;
    }

    /** 重试次数（发票金额）。 */
    public static long resolveRetryInvoiceAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_AMOUNT;
        }
        if (requested > RETRY_INVOICE_AMOUNT) {
            return RETRY_INVOICE_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（发票数量）。 */
    public static long resolveRetryInvoiceCount(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_COUNT;
        }
        if (requested > RETRY_INVOICE_COUNT) {
            return RETRY_INVOICE_COUNT;
        }
        return requested;
    }

    /** 重试次数（发票比率）。 */
    public static long resolveRetryInvoiceRate(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_RATE;
        }
        if (requested > RETRY_INVOICE_RATE) {
            return RETRY_INVOICE_RATE;
        }
        return requested;
    }

    /** 重试次数（发票日期）。 */
    public static long resolveRetryInvoiceDate(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_DATE;
        }
        if (requested > RETRY_INVOICE_DATE) {
            return RETRY_INVOICE_DATE;
        }
        return requested;
    }

    /** 重试次数（发票时间）。 */
    public static long resolveRetryInvoiceTime(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_TIME;
        }
        if (requested > RETRY_INVOICE_TIME) {
            return RETRY_INVOICE_TIME;
        }
        return requested;
    }

    /** 重试次数（发票标记）。 */
    public static long resolveRetryInvoiceFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_FLAG;
        }
        if (requested > RETRY_INVOICE_FLAG) {
            return RETRY_INVOICE_FLAG;
        }
        return requested;
    }

    /** 重试次数（发票说明）。 */
    public static long resolveRetryInvoiceRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_REMARK;
        }
        if (requested > RETRY_INVOICE_REMARK) {
            return RETRY_INVOICE_REMARK;
        }
        return requested;
    }

    /** 重试次数（发票来源）。 */
    public static long resolveRetryInvoiceSource(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_SOURCE;
        }
        if (requested > RETRY_INVOICE_SOURCE) {
            return RETRY_INVOICE_SOURCE;
        }
        return requested;
    }

    /** 重试次数（发票版本）。 */
    public static long resolveRetryInvoiceVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_VERSION;
        }
        if (requested > RETRY_INVOICE_VERSION) {
            return RETRY_INVOICE_VERSION;
        }
        return requested;
    }

    /** 重试次数（发票区域）。 */
    public static long resolveRetryInvoiceRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_REGION;
        }
        if (requested > RETRY_INVOICE_REGION) {
            return RETRY_INVOICE_REGION;
        }
        return requested;
    }

    /** 重试次数（发票渠道）。 */
    public static long resolveRetryInvoiceChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_CHANNEL;
        }
        if (requested > RETRY_INVOICE_CHANNEL) {
            return RETRY_INVOICE_CHANNEL;
        }
        return requested;
    }

}

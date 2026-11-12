package cn.song.custmetadata.config;

/**
 * 客户标签CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustTagCacheConfig {

    public static final String MODULE_CODE = "CUST_TAG_CACHE_CONFIG";

    /** 单次查询上限（付款状态） */
    public static final long LIMIT_PAYMENT_STATUS = 5L;

    /** 单次查询上限（付款金额） */
    public static final long LIMIT_PAYMENT_AMOUNT = 10L;

    /** 单次查询上限（付款数量） */
    public static final long LIMIT_PAYMENT_COUNT = 15L;

    /** 单次查询上限（付款比率） */
    public static final long LIMIT_PAYMENT_RATE = 20L;

    /** 单次查询上限（付款日期） */
    public static final long LIMIT_PAYMENT_DATE = 25L;

    /** 单次查询上限（付款时间） */
    public static final long LIMIT_PAYMENT_TIME = 30L;

    /** 单次查询上限（付款标记） */
    public static final long LIMIT_PAYMENT_FLAG = 35L;

    /** 单次查询上限（付款说明） */
    public static final long LIMIT_PAYMENT_REMARK = 40L;

    /** 单次查询上限（付款来源） */
    public static final long LIMIT_PAYMENT_SOURCE = 45L;

    /** 单次查询上限（付款版本） */
    public static final long LIMIT_PAYMENT_VERSION = 50L;

    /** 单次查询上限（付款区域） */
    public static final long LIMIT_PAYMENT_REGION = 55L;

    /** 单次查询上限（付款渠道） */
    public static final long LIMIT_PAYMENT_CHANNEL = 60L;

    /** 单次查询上限（付款分组） */
    public static final long LIMIT_PAYMENT_GROUP = 65L;

    /** 单次查询上限（付款标签） */
    public static final long LIMIT_PAYMENT_TAG = 70L;

    /** 单次查询上限（付款负责人） */
    public static final long LIMIT_PAYMENT_OWNER = 75L;

    /** 单次查询上限（发票编号） */
    public static final long LIMIT_INVOICE_NO = 80L;

    /** 单次查询上限（发票名称） */
    public static final long LIMIT_INVOICE_NAME = 85L;

    /** 单次查询上限（发票类型） */
    public static final long LIMIT_INVOICE_TYPE = 90L;

    /** 单次查询上限（发票编码） */
    public static final long LIMIT_INVOICE_CODE = 95L;

    /** 单次查询上限（发票级别） */
    public static final long LIMIT_INVOICE_LEVEL = 100L;

    /** 单次查询上限（发票状态） */
    public static final long LIMIT_INVOICE_STATUS = 105L;

    /** 单次查询上限（发票金额） */
    public static final long LIMIT_INVOICE_AMOUNT = 110L;

    /** 单次查询上限（发票数量） */
    public static final long LIMIT_INVOICE_COUNT = 115L;

    /** 单次查询上限（发票比率） */
    public static final long LIMIT_INVOICE_RATE = 120L;

    /** 单次查询上限（发票日期） */
    public static final long LIMIT_INVOICE_DATE = 125L;

    /** 单次查询上限（发票时间） */
    public static final long LIMIT_INVOICE_TIME = 130L;

    /** 单次查询上限（发票标记） */
    public static final long LIMIT_INVOICE_FLAG = 135L;

    /** 单次查询上限（发票说明） */
    public static final long LIMIT_INVOICE_REMARK = 140L;

    /** 单次查询上限（发票来源） */
    public static final long LIMIT_INVOICE_SOURCE = 145L;

    /** 单次查询上限（发票版本） */
    public static final long LIMIT_INVOICE_VERSION = 150L;

    /** 单次查询上限（发票区域） */
    public static final long LIMIT_INVOICE_REGION = 155L;

    /** 单次查询上限（发票渠道） */
    public static final long LIMIT_INVOICE_CHANNEL = 160L;

    /** 单次查询上限（发票分组） */
    public static final long LIMIT_INVOICE_GROUP = 165L;

    /** 单次查询上限（发票标签） */
    public static final long LIMIT_INVOICE_TAG = 170L;

    /** 单次查询上限（发票负责人） */
    public static final long LIMIT_INVOICE_OWNER = 175L;

    /** 单次查询上限（结算编号） */
    public static final long LIMIT_SETTLE_NO = 180L;

    /** 单次查询上限（结算名称） */
    public static final long LIMIT_SETTLE_NAME = 185L;

    /** 单次查询上限（结算类型） */
    public static final long LIMIT_SETTLE_TYPE = 190L;

    /** 单次查询上限（结算编码） */
    public static final long LIMIT_SETTLE_CODE = 195L;

    /** 单次查询上限（结算级别） */
    public static final long LIMIT_SETTLE_LEVEL = 200L;

    /** 单次查询上限（结算状态） */
    public static final long LIMIT_SETTLE_STATUS = 205L;

    /** 单次查询上限（结算金额） */
    public static final long LIMIT_SETTLE_AMOUNT = 210L;

    /** 单次查询上限（结算数量） */
    public static final long LIMIT_SETTLE_COUNT = 215L;

    /** 单次查询上限（结算比率） */
    public static final long LIMIT_SETTLE_RATE = 220L;

    /** 单次查询上限（结算日期） */
    public static final long LIMIT_SETTLE_DATE = 225L;

    /** 单次查询上限（结算时间） */
    public static final long LIMIT_SETTLE_TIME = 230L;

    /** 单次查询上限（结算标记） */
    public static final long LIMIT_SETTLE_FLAG = 235L;

    /** 单次查询上限（结算说明） */
    public static final long LIMIT_SETTLE_REMARK = 240L;

    /** 单次查询上限（结算来源） */
    public static final long LIMIT_SETTLE_SOURCE = 245L;

    /** 单次查询上限（结算版本） */
    public static final long LIMIT_SETTLE_VERSION = 250L;

    /** 单次查询上限（结算区域） */
    public static final long LIMIT_SETTLE_REGION = 255L;

    /** 单次查询上限（结算渠道） */
    public static final long LIMIT_SETTLE_CHANNEL = 260L;

    /** 单次查询上限（结算分组） */
    public static final long LIMIT_SETTLE_GROUP = 265L;

    /** 单次查询上限（结算标签） */
    public static final long LIMIT_SETTLE_TAG = 270L;

    /** 单次查询上限（结算负责人） */
    public static final long LIMIT_SETTLE_OWNER = 275L;

    /** 单次查询上限（审计编号） */
    public static final long LIMIT_AUDIT_NO = 280L;

    /** 单次查询上限（审计名称） */
    public static final long LIMIT_AUDIT_NAME = 285L;

    /** 单次查询上限（审计类型） */
    public static final long LIMIT_AUDIT_TYPE = 290L;

    /** 单次查询上限（审计编码） */
    public static final long LIMIT_AUDIT_CODE = 295L;

    /** 单次查询上限（审计级别） */
    public static final long LIMIT_AUDIT_LEVEL = 300L;

    private CustTagCacheConfig() {
    }

    /** 单次查询上限（付款状态）。 */
    public static long resolveLimitPaymentStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_STATUS;
        }
        if (requested > LIMIT_PAYMENT_STATUS) {
            return LIMIT_PAYMENT_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（付款金额）。 */
    public static long resolveLimitPaymentAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_AMOUNT;
        }
        if (requested > LIMIT_PAYMENT_AMOUNT) {
            return LIMIT_PAYMENT_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（付款数量）。 */
    public static long resolveLimitPaymentCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_COUNT;
        }
        if (requested > LIMIT_PAYMENT_COUNT) {
            return LIMIT_PAYMENT_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（付款比率）。 */
    public static long resolveLimitPaymentRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_RATE;
        }
        if (requested > LIMIT_PAYMENT_RATE) {
            return LIMIT_PAYMENT_RATE;
        }
        return requested;
    }

    /** 单次查询上限（付款日期）。 */
    public static long resolveLimitPaymentDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_DATE;
        }
        if (requested > LIMIT_PAYMENT_DATE) {
            return LIMIT_PAYMENT_DATE;
        }
        return requested;
    }

    /** 单次查询上限（付款时间）。 */
    public static long resolveLimitPaymentTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_TIME;
        }
        if (requested > LIMIT_PAYMENT_TIME) {
            return LIMIT_PAYMENT_TIME;
        }
        return requested;
    }

    /** 单次查询上限（付款标记）。 */
    public static long resolveLimitPaymentFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_FLAG;
        }
        if (requested > LIMIT_PAYMENT_FLAG) {
            return LIMIT_PAYMENT_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（付款说明）。 */
    public static long resolveLimitPaymentRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_REMARK;
        }
        if (requested > LIMIT_PAYMENT_REMARK) {
            return LIMIT_PAYMENT_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（付款来源）。 */
    public static long resolveLimitPaymentSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_SOURCE;
        }
        if (requested > LIMIT_PAYMENT_SOURCE) {
            return LIMIT_PAYMENT_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（付款版本）。 */
    public static long resolveLimitPaymentVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_VERSION;
        }
        if (requested > LIMIT_PAYMENT_VERSION) {
            return LIMIT_PAYMENT_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（付款区域）。 */
    public static long resolveLimitPaymentRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_REGION;
        }
        if (requested > LIMIT_PAYMENT_REGION) {
            return LIMIT_PAYMENT_REGION;
        }
        return requested;
    }

    /** 单次查询上限（付款渠道）。 */
    public static long resolveLimitPaymentChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_CHANNEL;
        }
        if (requested > LIMIT_PAYMENT_CHANNEL) {
            return LIMIT_PAYMENT_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（付款分组）。 */
    public static long resolveLimitPaymentGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_GROUP;
        }
        if (requested > LIMIT_PAYMENT_GROUP) {
            return LIMIT_PAYMENT_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（付款标签）。 */
    public static long resolveLimitPaymentTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_TAG;
        }
        if (requested > LIMIT_PAYMENT_TAG) {
            return LIMIT_PAYMENT_TAG;
        }
        return requested;
    }

    /** 单次查询上限（付款负责人）。 */
    public static long resolveLimitPaymentOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_PAYMENT_OWNER;
        }
        if (requested > LIMIT_PAYMENT_OWNER) {
            return LIMIT_PAYMENT_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（发票编号）。 */
    public static long resolveLimitInvoiceNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_NO;
        }
        if (requested > LIMIT_INVOICE_NO) {
            return LIMIT_INVOICE_NO;
        }
        return requested;
    }

    /** 单次查询上限（发票名称）。 */
    public static long resolveLimitInvoiceName(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_NAME;
        }
        if (requested > LIMIT_INVOICE_NAME) {
            return LIMIT_INVOICE_NAME;
        }
        return requested;
    }

    /** 单次查询上限（发票类型）。 */
    public static long resolveLimitInvoiceType(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_TYPE;
        }
        if (requested > LIMIT_INVOICE_TYPE) {
            return LIMIT_INVOICE_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（发票编码）。 */
    public static long resolveLimitInvoiceCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_CODE;
        }
        if (requested > LIMIT_INVOICE_CODE) {
            return LIMIT_INVOICE_CODE;
        }
        return requested;
    }

    /** 单次查询上限（发票级别）。 */
    public static long resolveLimitInvoiceLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_LEVEL;
        }
        if (requested > LIMIT_INVOICE_LEVEL) {
            return LIMIT_INVOICE_LEVEL;
        }
        return requested;
    }

}

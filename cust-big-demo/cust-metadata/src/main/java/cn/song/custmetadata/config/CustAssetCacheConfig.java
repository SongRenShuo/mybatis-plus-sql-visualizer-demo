package cn.song.custmetadata.config;

/**
 * 客户资产CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustAssetCacheConfig {

    public static final String MODULE_CODE = "CUST_ASSET_CACHE_CONFIG";

    /** 超时毫秒数（付款标记） */
    public static final long TIMEOUT_PAYMENT_FLAG = 5L;

    /** 超时毫秒数（付款说明） */
    public static final long TIMEOUT_PAYMENT_REMARK = 10L;

    /** 超时毫秒数（付款来源） */
    public static final long TIMEOUT_PAYMENT_SOURCE = 15L;

    /** 超时毫秒数（付款版本） */
    public static final long TIMEOUT_PAYMENT_VERSION = 20L;

    /** 超时毫秒数（付款区域） */
    public static final long TIMEOUT_PAYMENT_REGION = 25L;

    /** 超时毫秒数（付款渠道） */
    public static final long TIMEOUT_PAYMENT_CHANNEL = 30L;

    /** 超时毫秒数（付款分组） */
    public static final long TIMEOUT_PAYMENT_GROUP = 35L;

    /** 超时毫秒数（付款标签） */
    public static final long TIMEOUT_PAYMENT_TAG = 40L;

    /** 超时毫秒数（付款负责人） */
    public static final long TIMEOUT_PAYMENT_OWNER = 45L;

    /** 超时毫秒数（发票编号） */
    public static final long TIMEOUT_INVOICE_NO = 50L;

    /** 超时毫秒数（发票名称） */
    public static final long TIMEOUT_INVOICE_NAME = 55L;

    /** 超时毫秒数（发票类型） */
    public static final long TIMEOUT_INVOICE_TYPE = 60L;

    /** 超时毫秒数（发票编码） */
    public static final long TIMEOUT_INVOICE_CODE = 65L;

    /** 超时毫秒数（发票级别） */
    public static final long TIMEOUT_INVOICE_LEVEL = 70L;

    /** 超时毫秒数（发票状态） */
    public static final long TIMEOUT_INVOICE_STATUS = 75L;

    /** 超时毫秒数（发票金额） */
    public static final long TIMEOUT_INVOICE_AMOUNT = 80L;

    /** 超时毫秒数（发票数量） */
    public static final long TIMEOUT_INVOICE_COUNT = 85L;

    /** 超时毫秒数（发票比率） */
    public static final long TIMEOUT_INVOICE_RATE = 90L;

    /** 超时毫秒数（发票日期） */
    public static final long TIMEOUT_INVOICE_DATE = 95L;

    /** 超时毫秒数（发票时间） */
    public static final long TIMEOUT_INVOICE_TIME = 100L;

    /** 超时毫秒数（发票标记） */
    public static final long TIMEOUT_INVOICE_FLAG = 105L;

    /** 超时毫秒数（发票说明） */
    public static final long TIMEOUT_INVOICE_REMARK = 110L;

    /** 超时毫秒数（发票来源） */
    public static final long TIMEOUT_INVOICE_SOURCE = 115L;

    /** 超时毫秒数（发票版本） */
    public static final long TIMEOUT_INVOICE_VERSION = 120L;

    /** 超时毫秒数（发票区域） */
    public static final long TIMEOUT_INVOICE_REGION = 125L;

    /** 超时毫秒数（发票渠道） */
    public static final long TIMEOUT_INVOICE_CHANNEL = 130L;

    /** 超时毫秒数（发票分组） */
    public static final long TIMEOUT_INVOICE_GROUP = 135L;

    /** 超时毫秒数（发票标签） */
    public static final long TIMEOUT_INVOICE_TAG = 140L;

    /** 超时毫秒数（发票负责人） */
    public static final long TIMEOUT_INVOICE_OWNER = 145L;

    /** 超时毫秒数（结算编号） */
    public static final long TIMEOUT_SETTLE_NO = 150L;

    /** 超时毫秒数（结算名称） */
    public static final long TIMEOUT_SETTLE_NAME = 155L;

    /** 超时毫秒数（结算类型） */
    public static final long TIMEOUT_SETTLE_TYPE = 160L;

    /** 超时毫秒数（结算编码） */
    public static final long TIMEOUT_SETTLE_CODE = 165L;

    /** 超时毫秒数（结算级别） */
    public static final long TIMEOUT_SETTLE_LEVEL = 170L;

    /** 超时毫秒数（结算状态） */
    public static final long TIMEOUT_SETTLE_STATUS = 175L;

    /** 超时毫秒数（结算金额） */
    public static final long TIMEOUT_SETTLE_AMOUNT = 180L;

    /** 超时毫秒数（结算数量） */
    public static final long TIMEOUT_SETTLE_COUNT = 185L;

    /** 超时毫秒数（结算比率） */
    public static final long TIMEOUT_SETTLE_RATE = 190L;

    /** 超时毫秒数（结算日期） */
    public static final long TIMEOUT_SETTLE_DATE = 195L;

    /** 超时毫秒数（结算时间） */
    public static final long TIMEOUT_SETTLE_TIME = 200L;

    /** 超时毫秒数（结算标记） */
    public static final long TIMEOUT_SETTLE_FLAG = 205L;

    /** 超时毫秒数（结算说明） */
    public static final long TIMEOUT_SETTLE_REMARK = 210L;

    /** 超时毫秒数（结算来源） */
    public static final long TIMEOUT_SETTLE_SOURCE = 215L;

    /** 超时毫秒数（结算版本） */
    public static final long TIMEOUT_SETTLE_VERSION = 220L;

    /** 超时毫秒数（结算区域） */
    public static final long TIMEOUT_SETTLE_REGION = 225L;

    /** 超时毫秒数（结算渠道） */
    public static final long TIMEOUT_SETTLE_CHANNEL = 230L;

    /** 超时毫秒数（结算分组） */
    public static final long TIMEOUT_SETTLE_GROUP = 235L;

    /** 超时毫秒数（结算标签） */
    public static final long TIMEOUT_SETTLE_TAG = 240L;

    /** 超时毫秒数（结算负责人） */
    public static final long TIMEOUT_SETTLE_OWNER = 245L;

    /** 超时毫秒数（审计编号） */
    public static final long TIMEOUT_AUDIT_NO = 250L;

    /** 超时毫秒数（审计名称） */
    public static final long TIMEOUT_AUDIT_NAME = 255L;

    /** 超时毫秒数（审计类型） */
    public static final long TIMEOUT_AUDIT_TYPE = 260L;

    /** 超时毫秒数（审计编码） */
    public static final long TIMEOUT_AUDIT_CODE = 265L;

    /** 超时毫秒数（审计级别） */
    public static final long TIMEOUT_AUDIT_LEVEL = 270L;

    /** 超时毫秒数（审计状态） */
    public static final long TIMEOUT_AUDIT_STATUS = 275L;

    /** 超时毫秒数（审计金额） */
    public static final long TIMEOUT_AUDIT_AMOUNT = 280L;

    /** 超时毫秒数（审计数量） */
    public static final long TIMEOUT_AUDIT_COUNT = 285L;

    /** 超时毫秒数（审计比率） */
    public static final long TIMEOUT_AUDIT_RATE = 290L;

    /** 超时毫秒数（审计日期） */
    public static final long TIMEOUT_AUDIT_DATE = 295L;

    /** 超时毫秒数（审计时间） */
    public static final long TIMEOUT_AUDIT_TIME = 300L;

    private CustAssetCacheConfig() {
    }

    /** 超时毫秒数（付款标记）。 */
    public static long resolveTimeoutPaymentFlag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PAYMENT_FLAG;
        }
        if (requested > TIMEOUT_PAYMENT_FLAG) {
            return TIMEOUT_PAYMENT_FLAG;
        }
        return requested;
    }

    /** 超时毫秒数（付款说明）。 */
    public static long resolveTimeoutPaymentRemark(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PAYMENT_REMARK;
        }
        if (requested > TIMEOUT_PAYMENT_REMARK) {
            return TIMEOUT_PAYMENT_REMARK;
        }
        return requested;
    }

    /** 超时毫秒数（付款来源）。 */
    public static long resolveTimeoutPaymentSource(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PAYMENT_SOURCE;
        }
        if (requested > TIMEOUT_PAYMENT_SOURCE) {
            return TIMEOUT_PAYMENT_SOURCE;
        }
        return requested;
    }

    /** 超时毫秒数（付款版本）。 */
    public static long resolveTimeoutPaymentVersion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PAYMENT_VERSION;
        }
        if (requested > TIMEOUT_PAYMENT_VERSION) {
            return TIMEOUT_PAYMENT_VERSION;
        }
        return requested;
    }

    /** 超时毫秒数（付款区域）。 */
    public static long resolveTimeoutPaymentRegion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PAYMENT_REGION;
        }
        if (requested > TIMEOUT_PAYMENT_REGION) {
            return TIMEOUT_PAYMENT_REGION;
        }
        return requested;
    }

    /** 超时毫秒数（付款渠道）。 */
    public static long resolveTimeoutPaymentChannel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PAYMENT_CHANNEL;
        }
        if (requested > TIMEOUT_PAYMENT_CHANNEL) {
            return TIMEOUT_PAYMENT_CHANNEL;
        }
        return requested;
    }

    /** 超时毫秒数（付款分组）。 */
    public static long resolveTimeoutPaymentGroup(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PAYMENT_GROUP;
        }
        if (requested > TIMEOUT_PAYMENT_GROUP) {
            return TIMEOUT_PAYMENT_GROUP;
        }
        return requested;
    }

    /** 超时毫秒数（付款标签）。 */
    public static long resolveTimeoutPaymentTag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PAYMENT_TAG;
        }
        if (requested > TIMEOUT_PAYMENT_TAG) {
            return TIMEOUT_PAYMENT_TAG;
        }
        return requested;
    }

    /** 超时毫秒数（付款负责人）。 */
    public static long resolveTimeoutPaymentOwner(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PAYMENT_OWNER;
        }
        if (requested > TIMEOUT_PAYMENT_OWNER) {
            return TIMEOUT_PAYMENT_OWNER;
        }
        return requested;
    }

    /** 超时毫秒数（发票编号）。 */
    public static long resolveTimeoutInvoiceNo(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_NO;
        }
        if (requested > TIMEOUT_INVOICE_NO) {
            return TIMEOUT_INVOICE_NO;
        }
        return requested;
    }

    /** 超时毫秒数（发票名称）。 */
    public static long resolveTimeoutInvoiceName(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_NAME;
        }
        if (requested > TIMEOUT_INVOICE_NAME) {
            return TIMEOUT_INVOICE_NAME;
        }
        return requested;
    }

    /** 超时毫秒数（发票类型）。 */
    public static long resolveTimeoutInvoiceType(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_TYPE;
        }
        if (requested > TIMEOUT_INVOICE_TYPE) {
            return TIMEOUT_INVOICE_TYPE;
        }
        return requested;
    }

    /** 超时毫秒数（发票编码）。 */
    public static long resolveTimeoutInvoiceCode(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_CODE;
        }
        if (requested > TIMEOUT_INVOICE_CODE) {
            return TIMEOUT_INVOICE_CODE;
        }
        return requested;
    }

    /** 超时毫秒数（发票级别）。 */
    public static long resolveTimeoutInvoiceLevel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_LEVEL;
        }
        if (requested > TIMEOUT_INVOICE_LEVEL) {
            return TIMEOUT_INVOICE_LEVEL;
        }
        return requested;
    }

    /** 超时毫秒数（发票状态）。 */
    public static long resolveTimeoutInvoiceStatus(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_STATUS;
        }
        if (requested > TIMEOUT_INVOICE_STATUS) {
            return TIMEOUT_INVOICE_STATUS;
        }
        return requested;
    }

    /** 超时毫秒数（发票金额）。 */
    public static long resolveTimeoutInvoiceAmount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_AMOUNT;
        }
        if (requested > TIMEOUT_INVOICE_AMOUNT) {
            return TIMEOUT_INVOICE_AMOUNT;
        }
        return requested;
    }

    /** 超时毫秒数（发票数量）。 */
    public static long resolveTimeoutInvoiceCount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_COUNT;
        }
        if (requested > TIMEOUT_INVOICE_COUNT) {
            return TIMEOUT_INVOICE_COUNT;
        }
        return requested;
    }

    /** 超时毫秒数（发票比率）。 */
    public static long resolveTimeoutInvoiceRate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_RATE;
        }
        if (requested > TIMEOUT_INVOICE_RATE) {
            return TIMEOUT_INVOICE_RATE;
        }
        return requested;
    }

    /** 超时毫秒数（发票日期）。 */
    public static long resolveTimeoutInvoiceDate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_DATE;
        }
        if (requested > TIMEOUT_INVOICE_DATE) {
            return TIMEOUT_INVOICE_DATE;
        }
        return requested;
    }

    /** 超时毫秒数（发票时间）。 */
    public static long resolveTimeoutInvoiceTime(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_TIME;
        }
        if (requested > TIMEOUT_INVOICE_TIME) {
            return TIMEOUT_INVOICE_TIME;
        }
        return requested;
    }

}

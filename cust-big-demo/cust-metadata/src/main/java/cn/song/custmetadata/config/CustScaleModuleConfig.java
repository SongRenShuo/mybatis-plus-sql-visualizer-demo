package cn.song.custmetadata.config;

/**
 * 客户规模ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustScaleModuleConfig {

    public static final String MODULE_CODE = "CUST_SCALE";

    /** 重试次数（付款级别） */
    public static final long RETRY_PAYMENT_LEVEL = 5L;

    /** 重试次数（付款状态） */
    public static final long RETRY_PAYMENT_STATUS = 10L;

    /** 重试次数（付款金额） */
    public static final long RETRY_PAYMENT_AMOUNT = 15L;

    /** 重试次数（付款数量） */
    public static final long RETRY_PAYMENT_COUNT = 20L;

    /** 重试次数（付款比率） */
    public static final long RETRY_PAYMENT_RATE = 25L;

    /** 重试次数（付款日期） */
    public static final long RETRY_PAYMENT_DATE = 30L;

    /** 重试次数（付款时间） */
    public static final long RETRY_PAYMENT_TIME = 35L;

    /** 重试次数（付款标记） */
    public static final long RETRY_PAYMENT_FLAG = 40L;

    /** 重试次数（付款说明） */
    public static final long RETRY_PAYMENT_REMARK = 45L;

    /** 重试次数（付款来源） */
    public static final long RETRY_PAYMENT_SOURCE = 50L;

    /** 重试次数（付款版本） */
    public static final long RETRY_PAYMENT_VERSION = 55L;

    /** 重试次数（付款区域） */
    public static final long RETRY_PAYMENT_REGION = 60L;

    /** 重试次数（付款渠道） */
    public static final long RETRY_PAYMENT_CHANNEL = 65L;

    /** 重试次数（付款分组） */
    public static final long RETRY_PAYMENT_GROUP = 70L;

    /** 重试次数（付款标签） */
    public static final long RETRY_PAYMENT_TAG = 75L;

    /** 重试次数（付款负责人） */
    public static final long RETRY_PAYMENT_OWNER = 80L;

    /** 重试次数（发票编号） */
    public static final long RETRY_INVOICE_NO = 85L;

    /** 重试次数（发票名称） */
    public static final long RETRY_INVOICE_NAME = 90L;

    /** 重试次数（发票类型） */
    public static final long RETRY_INVOICE_TYPE = 95L;

    /** 重试次数（发票编码） */
    public static final long RETRY_INVOICE_CODE = 100L;

    /** 重试次数（发票级别） */
    public static final long RETRY_INVOICE_LEVEL = 105L;

    /** 重试次数（发票状态） */
    public static final long RETRY_INVOICE_STATUS = 110L;

    /** 重试次数（发票金额） */
    public static final long RETRY_INVOICE_AMOUNT = 115L;

    /** 重试次数（发票数量） */
    public static final long RETRY_INVOICE_COUNT = 120L;

    /** 重试次数（发票比率） */
    public static final long RETRY_INVOICE_RATE = 125L;

    /** 重试次数（发票日期） */
    public static final long RETRY_INVOICE_DATE = 130L;

    /** 重试次数（发票时间） */
    public static final long RETRY_INVOICE_TIME = 135L;

    /** 重试次数（发票标记） */
    public static final long RETRY_INVOICE_FLAG = 140L;

    /** 重试次数（发票说明） */
    public static final long RETRY_INVOICE_REMARK = 145L;

    /** 重试次数（发票来源） */
    public static final long RETRY_INVOICE_SOURCE = 150L;

    /** 重试次数（发票版本） */
    public static final long RETRY_INVOICE_VERSION = 155L;

    /** 重试次数（发票区域） */
    public static final long RETRY_INVOICE_REGION = 160L;

    /** 重试次数（发票渠道） */
    public static final long RETRY_INVOICE_CHANNEL = 165L;

    /** 重试次数（发票分组） */
    public static final long RETRY_INVOICE_GROUP = 170L;

    /** 重试次数（发票标签） */
    public static final long RETRY_INVOICE_TAG = 175L;

    /** 重试次数（发票负责人） */
    public static final long RETRY_INVOICE_OWNER = 180L;

    /** 重试次数（结算编号） */
    public static final long RETRY_SETTLE_NO = 185L;

    /** 重试次数（结算名称） */
    public static final long RETRY_SETTLE_NAME = 190L;

    /** 重试次数（结算类型） */
    public static final long RETRY_SETTLE_TYPE = 195L;

    /** 重试次数（结算编码） */
    public static final long RETRY_SETTLE_CODE = 200L;

    /** 重试次数（结算级别） */
    public static final long RETRY_SETTLE_LEVEL = 205L;

    /** 重试次数（结算状态） */
    public static final long RETRY_SETTLE_STATUS = 210L;

    /** 重试次数（结算金额） */
    public static final long RETRY_SETTLE_AMOUNT = 215L;

    /** 重试次数（结算数量） */
    public static final long RETRY_SETTLE_COUNT = 220L;

    /** 重试次数（结算比率） */
    public static final long RETRY_SETTLE_RATE = 225L;

    /** 重试次数（结算日期） */
    public static final long RETRY_SETTLE_DATE = 230L;

    /** 重试次数（结算时间） */
    public static final long RETRY_SETTLE_TIME = 235L;

    /** 重试次数（结算标记） */
    public static final long RETRY_SETTLE_FLAG = 240L;

    /** 重试次数（结算说明） */
    public static final long RETRY_SETTLE_REMARK = 245L;

    /** 重试次数（结算来源） */
    public static final long RETRY_SETTLE_SOURCE = 250L;

    /** 重试次数（结算版本） */
    public static final long RETRY_SETTLE_VERSION = 255L;

    /** 重试次数（结算区域） */
    public static final long RETRY_SETTLE_REGION = 260L;

    /** 重试次数（结算渠道） */
    public static final long RETRY_SETTLE_CHANNEL = 265L;

    /** 重试次数（结算分组） */
    public static final long RETRY_SETTLE_GROUP = 270L;

    /** 重试次数（结算标签） */
    public static final long RETRY_SETTLE_TAG = 275L;

    /** 重试次数（结算负责人） */
    public static final long RETRY_SETTLE_OWNER = 280L;

    /** 重试次数（审计编号） */
    public static final long RETRY_AUDIT_NO = 285L;

    /** 重试次数（审计名称） */
    public static final long RETRY_AUDIT_NAME = 290L;

    /** 重试次数（审计类型） */
    public static final long RETRY_AUDIT_TYPE = 295L;

    /** 重试次数（审计编码） */
    public static final long RETRY_AUDIT_CODE = 300L;

    private CustScaleModuleConfig() {
    }

    /** 重试次数（付款级别）。 */
    public static long resolveRetryPaymentLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_LEVEL;
        }
        if (requested > RETRY_PAYMENT_LEVEL) {
            return RETRY_PAYMENT_LEVEL;
        }
        return requested;
    }

    /** 重试次数（付款状态）。 */
    public static long resolveRetryPaymentStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_STATUS;
        }
        if (requested > RETRY_PAYMENT_STATUS) {
            return RETRY_PAYMENT_STATUS;
        }
        return requested;
    }

    /** 重试次数（付款金额）。 */
    public static long resolveRetryPaymentAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_AMOUNT;
        }
        if (requested > RETRY_PAYMENT_AMOUNT) {
            return RETRY_PAYMENT_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（付款数量）。 */
    public static long resolveRetryPaymentCount(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_COUNT;
        }
        if (requested > RETRY_PAYMENT_COUNT) {
            return RETRY_PAYMENT_COUNT;
        }
        return requested;
    }

    /** 重试次数（付款比率）。 */
    public static long resolveRetryPaymentRate(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_RATE;
        }
        if (requested > RETRY_PAYMENT_RATE) {
            return RETRY_PAYMENT_RATE;
        }
        return requested;
    }

    /** 重试次数（付款日期）。 */
    public static long resolveRetryPaymentDate(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_DATE;
        }
        if (requested > RETRY_PAYMENT_DATE) {
            return RETRY_PAYMENT_DATE;
        }
        return requested;
    }

    /** 重试次数（付款时间）。 */
    public static long resolveRetryPaymentTime(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_TIME;
        }
        if (requested > RETRY_PAYMENT_TIME) {
            return RETRY_PAYMENT_TIME;
        }
        return requested;
    }

    /** 重试次数（付款标记）。 */
    public static long resolveRetryPaymentFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_FLAG;
        }
        if (requested > RETRY_PAYMENT_FLAG) {
            return RETRY_PAYMENT_FLAG;
        }
        return requested;
    }

    /** 重试次数（付款说明）。 */
    public static long resolveRetryPaymentRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_REMARK;
        }
        if (requested > RETRY_PAYMENT_REMARK) {
            return RETRY_PAYMENT_REMARK;
        }
        return requested;
    }

    /** 重试次数（付款来源）。 */
    public static long resolveRetryPaymentSource(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_SOURCE;
        }
        if (requested > RETRY_PAYMENT_SOURCE) {
            return RETRY_PAYMENT_SOURCE;
        }
        return requested;
    }

    /** 重试次数（付款版本）。 */
    public static long resolveRetryPaymentVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_VERSION;
        }
        if (requested > RETRY_PAYMENT_VERSION) {
            return RETRY_PAYMENT_VERSION;
        }
        return requested;
    }

    /** 重试次数（付款区域）。 */
    public static long resolveRetryPaymentRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_REGION;
        }
        if (requested > RETRY_PAYMENT_REGION) {
            return RETRY_PAYMENT_REGION;
        }
        return requested;
    }

    /** 重试次数（付款渠道）。 */
    public static long resolveRetryPaymentChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_PAYMENT_CHANNEL;
        }
        if (requested > RETRY_PAYMENT_CHANNEL) {
            return RETRY_PAYMENT_CHANNEL;
        }
        return requested;
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

}

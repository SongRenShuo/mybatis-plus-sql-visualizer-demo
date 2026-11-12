package cn.song.custmetadata.config;

/**
 * 客户标签JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustTagJobConfig {

    public static final String MODULE_CODE = "CUST_TAG_JOB_CONFIG";

    /** 单次查询上限（付款标签） */
    public static final long LIMIT_PAYMENT_TAG = 5L;

    /** 单次查询上限（付款负责人） */
    public static final long LIMIT_PAYMENT_OWNER = 10L;

    /** 单次查询上限（发票编号） */
    public static final long LIMIT_INVOICE_NO = 15L;

    /** 单次查询上限（发票名称） */
    public static final long LIMIT_INVOICE_NAME = 20L;

    /** 单次查询上限（发票类型） */
    public static final long LIMIT_INVOICE_TYPE = 25L;

    /** 单次查询上限（发票编码） */
    public static final long LIMIT_INVOICE_CODE = 30L;

    /** 单次查询上限（发票级别） */
    public static final long LIMIT_INVOICE_LEVEL = 35L;

    /** 单次查询上限（发票状态） */
    public static final long LIMIT_INVOICE_STATUS = 40L;

    /** 单次查询上限（发票金额） */
    public static final long LIMIT_INVOICE_AMOUNT = 45L;

    /** 单次查询上限（发票数量） */
    public static final long LIMIT_INVOICE_COUNT = 50L;

    /** 单次查询上限（发票比率） */
    public static final long LIMIT_INVOICE_RATE = 55L;

    /** 单次查询上限（发票日期） */
    public static final long LIMIT_INVOICE_DATE = 60L;

    /** 单次查询上限（发票时间） */
    public static final long LIMIT_INVOICE_TIME = 65L;

    /** 单次查询上限（发票标记） */
    public static final long LIMIT_INVOICE_FLAG = 70L;

    /** 单次查询上限（发票说明） */
    public static final long LIMIT_INVOICE_REMARK = 75L;

    /** 单次查询上限（发票来源） */
    public static final long LIMIT_INVOICE_SOURCE = 80L;

    /** 单次查询上限（发票版本） */
    public static final long LIMIT_INVOICE_VERSION = 85L;

    /** 单次查询上限（发票区域） */
    public static final long LIMIT_INVOICE_REGION = 90L;

    /** 单次查询上限（发票渠道） */
    public static final long LIMIT_INVOICE_CHANNEL = 95L;

    /** 单次查询上限（发票分组） */
    public static final long LIMIT_INVOICE_GROUP = 100L;

    /** 单次查询上限（发票标签） */
    public static final long LIMIT_INVOICE_TAG = 105L;

    /** 单次查询上限（发票负责人） */
    public static final long LIMIT_INVOICE_OWNER = 110L;

    /** 单次查询上限（结算编号） */
    public static final long LIMIT_SETTLE_NO = 115L;

    /** 单次查询上限（结算名称） */
    public static final long LIMIT_SETTLE_NAME = 120L;

    /** 单次查询上限（结算类型） */
    public static final long LIMIT_SETTLE_TYPE = 125L;

    /** 单次查询上限（结算编码） */
    public static final long LIMIT_SETTLE_CODE = 130L;

    /** 单次查询上限（结算级别） */
    public static final long LIMIT_SETTLE_LEVEL = 135L;

    /** 单次查询上限（结算状态） */
    public static final long LIMIT_SETTLE_STATUS = 140L;

    /** 单次查询上限（结算金额） */
    public static final long LIMIT_SETTLE_AMOUNT = 145L;

    /** 单次查询上限（结算数量） */
    public static final long LIMIT_SETTLE_COUNT = 150L;

    /** 单次查询上限（结算比率） */
    public static final long LIMIT_SETTLE_RATE = 155L;

    /** 单次查询上限（结算日期） */
    public static final long LIMIT_SETTLE_DATE = 160L;

    /** 单次查询上限（结算时间） */
    public static final long LIMIT_SETTLE_TIME = 165L;

    /** 单次查询上限（结算标记） */
    public static final long LIMIT_SETTLE_FLAG = 170L;

    /** 单次查询上限（结算说明） */
    public static final long LIMIT_SETTLE_REMARK = 175L;

    /** 单次查询上限（结算来源） */
    public static final long LIMIT_SETTLE_SOURCE = 180L;

    /** 单次查询上限（结算版本） */
    public static final long LIMIT_SETTLE_VERSION = 185L;

    /** 单次查询上限（结算区域） */
    public static final long LIMIT_SETTLE_REGION = 190L;

    /** 单次查询上限（结算渠道） */
    public static final long LIMIT_SETTLE_CHANNEL = 195L;

    /** 单次查询上限（结算分组） */
    public static final long LIMIT_SETTLE_GROUP = 200L;

    /** 单次查询上限（结算标签） */
    public static final long LIMIT_SETTLE_TAG = 205L;

    /** 单次查询上限（结算负责人） */
    public static final long LIMIT_SETTLE_OWNER = 210L;

    /** 单次查询上限（审计编号） */
    public static final long LIMIT_AUDIT_NO = 215L;

    /** 单次查询上限（审计名称） */
    public static final long LIMIT_AUDIT_NAME = 220L;

    /** 单次查询上限（审计类型） */
    public static final long LIMIT_AUDIT_TYPE = 225L;

    /** 单次查询上限（审计编码） */
    public static final long LIMIT_AUDIT_CODE = 230L;

    /** 单次查询上限（审计级别） */
    public static final long LIMIT_AUDIT_LEVEL = 235L;

    /** 单次查询上限（审计状态） */
    public static final long LIMIT_AUDIT_STATUS = 240L;

    /** 单次查询上限（审计金额） */
    public static final long LIMIT_AUDIT_AMOUNT = 245L;

    /** 单次查询上限（审计数量） */
    public static final long LIMIT_AUDIT_COUNT = 250L;

    /** 单次查询上限（审计比率） */
    public static final long LIMIT_AUDIT_RATE = 255L;

    /** 单次查询上限（审计日期） */
    public static final long LIMIT_AUDIT_DATE = 260L;

    /** 单次查询上限（审计时间） */
    public static final long LIMIT_AUDIT_TIME = 265L;

    /** 单次查询上限（审计标记） */
    public static final long LIMIT_AUDIT_FLAG = 270L;

    /** 单次查询上限（审计说明） */
    public static final long LIMIT_AUDIT_REMARK = 275L;

    /** 单次查询上限（审计来源） */
    public static final long LIMIT_AUDIT_SOURCE = 280L;

    /** 单次查询上限（审计版本） */
    public static final long LIMIT_AUDIT_VERSION = 285L;

    /** 单次查询上限（审计区域） */
    public static final long LIMIT_AUDIT_REGION = 290L;

    /** 单次查询上限（审计渠道） */
    public static final long LIMIT_AUDIT_CHANNEL = 295L;

    /** 单次查询上限（审计分组） */
    public static final long LIMIT_AUDIT_GROUP = 300L;

    private CustTagJobConfig() {
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

    /** 单次查询上限（发票状态）。 */
    public static long resolveLimitInvoiceStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_STATUS;
        }
        if (requested > LIMIT_INVOICE_STATUS) {
            return LIMIT_INVOICE_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（发票金额）。 */
    public static long resolveLimitInvoiceAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_AMOUNT;
        }
        if (requested > LIMIT_INVOICE_AMOUNT) {
            return LIMIT_INVOICE_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（发票数量）。 */
    public static long resolveLimitInvoiceCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_COUNT;
        }
        if (requested > LIMIT_INVOICE_COUNT) {
            return LIMIT_INVOICE_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（发票比率）。 */
    public static long resolveLimitInvoiceRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_RATE;
        }
        if (requested > LIMIT_INVOICE_RATE) {
            return LIMIT_INVOICE_RATE;
        }
        return requested;
    }

    /** 单次查询上限（发票日期）。 */
    public static long resolveLimitInvoiceDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_DATE;
        }
        if (requested > LIMIT_INVOICE_DATE) {
            return LIMIT_INVOICE_DATE;
        }
        return requested;
    }

    /** 单次查询上限（发票时间）。 */
    public static long resolveLimitInvoiceTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_TIME;
        }
        if (requested > LIMIT_INVOICE_TIME) {
            return LIMIT_INVOICE_TIME;
        }
        return requested;
    }

    /** 单次查询上限（发票标记）。 */
    public static long resolveLimitInvoiceFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_FLAG;
        }
        if (requested > LIMIT_INVOICE_FLAG) {
            return LIMIT_INVOICE_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（发票说明）。 */
    public static long resolveLimitInvoiceRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_REMARK;
        }
        if (requested > LIMIT_INVOICE_REMARK) {
            return LIMIT_INVOICE_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（发票来源）。 */
    public static long resolveLimitInvoiceSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_SOURCE;
        }
        if (requested > LIMIT_INVOICE_SOURCE) {
            return LIMIT_INVOICE_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（发票版本）。 */
    public static long resolveLimitInvoiceVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_VERSION;
        }
        if (requested > LIMIT_INVOICE_VERSION) {
            return LIMIT_INVOICE_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（发票区域）。 */
    public static long resolveLimitInvoiceRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_REGION;
        }
        if (requested > LIMIT_INVOICE_REGION) {
            return LIMIT_INVOICE_REGION;
        }
        return requested;
    }

    /** 单次查询上限（发票渠道）。 */
    public static long resolveLimitInvoiceChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_CHANNEL;
        }
        if (requested > LIMIT_INVOICE_CHANNEL) {
            return LIMIT_INVOICE_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（发票分组）。 */
    public static long resolveLimitInvoiceGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_INVOICE_GROUP;
        }
        if (requested > LIMIT_INVOICE_GROUP) {
            return LIMIT_INVOICE_GROUP;
        }
        return requested;
    }

}

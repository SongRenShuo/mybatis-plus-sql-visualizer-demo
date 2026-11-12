package cn.song.custmetadata.config;

/**
 * 客户发票ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustInvoiceModuleConfig {

    public static final String MODULE_CODE = "CUST_INVOICE";

    /** 批处理条数（付款渠道） */
    public static final long BATCH_PAYMENT_CHANNEL = 5L;

    /** 批处理条数（付款分组） */
    public static final long BATCH_PAYMENT_GROUP = 10L;

    /** 批处理条数（付款标签） */
    public static final long BATCH_PAYMENT_TAG = 15L;

    /** 批处理条数（付款负责人） */
    public static final long BATCH_PAYMENT_OWNER = 20L;

    /** 批处理条数（发票编号） */
    public static final long BATCH_INVOICE_NO = 25L;

    /** 批处理条数（发票名称） */
    public static final long BATCH_INVOICE_NAME = 30L;

    /** 批处理条数（发票类型） */
    public static final long BATCH_INVOICE_TYPE = 35L;

    /** 批处理条数（发票编码） */
    public static final long BATCH_INVOICE_CODE = 40L;

    /** 批处理条数（发票级别） */
    public static final long BATCH_INVOICE_LEVEL = 45L;

    /** 批处理条数（发票状态） */
    public static final long BATCH_INVOICE_STATUS = 50L;

    /** 批处理条数（发票金额） */
    public static final long BATCH_INVOICE_AMOUNT = 55L;

    /** 批处理条数（发票数量） */
    public static final long BATCH_INVOICE_COUNT = 60L;

    /** 批处理条数（发票比率） */
    public static final long BATCH_INVOICE_RATE = 65L;

    /** 批处理条数（发票日期） */
    public static final long BATCH_INVOICE_DATE = 70L;

    /** 批处理条数（发票时间） */
    public static final long BATCH_INVOICE_TIME = 75L;

    /** 批处理条数（发票标记） */
    public static final long BATCH_INVOICE_FLAG = 80L;

    /** 批处理条数（发票说明） */
    public static final long BATCH_INVOICE_REMARK = 85L;

    /** 批处理条数（发票来源） */
    public static final long BATCH_INVOICE_SOURCE = 90L;

    /** 批处理条数（发票版本） */
    public static final long BATCH_INVOICE_VERSION = 95L;

    /** 批处理条数（发票区域） */
    public static final long BATCH_INVOICE_REGION = 100L;

    /** 批处理条数（发票渠道） */
    public static final long BATCH_INVOICE_CHANNEL = 105L;

    /** 批处理条数（发票分组） */
    public static final long BATCH_INVOICE_GROUP = 110L;

    /** 批处理条数（发票标签） */
    public static final long BATCH_INVOICE_TAG = 115L;

    /** 批处理条数（发票负责人） */
    public static final long BATCH_INVOICE_OWNER = 120L;

    /** 批处理条数（结算编号） */
    public static final long BATCH_SETTLE_NO = 125L;

    /** 批处理条数（结算名称） */
    public static final long BATCH_SETTLE_NAME = 130L;

    /** 批处理条数（结算类型） */
    public static final long BATCH_SETTLE_TYPE = 135L;

    /** 批处理条数（结算编码） */
    public static final long BATCH_SETTLE_CODE = 140L;

    /** 批处理条数（结算级别） */
    public static final long BATCH_SETTLE_LEVEL = 145L;

    /** 批处理条数（结算状态） */
    public static final long BATCH_SETTLE_STATUS = 150L;

    /** 批处理条数（结算金额） */
    public static final long BATCH_SETTLE_AMOUNT = 155L;

    /** 批处理条数（结算数量） */
    public static final long BATCH_SETTLE_COUNT = 160L;

    /** 批处理条数（结算比率） */
    public static final long BATCH_SETTLE_RATE = 165L;

    /** 批处理条数（结算日期） */
    public static final long BATCH_SETTLE_DATE = 170L;

    /** 批处理条数（结算时间） */
    public static final long BATCH_SETTLE_TIME = 175L;

    /** 批处理条数（结算标记） */
    public static final long BATCH_SETTLE_FLAG = 180L;

    /** 批处理条数（结算说明） */
    public static final long BATCH_SETTLE_REMARK = 185L;

    /** 批处理条数（结算来源） */
    public static final long BATCH_SETTLE_SOURCE = 190L;

    /** 批处理条数（结算版本） */
    public static final long BATCH_SETTLE_VERSION = 195L;

    /** 批处理条数（结算区域） */
    public static final long BATCH_SETTLE_REGION = 200L;

    /** 批处理条数（结算渠道） */
    public static final long BATCH_SETTLE_CHANNEL = 205L;

    /** 批处理条数（结算分组） */
    public static final long BATCH_SETTLE_GROUP = 210L;

    /** 批处理条数（结算标签） */
    public static final long BATCH_SETTLE_TAG = 215L;

    /** 批处理条数（结算负责人） */
    public static final long BATCH_SETTLE_OWNER = 220L;

    /** 批处理条数（审计编号） */
    public static final long BATCH_AUDIT_NO = 225L;

    /** 批处理条数（审计名称） */
    public static final long BATCH_AUDIT_NAME = 230L;

    /** 批处理条数（审计类型） */
    public static final long BATCH_AUDIT_TYPE = 235L;

    /** 批处理条数（审计编码） */
    public static final long BATCH_AUDIT_CODE = 240L;

    /** 批处理条数（审计级别） */
    public static final long BATCH_AUDIT_LEVEL = 245L;

    /** 批处理条数（审计状态） */
    public static final long BATCH_AUDIT_STATUS = 250L;

    /** 批处理条数（审计金额） */
    public static final long BATCH_AUDIT_AMOUNT = 255L;

    /** 批处理条数（审计数量） */
    public static final long BATCH_AUDIT_COUNT = 260L;

    /** 批处理条数（审计比率） */
    public static final long BATCH_AUDIT_RATE = 265L;

    /** 批处理条数（审计日期） */
    public static final long BATCH_AUDIT_DATE = 270L;

    /** 批处理条数（审计时间） */
    public static final long BATCH_AUDIT_TIME = 275L;

    /** 批处理条数（审计标记） */
    public static final long BATCH_AUDIT_FLAG = 280L;

    /** 批处理条数（审计说明） */
    public static final long BATCH_AUDIT_REMARK = 285L;

    /** 批处理条数（审计来源） */
    public static final long BATCH_AUDIT_SOURCE = 290L;

    /** 批处理条数（审计版本） */
    public static final long BATCH_AUDIT_VERSION = 295L;

    /** 批处理条数（审计区域） */
    public static final long BATCH_AUDIT_REGION = 300L;

    private CustInvoiceModuleConfig() {
    }

    /** 批处理条数（付款渠道）。 */
    public static long resolveBatchPaymentChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_PAYMENT_CHANNEL;
        }
        if (requested > BATCH_PAYMENT_CHANNEL) {
            return BATCH_PAYMENT_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（付款分组）。 */
    public static long resolveBatchPaymentGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_PAYMENT_GROUP;
        }
        if (requested > BATCH_PAYMENT_GROUP) {
            return BATCH_PAYMENT_GROUP;
        }
        return requested;
    }

    /** 批处理条数（付款标签）。 */
    public static long resolveBatchPaymentTag(long requested) {
        if (requested <= 0L) {
            return BATCH_PAYMENT_TAG;
        }
        if (requested > BATCH_PAYMENT_TAG) {
            return BATCH_PAYMENT_TAG;
        }
        return requested;
    }

    /** 批处理条数（付款负责人）。 */
    public static long resolveBatchPaymentOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_PAYMENT_OWNER;
        }
        if (requested > BATCH_PAYMENT_OWNER) {
            return BATCH_PAYMENT_OWNER;
        }
        return requested;
    }

    /** 批处理条数（发票编号）。 */
    public static long resolveBatchInvoiceNo(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_NO;
        }
        if (requested > BATCH_INVOICE_NO) {
            return BATCH_INVOICE_NO;
        }
        return requested;
    }

    /** 批处理条数（发票名称）。 */
    public static long resolveBatchInvoiceName(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_NAME;
        }
        if (requested > BATCH_INVOICE_NAME) {
            return BATCH_INVOICE_NAME;
        }
        return requested;
    }

    /** 批处理条数（发票类型）。 */
    public static long resolveBatchInvoiceType(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_TYPE;
        }
        if (requested > BATCH_INVOICE_TYPE) {
            return BATCH_INVOICE_TYPE;
        }
        return requested;
    }

    /** 批处理条数（发票编码）。 */
    public static long resolveBatchInvoiceCode(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_CODE;
        }
        if (requested > BATCH_INVOICE_CODE) {
            return BATCH_INVOICE_CODE;
        }
        return requested;
    }

    /** 批处理条数（发票级别）。 */
    public static long resolveBatchInvoiceLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_LEVEL;
        }
        if (requested > BATCH_INVOICE_LEVEL) {
            return BATCH_INVOICE_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（发票状态）。 */
    public static long resolveBatchInvoiceStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_STATUS;
        }
        if (requested > BATCH_INVOICE_STATUS) {
            return BATCH_INVOICE_STATUS;
        }
        return requested;
    }

    /** 批处理条数（发票金额）。 */
    public static long resolveBatchInvoiceAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_AMOUNT;
        }
        if (requested > BATCH_INVOICE_AMOUNT) {
            return BATCH_INVOICE_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（发票数量）。 */
    public static long resolveBatchInvoiceCount(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_COUNT;
        }
        if (requested > BATCH_INVOICE_COUNT) {
            return BATCH_INVOICE_COUNT;
        }
        return requested;
    }

    /** 批处理条数（发票比率）。 */
    public static long resolveBatchInvoiceRate(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_RATE;
        }
        if (requested > BATCH_INVOICE_RATE) {
            return BATCH_INVOICE_RATE;
        }
        return requested;
    }

    /** 批处理条数（发票日期）。 */
    public static long resolveBatchInvoiceDate(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_DATE;
        }
        if (requested > BATCH_INVOICE_DATE) {
            return BATCH_INVOICE_DATE;
        }
        return requested;
    }

    /** 批处理条数（发票时间）。 */
    public static long resolveBatchInvoiceTime(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_TIME;
        }
        if (requested > BATCH_INVOICE_TIME) {
            return BATCH_INVOICE_TIME;
        }
        return requested;
    }

    /** 批处理条数（发票标记）。 */
    public static long resolveBatchInvoiceFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_FLAG;
        }
        if (requested > BATCH_INVOICE_FLAG) {
            return BATCH_INVOICE_FLAG;
        }
        return requested;
    }

    /** 批处理条数（发票说明）。 */
    public static long resolveBatchInvoiceRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_REMARK;
        }
        if (requested > BATCH_INVOICE_REMARK) {
            return BATCH_INVOICE_REMARK;
        }
        return requested;
    }

    /** 批处理条数（发票来源）。 */
    public static long resolveBatchInvoiceSource(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_SOURCE;
        }
        if (requested > BATCH_INVOICE_SOURCE) {
            return BATCH_INVOICE_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（发票版本）。 */
    public static long resolveBatchInvoiceVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_VERSION;
        }
        if (requested > BATCH_INVOICE_VERSION) {
            return BATCH_INVOICE_VERSION;
        }
        return requested;
    }

    /** 批处理条数（发票区域）。 */
    public static long resolveBatchInvoiceRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_REGION;
        }
        if (requested > BATCH_INVOICE_REGION) {
            return BATCH_INVOICE_REGION;
        }
        return requested;
    }

}

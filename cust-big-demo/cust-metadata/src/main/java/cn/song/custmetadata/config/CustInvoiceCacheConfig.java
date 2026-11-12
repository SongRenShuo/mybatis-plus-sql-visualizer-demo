package cn.song.custmetadata.config;

/**
 * 客户发票CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustInvoiceCacheConfig {

    public static final String MODULE_CODE = "CUST_INVOICE_CACHE_CONFIG";

    /** 批处理条数（发票日期） */
    public static final long BATCH_INVOICE_DATE = 5L;

    /** 批处理条数（发票时间） */
    public static final long BATCH_INVOICE_TIME = 10L;

    /** 批处理条数（发票标记） */
    public static final long BATCH_INVOICE_FLAG = 15L;

    /** 批处理条数（发票说明） */
    public static final long BATCH_INVOICE_REMARK = 20L;

    /** 批处理条数（发票来源） */
    public static final long BATCH_INVOICE_SOURCE = 25L;

    /** 批处理条数（发票版本） */
    public static final long BATCH_INVOICE_VERSION = 30L;

    /** 批处理条数（发票区域） */
    public static final long BATCH_INVOICE_REGION = 35L;

    /** 批处理条数（发票渠道） */
    public static final long BATCH_INVOICE_CHANNEL = 40L;

    /** 批处理条数（发票分组） */
    public static final long BATCH_INVOICE_GROUP = 45L;

    /** 批处理条数（发票标签） */
    public static final long BATCH_INVOICE_TAG = 50L;

    /** 批处理条数（发票负责人） */
    public static final long BATCH_INVOICE_OWNER = 55L;

    /** 批处理条数（结算编号） */
    public static final long BATCH_SETTLE_NO = 60L;

    /** 批处理条数（结算名称） */
    public static final long BATCH_SETTLE_NAME = 65L;

    /** 批处理条数（结算类型） */
    public static final long BATCH_SETTLE_TYPE = 70L;

    /** 批处理条数（结算编码） */
    public static final long BATCH_SETTLE_CODE = 75L;

    /** 批处理条数（结算级别） */
    public static final long BATCH_SETTLE_LEVEL = 80L;

    /** 批处理条数（结算状态） */
    public static final long BATCH_SETTLE_STATUS = 85L;

    /** 批处理条数（结算金额） */
    public static final long BATCH_SETTLE_AMOUNT = 90L;

    /** 批处理条数（结算数量） */
    public static final long BATCH_SETTLE_COUNT = 95L;

    /** 批处理条数（结算比率） */
    public static final long BATCH_SETTLE_RATE = 100L;

    /** 批处理条数（结算日期） */
    public static final long BATCH_SETTLE_DATE = 105L;

    /** 批处理条数（结算时间） */
    public static final long BATCH_SETTLE_TIME = 110L;

    /** 批处理条数（结算标记） */
    public static final long BATCH_SETTLE_FLAG = 115L;

    /** 批处理条数（结算说明） */
    public static final long BATCH_SETTLE_REMARK = 120L;

    /** 批处理条数（结算来源） */
    public static final long BATCH_SETTLE_SOURCE = 125L;

    /** 批处理条数（结算版本） */
    public static final long BATCH_SETTLE_VERSION = 130L;

    /** 批处理条数（结算区域） */
    public static final long BATCH_SETTLE_REGION = 135L;

    /** 批处理条数（结算渠道） */
    public static final long BATCH_SETTLE_CHANNEL = 140L;

    /** 批处理条数（结算分组） */
    public static final long BATCH_SETTLE_GROUP = 145L;

    /** 批处理条数（结算标签） */
    public static final long BATCH_SETTLE_TAG = 150L;

    /** 批处理条数（结算负责人） */
    public static final long BATCH_SETTLE_OWNER = 155L;

    /** 批处理条数（审计编号） */
    public static final long BATCH_AUDIT_NO = 160L;

    /** 批处理条数（审计名称） */
    public static final long BATCH_AUDIT_NAME = 165L;

    /** 批处理条数（审计类型） */
    public static final long BATCH_AUDIT_TYPE = 170L;

    /** 批处理条数（审计编码） */
    public static final long BATCH_AUDIT_CODE = 175L;

    /** 批处理条数（审计级别） */
    public static final long BATCH_AUDIT_LEVEL = 180L;

    /** 批处理条数（审计状态） */
    public static final long BATCH_AUDIT_STATUS = 185L;

    /** 批处理条数（审计金额） */
    public static final long BATCH_AUDIT_AMOUNT = 190L;

    /** 批处理条数（审计数量） */
    public static final long BATCH_AUDIT_COUNT = 195L;

    /** 批处理条数（审计比率） */
    public static final long BATCH_AUDIT_RATE = 200L;

    /** 批处理条数（审计日期） */
    public static final long BATCH_AUDIT_DATE = 205L;

    /** 批处理条数（审计时间） */
    public static final long BATCH_AUDIT_TIME = 210L;

    /** 批处理条数（审计标记） */
    public static final long BATCH_AUDIT_FLAG = 215L;

    /** 批处理条数（审计说明） */
    public static final long BATCH_AUDIT_REMARK = 220L;

    /** 批处理条数（审计来源） */
    public static final long BATCH_AUDIT_SOURCE = 225L;

    /** 批处理条数（审计版本） */
    public static final long BATCH_AUDIT_VERSION = 230L;

    /** 批处理条数（审计区域） */
    public static final long BATCH_AUDIT_REGION = 235L;

    /** 批处理条数（审计渠道） */
    public static final long BATCH_AUDIT_CHANNEL = 240L;

    /** 批处理条数（审计分组） */
    public static final long BATCH_AUDIT_GROUP = 245L;

    /** 批处理条数（审计标签） */
    public static final long BATCH_AUDIT_TAG = 250L;

    /** 批处理条数（审计负责人） */
    public static final long BATCH_AUDIT_OWNER = 255L;

    /** 批处理条数（附件编号） */
    public static final long BATCH_ATTACH_NO = 260L;

    /** 批处理条数（附件名称） */
    public static final long BATCH_ATTACH_NAME = 265L;

    /** 批处理条数（附件类型） */
    public static final long BATCH_ATTACH_TYPE = 270L;

    /** 批处理条数（附件编码） */
    public static final long BATCH_ATTACH_CODE = 275L;

    /** 批处理条数（附件级别） */
    public static final long BATCH_ATTACH_LEVEL = 280L;

    /** 批处理条数（附件状态） */
    public static final long BATCH_ATTACH_STATUS = 285L;

    /** 批处理条数（附件金额） */
    public static final long BATCH_ATTACH_AMOUNT = 290L;

    /** 批处理条数（附件数量） */
    public static final long BATCH_ATTACH_COUNT = 295L;

    /** 批处理条数（附件比率） */
    public static final long BATCH_ATTACH_RATE = 300L;

    private CustInvoiceCacheConfig() {
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

    /** 批处理条数（发票渠道）。 */
    public static long resolveBatchInvoiceChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_CHANNEL;
        }
        if (requested > BATCH_INVOICE_CHANNEL) {
            return BATCH_INVOICE_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（发票分组）。 */
    public static long resolveBatchInvoiceGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_GROUP;
        }
        if (requested > BATCH_INVOICE_GROUP) {
            return BATCH_INVOICE_GROUP;
        }
        return requested;
    }

    /** 批处理条数（发票标签）。 */
    public static long resolveBatchInvoiceTag(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_TAG;
        }
        if (requested > BATCH_INVOICE_TAG) {
            return BATCH_INVOICE_TAG;
        }
        return requested;
    }

    /** 批处理条数（发票负责人）。 */
    public static long resolveBatchInvoiceOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_INVOICE_OWNER;
        }
        if (requested > BATCH_INVOICE_OWNER) {
            return BATCH_INVOICE_OWNER;
        }
        return requested;
    }

    /** 批处理条数（结算编号）。 */
    public static long resolveBatchSettleNo(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_NO;
        }
        if (requested > BATCH_SETTLE_NO) {
            return BATCH_SETTLE_NO;
        }
        return requested;
    }

    /** 批处理条数（结算名称）。 */
    public static long resolveBatchSettleName(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_NAME;
        }
        if (requested > BATCH_SETTLE_NAME) {
            return BATCH_SETTLE_NAME;
        }
        return requested;
    }

    /** 批处理条数（结算类型）。 */
    public static long resolveBatchSettleType(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_TYPE;
        }
        if (requested > BATCH_SETTLE_TYPE) {
            return BATCH_SETTLE_TYPE;
        }
        return requested;
    }

    /** 批处理条数（结算编码）。 */
    public static long resolveBatchSettleCode(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_CODE;
        }
        if (requested > BATCH_SETTLE_CODE) {
            return BATCH_SETTLE_CODE;
        }
        return requested;
    }

    /** 批处理条数（结算级别）。 */
    public static long resolveBatchSettleLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_LEVEL;
        }
        if (requested > BATCH_SETTLE_LEVEL) {
            return BATCH_SETTLE_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（结算状态）。 */
    public static long resolveBatchSettleStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_STATUS;
        }
        if (requested > BATCH_SETTLE_STATUS) {
            return BATCH_SETTLE_STATUS;
        }
        return requested;
    }

    /** 批处理条数（结算金额）。 */
    public static long resolveBatchSettleAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_AMOUNT;
        }
        if (requested > BATCH_SETTLE_AMOUNT) {
            return BATCH_SETTLE_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（结算数量）。 */
    public static long resolveBatchSettleCount(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_COUNT;
        }
        if (requested > BATCH_SETTLE_COUNT) {
            return BATCH_SETTLE_COUNT;
        }
        return requested;
    }

    /** 批处理条数（结算比率）。 */
    public static long resolveBatchSettleRate(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_RATE;
        }
        if (requested > BATCH_SETTLE_RATE) {
            return BATCH_SETTLE_RATE;
        }
        return requested;
    }

}

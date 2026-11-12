package cn.song.custmetadata.config;

/**
 * 客户规模JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustScaleJobConfig {

    public static final String MODULE_CODE = "CUST_SCALE_JOB_CONFIG";

    /** 重试次数（发票时间） */
    public static final long RETRY_INVOICE_TIME = 5L;

    /** 重试次数（发票标记） */
    public static final long RETRY_INVOICE_FLAG = 10L;

    /** 重试次数（发票说明） */
    public static final long RETRY_INVOICE_REMARK = 15L;

    /** 重试次数（发票来源） */
    public static final long RETRY_INVOICE_SOURCE = 20L;

    /** 重试次数（发票版本） */
    public static final long RETRY_INVOICE_VERSION = 25L;

    /** 重试次数（发票区域） */
    public static final long RETRY_INVOICE_REGION = 30L;

    /** 重试次数（发票渠道） */
    public static final long RETRY_INVOICE_CHANNEL = 35L;

    /** 重试次数（发票分组） */
    public static final long RETRY_INVOICE_GROUP = 40L;

    /** 重试次数（发票标签） */
    public static final long RETRY_INVOICE_TAG = 45L;

    /** 重试次数（发票负责人） */
    public static final long RETRY_INVOICE_OWNER = 50L;

    /** 重试次数（结算编号） */
    public static final long RETRY_SETTLE_NO = 55L;

    /** 重试次数（结算名称） */
    public static final long RETRY_SETTLE_NAME = 60L;

    /** 重试次数（结算类型） */
    public static final long RETRY_SETTLE_TYPE = 65L;

    /** 重试次数（结算编码） */
    public static final long RETRY_SETTLE_CODE = 70L;

    /** 重试次数（结算级别） */
    public static final long RETRY_SETTLE_LEVEL = 75L;

    /** 重试次数（结算状态） */
    public static final long RETRY_SETTLE_STATUS = 80L;

    /** 重试次数（结算金额） */
    public static final long RETRY_SETTLE_AMOUNT = 85L;

    /** 重试次数（结算数量） */
    public static final long RETRY_SETTLE_COUNT = 90L;

    /** 重试次数（结算比率） */
    public static final long RETRY_SETTLE_RATE = 95L;

    /** 重试次数（结算日期） */
    public static final long RETRY_SETTLE_DATE = 100L;

    /** 重试次数（结算时间） */
    public static final long RETRY_SETTLE_TIME = 105L;

    /** 重试次数（结算标记） */
    public static final long RETRY_SETTLE_FLAG = 110L;

    /** 重试次数（结算说明） */
    public static final long RETRY_SETTLE_REMARK = 115L;

    /** 重试次数（结算来源） */
    public static final long RETRY_SETTLE_SOURCE = 120L;

    /** 重试次数（结算版本） */
    public static final long RETRY_SETTLE_VERSION = 125L;

    /** 重试次数（结算区域） */
    public static final long RETRY_SETTLE_REGION = 130L;

    /** 重试次数（结算渠道） */
    public static final long RETRY_SETTLE_CHANNEL = 135L;

    /** 重试次数（结算分组） */
    public static final long RETRY_SETTLE_GROUP = 140L;

    /** 重试次数（结算标签） */
    public static final long RETRY_SETTLE_TAG = 145L;

    /** 重试次数（结算负责人） */
    public static final long RETRY_SETTLE_OWNER = 150L;

    /** 重试次数（审计编号） */
    public static final long RETRY_AUDIT_NO = 155L;

    /** 重试次数（审计名称） */
    public static final long RETRY_AUDIT_NAME = 160L;

    /** 重试次数（审计类型） */
    public static final long RETRY_AUDIT_TYPE = 165L;

    /** 重试次数（审计编码） */
    public static final long RETRY_AUDIT_CODE = 170L;

    /** 重试次数（审计级别） */
    public static final long RETRY_AUDIT_LEVEL = 175L;

    /** 重试次数（审计状态） */
    public static final long RETRY_AUDIT_STATUS = 180L;

    /** 重试次数（审计金额） */
    public static final long RETRY_AUDIT_AMOUNT = 185L;

    /** 重试次数（审计数量） */
    public static final long RETRY_AUDIT_COUNT = 190L;

    /** 重试次数（审计比率） */
    public static final long RETRY_AUDIT_RATE = 195L;

    /** 重试次数（审计日期） */
    public static final long RETRY_AUDIT_DATE = 200L;

    /** 重试次数（审计时间） */
    public static final long RETRY_AUDIT_TIME = 205L;

    /** 重试次数（审计标记） */
    public static final long RETRY_AUDIT_FLAG = 210L;

    /** 重试次数（审计说明） */
    public static final long RETRY_AUDIT_REMARK = 215L;

    /** 重试次数（审计来源） */
    public static final long RETRY_AUDIT_SOURCE = 220L;

    /** 重试次数（审计版本） */
    public static final long RETRY_AUDIT_VERSION = 225L;

    /** 重试次数（审计区域） */
    public static final long RETRY_AUDIT_REGION = 230L;

    /** 重试次数（审计渠道） */
    public static final long RETRY_AUDIT_CHANNEL = 235L;

    /** 重试次数（审计分组） */
    public static final long RETRY_AUDIT_GROUP = 240L;

    /** 重试次数（审计标签） */
    public static final long RETRY_AUDIT_TAG = 245L;

    /** 重试次数（审计负责人） */
    public static final long RETRY_AUDIT_OWNER = 250L;

    /** 重试次数（附件编号） */
    public static final long RETRY_ATTACH_NO = 255L;

    /** 重试次数（附件名称） */
    public static final long RETRY_ATTACH_NAME = 260L;

    /** 重试次数（附件类型） */
    public static final long RETRY_ATTACH_TYPE = 265L;

    /** 重试次数（附件编码） */
    public static final long RETRY_ATTACH_CODE = 270L;

    /** 重试次数（附件级别） */
    public static final long RETRY_ATTACH_LEVEL = 275L;

    /** 重试次数（附件状态） */
    public static final long RETRY_ATTACH_STATUS = 280L;

    /** 重试次数（附件金额） */
    public static final long RETRY_ATTACH_AMOUNT = 285L;

    /** 重试次数（附件数量） */
    public static final long RETRY_ATTACH_COUNT = 290L;

    /** 重试次数（附件比率） */
    public static final long RETRY_ATTACH_RATE = 295L;

    /** 重试次数（附件日期） */
    public static final long RETRY_ATTACH_DATE = 300L;

    private CustScaleJobConfig() {
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

    /** 重试次数（发票分组）。 */
    public static long resolveRetryInvoiceGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_GROUP;
        }
        if (requested > RETRY_INVOICE_GROUP) {
            return RETRY_INVOICE_GROUP;
        }
        return requested;
    }

    /** 重试次数（发票标签）。 */
    public static long resolveRetryInvoiceTag(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_TAG;
        }
        if (requested > RETRY_INVOICE_TAG) {
            return RETRY_INVOICE_TAG;
        }
        return requested;
    }

    /** 重试次数（发票负责人）。 */
    public static long resolveRetryInvoiceOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_INVOICE_OWNER;
        }
        if (requested > RETRY_INVOICE_OWNER) {
            return RETRY_INVOICE_OWNER;
        }
        return requested;
    }

    /** 重试次数（结算编号）。 */
    public static long resolveRetrySettleNo(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_NO;
        }
        if (requested > RETRY_SETTLE_NO) {
            return RETRY_SETTLE_NO;
        }
        return requested;
    }

    /** 重试次数（结算名称）。 */
    public static long resolveRetrySettleName(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_NAME;
        }
        if (requested > RETRY_SETTLE_NAME) {
            return RETRY_SETTLE_NAME;
        }
        return requested;
    }

    /** 重试次数（结算类型）。 */
    public static long resolveRetrySettleType(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_TYPE;
        }
        if (requested > RETRY_SETTLE_TYPE) {
            return RETRY_SETTLE_TYPE;
        }
        return requested;
    }

    /** 重试次数（结算编码）。 */
    public static long resolveRetrySettleCode(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_CODE;
        }
        if (requested > RETRY_SETTLE_CODE) {
            return RETRY_SETTLE_CODE;
        }
        return requested;
    }

    /** 重试次数（结算级别）。 */
    public static long resolveRetrySettleLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_LEVEL;
        }
        if (requested > RETRY_SETTLE_LEVEL) {
            return RETRY_SETTLE_LEVEL;
        }
        return requested;
    }

    /** 重试次数（结算状态）。 */
    public static long resolveRetrySettleStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_STATUS;
        }
        if (requested > RETRY_SETTLE_STATUS) {
            return RETRY_SETTLE_STATUS;
        }
        return requested;
    }

    /** 重试次数（结算金额）。 */
    public static long resolveRetrySettleAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_AMOUNT;
        }
        if (requested > RETRY_SETTLE_AMOUNT) {
            return RETRY_SETTLE_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（结算数量）。 */
    public static long resolveRetrySettleCount(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_COUNT;
        }
        if (requested > RETRY_SETTLE_COUNT) {
            return RETRY_SETTLE_COUNT;
        }
        return requested;
    }

    /** 重试次数（结算比率）。 */
    public static long resolveRetrySettleRate(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_RATE;
        }
        if (requested > RETRY_SETTLE_RATE) {
            return RETRY_SETTLE_RATE;
        }
        return requested;
    }

    /** 重试次数（结算日期）。 */
    public static long resolveRetrySettleDate(long requested) {
        if (requested <= 0L) {
            return RETRY_SETTLE_DATE;
        }
        if (requested > RETRY_SETTLE_DATE) {
            return RETRY_SETTLE_DATE;
        }
        return requested;
    }

}

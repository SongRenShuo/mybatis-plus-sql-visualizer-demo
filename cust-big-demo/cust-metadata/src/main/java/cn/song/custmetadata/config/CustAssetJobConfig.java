package cn.song.custmetadata.config;

/**
 * 客户资产JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustAssetJobConfig {

    public static final String MODULE_CODE = "CUST_ASSET_JOB_CONFIG";

    /** 超时毫秒数（发票级别） */
    public static final long TIMEOUT_INVOICE_LEVEL = 5L;

    /** 超时毫秒数（发票状态） */
    public static final long TIMEOUT_INVOICE_STATUS = 10L;

    /** 超时毫秒数（发票金额） */
    public static final long TIMEOUT_INVOICE_AMOUNT = 15L;

    /** 超时毫秒数（发票数量） */
    public static final long TIMEOUT_INVOICE_COUNT = 20L;

    /** 超时毫秒数（发票比率） */
    public static final long TIMEOUT_INVOICE_RATE = 25L;

    /** 超时毫秒数（发票日期） */
    public static final long TIMEOUT_INVOICE_DATE = 30L;

    /** 超时毫秒数（发票时间） */
    public static final long TIMEOUT_INVOICE_TIME = 35L;

    /** 超时毫秒数（发票标记） */
    public static final long TIMEOUT_INVOICE_FLAG = 40L;

    /** 超时毫秒数（发票说明） */
    public static final long TIMEOUT_INVOICE_REMARK = 45L;

    /** 超时毫秒数（发票来源） */
    public static final long TIMEOUT_INVOICE_SOURCE = 50L;

    /** 超时毫秒数（发票版本） */
    public static final long TIMEOUT_INVOICE_VERSION = 55L;

    /** 超时毫秒数（发票区域） */
    public static final long TIMEOUT_INVOICE_REGION = 60L;

    /** 超时毫秒数（发票渠道） */
    public static final long TIMEOUT_INVOICE_CHANNEL = 65L;

    /** 超时毫秒数（发票分组） */
    public static final long TIMEOUT_INVOICE_GROUP = 70L;

    /** 超时毫秒数（发票标签） */
    public static final long TIMEOUT_INVOICE_TAG = 75L;

    /** 超时毫秒数（发票负责人） */
    public static final long TIMEOUT_INVOICE_OWNER = 80L;

    /** 超时毫秒数（结算编号） */
    public static final long TIMEOUT_SETTLE_NO = 85L;

    /** 超时毫秒数（结算名称） */
    public static final long TIMEOUT_SETTLE_NAME = 90L;

    /** 超时毫秒数（结算类型） */
    public static final long TIMEOUT_SETTLE_TYPE = 95L;

    /** 超时毫秒数（结算编码） */
    public static final long TIMEOUT_SETTLE_CODE = 100L;

    /** 超时毫秒数（结算级别） */
    public static final long TIMEOUT_SETTLE_LEVEL = 105L;

    /** 超时毫秒数（结算状态） */
    public static final long TIMEOUT_SETTLE_STATUS = 110L;

    /** 超时毫秒数（结算金额） */
    public static final long TIMEOUT_SETTLE_AMOUNT = 115L;

    /** 超时毫秒数（结算数量） */
    public static final long TIMEOUT_SETTLE_COUNT = 120L;

    /** 超时毫秒数（结算比率） */
    public static final long TIMEOUT_SETTLE_RATE = 125L;

    /** 超时毫秒数（结算日期） */
    public static final long TIMEOUT_SETTLE_DATE = 130L;

    /** 超时毫秒数（结算时间） */
    public static final long TIMEOUT_SETTLE_TIME = 135L;

    /** 超时毫秒数（结算标记） */
    public static final long TIMEOUT_SETTLE_FLAG = 140L;

    /** 超时毫秒数（结算说明） */
    public static final long TIMEOUT_SETTLE_REMARK = 145L;

    /** 超时毫秒数（结算来源） */
    public static final long TIMEOUT_SETTLE_SOURCE = 150L;

    /** 超时毫秒数（结算版本） */
    public static final long TIMEOUT_SETTLE_VERSION = 155L;

    /** 超时毫秒数（结算区域） */
    public static final long TIMEOUT_SETTLE_REGION = 160L;

    /** 超时毫秒数（结算渠道） */
    public static final long TIMEOUT_SETTLE_CHANNEL = 165L;

    /** 超时毫秒数（结算分组） */
    public static final long TIMEOUT_SETTLE_GROUP = 170L;

    /** 超时毫秒数（结算标签） */
    public static final long TIMEOUT_SETTLE_TAG = 175L;

    /** 超时毫秒数（结算负责人） */
    public static final long TIMEOUT_SETTLE_OWNER = 180L;

    /** 超时毫秒数（审计编号） */
    public static final long TIMEOUT_AUDIT_NO = 185L;

    /** 超时毫秒数（审计名称） */
    public static final long TIMEOUT_AUDIT_NAME = 190L;

    /** 超时毫秒数（审计类型） */
    public static final long TIMEOUT_AUDIT_TYPE = 195L;

    /** 超时毫秒数（审计编码） */
    public static final long TIMEOUT_AUDIT_CODE = 200L;

    /** 超时毫秒数（审计级别） */
    public static final long TIMEOUT_AUDIT_LEVEL = 205L;

    /** 超时毫秒数（审计状态） */
    public static final long TIMEOUT_AUDIT_STATUS = 210L;

    /** 超时毫秒数（审计金额） */
    public static final long TIMEOUT_AUDIT_AMOUNT = 215L;

    /** 超时毫秒数（审计数量） */
    public static final long TIMEOUT_AUDIT_COUNT = 220L;

    /** 超时毫秒数（审计比率） */
    public static final long TIMEOUT_AUDIT_RATE = 225L;

    /** 超时毫秒数（审计日期） */
    public static final long TIMEOUT_AUDIT_DATE = 230L;

    /** 超时毫秒数（审计时间） */
    public static final long TIMEOUT_AUDIT_TIME = 235L;

    /** 超时毫秒数（审计标记） */
    public static final long TIMEOUT_AUDIT_FLAG = 240L;

    /** 超时毫秒数（审计说明） */
    public static final long TIMEOUT_AUDIT_REMARK = 245L;

    /** 超时毫秒数（审计来源） */
    public static final long TIMEOUT_AUDIT_SOURCE = 250L;

    /** 超时毫秒数（审计版本） */
    public static final long TIMEOUT_AUDIT_VERSION = 255L;

    /** 超时毫秒数（审计区域） */
    public static final long TIMEOUT_AUDIT_REGION = 260L;

    /** 超时毫秒数（审计渠道） */
    public static final long TIMEOUT_AUDIT_CHANNEL = 265L;

    /** 超时毫秒数（审计分组） */
    public static final long TIMEOUT_AUDIT_GROUP = 270L;

    /** 超时毫秒数（审计标签） */
    public static final long TIMEOUT_AUDIT_TAG = 275L;

    /** 超时毫秒数（审计负责人） */
    public static final long TIMEOUT_AUDIT_OWNER = 280L;

    /** 超时毫秒数（附件编号） */
    public static final long TIMEOUT_ATTACH_NO = 285L;

    /** 超时毫秒数（附件名称） */
    public static final long TIMEOUT_ATTACH_NAME = 290L;

    /** 超时毫秒数（附件类型） */
    public static final long TIMEOUT_ATTACH_TYPE = 295L;

    /** 超时毫秒数（附件编码） */
    public static final long TIMEOUT_ATTACH_CODE = 300L;

    private CustAssetJobConfig() {
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

    /** 超时毫秒数（发票标记）。 */
    public static long resolveTimeoutInvoiceFlag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_FLAG;
        }
        if (requested > TIMEOUT_INVOICE_FLAG) {
            return TIMEOUT_INVOICE_FLAG;
        }
        return requested;
    }

    /** 超时毫秒数（发票说明）。 */
    public static long resolveTimeoutInvoiceRemark(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_REMARK;
        }
        if (requested > TIMEOUT_INVOICE_REMARK) {
            return TIMEOUT_INVOICE_REMARK;
        }
        return requested;
    }

    /** 超时毫秒数（发票来源）。 */
    public static long resolveTimeoutInvoiceSource(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_SOURCE;
        }
        if (requested > TIMEOUT_INVOICE_SOURCE) {
            return TIMEOUT_INVOICE_SOURCE;
        }
        return requested;
    }

    /** 超时毫秒数（发票版本）。 */
    public static long resolveTimeoutInvoiceVersion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_VERSION;
        }
        if (requested > TIMEOUT_INVOICE_VERSION) {
            return TIMEOUT_INVOICE_VERSION;
        }
        return requested;
    }

    /** 超时毫秒数（发票区域）。 */
    public static long resolveTimeoutInvoiceRegion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_REGION;
        }
        if (requested > TIMEOUT_INVOICE_REGION) {
            return TIMEOUT_INVOICE_REGION;
        }
        return requested;
    }

    /** 超时毫秒数（发票渠道）。 */
    public static long resolveTimeoutInvoiceChannel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_CHANNEL;
        }
        if (requested > TIMEOUT_INVOICE_CHANNEL) {
            return TIMEOUT_INVOICE_CHANNEL;
        }
        return requested;
    }

    /** 超时毫秒数（发票分组）。 */
    public static long resolveTimeoutInvoiceGroup(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_GROUP;
        }
        if (requested > TIMEOUT_INVOICE_GROUP) {
            return TIMEOUT_INVOICE_GROUP;
        }
        return requested;
    }

    /** 超时毫秒数（发票标签）。 */
    public static long resolveTimeoutInvoiceTag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_TAG;
        }
        if (requested > TIMEOUT_INVOICE_TAG) {
            return TIMEOUT_INVOICE_TAG;
        }
        return requested;
    }

    /** 超时毫秒数（发票负责人）。 */
    public static long resolveTimeoutInvoiceOwner(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_INVOICE_OWNER;
        }
        if (requested > TIMEOUT_INVOICE_OWNER) {
            return TIMEOUT_INVOICE_OWNER;
        }
        return requested;
    }

    /** 超时毫秒数（结算编号）。 */
    public static long resolveTimeoutSettleNo(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SETTLE_NO;
        }
        if (requested > TIMEOUT_SETTLE_NO) {
            return TIMEOUT_SETTLE_NO;
        }
        return requested;
    }

    /** 超时毫秒数（结算名称）。 */
    public static long resolveTimeoutSettleName(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SETTLE_NAME;
        }
        if (requested > TIMEOUT_SETTLE_NAME) {
            return TIMEOUT_SETTLE_NAME;
        }
        return requested;
    }

    /** 超时毫秒数（结算类型）。 */
    public static long resolveTimeoutSettleType(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SETTLE_TYPE;
        }
        if (requested > TIMEOUT_SETTLE_TYPE) {
            return TIMEOUT_SETTLE_TYPE;
        }
        return requested;
    }

    /** 超时毫秒数（结算编码）。 */
    public static long resolveTimeoutSettleCode(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_SETTLE_CODE;
        }
        if (requested > TIMEOUT_SETTLE_CODE) {
            return TIMEOUT_SETTLE_CODE;
        }
        return requested;
    }

}

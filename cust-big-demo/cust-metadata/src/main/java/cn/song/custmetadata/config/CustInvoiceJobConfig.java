package cn.song.custmetadata.config;

/**
 * 客户发票JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustInvoiceJobConfig {

    public static final String MODULE_CODE = "CUST_INVOICE_JOB_CONFIG";

    /** 批处理条数（结算类型） */
    public static final long BATCH_SETTLE_TYPE = 5L;

    /** 批处理条数（结算编码） */
    public static final long BATCH_SETTLE_CODE = 10L;

    /** 批处理条数（结算级别） */
    public static final long BATCH_SETTLE_LEVEL = 15L;

    /** 批处理条数（结算状态） */
    public static final long BATCH_SETTLE_STATUS = 20L;

    /** 批处理条数（结算金额） */
    public static final long BATCH_SETTLE_AMOUNT = 25L;

    /** 批处理条数（结算数量） */
    public static final long BATCH_SETTLE_COUNT = 30L;

    /** 批处理条数（结算比率） */
    public static final long BATCH_SETTLE_RATE = 35L;

    /** 批处理条数（结算日期） */
    public static final long BATCH_SETTLE_DATE = 40L;

    /** 批处理条数（结算时间） */
    public static final long BATCH_SETTLE_TIME = 45L;

    /** 批处理条数（结算标记） */
    public static final long BATCH_SETTLE_FLAG = 50L;

    /** 批处理条数（结算说明） */
    public static final long BATCH_SETTLE_REMARK = 55L;

    /** 批处理条数（结算来源） */
    public static final long BATCH_SETTLE_SOURCE = 60L;

    /** 批处理条数（结算版本） */
    public static final long BATCH_SETTLE_VERSION = 65L;

    /** 批处理条数（结算区域） */
    public static final long BATCH_SETTLE_REGION = 70L;

    /** 批处理条数（结算渠道） */
    public static final long BATCH_SETTLE_CHANNEL = 75L;

    /** 批处理条数（结算分组） */
    public static final long BATCH_SETTLE_GROUP = 80L;

    /** 批处理条数（结算标签） */
    public static final long BATCH_SETTLE_TAG = 85L;

    /** 批处理条数（结算负责人） */
    public static final long BATCH_SETTLE_OWNER = 90L;

    /** 批处理条数（审计编号） */
    public static final long BATCH_AUDIT_NO = 95L;

    /** 批处理条数（审计名称） */
    public static final long BATCH_AUDIT_NAME = 100L;

    /** 批处理条数（审计类型） */
    public static final long BATCH_AUDIT_TYPE = 105L;

    /** 批处理条数（审计编码） */
    public static final long BATCH_AUDIT_CODE = 110L;

    /** 批处理条数（审计级别） */
    public static final long BATCH_AUDIT_LEVEL = 115L;

    /** 批处理条数（审计状态） */
    public static final long BATCH_AUDIT_STATUS = 120L;

    /** 批处理条数（审计金额） */
    public static final long BATCH_AUDIT_AMOUNT = 125L;

    /** 批处理条数（审计数量） */
    public static final long BATCH_AUDIT_COUNT = 130L;

    /** 批处理条数（审计比率） */
    public static final long BATCH_AUDIT_RATE = 135L;

    /** 批处理条数（审计日期） */
    public static final long BATCH_AUDIT_DATE = 140L;

    /** 批处理条数（审计时间） */
    public static final long BATCH_AUDIT_TIME = 145L;

    /** 批处理条数（审计标记） */
    public static final long BATCH_AUDIT_FLAG = 150L;

    /** 批处理条数（审计说明） */
    public static final long BATCH_AUDIT_REMARK = 155L;

    /** 批处理条数（审计来源） */
    public static final long BATCH_AUDIT_SOURCE = 160L;

    /** 批处理条数（审计版本） */
    public static final long BATCH_AUDIT_VERSION = 165L;

    /** 批处理条数（审计区域） */
    public static final long BATCH_AUDIT_REGION = 170L;

    /** 批处理条数（审计渠道） */
    public static final long BATCH_AUDIT_CHANNEL = 175L;

    /** 批处理条数（审计分组） */
    public static final long BATCH_AUDIT_GROUP = 180L;

    /** 批处理条数（审计标签） */
    public static final long BATCH_AUDIT_TAG = 185L;

    /** 批处理条数（审计负责人） */
    public static final long BATCH_AUDIT_OWNER = 190L;

    /** 批处理条数（附件编号） */
    public static final long BATCH_ATTACH_NO = 195L;

    /** 批处理条数（附件名称） */
    public static final long BATCH_ATTACH_NAME = 200L;

    /** 批处理条数（附件类型） */
    public static final long BATCH_ATTACH_TYPE = 205L;

    /** 批处理条数（附件编码） */
    public static final long BATCH_ATTACH_CODE = 210L;

    /** 批处理条数（附件级别） */
    public static final long BATCH_ATTACH_LEVEL = 215L;

    /** 批处理条数（附件状态） */
    public static final long BATCH_ATTACH_STATUS = 220L;

    /** 批处理条数（附件金额） */
    public static final long BATCH_ATTACH_AMOUNT = 225L;

    /** 批处理条数（附件数量） */
    public static final long BATCH_ATTACH_COUNT = 230L;

    /** 批处理条数（附件比率） */
    public static final long BATCH_ATTACH_RATE = 235L;

    /** 批处理条数（附件日期） */
    public static final long BATCH_ATTACH_DATE = 240L;

    /** 批处理条数（附件时间） */
    public static final long BATCH_ATTACH_TIME = 245L;

    /** 批处理条数（附件标记） */
    public static final long BATCH_ATTACH_FLAG = 250L;

    /** 批处理条数（附件说明） */
    public static final long BATCH_ATTACH_REMARK = 255L;

    /** 批处理条数（附件来源） */
    public static final long BATCH_ATTACH_SOURCE = 260L;

    /** 批处理条数（附件版本） */
    public static final long BATCH_ATTACH_VERSION = 265L;

    /** 批处理条数（附件区域） */
    public static final long BATCH_ATTACH_REGION = 270L;

    /** 批处理条数（附件渠道） */
    public static final long BATCH_ATTACH_CHANNEL = 275L;

    /** 批处理条数（附件分组） */
    public static final long BATCH_ATTACH_GROUP = 280L;

    /** 批处理条数（附件标签） */
    public static final long BATCH_ATTACH_TAG = 285L;

    /** 批处理条数（附件负责人） */
    public static final long BATCH_ATTACH_OWNER = 290L;

    /** 批处理条数（备注编号） */
    public static final long BATCH_NOTE_NO = 295L;

    /** 批处理条数（备注名称） */
    public static final long BATCH_NOTE_NAME = 300L;

    private CustInvoiceJobConfig() {
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

    /** 批处理条数（结算日期）。 */
    public static long resolveBatchSettleDate(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_DATE;
        }
        if (requested > BATCH_SETTLE_DATE) {
            return BATCH_SETTLE_DATE;
        }
        return requested;
    }

    /** 批处理条数（结算时间）。 */
    public static long resolveBatchSettleTime(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_TIME;
        }
        if (requested > BATCH_SETTLE_TIME) {
            return BATCH_SETTLE_TIME;
        }
        return requested;
    }

    /** 批处理条数（结算标记）。 */
    public static long resolveBatchSettleFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_FLAG;
        }
        if (requested > BATCH_SETTLE_FLAG) {
            return BATCH_SETTLE_FLAG;
        }
        return requested;
    }

    /** 批处理条数（结算说明）。 */
    public static long resolveBatchSettleRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_REMARK;
        }
        if (requested > BATCH_SETTLE_REMARK) {
            return BATCH_SETTLE_REMARK;
        }
        return requested;
    }

    /** 批处理条数（结算来源）。 */
    public static long resolveBatchSettleSource(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_SOURCE;
        }
        if (requested > BATCH_SETTLE_SOURCE) {
            return BATCH_SETTLE_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（结算版本）。 */
    public static long resolveBatchSettleVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_VERSION;
        }
        if (requested > BATCH_SETTLE_VERSION) {
            return BATCH_SETTLE_VERSION;
        }
        return requested;
    }

    /** 批处理条数（结算区域）。 */
    public static long resolveBatchSettleRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_REGION;
        }
        if (requested > BATCH_SETTLE_REGION) {
            return BATCH_SETTLE_REGION;
        }
        return requested;
    }

    /** 批处理条数（结算渠道）。 */
    public static long resolveBatchSettleChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_CHANNEL;
        }
        if (requested > BATCH_SETTLE_CHANNEL) {
            return BATCH_SETTLE_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（结算分组）。 */
    public static long resolveBatchSettleGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_GROUP;
        }
        if (requested > BATCH_SETTLE_GROUP) {
            return BATCH_SETTLE_GROUP;
        }
        return requested;
    }

    /** 批处理条数（结算标签）。 */
    public static long resolveBatchSettleTag(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_TAG;
        }
        if (requested > BATCH_SETTLE_TAG) {
            return BATCH_SETTLE_TAG;
        }
        return requested;
    }

    /** 批处理条数（结算负责人）。 */
    public static long resolveBatchSettleOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_SETTLE_OWNER;
        }
        if (requested > BATCH_SETTLE_OWNER) {
            return BATCH_SETTLE_OWNER;
        }
        return requested;
    }

    /** 批处理条数（审计编号）。 */
    public static long resolveBatchAuditNo(long requested) {
        if (requested <= 0L) {
            return BATCH_AUDIT_NO;
        }
        if (requested > BATCH_AUDIT_NO) {
            return BATCH_AUDIT_NO;
        }
        return requested;
    }

    /** 批处理条数（审计名称）。 */
    public static long resolveBatchAuditName(long requested) {
        if (requested <= 0L) {
            return BATCH_AUDIT_NAME;
        }
        if (requested > BATCH_AUDIT_NAME) {
            return BATCH_AUDIT_NAME;
        }
        return requested;
    }

}

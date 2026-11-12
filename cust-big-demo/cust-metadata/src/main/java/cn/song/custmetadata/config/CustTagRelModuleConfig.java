package cn.song.custmetadata.config;

/**
 * 客户标签关系ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustTagRelModuleConfig {

    public static final String MODULE_CODE = "CUST_TAG_REL";

    /** 单次查询上限（结算时间） */
    public static final long LIMIT_SETTLE_TIME = 5L;

    /** 单次查询上限（结算标记） */
    public static final long LIMIT_SETTLE_FLAG = 10L;

    /** 单次查询上限（结算说明） */
    public static final long LIMIT_SETTLE_REMARK = 15L;

    /** 单次查询上限（结算来源） */
    public static final long LIMIT_SETTLE_SOURCE = 20L;

    /** 单次查询上限（结算版本） */
    public static final long LIMIT_SETTLE_VERSION = 25L;

    /** 单次查询上限（结算区域） */
    public static final long LIMIT_SETTLE_REGION = 30L;

    /** 单次查询上限（结算渠道） */
    public static final long LIMIT_SETTLE_CHANNEL = 35L;

    /** 单次查询上限（结算分组） */
    public static final long LIMIT_SETTLE_GROUP = 40L;

    /** 单次查询上限（结算标签） */
    public static final long LIMIT_SETTLE_TAG = 45L;

    /** 单次查询上限（结算负责人） */
    public static final long LIMIT_SETTLE_OWNER = 50L;

    /** 单次查询上限（审计编号） */
    public static final long LIMIT_AUDIT_NO = 55L;

    /** 单次查询上限（审计名称） */
    public static final long LIMIT_AUDIT_NAME = 60L;

    /** 单次查询上限（审计类型） */
    public static final long LIMIT_AUDIT_TYPE = 65L;

    /** 单次查询上限（审计编码） */
    public static final long LIMIT_AUDIT_CODE = 70L;

    /** 单次查询上限（审计级别） */
    public static final long LIMIT_AUDIT_LEVEL = 75L;

    /** 单次查询上限（审计状态） */
    public static final long LIMIT_AUDIT_STATUS = 80L;

    /** 单次查询上限（审计金额） */
    public static final long LIMIT_AUDIT_AMOUNT = 85L;

    /** 单次查询上限（审计数量） */
    public static final long LIMIT_AUDIT_COUNT = 90L;

    /** 单次查询上限（审计比率） */
    public static final long LIMIT_AUDIT_RATE = 95L;

    /** 单次查询上限（审计日期） */
    public static final long LIMIT_AUDIT_DATE = 100L;

    /** 单次查询上限（审计时间） */
    public static final long LIMIT_AUDIT_TIME = 105L;

    /** 单次查询上限（审计标记） */
    public static final long LIMIT_AUDIT_FLAG = 110L;

    /** 单次查询上限（审计说明） */
    public static final long LIMIT_AUDIT_REMARK = 115L;

    /** 单次查询上限（审计来源） */
    public static final long LIMIT_AUDIT_SOURCE = 120L;

    /** 单次查询上限（审计版本） */
    public static final long LIMIT_AUDIT_VERSION = 125L;

    /** 单次查询上限（审计区域） */
    public static final long LIMIT_AUDIT_REGION = 130L;

    /** 单次查询上限（审计渠道） */
    public static final long LIMIT_AUDIT_CHANNEL = 135L;

    /** 单次查询上限（审计分组） */
    public static final long LIMIT_AUDIT_GROUP = 140L;

    /** 单次查询上限（审计标签） */
    public static final long LIMIT_AUDIT_TAG = 145L;

    /** 单次查询上限（审计负责人） */
    public static final long LIMIT_AUDIT_OWNER = 150L;

    /** 单次查询上限（附件编号） */
    public static final long LIMIT_ATTACH_NO = 155L;

    /** 单次查询上限（附件名称） */
    public static final long LIMIT_ATTACH_NAME = 160L;

    /** 单次查询上限（附件类型） */
    public static final long LIMIT_ATTACH_TYPE = 165L;

    /** 单次查询上限（附件编码） */
    public static final long LIMIT_ATTACH_CODE = 170L;

    /** 单次查询上限（附件级别） */
    public static final long LIMIT_ATTACH_LEVEL = 175L;

    /** 单次查询上限（附件状态） */
    public static final long LIMIT_ATTACH_STATUS = 180L;

    /** 单次查询上限（附件金额） */
    public static final long LIMIT_ATTACH_AMOUNT = 185L;

    /** 单次查询上限（附件数量） */
    public static final long LIMIT_ATTACH_COUNT = 190L;

    /** 单次查询上限（附件比率） */
    public static final long LIMIT_ATTACH_RATE = 195L;

    /** 单次查询上限（附件日期） */
    public static final long LIMIT_ATTACH_DATE = 200L;

    /** 单次查询上限（附件时间） */
    public static final long LIMIT_ATTACH_TIME = 205L;

    /** 单次查询上限（附件标记） */
    public static final long LIMIT_ATTACH_FLAG = 210L;

    /** 单次查询上限（附件说明） */
    public static final long LIMIT_ATTACH_REMARK = 215L;

    /** 单次查询上限（附件来源） */
    public static final long LIMIT_ATTACH_SOURCE = 220L;

    /** 单次查询上限（附件版本） */
    public static final long LIMIT_ATTACH_VERSION = 225L;

    /** 单次查询上限（附件区域） */
    public static final long LIMIT_ATTACH_REGION = 230L;

    /** 单次查询上限（附件渠道） */
    public static final long LIMIT_ATTACH_CHANNEL = 235L;

    /** 单次查询上限（附件分组） */
    public static final long LIMIT_ATTACH_GROUP = 240L;

    /** 单次查询上限（附件标签） */
    public static final long LIMIT_ATTACH_TAG = 245L;

    /** 单次查询上限（附件负责人） */
    public static final long LIMIT_ATTACH_OWNER = 250L;

    /** 单次查询上限（备注编号） */
    public static final long LIMIT_NOTE_NO = 255L;

    /** 单次查询上限（备注名称） */
    public static final long LIMIT_NOTE_NAME = 260L;

    /** 单次查询上限（备注类型） */
    public static final long LIMIT_NOTE_TYPE = 265L;

    /** 单次查询上限（备注编码） */
    public static final long LIMIT_NOTE_CODE = 270L;

    /** 单次查询上限（备注级别） */
    public static final long LIMIT_NOTE_LEVEL = 275L;

    /** 单次查询上限（备注状态） */
    public static final long LIMIT_NOTE_STATUS = 280L;

    /** 单次查询上限（备注金额） */
    public static final long LIMIT_NOTE_AMOUNT = 285L;

    /** 单次查询上限（备注数量） */
    public static final long LIMIT_NOTE_COUNT = 290L;

    /** 单次查询上限（备注比率） */
    public static final long LIMIT_NOTE_RATE = 295L;

    /** 单次查询上限（备注日期） */
    public static final long LIMIT_NOTE_DATE = 300L;

    private CustTagRelModuleConfig() {
    }

    /** 单次查询上限（结算时间）。 */
    public static long resolveLimitSettleTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_TIME;
        }
        if (requested > LIMIT_SETTLE_TIME) {
            return LIMIT_SETTLE_TIME;
        }
        return requested;
    }

    /** 单次查询上限（结算标记）。 */
    public static long resolveLimitSettleFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_FLAG;
        }
        if (requested > LIMIT_SETTLE_FLAG) {
            return LIMIT_SETTLE_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（结算说明）。 */
    public static long resolveLimitSettleRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_REMARK;
        }
        if (requested > LIMIT_SETTLE_REMARK) {
            return LIMIT_SETTLE_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（结算来源）。 */
    public static long resolveLimitSettleSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_SOURCE;
        }
        if (requested > LIMIT_SETTLE_SOURCE) {
            return LIMIT_SETTLE_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（结算版本）。 */
    public static long resolveLimitSettleVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_VERSION;
        }
        if (requested > LIMIT_SETTLE_VERSION) {
            return LIMIT_SETTLE_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（结算区域）。 */
    public static long resolveLimitSettleRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_REGION;
        }
        if (requested > LIMIT_SETTLE_REGION) {
            return LIMIT_SETTLE_REGION;
        }
        return requested;
    }

    /** 单次查询上限（结算渠道）。 */
    public static long resolveLimitSettleChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_CHANNEL;
        }
        if (requested > LIMIT_SETTLE_CHANNEL) {
            return LIMIT_SETTLE_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（结算分组）。 */
    public static long resolveLimitSettleGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_GROUP;
        }
        if (requested > LIMIT_SETTLE_GROUP) {
            return LIMIT_SETTLE_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（结算标签）。 */
    public static long resolveLimitSettleTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_TAG;
        }
        if (requested > LIMIT_SETTLE_TAG) {
            return LIMIT_SETTLE_TAG;
        }
        return requested;
    }

    /** 单次查询上限（结算负责人）。 */
    public static long resolveLimitSettleOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_SETTLE_OWNER;
        }
        if (requested > LIMIT_SETTLE_OWNER) {
            return LIMIT_SETTLE_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（审计编号）。 */
    public static long resolveLimitAuditNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_NO;
        }
        if (requested > LIMIT_AUDIT_NO) {
            return LIMIT_AUDIT_NO;
        }
        return requested;
    }

    /** 单次查询上限（审计名称）。 */
    public static long resolveLimitAuditName(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_NAME;
        }
        if (requested > LIMIT_AUDIT_NAME) {
            return LIMIT_AUDIT_NAME;
        }
        return requested;
    }

    /** 单次查询上限（审计类型）。 */
    public static long resolveLimitAuditType(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_TYPE;
        }
        if (requested > LIMIT_AUDIT_TYPE) {
            return LIMIT_AUDIT_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（审计编码）。 */
    public static long resolveLimitAuditCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_CODE;
        }
        if (requested > LIMIT_AUDIT_CODE) {
            return LIMIT_AUDIT_CODE;
        }
        return requested;
    }

    /** 单次查询上限（审计级别）。 */
    public static long resolveLimitAuditLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_LEVEL;
        }
        if (requested > LIMIT_AUDIT_LEVEL) {
            return LIMIT_AUDIT_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（审计状态）。 */
    public static long resolveLimitAuditStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_STATUS;
        }
        if (requested > LIMIT_AUDIT_STATUS) {
            return LIMIT_AUDIT_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（审计金额）。 */
    public static long resolveLimitAuditAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_AMOUNT;
        }
        if (requested > LIMIT_AUDIT_AMOUNT) {
            return LIMIT_AUDIT_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（审计数量）。 */
    public static long resolveLimitAuditCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_COUNT;
        }
        if (requested > LIMIT_AUDIT_COUNT) {
            return LIMIT_AUDIT_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（审计比率）。 */
    public static long resolveLimitAuditRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_RATE;
        }
        if (requested > LIMIT_AUDIT_RATE) {
            return LIMIT_AUDIT_RATE;
        }
        return requested;
    }

    /** 单次查询上限（审计日期）。 */
    public static long resolveLimitAuditDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_DATE;
        }
        if (requested > LIMIT_AUDIT_DATE) {
            return LIMIT_AUDIT_DATE;
        }
        return requested;
    }

}

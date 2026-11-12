package cn.song.custmetadata.config;

/**
 * 客户结算ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustSettlementModuleConfig {

    public static final String MODULE_CODE = "CUST_SETTLEMENT";

    /** 批处理条数（审计版本） */
    public static final long BATCH_AUDIT_VERSION = 5L;

    /** 批处理条数（审计区域） */
    public static final long BATCH_AUDIT_REGION = 10L;

    /** 批处理条数（审计渠道） */
    public static final long BATCH_AUDIT_CHANNEL = 15L;

    /** 批处理条数（审计分组） */
    public static final long BATCH_AUDIT_GROUP = 20L;

    /** 批处理条数（审计标签） */
    public static final long BATCH_AUDIT_TAG = 25L;

    /** 批处理条数（审计负责人） */
    public static final long BATCH_AUDIT_OWNER = 30L;

    /** 批处理条数（附件编号） */
    public static final long BATCH_ATTACH_NO = 35L;

    /** 批处理条数（附件名称） */
    public static final long BATCH_ATTACH_NAME = 40L;

    /** 批处理条数（附件类型） */
    public static final long BATCH_ATTACH_TYPE = 45L;

    /** 批处理条数（附件编码） */
    public static final long BATCH_ATTACH_CODE = 50L;

    /** 批处理条数（附件级别） */
    public static final long BATCH_ATTACH_LEVEL = 55L;

    /** 批处理条数（附件状态） */
    public static final long BATCH_ATTACH_STATUS = 60L;

    /** 批处理条数（附件金额） */
    public static final long BATCH_ATTACH_AMOUNT = 65L;

    /** 批处理条数（附件数量） */
    public static final long BATCH_ATTACH_COUNT = 70L;

    /** 批处理条数（附件比率） */
    public static final long BATCH_ATTACH_RATE = 75L;

    /** 批处理条数（附件日期） */
    public static final long BATCH_ATTACH_DATE = 80L;

    /** 批处理条数（附件时间） */
    public static final long BATCH_ATTACH_TIME = 85L;

    /** 批处理条数（附件标记） */
    public static final long BATCH_ATTACH_FLAG = 90L;

    /** 批处理条数（附件说明） */
    public static final long BATCH_ATTACH_REMARK = 95L;

    /** 批处理条数（附件来源） */
    public static final long BATCH_ATTACH_SOURCE = 100L;

    /** 批处理条数（附件版本） */
    public static final long BATCH_ATTACH_VERSION = 105L;

    /** 批处理条数（附件区域） */
    public static final long BATCH_ATTACH_REGION = 110L;

    /** 批处理条数（附件渠道） */
    public static final long BATCH_ATTACH_CHANNEL = 115L;

    /** 批处理条数（附件分组） */
    public static final long BATCH_ATTACH_GROUP = 120L;

    /** 批处理条数（附件标签） */
    public static final long BATCH_ATTACH_TAG = 125L;

    /** 批处理条数（附件负责人） */
    public static final long BATCH_ATTACH_OWNER = 130L;

    /** 批处理条数（备注编号） */
    public static final long BATCH_NOTE_NO = 135L;

    /** 批处理条数（备注名称） */
    public static final long BATCH_NOTE_NAME = 140L;

    /** 批处理条数（备注类型） */
    public static final long BATCH_NOTE_TYPE = 145L;

    /** 批处理条数（备注编码） */
    public static final long BATCH_NOTE_CODE = 150L;

    /** 批处理条数（备注级别） */
    public static final long BATCH_NOTE_LEVEL = 155L;

    /** 批处理条数（备注状态） */
    public static final long BATCH_NOTE_STATUS = 160L;

    /** 批处理条数（备注金额） */
    public static final long BATCH_NOTE_AMOUNT = 165L;

    /** 批处理条数（备注数量） */
    public static final long BATCH_NOTE_COUNT = 170L;

    /** 批处理条数（备注比率） */
    public static final long BATCH_NOTE_RATE = 175L;

    /** 批处理条数（备注日期） */
    public static final long BATCH_NOTE_DATE = 180L;

    /** 批处理条数（备注时间） */
    public static final long BATCH_NOTE_TIME = 185L;

    /** 批处理条数（备注标记） */
    public static final long BATCH_NOTE_FLAG = 190L;

    /** 批处理条数（备注说明） */
    public static final long BATCH_NOTE_REMARK = 195L;

    /** 批处理条数（备注来源） */
    public static final long BATCH_NOTE_SOURCE = 200L;

    /** 批处理条数（备注版本） */
    public static final long BATCH_NOTE_VERSION = 205L;

    /** 批处理条数（备注区域） */
    public static final long BATCH_NOTE_REGION = 210L;

    /** 批处理条数（备注渠道） */
    public static final long BATCH_NOTE_CHANNEL = 215L;

    /** 批处理条数（备注分组） */
    public static final long BATCH_NOTE_GROUP = 220L;

    /** 批处理条数（备注标签） */
    public static final long BATCH_NOTE_TAG = 225L;

    /** 批处理条数（备注负责人） */
    public static final long BATCH_NOTE_OWNER = 230L;

    /** 批处理条数（偏好编号） */
    public static final long BATCH_PREFER_NO = 235L;

    /** 批处理条数（偏好名称） */
    public static final long BATCH_PREFER_NAME = 240L;

    /** 批处理条数（偏好类型） */
    public static final long BATCH_PREFER_TYPE = 245L;

    /** 批处理条数（偏好编码） */
    public static final long BATCH_PREFER_CODE = 250L;

    /** 批处理条数（偏好级别） */
    public static final long BATCH_PREFER_LEVEL = 255L;

    /** 批处理条数（偏好状态） */
    public static final long BATCH_PREFER_STATUS = 260L;

    /** 批处理条数（偏好金额） */
    public static final long BATCH_PREFER_AMOUNT = 265L;

    /** 批处理条数（偏好数量） */
    public static final long BATCH_PREFER_COUNT = 270L;

    /** 批处理条数（偏好比率） */
    public static final long BATCH_PREFER_RATE = 275L;

    /** 批处理条数（偏好日期） */
    public static final long BATCH_PREFER_DATE = 280L;

    /** 批处理条数（偏好时间） */
    public static final long BATCH_PREFER_TIME = 285L;

    /** 批处理条数（偏好标记） */
    public static final long BATCH_PREFER_FLAG = 290L;

    /** 批处理条数（偏好说明） */
    public static final long BATCH_PREFER_REMARK = 295L;

    /** 批处理条数（偏好来源） */
    public static final long BATCH_PREFER_SOURCE = 300L;

    private CustSettlementModuleConfig() {
    }

    /** 批处理条数（审计版本）。 */
    public static long resolveBatchAuditVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_AUDIT_VERSION;
        }
        if (requested > BATCH_AUDIT_VERSION) {
            return BATCH_AUDIT_VERSION;
        }
        return requested;
    }

    /** 批处理条数（审计区域）。 */
    public static long resolveBatchAuditRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_AUDIT_REGION;
        }
        if (requested > BATCH_AUDIT_REGION) {
            return BATCH_AUDIT_REGION;
        }
        return requested;
    }

    /** 批处理条数（审计渠道）。 */
    public static long resolveBatchAuditChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_AUDIT_CHANNEL;
        }
        if (requested > BATCH_AUDIT_CHANNEL) {
            return BATCH_AUDIT_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（审计分组）。 */
    public static long resolveBatchAuditGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_AUDIT_GROUP;
        }
        if (requested > BATCH_AUDIT_GROUP) {
            return BATCH_AUDIT_GROUP;
        }
        return requested;
    }

    /** 批处理条数（审计标签）。 */
    public static long resolveBatchAuditTag(long requested) {
        if (requested <= 0L) {
            return BATCH_AUDIT_TAG;
        }
        if (requested > BATCH_AUDIT_TAG) {
            return BATCH_AUDIT_TAG;
        }
        return requested;
    }

    /** 批处理条数（审计负责人）。 */
    public static long resolveBatchAuditOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_AUDIT_OWNER;
        }
        if (requested > BATCH_AUDIT_OWNER) {
            return BATCH_AUDIT_OWNER;
        }
        return requested;
    }

    /** 批处理条数（附件编号）。 */
    public static long resolveBatchAttachNo(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_NO;
        }
        if (requested > BATCH_ATTACH_NO) {
            return BATCH_ATTACH_NO;
        }
        return requested;
    }

    /** 批处理条数（附件名称）。 */
    public static long resolveBatchAttachName(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_NAME;
        }
        if (requested > BATCH_ATTACH_NAME) {
            return BATCH_ATTACH_NAME;
        }
        return requested;
    }

    /** 批处理条数（附件类型）。 */
    public static long resolveBatchAttachType(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_TYPE;
        }
        if (requested > BATCH_ATTACH_TYPE) {
            return BATCH_ATTACH_TYPE;
        }
        return requested;
    }

    /** 批处理条数（附件编码）。 */
    public static long resolveBatchAttachCode(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_CODE;
        }
        if (requested > BATCH_ATTACH_CODE) {
            return BATCH_ATTACH_CODE;
        }
        return requested;
    }

    /** 批处理条数（附件级别）。 */
    public static long resolveBatchAttachLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_LEVEL;
        }
        if (requested > BATCH_ATTACH_LEVEL) {
            return BATCH_ATTACH_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（附件状态）。 */
    public static long resolveBatchAttachStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_STATUS;
        }
        if (requested > BATCH_ATTACH_STATUS) {
            return BATCH_ATTACH_STATUS;
        }
        return requested;
    }

    /** 批处理条数（附件金额）。 */
    public static long resolveBatchAttachAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_AMOUNT;
        }
        if (requested > BATCH_ATTACH_AMOUNT) {
            return BATCH_ATTACH_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（附件数量）。 */
    public static long resolveBatchAttachCount(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_COUNT;
        }
        if (requested > BATCH_ATTACH_COUNT) {
            return BATCH_ATTACH_COUNT;
        }
        return requested;
    }

    /** 批处理条数（附件比率）。 */
    public static long resolveBatchAttachRate(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_RATE;
        }
        if (requested > BATCH_ATTACH_RATE) {
            return BATCH_ATTACH_RATE;
        }
        return requested;
    }

    /** 批处理条数（附件日期）。 */
    public static long resolveBatchAttachDate(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_DATE;
        }
        if (requested > BATCH_ATTACH_DATE) {
            return BATCH_ATTACH_DATE;
        }
        return requested;
    }

    /** 批处理条数（附件时间）。 */
    public static long resolveBatchAttachTime(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_TIME;
        }
        if (requested > BATCH_ATTACH_TIME) {
            return BATCH_ATTACH_TIME;
        }
        return requested;
    }

    /** 批处理条数（附件标记）。 */
    public static long resolveBatchAttachFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_FLAG;
        }
        if (requested > BATCH_ATTACH_FLAG) {
            return BATCH_ATTACH_FLAG;
        }
        return requested;
    }

    /** 批处理条数（附件说明）。 */
    public static long resolveBatchAttachRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_REMARK;
        }
        if (requested > BATCH_ATTACH_REMARK) {
            return BATCH_ATTACH_REMARK;
        }
        return requested;
    }

    /** 批处理条数（附件来源）。 */
    public static long resolveBatchAttachSource(long requested) {
        if (requested <= 0L) {
            return BATCH_ATTACH_SOURCE;
        }
        if (requested > BATCH_ATTACH_SOURCE) {
            return BATCH_ATTACH_SOURCE;
        }
        return requested;
    }

}

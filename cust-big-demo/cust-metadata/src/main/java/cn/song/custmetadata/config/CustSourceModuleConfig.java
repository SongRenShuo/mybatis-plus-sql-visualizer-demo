package cn.song.custmetadata.config;

/**
 * 客户来源ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustSourceModuleConfig {

    public static final String MODULE_CODE = "CUST_SOURCE";

    /** 重试次数（审计类型） */
    public static final long RETRY_AUDIT_TYPE = 5L;

    /** 重试次数（审计编码） */
    public static final long RETRY_AUDIT_CODE = 10L;

    /** 重试次数（审计级别） */
    public static final long RETRY_AUDIT_LEVEL = 15L;

    /** 重试次数（审计状态） */
    public static final long RETRY_AUDIT_STATUS = 20L;

    /** 重试次数（审计金额） */
    public static final long RETRY_AUDIT_AMOUNT = 25L;

    /** 重试次数（审计数量） */
    public static final long RETRY_AUDIT_COUNT = 30L;

    /** 重试次数（审计比率） */
    public static final long RETRY_AUDIT_RATE = 35L;

    /** 重试次数（审计日期） */
    public static final long RETRY_AUDIT_DATE = 40L;

    /** 重试次数（审计时间） */
    public static final long RETRY_AUDIT_TIME = 45L;

    /** 重试次数（审计标记） */
    public static final long RETRY_AUDIT_FLAG = 50L;

    /** 重试次数（审计说明） */
    public static final long RETRY_AUDIT_REMARK = 55L;

    /** 重试次数（审计来源） */
    public static final long RETRY_AUDIT_SOURCE = 60L;

    /** 重试次数（审计版本） */
    public static final long RETRY_AUDIT_VERSION = 65L;

    /** 重试次数（审计区域） */
    public static final long RETRY_AUDIT_REGION = 70L;

    /** 重试次数（审计渠道） */
    public static final long RETRY_AUDIT_CHANNEL = 75L;

    /** 重试次数（审计分组） */
    public static final long RETRY_AUDIT_GROUP = 80L;

    /** 重试次数（审计标签） */
    public static final long RETRY_AUDIT_TAG = 85L;

    /** 重试次数（审计负责人） */
    public static final long RETRY_AUDIT_OWNER = 90L;

    /** 重试次数（附件编号） */
    public static final long RETRY_ATTACH_NO = 95L;

    /** 重试次数（附件名称） */
    public static final long RETRY_ATTACH_NAME = 100L;

    /** 重试次数（附件类型） */
    public static final long RETRY_ATTACH_TYPE = 105L;

    /** 重试次数（附件编码） */
    public static final long RETRY_ATTACH_CODE = 110L;

    /** 重试次数（附件级别） */
    public static final long RETRY_ATTACH_LEVEL = 115L;

    /** 重试次数（附件状态） */
    public static final long RETRY_ATTACH_STATUS = 120L;

    /** 重试次数（附件金额） */
    public static final long RETRY_ATTACH_AMOUNT = 125L;

    /** 重试次数（附件数量） */
    public static final long RETRY_ATTACH_COUNT = 130L;

    /** 重试次数（附件比率） */
    public static final long RETRY_ATTACH_RATE = 135L;

    /** 重试次数（附件日期） */
    public static final long RETRY_ATTACH_DATE = 140L;

    /** 重试次数（附件时间） */
    public static final long RETRY_ATTACH_TIME = 145L;

    /** 重试次数（附件标记） */
    public static final long RETRY_ATTACH_FLAG = 150L;

    /** 重试次数（附件说明） */
    public static final long RETRY_ATTACH_REMARK = 155L;

    /** 重试次数（附件来源） */
    public static final long RETRY_ATTACH_SOURCE = 160L;

    /** 重试次数（附件版本） */
    public static final long RETRY_ATTACH_VERSION = 165L;

    /** 重试次数（附件区域） */
    public static final long RETRY_ATTACH_REGION = 170L;

    /** 重试次数（附件渠道） */
    public static final long RETRY_ATTACH_CHANNEL = 175L;

    /** 重试次数（附件分组） */
    public static final long RETRY_ATTACH_GROUP = 180L;

    /** 重试次数（附件标签） */
    public static final long RETRY_ATTACH_TAG = 185L;

    /** 重试次数（附件负责人） */
    public static final long RETRY_ATTACH_OWNER = 190L;

    /** 重试次数（备注编号） */
    public static final long RETRY_NOTE_NO = 195L;

    /** 重试次数（备注名称） */
    public static final long RETRY_NOTE_NAME = 200L;

    /** 重试次数（备注类型） */
    public static final long RETRY_NOTE_TYPE = 205L;

    /** 重试次数（备注编码） */
    public static final long RETRY_NOTE_CODE = 210L;

    /** 重试次数（备注级别） */
    public static final long RETRY_NOTE_LEVEL = 215L;

    /** 重试次数（备注状态） */
    public static final long RETRY_NOTE_STATUS = 220L;

    /** 重试次数（备注金额） */
    public static final long RETRY_NOTE_AMOUNT = 225L;

    /** 重试次数（备注数量） */
    public static final long RETRY_NOTE_COUNT = 230L;

    /** 重试次数（备注比率） */
    public static final long RETRY_NOTE_RATE = 235L;

    /** 重试次数（备注日期） */
    public static final long RETRY_NOTE_DATE = 240L;

    /** 重试次数（备注时间） */
    public static final long RETRY_NOTE_TIME = 245L;

    /** 重试次数（备注标记） */
    public static final long RETRY_NOTE_FLAG = 250L;

    /** 重试次数（备注说明） */
    public static final long RETRY_NOTE_REMARK = 255L;

    /** 重试次数（备注来源） */
    public static final long RETRY_NOTE_SOURCE = 260L;

    /** 重试次数（备注版本） */
    public static final long RETRY_NOTE_VERSION = 265L;

    /** 重试次数（备注区域） */
    public static final long RETRY_NOTE_REGION = 270L;

    /** 重试次数（备注渠道） */
    public static final long RETRY_NOTE_CHANNEL = 275L;

    /** 重试次数（备注分组） */
    public static final long RETRY_NOTE_GROUP = 280L;

    /** 重试次数（备注标签） */
    public static final long RETRY_NOTE_TAG = 285L;

    /** 重试次数（备注负责人） */
    public static final long RETRY_NOTE_OWNER = 290L;

    /** 重试次数（偏好编号） */
    public static final long RETRY_PREFER_NO = 295L;

    /** 重试次数（偏好名称） */
    public static final long RETRY_PREFER_NAME = 300L;

    private CustSourceModuleConfig() {
    }

    /** 重试次数（审计类型）。 */
    public static long resolveRetryAuditType(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_TYPE;
        }
        if (requested > RETRY_AUDIT_TYPE) {
            return RETRY_AUDIT_TYPE;
        }
        return requested;
    }

    /** 重试次数（审计编码）。 */
    public static long resolveRetryAuditCode(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_CODE;
        }
        if (requested > RETRY_AUDIT_CODE) {
            return RETRY_AUDIT_CODE;
        }
        return requested;
    }

    /** 重试次数（审计级别）。 */
    public static long resolveRetryAuditLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_LEVEL;
        }
        if (requested > RETRY_AUDIT_LEVEL) {
            return RETRY_AUDIT_LEVEL;
        }
        return requested;
    }

    /** 重试次数（审计状态）。 */
    public static long resolveRetryAuditStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_STATUS;
        }
        if (requested > RETRY_AUDIT_STATUS) {
            return RETRY_AUDIT_STATUS;
        }
        return requested;
    }

    /** 重试次数（审计金额）。 */
    public static long resolveRetryAuditAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_AMOUNT;
        }
        if (requested > RETRY_AUDIT_AMOUNT) {
            return RETRY_AUDIT_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（审计数量）。 */
    public static long resolveRetryAuditCount(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_COUNT;
        }
        if (requested > RETRY_AUDIT_COUNT) {
            return RETRY_AUDIT_COUNT;
        }
        return requested;
    }

    /** 重试次数（审计比率）。 */
    public static long resolveRetryAuditRate(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_RATE;
        }
        if (requested > RETRY_AUDIT_RATE) {
            return RETRY_AUDIT_RATE;
        }
        return requested;
    }

    /** 重试次数（审计日期）。 */
    public static long resolveRetryAuditDate(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_DATE;
        }
        if (requested > RETRY_AUDIT_DATE) {
            return RETRY_AUDIT_DATE;
        }
        return requested;
    }

    /** 重试次数（审计时间）。 */
    public static long resolveRetryAuditTime(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_TIME;
        }
        if (requested > RETRY_AUDIT_TIME) {
            return RETRY_AUDIT_TIME;
        }
        return requested;
    }

    /** 重试次数（审计标记）。 */
    public static long resolveRetryAuditFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_FLAG;
        }
        if (requested > RETRY_AUDIT_FLAG) {
            return RETRY_AUDIT_FLAG;
        }
        return requested;
    }

    /** 重试次数（审计说明）。 */
    public static long resolveRetryAuditRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_REMARK;
        }
        if (requested > RETRY_AUDIT_REMARK) {
            return RETRY_AUDIT_REMARK;
        }
        return requested;
    }

    /** 重试次数（审计来源）。 */
    public static long resolveRetryAuditSource(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_SOURCE;
        }
        if (requested > RETRY_AUDIT_SOURCE) {
            return RETRY_AUDIT_SOURCE;
        }
        return requested;
    }

    /** 重试次数（审计版本）。 */
    public static long resolveRetryAuditVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_VERSION;
        }
        if (requested > RETRY_AUDIT_VERSION) {
            return RETRY_AUDIT_VERSION;
        }
        return requested;
    }

    /** 重试次数（审计区域）。 */
    public static long resolveRetryAuditRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_REGION;
        }
        if (requested > RETRY_AUDIT_REGION) {
            return RETRY_AUDIT_REGION;
        }
        return requested;
    }

    /** 重试次数（审计渠道）。 */
    public static long resolveRetryAuditChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_CHANNEL;
        }
        if (requested > RETRY_AUDIT_CHANNEL) {
            return RETRY_AUDIT_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（审计分组）。 */
    public static long resolveRetryAuditGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_GROUP;
        }
        if (requested > RETRY_AUDIT_GROUP) {
            return RETRY_AUDIT_GROUP;
        }
        return requested;
    }

    /** 重试次数（审计标签）。 */
    public static long resolveRetryAuditTag(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_TAG;
        }
        if (requested > RETRY_AUDIT_TAG) {
            return RETRY_AUDIT_TAG;
        }
        return requested;
    }

    /** 重试次数（审计负责人）。 */
    public static long resolveRetryAuditOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_AUDIT_OWNER;
        }
        if (requested > RETRY_AUDIT_OWNER) {
            return RETRY_AUDIT_OWNER;
        }
        return requested;
    }

    /** 重试次数（附件编号）。 */
    public static long resolveRetryAttachNo(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_NO;
        }
        if (requested > RETRY_ATTACH_NO) {
            return RETRY_ATTACH_NO;
        }
        return requested;
    }

    /** 重试次数（附件名称）。 */
    public static long resolveRetryAttachName(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_NAME;
        }
        if (requested > RETRY_ATTACH_NAME) {
            return RETRY_ATTACH_NAME;
        }
        return requested;
    }

}

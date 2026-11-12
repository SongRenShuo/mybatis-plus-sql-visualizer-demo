package cn.song.custmetadata.config;

/**
 * 客户来源CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustSourceCacheConfig {

    public static final String MODULE_CODE = "CUST_SOURCE_CACHE_CONFIG";

    /** 重试次数（审计区域） */
    public static final long RETRY_AUDIT_REGION = 5L;

    /** 重试次数（审计渠道） */
    public static final long RETRY_AUDIT_CHANNEL = 10L;

    /** 重试次数（审计分组） */
    public static final long RETRY_AUDIT_GROUP = 15L;

    /** 重试次数（审计标签） */
    public static final long RETRY_AUDIT_TAG = 20L;

    /** 重试次数（审计负责人） */
    public static final long RETRY_AUDIT_OWNER = 25L;

    /** 重试次数（附件编号） */
    public static final long RETRY_ATTACH_NO = 30L;

    /** 重试次数（附件名称） */
    public static final long RETRY_ATTACH_NAME = 35L;

    /** 重试次数（附件类型） */
    public static final long RETRY_ATTACH_TYPE = 40L;

    /** 重试次数（附件编码） */
    public static final long RETRY_ATTACH_CODE = 45L;

    /** 重试次数（附件级别） */
    public static final long RETRY_ATTACH_LEVEL = 50L;

    /** 重试次数（附件状态） */
    public static final long RETRY_ATTACH_STATUS = 55L;

    /** 重试次数（附件金额） */
    public static final long RETRY_ATTACH_AMOUNT = 60L;

    /** 重试次数（附件数量） */
    public static final long RETRY_ATTACH_COUNT = 65L;

    /** 重试次数（附件比率） */
    public static final long RETRY_ATTACH_RATE = 70L;

    /** 重试次数（附件日期） */
    public static final long RETRY_ATTACH_DATE = 75L;

    /** 重试次数（附件时间） */
    public static final long RETRY_ATTACH_TIME = 80L;

    /** 重试次数（附件标记） */
    public static final long RETRY_ATTACH_FLAG = 85L;

    /** 重试次数（附件说明） */
    public static final long RETRY_ATTACH_REMARK = 90L;

    /** 重试次数（附件来源） */
    public static final long RETRY_ATTACH_SOURCE = 95L;

    /** 重试次数（附件版本） */
    public static final long RETRY_ATTACH_VERSION = 100L;

    /** 重试次数（附件区域） */
    public static final long RETRY_ATTACH_REGION = 105L;

    /** 重试次数（附件渠道） */
    public static final long RETRY_ATTACH_CHANNEL = 110L;

    /** 重试次数（附件分组） */
    public static final long RETRY_ATTACH_GROUP = 115L;

    /** 重试次数（附件标签） */
    public static final long RETRY_ATTACH_TAG = 120L;

    /** 重试次数（附件负责人） */
    public static final long RETRY_ATTACH_OWNER = 125L;

    /** 重试次数（备注编号） */
    public static final long RETRY_NOTE_NO = 130L;

    /** 重试次数（备注名称） */
    public static final long RETRY_NOTE_NAME = 135L;

    /** 重试次数（备注类型） */
    public static final long RETRY_NOTE_TYPE = 140L;

    /** 重试次数（备注编码） */
    public static final long RETRY_NOTE_CODE = 145L;

    /** 重试次数（备注级别） */
    public static final long RETRY_NOTE_LEVEL = 150L;

    /** 重试次数（备注状态） */
    public static final long RETRY_NOTE_STATUS = 155L;

    /** 重试次数（备注金额） */
    public static final long RETRY_NOTE_AMOUNT = 160L;

    /** 重试次数（备注数量） */
    public static final long RETRY_NOTE_COUNT = 165L;

    /** 重试次数（备注比率） */
    public static final long RETRY_NOTE_RATE = 170L;

    /** 重试次数（备注日期） */
    public static final long RETRY_NOTE_DATE = 175L;

    /** 重试次数（备注时间） */
    public static final long RETRY_NOTE_TIME = 180L;

    /** 重试次数（备注标记） */
    public static final long RETRY_NOTE_FLAG = 185L;

    /** 重试次数（备注说明） */
    public static final long RETRY_NOTE_REMARK = 190L;

    /** 重试次数（备注来源） */
    public static final long RETRY_NOTE_SOURCE = 195L;

    /** 重试次数（备注版本） */
    public static final long RETRY_NOTE_VERSION = 200L;

    /** 重试次数（备注区域） */
    public static final long RETRY_NOTE_REGION = 205L;

    /** 重试次数（备注渠道） */
    public static final long RETRY_NOTE_CHANNEL = 210L;

    /** 重试次数（备注分组） */
    public static final long RETRY_NOTE_GROUP = 215L;

    /** 重试次数（备注标签） */
    public static final long RETRY_NOTE_TAG = 220L;

    /** 重试次数（备注负责人） */
    public static final long RETRY_NOTE_OWNER = 225L;

    /** 重试次数（偏好编号） */
    public static final long RETRY_PREFER_NO = 230L;

    /** 重试次数（偏好名称） */
    public static final long RETRY_PREFER_NAME = 235L;

    /** 重试次数（偏好类型） */
    public static final long RETRY_PREFER_TYPE = 240L;

    /** 重试次数（偏好编码） */
    public static final long RETRY_PREFER_CODE = 245L;

    /** 重试次数（偏好级别） */
    public static final long RETRY_PREFER_LEVEL = 250L;

    /** 重试次数（偏好状态） */
    public static final long RETRY_PREFER_STATUS = 255L;

    /** 重试次数（偏好金额） */
    public static final long RETRY_PREFER_AMOUNT = 260L;

    /** 重试次数（偏好数量） */
    public static final long RETRY_PREFER_COUNT = 265L;

    /** 重试次数（偏好比率） */
    public static final long RETRY_PREFER_RATE = 270L;

    /** 重试次数（偏好日期） */
    public static final long RETRY_PREFER_DATE = 275L;

    /** 重试次数（偏好时间） */
    public static final long RETRY_PREFER_TIME = 280L;

    /** 重试次数（偏好标记） */
    public static final long RETRY_PREFER_FLAG = 285L;

    /** 重试次数（偏好说明） */
    public static final long RETRY_PREFER_REMARK = 290L;

    /** 重试次数（偏好来源） */
    public static final long RETRY_PREFER_SOURCE = 295L;

    /** 重试次数（偏好版本） */
    public static final long RETRY_PREFER_VERSION = 300L;

    private CustSourceCacheConfig() {
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

    /** 重试次数（附件类型）。 */
    public static long resolveRetryAttachType(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_TYPE;
        }
        if (requested > RETRY_ATTACH_TYPE) {
            return RETRY_ATTACH_TYPE;
        }
        return requested;
    }

    /** 重试次数（附件编码）。 */
    public static long resolveRetryAttachCode(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_CODE;
        }
        if (requested > RETRY_ATTACH_CODE) {
            return RETRY_ATTACH_CODE;
        }
        return requested;
    }

    /** 重试次数（附件级别）。 */
    public static long resolveRetryAttachLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_LEVEL;
        }
        if (requested > RETRY_ATTACH_LEVEL) {
            return RETRY_ATTACH_LEVEL;
        }
        return requested;
    }

    /** 重试次数（附件状态）。 */
    public static long resolveRetryAttachStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_STATUS;
        }
        if (requested > RETRY_ATTACH_STATUS) {
            return RETRY_ATTACH_STATUS;
        }
        return requested;
    }

    /** 重试次数（附件金额）。 */
    public static long resolveRetryAttachAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_AMOUNT;
        }
        if (requested > RETRY_ATTACH_AMOUNT) {
            return RETRY_ATTACH_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（附件数量）。 */
    public static long resolveRetryAttachCount(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_COUNT;
        }
        if (requested > RETRY_ATTACH_COUNT) {
            return RETRY_ATTACH_COUNT;
        }
        return requested;
    }

    /** 重试次数（附件比率）。 */
    public static long resolveRetryAttachRate(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_RATE;
        }
        if (requested > RETRY_ATTACH_RATE) {
            return RETRY_ATTACH_RATE;
        }
        return requested;
    }

    /** 重试次数（附件日期）。 */
    public static long resolveRetryAttachDate(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_DATE;
        }
        if (requested > RETRY_ATTACH_DATE) {
            return RETRY_ATTACH_DATE;
        }
        return requested;
    }

    /** 重试次数（附件时间）。 */
    public static long resolveRetryAttachTime(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_TIME;
        }
        if (requested > RETRY_ATTACH_TIME) {
            return RETRY_ATTACH_TIME;
        }
        return requested;
    }

    /** 重试次数（附件标记）。 */
    public static long resolveRetryAttachFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_FLAG;
        }
        if (requested > RETRY_ATTACH_FLAG) {
            return RETRY_ATTACH_FLAG;
        }
        return requested;
    }

    /** 重试次数（附件说明）。 */
    public static long resolveRetryAttachRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_REMARK;
        }
        if (requested > RETRY_ATTACH_REMARK) {
            return RETRY_ATTACH_REMARK;
        }
        return requested;
    }

    /** 重试次数（附件来源）。 */
    public static long resolveRetryAttachSource(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_SOURCE;
        }
        if (requested > RETRY_ATTACH_SOURCE) {
            return RETRY_ATTACH_SOURCE;
        }
        return requested;
    }

    /** 重试次数（附件版本）。 */
    public static long resolveRetryAttachVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_VERSION;
        }
        if (requested > RETRY_ATTACH_VERSION) {
            return RETRY_ATTACH_VERSION;
        }
        return requested;
    }

}

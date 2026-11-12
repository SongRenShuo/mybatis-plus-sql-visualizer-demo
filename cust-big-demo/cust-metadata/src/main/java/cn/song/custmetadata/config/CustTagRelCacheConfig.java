package cn.song.custmetadata.config;

/**
 * 客户标签关系CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustTagRelCacheConfig {

    public static final String MODULE_CODE = "CUST_TAG_REL_CACHE_CONFIG";

    /** 单次查询上限（审计编码） */
    public static final long LIMIT_AUDIT_CODE = 5L;

    /** 单次查询上限（审计级别） */
    public static final long LIMIT_AUDIT_LEVEL = 10L;

    /** 单次查询上限（审计状态） */
    public static final long LIMIT_AUDIT_STATUS = 15L;

    /** 单次查询上限（审计金额） */
    public static final long LIMIT_AUDIT_AMOUNT = 20L;

    /** 单次查询上限（审计数量） */
    public static final long LIMIT_AUDIT_COUNT = 25L;

    /** 单次查询上限（审计比率） */
    public static final long LIMIT_AUDIT_RATE = 30L;

    /** 单次查询上限（审计日期） */
    public static final long LIMIT_AUDIT_DATE = 35L;

    /** 单次查询上限（审计时间） */
    public static final long LIMIT_AUDIT_TIME = 40L;

    /** 单次查询上限（审计标记） */
    public static final long LIMIT_AUDIT_FLAG = 45L;

    /** 单次查询上限（审计说明） */
    public static final long LIMIT_AUDIT_REMARK = 50L;

    /** 单次查询上限（审计来源） */
    public static final long LIMIT_AUDIT_SOURCE = 55L;

    /** 单次查询上限（审计版本） */
    public static final long LIMIT_AUDIT_VERSION = 60L;

    /** 单次查询上限（审计区域） */
    public static final long LIMIT_AUDIT_REGION = 65L;

    /** 单次查询上限（审计渠道） */
    public static final long LIMIT_AUDIT_CHANNEL = 70L;

    /** 单次查询上限（审计分组） */
    public static final long LIMIT_AUDIT_GROUP = 75L;

    /** 单次查询上限（审计标签） */
    public static final long LIMIT_AUDIT_TAG = 80L;

    /** 单次查询上限（审计负责人） */
    public static final long LIMIT_AUDIT_OWNER = 85L;

    /** 单次查询上限（附件编号） */
    public static final long LIMIT_ATTACH_NO = 90L;

    /** 单次查询上限（附件名称） */
    public static final long LIMIT_ATTACH_NAME = 95L;

    /** 单次查询上限（附件类型） */
    public static final long LIMIT_ATTACH_TYPE = 100L;

    /** 单次查询上限（附件编码） */
    public static final long LIMIT_ATTACH_CODE = 105L;

    /** 单次查询上限（附件级别） */
    public static final long LIMIT_ATTACH_LEVEL = 110L;

    /** 单次查询上限（附件状态） */
    public static final long LIMIT_ATTACH_STATUS = 115L;

    /** 单次查询上限（附件金额） */
    public static final long LIMIT_ATTACH_AMOUNT = 120L;

    /** 单次查询上限（附件数量） */
    public static final long LIMIT_ATTACH_COUNT = 125L;

    /** 单次查询上限（附件比率） */
    public static final long LIMIT_ATTACH_RATE = 130L;

    /** 单次查询上限（附件日期） */
    public static final long LIMIT_ATTACH_DATE = 135L;

    /** 单次查询上限（附件时间） */
    public static final long LIMIT_ATTACH_TIME = 140L;

    /** 单次查询上限（附件标记） */
    public static final long LIMIT_ATTACH_FLAG = 145L;

    /** 单次查询上限（附件说明） */
    public static final long LIMIT_ATTACH_REMARK = 150L;

    /** 单次查询上限（附件来源） */
    public static final long LIMIT_ATTACH_SOURCE = 155L;

    /** 单次查询上限（附件版本） */
    public static final long LIMIT_ATTACH_VERSION = 160L;

    /** 单次查询上限（附件区域） */
    public static final long LIMIT_ATTACH_REGION = 165L;

    /** 单次查询上限（附件渠道） */
    public static final long LIMIT_ATTACH_CHANNEL = 170L;

    /** 单次查询上限（附件分组） */
    public static final long LIMIT_ATTACH_GROUP = 175L;

    /** 单次查询上限（附件标签） */
    public static final long LIMIT_ATTACH_TAG = 180L;

    /** 单次查询上限（附件负责人） */
    public static final long LIMIT_ATTACH_OWNER = 185L;

    /** 单次查询上限（备注编号） */
    public static final long LIMIT_NOTE_NO = 190L;

    /** 单次查询上限（备注名称） */
    public static final long LIMIT_NOTE_NAME = 195L;

    /** 单次查询上限（备注类型） */
    public static final long LIMIT_NOTE_TYPE = 200L;

    /** 单次查询上限（备注编码） */
    public static final long LIMIT_NOTE_CODE = 205L;

    /** 单次查询上限（备注级别） */
    public static final long LIMIT_NOTE_LEVEL = 210L;

    /** 单次查询上限（备注状态） */
    public static final long LIMIT_NOTE_STATUS = 215L;

    /** 单次查询上限（备注金额） */
    public static final long LIMIT_NOTE_AMOUNT = 220L;

    /** 单次查询上限（备注数量） */
    public static final long LIMIT_NOTE_COUNT = 225L;

    /** 单次查询上限（备注比率） */
    public static final long LIMIT_NOTE_RATE = 230L;

    /** 单次查询上限（备注日期） */
    public static final long LIMIT_NOTE_DATE = 235L;

    /** 单次查询上限（备注时间） */
    public static final long LIMIT_NOTE_TIME = 240L;

    /** 单次查询上限（备注标记） */
    public static final long LIMIT_NOTE_FLAG = 245L;

    /** 单次查询上限（备注说明） */
    public static final long LIMIT_NOTE_REMARK = 250L;

    /** 单次查询上限（备注来源） */
    public static final long LIMIT_NOTE_SOURCE = 255L;

    /** 单次查询上限（备注版本） */
    public static final long LIMIT_NOTE_VERSION = 260L;

    /** 单次查询上限（备注区域） */
    public static final long LIMIT_NOTE_REGION = 265L;

    /** 单次查询上限（备注渠道） */
    public static final long LIMIT_NOTE_CHANNEL = 270L;

    /** 单次查询上限（备注分组） */
    public static final long LIMIT_NOTE_GROUP = 275L;

    /** 单次查询上限（备注标签） */
    public static final long LIMIT_NOTE_TAG = 280L;

    /** 单次查询上限（备注负责人） */
    public static final long LIMIT_NOTE_OWNER = 285L;

    /** 单次查询上限（偏好编号） */
    public static final long LIMIT_PREFER_NO = 290L;

    /** 单次查询上限（偏好名称） */
    public static final long LIMIT_PREFER_NAME = 295L;

    /** 单次查询上限（偏好类型） */
    public static final long LIMIT_PREFER_TYPE = 300L;

    private CustTagRelCacheConfig() {
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

    /** 单次查询上限（审计时间）。 */
    public static long resolveLimitAuditTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_TIME;
        }
        if (requested > LIMIT_AUDIT_TIME) {
            return LIMIT_AUDIT_TIME;
        }
        return requested;
    }

    /** 单次查询上限（审计标记）。 */
    public static long resolveLimitAuditFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_FLAG;
        }
        if (requested > LIMIT_AUDIT_FLAG) {
            return LIMIT_AUDIT_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（审计说明）。 */
    public static long resolveLimitAuditRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_REMARK;
        }
        if (requested > LIMIT_AUDIT_REMARK) {
            return LIMIT_AUDIT_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（审计来源）。 */
    public static long resolveLimitAuditSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_SOURCE;
        }
        if (requested > LIMIT_AUDIT_SOURCE) {
            return LIMIT_AUDIT_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（审计版本）。 */
    public static long resolveLimitAuditVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_VERSION;
        }
        if (requested > LIMIT_AUDIT_VERSION) {
            return LIMIT_AUDIT_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（审计区域）。 */
    public static long resolveLimitAuditRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_REGION;
        }
        if (requested > LIMIT_AUDIT_REGION) {
            return LIMIT_AUDIT_REGION;
        }
        return requested;
    }

    /** 单次查询上限（审计渠道）。 */
    public static long resolveLimitAuditChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_CHANNEL;
        }
        if (requested > LIMIT_AUDIT_CHANNEL) {
            return LIMIT_AUDIT_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（审计分组）。 */
    public static long resolveLimitAuditGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_GROUP;
        }
        if (requested > LIMIT_AUDIT_GROUP) {
            return LIMIT_AUDIT_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（审计标签）。 */
    public static long resolveLimitAuditTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_TAG;
        }
        if (requested > LIMIT_AUDIT_TAG) {
            return LIMIT_AUDIT_TAG;
        }
        return requested;
    }

    /** 单次查询上限（审计负责人）。 */
    public static long resolveLimitAuditOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_AUDIT_OWNER;
        }
        if (requested > LIMIT_AUDIT_OWNER) {
            return LIMIT_AUDIT_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（附件编号）。 */
    public static long resolveLimitAttachNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_ATTACH_NO;
        }
        if (requested > LIMIT_ATTACH_NO) {
            return LIMIT_ATTACH_NO;
        }
        return requested;
    }

    /** 单次查询上限（附件名称）。 */
    public static long resolveLimitAttachName(long requested) {
        if (requested <= 0L) {
            return LIMIT_ATTACH_NAME;
        }
        if (requested > LIMIT_ATTACH_NAME) {
            return LIMIT_ATTACH_NAME;
        }
        return requested;
    }

    /** 单次查询上限（附件类型）。 */
    public static long resolveLimitAttachType(long requested) {
        if (requested <= 0L) {
            return LIMIT_ATTACH_TYPE;
        }
        if (requested > LIMIT_ATTACH_TYPE) {
            return LIMIT_ATTACH_TYPE;
        }
        return requested;
    }

}

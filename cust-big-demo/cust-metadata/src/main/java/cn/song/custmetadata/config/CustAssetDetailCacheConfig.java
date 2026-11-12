package cn.song.custmetadata.config;

/**
 * 客户资产明细CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustAssetDetailCacheConfig {

    public static final String MODULE_CODE = "CUST_ASSET_DETAIL_CACHE_CONFIG";

    /** 超时毫秒数（审计日期） */
    public static final long TIMEOUT_AUDIT_DATE = 5L;

    /** 超时毫秒数（审计时间） */
    public static final long TIMEOUT_AUDIT_TIME = 10L;

    /** 超时毫秒数（审计标记） */
    public static final long TIMEOUT_AUDIT_FLAG = 15L;

    /** 超时毫秒数（审计说明） */
    public static final long TIMEOUT_AUDIT_REMARK = 20L;

    /** 超时毫秒数（审计来源） */
    public static final long TIMEOUT_AUDIT_SOURCE = 25L;

    /** 超时毫秒数（审计版本） */
    public static final long TIMEOUT_AUDIT_VERSION = 30L;

    /** 超时毫秒数（审计区域） */
    public static final long TIMEOUT_AUDIT_REGION = 35L;

    /** 超时毫秒数（审计渠道） */
    public static final long TIMEOUT_AUDIT_CHANNEL = 40L;

    /** 超时毫秒数（审计分组） */
    public static final long TIMEOUT_AUDIT_GROUP = 45L;

    /** 超时毫秒数（审计标签） */
    public static final long TIMEOUT_AUDIT_TAG = 50L;

    /** 超时毫秒数（审计负责人） */
    public static final long TIMEOUT_AUDIT_OWNER = 55L;

    /** 超时毫秒数（附件编号） */
    public static final long TIMEOUT_ATTACH_NO = 60L;

    /** 超时毫秒数（附件名称） */
    public static final long TIMEOUT_ATTACH_NAME = 65L;

    /** 超时毫秒数（附件类型） */
    public static final long TIMEOUT_ATTACH_TYPE = 70L;

    /** 超时毫秒数（附件编码） */
    public static final long TIMEOUT_ATTACH_CODE = 75L;

    /** 超时毫秒数（附件级别） */
    public static final long TIMEOUT_ATTACH_LEVEL = 80L;

    /** 超时毫秒数（附件状态） */
    public static final long TIMEOUT_ATTACH_STATUS = 85L;

    /** 超时毫秒数（附件金额） */
    public static final long TIMEOUT_ATTACH_AMOUNT = 90L;

    /** 超时毫秒数（附件数量） */
    public static final long TIMEOUT_ATTACH_COUNT = 95L;

    /** 超时毫秒数（附件比率） */
    public static final long TIMEOUT_ATTACH_RATE = 100L;

    /** 超时毫秒数（附件日期） */
    public static final long TIMEOUT_ATTACH_DATE = 105L;

    /** 超时毫秒数（附件时间） */
    public static final long TIMEOUT_ATTACH_TIME = 110L;

    /** 超时毫秒数（附件标记） */
    public static final long TIMEOUT_ATTACH_FLAG = 115L;

    /** 超时毫秒数（附件说明） */
    public static final long TIMEOUT_ATTACH_REMARK = 120L;

    /** 超时毫秒数（附件来源） */
    public static final long TIMEOUT_ATTACH_SOURCE = 125L;

    /** 超时毫秒数（附件版本） */
    public static final long TIMEOUT_ATTACH_VERSION = 130L;

    /** 超时毫秒数（附件区域） */
    public static final long TIMEOUT_ATTACH_REGION = 135L;

    /** 超时毫秒数（附件渠道） */
    public static final long TIMEOUT_ATTACH_CHANNEL = 140L;

    /** 超时毫秒数（附件分组） */
    public static final long TIMEOUT_ATTACH_GROUP = 145L;

    /** 超时毫秒数（附件标签） */
    public static final long TIMEOUT_ATTACH_TAG = 150L;

    /** 超时毫秒数（附件负责人） */
    public static final long TIMEOUT_ATTACH_OWNER = 155L;

    /** 超时毫秒数（备注编号） */
    public static final long TIMEOUT_NOTE_NO = 160L;

    /** 超时毫秒数（备注名称） */
    public static final long TIMEOUT_NOTE_NAME = 165L;

    /** 超时毫秒数（备注类型） */
    public static final long TIMEOUT_NOTE_TYPE = 170L;

    /** 超时毫秒数（备注编码） */
    public static final long TIMEOUT_NOTE_CODE = 175L;

    /** 超时毫秒数（备注级别） */
    public static final long TIMEOUT_NOTE_LEVEL = 180L;

    /** 超时毫秒数（备注状态） */
    public static final long TIMEOUT_NOTE_STATUS = 185L;

    /** 超时毫秒数（备注金额） */
    public static final long TIMEOUT_NOTE_AMOUNT = 190L;

    /** 超时毫秒数（备注数量） */
    public static final long TIMEOUT_NOTE_COUNT = 195L;

    /** 超时毫秒数（备注比率） */
    public static final long TIMEOUT_NOTE_RATE = 200L;

    /** 超时毫秒数（备注日期） */
    public static final long TIMEOUT_NOTE_DATE = 205L;

    /** 超时毫秒数（备注时间） */
    public static final long TIMEOUT_NOTE_TIME = 210L;

    /** 超时毫秒数（备注标记） */
    public static final long TIMEOUT_NOTE_FLAG = 215L;

    /** 超时毫秒数（备注说明） */
    public static final long TIMEOUT_NOTE_REMARK = 220L;

    /** 超时毫秒数（备注来源） */
    public static final long TIMEOUT_NOTE_SOURCE = 225L;

    /** 超时毫秒数（备注版本） */
    public static final long TIMEOUT_NOTE_VERSION = 230L;

    /** 超时毫秒数（备注区域） */
    public static final long TIMEOUT_NOTE_REGION = 235L;

    /** 超时毫秒数（备注渠道） */
    public static final long TIMEOUT_NOTE_CHANNEL = 240L;

    /** 超时毫秒数（备注分组） */
    public static final long TIMEOUT_NOTE_GROUP = 245L;

    /** 超时毫秒数（备注标签） */
    public static final long TIMEOUT_NOTE_TAG = 250L;

    /** 超时毫秒数（备注负责人） */
    public static final long TIMEOUT_NOTE_OWNER = 255L;

    /** 超时毫秒数（偏好编号） */
    public static final long TIMEOUT_PREFER_NO = 260L;

    /** 超时毫秒数（偏好名称） */
    public static final long TIMEOUT_PREFER_NAME = 265L;

    /** 超时毫秒数（偏好类型） */
    public static final long TIMEOUT_PREFER_TYPE = 270L;

    /** 超时毫秒数（偏好编码） */
    public static final long TIMEOUT_PREFER_CODE = 275L;

    /** 超时毫秒数（偏好级别） */
    public static final long TIMEOUT_PREFER_LEVEL = 280L;

    /** 超时毫秒数（偏好状态） */
    public static final long TIMEOUT_PREFER_STATUS = 285L;

    /** 超时毫秒数（偏好金额） */
    public static final long TIMEOUT_PREFER_AMOUNT = 290L;

    /** 超时毫秒数（偏好数量） */
    public static final long TIMEOUT_PREFER_COUNT = 295L;

    /** 超时毫秒数（偏好比率） */
    public static final long TIMEOUT_PREFER_RATE = 300L;

    private CustAssetDetailCacheConfig() {
    }

    /** 超时毫秒数（审计日期）。 */
    public static long resolveTimeoutAuditDate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_DATE;
        }
        if (requested > TIMEOUT_AUDIT_DATE) {
            return TIMEOUT_AUDIT_DATE;
        }
        return requested;
    }

    /** 超时毫秒数（审计时间）。 */
    public static long resolveTimeoutAuditTime(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_TIME;
        }
        if (requested > TIMEOUT_AUDIT_TIME) {
            return TIMEOUT_AUDIT_TIME;
        }
        return requested;
    }

    /** 超时毫秒数（审计标记）。 */
    public static long resolveTimeoutAuditFlag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_FLAG;
        }
        if (requested > TIMEOUT_AUDIT_FLAG) {
            return TIMEOUT_AUDIT_FLAG;
        }
        return requested;
    }

    /** 超时毫秒数（审计说明）。 */
    public static long resolveTimeoutAuditRemark(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_REMARK;
        }
        if (requested > TIMEOUT_AUDIT_REMARK) {
            return TIMEOUT_AUDIT_REMARK;
        }
        return requested;
    }

    /** 超时毫秒数（审计来源）。 */
    public static long resolveTimeoutAuditSource(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_SOURCE;
        }
        if (requested > TIMEOUT_AUDIT_SOURCE) {
            return TIMEOUT_AUDIT_SOURCE;
        }
        return requested;
    }

    /** 超时毫秒数（审计版本）。 */
    public static long resolveTimeoutAuditVersion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_VERSION;
        }
        if (requested > TIMEOUT_AUDIT_VERSION) {
            return TIMEOUT_AUDIT_VERSION;
        }
        return requested;
    }

    /** 超时毫秒数（审计区域）。 */
    public static long resolveTimeoutAuditRegion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_REGION;
        }
        if (requested > TIMEOUT_AUDIT_REGION) {
            return TIMEOUT_AUDIT_REGION;
        }
        return requested;
    }

    /** 超时毫秒数（审计渠道）。 */
    public static long resolveTimeoutAuditChannel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_CHANNEL;
        }
        if (requested > TIMEOUT_AUDIT_CHANNEL) {
            return TIMEOUT_AUDIT_CHANNEL;
        }
        return requested;
    }

    /** 超时毫秒数（审计分组）。 */
    public static long resolveTimeoutAuditGroup(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_GROUP;
        }
        if (requested > TIMEOUT_AUDIT_GROUP) {
            return TIMEOUT_AUDIT_GROUP;
        }
        return requested;
    }

    /** 超时毫秒数（审计标签）。 */
    public static long resolveTimeoutAuditTag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_TAG;
        }
        if (requested > TIMEOUT_AUDIT_TAG) {
            return TIMEOUT_AUDIT_TAG;
        }
        return requested;
    }

    /** 超时毫秒数（审计负责人）。 */
    public static long resolveTimeoutAuditOwner(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_AUDIT_OWNER;
        }
        if (requested > TIMEOUT_AUDIT_OWNER) {
            return TIMEOUT_AUDIT_OWNER;
        }
        return requested;
    }

    /** 超时毫秒数（附件编号）。 */
    public static long resolveTimeoutAttachNo(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_ATTACH_NO;
        }
        if (requested > TIMEOUT_ATTACH_NO) {
            return TIMEOUT_ATTACH_NO;
        }
        return requested;
    }

    /** 超时毫秒数（附件名称）。 */
    public static long resolveTimeoutAttachName(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_ATTACH_NAME;
        }
        if (requested > TIMEOUT_ATTACH_NAME) {
            return TIMEOUT_ATTACH_NAME;
        }
        return requested;
    }

    /** 超时毫秒数（附件类型）。 */
    public static long resolveTimeoutAttachType(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_ATTACH_TYPE;
        }
        if (requested > TIMEOUT_ATTACH_TYPE) {
            return TIMEOUT_ATTACH_TYPE;
        }
        return requested;
    }

    /** 超时毫秒数（附件编码）。 */
    public static long resolveTimeoutAttachCode(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_ATTACH_CODE;
        }
        if (requested > TIMEOUT_ATTACH_CODE) {
            return TIMEOUT_ATTACH_CODE;
        }
        return requested;
    }

    /** 超时毫秒数（附件级别）。 */
    public static long resolveTimeoutAttachLevel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_ATTACH_LEVEL;
        }
        if (requested > TIMEOUT_ATTACH_LEVEL) {
            return TIMEOUT_ATTACH_LEVEL;
        }
        return requested;
    }

    /** 超时毫秒数（附件状态）。 */
    public static long resolveTimeoutAttachStatus(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_ATTACH_STATUS;
        }
        if (requested > TIMEOUT_ATTACH_STATUS) {
            return TIMEOUT_ATTACH_STATUS;
        }
        return requested;
    }

    /** 超时毫秒数（附件金额）。 */
    public static long resolveTimeoutAttachAmount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_ATTACH_AMOUNT;
        }
        if (requested > TIMEOUT_ATTACH_AMOUNT) {
            return TIMEOUT_ATTACH_AMOUNT;
        }
        return requested;
    }

    /** 超时毫秒数（附件数量）。 */
    public static long resolveTimeoutAttachCount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_ATTACH_COUNT;
        }
        if (requested > TIMEOUT_ATTACH_COUNT) {
            return TIMEOUT_ATTACH_COUNT;
        }
        return requested;
    }

    /** 超时毫秒数（附件比率）。 */
    public static long resolveTimeoutAttachRate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_ATTACH_RATE;
        }
        if (requested > TIMEOUT_ATTACH_RATE) {
            return TIMEOUT_ATTACH_RATE;
        }
        return requested;
    }

}

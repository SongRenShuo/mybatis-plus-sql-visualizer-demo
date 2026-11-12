package cn.song.custmetadata.config;

/**
 * 客户来源JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustSourceJobConfig {

    public static final String MODULE_CODE = "CUST_SOURCE_JOB_CONFIG";

    /** 重试次数（附件比率） */
    public static final long RETRY_ATTACH_RATE = 5L;

    /** 重试次数（附件日期） */
    public static final long RETRY_ATTACH_DATE = 10L;

    /** 重试次数（附件时间） */
    public static final long RETRY_ATTACH_TIME = 15L;

    /** 重试次数（附件标记） */
    public static final long RETRY_ATTACH_FLAG = 20L;

    /** 重试次数（附件说明） */
    public static final long RETRY_ATTACH_REMARK = 25L;

    /** 重试次数（附件来源） */
    public static final long RETRY_ATTACH_SOURCE = 30L;

    /** 重试次数（附件版本） */
    public static final long RETRY_ATTACH_VERSION = 35L;

    /** 重试次数（附件区域） */
    public static final long RETRY_ATTACH_REGION = 40L;

    /** 重试次数（附件渠道） */
    public static final long RETRY_ATTACH_CHANNEL = 45L;

    /** 重试次数（附件分组） */
    public static final long RETRY_ATTACH_GROUP = 50L;

    /** 重试次数（附件标签） */
    public static final long RETRY_ATTACH_TAG = 55L;

    /** 重试次数（附件负责人） */
    public static final long RETRY_ATTACH_OWNER = 60L;

    /** 重试次数（备注编号） */
    public static final long RETRY_NOTE_NO = 65L;

    /** 重试次数（备注名称） */
    public static final long RETRY_NOTE_NAME = 70L;

    /** 重试次数（备注类型） */
    public static final long RETRY_NOTE_TYPE = 75L;

    /** 重试次数（备注编码） */
    public static final long RETRY_NOTE_CODE = 80L;

    /** 重试次数（备注级别） */
    public static final long RETRY_NOTE_LEVEL = 85L;

    /** 重试次数（备注状态） */
    public static final long RETRY_NOTE_STATUS = 90L;

    /** 重试次数（备注金额） */
    public static final long RETRY_NOTE_AMOUNT = 95L;

    /** 重试次数（备注数量） */
    public static final long RETRY_NOTE_COUNT = 100L;

    /** 重试次数（备注比率） */
    public static final long RETRY_NOTE_RATE = 105L;

    /** 重试次数（备注日期） */
    public static final long RETRY_NOTE_DATE = 110L;

    /** 重试次数（备注时间） */
    public static final long RETRY_NOTE_TIME = 115L;

    /** 重试次数（备注标记） */
    public static final long RETRY_NOTE_FLAG = 120L;

    /** 重试次数（备注说明） */
    public static final long RETRY_NOTE_REMARK = 125L;

    /** 重试次数（备注来源） */
    public static final long RETRY_NOTE_SOURCE = 130L;

    /** 重试次数（备注版本） */
    public static final long RETRY_NOTE_VERSION = 135L;

    /** 重试次数（备注区域） */
    public static final long RETRY_NOTE_REGION = 140L;

    /** 重试次数（备注渠道） */
    public static final long RETRY_NOTE_CHANNEL = 145L;

    /** 重试次数（备注分组） */
    public static final long RETRY_NOTE_GROUP = 150L;

    /** 重试次数（备注标签） */
    public static final long RETRY_NOTE_TAG = 155L;

    /** 重试次数（备注负责人） */
    public static final long RETRY_NOTE_OWNER = 160L;

    /** 重试次数（偏好编号） */
    public static final long RETRY_PREFER_NO = 165L;

    /** 重试次数（偏好名称） */
    public static final long RETRY_PREFER_NAME = 170L;

    /** 重试次数（偏好类型） */
    public static final long RETRY_PREFER_TYPE = 175L;

    /** 重试次数（偏好编码） */
    public static final long RETRY_PREFER_CODE = 180L;

    /** 重试次数（偏好级别） */
    public static final long RETRY_PREFER_LEVEL = 185L;

    /** 重试次数（偏好状态） */
    public static final long RETRY_PREFER_STATUS = 190L;

    /** 重试次数（偏好金额） */
    public static final long RETRY_PREFER_AMOUNT = 195L;

    /** 重试次数（偏好数量） */
    public static final long RETRY_PREFER_COUNT = 200L;

    /** 重试次数（偏好比率） */
    public static final long RETRY_PREFER_RATE = 205L;

    /** 重试次数（偏好日期） */
    public static final long RETRY_PREFER_DATE = 210L;

    /** 重试次数（偏好时间） */
    public static final long RETRY_PREFER_TIME = 215L;

    /** 重试次数（偏好标记） */
    public static final long RETRY_PREFER_FLAG = 220L;

    /** 重试次数（偏好说明） */
    public static final long RETRY_PREFER_REMARK = 225L;

    /** 重试次数（偏好来源） */
    public static final long RETRY_PREFER_SOURCE = 230L;

    /** 重试次数（偏好版本） */
    public static final long RETRY_PREFER_VERSION = 235L;

    /** 重试次数（偏好区域） */
    public static final long RETRY_PREFER_REGION = 240L;

    /** 重试次数（偏好渠道） */
    public static final long RETRY_PREFER_CHANNEL = 245L;

    /** 重试次数（偏好分组） */
    public static final long RETRY_PREFER_GROUP = 250L;

    /** 重试次数（偏好标签） */
    public static final long RETRY_PREFER_TAG = 255L;

    /** 重试次数（偏好负责人） */
    public static final long RETRY_PREFER_OWNER = 260L;

    /** 重试次数（评分编号） */
    public static final long RETRY_SCORE_NO = 265L;

    /** 重试次数（评分名称） */
    public static final long RETRY_SCORE_NAME = 270L;

    /** 重试次数（评分类型） */
    public static final long RETRY_SCORE_TYPE = 275L;

    /** 重试次数（评分编码） */
    public static final long RETRY_SCORE_CODE = 280L;

    /** 重试次数（评分级别） */
    public static final long RETRY_SCORE_LEVEL = 285L;

    /** 重试次数（评分状态） */
    public static final long RETRY_SCORE_STATUS = 290L;

    /** 重试次数（评分金额） */
    public static final long RETRY_SCORE_AMOUNT = 295L;

    /** 重试次数（评分数量） */
    public static final long RETRY_SCORE_COUNT = 300L;

    private CustSourceJobConfig() {
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

    /** 重试次数（附件区域）。 */
    public static long resolveRetryAttachRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_REGION;
        }
        if (requested > RETRY_ATTACH_REGION) {
            return RETRY_ATTACH_REGION;
        }
        return requested;
    }

    /** 重试次数（附件渠道）。 */
    public static long resolveRetryAttachChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_CHANNEL;
        }
        if (requested > RETRY_ATTACH_CHANNEL) {
            return RETRY_ATTACH_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（附件分组）。 */
    public static long resolveRetryAttachGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_GROUP;
        }
        if (requested > RETRY_ATTACH_GROUP) {
            return RETRY_ATTACH_GROUP;
        }
        return requested;
    }

    /** 重试次数（附件标签）。 */
    public static long resolveRetryAttachTag(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_TAG;
        }
        if (requested > RETRY_ATTACH_TAG) {
            return RETRY_ATTACH_TAG;
        }
        return requested;
    }

    /** 重试次数（附件负责人）。 */
    public static long resolveRetryAttachOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_ATTACH_OWNER;
        }
        if (requested > RETRY_ATTACH_OWNER) {
            return RETRY_ATTACH_OWNER;
        }
        return requested;
    }

    /** 重试次数（备注编号）。 */
    public static long resolveRetryNoteNo(long requested) {
        if (requested <= 0L) {
            return RETRY_NOTE_NO;
        }
        if (requested > RETRY_NOTE_NO) {
            return RETRY_NOTE_NO;
        }
        return requested;
    }

    /** 重试次数（备注名称）。 */
    public static long resolveRetryNoteName(long requested) {
        if (requested <= 0L) {
            return RETRY_NOTE_NAME;
        }
        if (requested > RETRY_NOTE_NAME) {
            return RETRY_NOTE_NAME;
        }
        return requested;
    }

    /** 重试次数（备注类型）。 */
    public static long resolveRetryNoteType(long requested) {
        if (requested <= 0L) {
            return RETRY_NOTE_TYPE;
        }
        if (requested > RETRY_NOTE_TYPE) {
            return RETRY_NOTE_TYPE;
        }
        return requested;
    }

    /** 重试次数（备注编码）。 */
    public static long resolveRetryNoteCode(long requested) {
        if (requested <= 0L) {
            return RETRY_NOTE_CODE;
        }
        if (requested > RETRY_NOTE_CODE) {
            return RETRY_NOTE_CODE;
        }
        return requested;
    }

    /** 重试次数（备注级别）。 */
    public static long resolveRetryNoteLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_NOTE_LEVEL;
        }
        if (requested > RETRY_NOTE_LEVEL) {
            return RETRY_NOTE_LEVEL;
        }
        return requested;
    }

    /** 重试次数（备注状态）。 */
    public static long resolveRetryNoteStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_NOTE_STATUS;
        }
        if (requested > RETRY_NOTE_STATUS) {
            return RETRY_NOTE_STATUS;
        }
        return requested;
    }

    /** 重试次数（备注金额）。 */
    public static long resolveRetryNoteAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_NOTE_AMOUNT;
        }
        if (requested > RETRY_NOTE_AMOUNT) {
            return RETRY_NOTE_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（备注数量）。 */
    public static long resolveRetryNoteCount(long requested) {
        if (requested <= 0L) {
            return RETRY_NOTE_COUNT;
        }
        if (requested > RETRY_NOTE_COUNT) {
            return RETRY_NOTE_COUNT;
        }
        return requested;
    }

}

package cn.song.custmetadata.config;

/**
 * 客户群组ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustGroupModuleConfig {

    public static final String MODULE_CODE = "CUST_GROUP";

    /** 单次查询上限（备注比率） */
    public static final long LIMIT_NOTE_RATE = 5L;

    /** 单次查询上限（备注日期） */
    public static final long LIMIT_NOTE_DATE = 10L;

    /** 单次查询上限（备注时间） */
    public static final long LIMIT_NOTE_TIME = 15L;

    /** 单次查询上限（备注标记） */
    public static final long LIMIT_NOTE_FLAG = 20L;

    /** 单次查询上限（备注说明） */
    public static final long LIMIT_NOTE_REMARK = 25L;

    /** 单次查询上限（备注来源） */
    public static final long LIMIT_NOTE_SOURCE = 30L;

    /** 单次查询上限（备注版本） */
    public static final long LIMIT_NOTE_VERSION = 35L;

    /** 单次查询上限（备注区域） */
    public static final long LIMIT_NOTE_REGION = 40L;

    /** 单次查询上限（备注渠道） */
    public static final long LIMIT_NOTE_CHANNEL = 45L;

    /** 单次查询上限（备注分组） */
    public static final long LIMIT_NOTE_GROUP = 50L;

    /** 单次查询上限（备注标签） */
    public static final long LIMIT_NOTE_TAG = 55L;

    /** 单次查询上限（备注负责人） */
    public static final long LIMIT_NOTE_OWNER = 60L;

    /** 单次查询上限（偏好编号） */
    public static final long LIMIT_PREFER_NO = 65L;

    /** 单次查询上限（偏好名称） */
    public static final long LIMIT_PREFER_NAME = 70L;

    /** 单次查询上限（偏好类型） */
    public static final long LIMIT_PREFER_TYPE = 75L;

    /** 单次查询上限（偏好编码） */
    public static final long LIMIT_PREFER_CODE = 80L;

    /** 单次查询上限（偏好级别） */
    public static final long LIMIT_PREFER_LEVEL = 85L;

    /** 单次查询上限（偏好状态） */
    public static final long LIMIT_PREFER_STATUS = 90L;

    /** 单次查询上限（偏好金额） */
    public static final long LIMIT_PREFER_AMOUNT = 95L;

    /** 单次查询上限（偏好数量） */
    public static final long LIMIT_PREFER_COUNT = 100L;

    /** 单次查询上限（偏好比率） */
    public static final long LIMIT_PREFER_RATE = 105L;

    /** 单次查询上限（偏好日期） */
    public static final long LIMIT_PREFER_DATE = 110L;

    /** 单次查询上限（偏好时间） */
    public static final long LIMIT_PREFER_TIME = 115L;

    /** 单次查询上限（偏好标记） */
    public static final long LIMIT_PREFER_FLAG = 120L;

    /** 单次查询上限（偏好说明） */
    public static final long LIMIT_PREFER_REMARK = 125L;

    /** 单次查询上限（偏好来源） */
    public static final long LIMIT_PREFER_SOURCE = 130L;

    /** 单次查询上限（偏好版本） */
    public static final long LIMIT_PREFER_VERSION = 135L;

    /** 单次查询上限（偏好区域） */
    public static final long LIMIT_PREFER_REGION = 140L;

    /** 单次查询上限（偏好渠道） */
    public static final long LIMIT_PREFER_CHANNEL = 145L;

    /** 单次查询上限（偏好分组） */
    public static final long LIMIT_PREFER_GROUP = 150L;

    /** 单次查询上限（偏好标签） */
    public static final long LIMIT_PREFER_TAG = 155L;

    /** 单次查询上限（偏好负责人） */
    public static final long LIMIT_PREFER_OWNER = 160L;

    /** 单次查询上限（评分编号） */
    public static final long LIMIT_SCORE_NO = 165L;

    /** 单次查询上限（评分名称） */
    public static final long LIMIT_SCORE_NAME = 170L;

    /** 单次查询上限（评分类型） */
    public static final long LIMIT_SCORE_TYPE = 175L;

    /** 单次查询上限（评分编码） */
    public static final long LIMIT_SCORE_CODE = 180L;

    /** 单次查询上限（评分级别） */
    public static final long LIMIT_SCORE_LEVEL = 185L;

    /** 单次查询上限（评分状态） */
    public static final long LIMIT_SCORE_STATUS = 190L;

    /** 单次查询上限（评分金额） */
    public static final long LIMIT_SCORE_AMOUNT = 195L;

    /** 单次查询上限（评分数量） */
    public static final long LIMIT_SCORE_COUNT = 200L;

    /** 单次查询上限（评分比率） */
    public static final long LIMIT_SCORE_RATE = 205L;

    /** 单次查询上限（评分日期） */
    public static final long LIMIT_SCORE_DATE = 210L;

    /** 单次查询上限（评分时间） */
    public static final long LIMIT_SCORE_TIME = 215L;

    /** 单次查询上限（评分标记） */
    public static final long LIMIT_SCORE_FLAG = 220L;

    /** 单次查询上限（评分说明） */
    public static final long LIMIT_SCORE_REMARK = 225L;

    /** 单次查询上限（评分来源） */
    public static final long LIMIT_SCORE_SOURCE = 230L;

    /** 单次查询上限（评分版本） */
    public static final long LIMIT_SCORE_VERSION = 235L;

    /** 单次查询上限（评分区域） */
    public static final long LIMIT_SCORE_REGION = 240L;

    /** 单次查询上限（评分渠道） */
    public static final long LIMIT_SCORE_CHANNEL = 245L;

    /** 单次查询上限（评分分组） */
    public static final long LIMIT_SCORE_GROUP = 250L;

    /** 单次查询上限（评分标签） */
    public static final long LIMIT_SCORE_TAG = 255L;

    /** 单次查询上限（评分负责人） */
    public static final long LIMIT_SCORE_OWNER = 260L;

    /** 超时毫秒数（客户编号） */
    public static final long TIMEOUT_CUST_NO = 265L;

    /** 超时毫秒数（客户名称） */
    public static final long TIMEOUT_CUST_NAME = 270L;

    /** 超时毫秒数（客户类型） */
    public static final long TIMEOUT_CUST_TYPE = 275L;

    /** 超时毫秒数（客户编码） */
    public static final long TIMEOUT_CUST_CODE = 280L;

    /** 超时毫秒数（客户级别） */
    public static final long TIMEOUT_CUST_LEVEL = 285L;

    /** 超时毫秒数（客户状态） */
    public static final long TIMEOUT_CUST_STATUS = 290L;

    /** 超时毫秒数（客户金额） */
    public static final long TIMEOUT_CUST_AMOUNT = 295L;

    /** 超时毫秒数（客户数量） */
    public static final long TIMEOUT_CUST_COUNT = 300L;

    private CustGroupModuleConfig() {
    }

    /** 单次查询上限（备注比率）。 */
    public static long resolveLimitNoteRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_RATE;
        }
        if (requested > LIMIT_NOTE_RATE) {
            return LIMIT_NOTE_RATE;
        }
        return requested;
    }

    /** 单次查询上限（备注日期）。 */
    public static long resolveLimitNoteDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_DATE;
        }
        if (requested > LIMIT_NOTE_DATE) {
            return LIMIT_NOTE_DATE;
        }
        return requested;
    }

    /** 单次查询上限（备注时间）。 */
    public static long resolveLimitNoteTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_TIME;
        }
        if (requested > LIMIT_NOTE_TIME) {
            return LIMIT_NOTE_TIME;
        }
        return requested;
    }

    /** 单次查询上限（备注标记）。 */
    public static long resolveLimitNoteFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_FLAG;
        }
        if (requested > LIMIT_NOTE_FLAG) {
            return LIMIT_NOTE_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（备注说明）。 */
    public static long resolveLimitNoteRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_REMARK;
        }
        if (requested > LIMIT_NOTE_REMARK) {
            return LIMIT_NOTE_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（备注来源）。 */
    public static long resolveLimitNoteSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_SOURCE;
        }
        if (requested > LIMIT_NOTE_SOURCE) {
            return LIMIT_NOTE_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（备注版本）。 */
    public static long resolveLimitNoteVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_VERSION;
        }
        if (requested > LIMIT_NOTE_VERSION) {
            return LIMIT_NOTE_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（备注区域）。 */
    public static long resolveLimitNoteRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_REGION;
        }
        if (requested > LIMIT_NOTE_REGION) {
            return LIMIT_NOTE_REGION;
        }
        return requested;
    }

    /** 单次查询上限（备注渠道）。 */
    public static long resolveLimitNoteChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_CHANNEL;
        }
        if (requested > LIMIT_NOTE_CHANNEL) {
            return LIMIT_NOTE_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（备注分组）。 */
    public static long resolveLimitNoteGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_GROUP;
        }
        if (requested > LIMIT_NOTE_GROUP) {
            return LIMIT_NOTE_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（备注标签）。 */
    public static long resolveLimitNoteTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_TAG;
        }
        if (requested > LIMIT_NOTE_TAG) {
            return LIMIT_NOTE_TAG;
        }
        return requested;
    }

    /** 单次查询上限（备注负责人）。 */
    public static long resolveLimitNoteOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_NOTE_OWNER;
        }
        if (requested > LIMIT_NOTE_OWNER) {
            return LIMIT_NOTE_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（偏好编号）。 */
    public static long resolveLimitPreferNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_NO;
        }
        if (requested > LIMIT_PREFER_NO) {
            return LIMIT_PREFER_NO;
        }
        return requested;
    }

    /** 单次查询上限（偏好名称）。 */
    public static long resolveLimitPreferName(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_NAME;
        }
        if (requested > LIMIT_PREFER_NAME) {
            return LIMIT_PREFER_NAME;
        }
        return requested;
    }

    /** 单次查询上限（偏好类型）。 */
    public static long resolveLimitPreferType(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_TYPE;
        }
        if (requested > LIMIT_PREFER_TYPE) {
            return LIMIT_PREFER_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（偏好编码）。 */
    public static long resolveLimitPreferCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_CODE;
        }
        if (requested > LIMIT_PREFER_CODE) {
            return LIMIT_PREFER_CODE;
        }
        return requested;
    }

    /** 单次查询上限（偏好级别）。 */
    public static long resolveLimitPreferLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_LEVEL;
        }
        if (requested > LIMIT_PREFER_LEVEL) {
            return LIMIT_PREFER_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（偏好状态）。 */
    public static long resolveLimitPreferStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_STATUS;
        }
        if (requested > LIMIT_PREFER_STATUS) {
            return LIMIT_PREFER_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（偏好金额）。 */
    public static long resolveLimitPreferAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_AMOUNT;
        }
        if (requested > LIMIT_PREFER_AMOUNT) {
            return LIMIT_PREFER_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（偏好数量）。 */
    public static long resolveLimitPreferCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_PREFER_COUNT;
        }
        if (requested > LIMIT_PREFER_COUNT) {
            return LIMIT_PREFER_COUNT;
        }
        return requested;
    }

}

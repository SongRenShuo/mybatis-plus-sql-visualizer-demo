package cn.song.custmetadata.config;

/**
 * 客户风险评估ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustRiskEvalModuleConfig {

    public static final String MODULE_CODE = "CUST_RISK_EVAL";

    /** 超时毫秒数（备注版本） */
    public static final long TIMEOUT_NOTE_VERSION = 5L;

    /** 超时毫秒数（备注区域） */
    public static final long TIMEOUT_NOTE_REGION = 10L;

    /** 超时毫秒数（备注渠道） */
    public static final long TIMEOUT_NOTE_CHANNEL = 15L;

    /** 超时毫秒数（备注分组） */
    public static final long TIMEOUT_NOTE_GROUP = 20L;

    /** 超时毫秒数（备注标签） */
    public static final long TIMEOUT_NOTE_TAG = 25L;

    /** 超时毫秒数（备注负责人） */
    public static final long TIMEOUT_NOTE_OWNER = 30L;

    /** 超时毫秒数（偏好编号） */
    public static final long TIMEOUT_PREFER_NO = 35L;

    /** 超时毫秒数（偏好名称） */
    public static final long TIMEOUT_PREFER_NAME = 40L;

    /** 超时毫秒数（偏好类型） */
    public static final long TIMEOUT_PREFER_TYPE = 45L;

    /** 超时毫秒数（偏好编码） */
    public static final long TIMEOUT_PREFER_CODE = 50L;

    /** 超时毫秒数（偏好级别） */
    public static final long TIMEOUT_PREFER_LEVEL = 55L;

    /** 超时毫秒数（偏好状态） */
    public static final long TIMEOUT_PREFER_STATUS = 60L;

    /** 超时毫秒数（偏好金额） */
    public static final long TIMEOUT_PREFER_AMOUNT = 65L;

    /** 超时毫秒数（偏好数量） */
    public static final long TIMEOUT_PREFER_COUNT = 70L;

    /** 超时毫秒数（偏好比率） */
    public static final long TIMEOUT_PREFER_RATE = 75L;

    /** 超时毫秒数（偏好日期） */
    public static final long TIMEOUT_PREFER_DATE = 80L;

    /** 超时毫秒数（偏好时间） */
    public static final long TIMEOUT_PREFER_TIME = 85L;

    /** 超时毫秒数（偏好标记） */
    public static final long TIMEOUT_PREFER_FLAG = 90L;

    /** 超时毫秒数（偏好说明） */
    public static final long TIMEOUT_PREFER_REMARK = 95L;

    /** 超时毫秒数（偏好来源） */
    public static final long TIMEOUT_PREFER_SOURCE = 100L;

    /** 超时毫秒数（偏好版本） */
    public static final long TIMEOUT_PREFER_VERSION = 105L;

    /** 超时毫秒数（偏好区域） */
    public static final long TIMEOUT_PREFER_REGION = 110L;

    /** 超时毫秒数（偏好渠道） */
    public static final long TIMEOUT_PREFER_CHANNEL = 115L;

    /** 超时毫秒数（偏好分组） */
    public static final long TIMEOUT_PREFER_GROUP = 120L;

    /** 超时毫秒数（偏好标签） */
    public static final long TIMEOUT_PREFER_TAG = 125L;

    /** 超时毫秒数（偏好负责人） */
    public static final long TIMEOUT_PREFER_OWNER = 130L;

    /** 超时毫秒数（评分编号） */
    public static final long TIMEOUT_SCORE_NO = 135L;

    /** 超时毫秒数（评分名称） */
    public static final long TIMEOUT_SCORE_NAME = 140L;

    /** 超时毫秒数（评分类型） */
    public static final long TIMEOUT_SCORE_TYPE = 145L;

    /** 超时毫秒数（评分编码） */
    public static final long TIMEOUT_SCORE_CODE = 150L;

    /** 超时毫秒数（评分级别） */
    public static final long TIMEOUT_SCORE_LEVEL = 155L;

    /** 超时毫秒数（评分状态） */
    public static final long TIMEOUT_SCORE_STATUS = 160L;

    /** 超时毫秒数（评分金额） */
    public static final long TIMEOUT_SCORE_AMOUNT = 165L;

    /** 超时毫秒数（评分数量） */
    public static final long TIMEOUT_SCORE_COUNT = 170L;

    /** 超时毫秒数（评分比率） */
    public static final long TIMEOUT_SCORE_RATE = 175L;

    /** 超时毫秒数（评分日期） */
    public static final long TIMEOUT_SCORE_DATE = 180L;

    /** 超时毫秒数（评分时间） */
    public static final long TIMEOUT_SCORE_TIME = 185L;

    /** 超时毫秒数（评分标记） */
    public static final long TIMEOUT_SCORE_FLAG = 190L;

    /** 超时毫秒数（评分说明） */
    public static final long TIMEOUT_SCORE_REMARK = 195L;

    /** 超时毫秒数（评分来源） */
    public static final long TIMEOUT_SCORE_SOURCE = 200L;

    /** 超时毫秒数（评分版本） */
    public static final long TIMEOUT_SCORE_VERSION = 205L;

    /** 超时毫秒数（评分区域） */
    public static final long TIMEOUT_SCORE_REGION = 210L;

    /** 超时毫秒数（评分渠道） */
    public static final long TIMEOUT_SCORE_CHANNEL = 215L;

    /** 超时毫秒数（评分分组） */
    public static final long TIMEOUT_SCORE_GROUP = 220L;

    /** 超时毫秒数（评分标签） */
    public static final long TIMEOUT_SCORE_TAG = 225L;

    /** 超时毫秒数（评分负责人） */
    public static final long TIMEOUT_SCORE_OWNER = 230L;

    /** 重试次数（客户编号） */
    public static final long RETRY_CUST_NO = 235L;

    /** 重试次数（客户名称） */
    public static final long RETRY_CUST_NAME = 240L;

    /** 重试次数（客户类型） */
    public static final long RETRY_CUST_TYPE = 245L;

    /** 重试次数（客户编码） */
    public static final long RETRY_CUST_CODE = 250L;

    /** 重试次数（客户级别） */
    public static final long RETRY_CUST_LEVEL = 255L;

    /** 重试次数（客户状态） */
    public static final long RETRY_CUST_STATUS = 260L;

    /** 重试次数（客户金额） */
    public static final long RETRY_CUST_AMOUNT = 265L;

    /** 重试次数（客户数量） */
    public static final long RETRY_CUST_COUNT = 270L;

    /** 重试次数（客户比率） */
    public static final long RETRY_CUST_RATE = 275L;

    /** 重试次数（客户日期） */
    public static final long RETRY_CUST_DATE = 280L;

    /** 重试次数（客户时间） */
    public static final long RETRY_CUST_TIME = 285L;

    /** 重试次数（客户标记） */
    public static final long RETRY_CUST_FLAG = 290L;

    /** 重试次数（客户说明） */
    public static final long RETRY_CUST_REMARK = 295L;

    /** 重试次数（客户来源） */
    public static final long RETRY_CUST_SOURCE = 300L;

    private CustRiskEvalModuleConfig() {
    }

    /** 超时毫秒数（备注版本）。 */
    public static long resolveTimeoutNoteVersion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_NOTE_VERSION;
        }
        if (requested > TIMEOUT_NOTE_VERSION) {
            return TIMEOUT_NOTE_VERSION;
        }
        return requested;
    }

    /** 超时毫秒数（备注区域）。 */
    public static long resolveTimeoutNoteRegion(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_NOTE_REGION;
        }
        if (requested > TIMEOUT_NOTE_REGION) {
            return TIMEOUT_NOTE_REGION;
        }
        return requested;
    }

    /** 超时毫秒数（备注渠道）。 */
    public static long resolveTimeoutNoteChannel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_NOTE_CHANNEL;
        }
        if (requested > TIMEOUT_NOTE_CHANNEL) {
            return TIMEOUT_NOTE_CHANNEL;
        }
        return requested;
    }

    /** 超时毫秒数（备注分组）。 */
    public static long resolveTimeoutNoteGroup(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_NOTE_GROUP;
        }
        if (requested > TIMEOUT_NOTE_GROUP) {
            return TIMEOUT_NOTE_GROUP;
        }
        return requested;
    }

    /** 超时毫秒数（备注标签）。 */
    public static long resolveTimeoutNoteTag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_NOTE_TAG;
        }
        if (requested > TIMEOUT_NOTE_TAG) {
            return TIMEOUT_NOTE_TAG;
        }
        return requested;
    }

    /** 超时毫秒数（备注负责人）。 */
    public static long resolveTimeoutNoteOwner(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_NOTE_OWNER;
        }
        if (requested > TIMEOUT_NOTE_OWNER) {
            return TIMEOUT_NOTE_OWNER;
        }
        return requested;
    }

    /** 超时毫秒数（偏好编号）。 */
    public static long resolveTimeoutPreferNo(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_NO;
        }
        if (requested > TIMEOUT_PREFER_NO) {
            return TIMEOUT_PREFER_NO;
        }
        return requested;
    }

    /** 超时毫秒数（偏好名称）。 */
    public static long resolveTimeoutPreferName(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_NAME;
        }
        if (requested > TIMEOUT_PREFER_NAME) {
            return TIMEOUT_PREFER_NAME;
        }
        return requested;
    }

    /** 超时毫秒数（偏好类型）。 */
    public static long resolveTimeoutPreferType(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_TYPE;
        }
        if (requested > TIMEOUT_PREFER_TYPE) {
            return TIMEOUT_PREFER_TYPE;
        }
        return requested;
    }

    /** 超时毫秒数（偏好编码）。 */
    public static long resolveTimeoutPreferCode(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_CODE;
        }
        if (requested > TIMEOUT_PREFER_CODE) {
            return TIMEOUT_PREFER_CODE;
        }
        return requested;
    }

    /** 超时毫秒数（偏好级别）。 */
    public static long resolveTimeoutPreferLevel(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_LEVEL;
        }
        if (requested > TIMEOUT_PREFER_LEVEL) {
            return TIMEOUT_PREFER_LEVEL;
        }
        return requested;
    }

    /** 超时毫秒数（偏好状态）。 */
    public static long resolveTimeoutPreferStatus(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_STATUS;
        }
        if (requested > TIMEOUT_PREFER_STATUS) {
            return TIMEOUT_PREFER_STATUS;
        }
        return requested;
    }

    /** 超时毫秒数（偏好金额）。 */
    public static long resolveTimeoutPreferAmount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_AMOUNT;
        }
        if (requested > TIMEOUT_PREFER_AMOUNT) {
            return TIMEOUT_PREFER_AMOUNT;
        }
        return requested;
    }

    /** 超时毫秒数（偏好数量）。 */
    public static long resolveTimeoutPreferCount(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_COUNT;
        }
        if (requested > TIMEOUT_PREFER_COUNT) {
            return TIMEOUT_PREFER_COUNT;
        }
        return requested;
    }

    /** 超时毫秒数（偏好比率）。 */
    public static long resolveTimeoutPreferRate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_RATE;
        }
        if (requested > TIMEOUT_PREFER_RATE) {
            return TIMEOUT_PREFER_RATE;
        }
        return requested;
    }

    /** 超时毫秒数（偏好日期）。 */
    public static long resolveTimeoutPreferDate(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_DATE;
        }
        if (requested > TIMEOUT_PREFER_DATE) {
            return TIMEOUT_PREFER_DATE;
        }
        return requested;
    }

    /** 超时毫秒数（偏好时间）。 */
    public static long resolveTimeoutPreferTime(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_TIME;
        }
        if (requested > TIMEOUT_PREFER_TIME) {
            return TIMEOUT_PREFER_TIME;
        }
        return requested;
    }

    /** 超时毫秒数（偏好标记）。 */
    public static long resolveTimeoutPreferFlag(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_FLAG;
        }
        if (requested > TIMEOUT_PREFER_FLAG) {
            return TIMEOUT_PREFER_FLAG;
        }
        return requested;
    }

    /** 超时毫秒数（偏好说明）。 */
    public static long resolveTimeoutPreferRemark(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_REMARK;
        }
        if (requested > TIMEOUT_PREFER_REMARK) {
            return TIMEOUT_PREFER_REMARK;
        }
        return requested;
    }

    /** 超时毫秒数（偏好来源）。 */
    public static long resolveTimeoutPreferSource(long requested) {
        if (requested <= 0L) {
            return TIMEOUT_PREFER_SOURCE;
        }
        if (requested > TIMEOUT_PREFER_SOURCE) {
            return TIMEOUT_PREFER_SOURCE;
        }
        return requested;
    }

}

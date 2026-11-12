package cn.song.custmetadata.config;

/**
 * 客户经理关系CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustManagerRelCacheConfig {

    public static final String MODULE_CODE = "CUST_MANAGER_REL_CACHE_CONFIG";

    /** 缓存秒数（风险日期） */
    public static final long CACHE_RISK_DATE = 5L;

    /** 缓存秒数（风险时间） */
    public static final long CACHE_RISK_TIME = 10L;

    /** 缓存秒数（风险标记） */
    public static final long CACHE_RISK_FLAG = 15L;

    /** 缓存秒数（风险说明） */
    public static final long CACHE_RISK_REMARK = 20L;

    /** 缓存秒数（风险来源） */
    public static final long CACHE_RISK_SOURCE = 25L;

    /** 缓存秒数（风险版本） */
    public static final long CACHE_RISK_VERSION = 30L;

    /** 缓存秒数（风险区域） */
    public static final long CACHE_RISK_REGION = 35L;

    /** 缓存秒数（风险渠道） */
    public static final long CACHE_RISK_CHANNEL = 40L;

    /** 缓存秒数（风险分组） */
    public static final long CACHE_RISK_GROUP = 45L;

    /** 缓存秒数（风险标签） */
    public static final long CACHE_RISK_TAG = 50L;

    /** 缓存秒数（风险负责人） */
    public static final long CACHE_RISK_OWNER = 55L;

    /** 缓存秒数（信用编号） */
    public static final long CACHE_CREDIT_NO = 60L;

    /** 缓存秒数（信用名称） */
    public static final long CACHE_CREDIT_NAME = 65L;

    /** 缓存秒数（信用类型） */
    public static final long CACHE_CREDIT_TYPE = 70L;

    /** 缓存秒数（信用编码） */
    public static final long CACHE_CREDIT_CODE = 75L;

    /** 缓存秒数（信用级别） */
    public static final long CACHE_CREDIT_LEVEL = 80L;

    /** 缓存秒数（信用状态） */
    public static final long CACHE_CREDIT_STATUS = 85L;

    /** 缓存秒数（信用金额） */
    public static final long CACHE_CREDIT_AMOUNT = 90L;

    /** 缓存秒数（信用数量） */
    public static final long CACHE_CREDIT_COUNT = 95L;

    /** 缓存秒数（信用比率） */
    public static final long CACHE_CREDIT_RATE = 100L;

    /** 缓存秒数（信用日期） */
    public static final long CACHE_CREDIT_DATE = 105L;

    /** 缓存秒数（信用时间） */
    public static final long CACHE_CREDIT_TIME = 110L;

    /** 缓存秒数（信用标记） */
    public static final long CACHE_CREDIT_FLAG = 115L;

    /** 缓存秒数（信用说明） */
    public static final long CACHE_CREDIT_REMARK = 120L;

    /** 缓存秒数（信用来源） */
    public static final long CACHE_CREDIT_SOURCE = 125L;

    /** 缓存秒数（信用版本） */
    public static final long CACHE_CREDIT_VERSION = 130L;

    /** 缓存秒数（信用区域） */
    public static final long CACHE_CREDIT_REGION = 135L;

    /** 缓存秒数（信用渠道） */
    public static final long CACHE_CREDIT_CHANNEL = 140L;

    /** 缓存秒数（信用分组） */
    public static final long CACHE_CREDIT_GROUP = 145L;

    /** 缓存秒数（信用标签） */
    public static final long CACHE_CREDIT_TAG = 150L;

    /** 缓存秒数（信用负责人） */
    public static final long CACHE_CREDIT_OWNER = 155L;

    /** 缓存秒数（行业编号） */
    public static final long CACHE_INDUSTRY_NO = 160L;

    /** 缓存秒数（行业名称） */
    public static final long CACHE_INDUSTRY_NAME = 165L;

    /** 缓存秒数（行业类型） */
    public static final long CACHE_INDUSTRY_TYPE = 170L;

    /** 缓存秒数（行业编码） */
    public static final long CACHE_INDUSTRY_CODE = 175L;

    /** 缓存秒数（行业级别） */
    public static final long CACHE_INDUSTRY_LEVEL = 180L;

    /** 缓存秒数（行业状态） */
    public static final long CACHE_INDUSTRY_STATUS = 185L;

    /** 缓存秒数（行业金额） */
    public static final long CACHE_INDUSTRY_AMOUNT = 190L;

    /** 缓存秒数（行业数量） */
    public static final long CACHE_INDUSTRY_COUNT = 195L;

    /** 缓存秒数（行业比率） */
    public static final long CACHE_INDUSTRY_RATE = 200L;

    /** 缓存秒数（行业日期） */
    public static final long CACHE_INDUSTRY_DATE = 205L;

    /** 缓存秒数（行业时间） */
    public static final long CACHE_INDUSTRY_TIME = 210L;

    /** 缓存秒数（行业标记） */
    public static final long CACHE_INDUSTRY_FLAG = 215L;

    /** 缓存秒数（行业说明） */
    public static final long CACHE_INDUSTRY_REMARK = 220L;

    /** 缓存秒数（行业来源） */
    public static final long CACHE_INDUSTRY_SOURCE = 225L;

    /** 缓存秒数（行业版本） */
    public static final long CACHE_INDUSTRY_VERSION = 230L;

    /** 缓存秒数（行业区域） */
    public static final long CACHE_INDUSTRY_REGION = 235L;

    /** 缓存秒数（行业渠道） */
    public static final long CACHE_INDUSTRY_CHANNEL = 240L;

    /** 缓存秒数（行业分组） */
    public static final long CACHE_INDUSTRY_GROUP = 245L;

    /** 缓存秒数（行业标签） */
    public static final long CACHE_INDUSTRY_TAG = 250L;

    /** 缓存秒数（行业负责人） */
    public static final long CACHE_INDUSTRY_OWNER = 255L;

    /** 缓存秒数（渠道编号） */
    public static final long CACHE_CHANNEL_NO = 260L;

    /** 缓存秒数（渠道名称） */
    public static final long CACHE_CHANNEL_NAME = 265L;

    /** 缓存秒数（渠道类型） */
    public static final long CACHE_CHANNEL_TYPE = 270L;

    /** 缓存秒数（渠道编码） */
    public static final long CACHE_CHANNEL_CODE = 275L;

    /** 缓存秒数（渠道级别） */
    public static final long CACHE_CHANNEL_LEVEL = 280L;

    /** 缓存秒数（渠道状态） */
    public static final long CACHE_CHANNEL_STATUS = 285L;

    /** 缓存秒数（渠道金额） */
    public static final long CACHE_CHANNEL_AMOUNT = 290L;

    /** 缓存秒数（渠道数量） */
    public static final long CACHE_CHANNEL_COUNT = 295L;

    /** 缓存秒数（渠道比率） */
    public static final long CACHE_CHANNEL_RATE = 300L;

    private CustManagerRelCacheConfig() {
    }

    /** 缓存秒数（风险日期）。 */
    public static long resolveCacheRiskDate(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_DATE;
        }
        if (requested > CACHE_RISK_DATE) {
            return CACHE_RISK_DATE;
        }
        return requested;
    }

    /** 缓存秒数（风险时间）。 */
    public static long resolveCacheRiskTime(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_TIME;
        }
        if (requested > CACHE_RISK_TIME) {
            return CACHE_RISK_TIME;
        }
        return requested;
    }

    /** 缓存秒数（风险标记）。 */
    public static long resolveCacheRiskFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_FLAG;
        }
        if (requested > CACHE_RISK_FLAG) {
            return CACHE_RISK_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（风险说明）。 */
    public static long resolveCacheRiskRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_REMARK;
        }
        if (requested > CACHE_RISK_REMARK) {
            return CACHE_RISK_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（风险来源）。 */
    public static long resolveCacheRiskSource(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_SOURCE;
        }
        if (requested > CACHE_RISK_SOURCE) {
            return CACHE_RISK_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（风险版本）。 */
    public static long resolveCacheRiskVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_VERSION;
        }
        if (requested > CACHE_RISK_VERSION) {
            return CACHE_RISK_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（风险区域）。 */
    public static long resolveCacheRiskRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_REGION;
        }
        if (requested > CACHE_RISK_REGION) {
            return CACHE_RISK_REGION;
        }
        return requested;
    }

    /** 缓存秒数（风险渠道）。 */
    public static long resolveCacheRiskChannel(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_CHANNEL;
        }
        if (requested > CACHE_RISK_CHANNEL) {
            return CACHE_RISK_CHANNEL;
        }
        return requested;
    }

    /** 缓存秒数（风险分组）。 */
    public static long resolveCacheRiskGroup(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_GROUP;
        }
        if (requested > CACHE_RISK_GROUP) {
            return CACHE_RISK_GROUP;
        }
        return requested;
    }

    /** 缓存秒数（风险标签）。 */
    public static long resolveCacheRiskTag(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_TAG;
        }
        if (requested > CACHE_RISK_TAG) {
            return CACHE_RISK_TAG;
        }
        return requested;
    }

    /** 缓存秒数（风险负责人）。 */
    public static long resolveCacheRiskOwner(long requested) {
        if (requested <= 0L) {
            return CACHE_RISK_OWNER;
        }
        if (requested > CACHE_RISK_OWNER) {
            return CACHE_RISK_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（信用编号）。 */
    public static long resolveCacheCreditNo(long requested) {
        if (requested <= 0L) {
            return CACHE_CREDIT_NO;
        }
        if (requested > CACHE_CREDIT_NO) {
            return CACHE_CREDIT_NO;
        }
        return requested;
    }

    /** 缓存秒数（信用名称）。 */
    public static long resolveCacheCreditName(long requested) {
        if (requested <= 0L) {
            return CACHE_CREDIT_NAME;
        }
        if (requested > CACHE_CREDIT_NAME) {
            return CACHE_CREDIT_NAME;
        }
        return requested;
    }

    /** 缓存秒数（信用类型）。 */
    public static long resolveCacheCreditType(long requested) {
        if (requested <= 0L) {
            return CACHE_CREDIT_TYPE;
        }
        if (requested > CACHE_CREDIT_TYPE) {
            return CACHE_CREDIT_TYPE;
        }
        return requested;
    }

    /** 缓存秒数（信用编码）。 */
    public static long resolveCacheCreditCode(long requested) {
        if (requested <= 0L) {
            return CACHE_CREDIT_CODE;
        }
        if (requested > CACHE_CREDIT_CODE) {
            return CACHE_CREDIT_CODE;
        }
        return requested;
    }

    /** 缓存秒数（信用级别）。 */
    public static long resolveCacheCreditLevel(long requested) {
        if (requested <= 0L) {
            return CACHE_CREDIT_LEVEL;
        }
        if (requested > CACHE_CREDIT_LEVEL) {
            return CACHE_CREDIT_LEVEL;
        }
        return requested;
    }

    /** 缓存秒数（信用状态）。 */
    public static long resolveCacheCreditStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_CREDIT_STATUS;
        }
        if (requested > CACHE_CREDIT_STATUS) {
            return CACHE_CREDIT_STATUS;
        }
        return requested;
    }

    /** 缓存秒数（信用金额）。 */
    public static long resolveCacheCreditAmount(long requested) {
        if (requested <= 0L) {
            return CACHE_CREDIT_AMOUNT;
        }
        if (requested > CACHE_CREDIT_AMOUNT) {
            return CACHE_CREDIT_AMOUNT;
        }
        return requested;
    }

    /** 缓存秒数（信用数量）。 */
    public static long resolveCacheCreditCount(long requested) {
        if (requested <= 0L) {
            return CACHE_CREDIT_COUNT;
        }
        if (requested > CACHE_CREDIT_COUNT) {
            return CACHE_CREDIT_COUNT;
        }
        return requested;
    }

    /** 缓存秒数（信用比率）。 */
    public static long resolveCacheCreditRate(long requested) {
        if (requested <= 0L) {
            return CACHE_CREDIT_RATE;
        }
        if (requested > CACHE_CREDIT_RATE) {
            return CACHE_CREDIT_RATE;
        }
        return requested;
    }

}

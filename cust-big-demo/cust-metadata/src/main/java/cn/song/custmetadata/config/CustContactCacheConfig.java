package cn.song.custmetadata.config;

/**
 * 客户联系方式CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustContactCacheConfig {

    public static final String MODULE_CODE = "CUST_CONTACT_CACHE_CONFIG";

    /** 单次查询上限（资产标记） */
    public static final long LIMIT_ASSET_FLAG = 5L;

    /** 单次查询上限（资产说明） */
    public static final long LIMIT_ASSET_REMARK = 10L;

    /** 单次查询上限（资产来源） */
    public static final long LIMIT_ASSET_SOURCE = 15L;

    /** 单次查询上限（资产版本） */
    public static final long LIMIT_ASSET_VERSION = 20L;

    /** 单次查询上限（资产区域） */
    public static final long LIMIT_ASSET_REGION = 25L;

    /** 单次查询上限（资产渠道） */
    public static final long LIMIT_ASSET_CHANNEL = 30L;

    /** 单次查询上限（资产分组） */
    public static final long LIMIT_ASSET_GROUP = 35L;

    /** 单次查询上限（资产标签） */
    public static final long LIMIT_ASSET_TAG = 40L;

    /** 单次查询上限（资产负责人） */
    public static final long LIMIT_ASSET_OWNER = 45L;

    /** 单次查询上限（风险编号） */
    public static final long LIMIT_RISK_NO = 50L;

    /** 单次查询上限（风险名称） */
    public static final long LIMIT_RISK_NAME = 55L;

    /** 单次查询上限（风险类型） */
    public static final long LIMIT_RISK_TYPE = 60L;

    /** 单次查询上限（风险编码） */
    public static final long LIMIT_RISK_CODE = 65L;

    /** 单次查询上限（风险级别） */
    public static final long LIMIT_RISK_LEVEL = 70L;

    /** 单次查询上限（风险状态） */
    public static final long LIMIT_RISK_STATUS = 75L;

    /** 单次查询上限（风险金额） */
    public static final long LIMIT_RISK_AMOUNT = 80L;

    /** 单次查询上限（风险数量） */
    public static final long LIMIT_RISK_COUNT = 85L;

    /** 单次查询上限（风险比率） */
    public static final long LIMIT_RISK_RATE = 90L;

    /** 单次查询上限（风险日期） */
    public static final long LIMIT_RISK_DATE = 95L;

    /** 单次查询上限（风险时间） */
    public static final long LIMIT_RISK_TIME = 100L;

    /** 单次查询上限（风险标记） */
    public static final long LIMIT_RISK_FLAG = 105L;

    /** 单次查询上限（风险说明） */
    public static final long LIMIT_RISK_REMARK = 110L;

    /** 单次查询上限（风险来源） */
    public static final long LIMIT_RISK_SOURCE = 115L;

    /** 单次查询上限（风险版本） */
    public static final long LIMIT_RISK_VERSION = 120L;

    /** 单次查询上限（风险区域） */
    public static final long LIMIT_RISK_REGION = 125L;

    /** 单次查询上限（风险渠道） */
    public static final long LIMIT_RISK_CHANNEL = 130L;

    /** 单次查询上限（风险分组） */
    public static final long LIMIT_RISK_GROUP = 135L;

    /** 单次查询上限（风险标签） */
    public static final long LIMIT_RISK_TAG = 140L;

    /** 单次查询上限（风险负责人） */
    public static final long LIMIT_RISK_OWNER = 145L;

    /** 单次查询上限（信用编号） */
    public static final long LIMIT_CREDIT_NO = 150L;

    /** 单次查询上限（信用名称） */
    public static final long LIMIT_CREDIT_NAME = 155L;

    /** 单次查询上限（信用类型） */
    public static final long LIMIT_CREDIT_TYPE = 160L;

    /** 单次查询上限（信用编码） */
    public static final long LIMIT_CREDIT_CODE = 165L;

    /** 单次查询上限（信用级别） */
    public static final long LIMIT_CREDIT_LEVEL = 170L;

    /** 单次查询上限（信用状态） */
    public static final long LIMIT_CREDIT_STATUS = 175L;

    /** 单次查询上限（信用金额） */
    public static final long LIMIT_CREDIT_AMOUNT = 180L;

    /** 单次查询上限（信用数量） */
    public static final long LIMIT_CREDIT_COUNT = 185L;

    /** 单次查询上限（信用比率） */
    public static final long LIMIT_CREDIT_RATE = 190L;

    /** 单次查询上限（信用日期） */
    public static final long LIMIT_CREDIT_DATE = 195L;

    /** 单次查询上限（信用时间） */
    public static final long LIMIT_CREDIT_TIME = 200L;

    /** 单次查询上限（信用标记） */
    public static final long LIMIT_CREDIT_FLAG = 205L;

    /** 单次查询上限（信用说明） */
    public static final long LIMIT_CREDIT_REMARK = 210L;

    /** 单次查询上限（信用来源） */
    public static final long LIMIT_CREDIT_SOURCE = 215L;

    /** 单次查询上限（信用版本） */
    public static final long LIMIT_CREDIT_VERSION = 220L;

    /** 单次查询上限（信用区域） */
    public static final long LIMIT_CREDIT_REGION = 225L;

    /** 单次查询上限（信用渠道） */
    public static final long LIMIT_CREDIT_CHANNEL = 230L;

    /** 单次查询上限（信用分组） */
    public static final long LIMIT_CREDIT_GROUP = 235L;

    /** 单次查询上限（信用标签） */
    public static final long LIMIT_CREDIT_TAG = 240L;

    /** 单次查询上限（信用负责人） */
    public static final long LIMIT_CREDIT_OWNER = 245L;

    /** 单次查询上限（行业编号） */
    public static final long LIMIT_INDUSTRY_NO = 250L;

    /** 单次查询上限（行业名称） */
    public static final long LIMIT_INDUSTRY_NAME = 255L;

    /** 单次查询上限（行业类型） */
    public static final long LIMIT_INDUSTRY_TYPE = 260L;

    /** 单次查询上限（行业编码） */
    public static final long LIMIT_INDUSTRY_CODE = 265L;

    /** 单次查询上限（行业级别） */
    public static final long LIMIT_INDUSTRY_LEVEL = 270L;

    /** 单次查询上限（行业状态） */
    public static final long LIMIT_INDUSTRY_STATUS = 275L;

    /** 单次查询上限（行业金额） */
    public static final long LIMIT_INDUSTRY_AMOUNT = 280L;

    /** 单次查询上限（行业数量） */
    public static final long LIMIT_INDUSTRY_COUNT = 285L;

    /** 单次查询上限（行业比率） */
    public static final long LIMIT_INDUSTRY_RATE = 290L;

    /** 单次查询上限（行业日期） */
    public static final long LIMIT_INDUSTRY_DATE = 295L;

    /** 单次查询上限（行业时间） */
    public static final long LIMIT_INDUSTRY_TIME = 300L;

    private CustContactCacheConfig() {
    }

    /** 单次查询上限（资产标记）。 */
    public static long resolveLimitAssetFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_FLAG;
        }
        if (requested > LIMIT_ASSET_FLAG) {
            return LIMIT_ASSET_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（资产说明）。 */
    public static long resolveLimitAssetRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_REMARK;
        }
        if (requested > LIMIT_ASSET_REMARK) {
            return LIMIT_ASSET_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（资产来源）。 */
    public static long resolveLimitAssetSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_SOURCE;
        }
        if (requested > LIMIT_ASSET_SOURCE) {
            return LIMIT_ASSET_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（资产版本）。 */
    public static long resolveLimitAssetVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_VERSION;
        }
        if (requested > LIMIT_ASSET_VERSION) {
            return LIMIT_ASSET_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（资产区域）。 */
    public static long resolveLimitAssetRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_REGION;
        }
        if (requested > LIMIT_ASSET_REGION) {
            return LIMIT_ASSET_REGION;
        }
        return requested;
    }

    /** 单次查询上限（资产渠道）。 */
    public static long resolveLimitAssetChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_CHANNEL;
        }
        if (requested > LIMIT_ASSET_CHANNEL) {
            return LIMIT_ASSET_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（资产分组）。 */
    public static long resolveLimitAssetGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_GROUP;
        }
        if (requested > LIMIT_ASSET_GROUP) {
            return LIMIT_ASSET_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（资产标签）。 */
    public static long resolveLimitAssetTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_TAG;
        }
        if (requested > LIMIT_ASSET_TAG) {
            return LIMIT_ASSET_TAG;
        }
        return requested;
    }

    /** 单次查询上限（资产负责人）。 */
    public static long resolveLimitAssetOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_OWNER;
        }
        if (requested > LIMIT_ASSET_OWNER) {
            return LIMIT_ASSET_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（风险编号）。 */
    public static long resolveLimitRiskNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_NO;
        }
        if (requested > LIMIT_RISK_NO) {
            return LIMIT_RISK_NO;
        }
        return requested;
    }

    /** 单次查询上限（风险名称）。 */
    public static long resolveLimitRiskName(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_NAME;
        }
        if (requested > LIMIT_RISK_NAME) {
            return LIMIT_RISK_NAME;
        }
        return requested;
    }

    /** 单次查询上限（风险类型）。 */
    public static long resolveLimitRiskType(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_TYPE;
        }
        if (requested > LIMIT_RISK_TYPE) {
            return LIMIT_RISK_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（风险编码）。 */
    public static long resolveLimitRiskCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_CODE;
        }
        if (requested > LIMIT_RISK_CODE) {
            return LIMIT_RISK_CODE;
        }
        return requested;
    }

    /** 单次查询上限（风险级别）。 */
    public static long resolveLimitRiskLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_LEVEL;
        }
        if (requested > LIMIT_RISK_LEVEL) {
            return LIMIT_RISK_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（风险状态）。 */
    public static long resolveLimitRiskStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_STATUS;
        }
        if (requested > LIMIT_RISK_STATUS) {
            return LIMIT_RISK_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（风险金额）。 */
    public static long resolveLimitRiskAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_AMOUNT;
        }
        if (requested > LIMIT_RISK_AMOUNT) {
            return LIMIT_RISK_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（风险数量）。 */
    public static long resolveLimitRiskCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_COUNT;
        }
        if (requested > LIMIT_RISK_COUNT) {
            return LIMIT_RISK_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（风险比率）。 */
    public static long resolveLimitRiskRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_RATE;
        }
        if (requested > LIMIT_RISK_RATE) {
            return LIMIT_RISK_RATE;
        }
        return requested;
    }

    /** 单次查询上限（风险日期）。 */
    public static long resolveLimitRiskDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_DATE;
        }
        if (requested > LIMIT_RISK_DATE) {
            return LIMIT_RISK_DATE;
        }
        return requested;
    }

    /** 单次查询上限（风险时间）。 */
    public static long resolveLimitRiskTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_RISK_TIME;
        }
        if (requested > LIMIT_RISK_TIME) {
            return LIMIT_RISK_TIME;
        }
        return requested;
    }

}

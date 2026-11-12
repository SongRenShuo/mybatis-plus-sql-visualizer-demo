package cn.song.custmetadata.config;

/**
 * 客户经理JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustManagerJobConfig {

    public static final String MODULE_CODE = "CUST_MANAGER_JOB_CONFIG";

    /** 缓存秒数（银行级别） */
    public static final long CACHE_BANK_LEVEL = 5L;

    /** 缓存秒数（银行状态） */
    public static final long CACHE_BANK_STATUS = 10L;

    /** 缓存秒数（银行金额） */
    public static final long CACHE_BANK_AMOUNT = 15L;

    /** 缓存秒数（银行数量） */
    public static final long CACHE_BANK_COUNT = 20L;

    /** 缓存秒数（银行比率） */
    public static final long CACHE_BANK_RATE = 25L;

    /** 缓存秒数（银行日期） */
    public static final long CACHE_BANK_DATE = 30L;

    /** 缓存秒数（银行时间） */
    public static final long CACHE_BANK_TIME = 35L;

    /** 缓存秒数（银行标记） */
    public static final long CACHE_BANK_FLAG = 40L;

    /** 缓存秒数（银行说明） */
    public static final long CACHE_BANK_REMARK = 45L;

    /** 缓存秒数（银行来源） */
    public static final long CACHE_BANK_SOURCE = 50L;

    /** 缓存秒数（银行版本） */
    public static final long CACHE_BANK_VERSION = 55L;

    /** 缓存秒数（银行区域） */
    public static final long CACHE_BANK_REGION = 60L;

    /** 缓存秒数（银行渠道） */
    public static final long CACHE_BANK_CHANNEL = 65L;

    /** 缓存秒数（银行分组） */
    public static final long CACHE_BANK_GROUP = 70L;

    /** 缓存秒数（银行标签） */
    public static final long CACHE_BANK_TAG = 75L;

    /** 缓存秒数（银行负责人） */
    public static final long CACHE_BANK_OWNER = 80L;

    /** 缓存秒数（资产编号） */
    public static final long CACHE_ASSET_NO = 85L;

    /** 缓存秒数（资产名称） */
    public static final long CACHE_ASSET_NAME = 90L;

    /** 缓存秒数（资产类型） */
    public static final long CACHE_ASSET_TYPE = 95L;

    /** 缓存秒数（资产编码） */
    public static final long CACHE_ASSET_CODE = 100L;

    /** 缓存秒数（资产级别） */
    public static final long CACHE_ASSET_LEVEL = 105L;

    /** 缓存秒数（资产状态） */
    public static final long CACHE_ASSET_STATUS = 110L;

    /** 缓存秒数（资产金额） */
    public static final long CACHE_ASSET_AMOUNT = 115L;

    /** 缓存秒数（资产数量） */
    public static final long CACHE_ASSET_COUNT = 120L;

    /** 缓存秒数（资产比率） */
    public static final long CACHE_ASSET_RATE = 125L;

    /** 缓存秒数（资产日期） */
    public static final long CACHE_ASSET_DATE = 130L;

    /** 缓存秒数（资产时间） */
    public static final long CACHE_ASSET_TIME = 135L;

    /** 缓存秒数（资产标记） */
    public static final long CACHE_ASSET_FLAG = 140L;

    /** 缓存秒数（资产说明） */
    public static final long CACHE_ASSET_REMARK = 145L;

    /** 缓存秒数（资产来源） */
    public static final long CACHE_ASSET_SOURCE = 150L;

    /** 缓存秒数（资产版本） */
    public static final long CACHE_ASSET_VERSION = 155L;

    /** 缓存秒数（资产区域） */
    public static final long CACHE_ASSET_REGION = 160L;

    /** 缓存秒数（资产渠道） */
    public static final long CACHE_ASSET_CHANNEL = 165L;

    /** 缓存秒数（资产分组） */
    public static final long CACHE_ASSET_GROUP = 170L;

    /** 缓存秒数（资产标签） */
    public static final long CACHE_ASSET_TAG = 175L;

    /** 缓存秒数（资产负责人） */
    public static final long CACHE_ASSET_OWNER = 180L;

    /** 缓存秒数（风险编号） */
    public static final long CACHE_RISK_NO = 185L;

    /** 缓存秒数（风险名称） */
    public static final long CACHE_RISK_NAME = 190L;

    /** 缓存秒数（风险类型） */
    public static final long CACHE_RISK_TYPE = 195L;

    /** 缓存秒数（风险编码） */
    public static final long CACHE_RISK_CODE = 200L;

    /** 缓存秒数（风险级别） */
    public static final long CACHE_RISK_LEVEL = 205L;

    /** 缓存秒数（风险状态） */
    public static final long CACHE_RISK_STATUS = 210L;

    /** 缓存秒数（风险金额） */
    public static final long CACHE_RISK_AMOUNT = 215L;

    /** 缓存秒数（风险数量） */
    public static final long CACHE_RISK_COUNT = 220L;

    /** 缓存秒数（风险比率） */
    public static final long CACHE_RISK_RATE = 225L;

    /** 缓存秒数（风险日期） */
    public static final long CACHE_RISK_DATE = 230L;

    /** 缓存秒数（风险时间） */
    public static final long CACHE_RISK_TIME = 235L;

    /** 缓存秒数（风险标记） */
    public static final long CACHE_RISK_FLAG = 240L;

    /** 缓存秒数（风险说明） */
    public static final long CACHE_RISK_REMARK = 245L;

    /** 缓存秒数（风险来源） */
    public static final long CACHE_RISK_SOURCE = 250L;

    /** 缓存秒数（风险版本） */
    public static final long CACHE_RISK_VERSION = 255L;

    /** 缓存秒数（风险区域） */
    public static final long CACHE_RISK_REGION = 260L;

    /** 缓存秒数（风险渠道） */
    public static final long CACHE_RISK_CHANNEL = 265L;

    /** 缓存秒数（风险分组） */
    public static final long CACHE_RISK_GROUP = 270L;

    /** 缓存秒数（风险标签） */
    public static final long CACHE_RISK_TAG = 275L;

    /** 缓存秒数（风险负责人） */
    public static final long CACHE_RISK_OWNER = 280L;

    /** 缓存秒数（信用编号） */
    public static final long CACHE_CREDIT_NO = 285L;

    /** 缓存秒数（信用名称） */
    public static final long CACHE_CREDIT_NAME = 290L;

    /** 缓存秒数（信用类型） */
    public static final long CACHE_CREDIT_TYPE = 295L;

    /** 缓存秒数（信用编码） */
    public static final long CACHE_CREDIT_CODE = 300L;

    private CustManagerJobConfig() {
    }

    /** 缓存秒数（银行级别）。 */
    public static long resolveCacheBankLevel(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_LEVEL;
        }
        if (requested > CACHE_BANK_LEVEL) {
            return CACHE_BANK_LEVEL;
        }
        return requested;
    }

    /** 缓存秒数（银行状态）。 */
    public static long resolveCacheBankStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_STATUS;
        }
        if (requested > CACHE_BANK_STATUS) {
            return CACHE_BANK_STATUS;
        }
        return requested;
    }

    /** 缓存秒数（银行金额）。 */
    public static long resolveCacheBankAmount(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_AMOUNT;
        }
        if (requested > CACHE_BANK_AMOUNT) {
            return CACHE_BANK_AMOUNT;
        }
        return requested;
    }

    /** 缓存秒数（银行数量）。 */
    public static long resolveCacheBankCount(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_COUNT;
        }
        if (requested > CACHE_BANK_COUNT) {
            return CACHE_BANK_COUNT;
        }
        return requested;
    }

    /** 缓存秒数（银行比率）。 */
    public static long resolveCacheBankRate(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_RATE;
        }
        if (requested > CACHE_BANK_RATE) {
            return CACHE_BANK_RATE;
        }
        return requested;
    }

    /** 缓存秒数（银行日期）。 */
    public static long resolveCacheBankDate(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_DATE;
        }
        if (requested > CACHE_BANK_DATE) {
            return CACHE_BANK_DATE;
        }
        return requested;
    }

    /** 缓存秒数（银行时间）。 */
    public static long resolveCacheBankTime(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_TIME;
        }
        if (requested > CACHE_BANK_TIME) {
            return CACHE_BANK_TIME;
        }
        return requested;
    }

    /** 缓存秒数（银行标记）。 */
    public static long resolveCacheBankFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_FLAG;
        }
        if (requested > CACHE_BANK_FLAG) {
            return CACHE_BANK_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（银行说明）。 */
    public static long resolveCacheBankRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_REMARK;
        }
        if (requested > CACHE_BANK_REMARK) {
            return CACHE_BANK_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（银行来源）。 */
    public static long resolveCacheBankSource(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_SOURCE;
        }
        if (requested > CACHE_BANK_SOURCE) {
            return CACHE_BANK_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（银行版本）。 */
    public static long resolveCacheBankVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_VERSION;
        }
        if (requested > CACHE_BANK_VERSION) {
            return CACHE_BANK_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（银行区域）。 */
    public static long resolveCacheBankRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_REGION;
        }
        if (requested > CACHE_BANK_REGION) {
            return CACHE_BANK_REGION;
        }
        return requested;
    }

    /** 缓存秒数（银行渠道）。 */
    public static long resolveCacheBankChannel(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_CHANNEL;
        }
        if (requested > CACHE_BANK_CHANNEL) {
            return CACHE_BANK_CHANNEL;
        }
        return requested;
    }

    /** 缓存秒数（银行分组）。 */
    public static long resolveCacheBankGroup(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_GROUP;
        }
        if (requested > CACHE_BANK_GROUP) {
            return CACHE_BANK_GROUP;
        }
        return requested;
    }

    /** 缓存秒数（银行标签）。 */
    public static long resolveCacheBankTag(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_TAG;
        }
        if (requested > CACHE_BANK_TAG) {
            return CACHE_BANK_TAG;
        }
        return requested;
    }

    /** 缓存秒数（银行负责人）。 */
    public static long resolveCacheBankOwner(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_OWNER;
        }
        if (requested > CACHE_BANK_OWNER) {
            return CACHE_BANK_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（资产编号）。 */
    public static long resolveCacheAssetNo(long requested) {
        if (requested <= 0L) {
            return CACHE_ASSET_NO;
        }
        if (requested > CACHE_ASSET_NO) {
            return CACHE_ASSET_NO;
        }
        return requested;
    }

    /** 缓存秒数（资产名称）。 */
    public static long resolveCacheAssetName(long requested) {
        if (requested <= 0L) {
            return CACHE_ASSET_NAME;
        }
        if (requested > CACHE_ASSET_NAME) {
            return CACHE_ASSET_NAME;
        }
        return requested;
    }

    /** 缓存秒数（资产类型）。 */
    public static long resolveCacheAssetType(long requested) {
        if (requested <= 0L) {
            return CACHE_ASSET_TYPE;
        }
        if (requested > CACHE_ASSET_TYPE) {
            return CACHE_ASSET_TYPE;
        }
        return requested;
    }

    /** 缓存秒数（资产编码）。 */
    public static long resolveCacheAssetCode(long requested) {
        if (requested <= 0L) {
            return CACHE_ASSET_CODE;
        }
        if (requested > CACHE_ASSET_CODE) {
            return CACHE_ASSET_CODE;
        }
        return requested;
    }

}

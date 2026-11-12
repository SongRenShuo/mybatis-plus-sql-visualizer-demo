package cn.song.custmetadata.config;

/**
 * 客户经理CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustManagerCacheConfig {

    public static final String MODULE_CODE = "CUST_MANAGER_CACHE_CONFIG";

    /** 缓存秒数（证件标记） */
    public static final long CACHE_CERT_FLAG = 5L;

    /** 缓存秒数（证件说明） */
    public static final long CACHE_CERT_REMARK = 10L;

    /** 缓存秒数（证件来源） */
    public static final long CACHE_CERT_SOURCE = 15L;

    /** 缓存秒数（证件版本） */
    public static final long CACHE_CERT_VERSION = 20L;

    /** 缓存秒数（证件区域） */
    public static final long CACHE_CERT_REGION = 25L;

    /** 缓存秒数（证件渠道） */
    public static final long CACHE_CERT_CHANNEL = 30L;

    /** 缓存秒数（证件分组） */
    public static final long CACHE_CERT_GROUP = 35L;

    /** 缓存秒数（证件标签） */
    public static final long CACHE_CERT_TAG = 40L;

    /** 缓存秒数（证件负责人） */
    public static final long CACHE_CERT_OWNER = 45L;

    /** 缓存秒数（银行编号） */
    public static final long CACHE_BANK_NO = 50L;

    /** 缓存秒数（银行名称） */
    public static final long CACHE_BANK_NAME = 55L;

    /** 缓存秒数（银行类型） */
    public static final long CACHE_BANK_TYPE = 60L;

    /** 缓存秒数（银行编码） */
    public static final long CACHE_BANK_CODE = 65L;

    /** 缓存秒数（银行级别） */
    public static final long CACHE_BANK_LEVEL = 70L;

    /** 缓存秒数（银行状态） */
    public static final long CACHE_BANK_STATUS = 75L;

    /** 缓存秒数（银行金额） */
    public static final long CACHE_BANK_AMOUNT = 80L;

    /** 缓存秒数（银行数量） */
    public static final long CACHE_BANK_COUNT = 85L;

    /** 缓存秒数（银行比率） */
    public static final long CACHE_BANK_RATE = 90L;

    /** 缓存秒数（银行日期） */
    public static final long CACHE_BANK_DATE = 95L;

    /** 缓存秒数（银行时间） */
    public static final long CACHE_BANK_TIME = 100L;

    /** 缓存秒数（银行标记） */
    public static final long CACHE_BANK_FLAG = 105L;

    /** 缓存秒数（银行说明） */
    public static final long CACHE_BANK_REMARK = 110L;

    /** 缓存秒数（银行来源） */
    public static final long CACHE_BANK_SOURCE = 115L;

    /** 缓存秒数（银行版本） */
    public static final long CACHE_BANK_VERSION = 120L;

    /** 缓存秒数（银行区域） */
    public static final long CACHE_BANK_REGION = 125L;

    /** 缓存秒数（银行渠道） */
    public static final long CACHE_BANK_CHANNEL = 130L;

    /** 缓存秒数（银行分组） */
    public static final long CACHE_BANK_GROUP = 135L;

    /** 缓存秒数（银行标签） */
    public static final long CACHE_BANK_TAG = 140L;

    /** 缓存秒数（银行负责人） */
    public static final long CACHE_BANK_OWNER = 145L;

    /** 缓存秒数（资产编号） */
    public static final long CACHE_ASSET_NO = 150L;

    /** 缓存秒数（资产名称） */
    public static final long CACHE_ASSET_NAME = 155L;

    /** 缓存秒数（资产类型） */
    public static final long CACHE_ASSET_TYPE = 160L;

    /** 缓存秒数（资产编码） */
    public static final long CACHE_ASSET_CODE = 165L;

    /** 缓存秒数（资产级别） */
    public static final long CACHE_ASSET_LEVEL = 170L;

    /** 缓存秒数（资产状态） */
    public static final long CACHE_ASSET_STATUS = 175L;

    /** 缓存秒数（资产金额） */
    public static final long CACHE_ASSET_AMOUNT = 180L;

    /** 缓存秒数（资产数量） */
    public static final long CACHE_ASSET_COUNT = 185L;

    /** 缓存秒数（资产比率） */
    public static final long CACHE_ASSET_RATE = 190L;

    /** 缓存秒数（资产日期） */
    public static final long CACHE_ASSET_DATE = 195L;

    /** 缓存秒数（资产时间） */
    public static final long CACHE_ASSET_TIME = 200L;

    /** 缓存秒数（资产标记） */
    public static final long CACHE_ASSET_FLAG = 205L;

    /** 缓存秒数（资产说明） */
    public static final long CACHE_ASSET_REMARK = 210L;

    /** 缓存秒数（资产来源） */
    public static final long CACHE_ASSET_SOURCE = 215L;

    /** 缓存秒数（资产版本） */
    public static final long CACHE_ASSET_VERSION = 220L;

    /** 缓存秒数（资产区域） */
    public static final long CACHE_ASSET_REGION = 225L;

    /** 缓存秒数（资产渠道） */
    public static final long CACHE_ASSET_CHANNEL = 230L;

    /** 缓存秒数（资产分组） */
    public static final long CACHE_ASSET_GROUP = 235L;

    /** 缓存秒数（资产标签） */
    public static final long CACHE_ASSET_TAG = 240L;

    /** 缓存秒数（资产负责人） */
    public static final long CACHE_ASSET_OWNER = 245L;

    /** 缓存秒数（风险编号） */
    public static final long CACHE_RISK_NO = 250L;

    /** 缓存秒数（风险名称） */
    public static final long CACHE_RISK_NAME = 255L;

    /** 缓存秒数（风险类型） */
    public static final long CACHE_RISK_TYPE = 260L;

    /** 缓存秒数（风险编码） */
    public static final long CACHE_RISK_CODE = 265L;

    /** 缓存秒数（风险级别） */
    public static final long CACHE_RISK_LEVEL = 270L;

    /** 缓存秒数（风险状态） */
    public static final long CACHE_RISK_STATUS = 275L;

    /** 缓存秒数（风险金额） */
    public static final long CACHE_RISK_AMOUNT = 280L;

    /** 缓存秒数（风险数量） */
    public static final long CACHE_RISK_COUNT = 285L;

    /** 缓存秒数（风险比率） */
    public static final long CACHE_RISK_RATE = 290L;

    /** 缓存秒数（风险日期） */
    public static final long CACHE_RISK_DATE = 295L;

    /** 缓存秒数（风险时间） */
    public static final long CACHE_RISK_TIME = 300L;

    private CustManagerCacheConfig() {
    }

    /** 缓存秒数（证件标记）。 */
    public static long resolveCacheCertFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_FLAG;
        }
        if (requested > CACHE_CERT_FLAG) {
            return CACHE_CERT_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（证件说明）。 */
    public static long resolveCacheCertRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_REMARK;
        }
        if (requested > CACHE_CERT_REMARK) {
            return CACHE_CERT_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（证件来源）。 */
    public static long resolveCacheCertSource(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_SOURCE;
        }
        if (requested > CACHE_CERT_SOURCE) {
            return CACHE_CERT_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（证件版本）。 */
    public static long resolveCacheCertVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_VERSION;
        }
        if (requested > CACHE_CERT_VERSION) {
            return CACHE_CERT_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（证件区域）。 */
    public static long resolveCacheCertRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_REGION;
        }
        if (requested > CACHE_CERT_REGION) {
            return CACHE_CERT_REGION;
        }
        return requested;
    }

    /** 缓存秒数（证件渠道）。 */
    public static long resolveCacheCertChannel(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_CHANNEL;
        }
        if (requested > CACHE_CERT_CHANNEL) {
            return CACHE_CERT_CHANNEL;
        }
        return requested;
    }

    /** 缓存秒数（证件分组）。 */
    public static long resolveCacheCertGroup(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_GROUP;
        }
        if (requested > CACHE_CERT_GROUP) {
            return CACHE_CERT_GROUP;
        }
        return requested;
    }

    /** 缓存秒数（证件标签）。 */
    public static long resolveCacheCertTag(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_TAG;
        }
        if (requested > CACHE_CERT_TAG) {
            return CACHE_CERT_TAG;
        }
        return requested;
    }

    /** 缓存秒数（证件负责人）。 */
    public static long resolveCacheCertOwner(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_OWNER;
        }
        if (requested > CACHE_CERT_OWNER) {
            return CACHE_CERT_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（银行编号）。 */
    public static long resolveCacheBankNo(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_NO;
        }
        if (requested > CACHE_BANK_NO) {
            return CACHE_BANK_NO;
        }
        return requested;
    }

    /** 缓存秒数（银行名称）。 */
    public static long resolveCacheBankName(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_NAME;
        }
        if (requested > CACHE_BANK_NAME) {
            return CACHE_BANK_NAME;
        }
        return requested;
    }

    /** 缓存秒数（银行类型）。 */
    public static long resolveCacheBankType(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_TYPE;
        }
        if (requested > CACHE_BANK_TYPE) {
            return CACHE_BANK_TYPE;
        }
        return requested;
    }

    /** 缓存秒数（银行编码）。 */
    public static long resolveCacheBankCode(long requested) {
        if (requested <= 0L) {
            return CACHE_BANK_CODE;
        }
        if (requested > CACHE_BANK_CODE) {
            return CACHE_BANK_CODE;
        }
        return requested;
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

}

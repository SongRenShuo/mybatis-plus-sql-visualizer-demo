package cn.song.custmetadata.config;

/**
 * 客户变更日志CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustChangeLogCacheConfig {

    public static final String MODULE_CODE = "CUST_CHANGE_LOG_CACHE_CONFIG";

    /** 过期天数（银行编码） */
    public static final long EXPIRED_BANK_CODE = 5L;

    /** 过期天数（银行级别） */
    public static final long EXPIRED_BANK_LEVEL = 10L;

    /** 过期天数（银行状态） */
    public static final long EXPIRED_BANK_STATUS = 15L;

    /** 过期天数（银行金额） */
    public static final long EXPIRED_BANK_AMOUNT = 20L;

    /** 过期天数（银行数量） */
    public static final long EXPIRED_BANK_COUNT = 25L;

    /** 过期天数（银行比率） */
    public static final long EXPIRED_BANK_RATE = 30L;

    /** 过期天数（银行日期） */
    public static final long EXPIRED_BANK_DATE = 35L;

    /** 过期天数（银行时间） */
    public static final long EXPIRED_BANK_TIME = 40L;

    /** 过期天数（银行标记） */
    public static final long EXPIRED_BANK_FLAG = 45L;

    /** 过期天数（银行说明） */
    public static final long EXPIRED_BANK_REMARK = 50L;

    /** 过期天数（银行来源） */
    public static final long EXPIRED_BANK_SOURCE = 55L;

    /** 过期天数（银行版本） */
    public static final long EXPIRED_BANK_VERSION = 60L;

    /** 过期天数（银行区域） */
    public static final long EXPIRED_BANK_REGION = 65L;

    /** 过期天数（银行渠道） */
    public static final long EXPIRED_BANK_CHANNEL = 70L;

    /** 过期天数（银行分组） */
    public static final long EXPIRED_BANK_GROUP = 75L;

    /** 过期天数（银行标签） */
    public static final long EXPIRED_BANK_TAG = 80L;

    /** 过期天数（银行负责人） */
    public static final long EXPIRED_BANK_OWNER = 85L;

    /** 过期天数（资产编号） */
    public static final long EXPIRED_ASSET_NO = 90L;

    /** 过期天数（资产名称） */
    public static final long EXPIRED_ASSET_NAME = 95L;

    /** 过期天数（资产类型） */
    public static final long EXPIRED_ASSET_TYPE = 100L;

    /** 过期天数（资产编码） */
    public static final long EXPIRED_ASSET_CODE = 105L;

    /** 过期天数（资产级别） */
    public static final long EXPIRED_ASSET_LEVEL = 110L;

    /** 过期天数（资产状态） */
    public static final long EXPIRED_ASSET_STATUS = 115L;

    /** 过期天数（资产金额） */
    public static final long EXPIRED_ASSET_AMOUNT = 120L;

    /** 过期天数（资产数量） */
    public static final long EXPIRED_ASSET_COUNT = 125L;

    /** 过期天数（资产比率） */
    public static final long EXPIRED_ASSET_RATE = 130L;

    /** 过期天数（资产日期） */
    public static final long EXPIRED_ASSET_DATE = 135L;

    /** 过期天数（资产时间） */
    public static final long EXPIRED_ASSET_TIME = 140L;

    /** 过期天数（资产标记） */
    public static final long EXPIRED_ASSET_FLAG = 145L;

    /** 过期天数（资产说明） */
    public static final long EXPIRED_ASSET_REMARK = 150L;

    /** 过期天数（资产来源） */
    public static final long EXPIRED_ASSET_SOURCE = 155L;

    /** 过期天数（资产版本） */
    public static final long EXPIRED_ASSET_VERSION = 160L;

    /** 过期天数（资产区域） */
    public static final long EXPIRED_ASSET_REGION = 165L;

    /** 过期天数（资产渠道） */
    public static final long EXPIRED_ASSET_CHANNEL = 170L;

    /** 过期天数（资产分组） */
    public static final long EXPIRED_ASSET_GROUP = 175L;

    /** 过期天数（资产标签） */
    public static final long EXPIRED_ASSET_TAG = 180L;

    /** 过期天数（资产负责人） */
    public static final long EXPIRED_ASSET_OWNER = 185L;

    /** 过期天数（风险编号） */
    public static final long EXPIRED_RISK_NO = 190L;

    /** 过期天数（风险名称） */
    public static final long EXPIRED_RISK_NAME = 195L;

    /** 过期天数（风险类型） */
    public static final long EXPIRED_RISK_TYPE = 200L;

    /** 过期天数（风险编码） */
    public static final long EXPIRED_RISK_CODE = 205L;

    /** 过期天数（风险级别） */
    public static final long EXPIRED_RISK_LEVEL = 210L;

    /** 过期天数（风险状态） */
    public static final long EXPIRED_RISK_STATUS = 215L;

    /** 过期天数（风险金额） */
    public static final long EXPIRED_RISK_AMOUNT = 220L;

    /** 过期天数（风险数量） */
    public static final long EXPIRED_RISK_COUNT = 225L;

    /** 过期天数（风险比率） */
    public static final long EXPIRED_RISK_RATE = 230L;

    /** 过期天数（风险日期） */
    public static final long EXPIRED_RISK_DATE = 235L;

    /** 过期天数（风险时间） */
    public static final long EXPIRED_RISK_TIME = 240L;

    /** 过期天数（风险标记） */
    public static final long EXPIRED_RISK_FLAG = 245L;

    /** 过期天数（风险说明） */
    public static final long EXPIRED_RISK_REMARK = 250L;

    /** 过期天数（风险来源） */
    public static final long EXPIRED_RISK_SOURCE = 255L;

    /** 过期天数（风险版本） */
    public static final long EXPIRED_RISK_VERSION = 260L;

    /** 过期天数（风险区域） */
    public static final long EXPIRED_RISK_REGION = 265L;

    /** 过期天数（风险渠道） */
    public static final long EXPIRED_RISK_CHANNEL = 270L;

    /** 过期天数（风险分组） */
    public static final long EXPIRED_RISK_GROUP = 275L;

    /** 过期天数（风险标签） */
    public static final long EXPIRED_RISK_TAG = 280L;

    /** 过期天数（风险负责人） */
    public static final long EXPIRED_RISK_OWNER = 285L;

    /** 过期天数（信用编号） */
    public static final long EXPIRED_CREDIT_NO = 290L;

    /** 过期天数（信用名称） */
    public static final long EXPIRED_CREDIT_NAME = 295L;

    /** 过期天数（信用类型） */
    public static final long EXPIRED_CREDIT_TYPE = 300L;

    private CustChangeLogCacheConfig() {
    }

    /** 过期天数（银行编码）。 */
    public static long resolveExpiredBankCode(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_CODE;
        }
        if (requested > EXPIRED_BANK_CODE) {
            return EXPIRED_BANK_CODE;
        }
        return requested;
    }

    /** 过期天数（银行级别）。 */
    public static long resolveExpiredBankLevel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_LEVEL;
        }
        if (requested > EXPIRED_BANK_LEVEL) {
            return EXPIRED_BANK_LEVEL;
        }
        return requested;
    }

    /** 过期天数（银行状态）。 */
    public static long resolveExpiredBankStatus(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_STATUS;
        }
        if (requested > EXPIRED_BANK_STATUS) {
            return EXPIRED_BANK_STATUS;
        }
        return requested;
    }

    /** 过期天数（银行金额）。 */
    public static long resolveExpiredBankAmount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_AMOUNT;
        }
        if (requested > EXPIRED_BANK_AMOUNT) {
            return EXPIRED_BANK_AMOUNT;
        }
        return requested;
    }

    /** 过期天数（银行数量）。 */
    public static long resolveExpiredBankCount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_COUNT;
        }
        if (requested > EXPIRED_BANK_COUNT) {
            return EXPIRED_BANK_COUNT;
        }
        return requested;
    }

    /** 过期天数（银行比率）。 */
    public static long resolveExpiredBankRate(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_RATE;
        }
        if (requested > EXPIRED_BANK_RATE) {
            return EXPIRED_BANK_RATE;
        }
        return requested;
    }

    /** 过期天数（银行日期）。 */
    public static long resolveExpiredBankDate(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_DATE;
        }
        if (requested > EXPIRED_BANK_DATE) {
            return EXPIRED_BANK_DATE;
        }
        return requested;
    }

    /** 过期天数（银行时间）。 */
    public static long resolveExpiredBankTime(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_TIME;
        }
        if (requested > EXPIRED_BANK_TIME) {
            return EXPIRED_BANK_TIME;
        }
        return requested;
    }

    /** 过期天数（银行标记）。 */
    public static long resolveExpiredBankFlag(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_FLAG;
        }
        if (requested > EXPIRED_BANK_FLAG) {
            return EXPIRED_BANK_FLAG;
        }
        return requested;
    }

    /** 过期天数（银行说明）。 */
    public static long resolveExpiredBankRemark(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_REMARK;
        }
        if (requested > EXPIRED_BANK_REMARK) {
            return EXPIRED_BANK_REMARK;
        }
        return requested;
    }

    /** 过期天数（银行来源）。 */
    public static long resolveExpiredBankSource(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_SOURCE;
        }
        if (requested > EXPIRED_BANK_SOURCE) {
            return EXPIRED_BANK_SOURCE;
        }
        return requested;
    }

    /** 过期天数（银行版本）。 */
    public static long resolveExpiredBankVersion(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_VERSION;
        }
        if (requested > EXPIRED_BANK_VERSION) {
            return EXPIRED_BANK_VERSION;
        }
        return requested;
    }

    /** 过期天数（银行区域）。 */
    public static long resolveExpiredBankRegion(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_REGION;
        }
        if (requested > EXPIRED_BANK_REGION) {
            return EXPIRED_BANK_REGION;
        }
        return requested;
    }

    /** 过期天数（银行渠道）。 */
    public static long resolveExpiredBankChannel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_CHANNEL;
        }
        if (requested > EXPIRED_BANK_CHANNEL) {
            return EXPIRED_BANK_CHANNEL;
        }
        return requested;
    }

    /** 过期天数（银行分组）。 */
    public static long resolveExpiredBankGroup(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_GROUP;
        }
        if (requested > EXPIRED_BANK_GROUP) {
            return EXPIRED_BANK_GROUP;
        }
        return requested;
    }

    /** 过期天数（银行标签）。 */
    public static long resolveExpiredBankTag(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_TAG;
        }
        if (requested > EXPIRED_BANK_TAG) {
            return EXPIRED_BANK_TAG;
        }
        return requested;
    }

    /** 过期天数（银行负责人）。 */
    public static long resolveExpiredBankOwner(long requested) {
        if (requested <= 0L) {
            return EXPIRED_BANK_OWNER;
        }
        if (requested > EXPIRED_BANK_OWNER) {
            return EXPIRED_BANK_OWNER;
        }
        return requested;
    }

    /** 过期天数（资产编号）。 */
    public static long resolveExpiredAssetNo(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ASSET_NO;
        }
        if (requested > EXPIRED_ASSET_NO) {
            return EXPIRED_ASSET_NO;
        }
        return requested;
    }

    /** 过期天数（资产名称）。 */
    public static long resolveExpiredAssetName(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ASSET_NAME;
        }
        if (requested > EXPIRED_ASSET_NAME) {
            return EXPIRED_ASSET_NAME;
        }
        return requested;
    }

    /** 过期天数（资产类型）。 */
    public static long resolveExpiredAssetType(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ASSET_TYPE;
        }
        if (requested > EXPIRED_ASSET_TYPE) {
            return EXPIRED_ASSET_TYPE;
        }
        return requested;
    }

}

package cn.song.custmetadata.config;

/**
 * 客户联系方式ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustContactModuleConfig {

    public static final String MODULE_CODE = "CUST_CONTACT";

    /** 单次查询上限（银行标签） */
    public static final long LIMIT_BANK_TAG = 5L;

    /** 单次查询上限（银行负责人） */
    public static final long LIMIT_BANK_OWNER = 10L;

    /** 单次查询上限（资产编号） */
    public static final long LIMIT_ASSET_NO = 15L;

    /** 单次查询上限（资产名称） */
    public static final long LIMIT_ASSET_NAME = 20L;

    /** 单次查询上限（资产类型） */
    public static final long LIMIT_ASSET_TYPE = 25L;

    /** 单次查询上限（资产编码） */
    public static final long LIMIT_ASSET_CODE = 30L;

    /** 单次查询上限（资产级别） */
    public static final long LIMIT_ASSET_LEVEL = 35L;

    /** 单次查询上限（资产状态） */
    public static final long LIMIT_ASSET_STATUS = 40L;

    /** 单次查询上限（资产金额） */
    public static final long LIMIT_ASSET_AMOUNT = 45L;

    /** 单次查询上限（资产数量） */
    public static final long LIMIT_ASSET_COUNT = 50L;

    /** 单次查询上限（资产比率） */
    public static final long LIMIT_ASSET_RATE = 55L;

    /** 单次查询上限（资产日期） */
    public static final long LIMIT_ASSET_DATE = 60L;

    /** 单次查询上限（资产时间） */
    public static final long LIMIT_ASSET_TIME = 65L;

    /** 单次查询上限（资产标记） */
    public static final long LIMIT_ASSET_FLAG = 70L;

    /** 单次查询上限（资产说明） */
    public static final long LIMIT_ASSET_REMARK = 75L;

    /** 单次查询上限（资产来源） */
    public static final long LIMIT_ASSET_SOURCE = 80L;

    /** 单次查询上限（资产版本） */
    public static final long LIMIT_ASSET_VERSION = 85L;

    /** 单次查询上限（资产区域） */
    public static final long LIMIT_ASSET_REGION = 90L;

    /** 单次查询上限（资产渠道） */
    public static final long LIMIT_ASSET_CHANNEL = 95L;

    /** 单次查询上限（资产分组） */
    public static final long LIMIT_ASSET_GROUP = 100L;

    /** 单次查询上限（资产标签） */
    public static final long LIMIT_ASSET_TAG = 105L;

    /** 单次查询上限（资产负责人） */
    public static final long LIMIT_ASSET_OWNER = 110L;

    /** 单次查询上限（风险编号） */
    public static final long LIMIT_RISK_NO = 115L;

    /** 单次查询上限（风险名称） */
    public static final long LIMIT_RISK_NAME = 120L;

    /** 单次查询上限（风险类型） */
    public static final long LIMIT_RISK_TYPE = 125L;

    /** 单次查询上限（风险编码） */
    public static final long LIMIT_RISK_CODE = 130L;

    /** 单次查询上限（风险级别） */
    public static final long LIMIT_RISK_LEVEL = 135L;

    /** 单次查询上限（风险状态） */
    public static final long LIMIT_RISK_STATUS = 140L;

    /** 单次查询上限（风险金额） */
    public static final long LIMIT_RISK_AMOUNT = 145L;

    /** 单次查询上限（风险数量） */
    public static final long LIMIT_RISK_COUNT = 150L;

    /** 单次查询上限（风险比率） */
    public static final long LIMIT_RISK_RATE = 155L;

    /** 单次查询上限（风险日期） */
    public static final long LIMIT_RISK_DATE = 160L;

    /** 单次查询上限（风险时间） */
    public static final long LIMIT_RISK_TIME = 165L;

    /** 单次查询上限（风险标记） */
    public static final long LIMIT_RISK_FLAG = 170L;

    /** 单次查询上限（风险说明） */
    public static final long LIMIT_RISK_REMARK = 175L;

    /** 单次查询上限（风险来源） */
    public static final long LIMIT_RISK_SOURCE = 180L;

    /** 单次查询上限（风险版本） */
    public static final long LIMIT_RISK_VERSION = 185L;

    /** 单次查询上限（风险区域） */
    public static final long LIMIT_RISK_REGION = 190L;

    /** 单次查询上限（风险渠道） */
    public static final long LIMIT_RISK_CHANNEL = 195L;

    /** 单次查询上限（风险分组） */
    public static final long LIMIT_RISK_GROUP = 200L;

    /** 单次查询上限（风险标签） */
    public static final long LIMIT_RISK_TAG = 205L;

    /** 单次查询上限（风险负责人） */
    public static final long LIMIT_RISK_OWNER = 210L;

    /** 单次查询上限（信用编号） */
    public static final long LIMIT_CREDIT_NO = 215L;

    /** 单次查询上限（信用名称） */
    public static final long LIMIT_CREDIT_NAME = 220L;

    /** 单次查询上限（信用类型） */
    public static final long LIMIT_CREDIT_TYPE = 225L;

    /** 单次查询上限（信用编码） */
    public static final long LIMIT_CREDIT_CODE = 230L;

    /** 单次查询上限（信用级别） */
    public static final long LIMIT_CREDIT_LEVEL = 235L;

    /** 单次查询上限（信用状态） */
    public static final long LIMIT_CREDIT_STATUS = 240L;

    /** 单次查询上限（信用金额） */
    public static final long LIMIT_CREDIT_AMOUNT = 245L;

    /** 单次查询上限（信用数量） */
    public static final long LIMIT_CREDIT_COUNT = 250L;

    /** 单次查询上限（信用比率） */
    public static final long LIMIT_CREDIT_RATE = 255L;

    /** 单次查询上限（信用日期） */
    public static final long LIMIT_CREDIT_DATE = 260L;

    /** 单次查询上限（信用时间） */
    public static final long LIMIT_CREDIT_TIME = 265L;

    /** 单次查询上限（信用标记） */
    public static final long LIMIT_CREDIT_FLAG = 270L;

    /** 单次查询上限（信用说明） */
    public static final long LIMIT_CREDIT_REMARK = 275L;

    /** 单次查询上限（信用来源） */
    public static final long LIMIT_CREDIT_SOURCE = 280L;

    /** 单次查询上限（信用版本） */
    public static final long LIMIT_CREDIT_VERSION = 285L;

    /** 单次查询上限（信用区域） */
    public static final long LIMIT_CREDIT_REGION = 290L;

    /** 单次查询上限（信用渠道） */
    public static final long LIMIT_CREDIT_CHANNEL = 295L;

    /** 单次查询上限（信用分组） */
    public static final long LIMIT_CREDIT_GROUP = 300L;

    private CustContactModuleConfig() {
    }

    /** 单次查询上限（银行标签）。 */
    public static long resolveLimitBankTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_BANK_TAG;
        }
        if (requested > LIMIT_BANK_TAG) {
            return LIMIT_BANK_TAG;
        }
        return requested;
    }

    /** 单次查询上限（银行负责人）。 */
    public static long resolveLimitBankOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_BANK_OWNER;
        }
        if (requested > LIMIT_BANK_OWNER) {
            return LIMIT_BANK_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（资产编号）。 */
    public static long resolveLimitAssetNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_NO;
        }
        if (requested > LIMIT_ASSET_NO) {
            return LIMIT_ASSET_NO;
        }
        return requested;
    }

    /** 单次查询上限（资产名称）。 */
    public static long resolveLimitAssetName(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_NAME;
        }
        if (requested > LIMIT_ASSET_NAME) {
            return LIMIT_ASSET_NAME;
        }
        return requested;
    }

    /** 单次查询上限（资产类型）。 */
    public static long resolveLimitAssetType(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_TYPE;
        }
        if (requested > LIMIT_ASSET_TYPE) {
            return LIMIT_ASSET_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（资产编码）。 */
    public static long resolveLimitAssetCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_CODE;
        }
        if (requested > LIMIT_ASSET_CODE) {
            return LIMIT_ASSET_CODE;
        }
        return requested;
    }

    /** 单次查询上限（资产级别）。 */
    public static long resolveLimitAssetLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_LEVEL;
        }
        if (requested > LIMIT_ASSET_LEVEL) {
            return LIMIT_ASSET_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（资产状态）。 */
    public static long resolveLimitAssetStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_STATUS;
        }
        if (requested > LIMIT_ASSET_STATUS) {
            return LIMIT_ASSET_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（资产金额）。 */
    public static long resolveLimitAssetAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_AMOUNT;
        }
        if (requested > LIMIT_ASSET_AMOUNT) {
            return LIMIT_ASSET_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（资产数量）。 */
    public static long resolveLimitAssetCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_COUNT;
        }
        if (requested > LIMIT_ASSET_COUNT) {
            return LIMIT_ASSET_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（资产比率）。 */
    public static long resolveLimitAssetRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_RATE;
        }
        if (requested > LIMIT_ASSET_RATE) {
            return LIMIT_ASSET_RATE;
        }
        return requested;
    }

    /** 单次查询上限（资产日期）。 */
    public static long resolveLimitAssetDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_DATE;
        }
        if (requested > LIMIT_ASSET_DATE) {
            return LIMIT_ASSET_DATE;
        }
        return requested;
    }

    /** 单次查询上限（资产时间）。 */
    public static long resolveLimitAssetTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_ASSET_TIME;
        }
        if (requested > LIMIT_ASSET_TIME) {
            return LIMIT_ASSET_TIME;
        }
        return requested;
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

}

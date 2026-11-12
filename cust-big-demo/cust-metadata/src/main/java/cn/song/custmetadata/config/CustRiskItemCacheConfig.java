package cn.song.custmetadata.config;

/**
 * 客户风险项CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustRiskItemCacheConfig {

    public static final String MODULE_CODE = "CUST_RISK_ITEM_CACHE_CONFIG";

    /** 重试次数（证件状态） */
    public static final long RETRY_CERT_STATUS = 5L;

    /** 重试次数（证件金额） */
    public static final long RETRY_CERT_AMOUNT = 10L;

    /** 重试次数（证件数量） */
    public static final long RETRY_CERT_COUNT = 15L;

    /** 重试次数（证件比率） */
    public static final long RETRY_CERT_RATE = 20L;

    /** 重试次数（证件日期） */
    public static final long RETRY_CERT_DATE = 25L;

    /** 重试次数（证件时间） */
    public static final long RETRY_CERT_TIME = 30L;

    /** 重试次数（证件标记） */
    public static final long RETRY_CERT_FLAG = 35L;

    /** 重试次数（证件说明） */
    public static final long RETRY_CERT_REMARK = 40L;

    /** 重试次数（证件来源） */
    public static final long RETRY_CERT_SOURCE = 45L;

    /** 重试次数（证件版本） */
    public static final long RETRY_CERT_VERSION = 50L;

    /** 重试次数（证件区域） */
    public static final long RETRY_CERT_REGION = 55L;

    /** 重试次数（证件渠道） */
    public static final long RETRY_CERT_CHANNEL = 60L;

    /** 重试次数（证件分组） */
    public static final long RETRY_CERT_GROUP = 65L;

    /** 重试次数（证件标签） */
    public static final long RETRY_CERT_TAG = 70L;

    /** 重试次数（证件负责人） */
    public static final long RETRY_CERT_OWNER = 75L;

    /** 重试次数（银行编号） */
    public static final long RETRY_BANK_NO = 80L;

    /** 重试次数（银行名称） */
    public static final long RETRY_BANK_NAME = 85L;

    /** 重试次数（银行类型） */
    public static final long RETRY_BANK_TYPE = 90L;

    /** 重试次数（银行编码） */
    public static final long RETRY_BANK_CODE = 95L;

    /** 重试次数（银行级别） */
    public static final long RETRY_BANK_LEVEL = 100L;

    /** 重试次数（银行状态） */
    public static final long RETRY_BANK_STATUS = 105L;

    /** 重试次数（银行金额） */
    public static final long RETRY_BANK_AMOUNT = 110L;

    /** 重试次数（银行数量） */
    public static final long RETRY_BANK_COUNT = 115L;

    /** 重试次数（银行比率） */
    public static final long RETRY_BANK_RATE = 120L;

    /** 重试次数（银行日期） */
    public static final long RETRY_BANK_DATE = 125L;

    /** 重试次数（银行时间） */
    public static final long RETRY_BANK_TIME = 130L;

    /** 重试次数（银行标记） */
    public static final long RETRY_BANK_FLAG = 135L;

    /** 重试次数（银行说明） */
    public static final long RETRY_BANK_REMARK = 140L;

    /** 重试次数（银行来源） */
    public static final long RETRY_BANK_SOURCE = 145L;

    /** 重试次数（银行版本） */
    public static final long RETRY_BANK_VERSION = 150L;

    /** 重试次数（银行区域） */
    public static final long RETRY_BANK_REGION = 155L;

    /** 重试次数（银行渠道） */
    public static final long RETRY_BANK_CHANNEL = 160L;

    /** 重试次数（银行分组） */
    public static final long RETRY_BANK_GROUP = 165L;

    /** 重试次数（银行标签） */
    public static final long RETRY_BANK_TAG = 170L;

    /** 重试次数（银行负责人） */
    public static final long RETRY_BANK_OWNER = 175L;

    /** 重试次数（资产编号） */
    public static final long RETRY_ASSET_NO = 180L;

    /** 重试次数（资产名称） */
    public static final long RETRY_ASSET_NAME = 185L;

    /** 重试次数（资产类型） */
    public static final long RETRY_ASSET_TYPE = 190L;

    /** 重试次数（资产编码） */
    public static final long RETRY_ASSET_CODE = 195L;

    /** 重试次数（资产级别） */
    public static final long RETRY_ASSET_LEVEL = 200L;

    /** 重试次数（资产状态） */
    public static final long RETRY_ASSET_STATUS = 205L;

    /** 重试次数（资产金额） */
    public static final long RETRY_ASSET_AMOUNT = 210L;

    /** 重试次数（资产数量） */
    public static final long RETRY_ASSET_COUNT = 215L;

    /** 重试次数（资产比率） */
    public static final long RETRY_ASSET_RATE = 220L;

    /** 重试次数（资产日期） */
    public static final long RETRY_ASSET_DATE = 225L;

    /** 重试次数（资产时间） */
    public static final long RETRY_ASSET_TIME = 230L;

    /** 重试次数（资产标记） */
    public static final long RETRY_ASSET_FLAG = 235L;

    /** 重试次数（资产说明） */
    public static final long RETRY_ASSET_REMARK = 240L;

    /** 重试次数（资产来源） */
    public static final long RETRY_ASSET_SOURCE = 245L;

    /** 重试次数（资产版本） */
    public static final long RETRY_ASSET_VERSION = 250L;

    /** 重试次数（资产区域） */
    public static final long RETRY_ASSET_REGION = 255L;

    /** 重试次数（资产渠道） */
    public static final long RETRY_ASSET_CHANNEL = 260L;

    /** 重试次数（资产分组） */
    public static final long RETRY_ASSET_GROUP = 265L;

    /** 重试次数（资产标签） */
    public static final long RETRY_ASSET_TAG = 270L;

    /** 重试次数（资产负责人） */
    public static final long RETRY_ASSET_OWNER = 275L;

    /** 重试次数（风险编号） */
    public static final long RETRY_RISK_NO = 280L;

    /** 重试次数（风险名称） */
    public static final long RETRY_RISK_NAME = 285L;

    /** 重试次数（风险类型） */
    public static final long RETRY_RISK_TYPE = 290L;

    /** 重试次数（风险编码） */
    public static final long RETRY_RISK_CODE = 295L;

    /** 重试次数（风险级别） */
    public static final long RETRY_RISK_LEVEL = 300L;

    private CustRiskItemCacheConfig() {
    }

    /** 重试次数（证件状态）。 */
    public static long resolveRetryCertStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_STATUS;
        }
        if (requested > RETRY_CERT_STATUS) {
            return RETRY_CERT_STATUS;
        }
        return requested;
    }

    /** 重试次数（证件金额）。 */
    public static long resolveRetryCertAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_AMOUNT;
        }
        if (requested > RETRY_CERT_AMOUNT) {
            return RETRY_CERT_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（证件数量）。 */
    public static long resolveRetryCertCount(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_COUNT;
        }
        if (requested > RETRY_CERT_COUNT) {
            return RETRY_CERT_COUNT;
        }
        return requested;
    }

    /** 重试次数（证件比率）。 */
    public static long resolveRetryCertRate(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_RATE;
        }
        if (requested > RETRY_CERT_RATE) {
            return RETRY_CERT_RATE;
        }
        return requested;
    }

    /** 重试次数（证件日期）。 */
    public static long resolveRetryCertDate(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_DATE;
        }
        if (requested > RETRY_CERT_DATE) {
            return RETRY_CERT_DATE;
        }
        return requested;
    }

    /** 重试次数（证件时间）。 */
    public static long resolveRetryCertTime(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_TIME;
        }
        if (requested > RETRY_CERT_TIME) {
            return RETRY_CERT_TIME;
        }
        return requested;
    }

    /** 重试次数（证件标记）。 */
    public static long resolveRetryCertFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_FLAG;
        }
        if (requested > RETRY_CERT_FLAG) {
            return RETRY_CERT_FLAG;
        }
        return requested;
    }

    /** 重试次数（证件说明）。 */
    public static long resolveRetryCertRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_REMARK;
        }
        if (requested > RETRY_CERT_REMARK) {
            return RETRY_CERT_REMARK;
        }
        return requested;
    }

    /** 重试次数（证件来源）。 */
    public static long resolveRetryCertSource(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_SOURCE;
        }
        if (requested > RETRY_CERT_SOURCE) {
            return RETRY_CERT_SOURCE;
        }
        return requested;
    }

    /** 重试次数（证件版本）。 */
    public static long resolveRetryCertVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_VERSION;
        }
        if (requested > RETRY_CERT_VERSION) {
            return RETRY_CERT_VERSION;
        }
        return requested;
    }

    /** 重试次数（证件区域）。 */
    public static long resolveRetryCertRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_REGION;
        }
        if (requested > RETRY_CERT_REGION) {
            return RETRY_CERT_REGION;
        }
        return requested;
    }

    /** 重试次数（证件渠道）。 */
    public static long resolveRetryCertChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_CHANNEL;
        }
        if (requested > RETRY_CERT_CHANNEL) {
            return RETRY_CERT_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（证件分组）。 */
    public static long resolveRetryCertGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_GROUP;
        }
        if (requested > RETRY_CERT_GROUP) {
            return RETRY_CERT_GROUP;
        }
        return requested;
    }

    /** 重试次数（证件标签）。 */
    public static long resolveRetryCertTag(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_TAG;
        }
        if (requested > RETRY_CERT_TAG) {
            return RETRY_CERT_TAG;
        }
        return requested;
    }

    /** 重试次数（证件负责人）。 */
    public static long resolveRetryCertOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_CERT_OWNER;
        }
        if (requested > RETRY_CERT_OWNER) {
            return RETRY_CERT_OWNER;
        }
        return requested;
    }

    /** 重试次数（银行编号）。 */
    public static long resolveRetryBankNo(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_NO;
        }
        if (requested > RETRY_BANK_NO) {
            return RETRY_BANK_NO;
        }
        return requested;
    }

    /** 重试次数（银行名称）。 */
    public static long resolveRetryBankName(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_NAME;
        }
        if (requested > RETRY_BANK_NAME) {
            return RETRY_BANK_NAME;
        }
        return requested;
    }

    /** 重试次数（银行类型）。 */
    public static long resolveRetryBankType(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_TYPE;
        }
        if (requested > RETRY_BANK_TYPE) {
            return RETRY_BANK_TYPE;
        }
        return requested;
    }

    /** 重试次数（银行编码）。 */
    public static long resolveRetryBankCode(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_CODE;
        }
        if (requested > RETRY_BANK_CODE) {
            return RETRY_BANK_CODE;
        }
        return requested;
    }

    /** 重试次数（银行级别）。 */
    public static long resolveRetryBankLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_LEVEL;
        }
        if (requested > RETRY_BANK_LEVEL) {
            return RETRY_BANK_LEVEL;
        }
        return requested;
    }

}

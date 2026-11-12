package cn.song.custmetadata.config;

/**
 * 客户风险项JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustRiskItemJobConfig {

    public static final String MODULE_CODE = "CUST_RISK_ITEM_JOB_CONFIG";

    /** 重试次数（证件标签） */
    public static final long RETRY_CERT_TAG = 5L;

    /** 重试次数（证件负责人） */
    public static final long RETRY_CERT_OWNER = 10L;

    /** 重试次数（银行编号） */
    public static final long RETRY_BANK_NO = 15L;

    /** 重试次数（银行名称） */
    public static final long RETRY_BANK_NAME = 20L;

    /** 重试次数（银行类型） */
    public static final long RETRY_BANK_TYPE = 25L;

    /** 重试次数（银行编码） */
    public static final long RETRY_BANK_CODE = 30L;

    /** 重试次数（银行级别） */
    public static final long RETRY_BANK_LEVEL = 35L;

    /** 重试次数（银行状态） */
    public static final long RETRY_BANK_STATUS = 40L;

    /** 重试次数（银行金额） */
    public static final long RETRY_BANK_AMOUNT = 45L;

    /** 重试次数（银行数量） */
    public static final long RETRY_BANK_COUNT = 50L;

    /** 重试次数（银行比率） */
    public static final long RETRY_BANK_RATE = 55L;

    /** 重试次数（银行日期） */
    public static final long RETRY_BANK_DATE = 60L;

    /** 重试次数（银行时间） */
    public static final long RETRY_BANK_TIME = 65L;

    /** 重试次数（银行标记） */
    public static final long RETRY_BANK_FLAG = 70L;

    /** 重试次数（银行说明） */
    public static final long RETRY_BANK_REMARK = 75L;

    /** 重试次数（银行来源） */
    public static final long RETRY_BANK_SOURCE = 80L;

    /** 重试次数（银行版本） */
    public static final long RETRY_BANK_VERSION = 85L;

    /** 重试次数（银行区域） */
    public static final long RETRY_BANK_REGION = 90L;

    /** 重试次数（银行渠道） */
    public static final long RETRY_BANK_CHANNEL = 95L;

    /** 重试次数（银行分组） */
    public static final long RETRY_BANK_GROUP = 100L;

    /** 重试次数（银行标签） */
    public static final long RETRY_BANK_TAG = 105L;

    /** 重试次数（银行负责人） */
    public static final long RETRY_BANK_OWNER = 110L;

    /** 重试次数（资产编号） */
    public static final long RETRY_ASSET_NO = 115L;

    /** 重试次数（资产名称） */
    public static final long RETRY_ASSET_NAME = 120L;

    /** 重试次数（资产类型） */
    public static final long RETRY_ASSET_TYPE = 125L;

    /** 重试次数（资产编码） */
    public static final long RETRY_ASSET_CODE = 130L;

    /** 重试次数（资产级别） */
    public static final long RETRY_ASSET_LEVEL = 135L;

    /** 重试次数（资产状态） */
    public static final long RETRY_ASSET_STATUS = 140L;

    /** 重试次数（资产金额） */
    public static final long RETRY_ASSET_AMOUNT = 145L;

    /** 重试次数（资产数量） */
    public static final long RETRY_ASSET_COUNT = 150L;

    /** 重试次数（资产比率） */
    public static final long RETRY_ASSET_RATE = 155L;

    /** 重试次数（资产日期） */
    public static final long RETRY_ASSET_DATE = 160L;

    /** 重试次数（资产时间） */
    public static final long RETRY_ASSET_TIME = 165L;

    /** 重试次数（资产标记） */
    public static final long RETRY_ASSET_FLAG = 170L;

    /** 重试次数（资产说明） */
    public static final long RETRY_ASSET_REMARK = 175L;

    /** 重试次数（资产来源） */
    public static final long RETRY_ASSET_SOURCE = 180L;

    /** 重试次数（资产版本） */
    public static final long RETRY_ASSET_VERSION = 185L;

    /** 重试次数（资产区域） */
    public static final long RETRY_ASSET_REGION = 190L;

    /** 重试次数（资产渠道） */
    public static final long RETRY_ASSET_CHANNEL = 195L;

    /** 重试次数（资产分组） */
    public static final long RETRY_ASSET_GROUP = 200L;

    /** 重试次数（资产标签） */
    public static final long RETRY_ASSET_TAG = 205L;

    /** 重试次数（资产负责人） */
    public static final long RETRY_ASSET_OWNER = 210L;

    /** 重试次数（风险编号） */
    public static final long RETRY_RISK_NO = 215L;

    /** 重试次数（风险名称） */
    public static final long RETRY_RISK_NAME = 220L;

    /** 重试次数（风险类型） */
    public static final long RETRY_RISK_TYPE = 225L;

    /** 重试次数（风险编码） */
    public static final long RETRY_RISK_CODE = 230L;

    /** 重试次数（风险级别） */
    public static final long RETRY_RISK_LEVEL = 235L;

    /** 重试次数（风险状态） */
    public static final long RETRY_RISK_STATUS = 240L;

    /** 重试次数（风险金额） */
    public static final long RETRY_RISK_AMOUNT = 245L;

    /** 重试次数（风险数量） */
    public static final long RETRY_RISK_COUNT = 250L;

    /** 重试次数（风险比率） */
    public static final long RETRY_RISK_RATE = 255L;

    /** 重试次数（风险日期） */
    public static final long RETRY_RISK_DATE = 260L;

    /** 重试次数（风险时间） */
    public static final long RETRY_RISK_TIME = 265L;

    /** 重试次数（风险标记） */
    public static final long RETRY_RISK_FLAG = 270L;

    /** 重试次数（风险说明） */
    public static final long RETRY_RISK_REMARK = 275L;

    /** 重试次数（风险来源） */
    public static final long RETRY_RISK_SOURCE = 280L;

    /** 重试次数（风险版本） */
    public static final long RETRY_RISK_VERSION = 285L;

    /** 重试次数（风险区域） */
    public static final long RETRY_RISK_REGION = 290L;

    /** 重试次数（风险渠道） */
    public static final long RETRY_RISK_CHANNEL = 295L;

    /** 重试次数（风险分组） */
    public static final long RETRY_RISK_GROUP = 300L;

    private CustRiskItemJobConfig() {
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

    /** 重试次数（银行状态）。 */
    public static long resolveRetryBankStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_STATUS;
        }
        if (requested > RETRY_BANK_STATUS) {
            return RETRY_BANK_STATUS;
        }
        return requested;
    }

    /** 重试次数（银行金额）。 */
    public static long resolveRetryBankAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_AMOUNT;
        }
        if (requested > RETRY_BANK_AMOUNT) {
            return RETRY_BANK_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（银行数量）。 */
    public static long resolveRetryBankCount(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_COUNT;
        }
        if (requested > RETRY_BANK_COUNT) {
            return RETRY_BANK_COUNT;
        }
        return requested;
    }

    /** 重试次数（银行比率）。 */
    public static long resolveRetryBankRate(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_RATE;
        }
        if (requested > RETRY_BANK_RATE) {
            return RETRY_BANK_RATE;
        }
        return requested;
    }

    /** 重试次数（银行日期）。 */
    public static long resolveRetryBankDate(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_DATE;
        }
        if (requested > RETRY_BANK_DATE) {
            return RETRY_BANK_DATE;
        }
        return requested;
    }

    /** 重试次数（银行时间）。 */
    public static long resolveRetryBankTime(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_TIME;
        }
        if (requested > RETRY_BANK_TIME) {
            return RETRY_BANK_TIME;
        }
        return requested;
    }

    /** 重试次数（银行标记）。 */
    public static long resolveRetryBankFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_FLAG;
        }
        if (requested > RETRY_BANK_FLAG) {
            return RETRY_BANK_FLAG;
        }
        return requested;
    }

    /** 重试次数（银行说明）。 */
    public static long resolveRetryBankRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_REMARK;
        }
        if (requested > RETRY_BANK_REMARK) {
            return RETRY_BANK_REMARK;
        }
        return requested;
    }

    /** 重试次数（银行来源）。 */
    public static long resolveRetryBankSource(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_SOURCE;
        }
        if (requested > RETRY_BANK_SOURCE) {
            return RETRY_BANK_SOURCE;
        }
        return requested;
    }

    /** 重试次数（银行版本）。 */
    public static long resolveRetryBankVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_VERSION;
        }
        if (requested > RETRY_BANK_VERSION) {
            return RETRY_BANK_VERSION;
        }
        return requested;
    }

    /** 重试次数（银行区域）。 */
    public static long resolveRetryBankRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_REGION;
        }
        if (requested > RETRY_BANK_REGION) {
            return RETRY_BANK_REGION;
        }
        return requested;
    }

    /** 重试次数（银行渠道）。 */
    public static long resolveRetryBankChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_CHANNEL;
        }
        if (requested > RETRY_BANK_CHANNEL) {
            return RETRY_BANK_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（银行分组）。 */
    public static long resolveRetryBankGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_BANK_GROUP;
        }
        if (requested > RETRY_BANK_GROUP) {
            return RETRY_BANK_GROUP;
        }
        return requested;
    }

}

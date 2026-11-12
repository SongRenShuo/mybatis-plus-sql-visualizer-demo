package cn.song.custmetadata.config;

/**
 * 客户订单JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustOrderJobConfig {

    public static final String MODULE_CODE = "CUST_ORDER_JOB_CONFIG";

    /** 批处理条数（银行时间） */
    public static final long BATCH_BANK_TIME = 5L;

    /** 批处理条数（银行标记） */
    public static final long BATCH_BANK_FLAG = 10L;

    /** 批处理条数（银行说明） */
    public static final long BATCH_BANK_REMARK = 15L;

    /** 批处理条数（银行来源） */
    public static final long BATCH_BANK_SOURCE = 20L;

    /** 批处理条数（银行版本） */
    public static final long BATCH_BANK_VERSION = 25L;

    /** 批处理条数（银行区域） */
    public static final long BATCH_BANK_REGION = 30L;

    /** 批处理条数（银行渠道） */
    public static final long BATCH_BANK_CHANNEL = 35L;

    /** 批处理条数（银行分组） */
    public static final long BATCH_BANK_GROUP = 40L;

    /** 批处理条数（银行标签） */
    public static final long BATCH_BANK_TAG = 45L;

    /** 批处理条数（银行负责人） */
    public static final long BATCH_BANK_OWNER = 50L;

    /** 批处理条数（资产编号） */
    public static final long BATCH_ASSET_NO = 55L;

    /** 批处理条数（资产名称） */
    public static final long BATCH_ASSET_NAME = 60L;

    /** 批处理条数（资产类型） */
    public static final long BATCH_ASSET_TYPE = 65L;

    /** 批处理条数（资产编码） */
    public static final long BATCH_ASSET_CODE = 70L;

    /** 批处理条数（资产级别） */
    public static final long BATCH_ASSET_LEVEL = 75L;

    /** 批处理条数（资产状态） */
    public static final long BATCH_ASSET_STATUS = 80L;

    /** 批处理条数（资产金额） */
    public static final long BATCH_ASSET_AMOUNT = 85L;

    /** 批处理条数（资产数量） */
    public static final long BATCH_ASSET_COUNT = 90L;

    /** 批处理条数（资产比率） */
    public static final long BATCH_ASSET_RATE = 95L;

    /** 批处理条数（资产日期） */
    public static final long BATCH_ASSET_DATE = 100L;

    /** 批处理条数（资产时间） */
    public static final long BATCH_ASSET_TIME = 105L;

    /** 批处理条数（资产标记） */
    public static final long BATCH_ASSET_FLAG = 110L;

    /** 批处理条数（资产说明） */
    public static final long BATCH_ASSET_REMARK = 115L;

    /** 批处理条数（资产来源） */
    public static final long BATCH_ASSET_SOURCE = 120L;

    /** 批处理条数（资产版本） */
    public static final long BATCH_ASSET_VERSION = 125L;

    /** 批处理条数（资产区域） */
    public static final long BATCH_ASSET_REGION = 130L;

    /** 批处理条数（资产渠道） */
    public static final long BATCH_ASSET_CHANNEL = 135L;

    /** 批处理条数（资产分组） */
    public static final long BATCH_ASSET_GROUP = 140L;

    /** 批处理条数（资产标签） */
    public static final long BATCH_ASSET_TAG = 145L;

    /** 批处理条数（资产负责人） */
    public static final long BATCH_ASSET_OWNER = 150L;

    /** 批处理条数（风险编号） */
    public static final long BATCH_RISK_NO = 155L;

    /** 批处理条数（风险名称） */
    public static final long BATCH_RISK_NAME = 160L;

    /** 批处理条数（风险类型） */
    public static final long BATCH_RISK_TYPE = 165L;

    /** 批处理条数（风险编码） */
    public static final long BATCH_RISK_CODE = 170L;

    /** 批处理条数（风险级别） */
    public static final long BATCH_RISK_LEVEL = 175L;

    /** 批处理条数（风险状态） */
    public static final long BATCH_RISK_STATUS = 180L;

    /** 批处理条数（风险金额） */
    public static final long BATCH_RISK_AMOUNT = 185L;

    /** 批处理条数（风险数量） */
    public static final long BATCH_RISK_COUNT = 190L;

    /** 批处理条数（风险比率） */
    public static final long BATCH_RISK_RATE = 195L;

    /** 批处理条数（风险日期） */
    public static final long BATCH_RISK_DATE = 200L;

    /** 批处理条数（风险时间） */
    public static final long BATCH_RISK_TIME = 205L;

    /** 批处理条数（风险标记） */
    public static final long BATCH_RISK_FLAG = 210L;

    /** 批处理条数（风险说明） */
    public static final long BATCH_RISK_REMARK = 215L;

    /** 批处理条数（风险来源） */
    public static final long BATCH_RISK_SOURCE = 220L;

    /** 批处理条数（风险版本） */
    public static final long BATCH_RISK_VERSION = 225L;

    /** 批处理条数（风险区域） */
    public static final long BATCH_RISK_REGION = 230L;

    /** 批处理条数（风险渠道） */
    public static final long BATCH_RISK_CHANNEL = 235L;

    /** 批处理条数（风险分组） */
    public static final long BATCH_RISK_GROUP = 240L;

    /** 批处理条数（风险标签） */
    public static final long BATCH_RISK_TAG = 245L;

    /** 批处理条数（风险负责人） */
    public static final long BATCH_RISK_OWNER = 250L;

    /** 批处理条数（信用编号） */
    public static final long BATCH_CREDIT_NO = 255L;

    /** 批处理条数（信用名称） */
    public static final long BATCH_CREDIT_NAME = 260L;

    /** 批处理条数（信用类型） */
    public static final long BATCH_CREDIT_TYPE = 265L;

    /** 批处理条数（信用编码） */
    public static final long BATCH_CREDIT_CODE = 270L;

    /** 批处理条数（信用级别） */
    public static final long BATCH_CREDIT_LEVEL = 275L;

    /** 批处理条数（信用状态） */
    public static final long BATCH_CREDIT_STATUS = 280L;

    /** 批处理条数（信用金额） */
    public static final long BATCH_CREDIT_AMOUNT = 285L;

    /** 批处理条数（信用数量） */
    public static final long BATCH_CREDIT_COUNT = 290L;

    /** 批处理条数（信用比率） */
    public static final long BATCH_CREDIT_RATE = 295L;

    /** 批处理条数（信用日期） */
    public static final long BATCH_CREDIT_DATE = 300L;

    private CustOrderJobConfig() {
    }

    /** 批处理条数（银行时间）。 */
    public static long resolveBatchBankTime(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_TIME;
        }
        if (requested > BATCH_BANK_TIME) {
            return BATCH_BANK_TIME;
        }
        return requested;
    }

    /** 批处理条数（银行标记）。 */
    public static long resolveBatchBankFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_FLAG;
        }
        if (requested > BATCH_BANK_FLAG) {
            return BATCH_BANK_FLAG;
        }
        return requested;
    }

    /** 批处理条数（银行说明）。 */
    public static long resolveBatchBankRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_REMARK;
        }
        if (requested > BATCH_BANK_REMARK) {
            return BATCH_BANK_REMARK;
        }
        return requested;
    }

    /** 批处理条数（银行来源）。 */
    public static long resolveBatchBankSource(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_SOURCE;
        }
        if (requested > BATCH_BANK_SOURCE) {
            return BATCH_BANK_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（银行版本）。 */
    public static long resolveBatchBankVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_VERSION;
        }
        if (requested > BATCH_BANK_VERSION) {
            return BATCH_BANK_VERSION;
        }
        return requested;
    }

    /** 批处理条数（银行区域）。 */
    public static long resolveBatchBankRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_REGION;
        }
        if (requested > BATCH_BANK_REGION) {
            return BATCH_BANK_REGION;
        }
        return requested;
    }

    /** 批处理条数（银行渠道）。 */
    public static long resolveBatchBankChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_CHANNEL;
        }
        if (requested > BATCH_BANK_CHANNEL) {
            return BATCH_BANK_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（银行分组）。 */
    public static long resolveBatchBankGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_GROUP;
        }
        if (requested > BATCH_BANK_GROUP) {
            return BATCH_BANK_GROUP;
        }
        return requested;
    }

    /** 批处理条数（银行标签）。 */
    public static long resolveBatchBankTag(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_TAG;
        }
        if (requested > BATCH_BANK_TAG) {
            return BATCH_BANK_TAG;
        }
        return requested;
    }

    /** 批处理条数（银行负责人）。 */
    public static long resolveBatchBankOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_OWNER;
        }
        if (requested > BATCH_BANK_OWNER) {
            return BATCH_BANK_OWNER;
        }
        return requested;
    }

    /** 批处理条数（资产编号）。 */
    public static long resolveBatchAssetNo(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_NO;
        }
        if (requested > BATCH_ASSET_NO) {
            return BATCH_ASSET_NO;
        }
        return requested;
    }

    /** 批处理条数（资产名称）。 */
    public static long resolveBatchAssetName(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_NAME;
        }
        if (requested > BATCH_ASSET_NAME) {
            return BATCH_ASSET_NAME;
        }
        return requested;
    }

    /** 批处理条数（资产类型）。 */
    public static long resolveBatchAssetType(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_TYPE;
        }
        if (requested > BATCH_ASSET_TYPE) {
            return BATCH_ASSET_TYPE;
        }
        return requested;
    }

    /** 批处理条数（资产编码）。 */
    public static long resolveBatchAssetCode(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_CODE;
        }
        if (requested > BATCH_ASSET_CODE) {
            return BATCH_ASSET_CODE;
        }
        return requested;
    }

    /** 批处理条数（资产级别）。 */
    public static long resolveBatchAssetLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_LEVEL;
        }
        if (requested > BATCH_ASSET_LEVEL) {
            return BATCH_ASSET_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（资产状态）。 */
    public static long resolveBatchAssetStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_STATUS;
        }
        if (requested > BATCH_ASSET_STATUS) {
            return BATCH_ASSET_STATUS;
        }
        return requested;
    }

    /** 批处理条数（资产金额）。 */
    public static long resolveBatchAssetAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_AMOUNT;
        }
        if (requested > BATCH_ASSET_AMOUNT) {
            return BATCH_ASSET_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（资产数量）。 */
    public static long resolveBatchAssetCount(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_COUNT;
        }
        if (requested > BATCH_ASSET_COUNT) {
            return BATCH_ASSET_COUNT;
        }
        return requested;
    }

    /** 批处理条数（资产比率）。 */
    public static long resolveBatchAssetRate(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_RATE;
        }
        if (requested > BATCH_ASSET_RATE) {
            return BATCH_ASSET_RATE;
        }
        return requested;
    }

    /** 批处理条数（资产日期）。 */
    public static long resolveBatchAssetDate(long requested) {
        if (requested <= 0L) {
            return BATCH_ASSET_DATE;
        }
        if (requested > BATCH_ASSET_DATE) {
            return BATCH_ASSET_DATE;
        }
        return requested;
    }

}

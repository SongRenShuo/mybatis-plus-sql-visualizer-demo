package cn.song.custmetadata.config;

/**
 * 客户订单CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustOrderCacheConfig {

    public static final String MODULE_CODE = "CUST_ORDER_CACHE_CONFIG";

    /** 批处理条数（证件分组） */
    public static final long BATCH_CERT_GROUP = 5L;

    /** 批处理条数（证件标签） */
    public static final long BATCH_CERT_TAG = 10L;

    /** 批处理条数（证件负责人） */
    public static final long BATCH_CERT_OWNER = 15L;

    /** 批处理条数（银行编号） */
    public static final long BATCH_BANK_NO = 20L;

    /** 批处理条数（银行名称） */
    public static final long BATCH_BANK_NAME = 25L;

    /** 批处理条数（银行类型） */
    public static final long BATCH_BANK_TYPE = 30L;

    /** 批处理条数（银行编码） */
    public static final long BATCH_BANK_CODE = 35L;

    /** 批处理条数（银行级别） */
    public static final long BATCH_BANK_LEVEL = 40L;

    /** 批处理条数（银行状态） */
    public static final long BATCH_BANK_STATUS = 45L;

    /** 批处理条数（银行金额） */
    public static final long BATCH_BANK_AMOUNT = 50L;

    /** 批处理条数（银行数量） */
    public static final long BATCH_BANK_COUNT = 55L;

    /** 批处理条数（银行比率） */
    public static final long BATCH_BANK_RATE = 60L;

    /** 批处理条数（银行日期） */
    public static final long BATCH_BANK_DATE = 65L;

    /** 批处理条数（银行时间） */
    public static final long BATCH_BANK_TIME = 70L;

    /** 批处理条数（银行标记） */
    public static final long BATCH_BANK_FLAG = 75L;

    /** 批处理条数（银行说明） */
    public static final long BATCH_BANK_REMARK = 80L;

    /** 批处理条数（银行来源） */
    public static final long BATCH_BANK_SOURCE = 85L;

    /** 批处理条数（银行版本） */
    public static final long BATCH_BANK_VERSION = 90L;

    /** 批处理条数（银行区域） */
    public static final long BATCH_BANK_REGION = 95L;

    /** 批处理条数（银行渠道） */
    public static final long BATCH_BANK_CHANNEL = 100L;

    /** 批处理条数（银行分组） */
    public static final long BATCH_BANK_GROUP = 105L;

    /** 批处理条数（银行标签） */
    public static final long BATCH_BANK_TAG = 110L;

    /** 批处理条数（银行负责人） */
    public static final long BATCH_BANK_OWNER = 115L;

    /** 批处理条数（资产编号） */
    public static final long BATCH_ASSET_NO = 120L;

    /** 批处理条数（资产名称） */
    public static final long BATCH_ASSET_NAME = 125L;

    /** 批处理条数（资产类型） */
    public static final long BATCH_ASSET_TYPE = 130L;

    /** 批处理条数（资产编码） */
    public static final long BATCH_ASSET_CODE = 135L;

    /** 批处理条数（资产级别） */
    public static final long BATCH_ASSET_LEVEL = 140L;

    /** 批处理条数（资产状态） */
    public static final long BATCH_ASSET_STATUS = 145L;

    /** 批处理条数（资产金额） */
    public static final long BATCH_ASSET_AMOUNT = 150L;

    /** 批处理条数（资产数量） */
    public static final long BATCH_ASSET_COUNT = 155L;

    /** 批处理条数（资产比率） */
    public static final long BATCH_ASSET_RATE = 160L;

    /** 批处理条数（资产日期） */
    public static final long BATCH_ASSET_DATE = 165L;

    /** 批处理条数（资产时间） */
    public static final long BATCH_ASSET_TIME = 170L;

    /** 批处理条数（资产标记） */
    public static final long BATCH_ASSET_FLAG = 175L;

    /** 批处理条数（资产说明） */
    public static final long BATCH_ASSET_REMARK = 180L;

    /** 批处理条数（资产来源） */
    public static final long BATCH_ASSET_SOURCE = 185L;

    /** 批处理条数（资产版本） */
    public static final long BATCH_ASSET_VERSION = 190L;

    /** 批处理条数（资产区域） */
    public static final long BATCH_ASSET_REGION = 195L;

    /** 批处理条数（资产渠道） */
    public static final long BATCH_ASSET_CHANNEL = 200L;

    /** 批处理条数（资产分组） */
    public static final long BATCH_ASSET_GROUP = 205L;

    /** 批处理条数（资产标签） */
    public static final long BATCH_ASSET_TAG = 210L;

    /** 批处理条数（资产负责人） */
    public static final long BATCH_ASSET_OWNER = 215L;

    /** 批处理条数（风险编号） */
    public static final long BATCH_RISK_NO = 220L;

    /** 批处理条数（风险名称） */
    public static final long BATCH_RISK_NAME = 225L;

    /** 批处理条数（风险类型） */
    public static final long BATCH_RISK_TYPE = 230L;

    /** 批处理条数（风险编码） */
    public static final long BATCH_RISK_CODE = 235L;

    /** 批处理条数（风险级别） */
    public static final long BATCH_RISK_LEVEL = 240L;

    /** 批处理条数（风险状态） */
    public static final long BATCH_RISK_STATUS = 245L;

    /** 批处理条数（风险金额） */
    public static final long BATCH_RISK_AMOUNT = 250L;

    /** 批处理条数（风险数量） */
    public static final long BATCH_RISK_COUNT = 255L;

    /** 批处理条数（风险比率） */
    public static final long BATCH_RISK_RATE = 260L;

    /** 批处理条数（风险日期） */
    public static final long BATCH_RISK_DATE = 265L;

    /** 批处理条数（风险时间） */
    public static final long BATCH_RISK_TIME = 270L;

    /** 批处理条数（风险标记） */
    public static final long BATCH_RISK_FLAG = 275L;

    /** 批处理条数（风险说明） */
    public static final long BATCH_RISK_REMARK = 280L;

    /** 批处理条数（风险来源） */
    public static final long BATCH_RISK_SOURCE = 285L;

    /** 批处理条数（风险版本） */
    public static final long BATCH_RISK_VERSION = 290L;

    /** 批处理条数（风险区域） */
    public static final long BATCH_RISK_REGION = 295L;

    /** 批处理条数（风险渠道） */
    public static final long BATCH_RISK_CHANNEL = 300L;

    private CustOrderCacheConfig() {
    }

    /** 批处理条数（证件分组）。 */
    public static long resolveBatchCertGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_CERT_GROUP;
        }
        if (requested > BATCH_CERT_GROUP) {
            return BATCH_CERT_GROUP;
        }
        return requested;
    }

    /** 批处理条数（证件标签）。 */
    public static long resolveBatchCertTag(long requested) {
        if (requested <= 0L) {
            return BATCH_CERT_TAG;
        }
        if (requested > BATCH_CERT_TAG) {
            return BATCH_CERT_TAG;
        }
        return requested;
    }

    /** 批处理条数（证件负责人）。 */
    public static long resolveBatchCertOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_CERT_OWNER;
        }
        if (requested > BATCH_CERT_OWNER) {
            return BATCH_CERT_OWNER;
        }
        return requested;
    }

    /** 批处理条数（银行编号）。 */
    public static long resolveBatchBankNo(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_NO;
        }
        if (requested > BATCH_BANK_NO) {
            return BATCH_BANK_NO;
        }
        return requested;
    }

    /** 批处理条数（银行名称）。 */
    public static long resolveBatchBankName(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_NAME;
        }
        if (requested > BATCH_BANK_NAME) {
            return BATCH_BANK_NAME;
        }
        return requested;
    }

    /** 批处理条数（银行类型）。 */
    public static long resolveBatchBankType(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_TYPE;
        }
        if (requested > BATCH_BANK_TYPE) {
            return BATCH_BANK_TYPE;
        }
        return requested;
    }

    /** 批处理条数（银行编码）。 */
    public static long resolveBatchBankCode(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_CODE;
        }
        if (requested > BATCH_BANK_CODE) {
            return BATCH_BANK_CODE;
        }
        return requested;
    }

    /** 批处理条数（银行级别）。 */
    public static long resolveBatchBankLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_LEVEL;
        }
        if (requested > BATCH_BANK_LEVEL) {
            return BATCH_BANK_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（银行状态）。 */
    public static long resolveBatchBankStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_STATUS;
        }
        if (requested > BATCH_BANK_STATUS) {
            return BATCH_BANK_STATUS;
        }
        return requested;
    }

    /** 批处理条数（银行金额）。 */
    public static long resolveBatchBankAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_AMOUNT;
        }
        if (requested > BATCH_BANK_AMOUNT) {
            return BATCH_BANK_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（银行数量）。 */
    public static long resolveBatchBankCount(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_COUNT;
        }
        if (requested > BATCH_BANK_COUNT) {
            return BATCH_BANK_COUNT;
        }
        return requested;
    }

    /** 批处理条数（银行比率）。 */
    public static long resolveBatchBankRate(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_RATE;
        }
        if (requested > BATCH_BANK_RATE) {
            return BATCH_BANK_RATE;
        }
        return requested;
    }

    /** 批处理条数（银行日期）。 */
    public static long resolveBatchBankDate(long requested) {
        if (requested <= 0L) {
            return BATCH_BANK_DATE;
        }
        if (requested > BATCH_BANK_DATE) {
            return BATCH_BANK_DATE;
        }
        return requested;
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

}

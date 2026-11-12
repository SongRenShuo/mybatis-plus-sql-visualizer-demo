package cn.song.custmetadata.config;

/**
 * 客户信息JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustInfoJobConfig {

    public static final String MODULE_CODE = "CUST_INFO_JOB_CONFIG";

    /** 单次查询上限（证件金额） */
    public static final long LIMIT_CERT_AMOUNT = 5L;

    /** 单次查询上限（证件数量） */
    public static final long LIMIT_CERT_COUNT = 10L;

    /** 单次查询上限（证件比率） */
    public static final long LIMIT_CERT_RATE = 15L;

    /** 单次查询上限（证件日期） */
    public static final long LIMIT_CERT_DATE = 20L;

    /** 单次查询上限（证件时间） */
    public static final long LIMIT_CERT_TIME = 25L;

    /** 单次查询上限（证件标记） */
    public static final long LIMIT_CERT_FLAG = 30L;

    /** 单次查询上限（证件说明） */
    public static final long LIMIT_CERT_REMARK = 35L;

    /** 单次查询上限（证件来源） */
    public static final long LIMIT_CERT_SOURCE = 40L;

    /** 单次查询上限（证件版本） */
    public static final long LIMIT_CERT_VERSION = 45L;

    /** 单次查询上限（证件区域） */
    public static final long LIMIT_CERT_REGION = 50L;

    /** 单次查询上限（证件渠道） */
    public static final long LIMIT_CERT_CHANNEL = 55L;

    /** 单次查询上限（证件分组） */
    public static final long LIMIT_CERT_GROUP = 60L;

    /** 单次查询上限（证件标签） */
    public static final long LIMIT_CERT_TAG = 65L;

    /** 单次查询上限（证件负责人） */
    public static final long LIMIT_CERT_OWNER = 70L;

    /** 单次查询上限（银行编号） */
    public static final long LIMIT_BANK_NO = 75L;

    /** 单次查询上限（银行名称） */
    public static final long LIMIT_BANK_NAME = 80L;

    /** 单次查询上限（银行类型） */
    public static final long LIMIT_BANK_TYPE = 85L;

    /** 单次查询上限（银行编码） */
    public static final long LIMIT_BANK_CODE = 90L;

    /** 单次查询上限（银行级别） */
    public static final long LIMIT_BANK_LEVEL = 95L;

    /** 单次查询上限（银行状态） */
    public static final long LIMIT_BANK_STATUS = 100L;

    /** 单次查询上限（银行金额） */
    public static final long LIMIT_BANK_AMOUNT = 105L;

    /** 单次查询上限（银行数量） */
    public static final long LIMIT_BANK_COUNT = 110L;

    /** 单次查询上限（银行比率） */
    public static final long LIMIT_BANK_RATE = 115L;

    /** 单次查询上限（银行日期） */
    public static final long LIMIT_BANK_DATE = 120L;

    /** 单次查询上限（银行时间） */
    public static final long LIMIT_BANK_TIME = 125L;

    /** 单次查询上限（银行标记） */
    public static final long LIMIT_BANK_FLAG = 130L;

    /** 单次查询上限（银行说明） */
    public static final long LIMIT_BANK_REMARK = 135L;

    /** 单次查询上限（银行来源） */
    public static final long LIMIT_BANK_SOURCE = 140L;

    /** 单次查询上限（银行版本） */
    public static final long LIMIT_BANK_VERSION = 145L;

    /** 单次查询上限（银行区域） */
    public static final long LIMIT_BANK_REGION = 150L;

    /** 单次查询上限（银行渠道） */
    public static final long LIMIT_BANK_CHANNEL = 155L;

    /** 单次查询上限（银行分组） */
    public static final long LIMIT_BANK_GROUP = 160L;

    /** 单次查询上限（银行标签） */
    public static final long LIMIT_BANK_TAG = 165L;

    /** 单次查询上限（银行负责人） */
    public static final long LIMIT_BANK_OWNER = 170L;

    /** 单次查询上限（资产编号） */
    public static final long LIMIT_ASSET_NO = 175L;

    /** 单次查询上限（资产名称） */
    public static final long LIMIT_ASSET_NAME = 180L;

    /** 单次查询上限（资产类型） */
    public static final long LIMIT_ASSET_TYPE = 185L;

    /** 单次查询上限（资产编码） */
    public static final long LIMIT_ASSET_CODE = 190L;

    /** 单次查询上限（资产级别） */
    public static final long LIMIT_ASSET_LEVEL = 195L;

    /** 单次查询上限（资产状态） */
    public static final long LIMIT_ASSET_STATUS = 200L;

    /** 单次查询上限（资产金额） */
    public static final long LIMIT_ASSET_AMOUNT = 205L;

    /** 单次查询上限（资产数量） */
    public static final long LIMIT_ASSET_COUNT = 210L;

    /** 单次查询上限（资产比率） */
    public static final long LIMIT_ASSET_RATE = 215L;

    /** 单次查询上限（资产日期） */
    public static final long LIMIT_ASSET_DATE = 220L;

    /** 单次查询上限（资产时间） */
    public static final long LIMIT_ASSET_TIME = 225L;

    /** 单次查询上限（资产标记） */
    public static final long LIMIT_ASSET_FLAG = 230L;

    /** 单次查询上限（资产说明） */
    public static final long LIMIT_ASSET_REMARK = 235L;

    /** 单次查询上限（资产来源） */
    public static final long LIMIT_ASSET_SOURCE = 240L;

    /** 单次查询上限（资产版本） */
    public static final long LIMIT_ASSET_VERSION = 245L;

    /** 单次查询上限（资产区域） */
    public static final long LIMIT_ASSET_REGION = 250L;

    /** 单次查询上限（资产渠道） */
    public static final long LIMIT_ASSET_CHANNEL = 255L;

    /** 单次查询上限（资产分组） */
    public static final long LIMIT_ASSET_GROUP = 260L;

    /** 单次查询上限（资产标签） */
    public static final long LIMIT_ASSET_TAG = 265L;

    /** 单次查询上限（资产负责人） */
    public static final long LIMIT_ASSET_OWNER = 270L;

    /** 单次查询上限（风险编号） */
    public static final long LIMIT_RISK_NO = 275L;

    /** 单次查询上限（风险名称） */
    public static final long LIMIT_RISK_NAME = 280L;

    /** 单次查询上限（风险类型） */
    public static final long LIMIT_RISK_TYPE = 285L;

    /** 单次查询上限（风险编码） */
    public static final long LIMIT_RISK_CODE = 290L;

    /** 单次查询上限（风险级别） */
    public static final long LIMIT_RISK_LEVEL = 295L;

    /** 单次查询上限（风险状态） */
    public static final long LIMIT_RISK_STATUS = 300L;

    private CustInfoJobConfig() {
    }

    /** 单次查询上限（证件金额）。 */
    public static long resolveLimitCertAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_AMOUNT;
        }
        if (requested > LIMIT_CERT_AMOUNT) {
            return LIMIT_CERT_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（证件数量）。 */
    public static long resolveLimitCertCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_COUNT;
        }
        if (requested > LIMIT_CERT_COUNT) {
            return LIMIT_CERT_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（证件比率）。 */
    public static long resolveLimitCertRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_RATE;
        }
        if (requested > LIMIT_CERT_RATE) {
            return LIMIT_CERT_RATE;
        }
        return requested;
    }

    /** 单次查询上限（证件日期）。 */
    public static long resolveLimitCertDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_DATE;
        }
        if (requested > LIMIT_CERT_DATE) {
            return LIMIT_CERT_DATE;
        }
        return requested;
    }

    /** 单次查询上限（证件时间）。 */
    public static long resolveLimitCertTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_TIME;
        }
        if (requested > LIMIT_CERT_TIME) {
            return LIMIT_CERT_TIME;
        }
        return requested;
    }

    /** 单次查询上限（证件标记）。 */
    public static long resolveLimitCertFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_FLAG;
        }
        if (requested > LIMIT_CERT_FLAG) {
            return LIMIT_CERT_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（证件说明）。 */
    public static long resolveLimitCertRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_REMARK;
        }
        if (requested > LIMIT_CERT_REMARK) {
            return LIMIT_CERT_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（证件来源）。 */
    public static long resolveLimitCertSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_SOURCE;
        }
        if (requested > LIMIT_CERT_SOURCE) {
            return LIMIT_CERT_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（证件版本）。 */
    public static long resolveLimitCertVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_VERSION;
        }
        if (requested > LIMIT_CERT_VERSION) {
            return LIMIT_CERT_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（证件区域）。 */
    public static long resolveLimitCertRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_REGION;
        }
        if (requested > LIMIT_CERT_REGION) {
            return LIMIT_CERT_REGION;
        }
        return requested;
    }

    /** 单次查询上限（证件渠道）。 */
    public static long resolveLimitCertChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_CHANNEL;
        }
        if (requested > LIMIT_CERT_CHANNEL) {
            return LIMIT_CERT_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（证件分组）。 */
    public static long resolveLimitCertGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_GROUP;
        }
        if (requested > LIMIT_CERT_GROUP) {
            return LIMIT_CERT_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（证件标签）。 */
    public static long resolveLimitCertTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_TAG;
        }
        if (requested > LIMIT_CERT_TAG) {
            return LIMIT_CERT_TAG;
        }
        return requested;
    }

    /** 单次查询上限（证件负责人）。 */
    public static long resolveLimitCertOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_OWNER;
        }
        if (requested > LIMIT_CERT_OWNER) {
            return LIMIT_CERT_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（银行编号）。 */
    public static long resolveLimitBankNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_BANK_NO;
        }
        if (requested > LIMIT_BANK_NO) {
            return LIMIT_BANK_NO;
        }
        return requested;
    }

    /** 单次查询上限（银行名称）。 */
    public static long resolveLimitBankName(long requested) {
        if (requested <= 0L) {
            return LIMIT_BANK_NAME;
        }
        if (requested > LIMIT_BANK_NAME) {
            return LIMIT_BANK_NAME;
        }
        return requested;
    }

    /** 单次查询上限（银行类型）。 */
    public static long resolveLimitBankType(long requested) {
        if (requested <= 0L) {
            return LIMIT_BANK_TYPE;
        }
        if (requested > LIMIT_BANK_TYPE) {
            return LIMIT_BANK_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（银行编码）。 */
    public static long resolveLimitBankCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_BANK_CODE;
        }
        if (requested > LIMIT_BANK_CODE) {
            return LIMIT_BANK_CODE;
        }
        return requested;
    }

    /** 单次查询上限（银行级别）。 */
    public static long resolveLimitBankLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_BANK_LEVEL;
        }
        if (requested > LIMIT_BANK_LEVEL) {
            return LIMIT_BANK_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（银行状态）。 */
    public static long resolveLimitBankStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_BANK_STATUS;
        }
        if (requested > LIMIT_BANK_STATUS) {
            return LIMIT_BANK_STATUS;
        }
        return requested;
    }

}

package cn.song.custmetadata.config;

/**
 * 客户信息CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustInfoCacheConfig {

    public static final String MODULE_CODE = "CUST_INFO_CACHE_CONFIG";

    /** 单次查询上限（客户来源） */
    public static final long LIMIT_CUST_SOURCE = 5L;

    /** 单次查询上限（客户版本） */
    public static final long LIMIT_CUST_VERSION = 10L;

    /** 单次查询上限（客户区域） */
    public static final long LIMIT_CUST_REGION = 15L;

    /** 单次查询上限（客户渠道） */
    public static final long LIMIT_CUST_CHANNEL = 20L;

    /** 单次查询上限（客户分组） */
    public static final long LIMIT_CUST_GROUP = 25L;

    /** 单次查询上限（客户标签） */
    public static final long LIMIT_CUST_TAG = 30L;

    /** 单次查询上限（客户负责人） */
    public static final long LIMIT_CUST_OWNER = 35L;

    /** 单次查询上限（证件编号） */
    public static final long LIMIT_CERT_NO = 40L;

    /** 单次查询上限（证件名称） */
    public static final long LIMIT_CERT_NAME = 45L;

    /** 单次查询上限（证件类型） */
    public static final long LIMIT_CERT_TYPE = 50L;

    /** 单次查询上限（证件编码） */
    public static final long LIMIT_CERT_CODE = 55L;

    /** 单次查询上限（证件级别） */
    public static final long LIMIT_CERT_LEVEL = 60L;

    /** 单次查询上限（证件状态） */
    public static final long LIMIT_CERT_STATUS = 65L;

    /** 单次查询上限（证件金额） */
    public static final long LIMIT_CERT_AMOUNT = 70L;

    /** 单次查询上限（证件数量） */
    public static final long LIMIT_CERT_COUNT = 75L;

    /** 单次查询上限（证件比率） */
    public static final long LIMIT_CERT_RATE = 80L;

    /** 单次查询上限（证件日期） */
    public static final long LIMIT_CERT_DATE = 85L;

    /** 单次查询上限（证件时间） */
    public static final long LIMIT_CERT_TIME = 90L;

    /** 单次查询上限（证件标记） */
    public static final long LIMIT_CERT_FLAG = 95L;

    /** 单次查询上限（证件说明） */
    public static final long LIMIT_CERT_REMARK = 100L;

    /** 单次查询上限（证件来源） */
    public static final long LIMIT_CERT_SOURCE = 105L;

    /** 单次查询上限（证件版本） */
    public static final long LIMIT_CERT_VERSION = 110L;

    /** 单次查询上限（证件区域） */
    public static final long LIMIT_CERT_REGION = 115L;

    /** 单次查询上限（证件渠道） */
    public static final long LIMIT_CERT_CHANNEL = 120L;

    /** 单次查询上限（证件分组） */
    public static final long LIMIT_CERT_GROUP = 125L;

    /** 单次查询上限（证件标签） */
    public static final long LIMIT_CERT_TAG = 130L;

    /** 单次查询上限（证件负责人） */
    public static final long LIMIT_CERT_OWNER = 135L;

    /** 单次查询上限（银行编号） */
    public static final long LIMIT_BANK_NO = 140L;

    /** 单次查询上限（银行名称） */
    public static final long LIMIT_BANK_NAME = 145L;

    /** 单次查询上限（银行类型） */
    public static final long LIMIT_BANK_TYPE = 150L;

    /** 单次查询上限（银行编码） */
    public static final long LIMIT_BANK_CODE = 155L;

    /** 单次查询上限（银行级别） */
    public static final long LIMIT_BANK_LEVEL = 160L;

    /** 单次查询上限（银行状态） */
    public static final long LIMIT_BANK_STATUS = 165L;

    /** 单次查询上限（银行金额） */
    public static final long LIMIT_BANK_AMOUNT = 170L;

    /** 单次查询上限（银行数量） */
    public static final long LIMIT_BANK_COUNT = 175L;

    /** 单次查询上限（银行比率） */
    public static final long LIMIT_BANK_RATE = 180L;

    /** 单次查询上限（银行日期） */
    public static final long LIMIT_BANK_DATE = 185L;

    /** 单次查询上限（银行时间） */
    public static final long LIMIT_BANK_TIME = 190L;

    /** 单次查询上限（银行标记） */
    public static final long LIMIT_BANK_FLAG = 195L;

    /** 单次查询上限（银行说明） */
    public static final long LIMIT_BANK_REMARK = 200L;

    /** 单次查询上限（银行来源） */
    public static final long LIMIT_BANK_SOURCE = 205L;

    /** 单次查询上限（银行版本） */
    public static final long LIMIT_BANK_VERSION = 210L;

    /** 单次查询上限（银行区域） */
    public static final long LIMIT_BANK_REGION = 215L;

    /** 单次查询上限（银行渠道） */
    public static final long LIMIT_BANK_CHANNEL = 220L;

    /** 单次查询上限（银行分组） */
    public static final long LIMIT_BANK_GROUP = 225L;

    /** 单次查询上限（银行标签） */
    public static final long LIMIT_BANK_TAG = 230L;

    /** 单次查询上限（银行负责人） */
    public static final long LIMIT_BANK_OWNER = 235L;

    /** 单次查询上限（资产编号） */
    public static final long LIMIT_ASSET_NO = 240L;

    /** 单次查询上限（资产名称） */
    public static final long LIMIT_ASSET_NAME = 245L;

    /** 单次查询上限（资产类型） */
    public static final long LIMIT_ASSET_TYPE = 250L;

    /** 单次查询上限（资产编码） */
    public static final long LIMIT_ASSET_CODE = 255L;

    /** 单次查询上限（资产级别） */
    public static final long LIMIT_ASSET_LEVEL = 260L;

    /** 单次查询上限（资产状态） */
    public static final long LIMIT_ASSET_STATUS = 265L;

    /** 单次查询上限（资产金额） */
    public static final long LIMIT_ASSET_AMOUNT = 270L;

    /** 单次查询上限（资产数量） */
    public static final long LIMIT_ASSET_COUNT = 275L;

    /** 单次查询上限（资产比率） */
    public static final long LIMIT_ASSET_RATE = 280L;

    /** 单次查询上限（资产日期） */
    public static final long LIMIT_ASSET_DATE = 285L;

    /** 单次查询上限（资产时间） */
    public static final long LIMIT_ASSET_TIME = 290L;

    /** 单次查询上限（资产标记） */
    public static final long LIMIT_ASSET_FLAG = 295L;

    /** 单次查询上限（资产说明） */
    public static final long LIMIT_ASSET_REMARK = 300L;

    private CustInfoCacheConfig() {
    }

    /** 单次查询上限（客户来源）。 */
    public static long resolveLimitCustSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_CUST_SOURCE;
        }
        if (requested > LIMIT_CUST_SOURCE) {
            return LIMIT_CUST_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（客户版本）。 */
    public static long resolveLimitCustVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_CUST_VERSION;
        }
        if (requested > LIMIT_CUST_VERSION) {
            return LIMIT_CUST_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（客户区域）。 */
    public static long resolveLimitCustRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_CUST_REGION;
        }
        if (requested > LIMIT_CUST_REGION) {
            return LIMIT_CUST_REGION;
        }
        return requested;
    }

    /** 单次查询上限（客户渠道）。 */
    public static long resolveLimitCustChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_CUST_CHANNEL;
        }
        if (requested > LIMIT_CUST_CHANNEL) {
            return LIMIT_CUST_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（客户分组）。 */
    public static long resolveLimitCustGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_CUST_GROUP;
        }
        if (requested > LIMIT_CUST_GROUP) {
            return LIMIT_CUST_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（客户标签）。 */
    public static long resolveLimitCustTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_CUST_TAG;
        }
        if (requested > LIMIT_CUST_TAG) {
            return LIMIT_CUST_TAG;
        }
        return requested;
    }

    /** 单次查询上限（客户负责人）。 */
    public static long resolveLimitCustOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_CUST_OWNER;
        }
        if (requested > LIMIT_CUST_OWNER) {
            return LIMIT_CUST_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（证件编号）。 */
    public static long resolveLimitCertNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_NO;
        }
        if (requested > LIMIT_CERT_NO) {
            return LIMIT_CERT_NO;
        }
        return requested;
    }

    /** 单次查询上限（证件名称）。 */
    public static long resolveLimitCertName(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_NAME;
        }
        if (requested > LIMIT_CERT_NAME) {
            return LIMIT_CERT_NAME;
        }
        return requested;
    }

    /** 单次查询上限（证件类型）。 */
    public static long resolveLimitCertType(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_TYPE;
        }
        if (requested > LIMIT_CERT_TYPE) {
            return LIMIT_CERT_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（证件编码）。 */
    public static long resolveLimitCertCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_CODE;
        }
        if (requested > LIMIT_CERT_CODE) {
            return LIMIT_CERT_CODE;
        }
        return requested;
    }

    /** 单次查询上限（证件级别）。 */
    public static long resolveLimitCertLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_LEVEL;
        }
        if (requested > LIMIT_CERT_LEVEL) {
            return LIMIT_CERT_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（证件状态）。 */
    public static long resolveLimitCertStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_CERT_STATUS;
        }
        if (requested > LIMIT_CERT_STATUS) {
            return LIMIT_CERT_STATUS;
        }
        return requested;
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

}

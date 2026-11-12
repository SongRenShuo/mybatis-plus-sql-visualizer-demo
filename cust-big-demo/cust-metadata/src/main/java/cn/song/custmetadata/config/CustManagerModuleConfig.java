package cn.song.custmetadata.config;

/**
 * 客户经理ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustManagerModuleConfig {

    public static final String MODULE_CODE = "CUST_MANAGER";

    /** 缓存秒数（客户标签） */
    public static final long CACHE_CUST_TAG = 5L;

    /** 缓存秒数（客户负责人） */
    public static final long CACHE_CUST_OWNER = 10L;

    /** 缓存秒数（证件编号） */
    public static final long CACHE_CERT_NO = 15L;

    /** 缓存秒数（证件名称） */
    public static final long CACHE_CERT_NAME = 20L;

    /** 缓存秒数（证件类型） */
    public static final long CACHE_CERT_TYPE = 25L;

    /** 缓存秒数（证件编码） */
    public static final long CACHE_CERT_CODE = 30L;

    /** 缓存秒数（证件级别） */
    public static final long CACHE_CERT_LEVEL = 35L;

    /** 缓存秒数（证件状态） */
    public static final long CACHE_CERT_STATUS = 40L;

    /** 缓存秒数（证件金额） */
    public static final long CACHE_CERT_AMOUNT = 45L;

    /** 缓存秒数（证件数量） */
    public static final long CACHE_CERT_COUNT = 50L;

    /** 缓存秒数（证件比率） */
    public static final long CACHE_CERT_RATE = 55L;

    /** 缓存秒数（证件日期） */
    public static final long CACHE_CERT_DATE = 60L;

    /** 缓存秒数（证件时间） */
    public static final long CACHE_CERT_TIME = 65L;

    /** 缓存秒数（证件标记） */
    public static final long CACHE_CERT_FLAG = 70L;

    /** 缓存秒数（证件说明） */
    public static final long CACHE_CERT_REMARK = 75L;

    /** 缓存秒数（证件来源） */
    public static final long CACHE_CERT_SOURCE = 80L;

    /** 缓存秒数（证件版本） */
    public static final long CACHE_CERT_VERSION = 85L;

    /** 缓存秒数（证件区域） */
    public static final long CACHE_CERT_REGION = 90L;

    /** 缓存秒数（证件渠道） */
    public static final long CACHE_CERT_CHANNEL = 95L;

    /** 缓存秒数（证件分组） */
    public static final long CACHE_CERT_GROUP = 100L;

    /** 缓存秒数（证件标签） */
    public static final long CACHE_CERT_TAG = 105L;

    /** 缓存秒数（证件负责人） */
    public static final long CACHE_CERT_OWNER = 110L;

    /** 缓存秒数（银行编号） */
    public static final long CACHE_BANK_NO = 115L;

    /** 缓存秒数（银行名称） */
    public static final long CACHE_BANK_NAME = 120L;

    /** 缓存秒数（银行类型） */
    public static final long CACHE_BANK_TYPE = 125L;

    /** 缓存秒数（银行编码） */
    public static final long CACHE_BANK_CODE = 130L;

    /** 缓存秒数（银行级别） */
    public static final long CACHE_BANK_LEVEL = 135L;

    /** 缓存秒数（银行状态） */
    public static final long CACHE_BANK_STATUS = 140L;

    /** 缓存秒数（银行金额） */
    public static final long CACHE_BANK_AMOUNT = 145L;

    /** 缓存秒数（银行数量） */
    public static final long CACHE_BANK_COUNT = 150L;

    /** 缓存秒数（银行比率） */
    public static final long CACHE_BANK_RATE = 155L;

    /** 缓存秒数（银行日期） */
    public static final long CACHE_BANK_DATE = 160L;

    /** 缓存秒数（银行时间） */
    public static final long CACHE_BANK_TIME = 165L;

    /** 缓存秒数（银行标记） */
    public static final long CACHE_BANK_FLAG = 170L;

    /** 缓存秒数（银行说明） */
    public static final long CACHE_BANK_REMARK = 175L;

    /** 缓存秒数（银行来源） */
    public static final long CACHE_BANK_SOURCE = 180L;

    /** 缓存秒数（银行版本） */
    public static final long CACHE_BANK_VERSION = 185L;

    /** 缓存秒数（银行区域） */
    public static final long CACHE_BANK_REGION = 190L;

    /** 缓存秒数（银行渠道） */
    public static final long CACHE_BANK_CHANNEL = 195L;

    /** 缓存秒数（银行分组） */
    public static final long CACHE_BANK_GROUP = 200L;

    /** 缓存秒数（银行标签） */
    public static final long CACHE_BANK_TAG = 205L;

    /** 缓存秒数（银行负责人） */
    public static final long CACHE_BANK_OWNER = 210L;

    /** 缓存秒数（资产编号） */
    public static final long CACHE_ASSET_NO = 215L;

    /** 缓存秒数（资产名称） */
    public static final long CACHE_ASSET_NAME = 220L;

    /** 缓存秒数（资产类型） */
    public static final long CACHE_ASSET_TYPE = 225L;

    /** 缓存秒数（资产编码） */
    public static final long CACHE_ASSET_CODE = 230L;

    /** 缓存秒数（资产级别） */
    public static final long CACHE_ASSET_LEVEL = 235L;

    /** 缓存秒数（资产状态） */
    public static final long CACHE_ASSET_STATUS = 240L;

    /** 缓存秒数（资产金额） */
    public static final long CACHE_ASSET_AMOUNT = 245L;

    /** 缓存秒数（资产数量） */
    public static final long CACHE_ASSET_COUNT = 250L;

    /** 缓存秒数（资产比率） */
    public static final long CACHE_ASSET_RATE = 255L;

    /** 缓存秒数（资产日期） */
    public static final long CACHE_ASSET_DATE = 260L;

    /** 缓存秒数（资产时间） */
    public static final long CACHE_ASSET_TIME = 265L;

    /** 缓存秒数（资产标记） */
    public static final long CACHE_ASSET_FLAG = 270L;

    /** 缓存秒数（资产说明） */
    public static final long CACHE_ASSET_REMARK = 275L;

    /** 缓存秒数（资产来源） */
    public static final long CACHE_ASSET_SOURCE = 280L;

    /** 缓存秒数（资产版本） */
    public static final long CACHE_ASSET_VERSION = 285L;

    /** 缓存秒数（资产区域） */
    public static final long CACHE_ASSET_REGION = 290L;

    /** 缓存秒数（资产渠道） */
    public static final long CACHE_ASSET_CHANNEL = 295L;

    /** 缓存秒数（资产分组） */
    public static final long CACHE_ASSET_GROUP = 300L;

    private CustManagerModuleConfig() {
    }

    /** 缓存秒数（客户标签）。 */
    public static long resolveCacheCustTag(long requested) {
        if (requested <= 0L) {
            return CACHE_CUST_TAG;
        }
        if (requested > CACHE_CUST_TAG) {
            return CACHE_CUST_TAG;
        }
        return requested;
    }

    /** 缓存秒数（客户负责人）。 */
    public static long resolveCacheCustOwner(long requested) {
        if (requested <= 0L) {
            return CACHE_CUST_OWNER;
        }
        if (requested > CACHE_CUST_OWNER) {
            return CACHE_CUST_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（证件编号）。 */
    public static long resolveCacheCertNo(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_NO;
        }
        if (requested > CACHE_CERT_NO) {
            return CACHE_CERT_NO;
        }
        return requested;
    }

    /** 缓存秒数（证件名称）。 */
    public static long resolveCacheCertName(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_NAME;
        }
        if (requested > CACHE_CERT_NAME) {
            return CACHE_CERT_NAME;
        }
        return requested;
    }

    /** 缓存秒数（证件类型）。 */
    public static long resolveCacheCertType(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_TYPE;
        }
        if (requested > CACHE_CERT_TYPE) {
            return CACHE_CERT_TYPE;
        }
        return requested;
    }

    /** 缓存秒数（证件编码）。 */
    public static long resolveCacheCertCode(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_CODE;
        }
        if (requested > CACHE_CERT_CODE) {
            return CACHE_CERT_CODE;
        }
        return requested;
    }

    /** 缓存秒数（证件级别）。 */
    public static long resolveCacheCertLevel(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_LEVEL;
        }
        if (requested > CACHE_CERT_LEVEL) {
            return CACHE_CERT_LEVEL;
        }
        return requested;
    }

    /** 缓存秒数（证件状态）。 */
    public static long resolveCacheCertStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_STATUS;
        }
        if (requested > CACHE_CERT_STATUS) {
            return CACHE_CERT_STATUS;
        }
        return requested;
    }

    /** 缓存秒数（证件金额）。 */
    public static long resolveCacheCertAmount(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_AMOUNT;
        }
        if (requested > CACHE_CERT_AMOUNT) {
            return CACHE_CERT_AMOUNT;
        }
        return requested;
    }

    /** 缓存秒数（证件数量）。 */
    public static long resolveCacheCertCount(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_COUNT;
        }
        if (requested > CACHE_CERT_COUNT) {
            return CACHE_CERT_COUNT;
        }
        return requested;
    }

    /** 缓存秒数（证件比率）。 */
    public static long resolveCacheCertRate(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_RATE;
        }
        if (requested > CACHE_CERT_RATE) {
            return CACHE_CERT_RATE;
        }
        return requested;
    }

    /** 缓存秒数（证件日期）。 */
    public static long resolveCacheCertDate(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_DATE;
        }
        if (requested > CACHE_CERT_DATE) {
            return CACHE_CERT_DATE;
        }
        return requested;
    }

    /** 缓存秒数（证件时间）。 */
    public static long resolveCacheCertTime(long requested) {
        if (requested <= 0L) {
            return CACHE_CERT_TIME;
        }
        if (requested > CACHE_CERT_TIME) {
            return CACHE_CERT_TIME;
        }
        return requested;
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

}

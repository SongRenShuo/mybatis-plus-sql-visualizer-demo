package cn.song.custmetadata.config;

/**
 * 客户跟进CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustFollowUpCacheConfig {

    public static final String MODULE_CODE = "CUST_FOLLOW_UP_CACHE_CONFIG";

    /** 缓存秒数（合同状态） */
    public static final long CACHE_CONTRACT_STATUS = 5L;

    /** 缓存秒数（合同金额） */
    public static final long CACHE_CONTRACT_AMOUNT = 10L;

    /** 缓存秒数（合同数量） */
    public static final long CACHE_CONTRACT_COUNT = 15L;

    /** 缓存秒数（合同比率） */
    public static final long CACHE_CONTRACT_RATE = 20L;

    /** 缓存秒数（合同日期） */
    public static final long CACHE_CONTRACT_DATE = 25L;

    /** 缓存秒数（合同时间） */
    public static final long CACHE_CONTRACT_TIME = 30L;

    /** 缓存秒数（合同标记） */
    public static final long CACHE_CONTRACT_FLAG = 35L;

    /** 缓存秒数（合同说明） */
    public static final long CACHE_CONTRACT_REMARK = 40L;

    /** 缓存秒数（合同来源） */
    public static final long CACHE_CONTRACT_SOURCE = 45L;

    /** 缓存秒数（合同版本） */
    public static final long CACHE_CONTRACT_VERSION = 50L;

    /** 缓存秒数（合同区域） */
    public static final long CACHE_CONTRACT_REGION = 55L;

    /** 缓存秒数（合同渠道） */
    public static final long CACHE_CONTRACT_CHANNEL = 60L;

    /** 缓存秒数（合同分组） */
    public static final long CACHE_CONTRACT_GROUP = 65L;

    /** 缓存秒数（合同标签） */
    public static final long CACHE_CONTRACT_TAG = 70L;

    /** 缓存秒数（合同负责人） */
    public static final long CACHE_CONTRACT_OWNER = 75L;

    /** 缓存秒数（订单编号） */
    public static final long CACHE_ORDER_NO = 80L;

    /** 缓存秒数（订单名称） */
    public static final long CACHE_ORDER_NAME = 85L;

    /** 缓存秒数（订单类型） */
    public static final long CACHE_ORDER_TYPE = 90L;

    /** 缓存秒数（订单编码） */
    public static final long CACHE_ORDER_CODE = 95L;

    /** 缓存秒数（订单级别） */
    public static final long CACHE_ORDER_LEVEL = 100L;

    /** 缓存秒数（订单状态） */
    public static final long CACHE_ORDER_STATUS = 105L;

    /** 缓存秒数（订单金额） */
    public static final long CACHE_ORDER_AMOUNT = 110L;

    /** 缓存秒数（订单数量） */
    public static final long CACHE_ORDER_COUNT = 115L;

    /** 缓存秒数（订单比率） */
    public static final long CACHE_ORDER_RATE = 120L;

    /** 缓存秒数（订单日期） */
    public static final long CACHE_ORDER_DATE = 125L;

    /** 缓存秒数（订单时间） */
    public static final long CACHE_ORDER_TIME = 130L;

    /** 缓存秒数（订单标记） */
    public static final long CACHE_ORDER_FLAG = 135L;

    /** 缓存秒数（订单说明） */
    public static final long CACHE_ORDER_REMARK = 140L;

    /** 缓存秒数（订单来源） */
    public static final long CACHE_ORDER_SOURCE = 145L;

    /** 缓存秒数（订单版本） */
    public static final long CACHE_ORDER_VERSION = 150L;

    /** 缓存秒数（订单区域） */
    public static final long CACHE_ORDER_REGION = 155L;

    /** 缓存秒数（订单渠道） */
    public static final long CACHE_ORDER_CHANNEL = 160L;

    /** 缓存秒数（订单分组） */
    public static final long CACHE_ORDER_GROUP = 165L;

    /** 缓存秒数（订单标签） */
    public static final long CACHE_ORDER_TAG = 170L;

    /** 缓存秒数（订单负责人） */
    public static final long CACHE_ORDER_OWNER = 175L;

    /** 缓存秒数（付款编号） */
    public static final long CACHE_PAYMENT_NO = 180L;

    /** 缓存秒数（付款名称） */
    public static final long CACHE_PAYMENT_NAME = 185L;

    /** 缓存秒数（付款类型） */
    public static final long CACHE_PAYMENT_TYPE = 190L;

    /** 缓存秒数（付款编码） */
    public static final long CACHE_PAYMENT_CODE = 195L;

    /** 缓存秒数（付款级别） */
    public static final long CACHE_PAYMENT_LEVEL = 200L;

    /** 缓存秒数（付款状态） */
    public static final long CACHE_PAYMENT_STATUS = 205L;

    /** 缓存秒数（付款金额） */
    public static final long CACHE_PAYMENT_AMOUNT = 210L;

    /** 缓存秒数（付款数量） */
    public static final long CACHE_PAYMENT_COUNT = 215L;

    /** 缓存秒数（付款比率） */
    public static final long CACHE_PAYMENT_RATE = 220L;

    /** 缓存秒数（付款日期） */
    public static final long CACHE_PAYMENT_DATE = 225L;

    /** 缓存秒数（付款时间） */
    public static final long CACHE_PAYMENT_TIME = 230L;

    /** 缓存秒数（付款标记） */
    public static final long CACHE_PAYMENT_FLAG = 235L;

    /** 缓存秒数（付款说明） */
    public static final long CACHE_PAYMENT_REMARK = 240L;

    /** 缓存秒数（付款来源） */
    public static final long CACHE_PAYMENT_SOURCE = 245L;

    /** 缓存秒数（付款版本） */
    public static final long CACHE_PAYMENT_VERSION = 250L;

    /** 缓存秒数（付款区域） */
    public static final long CACHE_PAYMENT_REGION = 255L;

    /** 缓存秒数（付款渠道） */
    public static final long CACHE_PAYMENT_CHANNEL = 260L;

    /** 缓存秒数（付款分组） */
    public static final long CACHE_PAYMENT_GROUP = 265L;

    /** 缓存秒数（付款标签） */
    public static final long CACHE_PAYMENT_TAG = 270L;

    /** 缓存秒数（付款负责人） */
    public static final long CACHE_PAYMENT_OWNER = 275L;

    /** 缓存秒数（发票编号） */
    public static final long CACHE_INVOICE_NO = 280L;

    /** 缓存秒数（发票名称） */
    public static final long CACHE_INVOICE_NAME = 285L;

    /** 缓存秒数（发票类型） */
    public static final long CACHE_INVOICE_TYPE = 290L;

    /** 缓存秒数（发票编码） */
    public static final long CACHE_INVOICE_CODE = 295L;

    /** 缓存秒数（发票级别） */
    public static final long CACHE_INVOICE_LEVEL = 300L;

    private CustFollowUpCacheConfig() {
    }

    /** 缓存秒数（合同状态）。 */
    public static long resolveCacheContractStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_STATUS;
        }
        if (requested > CACHE_CONTRACT_STATUS) {
            return CACHE_CONTRACT_STATUS;
        }
        return requested;
    }

    /** 缓存秒数（合同金额）。 */
    public static long resolveCacheContractAmount(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_AMOUNT;
        }
        if (requested > CACHE_CONTRACT_AMOUNT) {
            return CACHE_CONTRACT_AMOUNT;
        }
        return requested;
    }

    /** 缓存秒数（合同数量）。 */
    public static long resolveCacheContractCount(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_COUNT;
        }
        if (requested > CACHE_CONTRACT_COUNT) {
            return CACHE_CONTRACT_COUNT;
        }
        return requested;
    }

    /** 缓存秒数（合同比率）。 */
    public static long resolveCacheContractRate(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_RATE;
        }
        if (requested > CACHE_CONTRACT_RATE) {
            return CACHE_CONTRACT_RATE;
        }
        return requested;
    }

    /** 缓存秒数（合同日期）。 */
    public static long resolveCacheContractDate(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_DATE;
        }
        if (requested > CACHE_CONTRACT_DATE) {
            return CACHE_CONTRACT_DATE;
        }
        return requested;
    }

    /** 缓存秒数（合同时间）。 */
    public static long resolveCacheContractTime(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_TIME;
        }
        if (requested > CACHE_CONTRACT_TIME) {
            return CACHE_CONTRACT_TIME;
        }
        return requested;
    }

    /** 缓存秒数（合同标记）。 */
    public static long resolveCacheContractFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_FLAG;
        }
        if (requested > CACHE_CONTRACT_FLAG) {
            return CACHE_CONTRACT_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（合同说明）。 */
    public static long resolveCacheContractRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_REMARK;
        }
        if (requested > CACHE_CONTRACT_REMARK) {
            return CACHE_CONTRACT_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（合同来源）。 */
    public static long resolveCacheContractSource(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_SOURCE;
        }
        if (requested > CACHE_CONTRACT_SOURCE) {
            return CACHE_CONTRACT_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（合同版本）。 */
    public static long resolveCacheContractVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_VERSION;
        }
        if (requested > CACHE_CONTRACT_VERSION) {
            return CACHE_CONTRACT_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（合同区域）。 */
    public static long resolveCacheContractRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_REGION;
        }
        if (requested > CACHE_CONTRACT_REGION) {
            return CACHE_CONTRACT_REGION;
        }
        return requested;
    }

    /** 缓存秒数（合同渠道）。 */
    public static long resolveCacheContractChannel(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_CHANNEL;
        }
        if (requested > CACHE_CONTRACT_CHANNEL) {
            return CACHE_CONTRACT_CHANNEL;
        }
        return requested;
    }

    /** 缓存秒数（合同分组）。 */
    public static long resolveCacheContractGroup(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_GROUP;
        }
        if (requested > CACHE_CONTRACT_GROUP) {
            return CACHE_CONTRACT_GROUP;
        }
        return requested;
    }

    /** 缓存秒数（合同标签）。 */
    public static long resolveCacheContractTag(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_TAG;
        }
        if (requested > CACHE_CONTRACT_TAG) {
            return CACHE_CONTRACT_TAG;
        }
        return requested;
    }

    /** 缓存秒数（合同负责人）。 */
    public static long resolveCacheContractOwner(long requested) {
        if (requested <= 0L) {
            return CACHE_CONTRACT_OWNER;
        }
        if (requested > CACHE_CONTRACT_OWNER) {
            return CACHE_CONTRACT_OWNER;
        }
        return requested;
    }

    /** 缓存秒数（订单编号）。 */
    public static long resolveCacheOrderNo(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_NO;
        }
        if (requested > CACHE_ORDER_NO) {
            return CACHE_ORDER_NO;
        }
        return requested;
    }

    /** 缓存秒数（订单名称）。 */
    public static long resolveCacheOrderName(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_NAME;
        }
        if (requested > CACHE_ORDER_NAME) {
            return CACHE_ORDER_NAME;
        }
        return requested;
    }

    /** 缓存秒数（订单类型）。 */
    public static long resolveCacheOrderType(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_TYPE;
        }
        if (requested > CACHE_ORDER_TYPE) {
            return CACHE_ORDER_TYPE;
        }
        return requested;
    }

    /** 缓存秒数（订单编码）。 */
    public static long resolveCacheOrderCode(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_CODE;
        }
        if (requested > CACHE_ORDER_CODE) {
            return CACHE_ORDER_CODE;
        }
        return requested;
    }

    /** 缓存秒数（订单级别）。 */
    public static long resolveCacheOrderLevel(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_LEVEL;
        }
        if (requested > CACHE_ORDER_LEVEL) {
            return CACHE_ORDER_LEVEL;
        }
        return requested;
    }

}

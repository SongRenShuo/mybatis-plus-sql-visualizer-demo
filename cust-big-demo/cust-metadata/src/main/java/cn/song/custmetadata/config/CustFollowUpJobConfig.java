package cn.song.custmetadata.config;

/**
 * 客户跟进JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustFollowUpJobConfig {

    public static final String MODULE_CODE = "CUST_FOLLOW_UP_JOB_CONFIG";

    /** 缓存秒数（合同标签） */
    public static final long CACHE_CONTRACT_TAG = 5L;

    /** 缓存秒数（合同负责人） */
    public static final long CACHE_CONTRACT_OWNER = 10L;

    /** 缓存秒数（订单编号） */
    public static final long CACHE_ORDER_NO = 15L;

    /** 缓存秒数（订单名称） */
    public static final long CACHE_ORDER_NAME = 20L;

    /** 缓存秒数（订单类型） */
    public static final long CACHE_ORDER_TYPE = 25L;

    /** 缓存秒数（订单编码） */
    public static final long CACHE_ORDER_CODE = 30L;

    /** 缓存秒数（订单级别） */
    public static final long CACHE_ORDER_LEVEL = 35L;

    /** 缓存秒数（订单状态） */
    public static final long CACHE_ORDER_STATUS = 40L;

    /** 缓存秒数（订单金额） */
    public static final long CACHE_ORDER_AMOUNT = 45L;

    /** 缓存秒数（订单数量） */
    public static final long CACHE_ORDER_COUNT = 50L;

    /** 缓存秒数（订单比率） */
    public static final long CACHE_ORDER_RATE = 55L;

    /** 缓存秒数（订单日期） */
    public static final long CACHE_ORDER_DATE = 60L;

    /** 缓存秒数（订单时间） */
    public static final long CACHE_ORDER_TIME = 65L;

    /** 缓存秒数（订单标记） */
    public static final long CACHE_ORDER_FLAG = 70L;

    /** 缓存秒数（订单说明） */
    public static final long CACHE_ORDER_REMARK = 75L;

    /** 缓存秒数（订单来源） */
    public static final long CACHE_ORDER_SOURCE = 80L;

    /** 缓存秒数（订单版本） */
    public static final long CACHE_ORDER_VERSION = 85L;

    /** 缓存秒数（订单区域） */
    public static final long CACHE_ORDER_REGION = 90L;

    /** 缓存秒数（订单渠道） */
    public static final long CACHE_ORDER_CHANNEL = 95L;

    /** 缓存秒数（订单分组） */
    public static final long CACHE_ORDER_GROUP = 100L;

    /** 缓存秒数（订单标签） */
    public static final long CACHE_ORDER_TAG = 105L;

    /** 缓存秒数（订单负责人） */
    public static final long CACHE_ORDER_OWNER = 110L;

    /** 缓存秒数（付款编号） */
    public static final long CACHE_PAYMENT_NO = 115L;

    /** 缓存秒数（付款名称） */
    public static final long CACHE_PAYMENT_NAME = 120L;

    /** 缓存秒数（付款类型） */
    public static final long CACHE_PAYMENT_TYPE = 125L;

    /** 缓存秒数（付款编码） */
    public static final long CACHE_PAYMENT_CODE = 130L;

    /** 缓存秒数（付款级别） */
    public static final long CACHE_PAYMENT_LEVEL = 135L;

    /** 缓存秒数（付款状态） */
    public static final long CACHE_PAYMENT_STATUS = 140L;

    /** 缓存秒数（付款金额） */
    public static final long CACHE_PAYMENT_AMOUNT = 145L;

    /** 缓存秒数（付款数量） */
    public static final long CACHE_PAYMENT_COUNT = 150L;

    /** 缓存秒数（付款比率） */
    public static final long CACHE_PAYMENT_RATE = 155L;

    /** 缓存秒数（付款日期） */
    public static final long CACHE_PAYMENT_DATE = 160L;

    /** 缓存秒数（付款时间） */
    public static final long CACHE_PAYMENT_TIME = 165L;

    /** 缓存秒数（付款标记） */
    public static final long CACHE_PAYMENT_FLAG = 170L;

    /** 缓存秒数（付款说明） */
    public static final long CACHE_PAYMENT_REMARK = 175L;

    /** 缓存秒数（付款来源） */
    public static final long CACHE_PAYMENT_SOURCE = 180L;

    /** 缓存秒数（付款版本） */
    public static final long CACHE_PAYMENT_VERSION = 185L;

    /** 缓存秒数（付款区域） */
    public static final long CACHE_PAYMENT_REGION = 190L;

    /** 缓存秒数（付款渠道） */
    public static final long CACHE_PAYMENT_CHANNEL = 195L;

    /** 缓存秒数（付款分组） */
    public static final long CACHE_PAYMENT_GROUP = 200L;

    /** 缓存秒数（付款标签） */
    public static final long CACHE_PAYMENT_TAG = 205L;

    /** 缓存秒数（付款负责人） */
    public static final long CACHE_PAYMENT_OWNER = 210L;

    /** 缓存秒数（发票编号） */
    public static final long CACHE_INVOICE_NO = 215L;

    /** 缓存秒数（发票名称） */
    public static final long CACHE_INVOICE_NAME = 220L;

    /** 缓存秒数（发票类型） */
    public static final long CACHE_INVOICE_TYPE = 225L;

    /** 缓存秒数（发票编码） */
    public static final long CACHE_INVOICE_CODE = 230L;

    /** 缓存秒数（发票级别） */
    public static final long CACHE_INVOICE_LEVEL = 235L;

    /** 缓存秒数（发票状态） */
    public static final long CACHE_INVOICE_STATUS = 240L;

    /** 缓存秒数（发票金额） */
    public static final long CACHE_INVOICE_AMOUNT = 245L;

    /** 缓存秒数（发票数量） */
    public static final long CACHE_INVOICE_COUNT = 250L;

    /** 缓存秒数（发票比率） */
    public static final long CACHE_INVOICE_RATE = 255L;

    /** 缓存秒数（发票日期） */
    public static final long CACHE_INVOICE_DATE = 260L;

    /** 缓存秒数（发票时间） */
    public static final long CACHE_INVOICE_TIME = 265L;

    /** 缓存秒数（发票标记） */
    public static final long CACHE_INVOICE_FLAG = 270L;

    /** 缓存秒数（发票说明） */
    public static final long CACHE_INVOICE_REMARK = 275L;

    /** 缓存秒数（发票来源） */
    public static final long CACHE_INVOICE_SOURCE = 280L;

    /** 缓存秒数（发票版本） */
    public static final long CACHE_INVOICE_VERSION = 285L;

    /** 缓存秒数（发票区域） */
    public static final long CACHE_INVOICE_REGION = 290L;

    /** 缓存秒数（发票渠道） */
    public static final long CACHE_INVOICE_CHANNEL = 295L;

    /** 缓存秒数（发票分组） */
    public static final long CACHE_INVOICE_GROUP = 300L;

    private CustFollowUpJobConfig() {
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

    /** 缓存秒数（订单状态）。 */
    public static long resolveCacheOrderStatus(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_STATUS;
        }
        if (requested > CACHE_ORDER_STATUS) {
            return CACHE_ORDER_STATUS;
        }
        return requested;
    }

    /** 缓存秒数（订单金额）。 */
    public static long resolveCacheOrderAmount(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_AMOUNT;
        }
        if (requested > CACHE_ORDER_AMOUNT) {
            return CACHE_ORDER_AMOUNT;
        }
        return requested;
    }

    /** 缓存秒数（订单数量）。 */
    public static long resolveCacheOrderCount(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_COUNT;
        }
        if (requested > CACHE_ORDER_COUNT) {
            return CACHE_ORDER_COUNT;
        }
        return requested;
    }

    /** 缓存秒数（订单比率）。 */
    public static long resolveCacheOrderRate(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_RATE;
        }
        if (requested > CACHE_ORDER_RATE) {
            return CACHE_ORDER_RATE;
        }
        return requested;
    }

    /** 缓存秒数（订单日期）。 */
    public static long resolveCacheOrderDate(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_DATE;
        }
        if (requested > CACHE_ORDER_DATE) {
            return CACHE_ORDER_DATE;
        }
        return requested;
    }

    /** 缓存秒数（订单时间）。 */
    public static long resolveCacheOrderTime(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_TIME;
        }
        if (requested > CACHE_ORDER_TIME) {
            return CACHE_ORDER_TIME;
        }
        return requested;
    }

    /** 缓存秒数（订单标记）。 */
    public static long resolveCacheOrderFlag(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_FLAG;
        }
        if (requested > CACHE_ORDER_FLAG) {
            return CACHE_ORDER_FLAG;
        }
        return requested;
    }

    /** 缓存秒数（订单说明）。 */
    public static long resolveCacheOrderRemark(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_REMARK;
        }
        if (requested > CACHE_ORDER_REMARK) {
            return CACHE_ORDER_REMARK;
        }
        return requested;
    }

    /** 缓存秒数（订单来源）。 */
    public static long resolveCacheOrderSource(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_SOURCE;
        }
        if (requested > CACHE_ORDER_SOURCE) {
            return CACHE_ORDER_SOURCE;
        }
        return requested;
    }

    /** 缓存秒数（订单版本）。 */
    public static long resolveCacheOrderVersion(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_VERSION;
        }
        if (requested > CACHE_ORDER_VERSION) {
            return CACHE_ORDER_VERSION;
        }
        return requested;
    }

    /** 缓存秒数（订单区域）。 */
    public static long resolveCacheOrderRegion(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_REGION;
        }
        if (requested > CACHE_ORDER_REGION) {
            return CACHE_ORDER_REGION;
        }
        return requested;
    }

    /** 缓存秒数（订单渠道）。 */
    public static long resolveCacheOrderChannel(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_CHANNEL;
        }
        if (requested > CACHE_ORDER_CHANNEL) {
            return CACHE_ORDER_CHANNEL;
        }
        return requested;
    }

    /** 缓存秒数（订单分组）。 */
    public static long resolveCacheOrderGroup(long requested) {
        if (requested <= 0L) {
            return CACHE_ORDER_GROUP;
        }
        if (requested > CACHE_ORDER_GROUP) {
            return CACHE_ORDER_GROUP;
        }
        return requested;
    }

}

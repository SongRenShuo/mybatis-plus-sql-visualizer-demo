package cn.song.custmetadata.config;

/**
 * 客户退款CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustRefundCacheConfig {

    public static final String MODULE_CODE = "CUST_REFUND_CACHE_CONFIG";

    /** 批处理条数（合同标记） */
    public static final long BATCH_CONTRACT_FLAG = 5L;

    /** 批处理条数（合同说明） */
    public static final long BATCH_CONTRACT_REMARK = 10L;

    /** 批处理条数（合同来源） */
    public static final long BATCH_CONTRACT_SOURCE = 15L;

    /** 批处理条数（合同版本） */
    public static final long BATCH_CONTRACT_VERSION = 20L;

    /** 批处理条数（合同区域） */
    public static final long BATCH_CONTRACT_REGION = 25L;

    /** 批处理条数（合同渠道） */
    public static final long BATCH_CONTRACT_CHANNEL = 30L;

    /** 批处理条数（合同分组） */
    public static final long BATCH_CONTRACT_GROUP = 35L;

    /** 批处理条数（合同标签） */
    public static final long BATCH_CONTRACT_TAG = 40L;

    /** 批处理条数（合同负责人） */
    public static final long BATCH_CONTRACT_OWNER = 45L;

    /** 批处理条数（订单编号） */
    public static final long BATCH_ORDER_NO = 50L;

    /** 批处理条数（订单名称） */
    public static final long BATCH_ORDER_NAME = 55L;

    /** 批处理条数（订单类型） */
    public static final long BATCH_ORDER_TYPE = 60L;

    /** 批处理条数（订单编码） */
    public static final long BATCH_ORDER_CODE = 65L;

    /** 批处理条数（订单级别） */
    public static final long BATCH_ORDER_LEVEL = 70L;

    /** 批处理条数（订单状态） */
    public static final long BATCH_ORDER_STATUS = 75L;

    /** 批处理条数（订单金额） */
    public static final long BATCH_ORDER_AMOUNT = 80L;

    /** 批处理条数（订单数量） */
    public static final long BATCH_ORDER_COUNT = 85L;

    /** 批处理条数（订单比率） */
    public static final long BATCH_ORDER_RATE = 90L;

    /** 批处理条数（订单日期） */
    public static final long BATCH_ORDER_DATE = 95L;

    /** 批处理条数（订单时间） */
    public static final long BATCH_ORDER_TIME = 100L;

    /** 批处理条数（订单标记） */
    public static final long BATCH_ORDER_FLAG = 105L;

    /** 批处理条数（订单说明） */
    public static final long BATCH_ORDER_REMARK = 110L;

    /** 批处理条数（订单来源） */
    public static final long BATCH_ORDER_SOURCE = 115L;

    /** 批处理条数（订单版本） */
    public static final long BATCH_ORDER_VERSION = 120L;

    /** 批处理条数（订单区域） */
    public static final long BATCH_ORDER_REGION = 125L;

    /** 批处理条数（订单渠道） */
    public static final long BATCH_ORDER_CHANNEL = 130L;

    /** 批处理条数（订单分组） */
    public static final long BATCH_ORDER_GROUP = 135L;

    /** 批处理条数（订单标签） */
    public static final long BATCH_ORDER_TAG = 140L;

    /** 批处理条数（订单负责人） */
    public static final long BATCH_ORDER_OWNER = 145L;

    /** 批处理条数（付款编号） */
    public static final long BATCH_PAYMENT_NO = 150L;

    /** 批处理条数（付款名称） */
    public static final long BATCH_PAYMENT_NAME = 155L;

    /** 批处理条数（付款类型） */
    public static final long BATCH_PAYMENT_TYPE = 160L;

    /** 批处理条数（付款编码） */
    public static final long BATCH_PAYMENT_CODE = 165L;

    /** 批处理条数（付款级别） */
    public static final long BATCH_PAYMENT_LEVEL = 170L;

    /** 批处理条数（付款状态） */
    public static final long BATCH_PAYMENT_STATUS = 175L;

    /** 批处理条数（付款金额） */
    public static final long BATCH_PAYMENT_AMOUNT = 180L;

    /** 批处理条数（付款数量） */
    public static final long BATCH_PAYMENT_COUNT = 185L;

    /** 批处理条数（付款比率） */
    public static final long BATCH_PAYMENT_RATE = 190L;

    /** 批处理条数（付款日期） */
    public static final long BATCH_PAYMENT_DATE = 195L;

    /** 批处理条数（付款时间） */
    public static final long BATCH_PAYMENT_TIME = 200L;

    /** 批处理条数（付款标记） */
    public static final long BATCH_PAYMENT_FLAG = 205L;

    /** 批处理条数（付款说明） */
    public static final long BATCH_PAYMENT_REMARK = 210L;

    /** 批处理条数（付款来源） */
    public static final long BATCH_PAYMENT_SOURCE = 215L;

    /** 批处理条数（付款版本） */
    public static final long BATCH_PAYMENT_VERSION = 220L;

    /** 批处理条数（付款区域） */
    public static final long BATCH_PAYMENT_REGION = 225L;

    /** 批处理条数（付款渠道） */
    public static final long BATCH_PAYMENT_CHANNEL = 230L;

    /** 批处理条数（付款分组） */
    public static final long BATCH_PAYMENT_GROUP = 235L;

    /** 批处理条数（付款标签） */
    public static final long BATCH_PAYMENT_TAG = 240L;

    /** 批处理条数（付款负责人） */
    public static final long BATCH_PAYMENT_OWNER = 245L;

    /** 批处理条数（发票编号） */
    public static final long BATCH_INVOICE_NO = 250L;

    /** 批处理条数（发票名称） */
    public static final long BATCH_INVOICE_NAME = 255L;

    /** 批处理条数（发票类型） */
    public static final long BATCH_INVOICE_TYPE = 260L;

    /** 批处理条数（发票编码） */
    public static final long BATCH_INVOICE_CODE = 265L;

    /** 批处理条数（发票级别） */
    public static final long BATCH_INVOICE_LEVEL = 270L;

    /** 批处理条数（发票状态） */
    public static final long BATCH_INVOICE_STATUS = 275L;

    /** 批处理条数（发票金额） */
    public static final long BATCH_INVOICE_AMOUNT = 280L;

    /** 批处理条数（发票数量） */
    public static final long BATCH_INVOICE_COUNT = 285L;

    /** 批处理条数（发票比率） */
    public static final long BATCH_INVOICE_RATE = 290L;

    /** 批处理条数（发票日期） */
    public static final long BATCH_INVOICE_DATE = 295L;

    /** 批处理条数（发票时间） */
    public static final long BATCH_INVOICE_TIME = 300L;

    private CustRefundCacheConfig() {
    }

    /** 批处理条数（合同标记）。 */
    public static long resolveBatchContractFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_CONTRACT_FLAG;
        }
        if (requested > BATCH_CONTRACT_FLAG) {
            return BATCH_CONTRACT_FLAG;
        }
        return requested;
    }

    /** 批处理条数（合同说明）。 */
    public static long resolveBatchContractRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_CONTRACT_REMARK;
        }
        if (requested > BATCH_CONTRACT_REMARK) {
            return BATCH_CONTRACT_REMARK;
        }
        return requested;
    }

    /** 批处理条数（合同来源）。 */
    public static long resolveBatchContractSource(long requested) {
        if (requested <= 0L) {
            return BATCH_CONTRACT_SOURCE;
        }
        if (requested > BATCH_CONTRACT_SOURCE) {
            return BATCH_CONTRACT_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（合同版本）。 */
    public static long resolveBatchContractVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_CONTRACT_VERSION;
        }
        if (requested > BATCH_CONTRACT_VERSION) {
            return BATCH_CONTRACT_VERSION;
        }
        return requested;
    }

    /** 批处理条数（合同区域）。 */
    public static long resolveBatchContractRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_CONTRACT_REGION;
        }
        if (requested > BATCH_CONTRACT_REGION) {
            return BATCH_CONTRACT_REGION;
        }
        return requested;
    }

    /** 批处理条数（合同渠道）。 */
    public static long resolveBatchContractChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_CONTRACT_CHANNEL;
        }
        if (requested > BATCH_CONTRACT_CHANNEL) {
            return BATCH_CONTRACT_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（合同分组）。 */
    public static long resolveBatchContractGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_CONTRACT_GROUP;
        }
        if (requested > BATCH_CONTRACT_GROUP) {
            return BATCH_CONTRACT_GROUP;
        }
        return requested;
    }

    /** 批处理条数（合同标签）。 */
    public static long resolveBatchContractTag(long requested) {
        if (requested <= 0L) {
            return BATCH_CONTRACT_TAG;
        }
        if (requested > BATCH_CONTRACT_TAG) {
            return BATCH_CONTRACT_TAG;
        }
        return requested;
    }

    /** 批处理条数（合同负责人）。 */
    public static long resolveBatchContractOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_CONTRACT_OWNER;
        }
        if (requested > BATCH_CONTRACT_OWNER) {
            return BATCH_CONTRACT_OWNER;
        }
        return requested;
    }

    /** 批处理条数（订单编号）。 */
    public static long resolveBatchOrderNo(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_NO;
        }
        if (requested > BATCH_ORDER_NO) {
            return BATCH_ORDER_NO;
        }
        return requested;
    }

    /** 批处理条数（订单名称）。 */
    public static long resolveBatchOrderName(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_NAME;
        }
        if (requested > BATCH_ORDER_NAME) {
            return BATCH_ORDER_NAME;
        }
        return requested;
    }

    /** 批处理条数（订单类型）。 */
    public static long resolveBatchOrderType(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_TYPE;
        }
        if (requested > BATCH_ORDER_TYPE) {
            return BATCH_ORDER_TYPE;
        }
        return requested;
    }

    /** 批处理条数（订单编码）。 */
    public static long resolveBatchOrderCode(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_CODE;
        }
        if (requested > BATCH_ORDER_CODE) {
            return BATCH_ORDER_CODE;
        }
        return requested;
    }

    /** 批处理条数（订单级别）。 */
    public static long resolveBatchOrderLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_LEVEL;
        }
        if (requested > BATCH_ORDER_LEVEL) {
            return BATCH_ORDER_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（订单状态）。 */
    public static long resolveBatchOrderStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_STATUS;
        }
        if (requested > BATCH_ORDER_STATUS) {
            return BATCH_ORDER_STATUS;
        }
        return requested;
    }

    /** 批处理条数（订单金额）。 */
    public static long resolveBatchOrderAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_AMOUNT;
        }
        if (requested > BATCH_ORDER_AMOUNT) {
            return BATCH_ORDER_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（订单数量）。 */
    public static long resolveBatchOrderCount(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_COUNT;
        }
        if (requested > BATCH_ORDER_COUNT) {
            return BATCH_ORDER_COUNT;
        }
        return requested;
    }

    /** 批处理条数（订单比率）。 */
    public static long resolveBatchOrderRate(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_RATE;
        }
        if (requested > BATCH_ORDER_RATE) {
            return BATCH_ORDER_RATE;
        }
        return requested;
    }

    /** 批处理条数（订单日期）。 */
    public static long resolveBatchOrderDate(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_DATE;
        }
        if (requested > BATCH_ORDER_DATE) {
            return BATCH_ORDER_DATE;
        }
        return requested;
    }

    /** 批处理条数（订单时间）。 */
    public static long resolveBatchOrderTime(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_TIME;
        }
        if (requested > BATCH_ORDER_TIME) {
            return BATCH_ORDER_TIME;
        }
        return requested;
    }

}

package cn.song.custmetadata.config;

/**
 * 客户退款JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustRefundJobConfig {

    public static final String MODULE_CODE = "CUST_REFUND_JOB_CONFIG";

    /** 批处理条数（订单级别） */
    public static final long BATCH_ORDER_LEVEL = 5L;

    /** 批处理条数（订单状态） */
    public static final long BATCH_ORDER_STATUS = 10L;

    /** 批处理条数（订单金额） */
    public static final long BATCH_ORDER_AMOUNT = 15L;

    /** 批处理条数（订单数量） */
    public static final long BATCH_ORDER_COUNT = 20L;

    /** 批处理条数（订单比率） */
    public static final long BATCH_ORDER_RATE = 25L;

    /** 批处理条数（订单日期） */
    public static final long BATCH_ORDER_DATE = 30L;

    /** 批处理条数（订单时间） */
    public static final long BATCH_ORDER_TIME = 35L;

    /** 批处理条数（订单标记） */
    public static final long BATCH_ORDER_FLAG = 40L;

    /** 批处理条数（订单说明） */
    public static final long BATCH_ORDER_REMARK = 45L;

    /** 批处理条数（订单来源） */
    public static final long BATCH_ORDER_SOURCE = 50L;

    /** 批处理条数（订单版本） */
    public static final long BATCH_ORDER_VERSION = 55L;

    /** 批处理条数（订单区域） */
    public static final long BATCH_ORDER_REGION = 60L;

    /** 批处理条数（订单渠道） */
    public static final long BATCH_ORDER_CHANNEL = 65L;

    /** 批处理条数（订单分组） */
    public static final long BATCH_ORDER_GROUP = 70L;

    /** 批处理条数（订单标签） */
    public static final long BATCH_ORDER_TAG = 75L;

    /** 批处理条数（订单负责人） */
    public static final long BATCH_ORDER_OWNER = 80L;

    /** 批处理条数（付款编号） */
    public static final long BATCH_PAYMENT_NO = 85L;

    /** 批处理条数（付款名称） */
    public static final long BATCH_PAYMENT_NAME = 90L;

    /** 批处理条数（付款类型） */
    public static final long BATCH_PAYMENT_TYPE = 95L;

    /** 批处理条数（付款编码） */
    public static final long BATCH_PAYMENT_CODE = 100L;

    /** 批处理条数（付款级别） */
    public static final long BATCH_PAYMENT_LEVEL = 105L;

    /** 批处理条数（付款状态） */
    public static final long BATCH_PAYMENT_STATUS = 110L;

    /** 批处理条数（付款金额） */
    public static final long BATCH_PAYMENT_AMOUNT = 115L;

    /** 批处理条数（付款数量） */
    public static final long BATCH_PAYMENT_COUNT = 120L;

    /** 批处理条数（付款比率） */
    public static final long BATCH_PAYMENT_RATE = 125L;

    /** 批处理条数（付款日期） */
    public static final long BATCH_PAYMENT_DATE = 130L;

    /** 批处理条数（付款时间） */
    public static final long BATCH_PAYMENT_TIME = 135L;

    /** 批处理条数（付款标记） */
    public static final long BATCH_PAYMENT_FLAG = 140L;

    /** 批处理条数（付款说明） */
    public static final long BATCH_PAYMENT_REMARK = 145L;

    /** 批处理条数（付款来源） */
    public static final long BATCH_PAYMENT_SOURCE = 150L;

    /** 批处理条数（付款版本） */
    public static final long BATCH_PAYMENT_VERSION = 155L;

    /** 批处理条数（付款区域） */
    public static final long BATCH_PAYMENT_REGION = 160L;

    /** 批处理条数（付款渠道） */
    public static final long BATCH_PAYMENT_CHANNEL = 165L;

    /** 批处理条数（付款分组） */
    public static final long BATCH_PAYMENT_GROUP = 170L;

    /** 批处理条数（付款标签） */
    public static final long BATCH_PAYMENT_TAG = 175L;

    /** 批处理条数（付款负责人） */
    public static final long BATCH_PAYMENT_OWNER = 180L;

    /** 批处理条数（发票编号） */
    public static final long BATCH_INVOICE_NO = 185L;

    /** 批处理条数（发票名称） */
    public static final long BATCH_INVOICE_NAME = 190L;

    /** 批处理条数（发票类型） */
    public static final long BATCH_INVOICE_TYPE = 195L;

    /** 批处理条数（发票编码） */
    public static final long BATCH_INVOICE_CODE = 200L;

    /** 批处理条数（发票级别） */
    public static final long BATCH_INVOICE_LEVEL = 205L;

    /** 批处理条数（发票状态） */
    public static final long BATCH_INVOICE_STATUS = 210L;

    /** 批处理条数（发票金额） */
    public static final long BATCH_INVOICE_AMOUNT = 215L;

    /** 批处理条数（发票数量） */
    public static final long BATCH_INVOICE_COUNT = 220L;

    /** 批处理条数（发票比率） */
    public static final long BATCH_INVOICE_RATE = 225L;

    /** 批处理条数（发票日期） */
    public static final long BATCH_INVOICE_DATE = 230L;

    /** 批处理条数（发票时间） */
    public static final long BATCH_INVOICE_TIME = 235L;

    /** 批处理条数（发票标记） */
    public static final long BATCH_INVOICE_FLAG = 240L;

    /** 批处理条数（发票说明） */
    public static final long BATCH_INVOICE_REMARK = 245L;

    /** 批处理条数（发票来源） */
    public static final long BATCH_INVOICE_SOURCE = 250L;

    /** 批处理条数（发票版本） */
    public static final long BATCH_INVOICE_VERSION = 255L;

    /** 批处理条数（发票区域） */
    public static final long BATCH_INVOICE_REGION = 260L;

    /** 批处理条数（发票渠道） */
    public static final long BATCH_INVOICE_CHANNEL = 265L;

    /** 批处理条数（发票分组） */
    public static final long BATCH_INVOICE_GROUP = 270L;

    /** 批处理条数（发票标签） */
    public static final long BATCH_INVOICE_TAG = 275L;

    /** 批处理条数（发票负责人） */
    public static final long BATCH_INVOICE_OWNER = 280L;

    /** 批处理条数（结算编号） */
    public static final long BATCH_SETTLE_NO = 285L;

    /** 批处理条数（结算名称） */
    public static final long BATCH_SETTLE_NAME = 290L;

    /** 批处理条数（结算类型） */
    public static final long BATCH_SETTLE_TYPE = 295L;

    /** 批处理条数（结算编码） */
    public static final long BATCH_SETTLE_CODE = 300L;

    private CustRefundJobConfig() {
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

    /** 批处理条数（订单标记）。 */
    public static long resolveBatchOrderFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_FLAG;
        }
        if (requested > BATCH_ORDER_FLAG) {
            return BATCH_ORDER_FLAG;
        }
        return requested;
    }

    /** 批处理条数（订单说明）。 */
    public static long resolveBatchOrderRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_REMARK;
        }
        if (requested > BATCH_ORDER_REMARK) {
            return BATCH_ORDER_REMARK;
        }
        return requested;
    }

    /** 批处理条数（订单来源）。 */
    public static long resolveBatchOrderSource(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_SOURCE;
        }
        if (requested > BATCH_ORDER_SOURCE) {
            return BATCH_ORDER_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（订单版本）。 */
    public static long resolveBatchOrderVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_VERSION;
        }
        if (requested > BATCH_ORDER_VERSION) {
            return BATCH_ORDER_VERSION;
        }
        return requested;
    }

    /** 批处理条数（订单区域）。 */
    public static long resolveBatchOrderRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_REGION;
        }
        if (requested > BATCH_ORDER_REGION) {
            return BATCH_ORDER_REGION;
        }
        return requested;
    }

    /** 批处理条数（订单渠道）。 */
    public static long resolveBatchOrderChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_CHANNEL;
        }
        if (requested > BATCH_ORDER_CHANNEL) {
            return BATCH_ORDER_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（订单分组）。 */
    public static long resolveBatchOrderGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_GROUP;
        }
        if (requested > BATCH_ORDER_GROUP) {
            return BATCH_ORDER_GROUP;
        }
        return requested;
    }

    /** 批处理条数（订单标签）。 */
    public static long resolveBatchOrderTag(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_TAG;
        }
        if (requested > BATCH_ORDER_TAG) {
            return BATCH_ORDER_TAG;
        }
        return requested;
    }

    /** 批处理条数（订单负责人）。 */
    public static long resolveBatchOrderOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_ORDER_OWNER;
        }
        if (requested > BATCH_ORDER_OWNER) {
            return BATCH_ORDER_OWNER;
        }
        return requested;
    }

    /** 批处理条数（付款编号）。 */
    public static long resolveBatchPaymentNo(long requested) {
        if (requested <= 0L) {
            return BATCH_PAYMENT_NO;
        }
        if (requested > BATCH_PAYMENT_NO) {
            return BATCH_PAYMENT_NO;
        }
        return requested;
    }

    /** 批处理条数（付款名称）。 */
    public static long resolveBatchPaymentName(long requested) {
        if (requested <= 0L) {
            return BATCH_PAYMENT_NAME;
        }
        if (requested > BATCH_PAYMENT_NAME) {
            return BATCH_PAYMENT_NAME;
        }
        return requested;
    }

    /** 批处理条数（付款类型）。 */
    public static long resolveBatchPaymentType(long requested) {
        if (requested <= 0L) {
            return BATCH_PAYMENT_TYPE;
        }
        if (requested > BATCH_PAYMENT_TYPE) {
            return BATCH_PAYMENT_TYPE;
        }
        return requested;
    }

    /** 批处理条数（付款编码）。 */
    public static long resolveBatchPaymentCode(long requested) {
        if (requested <= 0L) {
            return BATCH_PAYMENT_CODE;
        }
        if (requested > BATCH_PAYMENT_CODE) {
            return BATCH_PAYMENT_CODE;
        }
        return requested;
    }

}

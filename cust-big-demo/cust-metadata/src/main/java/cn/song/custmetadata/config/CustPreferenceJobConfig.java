package cn.song.custmetadata.config;

/**
 * 客户偏好JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustPreferenceJobConfig {

    public static final String MODULE_CODE = "CUST_PREFERENCE_JOB_CONFIG";

    /** 过期天数（订单时间） */
    public static final long EXPIRED_ORDER_TIME = 5L;

    /** 过期天数（订单标记） */
    public static final long EXPIRED_ORDER_FLAG = 10L;

    /** 过期天数（订单说明） */
    public static final long EXPIRED_ORDER_REMARK = 15L;

    /** 过期天数（订单来源） */
    public static final long EXPIRED_ORDER_SOURCE = 20L;

    /** 过期天数（订单版本） */
    public static final long EXPIRED_ORDER_VERSION = 25L;

    /** 过期天数（订单区域） */
    public static final long EXPIRED_ORDER_REGION = 30L;

    /** 过期天数（订单渠道） */
    public static final long EXPIRED_ORDER_CHANNEL = 35L;

    /** 过期天数（订单分组） */
    public static final long EXPIRED_ORDER_GROUP = 40L;

    /** 过期天数（订单标签） */
    public static final long EXPIRED_ORDER_TAG = 45L;

    /** 过期天数（订单负责人） */
    public static final long EXPIRED_ORDER_OWNER = 50L;

    /** 过期天数（付款编号） */
    public static final long EXPIRED_PAYMENT_NO = 55L;

    /** 过期天数（付款名称） */
    public static final long EXPIRED_PAYMENT_NAME = 60L;

    /** 过期天数（付款类型） */
    public static final long EXPIRED_PAYMENT_TYPE = 65L;

    /** 过期天数（付款编码） */
    public static final long EXPIRED_PAYMENT_CODE = 70L;

    /** 过期天数（付款级别） */
    public static final long EXPIRED_PAYMENT_LEVEL = 75L;

    /** 过期天数（付款状态） */
    public static final long EXPIRED_PAYMENT_STATUS = 80L;

    /** 过期天数（付款金额） */
    public static final long EXPIRED_PAYMENT_AMOUNT = 85L;

    /** 过期天数（付款数量） */
    public static final long EXPIRED_PAYMENT_COUNT = 90L;

    /** 过期天数（付款比率） */
    public static final long EXPIRED_PAYMENT_RATE = 95L;

    /** 过期天数（付款日期） */
    public static final long EXPIRED_PAYMENT_DATE = 100L;

    /** 过期天数（付款时间） */
    public static final long EXPIRED_PAYMENT_TIME = 105L;

    /** 过期天数（付款标记） */
    public static final long EXPIRED_PAYMENT_FLAG = 110L;

    /** 过期天数（付款说明） */
    public static final long EXPIRED_PAYMENT_REMARK = 115L;

    /** 过期天数（付款来源） */
    public static final long EXPIRED_PAYMENT_SOURCE = 120L;

    /** 过期天数（付款版本） */
    public static final long EXPIRED_PAYMENT_VERSION = 125L;

    /** 过期天数（付款区域） */
    public static final long EXPIRED_PAYMENT_REGION = 130L;

    /** 过期天数（付款渠道） */
    public static final long EXPIRED_PAYMENT_CHANNEL = 135L;

    /** 过期天数（付款分组） */
    public static final long EXPIRED_PAYMENT_GROUP = 140L;

    /** 过期天数（付款标签） */
    public static final long EXPIRED_PAYMENT_TAG = 145L;

    /** 过期天数（付款负责人） */
    public static final long EXPIRED_PAYMENT_OWNER = 150L;

    /** 过期天数（发票编号） */
    public static final long EXPIRED_INVOICE_NO = 155L;

    /** 过期天数（发票名称） */
    public static final long EXPIRED_INVOICE_NAME = 160L;

    /** 过期天数（发票类型） */
    public static final long EXPIRED_INVOICE_TYPE = 165L;

    /** 过期天数（发票编码） */
    public static final long EXPIRED_INVOICE_CODE = 170L;

    /** 过期天数（发票级别） */
    public static final long EXPIRED_INVOICE_LEVEL = 175L;

    /** 过期天数（发票状态） */
    public static final long EXPIRED_INVOICE_STATUS = 180L;

    /** 过期天数（发票金额） */
    public static final long EXPIRED_INVOICE_AMOUNT = 185L;

    /** 过期天数（发票数量） */
    public static final long EXPIRED_INVOICE_COUNT = 190L;

    /** 过期天数（发票比率） */
    public static final long EXPIRED_INVOICE_RATE = 195L;

    /** 过期天数（发票日期） */
    public static final long EXPIRED_INVOICE_DATE = 200L;

    /** 过期天数（发票时间） */
    public static final long EXPIRED_INVOICE_TIME = 205L;

    /** 过期天数（发票标记） */
    public static final long EXPIRED_INVOICE_FLAG = 210L;

    /** 过期天数（发票说明） */
    public static final long EXPIRED_INVOICE_REMARK = 215L;

    /** 过期天数（发票来源） */
    public static final long EXPIRED_INVOICE_SOURCE = 220L;

    /** 过期天数（发票版本） */
    public static final long EXPIRED_INVOICE_VERSION = 225L;

    /** 过期天数（发票区域） */
    public static final long EXPIRED_INVOICE_REGION = 230L;

    /** 过期天数（发票渠道） */
    public static final long EXPIRED_INVOICE_CHANNEL = 235L;

    /** 过期天数（发票分组） */
    public static final long EXPIRED_INVOICE_GROUP = 240L;

    /** 过期天数（发票标签） */
    public static final long EXPIRED_INVOICE_TAG = 245L;

    /** 过期天数（发票负责人） */
    public static final long EXPIRED_INVOICE_OWNER = 250L;

    /** 过期天数（结算编号） */
    public static final long EXPIRED_SETTLE_NO = 255L;

    /** 过期天数（结算名称） */
    public static final long EXPIRED_SETTLE_NAME = 260L;

    /** 过期天数（结算类型） */
    public static final long EXPIRED_SETTLE_TYPE = 265L;

    /** 过期天数（结算编码） */
    public static final long EXPIRED_SETTLE_CODE = 270L;

    /** 过期天数（结算级别） */
    public static final long EXPIRED_SETTLE_LEVEL = 275L;

    /** 过期天数（结算状态） */
    public static final long EXPIRED_SETTLE_STATUS = 280L;

    /** 过期天数（结算金额） */
    public static final long EXPIRED_SETTLE_AMOUNT = 285L;

    /** 过期天数（结算数量） */
    public static final long EXPIRED_SETTLE_COUNT = 290L;

    /** 过期天数（结算比率） */
    public static final long EXPIRED_SETTLE_RATE = 295L;

    /** 过期天数（结算日期） */
    public static final long EXPIRED_SETTLE_DATE = 300L;

    private CustPreferenceJobConfig() {
    }

    /** 过期天数（订单时间）。 */
    public static long resolveExpiredOrderTime(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_TIME;
        }
        if (requested > EXPIRED_ORDER_TIME) {
            return EXPIRED_ORDER_TIME;
        }
        return requested;
    }

    /** 过期天数（订单标记）。 */
    public static long resolveExpiredOrderFlag(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_FLAG;
        }
        if (requested > EXPIRED_ORDER_FLAG) {
            return EXPIRED_ORDER_FLAG;
        }
        return requested;
    }

    /** 过期天数（订单说明）。 */
    public static long resolveExpiredOrderRemark(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_REMARK;
        }
        if (requested > EXPIRED_ORDER_REMARK) {
            return EXPIRED_ORDER_REMARK;
        }
        return requested;
    }

    /** 过期天数（订单来源）。 */
    public static long resolveExpiredOrderSource(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_SOURCE;
        }
        if (requested > EXPIRED_ORDER_SOURCE) {
            return EXPIRED_ORDER_SOURCE;
        }
        return requested;
    }

    /** 过期天数（订单版本）。 */
    public static long resolveExpiredOrderVersion(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_VERSION;
        }
        if (requested > EXPIRED_ORDER_VERSION) {
            return EXPIRED_ORDER_VERSION;
        }
        return requested;
    }

    /** 过期天数（订单区域）。 */
    public static long resolveExpiredOrderRegion(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_REGION;
        }
        if (requested > EXPIRED_ORDER_REGION) {
            return EXPIRED_ORDER_REGION;
        }
        return requested;
    }

    /** 过期天数（订单渠道）。 */
    public static long resolveExpiredOrderChannel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_CHANNEL;
        }
        if (requested > EXPIRED_ORDER_CHANNEL) {
            return EXPIRED_ORDER_CHANNEL;
        }
        return requested;
    }

    /** 过期天数（订单分组）。 */
    public static long resolveExpiredOrderGroup(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_GROUP;
        }
        if (requested > EXPIRED_ORDER_GROUP) {
            return EXPIRED_ORDER_GROUP;
        }
        return requested;
    }

    /** 过期天数（订单标签）。 */
    public static long resolveExpiredOrderTag(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_TAG;
        }
        if (requested > EXPIRED_ORDER_TAG) {
            return EXPIRED_ORDER_TAG;
        }
        return requested;
    }

    /** 过期天数（订单负责人）。 */
    public static long resolveExpiredOrderOwner(long requested) {
        if (requested <= 0L) {
            return EXPIRED_ORDER_OWNER;
        }
        if (requested > EXPIRED_ORDER_OWNER) {
            return EXPIRED_ORDER_OWNER;
        }
        return requested;
    }

    /** 过期天数（付款编号）。 */
    public static long resolveExpiredPaymentNo(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_NO;
        }
        if (requested > EXPIRED_PAYMENT_NO) {
            return EXPIRED_PAYMENT_NO;
        }
        return requested;
    }

    /** 过期天数（付款名称）。 */
    public static long resolveExpiredPaymentName(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_NAME;
        }
        if (requested > EXPIRED_PAYMENT_NAME) {
            return EXPIRED_PAYMENT_NAME;
        }
        return requested;
    }

    /** 过期天数（付款类型）。 */
    public static long resolveExpiredPaymentType(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_TYPE;
        }
        if (requested > EXPIRED_PAYMENT_TYPE) {
            return EXPIRED_PAYMENT_TYPE;
        }
        return requested;
    }

    /** 过期天数（付款编码）。 */
    public static long resolveExpiredPaymentCode(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_CODE;
        }
        if (requested > EXPIRED_PAYMENT_CODE) {
            return EXPIRED_PAYMENT_CODE;
        }
        return requested;
    }

    /** 过期天数（付款级别）。 */
    public static long resolveExpiredPaymentLevel(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_LEVEL;
        }
        if (requested > EXPIRED_PAYMENT_LEVEL) {
            return EXPIRED_PAYMENT_LEVEL;
        }
        return requested;
    }

    /** 过期天数（付款状态）。 */
    public static long resolveExpiredPaymentStatus(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_STATUS;
        }
        if (requested > EXPIRED_PAYMENT_STATUS) {
            return EXPIRED_PAYMENT_STATUS;
        }
        return requested;
    }

    /** 过期天数（付款金额）。 */
    public static long resolveExpiredPaymentAmount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_AMOUNT;
        }
        if (requested > EXPIRED_PAYMENT_AMOUNT) {
            return EXPIRED_PAYMENT_AMOUNT;
        }
        return requested;
    }

    /** 过期天数（付款数量）。 */
    public static long resolveExpiredPaymentCount(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_COUNT;
        }
        if (requested > EXPIRED_PAYMENT_COUNT) {
            return EXPIRED_PAYMENT_COUNT;
        }
        return requested;
    }

    /** 过期天数（付款比率）。 */
    public static long resolveExpiredPaymentRate(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_RATE;
        }
        if (requested > EXPIRED_PAYMENT_RATE) {
            return EXPIRED_PAYMENT_RATE;
        }
        return requested;
    }

    /** 过期天数（付款日期）。 */
    public static long resolveExpiredPaymentDate(long requested) {
        if (requested <= 0L) {
            return EXPIRED_PAYMENT_DATE;
        }
        if (requested > EXPIRED_PAYMENT_DATE) {
            return EXPIRED_PAYMENT_DATE;
        }
        return requested;
    }

}

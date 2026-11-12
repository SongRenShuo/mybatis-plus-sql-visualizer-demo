package cn.song.custmetadata.config;

/**
 * 客户行业关系CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustIndustryRelCacheConfig {

    public static final String MODULE_CODE = "CUST_INDUSTRY_REL_CACHE_CONFIG";

    /** 重试次数（拜访负责人） */
    public static final long RETRY_VISIT_OWNER = 5L;

    /** 重试次数（合同编号） */
    public static final long RETRY_CONTRACT_NO = 10L;

    /** 重试次数（合同名称） */
    public static final long RETRY_CONTRACT_NAME = 15L;

    /** 重试次数（合同类型） */
    public static final long RETRY_CONTRACT_TYPE = 20L;

    /** 重试次数（合同编码） */
    public static final long RETRY_CONTRACT_CODE = 25L;

    /** 重试次数（合同级别） */
    public static final long RETRY_CONTRACT_LEVEL = 30L;

    /** 重试次数（合同状态） */
    public static final long RETRY_CONTRACT_STATUS = 35L;

    /** 重试次数（合同金额） */
    public static final long RETRY_CONTRACT_AMOUNT = 40L;

    /** 重试次数（合同数量） */
    public static final long RETRY_CONTRACT_COUNT = 45L;

    /** 重试次数（合同比率） */
    public static final long RETRY_CONTRACT_RATE = 50L;

    /** 重试次数（合同日期） */
    public static final long RETRY_CONTRACT_DATE = 55L;

    /** 重试次数（合同时间） */
    public static final long RETRY_CONTRACT_TIME = 60L;

    /** 重试次数（合同标记） */
    public static final long RETRY_CONTRACT_FLAG = 65L;

    /** 重试次数（合同说明） */
    public static final long RETRY_CONTRACT_REMARK = 70L;

    /** 重试次数（合同来源） */
    public static final long RETRY_CONTRACT_SOURCE = 75L;

    /** 重试次数（合同版本） */
    public static final long RETRY_CONTRACT_VERSION = 80L;

    /** 重试次数（合同区域） */
    public static final long RETRY_CONTRACT_REGION = 85L;

    /** 重试次数（合同渠道） */
    public static final long RETRY_CONTRACT_CHANNEL = 90L;

    /** 重试次数（合同分组） */
    public static final long RETRY_CONTRACT_GROUP = 95L;

    /** 重试次数（合同标签） */
    public static final long RETRY_CONTRACT_TAG = 100L;

    /** 重试次数（合同负责人） */
    public static final long RETRY_CONTRACT_OWNER = 105L;

    /** 重试次数（订单编号） */
    public static final long RETRY_ORDER_NO = 110L;

    /** 重试次数（订单名称） */
    public static final long RETRY_ORDER_NAME = 115L;

    /** 重试次数（订单类型） */
    public static final long RETRY_ORDER_TYPE = 120L;

    /** 重试次数（订单编码） */
    public static final long RETRY_ORDER_CODE = 125L;

    /** 重试次数（订单级别） */
    public static final long RETRY_ORDER_LEVEL = 130L;

    /** 重试次数（订单状态） */
    public static final long RETRY_ORDER_STATUS = 135L;

    /** 重试次数（订单金额） */
    public static final long RETRY_ORDER_AMOUNT = 140L;

    /** 重试次数（订单数量） */
    public static final long RETRY_ORDER_COUNT = 145L;

    /** 重试次数（订单比率） */
    public static final long RETRY_ORDER_RATE = 150L;

    /** 重试次数（订单日期） */
    public static final long RETRY_ORDER_DATE = 155L;

    /** 重试次数（订单时间） */
    public static final long RETRY_ORDER_TIME = 160L;

    /** 重试次数（订单标记） */
    public static final long RETRY_ORDER_FLAG = 165L;

    /** 重试次数（订单说明） */
    public static final long RETRY_ORDER_REMARK = 170L;

    /** 重试次数（订单来源） */
    public static final long RETRY_ORDER_SOURCE = 175L;

    /** 重试次数（订单版本） */
    public static final long RETRY_ORDER_VERSION = 180L;

    /** 重试次数（订单区域） */
    public static final long RETRY_ORDER_REGION = 185L;

    /** 重试次数（订单渠道） */
    public static final long RETRY_ORDER_CHANNEL = 190L;

    /** 重试次数（订单分组） */
    public static final long RETRY_ORDER_GROUP = 195L;

    /** 重试次数（订单标签） */
    public static final long RETRY_ORDER_TAG = 200L;

    /** 重试次数（订单负责人） */
    public static final long RETRY_ORDER_OWNER = 205L;

    /** 重试次数（付款编号） */
    public static final long RETRY_PAYMENT_NO = 210L;

    /** 重试次数（付款名称） */
    public static final long RETRY_PAYMENT_NAME = 215L;

    /** 重试次数（付款类型） */
    public static final long RETRY_PAYMENT_TYPE = 220L;

    /** 重试次数（付款编码） */
    public static final long RETRY_PAYMENT_CODE = 225L;

    /** 重试次数（付款级别） */
    public static final long RETRY_PAYMENT_LEVEL = 230L;

    /** 重试次数（付款状态） */
    public static final long RETRY_PAYMENT_STATUS = 235L;

    /** 重试次数（付款金额） */
    public static final long RETRY_PAYMENT_AMOUNT = 240L;

    /** 重试次数（付款数量） */
    public static final long RETRY_PAYMENT_COUNT = 245L;

    /** 重试次数（付款比率） */
    public static final long RETRY_PAYMENT_RATE = 250L;

    /** 重试次数（付款日期） */
    public static final long RETRY_PAYMENT_DATE = 255L;

    /** 重试次数（付款时间） */
    public static final long RETRY_PAYMENT_TIME = 260L;

    /** 重试次数（付款标记） */
    public static final long RETRY_PAYMENT_FLAG = 265L;

    /** 重试次数（付款说明） */
    public static final long RETRY_PAYMENT_REMARK = 270L;

    /** 重试次数（付款来源） */
    public static final long RETRY_PAYMENT_SOURCE = 275L;

    /** 重试次数（付款版本） */
    public static final long RETRY_PAYMENT_VERSION = 280L;

    /** 重试次数（付款区域） */
    public static final long RETRY_PAYMENT_REGION = 285L;

    /** 重试次数（付款渠道） */
    public static final long RETRY_PAYMENT_CHANNEL = 290L;

    /** 重试次数（付款分组） */
    public static final long RETRY_PAYMENT_GROUP = 295L;

    /** 重试次数（付款标签） */
    public static final long RETRY_PAYMENT_TAG = 300L;

    private CustIndustryRelCacheConfig() {
    }

    /** 重试次数（拜访负责人）。 */
    public static long resolveRetryVisitOwner(long requested) {
        if (requested <= 0L) {
            return RETRY_VISIT_OWNER;
        }
        if (requested > RETRY_VISIT_OWNER) {
            return RETRY_VISIT_OWNER;
        }
        return requested;
    }

    /** 重试次数（合同编号）。 */
    public static long resolveRetryContractNo(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_NO;
        }
        if (requested > RETRY_CONTRACT_NO) {
            return RETRY_CONTRACT_NO;
        }
        return requested;
    }

    /** 重试次数（合同名称）。 */
    public static long resolveRetryContractName(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_NAME;
        }
        if (requested > RETRY_CONTRACT_NAME) {
            return RETRY_CONTRACT_NAME;
        }
        return requested;
    }

    /** 重试次数（合同类型）。 */
    public static long resolveRetryContractType(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_TYPE;
        }
        if (requested > RETRY_CONTRACT_TYPE) {
            return RETRY_CONTRACT_TYPE;
        }
        return requested;
    }

    /** 重试次数（合同编码）。 */
    public static long resolveRetryContractCode(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_CODE;
        }
        if (requested > RETRY_CONTRACT_CODE) {
            return RETRY_CONTRACT_CODE;
        }
        return requested;
    }

    /** 重试次数（合同级别）。 */
    public static long resolveRetryContractLevel(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_LEVEL;
        }
        if (requested > RETRY_CONTRACT_LEVEL) {
            return RETRY_CONTRACT_LEVEL;
        }
        return requested;
    }

    /** 重试次数（合同状态）。 */
    public static long resolveRetryContractStatus(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_STATUS;
        }
        if (requested > RETRY_CONTRACT_STATUS) {
            return RETRY_CONTRACT_STATUS;
        }
        return requested;
    }

    /** 重试次数（合同金额）。 */
    public static long resolveRetryContractAmount(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_AMOUNT;
        }
        if (requested > RETRY_CONTRACT_AMOUNT) {
            return RETRY_CONTRACT_AMOUNT;
        }
        return requested;
    }

    /** 重试次数（合同数量）。 */
    public static long resolveRetryContractCount(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_COUNT;
        }
        if (requested > RETRY_CONTRACT_COUNT) {
            return RETRY_CONTRACT_COUNT;
        }
        return requested;
    }

    /** 重试次数（合同比率）。 */
    public static long resolveRetryContractRate(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_RATE;
        }
        if (requested > RETRY_CONTRACT_RATE) {
            return RETRY_CONTRACT_RATE;
        }
        return requested;
    }

    /** 重试次数（合同日期）。 */
    public static long resolveRetryContractDate(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_DATE;
        }
        if (requested > RETRY_CONTRACT_DATE) {
            return RETRY_CONTRACT_DATE;
        }
        return requested;
    }

    /** 重试次数（合同时间）。 */
    public static long resolveRetryContractTime(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_TIME;
        }
        if (requested > RETRY_CONTRACT_TIME) {
            return RETRY_CONTRACT_TIME;
        }
        return requested;
    }

    /** 重试次数（合同标记）。 */
    public static long resolveRetryContractFlag(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_FLAG;
        }
        if (requested > RETRY_CONTRACT_FLAG) {
            return RETRY_CONTRACT_FLAG;
        }
        return requested;
    }

    /** 重试次数（合同说明）。 */
    public static long resolveRetryContractRemark(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_REMARK;
        }
        if (requested > RETRY_CONTRACT_REMARK) {
            return RETRY_CONTRACT_REMARK;
        }
        return requested;
    }

    /** 重试次数（合同来源）。 */
    public static long resolveRetryContractSource(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_SOURCE;
        }
        if (requested > RETRY_CONTRACT_SOURCE) {
            return RETRY_CONTRACT_SOURCE;
        }
        return requested;
    }

    /** 重试次数（合同版本）。 */
    public static long resolveRetryContractVersion(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_VERSION;
        }
        if (requested > RETRY_CONTRACT_VERSION) {
            return RETRY_CONTRACT_VERSION;
        }
        return requested;
    }

    /** 重试次数（合同区域）。 */
    public static long resolveRetryContractRegion(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_REGION;
        }
        if (requested > RETRY_CONTRACT_REGION) {
            return RETRY_CONTRACT_REGION;
        }
        return requested;
    }

    /** 重试次数（合同渠道）。 */
    public static long resolveRetryContractChannel(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_CHANNEL;
        }
        if (requested > RETRY_CONTRACT_CHANNEL) {
            return RETRY_CONTRACT_CHANNEL;
        }
        return requested;
    }

    /** 重试次数（合同分组）。 */
    public static long resolveRetryContractGroup(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_GROUP;
        }
        if (requested > RETRY_CONTRACT_GROUP) {
            return RETRY_CONTRACT_GROUP;
        }
        return requested;
    }

    /** 重试次数（合同标签）。 */
    public static long resolveRetryContractTag(long requested) {
        if (requested <= 0L) {
            return RETRY_CONTRACT_TAG;
        }
        if (requested > RETRY_CONTRACT_TAG) {
            return RETRY_CONTRACT_TAG;
        }
        return requested;
    }

}

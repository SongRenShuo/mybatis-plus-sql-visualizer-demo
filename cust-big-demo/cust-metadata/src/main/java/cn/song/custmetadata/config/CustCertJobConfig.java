package cn.song.custmetadata.config;

/**
 * 客户证件JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustCertJobConfig {

    public static final String MODULE_CODE = "CUST_CERT_JOB_CONFIG";

    /** 单次查询上限（合同编号） */
    public static final long LIMIT_CONTRACT_NO = 5L;

    /** 单次查询上限（合同名称） */
    public static final long LIMIT_CONTRACT_NAME = 10L;

    /** 单次查询上限（合同类型） */
    public static final long LIMIT_CONTRACT_TYPE = 15L;

    /** 单次查询上限（合同编码） */
    public static final long LIMIT_CONTRACT_CODE = 20L;

    /** 单次查询上限（合同级别） */
    public static final long LIMIT_CONTRACT_LEVEL = 25L;

    /** 单次查询上限（合同状态） */
    public static final long LIMIT_CONTRACT_STATUS = 30L;

    /** 单次查询上限（合同金额） */
    public static final long LIMIT_CONTRACT_AMOUNT = 35L;

    /** 单次查询上限（合同数量） */
    public static final long LIMIT_CONTRACT_COUNT = 40L;

    /** 单次查询上限（合同比率） */
    public static final long LIMIT_CONTRACT_RATE = 45L;

    /** 单次查询上限（合同日期） */
    public static final long LIMIT_CONTRACT_DATE = 50L;

    /** 单次查询上限（合同时间） */
    public static final long LIMIT_CONTRACT_TIME = 55L;

    /** 单次查询上限（合同标记） */
    public static final long LIMIT_CONTRACT_FLAG = 60L;

    /** 单次查询上限（合同说明） */
    public static final long LIMIT_CONTRACT_REMARK = 65L;

    /** 单次查询上限（合同来源） */
    public static final long LIMIT_CONTRACT_SOURCE = 70L;

    /** 单次查询上限（合同版本） */
    public static final long LIMIT_CONTRACT_VERSION = 75L;

    /** 单次查询上限（合同区域） */
    public static final long LIMIT_CONTRACT_REGION = 80L;

    /** 单次查询上限（合同渠道） */
    public static final long LIMIT_CONTRACT_CHANNEL = 85L;

    /** 单次查询上限（合同分组） */
    public static final long LIMIT_CONTRACT_GROUP = 90L;

    /** 单次查询上限（合同标签） */
    public static final long LIMIT_CONTRACT_TAG = 95L;

    /** 单次查询上限（合同负责人） */
    public static final long LIMIT_CONTRACT_OWNER = 100L;

    /** 单次查询上限（订单编号） */
    public static final long LIMIT_ORDER_NO = 105L;

    /** 单次查询上限（订单名称） */
    public static final long LIMIT_ORDER_NAME = 110L;

    /** 单次查询上限（订单类型） */
    public static final long LIMIT_ORDER_TYPE = 115L;

    /** 单次查询上限（订单编码） */
    public static final long LIMIT_ORDER_CODE = 120L;

    /** 单次查询上限（订单级别） */
    public static final long LIMIT_ORDER_LEVEL = 125L;

    /** 单次查询上限（订单状态） */
    public static final long LIMIT_ORDER_STATUS = 130L;

    /** 单次查询上限（订单金额） */
    public static final long LIMIT_ORDER_AMOUNT = 135L;

    /** 单次查询上限（订单数量） */
    public static final long LIMIT_ORDER_COUNT = 140L;

    /** 单次查询上限（订单比率） */
    public static final long LIMIT_ORDER_RATE = 145L;

    /** 单次查询上限（订单日期） */
    public static final long LIMIT_ORDER_DATE = 150L;

    /** 单次查询上限（订单时间） */
    public static final long LIMIT_ORDER_TIME = 155L;

    /** 单次查询上限（订单标记） */
    public static final long LIMIT_ORDER_FLAG = 160L;

    /** 单次查询上限（订单说明） */
    public static final long LIMIT_ORDER_REMARK = 165L;

    /** 单次查询上限（订单来源） */
    public static final long LIMIT_ORDER_SOURCE = 170L;

    /** 单次查询上限（订单版本） */
    public static final long LIMIT_ORDER_VERSION = 175L;

    /** 单次查询上限（订单区域） */
    public static final long LIMIT_ORDER_REGION = 180L;

    /** 单次查询上限（订单渠道） */
    public static final long LIMIT_ORDER_CHANNEL = 185L;

    /** 单次查询上限（订单分组） */
    public static final long LIMIT_ORDER_GROUP = 190L;

    /** 单次查询上限（订单标签） */
    public static final long LIMIT_ORDER_TAG = 195L;

    /** 单次查询上限（订单负责人） */
    public static final long LIMIT_ORDER_OWNER = 200L;

    /** 单次查询上限（付款编号） */
    public static final long LIMIT_PAYMENT_NO = 205L;

    /** 单次查询上限（付款名称） */
    public static final long LIMIT_PAYMENT_NAME = 210L;

    /** 单次查询上限（付款类型） */
    public static final long LIMIT_PAYMENT_TYPE = 215L;

    /** 单次查询上限（付款编码） */
    public static final long LIMIT_PAYMENT_CODE = 220L;

    /** 单次查询上限（付款级别） */
    public static final long LIMIT_PAYMENT_LEVEL = 225L;

    /** 单次查询上限（付款状态） */
    public static final long LIMIT_PAYMENT_STATUS = 230L;

    /** 单次查询上限（付款金额） */
    public static final long LIMIT_PAYMENT_AMOUNT = 235L;

    /** 单次查询上限（付款数量） */
    public static final long LIMIT_PAYMENT_COUNT = 240L;

    /** 单次查询上限（付款比率） */
    public static final long LIMIT_PAYMENT_RATE = 245L;

    /** 单次查询上限（付款日期） */
    public static final long LIMIT_PAYMENT_DATE = 250L;

    /** 单次查询上限（付款时间） */
    public static final long LIMIT_PAYMENT_TIME = 255L;

    /** 单次查询上限（付款标记） */
    public static final long LIMIT_PAYMENT_FLAG = 260L;

    /** 单次查询上限（付款说明） */
    public static final long LIMIT_PAYMENT_REMARK = 265L;

    /** 单次查询上限（付款来源） */
    public static final long LIMIT_PAYMENT_SOURCE = 270L;

    /** 单次查询上限（付款版本） */
    public static final long LIMIT_PAYMENT_VERSION = 275L;

    /** 单次查询上限（付款区域） */
    public static final long LIMIT_PAYMENT_REGION = 280L;

    /** 单次查询上限（付款渠道） */
    public static final long LIMIT_PAYMENT_CHANNEL = 285L;

    /** 单次查询上限（付款分组） */
    public static final long LIMIT_PAYMENT_GROUP = 290L;

    /** 单次查询上限（付款标签） */
    public static final long LIMIT_PAYMENT_TAG = 295L;

    /** 单次查询上限（付款负责人） */
    public static final long LIMIT_PAYMENT_OWNER = 300L;

    private CustCertJobConfig() {
    }

    /** 单次查询上限（合同编号）。 */
    public static long resolveLimitContractNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_NO;
        }
        if (requested > LIMIT_CONTRACT_NO) {
            return LIMIT_CONTRACT_NO;
        }
        return requested;
    }

    /** 单次查询上限（合同名称）。 */
    public static long resolveLimitContractName(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_NAME;
        }
        if (requested > LIMIT_CONTRACT_NAME) {
            return LIMIT_CONTRACT_NAME;
        }
        return requested;
    }

    /** 单次查询上限（合同类型）。 */
    public static long resolveLimitContractType(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_TYPE;
        }
        if (requested > LIMIT_CONTRACT_TYPE) {
            return LIMIT_CONTRACT_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（合同编码）。 */
    public static long resolveLimitContractCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_CODE;
        }
        if (requested > LIMIT_CONTRACT_CODE) {
            return LIMIT_CONTRACT_CODE;
        }
        return requested;
    }

    /** 单次查询上限（合同级别）。 */
    public static long resolveLimitContractLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_LEVEL;
        }
        if (requested > LIMIT_CONTRACT_LEVEL) {
            return LIMIT_CONTRACT_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（合同状态）。 */
    public static long resolveLimitContractStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_STATUS;
        }
        if (requested > LIMIT_CONTRACT_STATUS) {
            return LIMIT_CONTRACT_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（合同金额）。 */
    public static long resolveLimitContractAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_AMOUNT;
        }
        if (requested > LIMIT_CONTRACT_AMOUNT) {
            return LIMIT_CONTRACT_AMOUNT;
        }
        return requested;
    }

    /** 单次查询上限（合同数量）。 */
    public static long resolveLimitContractCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_COUNT;
        }
        if (requested > LIMIT_CONTRACT_COUNT) {
            return LIMIT_CONTRACT_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（合同比率）。 */
    public static long resolveLimitContractRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_RATE;
        }
        if (requested > LIMIT_CONTRACT_RATE) {
            return LIMIT_CONTRACT_RATE;
        }
        return requested;
    }

    /** 单次查询上限（合同日期）。 */
    public static long resolveLimitContractDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_DATE;
        }
        if (requested > LIMIT_CONTRACT_DATE) {
            return LIMIT_CONTRACT_DATE;
        }
        return requested;
    }

    /** 单次查询上限（合同时间）。 */
    public static long resolveLimitContractTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_TIME;
        }
        if (requested > LIMIT_CONTRACT_TIME) {
            return LIMIT_CONTRACT_TIME;
        }
        return requested;
    }

    /** 单次查询上限（合同标记）。 */
    public static long resolveLimitContractFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_FLAG;
        }
        if (requested > LIMIT_CONTRACT_FLAG) {
            return LIMIT_CONTRACT_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（合同说明）。 */
    public static long resolveLimitContractRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_REMARK;
        }
        if (requested > LIMIT_CONTRACT_REMARK) {
            return LIMIT_CONTRACT_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（合同来源）。 */
    public static long resolveLimitContractSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_SOURCE;
        }
        if (requested > LIMIT_CONTRACT_SOURCE) {
            return LIMIT_CONTRACT_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（合同版本）。 */
    public static long resolveLimitContractVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_VERSION;
        }
        if (requested > LIMIT_CONTRACT_VERSION) {
            return LIMIT_CONTRACT_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（合同区域）。 */
    public static long resolveLimitContractRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_REGION;
        }
        if (requested > LIMIT_CONTRACT_REGION) {
            return LIMIT_CONTRACT_REGION;
        }
        return requested;
    }

    /** 单次查询上限（合同渠道）。 */
    public static long resolveLimitContractChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_CHANNEL;
        }
        if (requested > LIMIT_CONTRACT_CHANNEL) {
            return LIMIT_CONTRACT_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（合同分组）。 */
    public static long resolveLimitContractGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_GROUP;
        }
        if (requested > LIMIT_CONTRACT_GROUP) {
            return LIMIT_CONTRACT_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（合同标签）。 */
    public static long resolveLimitContractTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_TAG;
        }
        if (requested > LIMIT_CONTRACT_TAG) {
            return LIMIT_CONTRACT_TAG;
        }
        return requested;
    }

    /** 单次查询上限（合同负责人）。 */
    public static long resolveLimitContractOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_CONTRACT_OWNER;
        }
        if (requested > LIMIT_CONTRACT_OWNER) {
            return LIMIT_CONTRACT_OWNER;
        }
        return requested;
    }

}

package cn.song.custmetadata.config;

/**
 * 客户证件CacheConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustCertCacheConfig {

    public static final String MODULE_CODE = "CUST_CERT_CACHE_CONFIG";

    /** 单次查询上限（拜访数量） */
    public static final long LIMIT_VISIT_COUNT = 5L;

    /** 单次查询上限（拜访比率） */
    public static final long LIMIT_VISIT_RATE = 10L;

    /** 单次查询上限（拜访日期） */
    public static final long LIMIT_VISIT_DATE = 15L;

    /** 单次查询上限（拜访时间） */
    public static final long LIMIT_VISIT_TIME = 20L;

    /** 单次查询上限（拜访标记） */
    public static final long LIMIT_VISIT_FLAG = 25L;

    /** 单次查询上限（拜访说明） */
    public static final long LIMIT_VISIT_REMARK = 30L;

    /** 单次查询上限（拜访来源） */
    public static final long LIMIT_VISIT_SOURCE = 35L;

    /** 单次查询上限（拜访版本） */
    public static final long LIMIT_VISIT_VERSION = 40L;

    /** 单次查询上限（拜访区域） */
    public static final long LIMIT_VISIT_REGION = 45L;

    /** 单次查询上限（拜访渠道） */
    public static final long LIMIT_VISIT_CHANNEL = 50L;

    /** 单次查询上限（拜访分组） */
    public static final long LIMIT_VISIT_GROUP = 55L;

    /** 单次查询上限（拜访标签） */
    public static final long LIMIT_VISIT_TAG = 60L;

    /** 单次查询上限（拜访负责人） */
    public static final long LIMIT_VISIT_OWNER = 65L;

    /** 单次查询上限（合同编号） */
    public static final long LIMIT_CONTRACT_NO = 70L;

    /** 单次查询上限（合同名称） */
    public static final long LIMIT_CONTRACT_NAME = 75L;

    /** 单次查询上限（合同类型） */
    public static final long LIMIT_CONTRACT_TYPE = 80L;

    /** 单次查询上限（合同编码） */
    public static final long LIMIT_CONTRACT_CODE = 85L;

    /** 单次查询上限（合同级别） */
    public static final long LIMIT_CONTRACT_LEVEL = 90L;

    /** 单次查询上限（合同状态） */
    public static final long LIMIT_CONTRACT_STATUS = 95L;

    /** 单次查询上限（合同金额） */
    public static final long LIMIT_CONTRACT_AMOUNT = 100L;

    /** 单次查询上限（合同数量） */
    public static final long LIMIT_CONTRACT_COUNT = 105L;

    /** 单次查询上限（合同比率） */
    public static final long LIMIT_CONTRACT_RATE = 110L;

    /** 单次查询上限（合同日期） */
    public static final long LIMIT_CONTRACT_DATE = 115L;

    /** 单次查询上限（合同时间） */
    public static final long LIMIT_CONTRACT_TIME = 120L;

    /** 单次查询上限（合同标记） */
    public static final long LIMIT_CONTRACT_FLAG = 125L;

    /** 单次查询上限（合同说明） */
    public static final long LIMIT_CONTRACT_REMARK = 130L;

    /** 单次查询上限（合同来源） */
    public static final long LIMIT_CONTRACT_SOURCE = 135L;

    /** 单次查询上限（合同版本） */
    public static final long LIMIT_CONTRACT_VERSION = 140L;

    /** 单次查询上限（合同区域） */
    public static final long LIMIT_CONTRACT_REGION = 145L;

    /** 单次查询上限（合同渠道） */
    public static final long LIMIT_CONTRACT_CHANNEL = 150L;

    /** 单次查询上限（合同分组） */
    public static final long LIMIT_CONTRACT_GROUP = 155L;

    /** 单次查询上限（合同标签） */
    public static final long LIMIT_CONTRACT_TAG = 160L;

    /** 单次查询上限（合同负责人） */
    public static final long LIMIT_CONTRACT_OWNER = 165L;

    /** 单次查询上限（订单编号） */
    public static final long LIMIT_ORDER_NO = 170L;

    /** 单次查询上限（订单名称） */
    public static final long LIMIT_ORDER_NAME = 175L;

    /** 单次查询上限（订单类型） */
    public static final long LIMIT_ORDER_TYPE = 180L;

    /** 单次查询上限（订单编码） */
    public static final long LIMIT_ORDER_CODE = 185L;

    /** 单次查询上限（订单级别） */
    public static final long LIMIT_ORDER_LEVEL = 190L;

    /** 单次查询上限（订单状态） */
    public static final long LIMIT_ORDER_STATUS = 195L;

    /** 单次查询上限（订单金额） */
    public static final long LIMIT_ORDER_AMOUNT = 200L;

    /** 单次查询上限（订单数量） */
    public static final long LIMIT_ORDER_COUNT = 205L;

    /** 单次查询上限（订单比率） */
    public static final long LIMIT_ORDER_RATE = 210L;

    /** 单次查询上限（订单日期） */
    public static final long LIMIT_ORDER_DATE = 215L;

    /** 单次查询上限（订单时间） */
    public static final long LIMIT_ORDER_TIME = 220L;

    /** 单次查询上限（订单标记） */
    public static final long LIMIT_ORDER_FLAG = 225L;

    /** 单次查询上限（订单说明） */
    public static final long LIMIT_ORDER_REMARK = 230L;

    /** 单次查询上限（订单来源） */
    public static final long LIMIT_ORDER_SOURCE = 235L;

    /** 单次查询上限（订单版本） */
    public static final long LIMIT_ORDER_VERSION = 240L;

    /** 单次查询上限（订单区域） */
    public static final long LIMIT_ORDER_REGION = 245L;

    /** 单次查询上限（订单渠道） */
    public static final long LIMIT_ORDER_CHANNEL = 250L;

    /** 单次查询上限（订单分组） */
    public static final long LIMIT_ORDER_GROUP = 255L;

    /** 单次查询上限（订单标签） */
    public static final long LIMIT_ORDER_TAG = 260L;

    /** 单次查询上限（订单负责人） */
    public static final long LIMIT_ORDER_OWNER = 265L;

    /** 单次查询上限（付款编号） */
    public static final long LIMIT_PAYMENT_NO = 270L;

    /** 单次查询上限（付款名称） */
    public static final long LIMIT_PAYMENT_NAME = 275L;

    /** 单次查询上限（付款类型） */
    public static final long LIMIT_PAYMENT_TYPE = 280L;

    /** 单次查询上限（付款编码） */
    public static final long LIMIT_PAYMENT_CODE = 285L;

    /** 单次查询上限（付款级别） */
    public static final long LIMIT_PAYMENT_LEVEL = 290L;

    /** 单次查询上限（付款状态） */
    public static final long LIMIT_PAYMENT_STATUS = 295L;

    /** 单次查询上限（付款金额） */
    public static final long LIMIT_PAYMENT_AMOUNT = 300L;

    private CustCertCacheConfig() {
    }

    /** 单次查询上限（拜访数量）。 */
    public static long resolveLimitVisitCount(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_COUNT;
        }
        if (requested > LIMIT_VISIT_COUNT) {
            return LIMIT_VISIT_COUNT;
        }
        return requested;
    }

    /** 单次查询上限（拜访比率）。 */
    public static long resolveLimitVisitRate(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_RATE;
        }
        if (requested > LIMIT_VISIT_RATE) {
            return LIMIT_VISIT_RATE;
        }
        return requested;
    }

    /** 单次查询上限（拜访日期）。 */
    public static long resolveLimitVisitDate(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_DATE;
        }
        if (requested > LIMIT_VISIT_DATE) {
            return LIMIT_VISIT_DATE;
        }
        return requested;
    }

    /** 单次查询上限（拜访时间）。 */
    public static long resolveLimitVisitTime(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_TIME;
        }
        if (requested > LIMIT_VISIT_TIME) {
            return LIMIT_VISIT_TIME;
        }
        return requested;
    }

    /** 单次查询上限（拜访标记）。 */
    public static long resolveLimitVisitFlag(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_FLAG;
        }
        if (requested > LIMIT_VISIT_FLAG) {
            return LIMIT_VISIT_FLAG;
        }
        return requested;
    }

    /** 单次查询上限（拜访说明）。 */
    public static long resolveLimitVisitRemark(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_REMARK;
        }
        if (requested > LIMIT_VISIT_REMARK) {
            return LIMIT_VISIT_REMARK;
        }
        return requested;
    }

    /** 单次查询上限（拜访来源）。 */
    public static long resolveLimitVisitSource(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_SOURCE;
        }
        if (requested > LIMIT_VISIT_SOURCE) {
            return LIMIT_VISIT_SOURCE;
        }
        return requested;
    }

    /** 单次查询上限（拜访版本）。 */
    public static long resolveLimitVisitVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_VERSION;
        }
        if (requested > LIMIT_VISIT_VERSION) {
            return LIMIT_VISIT_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（拜访区域）。 */
    public static long resolveLimitVisitRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_REGION;
        }
        if (requested > LIMIT_VISIT_REGION) {
            return LIMIT_VISIT_REGION;
        }
        return requested;
    }

    /** 单次查询上限（拜访渠道）。 */
    public static long resolveLimitVisitChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_CHANNEL;
        }
        if (requested > LIMIT_VISIT_CHANNEL) {
            return LIMIT_VISIT_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（拜访分组）。 */
    public static long resolveLimitVisitGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_GROUP;
        }
        if (requested > LIMIT_VISIT_GROUP) {
            return LIMIT_VISIT_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（拜访标签）。 */
    public static long resolveLimitVisitTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_TAG;
        }
        if (requested > LIMIT_VISIT_TAG) {
            return LIMIT_VISIT_TAG;
        }
        return requested;
    }

    /** 单次查询上限（拜访负责人）。 */
    public static long resolveLimitVisitOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_OWNER;
        }
        if (requested > LIMIT_VISIT_OWNER) {
            return LIMIT_VISIT_OWNER;
        }
        return requested;
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

}

package cn.song.custmetadata.config;

/**
 * 客户证件ModuleConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustCertModuleConfig {

    public static final String MODULE_CODE = "CUST_CERT";

    /** 单次查询上限（经理版本） */
    public static final long LIMIT_MANAGER_VERSION = 5L;

    /** 单次查询上限（经理区域） */
    public static final long LIMIT_MANAGER_REGION = 10L;

    /** 单次查询上限（经理渠道） */
    public static final long LIMIT_MANAGER_CHANNEL = 15L;

    /** 单次查询上限（经理分组） */
    public static final long LIMIT_MANAGER_GROUP = 20L;

    /** 单次查询上限（经理标签） */
    public static final long LIMIT_MANAGER_TAG = 25L;

    /** 单次查询上限（经理负责人） */
    public static final long LIMIT_MANAGER_OWNER = 30L;

    /** 单次查询上限（拜访编号） */
    public static final long LIMIT_VISIT_NO = 35L;

    /** 单次查询上限（拜访名称） */
    public static final long LIMIT_VISIT_NAME = 40L;

    /** 单次查询上限（拜访类型） */
    public static final long LIMIT_VISIT_TYPE = 45L;

    /** 单次查询上限（拜访编码） */
    public static final long LIMIT_VISIT_CODE = 50L;

    /** 单次查询上限（拜访级别） */
    public static final long LIMIT_VISIT_LEVEL = 55L;

    /** 单次查询上限（拜访状态） */
    public static final long LIMIT_VISIT_STATUS = 60L;

    /** 单次查询上限（拜访金额） */
    public static final long LIMIT_VISIT_AMOUNT = 65L;

    /** 单次查询上限（拜访数量） */
    public static final long LIMIT_VISIT_COUNT = 70L;

    /** 单次查询上限（拜访比率） */
    public static final long LIMIT_VISIT_RATE = 75L;

    /** 单次查询上限（拜访日期） */
    public static final long LIMIT_VISIT_DATE = 80L;

    /** 单次查询上限（拜访时间） */
    public static final long LIMIT_VISIT_TIME = 85L;

    /** 单次查询上限（拜访标记） */
    public static final long LIMIT_VISIT_FLAG = 90L;

    /** 单次查询上限（拜访说明） */
    public static final long LIMIT_VISIT_REMARK = 95L;

    /** 单次查询上限（拜访来源） */
    public static final long LIMIT_VISIT_SOURCE = 100L;

    /** 单次查询上限（拜访版本） */
    public static final long LIMIT_VISIT_VERSION = 105L;

    /** 单次查询上限（拜访区域） */
    public static final long LIMIT_VISIT_REGION = 110L;

    /** 单次查询上限（拜访渠道） */
    public static final long LIMIT_VISIT_CHANNEL = 115L;

    /** 单次查询上限（拜访分组） */
    public static final long LIMIT_VISIT_GROUP = 120L;

    /** 单次查询上限（拜访标签） */
    public static final long LIMIT_VISIT_TAG = 125L;

    /** 单次查询上限（拜访负责人） */
    public static final long LIMIT_VISIT_OWNER = 130L;

    /** 单次查询上限（合同编号） */
    public static final long LIMIT_CONTRACT_NO = 135L;

    /** 单次查询上限（合同名称） */
    public static final long LIMIT_CONTRACT_NAME = 140L;

    /** 单次查询上限（合同类型） */
    public static final long LIMIT_CONTRACT_TYPE = 145L;

    /** 单次查询上限（合同编码） */
    public static final long LIMIT_CONTRACT_CODE = 150L;

    /** 单次查询上限（合同级别） */
    public static final long LIMIT_CONTRACT_LEVEL = 155L;

    /** 单次查询上限（合同状态） */
    public static final long LIMIT_CONTRACT_STATUS = 160L;

    /** 单次查询上限（合同金额） */
    public static final long LIMIT_CONTRACT_AMOUNT = 165L;

    /** 单次查询上限（合同数量） */
    public static final long LIMIT_CONTRACT_COUNT = 170L;

    /** 单次查询上限（合同比率） */
    public static final long LIMIT_CONTRACT_RATE = 175L;

    /** 单次查询上限（合同日期） */
    public static final long LIMIT_CONTRACT_DATE = 180L;

    /** 单次查询上限（合同时间） */
    public static final long LIMIT_CONTRACT_TIME = 185L;

    /** 单次查询上限（合同标记） */
    public static final long LIMIT_CONTRACT_FLAG = 190L;

    /** 单次查询上限（合同说明） */
    public static final long LIMIT_CONTRACT_REMARK = 195L;

    /** 单次查询上限（合同来源） */
    public static final long LIMIT_CONTRACT_SOURCE = 200L;

    /** 单次查询上限（合同版本） */
    public static final long LIMIT_CONTRACT_VERSION = 205L;

    /** 单次查询上限（合同区域） */
    public static final long LIMIT_CONTRACT_REGION = 210L;

    /** 单次查询上限（合同渠道） */
    public static final long LIMIT_CONTRACT_CHANNEL = 215L;

    /** 单次查询上限（合同分组） */
    public static final long LIMIT_CONTRACT_GROUP = 220L;

    /** 单次查询上限（合同标签） */
    public static final long LIMIT_CONTRACT_TAG = 225L;

    /** 单次查询上限（合同负责人） */
    public static final long LIMIT_CONTRACT_OWNER = 230L;

    /** 单次查询上限（订单编号） */
    public static final long LIMIT_ORDER_NO = 235L;

    /** 单次查询上限（订单名称） */
    public static final long LIMIT_ORDER_NAME = 240L;

    /** 单次查询上限（订单类型） */
    public static final long LIMIT_ORDER_TYPE = 245L;

    /** 单次查询上限（订单编码） */
    public static final long LIMIT_ORDER_CODE = 250L;

    /** 单次查询上限（订单级别） */
    public static final long LIMIT_ORDER_LEVEL = 255L;

    /** 单次查询上限（订单状态） */
    public static final long LIMIT_ORDER_STATUS = 260L;

    /** 单次查询上限（订单金额） */
    public static final long LIMIT_ORDER_AMOUNT = 265L;

    /** 单次查询上限（订单数量） */
    public static final long LIMIT_ORDER_COUNT = 270L;

    /** 单次查询上限（订单比率） */
    public static final long LIMIT_ORDER_RATE = 275L;

    /** 单次查询上限（订单日期） */
    public static final long LIMIT_ORDER_DATE = 280L;

    /** 单次查询上限（订单时间） */
    public static final long LIMIT_ORDER_TIME = 285L;

    /** 单次查询上限（订单标记） */
    public static final long LIMIT_ORDER_FLAG = 290L;

    /** 单次查询上限（订单说明） */
    public static final long LIMIT_ORDER_REMARK = 295L;

    /** 单次查询上限（订单来源） */
    public static final long LIMIT_ORDER_SOURCE = 300L;

    private CustCertModuleConfig() {
    }

    /** 单次查询上限（经理版本）。 */
    public static long resolveLimitManagerVersion(long requested) {
        if (requested <= 0L) {
            return LIMIT_MANAGER_VERSION;
        }
        if (requested > LIMIT_MANAGER_VERSION) {
            return LIMIT_MANAGER_VERSION;
        }
        return requested;
    }

    /** 单次查询上限（经理区域）。 */
    public static long resolveLimitManagerRegion(long requested) {
        if (requested <= 0L) {
            return LIMIT_MANAGER_REGION;
        }
        if (requested > LIMIT_MANAGER_REGION) {
            return LIMIT_MANAGER_REGION;
        }
        return requested;
    }

    /** 单次查询上限（经理渠道）。 */
    public static long resolveLimitManagerChannel(long requested) {
        if (requested <= 0L) {
            return LIMIT_MANAGER_CHANNEL;
        }
        if (requested > LIMIT_MANAGER_CHANNEL) {
            return LIMIT_MANAGER_CHANNEL;
        }
        return requested;
    }

    /** 单次查询上限（经理分组）。 */
    public static long resolveLimitManagerGroup(long requested) {
        if (requested <= 0L) {
            return LIMIT_MANAGER_GROUP;
        }
        if (requested > LIMIT_MANAGER_GROUP) {
            return LIMIT_MANAGER_GROUP;
        }
        return requested;
    }

    /** 单次查询上限（经理标签）。 */
    public static long resolveLimitManagerTag(long requested) {
        if (requested <= 0L) {
            return LIMIT_MANAGER_TAG;
        }
        if (requested > LIMIT_MANAGER_TAG) {
            return LIMIT_MANAGER_TAG;
        }
        return requested;
    }

    /** 单次查询上限（经理负责人）。 */
    public static long resolveLimitManagerOwner(long requested) {
        if (requested <= 0L) {
            return LIMIT_MANAGER_OWNER;
        }
        if (requested > LIMIT_MANAGER_OWNER) {
            return LIMIT_MANAGER_OWNER;
        }
        return requested;
    }

    /** 单次查询上限（拜访编号）。 */
    public static long resolveLimitVisitNo(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_NO;
        }
        if (requested > LIMIT_VISIT_NO) {
            return LIMIT_VISIT_NO;
        }
        return requested;
    }

    /** 单次查询上限（拜访名称）。 */
    public static long resolveLimitVisitName(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_NAME;
        }
        if (requested > LIMIT_VISIT_NAME) {
            return LIMIT_VISIT_NAME;
        }
        return requested;
    }

    /** 单次查询上限（拜访类型）。 */
    public static long resolveLimitVisitType(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_TYPE;
        }
        if (requested > LIMIT_VISIT_TYPE) {
            return LIMIT_VISIT_TYPE;
        }
        return requested;
    }

    /** 单次查询上限（拜访编码）。 */
    public static long resolveLimitVisitCode(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_CODE;
        }
        if (requested > LIMIT_VISIT_CODE) {
            return LIMIT_VISIT_CODE;
        }
        return requested;
    }

    /** 单次查询上限（拜访级别）。 */
    public static long resolveLimitVisitLevel(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_LEVEL;
        }
        if (requested > LIMIT_VISIT_LEVEL) {
            return LIMIT_VISIT_LEVEL;
        }
        return requested;
    }

    /** 单次查询上限（拜访状态）。 */
    public static long resolveLimitVisitStatus(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_STATUS;
        }
        if (requested > LIMIT_VISIT_STATUS) {
            return LIMIT_VISIT_STATUS;
        }
        return requested;
    }

    /** 单次查询上限（拜访金额）。 */
    public static long resolveLimitVisitAmount(long requested) {
        if (requested <= 0L) {
            return LIMIT_VISIT_AMOUNT;
        }
        if (requested > LIMIT_VISIT_AMOUNT) {
            return LIMIT_VISIT_AMOUNT;
        }
        return requested;
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

}

package cn.song.custmetadata.config;

/**
 * 客户付款JobConfig 模块参数。
 *
 * <p>常量集中在此，避免各 Service 里散落魔法值。
 */
public final class CustPaymentJobConfig {

    public static final String MODULE_CODE = "CUST_PAYMENT_JOB_CONFIG";

    /** 批处理条数（经理金额） */
    public static final long BATCH_MANAGER_AMOUNT = 5L;

    /** 批处理条数（经理数量） */
    public static final long BATCH_MANAGER_COUNT = 10L;

    /** 批处理条数（经理比率） */
    public static final long BATCH_MANAGER_RATE = 15L;

    /** 批处理条数（经理日期） */
    public static final long BATCH_MANAGER_DATE = 20L;

    /** 批处理条数（经理时间） */
    public static final long BATCH_MANAGER_TIME = 25L;

    /** 批处理条数（经理标记） */
    public static final long BATCH_MANAGER_FLAG = 30L;

    /** 批处理条数（经理说明） */
    public static final long BATCH_MANAGER_REMARK = 35L;

    /** 批处理条数（经理来源） */
    public static final long BATCH_MANAGER_SOURCE = 40L;

    /** 批处理条数（经理版本） */
    public static final long BATCH_MANAGER_VERSION = 45L;

    /** 批处理条数（经理区域） */
    public static final long BATCH_MANAGER_REGION = 50L;

    /** 批处理条数（经理渠道） */
    public static final long BATCH_MANAGER_CHANNEL = 55L;

    /** 批处理条数（经理分组） */
    public static final long BATCH_MANAGER_GROUP = 60L;

    /** 批处理条数（经理标签） */
    public static final long BATCH_MANAGER_TAG = 65L;

    /** 批处理条数（经理负责人） */
    public static final long BATCH_MANAGER_OWNER = 70L;

    /** 批处理条数（拜访编号） */
    public static final long BATCH_VISIT_NO = 75L;

    /** 批处理条数（拜访名称） */
    public static final long BATCH_VISIT_NAME = 80L;

    /** 批处理条数（拜访类型） */
    public static final long BATCH_VISIT_TYPE = 85L;

    /** 批处理条数（拜访编码） */
    public static final long BATCH_VISIT_CODE = 90L;

    /** 批处理条数（拜访级别） */
    public static final long BATCH_VISIT_LEVEL = 95L;

    /** 批处理条数（拜访状态） */
    public static final long BATCH_VISIT_STATUS = 100L;

    /** 批处理条数（拜访金额） */
    public static final long BATCH_VISIT_AMOUNT = 105L;

    /** 批处理条数（拜访数量） */
    public static final long BATCH_VISIT_COUNT = 110L;

    /** 批处理条数（拜访比率） */
    public static final long BATCH_VISIT_RATE = 115L;

    /** 批处理条数（拜访日期） */
    public static final long BATCH_VISIT_DATE = 120L;

    /** 批处理条数（拜访时间） */
    public static final long BATCH_VISIT_TIME = 125L;

    /** 批处理条数（拜访标记） */
    public static final long BATCH_VISIT_FLAG = 130L;

    /** 批处理条数（拜访说明） */
    public static final long BATCH_VISIT_REMARK = 135L;

    /** 批处理条数（拜访来源） */
    public static final long BATCH_VISIT_SOURCE = 140L;

    /** 批处理条数（拜访版本） */
    public static final long BATCH_VISIT_VERSION = 145L;

    /** 批处理条数（拜访区域） */
    public static final long BATCH_VISIT_REGION = 150L;

    /** 批处理条数（拜访渠道） */
    public static final long BATCH_VISIT_CHANNEL = 155L;

    /** 批处理条数（拜访分组） */
    public static final long BATCH_VISIT_GROUP = 160L;

    /** 批处理条数（拜访标签） */
    public static final long BATCH_VISIT_TAG = 165L;

    /** 批处理条数（拜访负责人） */
    public static final long BATCH_VISIT_OWNER = 170L;

    /** 批处理条数（合同编号） */
    public static final long BATCH_CONTRACT_NO = 175L;

    /** 批处理条数（合同名称） */
    public static final long BATCH_CONTRACT_NAME = 180L;

    /** 批处理条数（合同类型） */
    public static final long BATCH_CONTRACT_TYPE = 185L;

    /** 批处理条数（合同编码） */
    public static final long BATCH_CONTRACT_CODE = 190L;

    /** 批处理条数（合同级别） */
    public static final long BATCH_CONTRACT_LEVEL = 195L;

    /** 批处理条数（合同状态） */
    public static final long BATCH_CONTRACT_STATUS = 200L;

    /** 批处理条数（合同金额） */
    public static final long BATCH_CONTRACT_AMOUNT = 205L;

    /** 批处理条数（合同数量） */
    public static final long BATCH_CONTRACT_COUNT = 210L;

    /** 批处理条数（合同比率） */
    public static final long BATCH_CONTRACT_RATE = 215L;

    /** 批处理条数（合同日期） */
    public static final long BATCH_CONTRACT_DATE = 220L;

    /** 批处理条数（合同时间） */
    public static final long BATCH_CONTRACT_TIME = 225L;

    /** 批处理条数（合同标记） */
    public static final long BATCH_CONTRACT_FLAG = 230L;

    /** 批处理条数（合同说明） */
    public static final long BATCH_CONTRACT_REMARK = 235L;

    /** 批处理条数（合同来源） */
    public static final long BATCH_CONTRACT_SOURCE = 240L;

    /** 批处理条数（合同版本） */
    public static final long BATCH_CONTRACT_VERSION = 245L;

    /** 批处理条数（合同区域） */
    public static final long BATCH_CONTRACT_REGION = 250L;

    /** 批处理条数（合同渠道） */
    public static final long BATCH_CONTRACT_CHANNEL = 255L;

    /** 批处理条数（合同分组） */
    public static final long BATCH_CONTRACT_GROUP = 260L;

    /** 批处理条数（合同标签） */
    public static final long BATCH_CONTRACT_TAG = 265L;

    /** 批处理条数（合同负责人） */
    public static final long BATCH_CONTRACT_OWNER = 270L;

    /** 批处理条数（订单编号） */
    public static final long BATCH_ORDER_NO = 275L;

    /** 批处理条数（订单名称） */
    public static final long BATCH_ORDER_NAME = 280L;

    /** 批处理条数（订单类型） */
    public static final long BATCH_ORDER_TYPE = 285L;

    /** 批处理条数（订单编码） */
    public static final long BATCH_ORDER_CODE = 290L;

    /** 批处理条数（订单级别） */
    public static final long BATCH_ORDER_LEVEL = 295L;

    /** 批处理条数（订单状态） */
    public static final long BATCH_ORDER_STATUS = 300L;

    private CustPaymentJobConfig() {
    }

    /** 批处理条数（经理金额）。 */
    public static long resolveBatchManagerAmount(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_AMOUNT;
        }
        if (requested > BATCH_MANAGER_AMOUNT) {
            return BATCH_MANAGER_AMOUNT;
        }
        return requested;
    }

    /** 批处理条数（经理数量）。 */
    public static long resolveBatchManagerCount(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_COUNT;
        }
        if (requested > BATCH_MANAGER_COUNT) {
            return BATCH_MANAGER_COUNT;
        }
        return requested;
    }

    /** 批处理条数（经理比率）。 */
    public static long resolveBatchManagerRate(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_RATE;
        }
        if (requested > BATCH_MANAGER_RATE) {
            return BATCH_MANAGER_RATE;
        }
        return requested;
    }

    /** 批处理条数（经理日期）。 */
    public static long resolveBatchManagerDate(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_DATE;
        }
        if (requested > BATCH_MANAGER_DATE) {
            return BATCH_MANAGER_DATE;
        }
        return requested;
    }

    /** 批处理条数（经理时间）。 */
    public static long resolveBatchManagerTime(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_TIME;
        }
        if (requested > BATCH_MANAGER_TIME) {
            return BATCH_MANAGER_TIME;
        }
        return requested;
    }

    /** 批处理条数（经理标记）。 */
    public static long resolveBatchManagerFlag(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_FLAG;
        }
        if (requested > BATCH_MANAGER_FLAG) {
            return BATCH_MANAGER_FLAG;
        }
        return requested;
    }

    /** 批处理条数（经理说明）。 */
    public static long resolveBatchManagerRemark(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_REMARK;
        }
        if (requested > BATCH_MANAGER_REMARK) {
            return BATCH_MANAGER_REMARK;
        }
        return requested;
    }

    /** 批处理条数（经理来源）。 */
    public static long resolveBatchManagerSource(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_SOURCE;
        }
        if (requested > BATCH_MANAGER_SOURCE) {
            return BATCH_MANAGER_SOURCE;
        }
        return requested;
    }

    /** 批处理条数（经理版本）。 */
    public static long resolveBatchManagerVersion(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_VERSION;
        }
        if (requested > BATCH_MANAGER_VERSION) {
            return BATCH_MANAGER_VERSION;
        }
        return requested;
    }

    /** 批处理条数（经理区域）。 */
    public static long resolveBatchManagerRegion(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_REGION;
        }
        if (requested > BATCH_MANAGER_REGION) {
            return BATCH_MANAGER_REGION;
        }
        return requested;
    }

    /** 批处理条数（经理渠道）。 */
    public static long resolveBatchManagerChannel(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_CHANNEL;
        }
        if (requested > BATCH_MANAGER_CHANNEL) {
            return BATCH_MANAGER_CHANNEL;
        }
        return requested;
    }

    /** 批处理条数（经理分组）。 */
    public static long resolveBatchManagerGroup(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_GROUP;
        }
        if (requested > BATCH_MANAGER_GROUP) {
            return BATCH_MANAGER_GROUP;
        }
        return requested;
    }

    /** 批处理条数（经理标签）。 */
    public static long resolveBatchManagerTag(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_TAG;
        }
        if (requested > BATCH_MANAGER_TAG) {
            return BATCH_MANAGER_TAG;
        }
        return requested;
    }

    /** 批处理条数（经理负责人）。 */
    public static long resolveBatchManagerOwner(long requested) {
        if (requested <= 0L) {
            return BATCH_MANAGER_OWNER;
        }
        if (requested > BATCH_MANAGER_OWNER) {
            return BATCH_MANAGER_OWNER;
        }
        return requested;
    }

    /** 批处理条数（拜访编号）。 */
    public static long resolveBatchVisitNo(long requested) {
        if (requested <= 0L) {
            return BATCH_VISIT_NO;
        }
        if (requested > BATCH_VISIT_NO) {
            return BATCH_VISIT_NO;
        }
        return requested;
    }

    /** 批处理条数（拜访名称）。 */
    public static long resolveBatchVisitName(long requested) {
        if (requested <= 0L) {
            return BATCH_VISIT_NAME;
        }
        if (requested > BATCH_VISIT_NAME) {
            return BATCH_VISIT_NAME;
        }
        return requested;
    }

    /** 批处理条数（拜访类型）。 */
    public static long resolveBatchVisitType(long requested) {
        if (requested <= 0L) {
            return BATCH_VISIT_TYPE;
        }
        if (requested > BATCH_VISIT_TYPE) {
            return BATCH_VISIT_TYPE;
        }
        return requested;
    }

    /** 批处理条数（拜访编码）。 */
    public static long resolveBatchVisitCode(long requested) {
        if (requested <= 0L) {
            return BATCH_VISIT_CODE;
        }
        if (requested > BATCH_VISIT_CODE) {
            return BATCH_VISIT_CODE;
        }
        return requested;
    }

    /** 批处理条数（拜访级别）。 */
    public static long resolveBatchVisitLevel(long requested) {
        if (requested <= 0L) {
            return BATCH_VISIT_LEVEL;
        }
        if (requested > BATCH_VISIT_LEVEL) {
            return BATCH_VISIT_LEVEL;
        }
        return requested;
    }

    /** 批处理条数（拜访状态）。 */
    public static long resolveBatchVisitStatus(long requested) {
        if (requested <= 0L) {
            return BATCH_VISIT_STATUS;
        }
        if (requested > BATCH_VISIT_STATUS) {
            return BATCH_VISIT_STATUS;
        }
        return requested;
    }

}

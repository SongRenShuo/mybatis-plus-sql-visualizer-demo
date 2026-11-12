package cn.song.custcommon.constant;

/**
 * 跨服务共享常量。
 */
public final class CommonConstants {

    public static final String DEFAULT_TENANT = "000000";

    public static final String DEL_FLAG_NORMAL = "0";

    public static final String DEL_FLAG_DELETED = "1";

    public static final String STATUS_ENABLED = "1";

    public static final String STATUS_DISABLED = "0";

    public static final int PAGE_SIZE_DEFAULT = 20;

    public static final int PAGE_SIZE_MAX = 500;

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String TRACE_HEADER = "X-Trace-Id";

    private CommonConstants() {
    }
}

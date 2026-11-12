package cn.song.custcommon.constant;

/**
 * 错误码。
 */
public final class ErrorCode {

    public static final int SUCCESS = 0;

    public static final int PARAM_INVALID = 40001;

    public static final int UNAUTHORIZED = 40101;

    public static final int FORBIDDEN = 40301;

    public static final int NOT_FOUND = 40401;

    public static final int CONFLICT = 40901;

    public static final int SYSTEM_ERROR = 50001;

    private ErrorCode() {
    }

    public static String messageOf(int code) {
        switch (code) {
            case SUCCESS:
                return "成功";
            case PARAM_INVALID:
                return "参数不合法";
            case UNAUTHORIZED:
                return "未认证";
            case FORBIDDEN:
                return "无权限";
            case NOT_FOUND:
                return "资源不存在";
            case CONFLICT:
                return "资源冲突";
            default:
                return "系统异常";
        }
    }
}

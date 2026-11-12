package cn.song.custcommon.exception;

/**
 * 系统级异常。
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}

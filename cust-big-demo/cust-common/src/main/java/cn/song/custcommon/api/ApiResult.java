package cn.song.custcommon.api;

import java.io.Serializable;

/**
 * 统一响应体。
 */
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int CODE_OK = 0;

    public static final int CODE_FAIL = 500;

    private int code;

    private String message;

    private T data;

    public ApiResult() {
    }

    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResult<T> ok(T data) {
        return new ApiResult<T>(CODE_OK, "OK", data);
    }

    public static <T> ApiResult<T> fail(int code, String message) {
        return new ApiResult<T>(code, message, null);
    }

    public boolean isSuccess() {
        return code == CODE_OK;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

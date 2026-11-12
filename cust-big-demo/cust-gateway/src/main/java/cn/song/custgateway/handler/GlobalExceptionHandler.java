package cn.song.custgateway.handler;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcommon.constant.ErrorCode;

/**
 * 全局异常处理。
 */
public class GlobalExceptionHandler {

    public ApiResult<String> handle(Throwable error) {
        if (error == null) {
            return ApiResult.fail(ErrorCode.SYSTEM_ERROR, "unknown error");
        }
        return ApiResult.fail(ErrorCode.SYSTEM_ERROR, error.getMessage());
    }
}

package cn.song.custgateway.handler;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcommon.constant.ErrorCode;

/**
 * 降级处理器。
 */
public class FallbackHandler {

    public ApiResult<String> fallback(String routeId) {
        return ApiResult.fail(ErrorCode.SYSTEM_ERROR, "route " + routeId + " is unavailable");
    }
}

package com.ysy.app.base.feign;

import com.ysy.app.base.common.contants.ResponseCodeEnum;
import com.ysy.app.base.http.ResponseResult;


public class BaseFeignFallBack {

    protected ResponseResult failedFeign(String serverName) {
        String message = String.format(ResponseCodeEnum.FAIL.getCode(), serverName);
        return new ResponseResult(ResponseCodeEnum.FAIL.getCode(), message);
    }
}

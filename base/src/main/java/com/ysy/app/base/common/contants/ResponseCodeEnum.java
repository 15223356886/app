package com.ysy.app.base.common.contants;

/**
 * @Copyright: Copyright (c) 2018
 * @Company: 云手艺
 * @Version: V2018.10.0.0.1
 * @PackageName: com.ysy.app.base.common.contants
 * @ProjectName: app
 * @Auther: 赵家豪
 * @Date: 2018/10/16 0016 15:15
 * @Description:
 */
public enum ResponseCodeEnum {

    SUCCESS("00", "SUCCESS"),
    FAIL("500", "失败"),
    ERROR("800", "系统异常");

    private String code;
    private String msg;

    ResponseCodeEnum(String code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

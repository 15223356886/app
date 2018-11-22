package com.ysy.app.appserver.controller;

import com.ysy.app.appserver.feign.BasicFeign;
import com.ysy.app.base.http.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2018
 * @Company: 云手艺
 * @Version: V2018.10.0.0.1
 * @PackageName: com.ysy.app.appserver.controller
 * @ProjectName: app
 * @Auther: 赵家豪
 * @Date: 2018/10/17 0017 16:21
 * @Description:
 */
@RequestMapping("/app")
@RestController
public class AppServerController {

    @Autowired
    private BasicFeign basicFeign;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult login(@RequestBody Map<String, Object> req) {
        //ResponseResult responseResult = basicFeign.basicFeign("user/login", req);
        ResponseResult responseResult=new ResponseResult();
        System.out.println(req.toString());
        return responseResult;
    }

    /**
     * 秘钥注册
     * @param req
     * @return
     */
    @RequestMapping(value = "/secretKeyRegisterService", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult secretKeyRegisterService(@RequestBody Map<String, Object> req) {
        ResponseResult responseResult=new ResponseResult();
        return responseResult;
    }
}

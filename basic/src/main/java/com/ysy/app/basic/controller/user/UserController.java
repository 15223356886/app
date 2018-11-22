package com.ysy.app.basic.controller.user;

import com.ysy.app.base.http.ResponseResult;
import com.ysy.app.basic.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Copyright: Copyright (c) 2018
 * @Company: 云手艺
 * @Version: V2018.10.0.0.1
 * @PackageName: com.ysy.app.basic.controller.user
 * @ProjectName: app
 * @Auther: 赵家豪
 * @Date: 2018/10/19 0019 10:04
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult login(@RequestBody Map<String, Object> req) {
        return userService.login(req);
    }

}

package com.ysy.app.db.controller.user;

import com.ysy.app.base.common.contants.ResponseCodeEnum;
import com.ysy.app.base.http.ResponseResult;
import com.ysy.app.db.controller.DataDicController;
import com.ysy.app.db.dao.user.TblUserInfoMapper;
import com.ysy.app.db.po.user.TblUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2018
 * @Company: 云手艺
 * @Version: V2018.10.0.0.1
 * @PackageName: com.ysy.app.db.controller.user
 * @ProjectName: app
 * @Auther: 赵家豪
 * @Date: 2018/10/18 0018 10:14
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private TblUserInfoMapper tblUserInfoMapper;

    @RequestMapping(value = "/selectUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult selectUser(@RequestBody Map<String,Object> req){
        try {
            List<TblUserInfo> tblUserInfoList=tblUserInfoMapper.selectUser(req);
            return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(),tblUserInfoList);
        } catch (Exception e) {
            logger.error("web exception, exec test is failed, [/dataDic/deleteByPrimaryKey]", e);
            return new ResponseResult(ResponseCodeEnum.FAIL.getCode(), e.getMessage());
        }
    }
}

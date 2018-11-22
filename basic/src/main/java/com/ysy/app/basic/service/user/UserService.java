package com.ysy.app.basic.service.user;

import com.alibaba.fastjson.JSON;
import com.ysy.app.base.common.contants.ResponseCodeEnum;
import com.ysy.app.base.exception.BusinessException;
import com.ysy.app.base.http.ResponseResult;
import com.ysy.app.basic.feign.DbFeign;
import com.ysy.app.entity.vo.user.TblUserInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.US_ASCII;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2018
 * @Company: 云手艺
 * @Version: V2018.10.0.0.1
 * @PackageName: com.ysy.app.basic.service.user
 * @ProjectName: app
 * @Auther: 赵家豪
 * @Date: 2018/10/18 0018 10:28
 * @Description:
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    private DbFeign dbFeign;

    public ResponseResult login(Map<String, Object> req) {
        long startTime = System.currentTimeMillis();
        logger.info("------------- basic系统处理登录逻辑  start-------------");
        ResponseResult responseResult = new ResponseResult();
        try {
            //登录请求参数验证
            logger.info("basic受理登录逻辑请求处理:[ 登录请求参数验证 开始 ]");
            if (req == null) {
                throw new BusinessException("请求对象为空");
            }
            if (req.get("loginName") == null) {
                throw new BusinessException("用户账号/手机号为空");
            }
            if (req.get("passwordType") == null) {
                throw new BusinessException("密码类型[passwordType]为空");
            }
            if (req.get("xLocaltion") == null) {
                throw new BusinessException("经度[xLocaltion]为空");
            }
            if (req.get("yLocaltion") == null) {
                throw new BusinessException("纬度[yLocaltion]为空");
            }
            if (req.get("loginIp") == null) {
                throw new BusinessException("登录IP[loginIp]为空");
            }
            if (req.get("loginCity") == null) {
                throw new BusinessException("登录城市[loginCity]为空");
            }
            if ("01".equals(req.get("passwordType"))) {
                if (req.get("userPwd") == null) {
                    throw new BusinessException("登录密码[userPwd]为空");
                }
            } else if ("02".equals(req.get("passwordType"))) {
                if (req.get("gesturePwd") == null) {
                    throw new BusinessException("手势密码[gesturePwd]为空");
                }
            }
            logger.info("basic受理登录逻辑请求处理:[ 登录请求参数验证 结束 ]");
            //检查用户是否存在
            logger.info("basic受理登录逻辑请求处理:[ 检查用户是否存在 开始 ]");
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("phone", req.get("loginName"));//根据手机号登录
            userMap.put("status", "00");//状态有效
            logger.info("basic受理登录逻辑请求处理:[ 检查是否根据手机号登录 ]");
            ResponseResult dbResultByPhone = dbFeign.dbFeign("user/selectUser", userMap);
            if (!dbResultByPhone.getCode().equals(ResponseCodeEnum.SUCCESS.getCode())) {
                //db层查询失败
                throw new BusinessException(dbResultByPhone.getMessage() + "数据库查询失败");
            }
            String resultByPhone = JSON.toJSONString(dbResultByPhone.getData());
            List<TblUserInfo> userInfos = JSON.parseObject(resultByPhone, List.class);
            if (userInfos == null || userInfos.size() == 0) {
                userMap = new HashMap<>();
                userMap.put("userCode", req.get("loginName"));//根据用户账户登录
                userMap.put("status", "00");//状态有效
                logger.info("basic受理登录逻辑请求处理:[ 检查是否根据用户账户登录 ]");
                ResponseResult dbResultByUserCode = dbFeign.dbFeign("user/selectUser", userMap);
                if (!dbResultByUserCode.getCode().equals(ResponseCodeEnum.SUCCESS.getCode())) {
                    //db层查询失败
                    throw new BusinessException(dbResultByUserCode.getMessage() + "数据库查询失败");
                }
                String resultByUserCode = JSON.toJSONString(dbResultByUserCode.getData());
                userInfos = JSON.parseObject(resultByUserCode, List.class);
                if (userInfos == null || userInfos.size() == 0) {
                    throw new BusinessException("用户尚未注册");
                }
            }
            //因为查询条件是手机号或登录账户  所以list内部只会存在一条数据  注册时过滤重复数据
            if (userInfos.size() != 1) {
                //查询出多条数据
                logger.error("basic受理登录逻辑请求处理:[ 系统异常同个手机号或者登录账户存在多条数据 ]");
                throw new BusinessException("系统异常，数据重复，请联系相关工作人员");
            }
            logger.info("basic受理登录逻辑请求处理:[ 检查用户是否存在 完成 ]");
            logger.info("basic受理登录逻辑请求处理:[ 检校验密码 开始 ]");
            TblUserInfo tblUserInfo = JSON.parseObject(JSON.toJSONString(userInfos.get(0)), TblUserInfo.class);
            if ("01".equals(req.get("passwordType"))) {
                //普通密码登录
                logger.info("basic受理登录逻辑请求处理:[ 普通密码登录 ]");
                if (!req.get("userPwd").equals(tblUserInfo.getUserPwd())) {
                    //登录密码错误
                    logger.error("basic受理登录逻辑请求处理:[ 登录密码错误 ]");
                    throw new BusinessException("登录密码输入有误，请检查后输入");
                }

            } else if ("02".equals(req.get("passwordType"))) {
                //手势密码登录
                logger.info("basic受理登录逻辑请求处理:[ 手势密码登录 ]");
                //判断能不能使用手势密码
                if ("01".equals(tblUserInfo.getIsGesture())) {
                    //未开通手势密码
                    logger.error("basic受理登录逻辑请求处理:[ 尚未开通手势密码 ]");
                    throw new BusinessException("尚未开通手势密码");
                }
                if (req.get("gesturePwd").equals(tblUserInfo.getGesturePwd())) {
                    //手势密码错误
                    logger.error("basic受理登录逻辑请求处理:[ 手势密码错误 ]");
                    throw new BusinessException("手势密码输入有误，请检查后输入");
                }
            } else if ("03".equals(req.get("passwordType"))) {
                //指纹密码登录
                if ("01".equals(tblUserInfo.getIsFinger())) {
                    //未开通指纹密码
                    logger.error("basic受理登录逻辑请求处理:[ 尚未开通指纹密码 ]");
                    throw new BusinessException("尚未开通指纹密码");
                }
            }
            logger.info("basic受理登录逻辑请求处理:[ 检校验密码 结束 ]");
            responseResult.setCode(ResponseCodeEnum.SUCCESS.getCode());
            responseResult.setMessage(ResponseCodeEnum.SUCCESS.getMsg());
            responseResult.setData(tblUserInfo);
            long endTime = System.currentTimeMillis();
            logger.info("------------- basic系统处理登录逻辑  end 耗时[" + (endTime - startTime) + "]ms-------------");
            return responseResult;
        } catch (BusinessException e) {
            responseResult.setCode(ResponseCodeEnum.FAIL.getCode());
            responseResult.setMessage(e.getMessage());
        } catch (Exception e) {
            responseResult.setCode(ResponseCodeEnum.ERROR.getCode());
            responseResult.setMessage(e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        logger.info("------------- basic系统处理登录逻辑  end 耗时[" + (endTime - startTime) + "]ms-------------");
        return responseResult;
    }
}

package com.ysy.app.basic.service;

import com.alibaba.fastjson.JSON;
import com.ysy.app.base.common.contants.ResponseCodeEnum;
import com.ysy.app.base.http.ResponseResult;
import com.ysy.app.basic.feign.DataDicFeign;
import com.ysy.app.entity.vo.dataDic.TblDataDicInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class DataDicService {
    private static final Logger logger = LoggerFactory.getLogger(DataDicService.class);
    @Autowired
    private DataDicFeign dataDicFeign;

    public ResponseResult<TblDataDicInfo> selectByPrimaryKey(String dataDicId) {
        ResponseResult<TblDataDicInfo> responseResult = dataDicFeign.selectByPrimaryKey(dataDicId);
        if (responseResult == null || !responseResult.getCode().equals(ResponseCodeEnum.SUCCESS.getCode())) {
            //数据库查询失败
            logger.error("selectByPrimaryKey is failed");
            return new ResponseResult(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getMsg());
        }
        TblDataDicInfo tblDataDicInfo=  responseResult.getData();
        return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(),ResponseCodeEnum.SUCCESS.getMsg(),tblDataDicInfo);
    }
}

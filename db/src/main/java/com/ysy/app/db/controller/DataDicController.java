package com.ysy.app.db.controller;

import com.ysy.app.base.common.contants.ResponseCodeEnum;
import com.ysy.app.base.http.ResponseResult;
import com.ysy.app.db.dao.TblDataDicInfoMapper;
import com.ysy.app.db.po.TblDataDicInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/dataDic")
@RestController
public class DataDicController {
    private static final Logger logger = LoggerFactory.getLogger(DataDicController.class);
    @Autowired
    private TblDataDicInfoMapper tblDataDicInfoMapper;

    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult deleteByPrimaryKey(@RequestParam("dataDicId") String dataDicId) {
        try {
            tblDataDicInfoMapper.deleteByPrimaryKey(dataDicId);
            return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("web exception, exec test is failed, [/dataDic/deleteByPrimaryKey]", e);
            return new ResponseResult(ResponseCodeEnum.FAIL.getCode(), e.getMessage());
        }
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult insert(@RequestBody TblDataDicInfo record) {
        try {
            tblDataDicInfoMapper.insert(record);
            return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("web exception, exec test is failed, [/dataDic/insert]", e);
            return new ResponseResult(ResponseCodeEnum.FAIL.getCode(), e.getMessage());
        }
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult insertSelective(@RequestBody TblDataDicInfo record) {
        try {
            tblDataDicInfoMapper.insertSelective(record);
            return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("web exception, exec test is failed, [/dataDic/insertSelective]", e);
            return new ResponseResult(ResponseCodeEnum.FAIL.getCode(), e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<TblDataDicInfo> selectByPrimaryKey(@RequestParam(value = "dataDicId",required = false) String dataDicId) {
        try {
            TblDataDicInfo tblDataDicInfo = tblDataDicInfoMapper.selectByPrimaryKey(dataDicId);
            return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), tblDataDicInfo);
        } catch (Exception e) {
            logger.error("web exception, exec test is failed, [/dataDic/selectByPrimaryKey]", e);
            return new ResponseResult(ResponseCodeEnum.FAIL.getCode(), e.getMessage());
        }
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult updateByPrimaryKeySelective(@RequestBody TblDataDicInfo record) {
        try {
            tblDataDicInfoMapper.updateByPrimaryKeySelective(record);
            return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("web exception, exec test is failed, [/dataDic/updateByPrimaryKeySelective]", e);
            return new ResponseResult(ResponseCodeEnum.FAIL.getCode(), e.getMessage());
        }
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult updateByPrimaryKey(@RequestBody TblDataDicInfo record) {
        try {
            tblDataDicInfoMapper.updateByPrimaryKey(record);
            return new ResponseResult(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("web exception, exec test is failed, [/dataDic/updateByPrimaryKey]", e);
            return new ResponseResult(ResponseCodeEnum.FAIL.getCode(), e.getMessage());
        }
    }
}

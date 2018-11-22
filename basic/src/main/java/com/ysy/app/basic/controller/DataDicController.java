package com.ysy.app.basic.controller;

import com.ysy.app.base.http.ResponseResult;
import com.ysy.app.basic.service.DataDicService;
import com.ysy.app.entity.vo.dataDic.TblDataDicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataDic")
public class DataDicController {

    @Autowired
    private DataDicService dataDicService;

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<TblDataDicInfo> selectByPrimaryKey(@RequestParam(value = "dataDicId",required = false) String dataDicId) {
        return dataDicService.selectByPrimaryKey(dataDicId);
    }
}

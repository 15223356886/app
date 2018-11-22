package com.ysy.app.basic.feign;

import com.ysy.app.base.feign.BaseFeignFallBack;
import com.ysy.app.base.feign.FeignClientsConfig;
import com.ysy.app.base.http.ResponseResult;
import com.ysy.app.entity.vo.dataDic.TblDataDicInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Copyright: Copyright (c) 2018
 * @Company: 云手艺
 * @Version: V2018.10.0.0.1
 * @PackageName: com.ysy.app.basic.feign
 * @ProjectName: app
 * @Auther: Administrator
 * @Date: 2018/10/16 0016 14:58
 * @Description:
 */
@FeignClient(value = "db", fallbackFactory = DataDicFeign.DataDicFeignFallBack.class, configuration = FeignClientsConfig.class)
public interface DataDicFeign {

    @RequestMapping(value = "/dataDic/deleteByPrimaryKey", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult deleteByPrimaryKey(@RequestParam("dataDicId") String dataDicId);

    @RequestMapping(value = "/dataDic/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult insert(@RequestBody TblDataDicInfo record);

    @RequestMapping(value = "/dataDic/insertSelective", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult insertSelective(@RequestBody TblDataDicInfo record);

    @RequestMapping(value = "/dataDic/selectByPrimaryKey", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult<TblDataDicInfo> selectByPrimaryKey(@RequestParam("dataDicId") String dataDicId);

    @RequestMapping(value = "/dataDic/updateByPrimaryKeySelective", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult updateByPrimaryKeySelective(@RequestBody TblDataDicInfo record);

    @RequestMapping(value = "/dataDic/updateByPrimaryKey", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult updateByPrimaryKey(@RequestBody TblDataDicInfo record);

    @Component
    class DataDicFeignFallBack extends BaseFeignFallBack implements DataDicFeign {
        private static final Logger logger = LoggerFactory.getLogger(DataDicFeignFallBack.class);

        private static final String SERVER_NAME = "db";

        @Override
        public ResponseResult deleteByPrimaryKey(String dataDicId) {
            logger.warn("warn: feign request is failed, serverName[{}].", SERVER_NAME);
            return failedFeign(SERVER_NAME);
        }

        @Override
        public ResponseResult insert(TblDataDicInfo record) {
            logger.warn("warn: feign request is failed, serverName[{}].", SERVER_NAME);
            return failedFeign(SERVER_NAME);
        }

        @Override
        public ResponseResult insertSelective(TblDataDicInfo record) {
            logger.warn("warn: feign request is failed, serverName[{}].", SERVER_NAME);
            return failedFeign(SERVER_NAME);
        }

        @Override
        public ResponseResult selectByPrimaryKey(String dataDicId) {
            logger.warn("warn: feign request is failed, serverName[{}].", SERVER_NAME);
            return failedFeign(SERVER_NAME);
        }

        @Override
        public ResponseResult updateByPrimaryKeySelective(TblDataDicInfo record) {
            logger.warn("warn: feign request is failed, serverName[{}].", SERVER_NAME);
            return failedFeign(SERVER_NAME);
        }

        @Override
        public ResponseResult updateByPrimaryKey(TblDataDicInfo record) {
            logger.warn("warn: feign request is failed, serverName[{}].", SERVER_NAME);
            return failedFeign(SERVER_NAME);
        }
    }
}

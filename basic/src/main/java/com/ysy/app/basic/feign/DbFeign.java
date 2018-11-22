package com.ysy.app.basic.feign;

import com.ysy.app.base.feign.BaseFeignFallBack;
import com.ysy.app.base.feign.FeignClientsConfig;
import com.ysy.app.base.http.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Copyright: Copyright (c) 2018
 * @Company: 云手艺
 * @Version: V2018.10.0.0.1
 * @PackageName: com.ysy.app.basic.feign
 * @ProjectName: app
 * @Auther: 赵家豪
 * @Date: 2018/10/18 0018 10:24
 * @Description:
 */
@FeignClient(value = "db", fallbackFactory = DbFeign.DbFeignFeignFallBack.class, configuration = FeignClientsConfig.class)
public interface DbFeign {

    @RequestMapping(value = "/{path}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseResult dbFeign(@PathVariable("path") String path, @RequestBody Map<String,Object> req);

    @Component
    class DbFeignFeignFallBack extends BaseFeignFallBack implements DbFeign {
        private static final Logger logger = LoggerFactory.getLogger(BaseFeignFallBack.class);

        private static final String SERVER_NAME = "db";

        @Override
        public ResponseResult dbFeign(String path, Map<String, Object> req) {
            logger.warn("warn: feign request is failed, serverName[{}].", SERVER_NAME);
            return failedFeign(SERVER_NAME);
        }
    }
}

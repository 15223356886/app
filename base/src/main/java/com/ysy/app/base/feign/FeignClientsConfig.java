package com.ysy.app.base.feign;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright: Copyright (c) 2018
 * @Company: 云手艺
 * @Version: V2018.10.0.0.1
 * @PackageName: com.ysy.app.base.feign
 * @ProjectName: app
 * @Auther: Administrator
 * @Date: 2018/10/16 0016 15:00
 * @Description:
 */
@Configuration
public class FeignClientsConfig {
    /**
     * feign 请求配置
     *
     * @return
     */
    @Bean
    Request.Options feignOptions() {
        return new Request.Options(30 * 1000, 30 * 1000);
    }
}

package com.ysy.app.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
        "com.ysy.app.basic.controller",
        "com.ysy.app.basic.service"
})
@EnableEurekaClient
@EnableFeignClients({
        "com.ysy.app.basic.feign"
})
@EnableCircuitBreaker
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }
}

package com.wangtao.sentinelexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangtao
 * Created at 2022/6/27 21:55
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelExampleApplication.class, args);
    }
}

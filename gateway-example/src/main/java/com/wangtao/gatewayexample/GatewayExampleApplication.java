package com.wangtao.gatewayexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangtao
 * Created at 2022/5/12 21:07
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayExampleApplication.class, args);
    }
}

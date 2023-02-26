package com.wangtao.seatabusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangtao
 * Created at 2023/2/26 00:33
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SeataBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataBusinessApplication.class, args);
    }
}

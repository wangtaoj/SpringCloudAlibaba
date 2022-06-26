package com.wangtao.feignexample;

import com.wangtao.feignexample.config.RibbonNacosProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangtao
 * Created at 2022/5/13 19:46
 */
@RibbonClients(
        value = {@RibbonClient(value = "nacos-producer", configuration = RibbonNacosProducerConfig.class)}
)
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignExampleApplication.class, args);
    }
}

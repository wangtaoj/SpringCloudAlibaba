package com.wangtao.ribbonexample;

import com.wangtao.ribbonexample.config.RibbonNacosProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author wangtao
 * Created at 2022/5/13 19:46
 */
@RibbonClients(
        value = {@RibbonClient(value = "nacos-producer", configuration = RibbonNacosProducerConfig.class)}
)
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonExampleApplication.class, args);
    }
}

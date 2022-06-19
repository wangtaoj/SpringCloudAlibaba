package com.wangtao.nacosconfig;

import com.wangtao.nacosconfig.config.UserProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangtao
 * Created at 2022/5/12 21:07
 */
@EnableConfigurationProperties(UserProperties.class)
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConigApplication.class, args);
    }
}

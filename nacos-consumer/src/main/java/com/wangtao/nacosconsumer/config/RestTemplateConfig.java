package com.wangtao.nacosconsumer.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author wangtao
 * Created at 2022/5/13 20:05
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 集成ribbon
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.of(30, SECONDS))
                .build();
    }
}

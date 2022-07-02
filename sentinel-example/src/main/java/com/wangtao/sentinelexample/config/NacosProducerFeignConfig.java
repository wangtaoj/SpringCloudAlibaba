package com.wangtao.sentinelexample.config;

import com.wangtao.sentinelexample.feign.UserService;
import com.wangtao.sentinelexample.feign.fallback.UserServiceFallback;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * 类上不加@Configuration注解, 是不想让该配置全局生效
 * @author wangtao
 * Created at 2022/6/24 21:09
 */
public class NacosProducerFeignConfig {

    /**
     * 配置feign的转换日志格式, 默认不打印
     * 注: 还需要打开logback的日志级别, feign接口是UserService
     * 所以将UserService的logback级别配成debug
     */
    @Bean
    public Logger.Level feginLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 配置超时时间
     */
    @Bean
    public Request.Options requestOption() {
        return new Request.Options(10, TimeUnit.SECONDS, 60, TimeUnit.SECONDS, true);
    }

    /**
     * 放到nacos-producer子容器中
     */
    @Bean
    public UserService userServiceFallback() {
        return new UserServiceFallback();
    }
}

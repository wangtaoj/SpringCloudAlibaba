package com.wangtao.seatabusiness;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author wangtao
 * Created at 2023/2/26 14:30
 */
@Configuration
public class GlobalFeignConfig {

    /**
     * 配置feign的转换日志格式, 默认不打印
     * 注: 还需要打开logback的日志级别, 将feign接口logback级别配成debug
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
}

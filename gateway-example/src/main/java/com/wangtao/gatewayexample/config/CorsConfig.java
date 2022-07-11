package com.wangtao.gatewayexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 全局跨域配置
 * @author wangtao
 * Created at 2022/7/9 17:38
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许的请求头
        corsConfiguration.addAllowedHeader("*");
        // 允许的请求源 （如：http://localhost:8080）
        corsConfiguration.addAllowedOrigin("*");
        // 允许的请求方法 ==> GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
        corsConfiguration.addAllowedMethod("*");
        // URL 映射 （如： /admin/**）
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(urlBasedCorsConfigurationSource);
    }
}

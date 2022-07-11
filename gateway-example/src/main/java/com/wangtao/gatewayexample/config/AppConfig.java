package com.wangtao.gatewayexample.config;

import com.wangtao.gatewayexample.predicate.PathPrefixRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangtao
 * Created at 2022/7/4 21:23
 */
@Configuration
public class AppConfig {

    @Bean
    public RoutePredicateFactory<PathPrefixRoutePredicateFactory.Config> pathPrefixRoutePredicateFactory() {
        return new PathPrefixRoutePredicateFactory();
    }
}

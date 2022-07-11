package com.wangtao.gatewayexample.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author wangtao
 * Created at 2022/7/4 21:19
 */
public class PathPrefixRoutePredicateFactory extends AbstractRoutePredicateFactory<PathPrefixRoutePredicateFactory.Config> {

    private static final String ARG_KEY = "prefix";

    public PathPrefixRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(ARG_KEY);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                URI uri = exchange.getRequest().getURI();
                return uri.getPath().startsWith(config.getPrefix());
            }
        };
    }

    @Validated
    public static class Config {

        private String prefix;

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }
    }
}

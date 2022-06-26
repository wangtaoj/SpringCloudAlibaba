package com.wangtao.ribbonexample.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangtao
 * Created at 2022/6/19 20:40
 */
@Configuration
public class RibbonGlobalConfig {

    /**
     * 随机策略
     */
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}

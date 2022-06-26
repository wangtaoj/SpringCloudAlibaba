package com.wangtao.ribbonexample.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @author wangtao
 * Created at 2022/6/26 12:09
 */
public class RibbonNacosProducerConfig {

    /**
     * 线性轮询策略
     */
    @Primary
    @Bean
    public IRule roundRobinRule() {
        return new RoundRobinRule();
    }
}

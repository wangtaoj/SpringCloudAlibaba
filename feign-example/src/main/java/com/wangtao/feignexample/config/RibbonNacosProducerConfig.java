package com.wangtao.feignexample.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author wangtao
 * Created at 2022/6/26 12:09
 */
public class RibbonNacosProducerConfig {

    /**
     * 线性轮询策略
     */
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}

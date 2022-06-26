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
     * Primary注解很重要，不然在创建ILoadBalancer会发生错误，依赖IRule实现，因为无法找到唯一的实现
     */
    @Primary
    @Bean
    public IRule roundRobinRule() {
        return new RoundRobinRule();
    }
}

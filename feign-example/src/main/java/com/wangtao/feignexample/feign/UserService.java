package com.wangtao.feignexample.feign;


import com.wangtao.feignexample.config.NacosProducerFeignConfig;
import com.wangtao.feignexample.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 其中value或name属性为服务名称
 * contextId为子容器的名字, 默认等于value
 * FeignClient注解的configuration属性指定的配置类都是在子容器创建的
 *
 * 会创建两个bean
 * 1. beanName=[contextId].FeignClientSpecification
 *    class=org.springframework.cloud.openfeign.FeignClientSpecification
 * 2. beanName=com.wangtao.feignexample.feign.UserService
 *    class=org.springframework.cloud.openfeign.FeignClientFactoryBean
 *    FeignClientFactoryBean是一个FactoryBean, 从容器通过getObject方法可以获取
 *    到UserService的实例, 且该bean会被@Primary修饰(@FeignClient注解的primary默认为true),
 *    因此存在fallback实现类时, 注入时不用指定名称也不会报错
 * @author wangtao
 * Created at 2022/5/13 20:55
 */
@FeignClient(value = "nacos-producer", contextId = "nacos-producer", path = "/api/users", configuration = NacosProducerFeignConfig.class)
public interface UserService {

    @GetMapping("/{userId}")
    UserVO detailUser(@PathVariable Integer userId);

    @GetMapping("/getServerPort")
    String getServerPort();
}

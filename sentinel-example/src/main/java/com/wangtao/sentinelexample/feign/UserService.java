package com.wangtao.sentinelexample.feign;


import com.wangtao.sentinelexample.config.NacosProducerFeignConfig;
import com.wangtao.sentinelexample.feign.fallback.UserServiceFallback;
import com.wangtao.sentinelexample.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangtao
 * Created at 2022/5/13 20:55
 */
@FeignClient(value = "nacos-producer", path = "/api/users", configuration = NacosProducerFeignConfig.class,
        fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/{userId}")
    UserVO detailUser(@PathVariable Integer userId);

    @GetMapping("/getServerPort")
    String getServerPort();
}

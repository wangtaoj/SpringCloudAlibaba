package com.wangtao.feignexample.feign;


import com.wangtao.feignexample.config.NacosProducerFeignConfig;
import com.wangtao.feignexample.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangtao
 * Created at 2022/5/13 20:55
 */
@FeignClient(value = "nacos-producer", path = "/api/users", configuration = NacosProducerFeignConfig.class)
public interface UserService {

    @GetMapping("/{userId}")
    UserVO detailUser(@PathVariable Integer userId);

    @GetMapping("/getServerPort")
    String getServerPort();
}

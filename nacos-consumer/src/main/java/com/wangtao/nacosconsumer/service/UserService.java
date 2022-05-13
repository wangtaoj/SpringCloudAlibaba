package com.wangtao.nacosconsumer.service;

import com.wangtao.nacosconsumer.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangtao
 * Created at 2022/5/13 20:55
 */
@FeignClient("nacos-producer")
public interface UserService {

    @GetMapping("/api/users/{userId}")
    UserVO detailUser(@PathVariable Integer userId);
}

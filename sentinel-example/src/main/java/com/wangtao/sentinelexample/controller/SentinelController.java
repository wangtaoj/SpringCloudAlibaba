package com.wangtao.sentinelexample.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wangtao.sentinelexample.feign.UserService;
import com.wangtao.sentinelexample.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangtao
 * Created at 2022/6/27 21:57
 */
@RequestMapping("/sentinel")
@RestController
public class SentinelController {

    @Autowired
    private UserService userService;

    @SentinelResource(value = "/hello", blockHandler = "helloBlockHandler", fallback = "helloFallback")
    @GetMapping("/hello")
    public String hello(boolean throwException) {
        if (throwException) {
            throw new IllegalArgumentException();
        }
        return "Hello, Sentinel";
    }

    public String helloBlockHandler(boolean throwException, BlockException e) {
        System.out.println(throwException);
        System.out.println(e.getMessage());
        return "Hello, Sentinel Block.";
    }

    public String helloFallback(boolean throwException) {
        System.out.println(throwException);
        return "Hello Exception";
    }

    @GetMapping("/detailUser/{userId}")
    public UserVO detailUser(@PathVariable Integer userId) {
        return userService.detailUser(userId);
    }
}

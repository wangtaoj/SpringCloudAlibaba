package com.wangtao.feignexample.controller;

import com.wangtao.feignexample.feign.UserService;
import com.wangtao.feignexample.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangtao
 * Created at 2022/5/13 20:03
 */
@RequestMapping("/api/email")
@RestController
public class EmailController {

    @Autowired
    private UserService userService;

    @GetMapping("/sendEmail")
    public String sendEmail(Integer userId) {
        UserVO user = userService.detailUser(userId);
        if (user == null) {
            return "send email error, not found user!";
        }
        return "send email to " + user.getName();
    }

    @GetMapping("/getServerPort")
    public String getServerPort() {
        return userService.getServerPort();
    }
}

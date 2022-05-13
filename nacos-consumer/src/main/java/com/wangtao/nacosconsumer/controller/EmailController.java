package com.wangtao.nacosconsumer.controller;

import com.wangtao.nacosconsumer.service.UserService;
import com.wangtao.nacosconsumer.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangtao
 * Created at 2022/5/13 20:03
 */
@RequestMapping("/api/email")
@RestController
public class EmailController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @GetMapping("/sendEmail")
    public String sendEmail(Integer userId) {
        String url = "http://nacos-producer/api/users/" + userId;
        UserVO user = restTemplate.getForObject(url, UserVO.class);
        if (user == null) {
            return "send email error, not found user!";
        }
        return "send email to " + user.getName();
    }

    @GetMapping("/sendEmailByFeign")
    public String sendEmailByFeign(Integer userId) {
        UserVO user = userService.detailUser(userId);
        if (user == null) {
            return "send email error, not found user!";
        }
        return "send email to " + user.getName();
    }
}

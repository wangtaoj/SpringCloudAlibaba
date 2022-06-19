package com.wangtao.nacosconfig.controller;

import com.wangtao.nacosconfig.config.UserProperties;
import com.wangtao.nacosconfig.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @author wangtao
 * Created at 2022/6/18 17:05
 */
@RefreshScope
@RequestMapping("/api/config")
@RestController
public class ConfigController {

    @Value("${user.id}")
    private Integer id;

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private Integer age;

    @Autowired
    private Environment environment;

    @Autowired
    private UserProperties userProperties;

    /**
     * 动态刷新时对应的值不会更新
     * 需要借助@RefreshScope注解, 再次访问这个bean时会更新
     */
    @GetMapping("/byValue")
    public UserVO byValue() {
        return new UserVO(id, name, age);
    }

    /**
     * 动态刷新时对应的值也会更新
     */
    @GetMapping("/byConfigurationProperties")
    public void byConfigurationProperties() {
        Instant start = Instant.now();
        while (true) {
            Duration duration = Duration.between(start, Instant.now());
            if (duration.getSeconds() > 60) {
                break;
            }
            System.out.println(userProperties);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/dynamicUpdate")
    public void dynamicUpdate() {
        Instant start = Instant.now();
        while (true) {
            Duration duration = Duration.between(start, Instant.now());
            if (duration.getSeconds() > 60) {
                break;
            }
            String name = environment.getProperty("user.name");
            String age = environment.getProperty("user.age");
            System.out.println("name: " + name + ", age: " + age);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

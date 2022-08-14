package com.wangtao.feignexample;

import feign.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author wangtao
 * Created at 2022/8/14 13:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private ApplicationContext ac;

    @Test
    public void contextLoad() {
        System.out.println(ac.getBeanDefinitionNames().length);
        Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("===================================");
        Arrays.stream(ac.getBeanNamesForType(Request.Options.class)).forEach(System.out::println);
    }
}

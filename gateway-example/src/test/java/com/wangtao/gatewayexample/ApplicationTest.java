package com.wangtao.gatewayexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wangtao
 * Created at 2022/7/2 23:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private ApplicationContext ac;

    @Test
    public void contextLoad() {
        System.out.println(ac);
    }
}

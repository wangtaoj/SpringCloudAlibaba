package com.wangtao.seatastorage;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangtao
 * Created at 2023/2/26 12:37
 */
@MapperScan(annotationClass = Mapper.class)
@EnableDiscoveryClient
@SpringBootApplication
public class SeataStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApplication.class, args);
    }
}

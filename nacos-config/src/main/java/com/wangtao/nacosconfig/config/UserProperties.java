package com.wangtao.nacosconfig.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangtao
 * Created at 2022/6/18 20:00
 */
@ConfigurationProperties(prefix = "user")
@Data
public class UserProperties {

    private Integer id;

    private String name;

    private Integer age;
}

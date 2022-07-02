package com.wangtao.sentinelexample.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangtao
 * Created at 2022/5/13 19:48
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVO {

    private Integer id;

    private String name;

    private Integer age;
}

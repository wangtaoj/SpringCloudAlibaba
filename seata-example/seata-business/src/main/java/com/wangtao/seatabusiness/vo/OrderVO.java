package com.wangtao.seatabusiness.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangtao
 * Created at 2023/2/26 13:24
 */
@Getter
@Setter
public class OrderVO {

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;
}

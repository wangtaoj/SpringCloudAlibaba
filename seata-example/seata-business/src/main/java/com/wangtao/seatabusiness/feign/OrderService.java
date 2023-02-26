package com.wangtao.seatabusiness.feign;

import com.wangtao.seatabusiness.vo.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wangtao
 * Created at 2023/2/26 13:16
 */
@FeignClient(value = "seata-order", path = "/order")
public interface OrderService {

    @PostMapping("/create")
    void create(OrderVO orderVO);

}

package com.wangtao.seataorder.controller;

import com.wangtao.seataorder.entity.OrderEntity;
import com.wangtao.seataorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangtao
 * Created at 2023/2/26 00:36
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Seata!";
    }

    @PostMapping("/create")
    public void create(@RequestBody OrderEntity order) {
        orderService.create(order);
    }
}

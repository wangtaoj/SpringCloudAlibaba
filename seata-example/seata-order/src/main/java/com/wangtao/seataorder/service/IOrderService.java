package com.wangtao.seataorder.service;

import com.wangtao.seataorder.entity.OrderEntity;

public interface IOrderService {

    /**
     * 创建订单
     * @param order 订单实体
     */
    void create(OrderEntity order);
}

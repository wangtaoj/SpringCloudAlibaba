package com.wangtao.seataorder.service.impl;

import com.wangtao.seataorder.entity.OrderEntity;
import com.wangtao.seataorder.mapper.OrderMapper;
import com.wangtao.seataorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    @Override
    public void create(OrderEntity order) {
        orderMapper.insert(order);
    }
}





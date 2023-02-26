package com.wangtao.seatabusiness.service.impl;

import com.wangtao.seatabusiness.feign.OrderService;
import com.wangtao.seatabusiness.feign.StorageService;
import com.wangtao.seatabusiness.service.IBusinessService;
import com.wangtao.seatabusiness.vo.OrderVO;
import com.wangtao.seatabusiness.vo.PurchaseVO;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private StorageService storageService;

    @GlobalTransactional
    @Override
    public void purchase(PurchaseVO purchaseVO, boolean throwExp) {
        storageService.deduce(purchaseVO.getCommodityCode(), purchaseVO.getCount());

        OrderVO orderVO = new OrderVO();
        orderVO.setUserId(purchaseVO.getUserId());
        orderVO.setCommodityCode(purchaseVO.getCommodityCode());
        orderVO.setCount(purchaseVO.getCount());
        orderVO.setMoney(purchaseVO.getCount() * 1000);
        orderService.create(orderVO);

        if (throwExp) {
            throw new IllegalStateException("下单失败");
        }
    }
}





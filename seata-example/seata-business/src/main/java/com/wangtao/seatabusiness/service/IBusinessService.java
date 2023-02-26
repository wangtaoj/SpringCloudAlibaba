package com.wangtao.seatabusiness.service;

import com.wangtao.seatabusiness.vo.PurchaseVO;

public interface IBusinessService {

    void purchase(PurchaseVO purchaseVO, boolean throwExp);
}

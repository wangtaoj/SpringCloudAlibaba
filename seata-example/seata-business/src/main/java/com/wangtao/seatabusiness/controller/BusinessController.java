package com.wangtao.seatabusiness.controller;

import com.wangtao.seatabusiness.service.IBusinessService;
import com.wangtao.seatabusiness.vo.PurchaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangtao
 * Created at 2023/2/26 00:36
 */
@RequestMapping("/business")
@RestController
public class BusinessController {

    @Autowired
    private IBusinessService businessService;

    @PostMapping("/purchase")
    public void purchase(PurchaseVO purchaseVO, @RequestParam(defaultValue = "false") boolean throwExp) {
        businessService.purchase(purchaseVO, throwExp);
    }
}

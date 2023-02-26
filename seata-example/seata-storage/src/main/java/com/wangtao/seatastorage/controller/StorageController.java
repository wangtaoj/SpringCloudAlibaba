package com.wangtao.seatastorage.controller;

import com.wangtao.seatastorage.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangtao
 * Created at 2023/2/26 12:52
 */
@RequestMapping("/storage")
@RestController
public class StorageController {

    @Autowired
    private IStorageService storageService;

    @PostMapping("/deduce")
    public void deduce(String commodityCode, Integer count) {
        storageService.deduce(commodityCode, count);
    }
}

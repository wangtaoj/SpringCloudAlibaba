package com.wangtao.seatastorage.service.impl;

import com.wangtao.seatastorage.mapper.StorageMapper;
import com.wangtao.seatastorage.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangtao
 * Created at 2023/2/26 12:46
 */
@Service
public class StorageServiceImpl implements IStorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Transactional
    @Override
    public void deduce(String commodityCode, Integer count) {
        storageMapper.updateCountByCommodityCode(commodityCode, count);
    }
}

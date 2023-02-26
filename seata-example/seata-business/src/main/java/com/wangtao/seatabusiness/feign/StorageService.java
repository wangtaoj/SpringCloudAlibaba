package com.wangtao.seatabusiness.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangtao
 * Created at 2023/2/26 12:45
 */
@FeignClient(value = "seata-storage", path = "/storage")
public interface StorageService {

    @PostMapping("/deduce")
    void deduce(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}

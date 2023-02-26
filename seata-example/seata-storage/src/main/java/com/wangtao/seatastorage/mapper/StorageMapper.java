package com.wangtao.seatastorage.mapper;
import org.apache.ibatis.annotations.Param;

import com.wangtao.seatastorage.entity.StorageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageMapper extends BaseMapper<StorageEntity> {

    int updateCountByCommodityCode(@Param("commodityCode") String commodityCode, @Param("count") Integer count);

}





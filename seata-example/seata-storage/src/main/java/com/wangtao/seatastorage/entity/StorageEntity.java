package com.wangtao.seatastorage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@TableName(value ="storage_tbl")
@Data
public class StorageEntity implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String commodityCode;

    /**
     * 
     */
    private Integer count;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
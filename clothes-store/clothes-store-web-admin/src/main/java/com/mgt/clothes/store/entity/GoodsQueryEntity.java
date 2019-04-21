package com.mgt.clothes.store.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ResponseGoods
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/22 14:27
 * @Version 1.0
 **/
@Data
public class GoodsQueryEntity<T> implements Serializable {

    private List<T> data;

    public GoodsQueryEntity(List<T> data){
        this.data = data;
    }

}

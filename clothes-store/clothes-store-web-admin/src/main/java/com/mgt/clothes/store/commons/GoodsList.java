package com.mgt.clothes.store.commons;

import lombok.Data;

import java.util.List;

/**
 * @ClassName GoodsList
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/22 16:20
 * @Version 1.0
 **/
@Data
public class GoodsList<T> {
    /**
     * 存储用户信息
     */
    private List<T> data;
}

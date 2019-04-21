package com.mgt.clothes.store.commons;

import com.mgt.clothes.store.abstracts.AbstractBaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class DataTable<T extends AbstractBaseEntity> {
    /**
     * 总条数
     */
    private int total;
    /**
     * 存储用户信息
     */
    private List<T> data;
}

package com.mgt.clothes.store.entity;

import com.mgt.clothes.store.abstracts.AbstractBaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageInfo
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 3:39
 * @Version 1.0
 **/
@Data
public class PageInfo<T extends AbstractBaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;
}

package com.mgt.clothes.store.entity;

import com.mgt.clothes.store.abstracts.AbstractBaseEntity;
import lombok.Data;

/**
 * @ClassName TbGoodsType
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/22 9:32
 * @Version 1.0
 **/
@Data
public class TbGoodsType extends AbstractBaseEntity {
    private String goodsTypeName;
    private Integer parentId;

}

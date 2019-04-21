package com.mgt.clothes.store.abstracts;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName AbstractBaseEntity
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 3:29
 * @Version 1.0
 **/
@Data
public class AbstractBaseEntity implements Serializable {

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("创建日期")
    private Date created;
    @ApiModelProperty("修改日期")
    private Date updated;

    /**
     * 添加和修改的判断
     * @param entity
     * @return
     */
    public boolean nowInsert(AbstractBaseEntity entity){
        Date currentData = new Date();
        entity.setUpdated(currentData);
        //添加
        if(entity.getId()==null){
            entity.setCreated(currentData);
            return true;
        }
        return false;
    }


}

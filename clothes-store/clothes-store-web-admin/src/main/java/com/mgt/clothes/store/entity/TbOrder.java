package com.mgt.clothes.store.entity;

import com.mgt.clothes.store.abstracts.AbstractBaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbOrder extends AbstractBaseEntity  {
    @ApiModelProperty("订单号")
    private String orderId;
    @ApiModelProperty("顾客id")
    private int customerId;
    @ApiModelProperty("顾客名字")
    private String customerName;
    @ApiModelProperty("总价格")
    private int totalMoney;
    @ApiModelProperty("订单状态")
    private String orderState;

}

package com.mgt.clothes.store.entity;

import lombok.Data;

/**
 * @ClassName TbAddress
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/23 15:09
 * @Version 1.0
 **/
@Data
public class TbAddress {
    private Integer customerId;
    private String phone;
    private String shouhuoren;
    private String address;
}

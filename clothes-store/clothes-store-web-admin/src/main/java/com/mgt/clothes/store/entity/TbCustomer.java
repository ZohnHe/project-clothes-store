package com.mgt.clothes.store.entity;

import com.mgt.clothes.store.abstracts.AbstractBaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName TbCustomer
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 16:23
 * @Version 1.0
 **/
@Data
public class TbCustomer extends AbstractBaseEntity {

    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    private String customerName;
    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String customerPassword;
    @ApiModelProperty("电话号码")
    private String customerPhone;
    @ApiModelProperty("用户真实名字")
    private String trueName;
    @ApiModelProperty("邮箱")
    private String customerEmail;
    @ApiModelProperty("密码加密的盐值")
    private String salt;
    @ApiModelProperty("用户地址")
    private String customerAddress;
    @ApiModelProperty("邮政编码")
    private String postCode;
    @ApiModelProperty("登录验证码")
    private String verify;


}

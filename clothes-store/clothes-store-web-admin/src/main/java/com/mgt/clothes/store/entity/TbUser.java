package com.mgt.clothes.store.entity;

import com.mgt.clothes.store.abstracts.AbstractBaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @ClassName TbUser
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/16 16:18
 * @Version 1.0
 **/
@Data
public class TbUser extends AbstractBaseEntity {


    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
    @ApiModelProperty("电话号码")
    private String phone;
    @ApiModelProperty("头像")
    private String image;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("密码加密的盐值")
    private String salt;
    @ApiModelProperty("登录验证码")
    private String verify;
}

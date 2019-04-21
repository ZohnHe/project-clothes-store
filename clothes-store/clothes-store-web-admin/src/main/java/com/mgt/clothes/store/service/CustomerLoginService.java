package com.mgt.clothes.store.service;

import com.mgt.clothes.store.entity.TbCustomer;
import com.mgt.clothes.store.entity.TbUser;

/**
 * @ClassName CustomerLoginService
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 19:22
 * @Version 1.0
 **/
public interface CustomerLoginService {
    TbCustomer Login(String loginId);
}

package com.mgt.clothes.store.service;

import com.mgt.clothes.store.entity.TbUser;

/**
 * @ClassName TbUserService
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/16 16:19
 * @Version 1.0
 **/
public interface LoginService {
    TbUser Login(String loginId);
}

package com.mgt.clothes.store.service.impl;

import com.mgt.clothes.store.entity.TbUser;
import com.mgt.clothes.store.mapper.TbUserMapper;
import com.mgt.clothes.store.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/16 16:22
 * @Version 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TbUserMapper tbUserMapper;


    @Override
    public TbUser Login(String loginId) {
        TbUser param = new TbUser();
        //设置用户名、邮箱、手机号均可登陆
        param.setPhone(loginId);
        param.setEmail(loginId);
        param.setUsername(loginId);
        TbUser tbUser = tbUserMapper.getByLoginId(param);
       //登陆成功
        if(tbUser != null){
            return tbUser;
        }
        //登陆失败
        else{
            return null;
        }
    }
}

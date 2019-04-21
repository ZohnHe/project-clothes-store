package com.mgt.clothes.store.service.impl;

import com.mgt.clothes.store.entity.TbCustomer;
import com.mgt.clothes.store.entity.TbUser;
import com.mgt.clothes.store.mapper.TbCustomerMapper;
import com.mgt.clothes.store.mapper.TbUserMapper;
import com.mgt.clothes.store.service.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CustomerLoginServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 19:23
 * @Version 1.0
 **/
@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
    @Autowired
    private TbCustomerMapper tbCustomerMapper;

    @Override
    public TbCustomer Login(String loginId) {
        TbCustomer param = new TbCustomer();
        //设置用户名、邮箱、手机号均可登陆
        param.setCustomerPhone(loginId);
        param.setCustomerEmail(loginId);
        param.setCustomerName(loginId);
        TbCustomer tbCustomer = tbCustomerMapper.getByLoginId(param);
        //登陆成功
        if(tbCustomer != null){
            return tbCustomer;
        }
        //登陆失败
        else{

            return null;
        }
    }
}

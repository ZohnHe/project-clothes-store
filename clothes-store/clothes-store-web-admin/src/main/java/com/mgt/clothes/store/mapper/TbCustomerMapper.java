package com.mgt.clothes.store.mapper;

import com.mgt.clothes.store.abstracts.BaseCrudMapper;
import com.mgt.clothes.store.entity.TbCustomer;
import com.mgt.clothes.store.entity.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @ClassName TbCustomerMapper
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 16:29
 * @Version 1.0
 **/

public interface TbCustomerMapper extends BaseCrudMapper<TbCustomer> {
    /**
     * 顾客登陆商城
     * @param tbCustomer
     * @return
     */
    TbCustomer getByLoginId(TbCustomer tbCustomer);

}

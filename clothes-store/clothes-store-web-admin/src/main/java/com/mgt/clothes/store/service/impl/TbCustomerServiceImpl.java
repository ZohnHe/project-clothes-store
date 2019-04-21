package com.mgt.clothes.store.service.impl;

import com.mgt.clothes.store.abstracts.impl.AbstractCrudServiceImpl;
import com.mgt.clothes.store.entity.Goods;
import com.mgt.clothes.store.entity.TbCustomer;
import com.mgt.clothes.store.mapper.TbCustomerMapper;
import com.mgt.clothes.store.service.TbCustomerService;
import org.springframework.stereotype.Service;

/**
 * @ClassName TbCustomerServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/19 16:51
 * @Version 1.0
 **/
@Service
public class TbCustomerServiceImpl extends AbstractCrudServiceImpl<TbCustomer, TbCustomerMapper> implements TbCustomerService {
}

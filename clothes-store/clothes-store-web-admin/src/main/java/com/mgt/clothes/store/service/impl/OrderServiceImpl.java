package com.mgt.clothes.store.service.impl;

import com.mgt.clothes.store.abstracts.impl.AbstractCrudServiceImpl;
import com.mgt.clothes.store.entity.TbOrder;
import com.mgt.clothes.store.mapper.TbOrderMapper;
import com.mgt.clothes.store.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractCrudServiceImpl<TbOrder, TbOrderMapper> implements OrderService {
}

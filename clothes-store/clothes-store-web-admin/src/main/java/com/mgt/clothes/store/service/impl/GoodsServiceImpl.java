package com.mgt.clothes.store.service.impl;


import com.mgt.clothes.store.abstracts.impl.AbstractCrudServiceImpl;
import com.mgt.clothes.store.entity.Goods;
import com.mgt.clothes.store.mapper.TbGoodsMapper;
import com.mgt.clothes.store.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends AbstractCrudServiceImpl<Goods, TbGoodsMapper> implements GoodsService {
}

package com.mgt.clothes.store.service.impl;

import com.mgt.clothes.store.abstracts.impl.AbstractCrudServiceImpl;
import com.mgt.clothes.store.commons.DataTable;
import com.mgt.clothes.store.entity.Goods;
import com.mgt.clothes.store.entity.TbUser;
import com.mgt.clothes.store.mapper.TbGoodsMapper;
import com.mgt.clothes.store.mapper.TbUserMapper;
import com.mgt.clothes.store.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TbUserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 13:11
 * @Version 1.0
 **/
@Service
public class TbUserServiceImpl extends AbstractCrudServiceImpl<TbUser, TbUserMapper> implements TbUserService {
    @Resource
    private TbUserMapper tbUserMapper;
    @Override
    public void update(TbUser tbUser) {
        Date currentData = new Date();
        tbUser.setUpdated(currentData);
        tbUserMapper.update(tbUser);
    }


}

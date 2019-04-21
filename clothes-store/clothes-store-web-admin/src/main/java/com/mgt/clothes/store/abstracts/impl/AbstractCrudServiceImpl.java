package com.mgt.clothes.store.abstracts.impl;

import com.mgt.clothes.store.abstracts.AbstractBaseEntity;
import com.mgt.clothes.store.abstracts.BaseCrudMapper;
import com.mgt.clothes.store.abstracts.BaseCrudService;
import com.mgt.clothes.store.commons.DataTable;
import com.mgt.clothes.store.commons.GoodsList;
import com.mgt.clothes.store.entity.Goods;
import com.mgt.clothes.store.entity.PageInfo;
import com.mgt.clothes.store.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AbstractCrudServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 3:35
 * @Version 1.0
 **/
@Service
public class AbstractCrudServiceImpl <T extends AbstractBaseEntity,M extends BaseCrudMapper<T>> implements BaseCrudService<T> {

    @Autowired
    private M mapper;
    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public DataTable<T> page(T entity, int start, int length, int draw) {
        Map<String,Object> params = new HashMap<>();
        //将获取的值传入一个对象（遵循驼峰命名）
        params.put(StringUtils.toLowerCaseFirstOne(entity.getClass().getSimpleName()),entity);
        params.put("start",start);
        params.put("length",length);

        List<T> data=mapper.page(params);
        int total = mapper.count(entity);

        DataTable<T> dataTable = new DataTable<>();
        dataTable.setData(data);
        dataTable.setTotal(total);

        return dataTable;
    }

    @Override
    public int count(T entity) {
        return mapper.count(entity);
    }

    @Override
    public void save(T entity) {
        //添加
        if(entity.nowInsert(entity)){
            mapper.add(entity);
        }
        //修改
        else {
            mapper.update(entity);
        }

    }

    @Override
    public T getById(Long id) {
        return mapper.getById(id);
    }

    @Override
    public void delete(T entity) {
        mapper.delete(entity);
    }
    @Override
    public void del(long id) {
        mapper.del(id);
    }
}

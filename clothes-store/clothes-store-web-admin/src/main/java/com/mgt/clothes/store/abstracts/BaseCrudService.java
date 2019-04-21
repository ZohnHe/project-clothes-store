package com.mgt.clothes.store.abstracts;


import com.mgt.clothes.store.commons.DataTable;
import com.mgt.clothes.store.commons.GoodsList;
import com.mgt.clothes.store.entity.PageInfo;

import java.util.List;

public interface BaseCrudService<T extends AbstractBaseEntity> {

    /**
     *  查询所有数据
     * @return
     */
    List<T> selectAll();

    /**
     * 分页
     * @param entity
     * @param start
     * @param length
     * @param draw
     * @return
     */
    DataTable<T> page(T entity, int start, int length, int draw);

    /**
     * 查询总数据条数
     * @param entity
     * @return
     */
    int count(T entity);

    /**
     * 保存用户
     * @param entity
     */
    void save(T entity);

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 删除
     * @param entity
     */
    void delete(T entity);
    /**
     * 根据id删除
     *
     */
    void del(long id);
}

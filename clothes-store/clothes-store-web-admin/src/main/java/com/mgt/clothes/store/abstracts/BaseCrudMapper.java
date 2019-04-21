package com.mgt.clothes.store.abstracts;

import com.mgt.clothes.store.commons.GoodsList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseCrudMapper
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 3:27
 * @Version 1.0
 **/
@Repository
public interface BaseCrudMapper<T extends AbstractBaseEntity> {
    /**
     * 查询所有用户信息
     * @return
     */
    List<T> selectAll();

    /**
     * 分页查询
     * @param params
     * @return
     */
    List<T> page(Map<String, Object> params);

    /**
     * 查询数据条数
     * @param entity
     * @return
     */
    int count(T entity);

    /**
     * 根据id获取对象
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 添加
     * @param entity
     */
    void add(T entity);

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

    /**
     * 修改
     * @param entity
     */
    void update(T entity);

}

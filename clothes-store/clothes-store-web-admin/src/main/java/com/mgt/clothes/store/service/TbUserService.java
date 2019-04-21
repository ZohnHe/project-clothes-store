package com.mgt.clothes.store.service;

import com.mgt.clothes.store.abstracts.BaseCrudService;
import com.mgt.clothes.store.commons.DataTable;
import com.mgt.clothes.store.entity.TbUser;
import org.springframework.stereotype.Service;

/**
 * @ClassName TbUserService
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 13:10
 * @Version 1.0
 **/

public interface TbUserService extends BaseCrudService<TbUser> {
    void update(TbUser tbUser);

}

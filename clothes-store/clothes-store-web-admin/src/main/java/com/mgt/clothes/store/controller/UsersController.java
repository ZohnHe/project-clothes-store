package com.mgt.clothes.store.controller;

import com.mgt.clothes.store.abstracts.AbstractBaseController;
import com.mgt.clothes.store.entity.TbUser;
import com.mgt.clothes.store.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@RequestMapping(value = "users")
public class UsersController extends AbstractBaseController<TbUser, TbUserService> {
    @GetMapping(value = "list")
    public String users(){
        return "users/users_list";
    }

    @GetMapping(value = "form")
    public String form(){
        return "users/users_form";
    }
    @GetMapping(value = "add")
    public String add(){
        return "users/users_add";
    }
    @ResponseBody
    @PostMapping(value = "form")
    public TbUser form(HttpServletRequest request){
        return (TbUser) request.getSession().getAttribute("goodsMessage");

    }
    @ResponseBody
    @PostMapping(value = "save")
    public String save(long id, String username, String password, String phone, String email, Date created, Date updated){
        TbUser tbUser = new TbUser();
        tbUser.setId(id);
        tbUser.setUsername(username);
        tbUser.setPassword(password);
        tbUser.setPhone(phone);
        tbUser.setEmail(email);
        tbUser.setCreated(created);
        tbUser.setUpdated(updated);
        // 验证成功
        if (tbUser!=null){
            service.save(tbUser);
            return "1";
        }

        // 验证失败
        else {
            return "0";
        }

    }
    @ResponseBody
    @PostMapping(value = "add")
    public String save(String username,String password,String phone,String email,Date created,Date updated,String salt){
        TbUser tbUser = new TbUser();
        tbUser.setUsername(username);
        tbUser.setPassword(password);
        tbUser.setPhone(phone);
        tbUser.setEmail(email);
        tbUser.setCreated(created);
        tbUser.setUpdated(updated);
        System.out.println(salt);
        tbUser.setSalt(salt);
        // 验证成功
        if (tbUser!=null){
            service.save(tbUser);
            return "1";
        }

        // 验证失败
        else {
            return "0";
        }

    }
    @GetMapping(value = "del")
    public String del(HttpServletRequest request){
        TbUser tbUser = (TbUser) request.getSession().getAttribute("goodsMessage");
        System.out.println(tbUser.toString());
        Long id = tbUser.getId();
        if (id!=null){
            service.del(id);
            return "users/users_list";
        }
        else {
            return "users/users_list";
        }
    }
}

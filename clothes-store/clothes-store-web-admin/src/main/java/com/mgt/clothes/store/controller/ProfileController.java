package com.mgt.clothes.store.controller;

import com.mgt.clothes.store.entity.TbUser;
import com.mgt.clothes.store.service.TbUserService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ProfileController
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 13:08
 * @Version 1.0
 **/
@Controller
@Api(tags = "个人信息修改模块")
@RequestMapping(value = {"profile"})
public class ProfileController {

    @Resource
    private TbUserService tbUserService;

    //跳转个人信息界面
    @GetMapping(value = {"info"})
    public String info() {
        return "/profile_info";
    }


    //修改信息
    @ResponseBody
    @PostMapping(value = {"save"})
    public String update(TbUser tbUser, HttpServletRequest request){
        System.out.println(tbUser);
        tbUserService.update(tbUser);
        return "1";
    }
}

package com.mgt.clothes.store.controller;

import com.mgt.clothes.store.entity.TbUser;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆成功页面跳转
 * @ClassName MainController
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 0:49
 * @Version 1.0
 **/
@Controller
@Api(value = "登陆成功首页", tags = "主页模板")
@RequestMapping(value = "/admin")
public class MainController {

    @GetMapping(value = {"error"})
    public String error(){
        return "html/main";
    }

    @GetMapping(value = {"main"})
    public String main(){
        return "main";
    }

    @GetMapping(value = "login")
    public String logout(){
        return "login";
    }

    /**
     * 从session中获取信息，返回登录id名
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping(value = "getMsg")
    public TbUser getMsg(HttpServletRequest request){
        TbUser tbUser = (TbUser) request.getSession().getAttribute("tbUser");
        return tbUser;
    }
}

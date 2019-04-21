package com.mgt.clothes.store.controller;

import com.mgt.clothes.store.entity.ResponseEntity;
import com.mgt.clothes.store.entity.TbUser;
import com.mgt.clothes.store.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/16 16:26
 * @Version 1.0
 **/
@Controller
@Api(value = "登录",tags = "登录模块")
@RequestMapping(value = {"/user"})
public class LoginController {
    @Autowired
    private LoginService loginService;

    //跳转登录页
    @GetMapping(value = {"", "login"})
    public String login() {
        return "/login";
    }
    /**
     * 登录
     *
     * @param loginId 用户名，邮箱，电话号码
     * @param loginPwd 密码
     * @return
     */
    @ResponseBody
    @PostMapping(value = "userLogin")
    @ApiOperation(value = "管理员登录", notes = "POST请求登录")
    public ResponseEntity login(String loginId, String loginPwd, String verify, HttpServletRequest request) {
        ResponseEntity responseEntity = new ResponseEntity();
        //TODO 判断验证码是否正确
        if (StringUtils.isNotBlank(verify)) {
            TbUser tbUser = loginService.Login(loginId);
            if (tbUser  != null) {
                //TODO 判断密码是否正确
                if (StringUtils.equals(loginPwd, tbUser.getPassword())) {
                    request.getSession().setAttribute("tbUser",tbUser);
                    responseEntity.setSuccess("1");
                    return responseEntity;
                }
            }
            //TODO 账号或密码错误
            responseEntity.setSuccess("2");
            return responseEntity;
        }
        else {
            //TODO 验证码错误
            responseEntity.setSuccess("0");
            return responseEntity;
        }
    }
    /**
     * 获取数据库中的盐值
     * @param loginId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "salt")
    @ApiOperation(value = "获取数据库中的盐值", notes = "GET 请求")
    public String getSalt(String loginId){
        TbUser tbUser = loginService.Login(loginId);
        System.out.println(tbUser.getSalt());
        if(tbUser != null){
            //获取数据库的盐值
            return tbUser.getSalt();
        }
        return null;
    }
    /**
     * 注销
     * @param request
     * @return
     */
    @GetMapping(value = "logout")
    @ApiOperation(value = "管理员注销", notes = "GET 请求")
    public String logOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/admin/login";
    }
}

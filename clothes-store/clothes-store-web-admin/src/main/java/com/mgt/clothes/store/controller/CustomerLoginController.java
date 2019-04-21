package com.mgt.clothes.store.controller;

import com.mgt.clothes.store.entity.Goods;
import com.mgt.clothes.store.entity.ResponseEntity;
import com.mgt.clothes.store.entity.TbCustomer;
import com.mgt.clothes.store.service.CustomerLoginService;
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
 * @ClassName CustomerLoginController
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 19:31
 * @Version 1.0
 **/
@Controller
@Api(value = "顾客登录",tags = "登录模块")
    @RequestMapping(value = {"/customers"})
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService customerLoginService;
    //跳转商城首页
    @GetMapping(value = {"register"})
    public String register() {
        return "customer/register";
    }

    //跳转商城首页
    @GetMapping(value = {"index"})
    public String index() {
        return "customer/index";
    }

    //跳转登录页
    @GetMapping(value = {"denglu"})
    public String login() {
        return "customer/denglu";
    }

    /**
     * 登录
     *
     * @param loginId 顾客名，邮箱，电话号码
     * @param loginPwd 密码
     * @return
     */
    @ResponseBody
    @PostMapping(value = "login")
    @ApiOperation(value = "顾客登录", notes = "POST请求登录")
    public ResponseEntity login(String loginId, String loginPwd, String verify, HttpServletRequest request) {
        ResponseEntity responseEntity = new ResponseEntity();
        //TODO 判断验证码是否正确
        if (StringUtils.isNotBlank(verify)) {
            TbCustomer tbCustomer = customerLoginService.Login(loginId);
            if (tbCustomer  != null) {
                //TODO 判断密码是否正确
                if (StringUtils.equals(loginPwd,tbCustomer.getCustomerPassword())) {
                    request.getSession().setAttribute("tbCustomer",tbCustomer);
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
        TbCustomer tbCustomer = customerLoginService.Login(loginId);
        if(tbCustomer != null){
            return tbCustomer.getSalt();
        }
        return null;
    }
    /**
     * 注销
     * @param request
     * @return
     */
    @GetMapping(value = "logout")
    @ApiOperation(value = "顾客注销", notes = "GET 请求")
    public String logOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/admin/login";
    }

    @GetMapping(value="categories")
    @ApiOperation(value = "顾客注销", notes = "GET 请求")
    public String categories(){
        return "customer/categories";
    }


}

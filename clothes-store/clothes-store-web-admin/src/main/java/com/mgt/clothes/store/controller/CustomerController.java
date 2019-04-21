package com.mgt.clothes.store.controller;

import com.mgt.clothes.store.abstracts.AbstractBaseController;
import com.mgt.clothes.store.entity.Goods;
import com.mgt.clothes.store.entity.TbCustomer;
import com.mgt.clothes.store.service.TbCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CustomerController
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/19 16:57
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "customer")
@Api(value = "顾客",tags = "顾客后台管理模块")
public class CustomerController extends AbstractBaseController<TbCustomer, TbCustomerService> {

    @GetMapping(value = "list")
    public String goods(){
        return "customer/list";
    }

    @GetMapping(value = "tij_dingd")
    public String tij(){
        return "customer/tij_dingdan";
    }

    @GetMapping(value = "form")
    public String form(){
        return "customer/form";
    }
    @GetMapping(value = "add")
    public String add(){
        return "customer/add";
    }
    @ResponseBody
    @PostMapping(value = "form")
    public TbCustomer form(HttpServletRequest request){
        return (TbCustomer) request.getSession().getAttribute("customerMessage");
    }
    @ResponseBody
    @PostMapping(value = "update")
    public String save(Long id,String customerName,String customerPassword,String trueName,String postCode,String customerAddress,String customerPhone,String customerEmail){
        TbCustomer tbCustomer = new TbCustomer();
        tbCustomer.setId(id);
        tbCustomer.setCustomerPassword(customerPassword);
        tbCustomer.setCustomerName(customerName);
        tbCustomer.setPostCode(postCode);
        tbCustomer.setTrueName(trueName);
        tbCustomer.setCustomerAddress(customerAddress);
        tbCustomer.setCustomerPhone(customerPhone);
        tbCustomer.setCustomerEmail(customerEmail);
        System.out.println(tbCustomer);
        // 验证成功
        if (tbCustomer!=null){
            service.save(tbCustomer);
            return "1";
        }
        // 验证失败
        else {
            return "0";
        }
    }
    @ResponseBody
    @PostMapping(value = "add")
    public String save(String salt,String customerName,String customerPassword,String trueName,String customerAddress,String postCode,String customerPhone,String customerEmail){
        TbCustomer tbCustomer = new TbCustomer();
        tbCustomer.setCustomerName(customerName);
        tbCustomer.setCustomerPassword(customerPassword);
        tbCustomer.setTrueName(trueName);
        tbCustomer.setCustomerAddress(customerAddress);
        tbCustomer.setPostCode(postCode);
        tbCustomer.setCustomerPhone(customerPhone);
        tbCustomer.setCustomerEmail(customerEmail);
        tbCustomer.setSalt(salt);
        // 验证成功
        if (tbCustomer!=null){
            service.save(tbCustomer);
            return "1";
        }
        // 验证失败
        else {
            return "0";
        }

    }
    @GetMapping(value = "del")
    public String del(HttpServletRequest request){
        TbCustomer tbCustomer = (TbCustomer) request.getSession().getAttribute("customerMessage");
        Long id = tbCustomer.getId();
        if (id!=null){
            service.del(id);
            return "customer/list";
        }
        else {
            return "customer/list";
        }
    }
}

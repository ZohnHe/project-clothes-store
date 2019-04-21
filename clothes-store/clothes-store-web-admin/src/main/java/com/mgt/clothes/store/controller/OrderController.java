package com.mgt.clothes.store.controller;


import com.mgt.clothes.store.abstracts.AbstractBaseController;
import com.mgt.clothes.store.entity.TbOrder;
import com.mgt.clothes.store.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Controller
@Api(tags = "订单管理模块")
@RequestMapping(value = "orders")
public class OrderController extends AbstractBaseController<TbOrder, OrderService> {
    @GetMapping(value = "list")
    public String  list(){
        return "orders/list";
    }

    @GetMapping(value = "form")
    public String form(){
        return "orders/form";
    }

    @ResponseBody
    @PostMapping(value = "form")
    public TbOrder form(HttpServletRequest request){
        return (TbOrder) request.getSession().getAttribute("goodsMessage");
    }

    @ResponseBody
    @PostMapping(value = "add")
    public String save(){
        TbOrder order = new TbOrder();
        order.setCustomerName("admin");
        order.setOrderId(UUID.randomUUID().toString());
        order.setTotalMoney(80);
        order.setOrderState("已付账");
        order.setCustomerId(17);
        if (order != null){
            System.out.println(order.getUpdated());
            service.save(order);
            return "1";
        }else {
            return "0";
        }
    }

    @ResponseBody
    @PostMapping(value = "save")
    public String save(String orderId,int customerId,String customerName, int totalMoney,String orderState,Date created,Date updated){
        TbOrder order = new TbOrder();
        order.setOrderId(orderId);
        order.setCustomerId(customerId);
        order.setCustomerName(customerName);
        order.setTotalMoney(totalMoney);
        order.setOrderState(orderState);
        order.setCreated(created);
        order.setUpdated(updated);
        if (order != null){
            service.save(order);
            return "1";
        }else {
            return "0";
        }
    }

    @GetMapping(value = "del")
    public String del(HttpServletRequest request){
        TbOrder order = (TbOrder)request.getSession().getAttribute("GoodsMessage");
        Long id = order.getId();
        if (id != null){
            service.del(id);
            return "orders/list";
        }else {
            return "orders/list";
        }
    }

}

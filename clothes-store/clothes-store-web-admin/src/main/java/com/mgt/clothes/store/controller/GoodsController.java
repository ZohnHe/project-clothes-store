package com.mgt.clothes.store.controller;

import com.mgt.clothes.store.abstracts.AbstractBaseController;
import com.mgt.clothes.store.entity.Goods;
import com.mgt.clothes.store.entity.GoodsQueryEntity;
import com.mgt.clothes.store.entity.TbCustomer;
import com.mgt.clothes.store.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value = "goods")
@Api(value = "物品",tags = "物品模块")
public class GoodsController extends AbstractBaseController<Goods, GoodsService> {
    @Autowired


    @GetMapping(value = "list")
    public String goods(){
        return "goods/list";
    }
    @GetMapping(value = "form")
    public String form(){
        return "goods/form";
    }
    @GetMapping(value = "add")
    public String add(){
        return "goods/add";
    }
    @ResponseBody
    @PostMapping(value = "form")
    public Goods form(HttpServletRequest request){
        return (Goods) request.getSession().getAttribute("goodsMessage");

    }

    @ResponseBody
    @GetMapping(value = "select")
    public GoodsQueryEntity<Goods> select(HttpServletRequest request){
        List<Goods> goods = service.selectAll();
        GoodsQueryEntity goodsQueryEntity = new GoodsQueryEntity(goods);
        return goodsQueryEntity;
    }

    @ResponseBody
    @PostMapping(value = "save")
    public String save(long id,String goodsName,long goodsTypeid,String goodsDesc,int goodsPrice,int goodsStock ,String image){
        Goods goods = new Goods();
        goods.setId(id);
        goods.setImage(image);
        goods.setGoodsName(goodsName);
        goods.setGoodsTypeid(goodsTypeid);
        goods.setGoodsDesc(goodsDesc);
        goods.setGoodsPrice(goodsPrice);
        goods.setGoodsStock(goodsStock);
        // 验证成功
     if (goods!=null){
         service.save(goods);
         return "1";
        }
        // 验证失败
        else {
            return "0";
        }

    }
    @ResponseBody
    @PostMapping(value = "add")
    public String save(String goodsName,long goodsTypeid,String goodsDesc,int goodsPrice,int goodsStock,String image){
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setGoodsTypeid(goodsTypeid);
        goods.setGoodsDesc(goodsDesc);
        goods.setGoodsPrice(goodsPrice);
        goods.setGoodsStock(goodsStock);
        goods.setImage(image);
        // 验证成功
        if (goods!=null){
            service.save(goods);
            return "1";
        }

        // 验证失败
        else {
            return "0";
        }

    }
    @GetMapping(value = "del")
    public String del(HttpServletRequest request){
        Goods goods = (Goods) request.getSession().getAttribute("goodsMessage");
        Long id = goods.getId();
        if (id!=null){
        service.del(id);
            return "goods/list";
        }
        else {
            return "goods/list";
        }
    }



    @GetMapping(value="product")
    @ApiOperation(value = "商品", notes = "GET 请求")
    public String product(){
        return "customer/product";
    }

    @PostMapping(value = "product")
    public Goods product( HttpServletRequest request){
        return (Goods) request.getSession().getAttribute("goodsMessage");
    }

}

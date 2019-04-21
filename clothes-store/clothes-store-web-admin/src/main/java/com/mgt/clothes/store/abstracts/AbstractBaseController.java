package com.mgt.clothes.store.abstracts;

import com.mgt.clothes.store.commons.BeanValidator;
import com.mgt.clothes.store.commons.DataTable;
import com.mgt.clothes.store.entity.Goods;
import com.mgt.clothes.store.entity.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;

/**
 * @ClassName AbstractBaseController
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 3:41
 * @Version 1.0
 **/

public class AbstractBaseController<T extends AbstractBaseEntity,S extends BaseCrudService<T>> {

    @ModelAttribute
    public T getById(Long id,HttpServletRequest request) throws IllegalAccessException, InstantiationException {
        if (id == null) {
            ParameterizedType ptype = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class clazz = (Class<T>) ptype.getActualTypeArguments()[0];
            T o = (T) clazz.newInstance();
            return o;
        } else {
            T goodsMessage = service.getById(id);
            request.getSession().setAttribute("usersMessage",goodsMessage);
            request.getSession().setAttribute("goodsMessage",goodsMessage);
            request.getSession().setAttribute("customerMessage",goodsMessage);
            return null;
        }
    }


    @Autowired
    protected S service;
    /**
     * 分页
     * @param entity
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping(value = "page")
    public PageInfo<T> page(T entity, HttpServletRequest request){
        System.out.println(entity);
        PageInfo<T> pageInfo = new PageInfo<>();
        /*从前台获取这是第几次请求*/
        String strDraw = request.getParameter("draw");
        /*从前台获取本页起始数*/
        String strStart = request.getParameter("start");
        /*从前台获取本页的记录数*/
        String strLength = request.getParameter("length");

        int draw= StringUtils.isBlank(strDraw)?1:Integer.parseInt(strDraw);
        int start= StringUtils.isBlank(strStart)?0:Integer.parseInt(strStart);
        int length= StringUtils.isBlank(strLength)?10:Integer.parseInt(strLength);
        DataTable<T>  dataTable= service.page(entity,start,length,draw);
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(dataTable.getTotal());
        pageInfo.setRecordsFiltered(dataTable.getTotal());
        pageInfo.setData(dataTable.getData());
        System.out.println(pageInfo);
        return pageInfo;
    }
    protected boolean beanValidator(T entity, Model model){
        return checkBeanValidator(entity,model);
    }

    protected boolean beanValidator(T entity, RedirectAttributes redirectAttributes){
        return checkBeanValidator(entity,redirectAttributes);
    }


    protected void addMessage(Model model, String message) {
        model.addAttribute("message", message);
    }

    protected void addMessage(RedirectAttributes redirectAttributes, String message) {
        redirectAttributes.addFlashAttribute("message", message);
    }


    /**
     * 检查bean
     */
    private boolean checkBeanValidator(T entity,Model model){
        String result = BeanValidator.validator(entity);
        //验证失败
        if (StringUtils.isNoneBlank(result)){
            //redirectAttributes
            if(model instanceof RedirectAttributes){
                RedirectAttributes redirectAttributes=(RedirectAttributes)model;
                addMessage(redirectAttributes,result);
            }
            //model
            else {
                addMessage(model,result);
            }
            return false;
        }
        //验证成功
        else {
            return true;
        }
    }
}
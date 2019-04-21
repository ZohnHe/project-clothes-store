package com.mgt.clothes.store.interceptor;

import com.mgt.clothes.store.entity.TbCustomer;
import com.mgt.clothes.store.entity.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/16 15:46
 * @Version 1.0
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //根据Session中有无User对象来判断是否登录
        boolean flag = true;
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute("tbUser");
        TbCustomer tbCustomer = (TbCustomer) httpServletRequest.getSession().getAttribute("tbCustomer");
        //为空则拦截跳转到登录页
        if (tbUser == null){
            httpServletResponse.sendRedirect("/user/login");
            flag = false;
        }
        //不为空则放行
        else {

            flag = true;
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //如果请求跳转登录页面
        if (modelAndView != null) {
            if(modelAndView.getViewName().endsWith("login")){
                //则重定向到首页不显示登录页
                httpServletResponse.sendRedirect("/admin/main");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

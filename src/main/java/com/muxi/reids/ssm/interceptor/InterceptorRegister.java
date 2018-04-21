package com.muxi.reids.ssm.interceptor;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description: 注册页面检测
 *   @Author: MuXi
 *   @create: 2018-04-17 15:05
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorRegister implements HandlerInterceptor {

    /**
     * Handler执行之前调用这个方法
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("1");
        return true;
    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("2");
    }

    /**
     * Handler执行完成之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("3");
    }
}

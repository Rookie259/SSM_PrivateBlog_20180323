package com.muxi.reids.ssm.controller;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-04-12 09:45
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class RouteController extends DispatcherServlet {

    private static final UrlPathHelper urlPathHelper = new UrlPathHelper();

    private String fileNotFondUrl_404 = "/Blog404.jsp";
    private String fileNotFondUrl_500 = "/Blog500.jsp";

    /*登录映射*/
    @RequestMapping(value = "si9780876")
    public String si9780876() {
        return "BlogLogin";
    }

    /*注册映射*/
    @RequestMapping(value = "rs9780876")
    public String rs978087() {
        return "BlogRegister";
    }

    /*首页映射*/
    @RequestMapping(value = "hp90880877")
    public String hp90880877() {
        return "/BlogHomePage";
    }

    /*博客映射*/
    @RequestMapping(value = "bo94670877")
    public String bo94670877() {
        return "BlogArticle";
    }

    /*心情随笔映射*/
    @RequestMapping(value = "ho94157877")
    public String ho94157877() {
        return "BlogHobby";
    }

    /*过往云烟映射*/
    @RequestMapping(value = "ph94190877")
    public String ph94190877() {
        return "BolgPhotos";
    }

    /*博客留言*/
    @RequestMapping(value = "le94190877")
    public String le94190877() {
        return "BlogLeaveNote";
    }

    /*关于我*/
    @RequestMapping(value = "me94000877")
    public String me94000877() {
        return "BlogAbout";
    }

    /*休闲一刻*/
    @RequestMapping(value = "ga94192577")
    public String ga94192577() {
        return "BlogMatchPanic";
    }

    /*博客详情*/
    @RequestMapping(value = "bodet94192577/{bid}")
    public String bodet94192577(@PathVariable(value = "bid") String bid) {
        return "/BlogView";
    }

    /*重写noHandlerFound*/
    @RequestMapping("*/*")
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (pageNotFoundLogger.isWarnEnabled()) {
            String requestUri = urlPathHelper.getRequestUri(request);
            pageNotFoundLogger.warn("No mapping found for HTTP request with URI [" + requestUri +
                    "] in DispatcherServlet with name '" + getServletName() + "'");
        }
        response.sendRedirect(request.getContextPath() + fileNotFondUrl_404);
    }

    @RequestMapping("*")
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        if (pageNotFoundLogger.isWarnEnabled()) {
            String requestUri = urlPathHelper.getRequestUri(request);
            pageNotFoundLogger.warn("No mapping found for HTTP request with URI [" + requestUri +
                    "] in DispatcherServlet with name '" + getServletName() + "'");
        }
        response.sendRedirect(request.getContextPath() + fileNotFondUrl_404);
    }



    @RequestMapping("errors/500")
    public String error500() {
        return fileNotFondUrl_500;
    }
}

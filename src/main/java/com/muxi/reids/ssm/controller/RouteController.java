package com.muxi.reids.ssm.controller;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-04-12 09:45
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RouteController {

    /*登录映射*/
    @RequestMapping(value = "si9780876.do")
    public String si9780876() {
        return "BlogLogin";
    }

    /*注册映射*/
    @RequestMapping(value = "rs9780876.do")
    public String rs978087() {
        return "BlogRegister";
    }

    /*首页映射*/
    @RequestMapping(value = "hp90880877.do")
    public String hp90880877() {
        return "BlogHomePage";
    }
    /*博客映射*/
    @RequestMapping(value = "bo94670877.do")
    public String bo94670877() {
        return "BlogArticle";
    }
    /*心情随笔映射*/
    @RequestMapping(value = "ho94157877.do")
    public String ho94157877() {
        return "BlogHobby";
    }
    /*过往云烟映射*/
    @RequestMapping(value = "ph94190877.do")
    public String ph94190877() {
        return "BolgPhotos";
    }
    /*留言映射*/
    @RequestMapping(value = "le94190877.do")
    public String le94190877() {
        return "BlogLeaveNote";
    }

    /*关于我*/
    @RequestMapping(value = "me94000877.do")
    public String me94000877() {
        return "BlogAbout";
    }

    /*休闲一刻*/
    @RequestMapping(value = "ga94192577.do")
    public String ga94192577() {
        return "BlogMatchPanic";
    }

    /*博客详情*/
    @RequestMapping(value = "bodet94192577.do")
    public String bodet94192577() {
        return "BlogView";
    }
}

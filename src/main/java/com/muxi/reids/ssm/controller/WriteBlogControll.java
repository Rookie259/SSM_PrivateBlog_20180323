package com.muxi.reids.ssm.controller;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-27 19:55
 */

import com.muxi.reids.ssm.entity.*;
import com.muxi.reids.ssm.services.AddInformationServices;
import com.muxi.reids.ssm.services.AlterInformationServices;
import com.muxi.reids.ssm.services.ReadInformationServices;
import com.muxi.reids.ssm.tool.commonTools.InCommonUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"commentInfoListSecondLikeState", "list_FirstLikeState", "label", "classify", "blogPreview", "blogLable", "topBlog", "dateBlog", "listLabel", "fullBlogText", "likeState", "recommendBlog", "baseComment", "doubleComment", "maxCommentCount","newSixBlog"})
@RequestMapping(value = "writeBlog")
public class WriteBlogControll {

    @Autowired
    private ReadInformationServices readInformationServices;

    @Autowired
    private AddInformationServices addInformationServices;

    @Autowired
    private AlterInformationServices alterInformationServices;

    @Autowired
    private InCommonUse inCommonUse;

    @RequestMapping(value = "/achieveLabel", method = RequestMethod.GET)
    public String readLabelAndClassify(ModelMap map) {
        List<List<String>> list = readInformationServices.readWriteLabelComment();
        map.addAttribute("label", list.get(0));
        map.addAttribute("classify", list.get(1));
        return "redirect:/BlogWriteArticle.jsp";
    }


    @RequestMapping(value = "/preview", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> publishPreviewArticle(HttpSession session, ModelMap modelMap, String title, String label, String classify, String text) {
        //获取当前登录用户
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        //根据分类获取对象
        ClassifyInfo classifyInfo = readInformationServices.readClassify(classify);
        //填充Blog对象
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setBcontent(text);
        blogInfo.setBtitle(title);
        blogInfo.setBlabel(label);
        blogInfo.setBtime(inCommonUse.achieveNowTime());
        blogInfo.setBstate("预览状态");
        blogInfo.setBuid(userInfo);
        blogInfo.setBclid(classifyInfo);
        //获取标签为List
        List<String> str_label = inCommonUse.splitStr(label, " ");
        //创建map
        Map<String, Object> map = new HashMap<String, Object>();
        //插入
        if (addInformationServices.addPreviewState(blogInfo)) {
            modelMap.addAttribute("blogLable", str_label);
            modelMap.addAttribute("blogPreview", blogInfo);
            map.put("issue", "success");
        } else
            map.put("issue", "error");
        return map;
    }


    //修改blog状态  正式发表
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> pulishBlog(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        BlogInfo blogInfo = (BlogInfo) session.getAttribute("blogPreview");
        blogInfo.setBstate("发布状态");
        if (alterInformationServices.alterBlogState(blogInfo))
            map.put("state", "success");
        else
            map.put("state", "error");
        return map;
    }


    //获取最新的10条blog
    @RequestMapping(value = "/achieveBlog", method = RequestMethod.GET)
    public String achieveTopFifteeBlog(ModelMap map) {
        List blog = readInformationServices.readTopFifteeBlog();
        //index 0 blog对象      index 1 Date对象
        List<BlogInfo> topBlog = (List<BlogInfo>) blog.get(0);
        List<SunDate> dateBlog = (List<SunDate>) blog.get(1);
        List<List<String>> list_label = (List<List<String>>) blog.get(2);
        /*评论量*/
        List<Integer> integerList = readInformationServices.readBlogByIdCommentMaxCount(topBlog);
        /*获取最新的六片文章*/
        List<BlogInfo> blogInfos = readInformationServices.readSixNewBlog();
        map.addAttribute("newSixBlog",blogInfos);
        map.addAttribute("topBlog", topBlog);
        map.addAttribute("maxCommentCount", integerList);
        map.addAttribute("dateBlog", dateBlog);
        map.addAttribute("listLabel", list_label);
        return "../BlogHomePage";
    }

    /*获取当前blog*/
    @RequestMapping(value = "/achieveFullText/{bid}", method = RequestMethod.GET)
    public String achieveFullText(@PathVariable(value = "bid") String bid, ModelMap modelMap, HttpSession session) throws UnknownHostException {
        Map<String, Object> map = new HashMap<String, Object>();
        BlogInfo blogInfo_1 = readInformationServices.readBlogById(bid);
        alterInformationServices.alterBlogBpageview(new Integer(blogInfo_1.getBpageview()) + 1, new Integer(bid));
        BlogInfo blogInfo_2 = readInformationServices.readBlogById(bid);
        //随机获取数据库 互不重复 且不与自身重复的 5条信息
        List<BlogInfo> recommendBlog_list = readInformationServices.readRepetitionBlogById(blogInfo_2);
        //存储推荐博客
        modelMap.addAttribute("recommendBlog", recommendBlog_list);
        /*获取根评论*/
        List<CommentInfo> commentInfo_list = readInformationServices.readBaseComment(bid);
        /*获取当前用户对当前评论点赞状态*/
        List<String> list_FirstLikeState = readInformationServices.readGetFirstLevelCommentThumbUpStatusList((UserInfo) session.getAttribute("user"),
                commentInfo_list);
        //获取ctargetid不为0的评论
        List<CommentInfo> list_ctargetid_noid = readInformationServices.readCommentInfoctargetidNoZero(new Integer(bid));
        List<String> commentInfoListSecondLikeState = readInformationServices.readGetFirstLevelCommentThumbUpStatusList((UserInfo) session.getAttribute("user"),
                list_ctargetid_noid);
        /*根评论存入session*/
        modelMap.addAttribute("baseComment", commentInfo_list);
        modelMap.addAttribute("commentInfoListSecondLikeState", commentInfoListSecondLikeState);
        modelMap.addAttribute("doubleComment", list_ctargetid_noid);
        modelMap.addAttribute("list_FirstLikeState", list_FirstLikeState);
        //查询当前用户对当前博客是否点赞  返回状态
        try {
            String ip = inCommonUse.getIpAddress();
            //查询当前ip是否存在当前博客id
            boolean state = readInformationServices.readLikeIsExist(ip, blogInfo_2);
            if (state)
                modelMap.addAttribute("likeState", "noExist");
            else
                modelMap.addAttribute("likeState", "exist");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (blogInfo_2 != null) {
            modelMap.addAttribute("fullBlogText", blogInfo_2);
        }
        return "../../BlogView";
    }


    /*博客jsp页面 获取所有blog*/
    @RequestMapping(value = "/achieveAllBlog", method = RequestMethod.GET)
    public String achieveAllBlog(ModelMap modelMap) {
        List<BlogInfo> list_blog_all = readInformationServices.readAllBlogTime("0","3");
        //index 0 blog对象      index 1 Date对象
        List<BlogInfo> topBlog = (List<BlogInfo>) list_blog_all.get(0);
        List<SunDate> dateBlog = (List<SunDate>) list_blog_all.get(1);
        List<List<String>> list_label = (List<List<String>>) list_blog_all.get(2);
        List<Integer> integerList = readInformationServices.readBlogByIdCommentMaxCount(topBlog);
        modelMap.addAttribute("maxCommentCount", integerList);
        modelMap.addAttribute("topBlog", topBlog);
        modelMap.addAttribute("dateBlog", dateBlog);
        modelMap.addAttribute("listLabel", list_label);
        return "../BlogArticle";
    }


    @RequestMapping(value = "/achieveMoreBlog", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<Object>> achieveMachBlog(String begin,ModelMap modelMap) {
        List<Object> list = new ArrayList<Object>();
        Map<String, List<Object>> map = new HashMap<String, List<Object>>();
        /*计算begin end*/
        String end = (new Integer(begin)+10)+"";
        List<BlogInfo> list_blog_all = readInformationServices.readAllBlogTime(begin,end);
        //index 0 blog对象      index 1 Date对象
        List<BlogInfo> topBlog = (List<BlogInfo>) list_blog_all.get(0);
        List<SunDate> dateBlog = (List<SunDate>) list_blog_all.get(1);
        List<List<String>> list_label = (List<List<String>>) list_blog_all.get(2);
        List<Integer> integerList = readInformationServices.readBlogByIdCommentMaxCount(topBlog);
        list.add(integerList);
        list.add(topBlog);
        list.add(dateBlog);
        list.add(list_label);
        map.put("machBlog",list);
        return map;
    }


    public void setReadInformationServices(ReadInformationServices readInformationServices) {
        this.readInformationServices = readInformationServices;
    }

    public void setAddInformationServices(AddInformationServices addInformationServices) {
        this.addInformationServices = addInformationServices;
    }

    public void setAlterInformationServices(AlterInformationServices alterInformationServices) {
        this.alterInformationServices = alterInformationServices;
    }

}

package com.muxi.reids.ssm.controller;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-04-10 15:55
 */

import com.muxi.reids.ssm.entity.BlogInfo;
import com.muxi.reids.ssm.entity.CommentInfo;
import com.muxi.reids.ssm.entity.LeaveNoteInfo;
import com.muxi.reids.ssm.entity.UserInfo;
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
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "note")
@SessionAttributes({"allLeaveNote","newSixBlog","recommendBlog","recommendBlog","baseComment","doubleComment","likeState","fullBlogText"})
public class LeaveNoteController  {
    @Autowired
    private ReadInformationServices readInformationServices;

    @Autowired
    private AddInformationServices addInformationServices;

    @Autowired
    private AlterInformationServices alterInformationServices;

    @Autowired
    private InCommonUse inCommonUse;

    /*博客留言*/
    @RequestMapping(value = "/leaveNote")
    @ResponseBody
    public Map<String,Object> leaveNote(String text, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        LeaveNoteInfo leaveNoteInfo = new LeaveNoteInfo();
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("user");
        if (userInfo != null) {
            leaveNoteInfo.setLnname(userInfo.getuNickName());
            leaveNoteInfo.setLntext(text);
            leaveNoteInfo.setLnaddress("["+readInformationServices.achieveNowAddressByGeoIP()+"]");
            leaveNoteInfo.setLntime(inCommonUse.achieveNowTime());
            addInformationServices.addLeaveNote(leaveNoteInfo);
            map.put("leaveNoteAddress",leaveNoteInfo);
        } else {
            try {
                leaveNoteInfo.setLnname("游客" + inCommonUse.getIpAddress());
                leaveNoteInfo.setLntext(text);
                leaveNoteInfo.setLnaddress("["+readInformationServices.achieveNowAddressByGeoIP()+"]");
                leaveNoteInfo.setLntime(inCommonUse.achieveNowTime());
                addInformationServices.addLeaveNote(leaveNoteInfo);
                map.put("leaveNoteAddress",leaveNoteInfo);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return map;
    }


    /*获取所有留言 以及 最新的6篇文章*/
    @RequestMapping(value = "/achieveAllNote", method = RequestMethod.GET)
    public String achieveBlogLeaveNote(ModelMap modelMap){
        List<LeaveNoteInfo> leaveNoteInfoList = readInformationServices.readAllLeaveNote();
        modelMap.addAttribute("allLeaveNote",leaveNoteInfoList);
        /*获取最新的六片文章*/
        List<BlogInfo> blogInfos = readInformationServices.readSixNewBlog();
        modelMap.addAttribute("newSixBlog",blogInfos);
        return "../BlogLeaveNote";
    }


    /*获取点击的最新文章详细内容*/
    @RequestMapping(value = "/achieveNewArticle")
    public String achieveBlogArticle(ModelMap modelMap,String blogId){
        BlogInfo blogInfo_1 = readInformationServices.readBlogById(blogId);
        alterInformationServices.alterBlogBpageview(new Integer(blogInfo_1.getBpageview()) + 1, new Integer(blogId));
        BlogInfo blogInfo_2 = readInformationServices.readBlogById(blogId);
        //随机获取数据库 互不重复 且不与自身重复的 5条信息
        List<BlogInfo> recommendBlog_list = readInformationServices.readRepetitionBlogById(blogInfo_2);
        //存储推荐博客
        modelMap.addAttribute("recommendBlog", recommendBlog_list);
        /*获取根评论*/
        List<CommentInfo> commentInfo_list = readInformationServices.readBaseComment(blogId);
        /*根评论存入session*/
        modelMap.addAttribute("baseComment", commentInfo_list);
        /*楼中楼待定*/
        //TODO
        /*目前只获取楼中楼一楼*/
        /*---------------------------------------------------*/
        //获取ctargetid不为0的评论
        List<CommentInfo> list_ctargetid_noid = readInformationServices.readCommentInfoctargetidNoZero(new Integer(blogId));
        modelMap.put("doubleComment",list_ctargetid_noid);
        /*---------------------------------------------------*/
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
         return "../BlogView";
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

    public void setInCommonUse(InCommonUse inCommonUse) {
        this.inCommonUse = inCommonUse;
    }
}

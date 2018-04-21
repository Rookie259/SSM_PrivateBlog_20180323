package com.muxi.reids.ssm.controller;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-29 10:30
 */

import com.muxi.reids.ssm.entity.BlogInfo;
import com.muxi.reids.ssm.entity.CommentInfo;
import com.muxi.reids.ssm.entity.UserInfo;
import com.muxi.reids.ssm.services.AddInformationServices;
import com.muxi.reids.ssm.services.AlterInformationServices;
import com.muxi.reids.ssm.services.ReadInformationServices;
import com.muxi.reids.ssm.tool.commonTools.InCommonUse;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "writeComment")
public class WriteCommentController {

    @Autowired
    private ReadInformationServices readInformationServices;

    @Autowired
    private AddInformationServices addInformationServices;

    @Autowired
    private AlterInformationServices alterInformationServices;

    @Autowired
    private InCommonUse inCommonUse;


    /*文章点赞*/
    @RequestMapping(value = "writeLike")
    @ResponseBody
    public Map<String, Object> checkWriteLike(Model model, String bid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //获取当前ip
            String ip = inCommonUse.getIpAddress();
            //获取当前博客
            BlogInfo blogInfo = readInformationServices.readBlogById(bid);
            //查询当前ip是否存在当前博客id
            boolean state = readInformationServices.readLikeIsExist(ip, blogInfo);
            if (state) {
                //如果不存在  插入
                addInformationServices.addBlogLike(ip, new Integer(blogInfo.getBid()));
                //并修改blog的点赞量
                alterInformationServices.alterBlogLikeCount(new Integer(new Integer(blogInfo.getBlike()) + 1), new Integer(blogInfo.getBid()));
                map.put("likeState", "noExist");
            } else
                map.put("likeState", "exist");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return map;
    }


    /*获取当前用户ip地址  返回昵称*/
    @RequestMapping(value = "achieveNickName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> achieveNowNickName() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String nowIp = inCommonUse.getIpAddress();
            String nickname = "游客" + nowIp;
            List<String> str_list = inCommonUse.splitStr(nickname, "\\.");
            String result = "";
            for (String s :
                    str_list) {
                result += s;
            }
            map.put("nickname", result);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return map;
    }


    /*发送根评论 0*/
    @RequestMapping(value = "sendZeroComment", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendComment(String id, String nickname, String text, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        String nowTime = inCommonUse.achieveNowTime();
        BlogInfo blogInfo = (BlogInfo) session.getAttribute("fullBlogText");
        if (addInformationServices.addBaseComment(nickname, text, nowTime, id) &&  alterInformationServices.blogCommentCountPlusOne(blogInfo, id)) {
            map.put("addBaseComment", "success");
        } else
            map.put("addBaseComment", "error");
        return map;
    }

    /*局部刷新评论区*/
    @RequestMapping(value = "/achieveLocalitycomment", method = RequestMethod.POST)
    @ResponseBody
    public void achieveLocalitycomment(ModelMap modelMap, String bid) {
        /*获取根评论*/
        List<CommentInfo> commentInfo_list = readInformationServices.readBaseComment(bid);
        /*根评论存入session*/
        modelMap.addAttribute("baseComment", commentInfo_list);
        List<CommentInfo> list_ctargetid_noid = readInformationServices.readCommentInfoctargetidNoZero(new Integer(bid));
        modelMap.put("doubleComment", list_ctargetid_noid);
    }


    /*楼中楼回复评论*/
    @RequestMapping(value = "doubleDeck", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> doubleDeckComment(String text, String reply, String bid, String baseCommentId,HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        /*插入楼中楼子评论*/
        /*当前博客评论量加一*/
        BlogInfo blogInfo = (BlogInfo) session.getAttribute("fullBlogText");
        if (addInformationServices.addCommentDoubleDeck(text, reply, bid, baseCommentId)  &&  alterInformationServices.blogCommentCountPlusOne(blogInfo, bid)) {
            map.put("doubleDeckState", "success");
        } else
            map.put("doubleDeckState", "error");
        return map;
    }

    /*一楼点赞记录*/
    @RequestMapping(value = "achieveFirstFloorLike", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> achieveFirstFloorLike(String bid, String cid, ModelMap modelMap, HttpSession session) {
        /*游客名称*/
        String nowIp = null;
        try {
            nowIp = inCommonUse.getIpAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String nickname = "游客" + nowIp;
        Map<String, Object> map = new HashMap<String, Object>();
        /*查询是否存在点赞记录*/
        /*获取当前人的ip地址*/
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        if (readInformationServices.readBlogAchieveLikeIsExist(userInfo, nickname, bid, cid))
            map.put("addFirstFloorLikeState", "noExist");
        else
            map.put("addFirstFloorLikeState", "exist");
        return map;
    }


    /*博客详细页面初始化获取当前用户*/
    @RequestMapping(value = "InitializationUser")
    @ResponseBody
    public Map<String, Object> achieveInitializationUser(HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("user");
        map.put("initializationUserInfo", userInfo);
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

    public void setInCommonUse(InCommonUse inCommonUse) {
        this.inCommonUse = inCommonUse;
    }
}

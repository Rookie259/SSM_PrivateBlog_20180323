package com.muxi.reids.ssm.services.impl;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-23 08:39
 */


import com.muxi.reids.ssm.dao.AddInformationInterfaces;
import com.muxi.reids.ssm.dao.ReadInformationInterfaces;
import com.muxi.reids.ssm.entity.BlogInfo;
import com.muxi.reids.ssm.entity.CommentInfo;
import com.muxi.reids.ssm.entity.UserInfo;
import com.muxi.reids.ssm.services.AddInformationServices;
import com.muxi.reids.ssm.tool.Eamil.EamilTool;
import com.muxi.reids.ssm.tool.commonTools.InCommonUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.UnknownHostException;

@Service("addInformationServices")
public class AddInforamteionImpl implements AddInformationServices {

    @Autowired
    private AddInformationInterfaces addInformationInterfaces;

    @Autowired
    private ReadInformationInterfaces readInformationInterfaces;

    @Autowired
    private InCommonUse inCommonUse;

    public boolean addUserInfo(UserInfo userInfo) {
        boolean flag = false;
        try {
            addInformationInterfaces.addUser(userInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addPreviewState(BlogInfo blogInfo) {
        try {
            addInformationInterfaces.addPreviewState(blogInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void addBlogLike(String ip, Integer bid) {
        addInformationInterfaces.addBlogLike(ip, bid);
    }

    public boolean addEssay(String content, String time) {
        try {
            addInformationInterfaces.addEssay(content, time);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addBaseComment(String nickname, String text, String time, String id) {
        try {
            addInformationInterfaces.addBaseComment(nickname, text, time, new Integer(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addCommentDoubleDeck(String text, String reply, String id, String baseCommentId) {
        CommentInfo commentInfo = new CommentInfo();
        String nowAddress = reply;
        try {
            String address = inCommonUse.getIpAddress();
            for (int i = 0; i < reply.length(); i++) {
                if (reply.charAt(i) == '.') {
                    nowAddress = inCommonUse.splitStrReturnStr(address, "\\.");
                    break;
                }
            }
            System.out.println(reply);
            System.out.println(text);
            System.out.println(id);
            System.out.println(baseCommentId);
            commentInfo.setCnickname(nowAddress);
            commentInfo.setCtext(text);
            commentInfo.setCtime(inCommonUse.achieveNowTime());
            commentInfo.setClike(0);
            commentInfo.setCbid(readInformationInterfaces.readBlogById(new Integer(id)));
            CommentInfo commentInfo1 = readInformationInterfaces.readCommentByCNickname(new Integer(baseCommentId));
            commentInfo.setCtargetid(commentInfo1);
            commentInfo.setCnote("1");
            commentInfo.setCcheckcomment(new Integer(baseCommentId));
            System.out.println("-------------------------------------------");
            System.out.println(commentInfo.toString());
            System.out.println("-------------------------------------------");
            addInformationInterfaces.addDoubleDeckComment(commentInfo);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addLeaveNote() {
        return false;
    }

    public void setAddInformationInterfaces(AddInformationInterfaces addInformationInterfaces) {
        this.addInformationInterfaces = addInformationInterfaces;
    }

    public void setInCommonUse(InCommonUse inCommonUse) {
        this.inCommonUse = inCommonUse;
    }

    public void setReadInformationInterfaces(ReadInformationInterfaces readInformationInterfaces) {
        this.readInformationInterfaces = readInformationInterfaces;
    }
}

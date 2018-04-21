package com.muxi.reids.ssm.services.impl;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-28 14:39
 */

import com.muxi.reids.ssm.dao.AlterInformateionInterfaces;
import com.muxi.reids.ssm.entity.BlogInfo;
import com.muxi.reids.ssm.services.AlterInformationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("alterInformationServices")
public class AlterInfomationImpl implements AlterInformationServices {

    @Autowired
    private AlterInformateionInterfaces alterInformateionInterfaces;


    public boolean alterBlogState(BlogInfo blogInfo) {
        try {
            alterInformateionInterfaces.alterBlogState(blogInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void alterBlogBpageview(Integer count, Integer bid) {
        alterInformateionInterfaces.alterBlogBpageview(count, bid);
    }

    public void alterBlogLikeCount(Integer count, Integer bid) {
        alterInformateionInterfaces.alterBlogLikeCount(count, bid);
    }

    public boolean blogCommentCountPlusOne(BlogInfo blogInfo, String id) {
        try {
            alterInformateionInterfaces.nowBlogCommentPlusOne( new Integer(blogInfo.getBcommentcount() + 1),new Integer(id));
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    public void setAlterInformateionInterfaces(AlterInformateionInterfaces alterInformateionInterfaces) {
        this.alterInformateionInterfaces = alterInformateionInterfaces;
    }
}

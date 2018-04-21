package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description: 点赞表
 *   @Author: MuXi
 *   @create: 2018-03-29 10:13
 */

import java.io.Serializable;

public class LikeInfo implements Serializable {

    private Integer lid;                 //id
    private String lip;                  //ip
    private BlogInfo lbid;              //关联博客
    private Integer lastate;            //文章评论标识  0 文章  1评论  2子评论
    private CommentInfo lcid;           //关联评论目标id


    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public void setLip(String lip) {
        this.lip = lip;
    }

    public void setLbid(BlogInfo lbid) {
        this.lbid = lbid;
    }

    public Integer getLid() {

        return lid;
    }

    public String getLip() {
        return lip;
    }

    public BlogInfo getLbid() {
        return lbid;
    }

    public void setLastate(Integer lastate) {
        this.lastate = lastate;
    }

    public void setLcid(CommentInfo lcid) {
        this.lcid = lcid;
    }

    public Integer getLastate() {

        return lastate;
    }

    public CommentInfo getLcid() {
        return lcid;
    }
}

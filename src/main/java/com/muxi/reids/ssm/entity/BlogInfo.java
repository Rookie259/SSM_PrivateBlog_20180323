package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-27 20:00
 */

import java.io.Serializable;

public class BlogInfo implements Serializable {


    private Integer bid;                //id
    private String btitle;              //blog标题
    private String bcontent;            //文章内容
    private String btime;               //发表时间
    private String bpageview;           //浏览量
    private String blabel;              //标签
    private String bstate;              //状态
    private Integer blike;              //点赞量
    private Integer bcommentcount;      //评论量
    private UserInfo buid;              //关联发帖用户
    private ClassifyInfo bclid;         //关联分类表


    public void setBlike(Integer blike) {
        this.blike = blike;
    }

    public Integer getBlike() {

        return blike;
    }

    public void setBcommentcount(Integer bcommentcount) {
        this.bcommentcount = bcommentcount;
    }

    public Integer getBcommentcount() {

        return bcommentcount;
    }

    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {

        this.bstate = bstate;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public void setBpageview(String bpageview) {
        this.bpageview = bpageview;
    }

    public void setBlabel(String blabel) {
        this.blabel = blabel;
    }

    public void setBuid(UserInfo buid) {
        this.buid = buid;
    }

    public void setBclid(ClassifyInfo bclid) {
        this.bclid = bclid;
    }

    public Integer getBid() {

        return bid;
    }

    public String getBtitle() {
        return btitle;
    }

    public String getBcontent() {
        return bcontent;
    }

    public String getBtime() {
        return btime;
    }

    public String getBpageview() {
        return bpageview;
    }

    public String getBlabel() {
        return blabel;
    }

    public UserInfo getBuid() {
        return buid;
    }

    public ClassifyInfo getBclid() {
        return bclid;
    }

    @Override
    public String toString() {
        return "BlogInfo{" +
                "bid=" + bid +
                ", btitle='" + btitle + '\'' +
                ", bcontent='" + bcontent + '\'' +
                ", btime='" + btime + '\'' +
                ", bpageview='" + bpageview + '\'' +
                ", blabel='" + blabel + '\'' +
                ", bstate='" + bstate + '\'' +
                ", blike=" + blike +
                ", bcommentcount=" + bcommentcount +
                ", buid=" + buid +
                ", bclid=" + bclid +
                '}';
    }
}

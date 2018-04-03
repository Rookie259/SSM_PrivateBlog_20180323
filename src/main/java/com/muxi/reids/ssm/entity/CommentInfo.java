package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-27 20:02
 */

import java.io.Serializable;

public class CommentInfo implements Serializable {

    private Integer cid;             //id
    private String cnickname;        //评论昵称
    private String ctext;            //评论内容
    private String ctime;            //评论时间
    private Integer clike;           //点赞量
    private BlogInfo cbid;           //关联帖子
    private CommentInfo ctargetid;   //评论目标用户id
    private String cnote;            //评论节点  默认为零 0  为一楼  楼中楼回复一楼 节点为1  回复1为2 依次循环 按评论id排序
    private Integer ccheckcomment;   //判断是拿一个主楼

    public void setCtext(String ctext) {
        this.ctext = ctext;
    }

    public String getCtext() {

        return ctext;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setCnickname(String cnickname) {
        this.cnickname = cnickname;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public void setClike(Integer clike) {
        this.clike = clike;
    }

    public void setCbid(BlogInfo cbid) {
        this.cbid = cbid;
    }

    public void setCtargetid(CommentInfo ctargetid) {
        this.ctargetid = ctargetid;
    }

    public Integer getCid() {

        return cid;
    }

    public String getCnickname() {
        return cnickname;
    }

    public String getCtime() {
        return ctime;
    }

    public Integer getClike() {
        return clike;
    }

    public BlogInfo getCbid() {
        return cbid;
    }

    public CommentInfo getCtargetid() {
        return ctargetid;
    }

    public void setCnote(String cnote) {
        this.cnote = cnote;
    }

    public String getCnote() {

        return cnote;
    }

    public void setCcheckcomment(Integer ccheckcomment) {
        this.ccheckcomment = ccheckcomment;
    }

    public Integer getCcheckcomment() {

        return ccheckcomment;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "cid=" + cid +
                ", cnickname='" + cnickname + '\'' +
                ", ctext='" + ctext + '\'' +
                ", ctime='" + ctime + '\'' +
                ", clike=" + clike +
                ", cbid=" + cbid +
                ", ctargetid=" + ctargetid +
                ", cnote='" + cnote + '\'' +
                ", ccheckcomment=" + ccheckcomment +
                '}';
    }
}

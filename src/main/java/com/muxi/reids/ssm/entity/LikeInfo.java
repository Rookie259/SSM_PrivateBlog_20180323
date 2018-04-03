package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description: 点赞表
 *   @Author: MuXi
 *   @create: 2018-03-29 10:13
 */

import java.io.Serializable;

public class LikeInfo implements Serializable {

    private Integer lid;              //id
    private String lip;              //ip
    private BlogInfo lbid;           //关联博客


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

    @Override
    public String toString() {
        return "LikeInfo{" +
                "lid=" + lid +
                ", lip='" + lip + '\'' +
                ", lbid=" + lbid +
                '}';
    }
}

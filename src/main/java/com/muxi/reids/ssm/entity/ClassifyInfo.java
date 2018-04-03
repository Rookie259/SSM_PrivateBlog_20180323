package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-27 19:59
 */

import java.io.Serializable;

public class ClassifyInfo implements Serializable{

    private Integer clid;                   //id
    private String clcomment;               //分类内容


    public void setClid(Integer clid) {
        this.clid = clid;
    }

    public void setClcomment(String clcomment) {
        this.clcomment = clcomment;
    }

    public Integer getClid() {

        return clid;
    }

    public String getClcomment() {
        return clcomment;
    }

    @Override
    public String toString() {
        return "ClassifyInfo{" +
                "clid=" + clid +
                ", clcomment='" + clcomment + '\'' +
                '}';
    }
}

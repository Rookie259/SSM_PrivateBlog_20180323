package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-27 19:58
 */

import java.io.Serializable;

public class LabelInfo implements Serializable{

    private Integer laid;                 //id
    private String lacomment;             //标签内容




    public void setLacomment(String lacomment) {
        this.lacomment = lacomment;
    }

    public void setLaid(Integer laid) {

        this.laid = laid;
    }

    public Integer getLaid() {

        return laid;
    }

    public String getLacomment() {
        return lacomment;
    }

    @Override
    public String toString() {
        return "LabelInfo{" +
                "laid=" + laid +
                ", lacomment='" + lacomment + '\'' +
                '}';
    }
}

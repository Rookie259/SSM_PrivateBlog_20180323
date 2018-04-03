package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-27 20:06
 */

import java.io.Serializable;

public class PhotoInfo implements Serializable {

    private Integer pid;            //id
    private String purl;            //图片上传阿里云后的url


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getPurl() {

        return purl;
    }

    @Override
    public String toString() {
        return "PhotoInfo{" +
                "pid=" + pid +
                ", purl='" + purl + '\'' +
                '}';
    }
}

package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-30 10:30
 */

import java.io.Serializable;

public class EssayInfo implements Serializable {
    private Integer eid;
    private String ehobby;                  //内容
    private String etime;                   //添加时间


    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public void setEhobby(String ehobby) {
        this.ehobby = ehobby;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public Integer getEid() {

        return eid;
    }

    public String getEhobby() {
        return ehobby;
    }

    public String getEtime() {
        return etime;
    }

    @Override
    public String toString() {
        return "EssayInfo{" +
                "eid=" + eid +
                ", ehobby='" + ehobby + '\'' +
                ", etime='" + etime + '\'' +
                '}';
    }
}

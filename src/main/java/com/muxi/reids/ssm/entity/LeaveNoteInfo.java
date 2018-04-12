package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-04-10 16:13
 */

public class LeaveNoteInfo {
    private Integer lnid;
    private String lnname;
    private String lnaddress;
    private String lntime;
    private String lnstate;


    @Override
    public String toString() {
        return "LeaveNoteInfo{" +
                "lnid=" + lnid +
                ", lnname='" + lnname + '\'' +
                ", lnaddress='" + lnaddress + '\'' +
                ", lntime='" + lntime + '\'' +
                ", lnstate='" + lnstate + '\'' +
                '}';
    }

    public void setLnid(Integer lnid) {
        this.lnid = lnid;
    }

    public void setLnname(String lnname) {
        this.lnname = lnname;
    }

    public void setLnaddress(String lnaddress) {
        this.lnaddress = lnaddress;
    }

    public void setLntime(String lntime) {
        this.lntime = lntime;
    }

    public void setLnstate(String lnstate) {
        this.lnstate = lnstate;
    }

    public Integer getLnid() {

        return lnid;
    }

    public String getLnname() {
        return lnname;
    }

    public String getLnaddress() {
        return lnaddress;
    }

    public String getLntime() {
        return lntime;
    }

    public String getLnstate() {
        return lnstate;
    }
}

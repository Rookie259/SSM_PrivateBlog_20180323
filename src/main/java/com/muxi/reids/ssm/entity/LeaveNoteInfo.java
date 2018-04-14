package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-04-10 16:13
 */

public class LeaveNoteInfo {
    private Integer lnid;
    private String lnname;
    private String lntext;
    private String lnaddress;
    private String lntime;
    private String lnstate;


    @Override
    public String toString() {
        return "LeaveNoteInfo{" +
                "lnid=" + lnid +
                ", lnname='" + lnname + '\'' +
                ", lntext='" + lntext + '\'' +
                ", lnaddress='" + lnaddress + '\'' +
                ", lntime='" + lntime + '\'' +
                ", lnstate='" + lnstate + '\'' +
                '}';
    }

    public void setLntext(String lntext) {
        this.lntext = lntext;
    }

    public String getLntext() {

        return lntext;
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

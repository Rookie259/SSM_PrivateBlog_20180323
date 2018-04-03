package com.muxi.reids.ssm.entity;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-22 10:03
 */

import java.io.Serializable;

public class UserInfo implements Serializable{
    private Integer uid;
    private String uNickName;
    private String uPassword;
    private String uSex;
    private String uEamil;
    private String uPhone;
    private String uTime;
    private String uState;


    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {

        return uid;
    }

    public void setuNickName(String uNickName) {
        this.uNickName = uNickName;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public void setuEamil(String uEamil) {
        this.uEamil = uEamil;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public void setuTime(String uTime) {
        this.uTime = uTime;
    }

    public void setuState(String uState) {
        this.uState = uState;
    }


    public String getuNickName() {
        return uNickName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public String getuSex() {
        return uSex;
    }

    public String getuEamil() {
        return uEamil;
    }

    public String getuPhone() {
        return uPhone;
    }

    public String getuTime() {
        return uTime;
    }

    public String getuState() {
        return uState;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", uNickName='" + uNickName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uEamil='" + uEamil + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uTime='" + uTime + '\'' +
                ", uState='" + uState + '\'' +
                '}';
    }
}

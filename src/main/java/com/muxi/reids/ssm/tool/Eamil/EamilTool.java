package com.muxi.reids.ssm.tool.Eamil;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-22 14:57
 */

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.text.SimpleDateFormat;
import java.util.*;

public class EamilTool {

    /*获取随机数字*/
    public String achieveCode() {
        String[] beforeShuffle = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
                "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z"};
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(5, 9);
        return result;
    }

    /*获取上下午时间*/
    public String achieveAmOrPm() {
        GregorianCalendar ca = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (ca.get(GregorianCalendar.AM_PM) == 0) {
            return "上午好 " + df.format(new Date());
        } else {
            return "下午好" + df.format(new Date());
        }
    }

    /*获取当前系统时间*/
    public String achieveNowTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String nowTime = df.format(new Date());                                 // new Date()为获取当前系统时间
        return nowTime;
    }

    /*发送验证吗*/
    public String sendCode(String eamil) {
        String resultCode = achieveCode();
        HtmlEmail send = new HtmlEmail();
        try {
            send.setHostName("smtp.qq.com");
            send.setSmtpPort(465);
            send.setSSLOnConnect(true);
            send.setCharset("utf-8");
            send.addTo(eamil);
            send.setFrom("1944851536@qq.com", "沐惜");
            send.setAuthentication("1944851536@qq.com", "ifrtjywtbacoehii");
            send.setSubject(achieveAmOrPm() + ",欢迎加入Blog博客系统,我们会为您更优质的服务!");
            send.setMsg("您的验证码为   " + resultCode);
            send.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return resultCode;
    }

}

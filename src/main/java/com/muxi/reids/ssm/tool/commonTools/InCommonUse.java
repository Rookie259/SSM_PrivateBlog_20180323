package com.muxi.reids.ssm.tool.commonTools;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-28 09:57
 */

import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

@Component
public class InCommonUse {


    //分割 index:0 = 字符串  index:1 = 分隔符
    public List<String> splitStr(String str, String symbol) {
        String[] array = str.split(symbol);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    //取值   index : 0 = 字符串    index : 1 = 左字符   index : 2 = 右字符
    public String bracketsByValue(String str, char str1, char str2) {
        int m = 0, n = 0, count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str1) {
                m = i;
                break;
            }
            // 2018-03-28
        }
        for (int j = m + 1; j < str.length(); j++) {
            if (str.charAt(j) == str2) {
                n = j;
                return str.substring(m + 1, n).trim();
            }
        }

        return str;
    }


    //判断str是否含有 ch1 and ch2
    public boolean checkPairingBracket(String str, char ch1, char ch2) {
        Stack<Character> sc = new Stack<Character>();
        char[] c = str.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == ch1) {
                sc.push(c[i]);
            } else if (c[i] == ch2) {
                if (sc.peek() == ch1) {
                    sc.pop();
                }
            }
        }
        if (sc.empty()) {
            return true;
        } else {
            return false;
        }
    }

    //排序
    public Integer[] insertSort(Integer[] v) {
        for (int i = 1; i < v.length; i++) {
            int key = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > key) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = key;
        }
        return v;
    }


    //获取系统当前时间
    public String achieveNowTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String nowTime = df.format(new Date());                                 // new Date()为获取当前系统时间
        return nowTime;
    }


    //截断字符串 获取字符串前 60 个char
    public String achieveFontStr(String str) {
        String str_result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i < 180) {
                str_result += str.charAt(i);
            }
        }
        return str_result;
    }

    //剔除HTML标签
    public String StripHT(String strHtml) {
        String txtcontent = strHtml.replaceAll("</?[^>]+>", ""); //剔出<html>的标签
        txtcontent = txtcontent.replaceAll("<a>\\s*|\t|\r|\n</a>", "");//去除字符串中的空格,回车,换行符,制表符
        return txtcontent;
    }

    /*获取当前ip*/
    public String getIpAddress() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        return address.getHostAddress();
    }

    /*分割字符串*/
    public String splitStrReturnStr(String str, String sp) {
        String[] str_arr = str.split(sp);
        String result = "";
        for (String s :
                str_arr) {
            result += s;
        }
        return result;
    }

}

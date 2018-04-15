package com.muxi.reids.ssm.tool.MD5;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-04-15 19:11
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_Password {

    public String getMD5(String str) throws NoSuchAlgorithmException {
        /*
         *  1.获取MD5对象 通过"信息摘要"获取实例构造（"MD5"）
         *  2.MD5对象对("字符串的" 字节形式得到数组) 进行摘要,则返回值为摘要数组
         *  3.摘要字节数组中的"每个二进制的值"字节形式,"转换为十六进制形式" 然后把这些信息拼接起来,就是MD5的值
         * */
        String MD5 = "";
        MessageDigest md5 = null;
        md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes();
        byte[] digest = md5.digest(bytes);


        for (int i = 0; i < digest.length; i++) {
            //摘要字节数组中各个字节的"十六进制"形式.
            int j = digest[i];
            j = j & 0x000000ff;
            String s1 = Integer.toHexString(j);

            if (s1.length() == 1) {
                s1 = "0" + s1;
            }
            MD5 += s1;
        }
        return MD5;
    }

    /*重载  进行问价MD5加密*/
    public static String getMD5(File file) throws NoSuchAlgorithmException, IOException {
        String MD5 = "";

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        FileInputStream fis = new FileInputStream(file);

        byte[] bytes = new byte[1024 * 5];

        int len = -1;
        while ((len = fis.read(bytes)) != -1) {
            //一部分一部分更新
            md5.update(bytes, 0, len);
        }
        byte[] digest = md5.digest();
        for (int i = 0; i < digest.length; i++) {
            int n = digest[i] & 0x000000ff;
            String s = Integer.toHexString(n);

            MD5 += s;
        }
        return MD5;
    }
}

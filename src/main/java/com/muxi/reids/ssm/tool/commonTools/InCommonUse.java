package com.muxi.reids.ssm.tool.commonTools;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-28 09:57
 */

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Subdivision;
import me.hupeng.ipLocationService.IpLocationResult;
import me.hupeng.ipLocationService.IpLocationService;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /*根据ip获取当前地理位置*/
    public Map<String, Object> achieveCiteByUserIP(String userIP) {
        IpLocationService ipLocationService = new IpLocationService();
        IpLocationResult ipLocationResult = ipLocationService.getIpLocationResult(userIP);
        String country = ipLocationResult.getCountry();
        String province = ipLocationResult.getProvince();
        String cite = ipLocationResult.getCity();
        Map<String, Object> map = new HashMap<String, Object>();
        if (country == null || "".equals(country)) {
            map.put("country", "未知");
        } else
            map.put("country", country);
        if (province == null || "".equals(province)) {
            map.put("province", "未知");
        } else
            map.put("province", province);
        if (cite == null || "".equals(cite)) {
            map.put("cite", "未知");
        } else
            map.put("cite", cite);
        if (map.get("province").equals("未知") && map.get("cite").equals("未知")) {
            map.put("provinceCite", "未知");
        } else {
            map.put("provinceCite", province + " " + cite);
        }
        return map;
    }


    /*使用GeoIP的数据库查询当前ip所对应的当前地址*/
    public List<Map<String,String>> achieveAddressByGeoIP(String ip){
        List<Map<String,String>> mapList = new ArrayList<Map<String, String>>();
        Map<String,String> map_province = new HashMap<String, String>();
        Map<String,String> map_city = new HashMap<String, String>();
        try {
            File database = ResourceUtils.getFile("classpath:address/GeoLite2-City.mmdb");
            // 创建 GeoLite2 数据库
            DatabaseReader reader = new DatabaseReader.Builder(database).build();
            // 读取数据库内容
            InCommonUse inCommonUse = new InCommonUse();
            InetAddress ipAddress = InetAddress.getByName(inCommonUse.getIpAddress());
            // 获取查询结果
            CityResponse response = reader.city(ipAddress);


            // 获取国家信息
            Country country = response.getCountry();
            System.out.println(country.getNames().get("zh-CN"));    // '中国'


            // 获取省份
            Subdivision subdivision = response.getMostSpecificSubdivision();
            System.out.println(subdivision.getNames().get("zh-CN")); // '广西壮族自治区'
            //Map添加省份
            map_province.put("province",subdivision.getNames().get("zh-CN"));

            // 获取城市
            City city = response.getCity();
            System.out.println(city.getNames().get("zh-CN")); // '南宁'
            map_city.put("city",city.getNames().get("zh-CN"));
            Location location = response.getLocation();
            mapList.add(map_province);
            mapList.add(map_city);
        } catch (IOException e) {
            System.out.println("进来了1");
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            /*检测不到在进来这里*/
            return null;
        }
        return mapList;
    }


}

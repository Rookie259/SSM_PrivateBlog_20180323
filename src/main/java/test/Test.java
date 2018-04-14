package test;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-04-13 15:57
 */

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;
import com.muxi.reids.ssm.tool.commonTools.InCommonUse;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class Test {
    public static void main(String[] args) {
        try {
            File database = ResourceUtils.getFile("classpath:address/GeoLite2-City.mmdb");
            // 创建 GeoLite2 数据库
            DatabaseReader reader = new DatabaseReader.Builder(database).build();
            // 读取数据库内容
            InCommonUse inCommonUse = new InCommonUse();
            InetAddress ipAddress = InetAddress.getByName("171.108.233.157");
            // 获取查询结果
            CityResponse response = reader.city(ipAddress);
            // 获取国家信息
            Country country = response.getCountry();
            System.out.println(country.getNames().get("zh-CN"));    // '中国'


            // 获取省份
            Subdivision subdivision = response.getMostSpecificSubdivision();
            System.out.println(subdivision.getNames().get("zh-CN")); // '广西壮族自治区'

            // 获取城市
            City city = response.getCity();
            System.out.println(city.getNames().get("zh-CN")); // '南宁'
            Location location = response.getLocation();
        } catch (IOException e) {
            System.out.println("进来了1");
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            System.out.println("进来了2");
            /*检测不到在进来这里*/
        }
    }
}

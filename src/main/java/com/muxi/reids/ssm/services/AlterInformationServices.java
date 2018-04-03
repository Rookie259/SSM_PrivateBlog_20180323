package com.muxi.reids.ssm.services;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-28 14:38
 */

import com.muxi.reids.ssm.entity.BlogInfo;
import org.springframework.stereotype.Service;


public interface AlterInformationServices {


    public boolean alterBlogState(BlogInfo blogInfo);


    /*
    *   @Author: MuXi
    *   @ClassName: AlterInformationServices
    *   @param:  * @param null
    *   @Date: 0:17 2018/3/29
    *   @Description: 修改blog浏览量
    *   @Return:
    */
    public void alterBlogBpageview(Integer count,Integer bid);

    /*
    *   @Author: MuXi
    *   @ClassName: AlterInformationServices
    *   @param:  * @param null
    *   @Date: 11:48 2018/3/29
    *   @Description: 修改点赞量
    *   @Return:
    */
    public  void alterBlogLikeCount(Integer count,Integer bid);
}

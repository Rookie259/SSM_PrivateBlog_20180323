package com.muxi.reids.ssm.dao;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-28 14:35
 */

import com.muxi.reids.ssm.entity.BlogInfo;

public interface AlterInformateionInterfaces {

    //修改blog状态 为发布状态
    public void alterBlogState(BlogInfo blogInfo);

    /*
     *   @Author: MuXi
     *   @ClassName: MoveInformateionInterfaces
     *   @param:  * @param null
     *   @Date: 0:14 2018/3/29
     *   @Description: 修改BlogInfo浏览量
     *   @Return:
     */
    public void alterBlogBpageview(Integer bpageview,Integer bid);

    /*
    *   @Author: MuXi
    *   @ClassName: AlterInformateionInterfaces
    *   @param:  * @param null
    *   @Date: 11:45 2018/3/29
    *   @Description: 修改点赞量
    *   @Return:
    */
    public void alterBlogLikeCount(Integer blike,Integer bid);


    /*
    *   @Author: MuXi
    *   @ClassName: AlterInformateionInterfaces
    *   @param:  * @param null
    *   @Date: 15:11 2018/4/19
    *   @Description: 修改comment的点赞量
    *   @Return: void
    */
    public void alterCommentLikeCount(Integer cid,Integer clike);


    /*
    *   @Author: MuXi
    *   @ClassName: AlterInformateionInterfaces
    *   @param:  * @param null
    *   @Date: 10:36 2018/4/21
    *   @Description: 当前博客评论量加一
    *   @Return: void
    */
    public void nowBlogCommentPlusOne(Integer commentCount,Integer id);
}

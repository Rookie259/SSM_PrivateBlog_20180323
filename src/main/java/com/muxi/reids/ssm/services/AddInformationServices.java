package com.muxi.reids.ssm.services;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-23 08:38
 */

import com.muxi.reids.ssm.entity.BlogInfo;
import com.muxi.reids.ssm.entity.UserInfo;

public interface AddInformationServices {



    /*
     *   @Author: MuXi
     *   @ClassName: AddInformationServices
     *   @param:  * @param null
     *   @Date: 8:38 2018/3/23
     *   @Description: 用户注册
     *   @Return:boolean
     */

    public boolean addUserInfo(UserInfo userInfo);


    /*
     *   @Author: MuXi
     *   @ClassName: AddInformationServices
     *   @param:  * @param null
     *   @Date: 10:22 2018/3/28
     *   @Description:添加预览状态
     *   @Return:boolean
     */
    public boolean addPreviewState(BlogInfo blogInfo);
    
    
    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationServices
    *   @param:  * @param null
    *   @Date: 11:05 2018/3/29
    *   @Description: 添加当前ip点赞博客
    *   @Return: void
    */
    public void addBlogLike(String ip , Integer bid);


    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationServices
    *   @param:  * @param null
    *   @Date: 10:34 2018/3/30
    *   @Description: 添加心情记录
    *   @Return: boolean
    */
    public boolean addEssay(String content,String time);

    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationServices
    *   @param:  * @param null
    *   @Date: 13:59 2018/3/31
    *   @Description: 添加根评论
    *   @Return: boolean
    */
    public boolean addBaseComment(String nickname,String text, String time,String id);


    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationServices
    *   @param:  * @param null
    *   @Date: 11:47 2018/4/2
    *   @Description: 插入楼中楼子评论
    *   @Return: boolean
    */
    public boolean addCommentDoubleDeck(String text,String name,String id,String baseCommentId);
    
}

package com.muxi.reids.ssm.dao;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-22 15:37
 */

import com.muxi.reids.ssm.entity.BlogInfo;
import com.muxi.reids.ssm.entity.CommentInfo;
import com.muxi.reids.ssm.entity.EssayInfo;
import com.muxi.reids.ssm.entity.UserInfo;

public interface AddInformationInterfaces {

    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationInterfaces
    *   @param:  * @param null
    *   @Date: 15:37 2018/3/22
    *   @Description: 保存用户
    *   @Return:
    */
    public void addUser(UserInfo userInfo);


    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationInterfaces
    *   @param:  * @param null
    *   @Date: 10:16 2018/3/28
    *   @Description: 插入预览状态文章
    *   @Return:
    */
    public void addPreviewState(BlogInfo blogInfo);

    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationInterfaces
    *   @param:  * @param null
    *   @Date: 11:03 2018/3/29
    *   @Description: 添加当前ip用户点赞记录
    *   @Return: void
    */
    public void addBlogLike(String ip,Integer bid);


    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationInterfaces
    *   @param:  * @param null
    *   @Date: 9:54 2018/3/30
    *   @Description: 添加心情随笔
    *   @Return:
    */
    public void addEssay(String ehobby,String etime);


    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationInterfaces
    *   @param:  * @param null
    *   @Date: 13:55 2018/3/31
    *   @Description: 插入根评论
    *   @Return:
    */
    public void addBaseComment(String nickname,String text, String time,Integer id);

    /*
    *   @Author: MuXi
    *   @ClassName: AddInformationInterfaces
    *   @param:  * @param null
    *   @Date: 11:56 2018/4/2
    *   @Description: 添加子评论
    *   @Return:
    */
    public void addDoubleDeckComment(CommentInfo commentInfo);


















}

package com.muxi.reids.ssm.services;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-22 10:38
 */

import com.muxi.reids.ssm.entity.*;

import java.util.List;

public interface ReadInformationServices {

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 10:38 2018/3/22
    *   @Description: 检测用户信息是否存在
    *   @Return: boolean
    */
    public boolean readUserIsExist(UserInfo userInfo);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 14:12 2018/3/22
    *   @Description: 用户昵称是否存在
    *   @Return: 存在 true  不存在 false
    */
    public boolean readUserNicknameIsExist(String nickname);


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 14:33 2018/3/22
    *   @Description: 注册用户邮箱是否被注册
    *   @Return: boolean
    */
    public boolean readUserEamilIsExist(String eamil);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 15:02 2018/3/22
    *   @Description: 获取验证码
    *   @Return: String
    */
    public String achieveCode(String eamil);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 20:11 2018/3/27
    *   @Description:保存标签和分类List
    *   @Return: List
    */
    public List<List<String>> readWriteLabelComment();

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 10:10 2018/3/28
    *   @Description: 获取classify  通过string
    *   @Return: classify
    */
    public ClassifyInfo readClassify(String str);

    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationServices
     *   @param:  * @param null
     *   @Date: 10:38 2018/3/22
     *   @Description: 获取用户
     *   @Return: UserInfo
     */
    public UserInfo readUserInfo(UserInfo userInfo);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 15:21 2018/3/28
    *   @Description: 获取按时间排序的前十五条博客
    *   @Return: List<BlogInfo>
    */
    public List readTopFifteeBlog();

     /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationServices
     *   @param:  * @param null
     *   @Date: 14:17 2018/3/29
     *   @Description: 获取按时间排序的所有信息
     *   @Return: List<BlogInfo>
     */
     public List readAllBlogTime();



    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 21:53 2018/3/28
    *   @Description: 通过id获取blog
    *   @Return: BlogInfo
    */
    public BlogInfo readBlogById(String id);


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 10:41 2018/3/29
    *   @Description: 根据当前ip查询是否存在
    *   @Return: boolean
    */
    public boolean readLikeIsExist(String ip, BlogInfo likeInfo);


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 12:08 2018/3/29
    *   @Description: 根据参数获取5条 互不重复的blog id并获取对应的bean
    *   @Return: List<BlogInfo>
    */
    public List<BlogInfo> readRepetitionBlogById(BlogInfo blogInfo);


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 10:41 2018/3/30
    *   @Description:
    *   @Return:
    */
    public List<EssayInfo> readEssayAll();


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 14:29 2018/3/31
    *   @Description: 获取根评论
    *   @Return: List<CommentInfo>
    */
    public List<CommentInfo> readBaseComment(String bid);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationServices
    *   @param:  * @param null
    *   @Date: 14:58 2018/3/31
    *   @Description: 通过id查询0节点平评论下的子评论
    *   @Return: List<Comment>
    */
    public  List<List<CommentInfo>> readCommentDoubleDeck(List<CommentInfo> list);

   /*
   *   @Author: MuXi
   *   @ClassName: ReadInformationServices
   *   @param:  * @param null
   *   @Date: 10:16 2018/4/2
   *   @Description: 查询所有楼中楼自评论
   *   @Return: List<CommentInfo>
   */
   public List<CommentInfo> readCommentInfoctargetidNoZero(Integer bid);


   /*
   *   @Author: MuXi
   *   @ClassName: ReadInformationServices
   *   @param:  * @param null
   *   @Date: 9:16 2018/4/8
   *   @Description: 获取blog最大评论量
   *   @Return: Integer
   */
   public List<Integer>  readBlogByIdCommentMaxCount(List<BlogInfo> list);




}

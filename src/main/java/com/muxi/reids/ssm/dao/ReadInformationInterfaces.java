package com.muxi.reids.ssm.dao;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-21 13:53
 */

import com.muxi.reids.ssm.entity.*;

import java.util.List;

public interface ReadInformationInterfaces {

    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 10:08 2018/3/22
     *   @Description: 登录查询用户是否存在
     *   @Return:
     */
    public UserInfo readUserIsExist(UserInfo user);


    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 14:09 2018/3/22
     *   @Description: 查询用户注册昵称是否存在
     *   @Return:
     */
    public UserInfo readUserNicknameIsExist(UserInfo userInfo);

    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 14:31 2018/3/22
     *   @Description: 查询注册用户的邮箱是否被注册
     *   @Return:
     */
    public UserInfo readUserEamilIsExist(UserInfo userInfo);


    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 19:57 2018/3/27
     *   @Description: 查询标签值
     *   @Return: List<LabelInfo>
     */
    public List<String> readLabel();


    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 20:09 2018/3/27
     *   @Description: 查询分类
     *   @Return: List<Classify>
     */
    public List<String> readClassify();


    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 10:04 2018/3/28
     *   @Description: 通过String获取分类对象
     *   @Return:ClassifyInfo
     */
    public ClassifyInfo readClassifyInfo(String clcomment);

    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 13:07 2018/3/28
     *   @Description:获取userInfo
     *   @Return:
     */
    public UserInfo readUserInfo(UserInfo user);


    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 15:09 2018/3/28
     *   @Description: 获取前15条博客  按时间顺序排序
     *   @Return: List<BlogInfo>
     */
    public List<BlogInfo> readFiftten();

    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 21:51 2018/3/28
     *   @Description: 通过id获取博客内容
     *   @Return: BlogInfo
     */
    public BlogInfo readBlogById(Integer id);

    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 23:57 2018/3/28
     *   @Description: 通过id查询用户
     *   @Return: UserInfo
     */
    public UserInfo readUserById(Integer uid);

    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationInterfaces
     *   @param:  * @param null
     *   @Date: 23:59 2018/3/28
     *   @Description: 通过id查询classify
     *   @Return: classify
     */
    public ClassifyInfo readClassifyById(Integer clid);


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 10:38 2018/3/29
    *   @Description: 根据当前ip查询是否存在当前博客
    *   @Return: LikeInfo
    */
    public LikeInfo readLikeInfoByBid(String ip,Integer bid);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 12:02 2018/3/29
    *   @Description: 获取5条不同的blog
    *   @Return: List<BlogInfo>
    */
    public List<BlogInfo> readBlogTopFive(List<Integer> list);


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 13:34 2018/3/29
    *   @Description: 获取所有Blog
    *   @Return: List<BlogInfo>
    */
    public List<BlogInfo> readBlogAll();

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 10:39 2018/3/30
    *   @Description: 查询心情记录  并按时间降序排序
    *   @Return: List<EassyInfo>
    */
    public List<EssayInfo> readEssayAll();

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 14:07 2018/3/29
    *   @Description: 获取所有blog  按时间排序
    *   @Return: List<BlogInfo>
    */
    public List<BlogInfo> readBlogAllTime(Integer begin,Integer end);


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 14:27 2018/3/31
    *   @Description: 通过博客id获取根评论
    *   @Return:List<CommentInfo>
    */
    public List<CommentInfo> readBaseComment(Integer bid);
    
    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 15:07 2018/3/31
    *   @Description: 通过ctargetid查询评论
    *   @Return: CommentInfo
    */
    public List<CommentInfo> readCommentInfo(Integer cid);

    /*
     *   @Author: MuXi
     *   @ClassName: ReadInformationServices
     *   @param:  * @param null
     *   @Date: 9:35 2018/4/2
     *   @Description: 通过id查询comment
     *   @Return: Comment
     */
    public CommentInfo readCommentById(Integer id);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 10:10 2018/4/2
    *   @Description: 获取评论的楼中楼  Integer  当前博客id
    *   @Return: Comment
    */
    public List<CommentInfo> readCommentCtargetid(Integer bid);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 11:54 2018/4/2
    *   @Description: 通过name获取comment
    *   @Return: Comment
    */
    public CommentInfo readCommentByCNickname(Integer cid);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 9:12 2018/4/8
    *   @Description: 通过id获取blog的评论量
    *   @Return: Integer
    */
    public Integer readBlogByIdCommentMaxCount(Integer bid);


    /*
     *   @Author: MuXi
     *   @ClassName: AddInformationInterfaces
     *   @param:  * @param null
     *   @Date: 17:27 2018/4/13
     *   @Description: 获取所有博客留言
     *   @Return: List<LeaveNote>
     */
    public List<LeaveNoteInfo> readAllLeaveNote();


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 14:20 2018/4/14
    *   @Description: 获取最新的6篇文章
    *   @Return: List<BlogInfo>
    */
    public List<BlogInfo> readSixNewBlog();

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 9:55 2018/4/19
    *   @Description: 查询评论是否存在点赞记录
    *   @Return:List<likeblog>
    */
    public List<LikeInfo> readLikeInfoFirsetFloorIsExist(String lip,Integer lbid,Integer lcid);



    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 15:04 2018/4/19
    *   @Description: 通过id查询当前一级评论点赞人数
    *   @Return:Integer
    */
    public Integer readNowUserCommentLikeCount(Integer lcid);

    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 15:09 2018/4/19
    *   @Description: 通过lcid查询comment
    *   @Return: comment
    */
    public CommentInfo readCommentInfoByLike(Integer cid);


    /*
    *   @Author: MuXi
    *   @ClassName: ReadInformationInterfaces
    *   @param:  * @param null
    *   @Date: 15:52 2018/4/19
    *   @Description: 查询当前用户名是否点赞
    *   @Return: comment
    */
    public LikeInfo readNowUserIsLikeComment(String nickname,Integer lcid);
}

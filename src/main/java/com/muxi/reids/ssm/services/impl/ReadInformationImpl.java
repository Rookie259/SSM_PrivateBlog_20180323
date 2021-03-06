package com.muxi.reids.ssm.services.impl;/*
 *   @program: SSM_Redis
 *   @description:
 *   @Author: MuXi
 *   @create: 2018-03-22 10:39
 */

import com.muxi.reids.ssm.dao.AddInformationInterfaces;
import com.muxi.reids.ssm.dao.AlterInformateionInterfaces;
import com.muxi.reids.ssm.dao.ReadInformationInterfaces;
import com.muxi.reids.ssm.entity.*;
import com.muxi.reids.ssm.services.AddInformationServices;
import com.muxi.reids.ssm.services.ReadInformationServices;
import com.muxi.reids.ssm.tool.Eamil.EamilTool;
import com.muxi.reids.ssm.tool.commonTools.InCommonUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.*;

@Service("readInformationServices")
public class ReadInformationImpl implements ReadInformationServices {


    @Autowired
    private ReadInformationInterfaces readInformationInterfaces;

    @Autowired
    private AddInformationInterfaces addInformationInterfaces;

    @Autowired
    private AlterInformateionInterfaces alterInformateionInterfaces;


    @Autowired
    private InCommonUse inCommonUse;


    private EamilTool tool = new EamilTool();

    public boolean readUserIsExist(UserInfo userInfo) {
        UserInfo userInfo1 = readInformationInterfaces.readUserIsExist(userInfo);
        if (userInfo1 == null)
            return false;
        else
            return true;
    }

    public boolean readUserNicknameIsExist(String nickname) {
        UserInfo userInfo = new UserInfo();
        userInfo.setuNickName(nickname);
        UserInfo userInfo1 = readInformationInterfaces.readUserNicknameIsExist(userInfo);
        if (userInfo1 == null)
            return false;
        else
            return true;
    }

    public boolean readUserEamilIsExist(String eamil) {
        UserInfo userInfo = new UserInfo();
        userInfo.setuEamil(eamil);
        UserInfo userInfo1 = readInformationInterfaces.readUserEamilIsExist(userInfo);
        if (userInfo1 == null)
            return false;
        else
            return true;
    }

    public String achieveCode(String eamil) {
        String resultCode = tool.sendCode(eamil);
        return resultCode;
    }

    public List<List<String>> readWriteLabelComment() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> list_label = readInformationInterfaces.readLabel();
        List<String> list_comment = readInformationInterfaces.readClassify();
        list.add(list_label);
        list.add(list_comment);
        return list;
    }

    public ClassifyInfo readClassify(String str) {

        return readInformationInterfaces.readClassifyInfo(str);
    }

    public UserInfo readUserInfo(UserInfo userInfo) {
        return readInformationInterfaces.readUserInfo(userInfo);
    }

    public List readTopFifteeBlog() {
        List<BlogInfo> list = readInformationInterfaces.readFiftten();
        List<SunDate> list_date = new ArrayList<SunDate>();
        List<List<String>> list_label = new ArrayList<List<String>>();
        for (int i = 0; i < list.size(); i++) {
            BlogInfo blogInfo = list.get(i);
            //第一步 获取每一篇博客正文内容的前60个char
            blogInfo.setBcontent(inCommonUse.achieveFontStr(inCommonUse.StripHT(blogInfo.getBcontent())));
            //第二步  改变日期的格式  2018-03-28 15:35:32  ------> 3 28
            String str_time = inCommonUse.bracketsByValue(list.get(i).getBtime(), '-', ' ');
            List<String> list_time = inCommonUse.splitStr(str_time, "-");
            String str_month = list_time.get(0);
            String str_day = list_time.get(1);
            SunDate date = new SunDate();
            date.setMonth(str_month);
            date.setDay(str_day);
            list_date.add(date);
            //第三步  取出标签 存储
            List<String> arr_label = inCommonUse.splitStr(blogInfo.getBlabel(), " ");
            list_label.add(arr_label);
        }
        List list_all = new ArrayList();
        list_all.add(list);
        list_all.add(list_date);
        list_all.add(list_label);
        return list_all;
    }

    public List readAllBlogTime(String begin, String end) {
        List<BlogInfo> list = readInformationInterfaces.readBlogAllTime(new Integer(begin), new Integer(end));
        List<SunDate> list_date = new ArrayList<SunDate>();
        List<List<String>> list_label = new ArrayList<List<String>>();
        for (int i = 0; i < list.size(); i++) {
            BlogInfo blogInfo = list.get(i);
            //第一步 获取每一篇博客正文内容的前60个char
            blogInfo.setBcontent(inCommonUse.achieveFontStr(inCommonUse.StripHT(blogInfo.getBcontent())));
            //第二步  改变日期的格式  2018-03-28 15:35:32  ------> 3 28
            String str_time = inCommonUse.bracketsByValue(list.get(i).getBtime(), '-', ' ');
            List<String> list_time = inCommonUse.splitStr(str_time, "-");
            String str_month = list_time.get(0);
            String str_day = list_time.get(1);
            SunDate date = new SunDate();
            date.setMonth(str_month);
            date.setDay(str_day);
            list_date.add(date);
            //第三步  取出标签 存储
            List<String> arr_label = inCommonUse.splitStr(blogInfo.getBlabel(), " ");
            list_label.add(arr_label);
        }
        List list_all = new ArrayList();
        list_all.add(list);
        list_all.add(list_date);
        list_all.add(list_label);
        return list_all;
    }


    public BlogInfo readBlogById(String id) {
        BlogInfo blogInfo = readInformationInterfaces.readBlogById(new Integer(id));
        if (blogInfo != null) {
            return blogInfo;
        } else
            return null;
    }

    public boolean readLikeIsExist(String ip, BlogInfo blogInfo) {
        LikeInfo likeInfo = readInformationInterfaces.readLikeInfoByBid(ip, blogInfo.getBid());
        if (likeInfo != null) {
            return false;
        } else
            return true;
    }


    public List<BlogInfo> readRepetitionBlogById(BlogInfo blogInfo) {
        List<BlogInfo> blogInfos_list = readInformationInterfaces.readBlogAll();
        Set<Integer> integer_set = new HashSet<Integer>();
        for (BlogInfo b :
                blogInfos_list) {
            if (b.getBid() != blogInfo.getBid()) {
                integer_set.add(b.getBid());
            }
        }
        Iterator<Integer> iterator = integer_set.iterator();
        List<Integer> list_Integer = new ArrayList<Integer>();
        int count = 1;
        while (iterator.hasNext()) {
            list_Integer.add(iterator.next());
            count++;
            if (count == 5) {
                break;
            }
        }
        List<BlogInfo> list_blog = readInformationInterfaces.readBlogTopFive(list_Integer);

        for (BlogInfo b :
                list_blog) {
            b.setBcontent(inCommonUse.achieveFontStr(inCommonUse.StripHT(b.getBcontent())));
        }
        return list_blog;
    }

    public List<EssayInfo> readEssayAll() {
        return readInformationInterfaces.readEssayAll();
    }


    public List<CommentInfo> readBaseComment(String bid) {
        return readInformationInterfaces.readBaseComment(new Integer(bid));
    }


    public List<List<CommentInfo>> readCommentDoubleDeck(List<CommentInfo> list) {
        List<List<CommentInfo>> listList = new ArrayList<List<CommentInfo>>();
        for (CommentInfo c :
                list) {
            List<CommentInfo> list1 = new ArrayList<CommentInfo>();
            list1 = readInformationInterfaces.readCommentInfo(c.getCid());
            if (list1 == null)
                listList.add(null);
            else
                listList.add(list1);
        }
        return listList;
    }

    public List<CommentInfo> readCommentInfoctargetidNoZero(Integer bid) {
        List<CommentInfo> list = readInformationInterfaces.readCommentCtargetid(bid);
        /*1.获取当前博客下所有根评论
         * 2.根据根本评论获取所有子评论
         * 3.如过无子评论 则放入null 有则放入List<CommentInfo>
         * 4.返回List<List<CommentInfo>>
         * */
        //1.所有根评论
        List<CommentInfo> list_Root = readInformationInterfaces.readBaseComment(new Integer(bid));
        //2.创建子评论集合
/*        List<List<CommentInfo>> lists_result = new ArrayList<List<CommentInfo>>();
        for (CommentInfo c :
                list_Root) {
            List<CommentInfo> list_son;
            try {
                list_son = readInformationInterfaces.readCommentInfo(c.getCtargetid().getCid());
                lists_result.add(list_son);
            } catch (NullPointerException e) {
                lists_result.add(null);
            }
        }
        for (List<CommentInfo> cl :
                lists_result) {
            if (cl != null) {
                for (CommentInfo c :
                        cl) {
                    System.out.println(c.toString() + "-------------------------------");
                }
            }

        }
        return lists_result;*/
        return list;
    }

    public List<Integer> readBlogByIdCommentMaxCount(List<BlogInfo> list) {
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            Integer maxCommentCount = readInformationInterfaces.readBlogByIdCommentMaxCount(list.get(i).getBid());
            integerList.add(maxCommentCount);
        }
        return integerList;
    }

    public String achieveNowAddressByGeoIP() {
        try {
            if (inCommonUse.achieveAddressByGeoIP(inCommonUse.getIpAddress()) != null) {
                List<Map<String, String>> mapList = inCommonUse.achieveAddressByGeoIP(inCommonUse.getIpAddress());
                return mapList.get(0).get("province") + mapList.get(1).get("city").toString();
            } else if (inCommonUse.achieveAddressByGeoIP(inCommonUse.getIpAddress()) == null) {
                return "未知";
            }
        } catch (UnknownHostException e) {
            return "未知";
        }
        return null;
    }

    public List<LeaveNoteInfo> readAllLeaveNote() {
        return readInformationInterfaces.readAllLeaveNote();
    }

    public List<BlogInfo> readSixNewBlog() {
        return readInformationInterfaces.readSixNewBlog();
    }

    public boolean readBlogAchieveLikeIsExist(UserInfo userInfo, String bid, String cid) {
        /*游客名称*/
        String nowIp = null;
        try {
            nowIp = inCommonUse.getIpAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String nickname = "游客" + nowIp;
        List<LikeInfo> commentInfoList = new ArrayList<LikeInfo>();
        if (null != userInfo)
            commentInfoList = readInformationInterfaces.readLikeInfoFirsetFloorIsExist(userInfo.getuNickName(), new Integer(bid), new Integer(cid));
        else
            commentInfoList = readInformationInterfaces.readLikeInfoFirsetFloorIsExist(nickname, new Integer(bid), new Integer(cid));
        /*查询是否存在点赞记录*/
        if (commentInfoList.size() == 0) {
            if (null == userInfo) {
                /*插入点赞记录*/
                addInformationInterfaces.addFirstFoolLike(nickname, new Integer(bid), new Integer(cid));
                /*查询贡献赞人数*/
                Integer countLike = readInformationInterfaces.readNowUserCommentLikeCount(new Integer(cid));
                /*修改comment  like属性*/
                /*查询comment对象*/
                CommentInfo commentInfo = readInformationInterfaces.readCommentInfoByLike(new Integer(cid));
                commentInfo.setClike(countLike);
                /*修改评论的点赞数量*/
                alterInformateionInterfaces.alterCommentLikeCount(new Integer(countLike), new Integer(cid));
                return true;
            } else {
                addInformationInterfaces.addFirstFoolLike(userInfo.getuNickName(), new Integer(bid), new Integer(cid));
                /*查询贡献赞人数*/
                Integer countLike = readInformationInterfaces.readNowUserCommentLikeCount(new Integer(cid));
                /*修改comment  like属性*/
                /*查询comment对象*/
                CommentInfo commentInfo = readInformationInterfaces.readCommentInfoByLike(new Integer(cid));
                commentInfo.setClike(countLike);
                /*修改评论的点赞数量*/
                alterInformateionInterfaces.alterCommentLikeCount(new Integer(countLike), new Integer(cid));
                return true;
            }
        } else {
            return false;
        }
    }

    public List<String> readGetFirstLevelCommentThumbUpStatusList(UserInfo userInfo, List<CommentInfo> commentInfoList) throws UnknownHostException {
        List<String> stringList = new ArrayList<String>();
        if (null != userInfo) {
            for (CommentInfo commentInfo :
                    commentInfoList) {
                if (readInformationInterfaces.readNowUserIsLikeComment(userInfo.getuNickName(), commentInfo.getCid()) != null) {
                    stringList.add("exist");
                } else {
                    stringList.add("noExist");
                }
            }
        } else {
            String nickname = "游客" + inCommonUse.getIpAddress();
            for (CommentInfo commentInfo :
                    commentInfoList) {
                if (null != readInformationInterfaces.readNowUserIsLikeComment(nickname, commentInfo.getCid())) {
                    stringList.add("exist");
                } else {
                    stringList.add("noExist");
                }
            }
        }

        return stringList;
    }


    public void setReadInformationInterfaces(ReadInformationInterfaces readInformationInterfaces) {
        this.readInformationInterfaces = readInformationInterfaces;
    }

    public void setInCommonUse(InCommonUse inCommonUse) {
        this.inCommonUse = inCommonUse;
    }

    public void setAddInformationInterfaces(AddInformationInterfaces addInformationInterfaces) {
        this.addInformationInterfaces = addInformationInterfaces;
    }

    public void setAlterInformateionInterfaces(AlterInformateionInterfaces alterInformateionInterfaces) {
        this.alterInformateionInterfaces = alterInformateionInterfaces;
    }
}

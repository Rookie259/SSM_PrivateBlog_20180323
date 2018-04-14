<%@ page import="com.muxi.reids.ssm.entity.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/hobby.css">
    <link rel="stylesheet" href="resources/css/leaveNote.css">
    <link rel="stylesheet" href="resources/css/text.css">
</head>
<body>
<%
    boolean isAdmin = false;
    UserInfo userInfo = (UserInfo) session.getAttribute("user");
    if (userInfo != null) {
        if (userInfo.getuNickName() == "沐惜") ;
        isAdmin = true;
    }
%>
<jsp:include page="BlogLogo.jsp"></jsp:include>
<jsp:include page="BlogLabel.jsp"></jsp:include>
<div class="allDiv">
    <div class="leftLeaveNote">
        <%--留言模块--%>
        <div class="leave">
            <div id="comment" class="comment-main">
                <textarea name="test" id="rl_exp_input" cols="30" rows="10" style="outline:none;"></textarea>
                <a href="javascript:void(0);" id="rl_exp_btn"
                   style="font-size: 15px;font-weight: bold;cursor: pointer;">表情</a>
                <input type="button" id="textButton" value="留言" class="textSub">
            </div>
            <div class="rl_exp" id="rl_bq" style="display:none;">
                <ul class="rl_exp_tab clearfix">
                    <li><a href="javascript:void(0);" class="selected">默认</a></li>
                    <li><a href="javascript:void(0);">拜年</a></li>
                    <li><a href="javascript:void(0);">浪小花</a></li>
                    <li><a href="javascript:void(0);">暴走漫画</a></li>
                </ul>
                <ul class="rl_exp_main clearfix rl_selected" id="1"></ul>
                <ul class="rl_exp_main clearfix" style="display:none;"></ul>
                <ul class="rl_exp_main clearfix" style="display:none;"></ul>
                <ul class="rl_exp_main clearfix" style="display:none;"></ul>
                <a href="javascript:void(0);" class="close">×</a>
            </div>
        </div>
        <%--留言内容模块--%>
        <div class="messageContent">
            <%--统计留言人数--%>
            <div></div>
            <%--傲娇的分割线--%>
            <hr class="theDividingLineOfTsundere"/>
            <c:forEach items="${allLeaveNote}" var="note" varStatus="=noteState">
                <%--留言内容模块--%>
                <div class="noteDiv" onmouseover="noteDivShow()">
                        <%--内左部  头像所在部--%>
                    <div class="innerHeaderImg">
                        <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%8B%97%E7%8B%97.png"
                             class="imgHeader">
                    </div>
                        <%--右部  基本信息  留言内容 所在部--%>
                    <div class="rightEssentialInformation">
                        <div class="firstDivMessage">
                            <span class="leaveName">${note.lnname}</span>
                            <span class="leaveProvince">${note.lnaddress}</span>
                            <span class="leaveTime">${note.lntime}</span>
                        </div>
                        <div class="leaveContent">
                                ${note.lntext}
                        </div>
                            <%--评论功能按钮--%>
                        <div class="functionButton"><%
                            if (isAdmin == true)
                            {
                        %>
                            <span class="moveLeave"><img
                                    src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E5%88%A0%E9%99%A4.png"
                                    id="move${note.lnid}">删除</span>
                            <%
                                }
                            %>

                            <span class="reply"><img
                                    src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E5%9B%9E%E5%A4%8D.png"
                                    id="replyImgid${note.lnid}" onmouseover="replyimg(this.id);"></span>
                            <span class="replyPraise"><img
                                    src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%82%B9%E8%B5%9E16px%20(1).png"
                                    id="notelike${note.lnid}" onclick="leaveNoteLike(this.id)"></span>
                            <span class="replyCount">(<span id="noteLikeCount">0</span>)</span>
                            <span class="replyPraiseStamp"><img
                                    src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E6%AF%85%E8%BF%9B14-%E8%B8%A9.png"
                                    style="margin-top: 2px" id="note1NoLike1" onclick="leaveNoteNoLike(this.id)"></span>
                            <span class="replyCountStamp">(<span id="noteNoLikeCount">0</span>)</span>
                            <div class="clear"></div>
                        </div>
                            <%--评论功能按钮END--%>
                            <%--添加回复框框--%>
                    </div>
                </div>
                <%--留言内容模块END--%>
            </c:forEach>
        </div>
    </div>

    <%--右部分推荐--%>
    <div class="rightLeaveNote">
        <%--最新文章6篇--%>
        <div class="nwwArticle">
            <p class="newRightArticleTitle">最新文章</p>
            <hr class="newHr"/>
            <ul class="nwwArticleUl">
                <c:forEach items="${newSixBlog}" var="newBlog">
                    <li><a href="note/achieveNewArticle.do?blogId=${newBlog.bid}">${newBlog.btitle}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div style="height: 200px"></div>
<jsp:include page="BlogFooter.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/tool/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="resources/js/leaveNote.js" charset="UTF-8"></script>
</body>
</html>

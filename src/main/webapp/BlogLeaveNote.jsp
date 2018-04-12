<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<jsp:include page="BlogLogo.jsp"></jsp:include>
<jsp:include page="BlogLabel.jsp"></jsp:include>
<div class="allDiv">

    <div class="leftLeaveNote">
        <%--留言模块--%>
        <div class="leave">
            <div id="comment" class="comment-main">
                <textarea name="test" id="rl_exp_input" cols="30" rows="10" style="outline:none;"></textarea>
                <%--            <div name="test" style="width: 500px;height: 100px;border: 1px solid black;overflow: auto"
                                 contenteditable="true" id="rl_exp_input" cols="30" rows="10"></div>--%>
                <a href="javascript:void(0);" id="rl_exp_btn"
                   style="font-size: 15px;font-weight: bold;cursor: pointer;">表情</a>
                <input type="button" id="textButton" value="发表" class="textSub">
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
                        <span class="leaveName">桓公</span>
                        <span class="leaveProvince">[河南省郑州市]</span>
                        <span class="leaveTime">2018-04-10 09:54:33</span>
                    </div>
                    <div class="leaveContent">
                        测试测试测试测试
                    </div>
                    <%--评论功能按钮--%>
                    <div class="functionButton">
                        <span class="moveLeave"><img
                                src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E5%88%A0%E9%99%A4.png">删除</span>
                        <span class="reply"><img
                                src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E5%9B%9E%E5%A4%8D.png"
                                id="replyImgid1" onmouseover="replyimg(this.id);"></span>
                        <span class="replyPraise"><img
                                src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%82%B9%E8%B5%9E16px%20(1).png"
                                id="notelike1" onclick="leaveNoteLike(this.id)"></span>
                        <span class="replyCount">(<span id="noteLikeCount">0</span>)</span>
                        <span class="replyPraiseStamp"><img
                                src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E6%AF%85%E8%BF%9B14-%E8%B8%A9.png"
                                style="margin-top: 2px" id="note1NoLike1" onclick="leaveNoteNoLike(this.id)"></span>
                        <span class="replyCountStamp">(<span id="noteNoLikeCount">0</span>)</span>
                    </div>
                    <%--评论功能按钮END--%>
                    <%--添加回复框框--%>

                </div>
            </div>
            <%--留言内容模块END--%>
        </div>
    </div>

    <%--右部分推荐--%>
    <div class="rightLeaveNote">


    </div>
</div>
<jsp:include page="BlogFooter.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/tool/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="resources/js/leaveNote.js"></script>
</body>
</html>

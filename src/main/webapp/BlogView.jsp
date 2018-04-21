<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/28
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page import="com.muxi.reids.ssm.entity.UserInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>博客详情</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <base href=" <%=basePath%>">
    <!--评论-->
    <link rel="stylesheet" href="resources/css/comment.css">
    <link rel="stylesheet" href="resources/css/previes.css">
    <script type="text/javascript" src="resources/js/tool/jquery-3.2.1.js"></script>

</head>
<body>
<% UserInfo userInfo = (UserInfo) session.getAttribute("user");%>
<!--悬浮按钮-->
<jsp:include page="BlogSuspension.jsp"></jsp:include>
<!--logo-->
<jsp:include page="BlogLogo.jsp"></jsp:include>
<!--菜单-->
<jsp:include page="BlogLabel.jsp"></jsp:include>
<div class="main">
    <div style="padding:20px;margin:0 auto;width: 950px;height: auto;border-radius: 4px;background-color: #FFFFFF;word-wrap:break-word; word-break:break-all; ">
        <div class="breadcrumb"></div>
        <p class="title">${fullBlogText.btitle}</p>
        <div class="nature" style="margin-top: 25px">
            <span class="author" style="margin-left: -1px"><img
                    src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%A8%BF%E4%BB%B6-%E4%BD%9C%E8%80%85.png"
                    style="vertical-align: middle">&nbsp;&nbsp;&nbsp;作者 : ${fullBlogText.buid.uNickName}</span>
            <span class="view" style="margin-left: 485px"><img
                    src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%9B%B4%E6%92%AD%E8%A7%82%E7%9C%8B%E6%95%B0_32.png"
                    style="vertical-align: middle">&nbsp;&nbsp;&nbsp;浏览量 : ${fullBlogText.bpageview}</span>
            <span class="time"><img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E6%97%A5%E6%9C%9F.png"
                                    style="vertical-align: middle">&nbsp;&nbsp;&nbsp;发布时间 : ${fullBlogText.btime}</span>
        </div>
        <p class="text" style="margin-top: 45px">
            ${fullBlogText.bcontent}
        </p>

        <div class="blogLike">
            <span class="likename" style="margin-left: 8px;margin-top: -68px;position: absolute">
                <c:choose>
                    <c:when test="${likeState == 'noExist'}">
                            <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%82%B9%E8%B5%9E(2).png"
                                 style="vertical-align:sub;">
                    </c:when>
                    <c:otherwise>
                            <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%82%B9%E8%B5%9E(3).png"
                                 style="vertical-align:sub;">
                    </c:otherwise>
                </c:choose>
                <span class="lickCount">
                    (&nbsp;<span class="lickCount_1">${fullBlogText.blike}</span>&nbsp;)
                </span>
            </span>
            <!--链接分享-->
            <div class="share">
                <ul>
                    <li><img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/social-qq.png"></li>
                    <li><img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E5%BE%AE%E4%BF%A1.png"></li>
                    <li><img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E6%96%B0%E6%B5%AA.png"></li>
                    <li><img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%A9%BA%E9%97%B4.png"></li>
                    <li><img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%99%BE%E5%BA%A61.png"></li>
                </ul>
            </div>
            <!--链接分享END-->
        </div>
        <!--二维码-->
        <div class="qrCodeWrite"><span>小哥哥！小姐姐！关个注呗!</span></div>
        <div class="qrCode">
            <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/blogcode.jpg">
        </div>
        <!--二维码END-->
        <!--评论-->
        <div class="commentDetiles">
            <!--
                此评论textarea文本框部分使用的https://github.com/alexdunphy/flexText此插件
            -->
            <div class="commentAll">
                <!--评论区域 begin-->
                <div class="reviewArea clearfix">
                    <textarea class="content comment-input" id="textareaComment" placeholder="Comm on baby!畅所欲言吧"
                              onkeyup="keyUP(this)"></textarea>
                    <a href="javascript:;" id="sendComment" class="plBtn">评论</a>
                </div>
                <!--评论区域 end-->
                <!--回复区域 begin-->
                <div class="comment-show" id="commentAjax">
                    <!--评论div-->
                    <c:forEach items="${baseComment}" var="baseComment">
                        <input type="text" id="hideid${baseComment.cid}" value="${baseComment.cid}"
                               style="display: none">
                        <div class="comment-show-con clearfix">
                            <div class="comment-show-con-img pull-left"><img
                                    src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%8B%97%E7%8B%97.png"
                                    alt=""></div>
                            <div class="comment-show-con-list pull-left clearfix">
                                <div class="pl-text clearfix">
                                    <a href="#" class="comment-size-name">${baseComment.cnickname} : </a>
                                    <span class="my-pl-con">&nbsp;${baseComment.ctext}</span>
                                </div>
                                <div class="date-dz">
                                    <span class="date-dz-left pull-left comment-time">${baseComment.ctime}</span>
                                    <div class="date-dz-right pull-right comment-pl-block">
                                        <%
                                            if (userInfo != null) {
                                        %>
                                        <a href="javascript:;" class="removeBlock">删除</a>
                                        <%
                                            }%>
                                        <a href="javascript:;"
                                           class="date-dz-pl pl-hf hf-con-block pull-left" id="${baseComment.cid}"
                                           onclick="achieveBaseCommentId(this.id)">回复</a>
                                        <span class="pull-left date-dz-line">|</span>

                                        <c:forEach items="${list_FirstLikeState}" var="firstLikeState"
                                                   begin="${baseCommentStatus.index}" end="${baseCommentStatus.index}">
                                            <c:choose>
                                                <c:when test="${firstLikeState == \"exist\"}">
                                                    <a href="javascript:;" class="date-dz-z pull-left date-dz-z-click"
                                                       id="assist${baseComment.cid}" onclick="firstFloor(this.id)"><i
                                                            class="date-dz-z-click-red red"></i>赞 (<i
                                                            class="z-num">${baseComment.clike}</i>)</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="javascript:;" class="date-dz-z pull-left"
                                                       id="assist${baseComment.cid}"
                                                       onclick="firstFloor(this.id)"><i
                                                            class="date-dz-z-click-red"></i>赞 (<i
                                                            class="z-num">${baseComment.clike}</i>)</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </div>
                                </div>
                                <!--子评论-->
                                <div class="hf-list-con">
                                    <c:forEach items="${doubleComment}" var="dou" varStatus="douSta">
                                        <c:choose>
                                            <c:when test="${dou.ccheckcomment== baseComment.cid}">
                                                <!--楼中楼-->
                                                <div class="all-pl-con">
                                                    <div class="pl-text hfpl-text clearfix">
                                                        <a href="#" class="comment-size-name">
                                                                ${dou.cnickname}
                                                        </a>
                                                        <span class="my-pl-con">回复@<a href="#"
                                                                                      class="atName">${dou.ctargetid.cnickname}</a> : ${dou.ctext}
                                        </span>
                                                    </div>
                                                    <div class="date-dz">
                                        <span class="date-dz-left pull-left comment-time">
                                                ${dou.ctime}
                                        </span>
                                                        <div class="date-dz-right pull-right comment-pl-block">
                                                                <%-- <a href="javascript:;" class="removeBlock">删除</a>--%>
                                                            <a href="javascript:;"
                                                               class="date-dz-pl pl-hf hf-con-block pull-left"
                                                               id="${baseComment.cid}"
                                                               onclick="achieveBaseCommentId(this.id)">回复</a>
                                                            <span class="pull-left date-dz-line">|</span>
                                                            <c:forEach items="${commentInfoListSecondLikeState}"
                                                                       var="secondState" varStatus="secondStateStatus" begin="${douSta.index}" end="${douSta.index}">
                                                                <c:choose>
                                                                    <c:when test="${secondState == \"exist\"}">
                                                                        <a href="javascript:;"
                                                                           class="date-dz-z pull-left date-dz-z-click"
                                                                           id="assist${dou.cid}"
                                                                           onclick="firstFloor(this.id)"><i
                                                                                class="date-dz-z-click-red red"></i>赞
                                                                            (<i
                                                                                    class="z-num">${dou.clike}</i>)</a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <a
                                                                                href="javascript:;"
                                                                                class="date-dz-z pull-left"
                                                                                id="assist${dou.cid}"
                                                                                onclick="firstFloor(this.id)">
                                                                            <i class="date-dz-z-click-red"></i>赞 (<i
                                                                                class="z-num">${dou.clike}</i>)</a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--楼中楼END-->
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                </div>
                                <!--子评论END-->
                            </div>
                        </div>
                    </c:forEach>
                    <!--评论divEND-->
                </div>
                <!--回复区域 end-->
            </div>
        </div>
        <!--评论END-->
        <!--推荐-->
        <div class="recommend">
            <ul>
                <c:forEach items="${recommendBlog}" var="reco">
                    <li>
                        <div class="recommendBlog" id="${reco.bid}" onclick="recommend(this.id);">
                            <div class="recommendBlogTitle">${reco.btitle}</div>
                            <div class="recommendBlogNature">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
                                    src="resources/images/狐狸(1).png" style="vertical-align:middle;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${reco.buid.uNickName}
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${reco.btime}
                            </div>
                            <div class="recommendBlogComment">
                                    ${reco.bcontent}
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <div style="margin-left: -80px">
                <jsp:include page="BlogFooter.jsp"></jsp:include>
            </div>
        </div>
    </div>
</div>
<input type="text" value="${fullBlogText.bid}" id="blog_id" style="display: none">
<script type="text/javascript" src="resources/js/comment.js" charset="UTF-8"></script>
<script type="text/javascript" src="resources/js/view.js"></script>
</body>
</html>

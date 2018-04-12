<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 10:32
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
    <link rel="stylesheet" href="resources/css/article.css">
    <script type="text/javascript" src="resources/js/tool/jquery-3.2.1.js"></script>
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="resources/images/logo/logo.png">
    </div>
</div>
<div class="nav">
    <ul>
        <li class="first"><a href="writeBlog/achieveBlog.do">首页</a></li>
        <li><a href="writeBlog/achieveAllBlog.do">博客</a></li>
        <li><a href="hobby/addHobby.do">心情随笔</a></li>
        <li><a href="ph94190877.do">过往云烟</a></li>
        <li><a href="le94190877.do">Blog留言</a></li>
        <li><a href="me94000877.do">关于我</a></li>
        <li><a href="ga94192577.do">休闲一刻</a></li>
    </ul>
</div>
<div class="main">
    <div class="left">
        <c:forEach items="${topBlog}" var="top" varStatus="status">
            <div class="article">
                <div class="article-logo">
                    <c:forEach items="${dateBlog}" var="date" begin="${status.index}" end="${status.index}">
                        <span class="month">${date.month}月</span>
                        <span class="day">${date.day}</span>
                    </c:forEach>
                </div>
                <div class="article-body">
                    <div class="article-title">
                        <h1>${top.btitle}</h1>
                    </div>
                    <div class="tag-article">
                        <c:forEach items="${listLabel}" var="label" varStatus="labelStatus" begin="${status.index}"
                                   end="${status.index}">
                            <c:forEach items="${label}" var="lb">
            <span class="label label-zan" style="margin-left: 1px">
                    ${lb}
            </span>
                            </c:forEach>
                        </c:forEach>
                    </div>
                    <div class="content-article">
                        <p>
                                ${top.bcontent}
                        </p>
                    </div>
                    <p class="btn-danger" href="BlogContent.jsp" id="${top.bid}" onclick="blogFullText(this.id);">
                        阅读全文
                        <span class="badge">
                            <c:forEach items="${maxCommentCount}" var="cc" begin="${status.index}" end="${status.index}">
                                ${cc}
                            </c:forEach>
    </span>
                    </p>
                </div>
            </div>
        </c:forEach>
        <div class="clear"></div>
        <div class="link-head more" style="margin-top: 55px">
            <p><a href="#">加载更多</a></p>
        </div>
        <div class="footer" style="margin-left: -85px">
            <p>Copyright © 2015 | <a href="si9780876.do">后台入口</a></p>
        </div>
    </div>
</div>
<script>
    /*获取全文内容*/
    function blogFullText(id) {
        data = {
            bid: id
        }
        $.ajax({
            type: "get",
            url: "writeBlog/achieveFullText.do",
            data: data,
            dataType: "json",
            success: function (msg) {
                if(msg.achieveState == "success")
                    window.location.href = "BlogView.jsp";
            }
        })
    }
</script>
</body>
</html>

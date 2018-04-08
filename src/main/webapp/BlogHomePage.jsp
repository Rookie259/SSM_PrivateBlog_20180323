<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>沐惜的个人博客</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/index.css">
</head>
<body>
<!--悬浮按钮-->
<jsp:include page="BlogSuspension.jsp"></jsp:include>
<!--logo-->
<jsp:include page="BlogLogo.jsp"></jsp:include>
<!--菜单-->
<jsp:include page="BlogLabel.jsp"></jsp:include>
<!--滚动-->
<div id="banner">
    <img src="resources/images/roll/roll6.png" style="display:block">
    <img src="resources/images/roll/roll2.png">
    <img src="resources/images/roll/roll5.png">
    <img src="resources/images/roll/roll1.png">
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
                        <h1><a href="#" id="${top.bid}" onclick="blogFullText(this.id);">${top.btitle}</a></h1>
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
                    <p class="btn-danger" id="${top.bid}" onclick="blogFullText(this.id);">
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
    </div>
    <!--友情链接-->
    <jsp:include page="BlogBlogroll.jsp"></jsp:include>
</div>
<jsp:include page="BlogFooter.jsp"></jsp:include>
<!-- <script src="js/banner_new.js"></script> -->
<script src="resources/js/banner_old.js"></script>
</body>
</html>

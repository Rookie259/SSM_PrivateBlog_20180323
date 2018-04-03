<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/28
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>预览文章</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/hobby.css">
    <link rel="stylesheet" href="resources/css/previes.css">
    <link rel="stylesheet" href="resources/css/button.css">
</head>
<body>
<!--悬浮按钮-->
<jsp:include page="BlogSuspension.jsp"></jsp:include>
<!--logo-->
<jsp:include page="BlogLogo.jsp"></jsp:include>
<!--菜单-->
<jsp:include page="BlogLabel.jsp"></jsp:include>
<div class="main">
    <div style="margin:0 auto;width: 1100px;height: auto;border-radius: 4px;background-color: #FFFFFF;word-wrap:break-word; word-break:break-all; ">
        <div class="breadcrumb"></div>
        <p class="title">${blogPreview.btitle}</p>
        <div class="natureLabel">
            <div class="tag-article">
                <c:forEach items="${blogLable}" var="label">
                    	<span class="label label-zan">
                                ${label}</span>
                </c:forEach>
            </div>
        </div>
        <div class="nature">
            <span class="author">作者 : ${blogPreview.buid.uNickName}</span>
            <span class="view">浏览量 : ${blogPreview.bpageview}</span>
            <span class="time">发布时间 : ${blogPreview.btime}</span>
        </div>
        <div class="nature">
            <span class="author">博客分类 : ${blogPreview.bclid.clcomment}</span>
        </div>
        <p>
             ${blogPreview.bcontent}
        </p>
        <input type="button" id="release" class="button button-black submitButtonPreview" value="发布">
    </div>
    <jsp:include page="BlogFooter.jsp"></jsp:include>
</div>
<script type="text/javascript" src="resources/js/preview.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>lavel</title>
    <base href=" <%=basePath%>">
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/hobby.css">
</head>
<body>

<div class="nav">
    <ul>
        <li class="first"><a href="writeBlog/achieveBlog">首页</a></li>
        <li><a href="writeBlog/achieveAllBlog">博客</a></li>
        <li><a href="hobby/readHobby">心情随笔</a></li>
        <li><a href="ph94190877">过往云烟</a></li>
        <li><a href="note/achieveAllNote">Blog留言</a></li>
        <li><a href="BlogAbout.jsp">关于我</a></li>
        <li><a href="BlogMatchPanic.jsp">休闲一刻</a></li>
    </ul>
</div>
</body>
</html>

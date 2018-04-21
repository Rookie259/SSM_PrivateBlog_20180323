<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href=" <%=basePath%>">
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/hobby.css">
</head>
<body>
<!--悬浮按钮-->
<jsp:include page="BlogSuspension.jsp"></jsp:include>
<!--logo-->
<jsp:include page="BlogLogo.jsp"></jsp:include>
<!--菜单-->
<jsp:include page="BlogLabel.jsp"></jsp:include>
<div class="main">
    <div class="content">
        <div class="breadcrumb"></div>
        <p class="title">关于我</p>
        <p class="text">
            Geeks spirit<br><br>
            My Blog : <a href="#" target="_blank">￥￥￥￥</a>
        </p>
    </div>
</div>
<jsp:include page="BlogFooter.jsp"></jsp:include>
</body>
</html>

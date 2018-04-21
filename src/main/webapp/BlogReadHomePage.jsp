<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/4/18
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>沐惜的个人博客</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="resources/js/tool/jquery-3.2.1.js"></script>
</head>
<body>
<script>window.onload = function () {
    window.location.href = "writeBlog/achieveBlog";
}</script>
</body>
</html>

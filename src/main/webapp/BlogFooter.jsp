<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>footer</title>
    <base href=" <%=basePath%>">
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/hobby.css">
</head>
<body>
<div class="footer">
    <p>Copyright © 2018 | <a href="BlogLogin.jsp">后台入口</a></p>
</div>
</body>
</html>

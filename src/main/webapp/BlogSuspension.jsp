<%@ page import="com.muxi.reids.ssm.entity.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>悬浮</title>
    <link rel="stylesheet" href="resources/css/suspension.css">
    <script type="text/javascript" src="resources/js/tool/jquery-3.2.1.js" CHARSET="UTF-8"></script>
</head>
<body>
<%
    UserInfo userInfo = (UserInfo) session.getAttribute("user");
    if (userInfo != null) {
%>
<div class="guide">
    <div class="guide-wrap">
        <a href="writeBlog/achieveLabel.do" class="edit" title="发新帖"><span>发新帖</span></a>
        <a href="javascript:window.scrollTo(0,0)" class="top" title="回顶部"><span>回顶部</span></a>
    </div>
</div>
<%
    }
%>

<script type="text/javascript" src="resources/js/suspension.js" CHARSET="UTF-8"></script>
</body>
</html>

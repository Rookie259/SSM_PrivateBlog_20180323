<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/4/19
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>姑娘，别走!</title>
    <base href=" <%=basePath%>">
    <link rel="stylesheet" type="text/css" href="resources/css/dandelion.css" media="screen"/>
    <script type="text/javascript" src="resources/js/tool/jquery-3.2.1.js"></script>
</head>
<body>

<div id="da-wrapper" class="fluid">
    <div id="da-content">
        <div class="da-container clearfix">
            <div id="da-error-wrapper">
                <div id="da-error-pin"></div>
                <div id="da-error-code">
                    error <span>404</span></div>
                <h1 class="da-error-heading"><a href="writeBlog/achieveBlog">姑娘，别走!</a></h1>
            </div>
        </div>
    </div>
</div>
</body>
</html>

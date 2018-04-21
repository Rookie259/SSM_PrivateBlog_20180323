<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Content</title>
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
        <p class="title">git 使用</p>
        <p class="text">
            创建github仓库<br>
            项目文件夹中初始化：git init ，自动生成.git文件夹<br>
            获取远程github仓库：git pull url url为github仓库地址<br>
            添加远程github仓库：git remote add name url <br>name为自定义主机名，url为github仓库地址<br>
            添加到暂存区：git add -A<br>
            提交到本地：git commit -m "message"<br>
            提交到远程：git push -u origin master<br>
            列出已经存在的远程分支<br><br>

            git remote<br>
            git remote -v (详细,带github地址)<br>
            检查目前文件状态<br><br>

            git status<br>
            添加到暂存区<br>

            git add -A stages All<br>
            git add . stages new and modified, without deleted<br>
            git add -u stages modified and deleted, without new
        </p>
    </div>
</div>
<jsp:include page="BlogFooter.jsp"></jsp:include>
</body>
</html>

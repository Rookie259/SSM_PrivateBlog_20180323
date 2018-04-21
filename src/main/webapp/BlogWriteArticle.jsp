<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/27
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>书写博客</title>
    <base href=" <%=basePath%>">
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/button.css">
    <link rel="stylesheet" href="resources/css/ComboBox.css">
    <script type="text/javascript" src="resources/js/tool/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="resources/ckeditor4.8/ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="resources/ckeditor4.8/ckeditor/config.js"></script>
</head>
<body>
<!--悬浮按钮-->
<jsp:include page="BlogSuspension.jsp"></jsp:include>
<!--logo-->
<jsp:include page="BlogLogo.jsp"></jsp:include>
<!--菜单-->
<jsp:include page="BlogLabel.jsp"></jsp:include>
<div class="main">
    <div style="width: 1000px;height: auto;border-radius: 4px;background-color: #FFFFFF">
        <div class="breadcrumb"></div>
        <p class="title">发表博客</p>
        <!--书写博客插件-->
        <p class="text">
            <textarea class="ckeditor" cols="80" id="editor1" rows="10"></textarea>
        </p>

        <div class="writeLabel">
            <span style="float: left">博客题目：</span>
            <div class="inputTitle"><input type="text" placeholder="请输入博客标题" id="inputContent"></div>
        </div>

        <div class="writeLabel">
            <span style="float: left">添加标签：</span>
        <!--标签下拉选择-->
        <div class='diy_select' style="float: left">
            <input type='hidden' name='' class='diy_select_input'/>
            <div class='diy_select_txt'>--请选择标签--</div>
            <div class='diy_select_btn'></div>
            <ul class='diy_select_list' id="labelULAppend">
                <c:forEach var="label" items="${label}">
                    <li id="${label}">${label}</li>
                </c:forEach>
            </ul>
        </div>
            <span style="float: left;margin-left: 45px;font-size: 10px;color: orange">( 最多5个标签哟! )</span>
        </div>
        <!--标签下拉选择END-->

        <!--添加标签内容-->
        <div class="writeLabel">
          <ul class="labelUL">
          </ul>
        </div>
        <!--添加标签内容END-->

        <!--分类下拉选择-->
        <div class="writeLabel">
            <span style="float: left">添加标签：</span>
        <div class='diy_select' style="float: left">
            <input type='hidden' name='' class='diy_select_input'/>
            <div class='diy_select_txt'>--请选择分类--</div>
            <div class='diy_select_btn'></div>
            <ul class='diy_select_list' id="classify">
                <c:forEach var="classify" items="${classify}">
                    <li>${classify}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <!--分类下拉选择END-->
        <input type="button" id="su" class="button button-black submitButton" value="预览">
    </div>

    <jsp:include page="BlogFooter.jsp"></jsp:include>
</div>
<script type="text/javascript" src="resources/js/ComboBox.js"></script>
</body>
</html>

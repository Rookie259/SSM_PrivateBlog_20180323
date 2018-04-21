<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/2/24
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Blog注册</title>
    <base href=" <%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="resources/css/rookieRegister.css">
    <script type="text/javascript" src="resources/js/tool/jquery-3.2.1.js" CHARSET="UTF-8"></script>
</head>
<body>
<div class="box">
    <div class="left">
    </div>
    <div class="right">
        <div class="rightBox">
            <div class="rightBoxUpTitle">
                <div class="write">
                    PRIVATE BLOG REGISTER
                </div>
            </div>
            <div class="rightBoxFrom">
                <form id="registerForm" method="post">
                <div class="input">
                    <img src="resources/images/nickNameRegister.png" style="height: 35px;width: 35px">
                    <input type="text" name="uNickName" class="inputText" placeholder="请输入昵称" id="nickName"/>
                </div>
                <div class="inputPassword">
                    <img src="resources/images/passwordRegister.png" style="height: 35px;width: 35px">
                    <input type="password" name="uPassword" class="inputText"placeholder="请输入账密码" id="pwd"/>
                </div>
                <div class="inputPasswordSecond">
                    <img src="resources/images/passwordSecondRegister.png" style="height: 35px;width: 35px">
                    <input type="password" class="inputText"placeholder="请再次输入账密码" id="pwd2"/>
                </div>
                <div class="inputPasswordEamil">
                    <img src="resources/images/eamilRegister.png" style="height: 35px;width: 35px">
                    <input type="text" name="uEamil" class="inputText"placeholder="请输入邮箱" id="userEamil"/>
                </div>
                </form>
                <div class="inputEamilCode">
                    <img src="resources/images/codeRegister.png" style="height: 35px;width: 35px">
                    <input type="text" class="inputTextEamil"placeholder="请输入邮箱验证码" id="userCode"/>
                    <input type="button" class="sendButton" id="achieveCode"  value="免费获取验证码"/>
                </div>
                  <div class="hint">
                       <span id="hintMassage"></span>
                  </div>
                <div class="registerBox">
                    <input type="button" class="registerButton" value="注册" id="register"/>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="resources/js/blogRegister.js" CHARSET="UTF-8"></script>
</body>
</html>

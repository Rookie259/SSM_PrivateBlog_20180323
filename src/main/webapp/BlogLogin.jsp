<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/2/23
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>沐惜Blog</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="resources/css/rookiieLogin.css">
    <script type="text/javascript" src="resources/js/tool/jquery-3.2.1.js" CHARSET="UTF-8"></script>
</head>
<div class="box">
    <div class="left">
        <div class="leftBox">
        </div>
    </div>
    <div class="right">
        <div class="rightBox">
            <div class="rightBoxUpTitle">
                <div class="write">
                    PRIVATE BLOG LOGIN
                </div>
            </div>
            <div class="rightBoxFrom">
                <form id="loginForm" action="">
                    <div class="input">
                        <img src="resources/images/account.png" style="height: 35px;width: 35px">
                        <input type="text" class="inputText" name="uEamil" id="userEamil" placeholder="请输入邮箱"/>
                    </div>
                    <div class="inputPassword">
                        <img src="resources/images/password.png" style="height: 35px;width: 35px">
                        <input type="password" class="inputText" name="uPassword" id="userPassword"
                               placeholder="请输入账密码"/>
                    </div>
                </form>
                <div class="error" id="errorAccount">
                    <span id="errorSpan"></span>
                </div>
                <div class="forgetPasswordBox">
                    <div class="forgetPassword"><a href="#">忘记密码?</a></div>
                </div>
                <div class="loginBox">
                    <input type="button" class="loginButton" id="loginButton" value="登陆"/>
                </div>

                <div class="othelogin">
                    <div class="otheloginWrite">其他登陆</div>
                </div>
                <div class="icon">
                    <img src="resources/images/qq200.png" style="height: 45px; width: 45px">
                    <img src="resources/images/weixin.png" style="height: 45px; width: 45px">
                </div>
                <div class="registerBox">
                    <div class="register">没有账号?<a href="#" onclick="checkRegister();">注册?</a></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="resources/js/blogLogin.js" CHARSET="UTF-8"></script>
</div>

</body>
</html>

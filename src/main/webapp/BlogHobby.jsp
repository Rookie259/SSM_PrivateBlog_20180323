<%@ page import="com.muxi.reids.ssm.entity.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>心情随笔</title>
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/hobby.css">
    <link rel="stylesheet" href="resources/css/myhobby.css">
    <link rel="stylesheet" href="resources/css/text.css">
    <style>


        .xm-bq {
            margin: 20px 0;
            font-size: 14px;
            color: #333;
        }

        .xm-bq a {
            color: #09c;
            margin: 0 5px;
        }

        .xm-bq a:hover {
            color: #E10602;
        }

        .comment-main {
            display: inline-block;
            *display: inline;
            zoom: 1;
            width: 560px;
            margin: 0 auto;
            border: 1px solid #ddd;
            background: #eee;
            border-radius: 3px;
            text-align: left;
            padding-top: 20px;
            padding-left: 20px;
            padding-right: 20px;
        }

        .comment-main textarea {
            width: 100%;
            border: 1px solid #dcdcdc;
        }

        .comment-main textarea:focus {
            outline: none;
            border-color: #4bf;
        }

        .comment-main a {
            font-size: 12px;
            text-decoration: none;
            color: #09c;
        }

        .comment-main a:hover {
            color: #E10602;
        }


    </style>
</head>
<body>
<!--悬浮按钮-->
<jsp:include page="BlogSuspension.jsp"></jsp:include>
<!--logo-->
<jsp:include page="BlogLogo.jsp"></jsp:include>
<!--菜单-->
<jsp:include page="BlogLabel.jsp"></jsp:include>

<div class="allHobby">
    <div class="leftHobby">
        <div class="publishHobby">
            <%--表情--%>
            <div style="text-align:center;" id="xm">
                <% UserInfo userInfo = (UserInfo) session.getAttribute("user");
                    if (userInfo != null) {
                %>
                <div id="comment" class="comment-main">
                    <textarea name="test" id="rl_exp_input" cols="30" rows="10"></textarea>
                    <%--            <div name="test" style="width: 500px;height: 100px;border: 1px solid black;overflow: auto"
                                     contenteditable="true" id="rl_exp_input" cols="30" rows="10"></div>--%>
                    <a href="javascript:void(0);" id="rl_exp_btn"
                       style="font-size: 15px;font-weight: bold;cursor: pointer">表情</a>
                    <input type="button" id="textButton" value="发表" class="textSub">
                </div>
                <div class="rl_exp" id="rl_bq" style="display:none;">
                    <ul class="rl_exp_tab clearfix">
                        <li><a href="javascript:void(0);" class="selected">默认</a></li>
                        <li><a href="javascript:void(0);">拜年</a></li>
                        <li><a href="javascript:void(0);">浪小花</a></li>
                        <li><a href="javascript:void(0);">暴走漫画</a></li>
                    </ul>
                    <ul class="rl_exp_main clearfix rl_selected" id="1"></ul>
                    <ul class="rl_exp_main clearfix" style="display:none;"></ul>
                    <ul class="rl_exp_main clearfix" style="display:none;"></ul>
                    <ul class="rl_exp_main clearfix" style="display:none;"></ul>
                    <a href="javascript:void(0);" class="close">×</a>
                </div>
                <%
                } else {
                %>
                <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/WriteBlogImage/bugimg3.jpg" style="height: 200px;width: 450px">
                <%
                    }
                %>


            </div>
            <%--表情END--%>
        </div>
        <div class="timerShaft">
            <hr style="height:1px;border:none;border-top:3px solid #555555;margin-top: 15px;width: 90%;margin-left: auto;margin-right: auto"/>
            <ul class="myUl">
                <c:forEach items="${allHobby}" var="hobby">
                    <li class="myUlLi">
                        <div style="height: 15px"></div>
                        <span style="margin-left: 35px;margin-top:20px">
                          <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E6%97%A5%E6%9C%9F.png"
                               style="vertical-align: sub"> <span
                                style="margin-left: 9px;color: #707070">${hobby.etime}</span>
                      </span>
                        <div class="myUlLiText">
                            <p>${hobby.ehobby}</p>
                        </div>
                    </li>
                    <div style='margin-top: 7px;background: #FFFFFF'></div>
                </c:forEach>
            </ul>
        </div>
    </div>
    <!--右部-->
    <div class="reightHobby">
        <%-- <div class="flipCord1">
               <div class="theCordUtl">

               </div>
               <div class="theCordUtl"></div>
               <div class="theCordUtl"></div>
         </div>
         <div class="flipCord2">
             <div class="theCordUt2"></div>
             <div class="theCordUt2"></div>
             <div class="theCordUt2"></div>
         </div>--%>
        <jsp:include page="BlogFilpCord.jsp"></jsp:include>
    </div>
    <!--右部END-->
</div>
<div class="fotter">
    <jsp:include page="BlogFooter.jsp"></jsp:include>
</div>
<script type="text/javascript" src="resources/js/tool/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="resources/js/rl_exp.js"></script>
</body>
</html>

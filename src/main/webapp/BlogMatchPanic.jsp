<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/26
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Contact</title>
    <base href=" <%=basePath%>">
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/common.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/hobby.css">
    <link rel="stylesheet" href="resources/css/matchPanic.css">
    <script type="text/javascript" src="resources/js/tool/jquery-3.2.1.js"></script>
    <style type="text/css">
        @import url("resources/css/matchPanic.css");

        * {
            margin: 0;
            padding: 0;
        }

        *, *:before, *:after {
            box-sizing: border-box;
        }

        html, body {
            height: 100%;
            font: 16px/1 'Open Sans', sans-serif;
            color: #555;
            background: #e5e5e5;
        }

        body {
            padding: 50px;
        }

        .togglebox {
            width: 248px;
            margin: 0 auto;
            background: #fff;
            transform: translateZ(0);
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
        }

        input[type="radio"] {
            position: absolute;
            opacity: 0;
        }

        label {
            position: relative;
            display: block;
            height: 50px;
            line-height: 50px;
            padding: 0 20px;
            font-size: 14px;
            font-weight: 700;
            cursor: pointer;
        }

        label[for*='1'] {
            border: 0;
        }

        label:after {
            content: '\f078';
            position: absolute;
            top: 0px;
            right: 20px;
            font-family: fontawesome;
            transform: rotate(90deg);
            transition: .3s transform;
        }

        section {
            height: 0;
            transition: .3s all;
            overflow: hidden;
        }

        #toggle1:checked ~ label[for*='1']:after,
        #toggle2:checked ~ label[for*='2']:after,
        #toggle3:checked ~ label[for*='3']:after,
        #toggle4:checked ~ label[for*='4']:after {
            transform: rotate(0deg);
        }

        #toggle1:checked ~ #content1,
        #toggle2:checked ~ #content2,
        #toggle3:checked ~ #content3,
        #toggle4:checked ~ #content4 {
            height: auto;
        }

        p {
            margin: 15px 0;
            padding: 0 20px;
            font-size: 12px;
            line-height: 1.5;
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
<div class="all">
    <div class="leftPart">
        <div class="leftMenu">
            <div class="menyTitle">菜单列表</div>
            <%--二级菜单--%>
            <div class="togglebox">
                <input id="toggle1" type="radio" name="toggle"/>
                <label for="toggle1">段 子</label>

                <section id="content1">
                    <ul>
                        <li><span style="margin-left: 20px">暂无段子</span></li>
                    </ul>
                </section>

                <input id="toggle2" type="radio" name="toggle"/>
                <label for="toggle2">小 游 戏</label>

                <section id="content2">
                    <ul>
                        <li onclick="bookFun('1');"><span style="margin-left: 20px">下 水 道 王 子</span>
                        </li>
                    </ul>
                </section>

                <input id="toggle3" type="radio" name="toggle"/>
                <label for="toggle3">音 乐</label>

                <section id="content3">
                    <ul>
                        <li><span style="margin-left: 20px">暂无音乐</span></li>
                    </ul>
                </section>

                <input id="toggle4" type="radio" name="toggle"/>
                <label for="toggle4">书 屋</label>

                <section id="content4">
                    <ul>
                        <li><span style="margin-left: 20px">暂无书屋</span></li>
                    </ul>
                </section>
            </div>
            <%--二级菜单END--%>
        </div>
    </div>


    <%--右部分--%>
    <div class="rightPart">
        <div id="referrers1" style="height: auto;width: auto;display: none">
            <jsp:include page="sewer.jsp"></jsp:include>
        </div>
    </div>
    <%--右部分END--%>
</div>

<script>
    function bookFun(check) {
        if(check == '1')
            $("#referrers1").css('display','block');
    }
</script>
<jsp:include page="BlogFooter.jsp"></jsp:include>
</body>
</html>

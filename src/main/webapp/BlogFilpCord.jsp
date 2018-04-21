<%--
  Created by IntelliJ IDEA.
  User: 沐惜
  Date: 2018/3/30
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>翻转</title>
    <base href=" <%=basePath%>">
    <link rel="stylesheet" href="resources/css/filpCord.css">
    <script type="text/javascript" src="resources/js/tool/jquery-1.7.2.min.js"></script>
</head>
<body>
<div class="wrapper">
    <ul>
        <li>
            <div class='picBox'>
                <div class='show'>
                    <img src="resources/images/cord/pic4-1.png" height='180px' width='180px'>
                </div>
                <a href="writeBlog/achieveBlog">
                    <div class='hide'>
                        <h3>
                            网 站 首 页
                        </h3>
                    </div>
                </a>
            </div>
        </li>
        <li>
            <div class='picBox'>
                <div class='show'>
                    <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/hobby/java.jpg" height='180px'
                         width='180px'>
                </div>
                <div class='hide'>
                    <h3>
                        技 术 论 帖
                    </h3>
                </div>
            </div>
        </li>
        <li>
            <div class='picBox'>
                <div class='show'>
                    <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/hobby/blog.jpg" height='180px'
                         width='180px'>
                </div>
                <a href="BlogLeaveNote.jsp">
                    <div class='hide'>
                        <h3>
                            Blog 留 言
                        </h3>
                    </div>
                </a>
            </div>
        </li>
        <li>
            <div class='picBox'>
                <div class='show'>
                    <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/hobby/%E9%98%BF%E4%B9%A0_%E9%98%BF%E4%B9%A0-%E8%BF%87%E5%BE%80%E4%BA%91%E7%83%9F%7Bvcd%7D.jpg"
                         height='180px' width='180px'>
                </div>
                <a href="BolgPhotos.jsp">
                    <div class='hide'>
                        <h3>
                            过 往 云 烟
                        </h3>
                    </div>
                </a>
            </div>
        </li>
        <li>
            <div class='picBox'>
                <div class='show'>
                    <img src="resources/images/cord/pic2-1.png" height='180px' width='180px'>
                </div>
                <div class='hide'>
                    <h3>
                        Picture5
                    </h3>
                </div>
            </div>
        </li>
        <li>
            <div class='picBox'>
                <div class='show'>
                    <img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/hobby/8921616_153752003385_2.jpg"
                         height='180px' width='180px'>
                </div>
                <a href="BlogMatchPanic.jsp">
                    <div class='hide'>
                        <h3>
                            休 闲 一 刻
                        </h3>
                    </div>
                </a>
            </div>
        </li>
    </ul>
</div>

<script type="text/javascript" src="resources/js/filpCord.js"></script>
</body>
</html>

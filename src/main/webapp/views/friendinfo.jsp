<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>My JSP 'info.jsp' starting page</title>
<link href="static/img/css.css" rel="stylesheet"/>
<link href="static/css/easyui.css" rel="stylesheet"/>
</head>
<body>
				<div class="inner">
					<div class="hd">
						<h3>基本资料
						<c:if test="${friend.state==1}">
						<a href="<%=path%>/user/feelmy?userid=${user.userid }&currentPage=1" target="iframepage" class="comfirm">说说</a>
						<a href="<%=path%>/user/showMessages?receiveid=${user.userid }&currentPage=1" target="_self" class="comfirm">留言板</a>
						<a href="<%=path%>/blackFriend?friendmapid=${friend.friendmapid }" class="comfirm" target="iframepage" onclick="return operaconfirm('拉黑');">拉黑</a>
						<a href="<%=path%>/outfriend?friendmapid=${friend.friendmapid }" class="comfirm" target="iframepage" onclick="return operaconfirm('删除');">删除</a>
						</c:if>
						<c:if test="${friend.state==-1 }">
						  <a href="<%=path%>/hfFriend?friendmapid=${friend.friendmapid }" class="comfirm" target="iframepage" onclick="return operaconfirm('恢复好友');" >恢复</a>
					      <a href="<%=path%>/outfriend?friendmapid=${friend.friendmapid}" class="comfirm" target="iframepage"  onclick="return operaconfirm('删除');">删除</a>
						</c:if>
						<c:if test="${friend.state==0 }">
						   <a href="<%=path%>/outfriend?friendmapid=${friend.friendmapid }" class="comfirm" target="iframepage"  onclick="return operaconfirm('拒绝');">拒绝</a>
						   <a href="<%=path%>/agreeFriend?friendmapid=${friend.friendmapid}" class="comfirm" target="iframepage">同意</a>
						</c:if>
						</h3>
					</div>
					<div class="infos">
					    QQ号码：${friend.user.qq}<br>
						昵称：${friend.user.username}<br> 
					 	性别：
						<c:if test="${friend.user.sex==1}">男</c:if>
						<c:if test="${friend.user.sex==0}">女</c:if>
						<br>  
						出生日期：${friend.user.birthday}<br>
						<c:if test="${!empty friend.user.hometown }">
							家乡住址：${friend.user.hometown}<br>
						</c:if>
						<c:if test="${empty friend.user.hometown }">
							家乡住址：未填写<br>
						</c:if>
						<c:if test="${!empty friend.user.nowaddress }">
							现在住址：${friend.user.nowaddress}<br>
						</c:if>
						<c:if test="${empty friend.user.nowaddress }">
							现在住址：未填写<br>
						</c:if>
					 	婚姻状况：
						<c:if test="${friend.user.ismarry==1}">是</c:if>
						<c:if test="${friend.user.ismarry==0}">否</c:if>
						<c:if test="${friend.user.ismarry==-1}">保密</c:if> 
						<br>  
						成为好友时间：
						<c:if test="${!empty friend.addtime}">
							${friend.addtime }<br>
						</c:if>
				</div>
				<c:if test="${empty friend.state }">
				<div class="inner">
					<div class="hd">
						<h3>登陆信息</h3>
					</div>
					<div class="infos">
					 	QQ状态：
						<c:if test="${friend.user.state==1}">正常</c:if>
						<c:if test="${friend.user.state==0}">冻结</c:if> 
						<br>  
						最近登录时间：${friend.user.lastvisit}<br>
					</div>
				</div>
				</c:if>
				
	<script type="text/javascript" src="static/js/jquery.js"></script>	
	<script type="text/javascript" src="static/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		  $(function() {
			  $(".comfirm").linkbutton();
		  });
	</script>
	<script type="text/javascript">
		function operaconfirm(opera) {
			question = confirm("你确认要"+opera+"么");
			if (question != "0") {
				return true;
			}
			return false;
		}
	</script>
</body>
</html>

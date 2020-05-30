<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hbsi.bean.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>top</title>
<style type="text/css">
.tb{
	background-image: url(/jiuyeGL/images/top-right.gif);
	background-repeat: repeat-x;
}
.td{
	font-size: 12px;
	color: #ffffff;
	height: 38px;
	line-height: 38px;
}
</style>
<script type="text/javascript">
function logout(){
	var flag=window.confirm("确定退出登录吗？");
	if (flag) {
		top.location="exit.jsp";
	}
	return false;
}
</script>
</head>
<body>
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="tb">
<tr>
<td width="61%" height="64">
<img alt="logo" src="/jiuyeGL/images/logo.gif" width="262" height="64" >
</td>
<td width="39%" height="64" valign="top">
<table width="100%" border="0"  cellpadding="0" cellspacing="0">
<tr>
<td width="75%"  height="38" class="td">
		<%
		User u=(User)session.getAttribute("user");
		if(u.getUsertypes().equals("admin")){
		%>
		管理员
		<%
		}
		if(u.getUsertypes().equals("student")){	
		%>
		学生
		<%
		}
		if(u.getUsertypes().equals("company")){		
		%>
		公司
		<% } %>
     	<%=u.getUsername()%>你好，欢迎登录！
</td>
<td>
	<a href="#" target="_self" onclick="logout()">
		<img src="/jiuyeGL/images/out.gif" width="46" height="20" border="0">
	</a>
</td>
</tr>
</table>
</td>
</tr>
</table>
</body>
</html>
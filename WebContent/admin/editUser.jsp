<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
</head>
<script type="text/javascript">
 function check(){
	 if(document.getElementById("password").value==""){
		 alert("请输入新的密码！");
		 window.event.returnValue=false;
	 }else{
		 window.event.returnValue=true;
	 }
 }
</script>
<body>
<form action="/jiuyeGL/userManage" method="post" onsubmit="check()">
<input type="hidden" value="update" name="action">
<input type="hidden" value="${param.id }" name="id">
<table border="0" width="350" height="150">
  <tr>
    <td>新密码：</td>
    <td><input type="password" name="password" id="password"></td>
  </tr>
  <tr>
    <td colspan="2">
    <input type="submit" name="bt1" value="提交">
    <input type="reset" name="bt2" value="重置">
    </td>
  </tr>
</table>
</form>
</body>
</html>
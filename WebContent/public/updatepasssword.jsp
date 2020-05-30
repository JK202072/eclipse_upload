<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<style type="text/css">
 body{
    fone-size:12px;
 }
 .tb{
    width:350;
    height:161px;
    margin-left:50px;
    margin-top:50px;
    border-style: 1px solid #99CCFF;
 
 }
</style>
<script type="text/javascript">
function check() {
	var oldpwd=document.getElementById("old").value;
	var hidpwd=document.getElementById("hidold").value;
	var newpwd=document.getElementById("password").value;
	if(oldpwd!=hidpwd){
		alert("旧密码不正确，请重新输入");
		return false;
	}else if ((newpwd=="")||(newpwd.length==0)) {
		alert("请输入密码");
		return false;
	}else {
		return true;
	}
}

</script>
</head>
<body bgcolor="e6e6fa">
<form action="/jiuyeGL/userManage" method="post" onsubmit="return check()">
   <table class="tb">
     
     <tr>
         <td>用户名：</td>
         <td><c:out value="${user.username }"></c:out>
         <input type="hidden" name="id" value="${user.id}"></td>
     </tr>
     <tr>
         <td>旧密码：</td>
         <td>
             <input type="hidden" name="hidold" value="${user.password }" id="hidold">
             <input type="password" name="old" id="old">
         </td>
     </tr>
     <tr>
         <td>新密码：</td>
         <td>
             <input type="password" name="password" id="password">
             <input type="hidden" name="action" value="update">
         </td>
     </tr>
     <tr>
         <td colspan="2" align="center">
         <input type="submit" value="修改">
         <input type="reset" value="重置">
         </td>
     </tr>
   
   </table>
 
</form>
</body>
</html>
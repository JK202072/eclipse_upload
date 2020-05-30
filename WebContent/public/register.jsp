<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 用户注册页面</title>
<style type="text/css">
  body{
    background-image:url("/jiuyeGL/images/bj.png");
    background-repeat: no-repeat;
    background-position: center 0;
    background-size:100% 100%;
    background-attachment: fixed;
  }
  .regtitle{
    font-family:楷体 _gb2312;
    font-size:16px;
    line-height:40px;
    color:#333333;
  }
  .regtxtbt{
    font-family:楷体,Arial;
    font-size:16px;
    color:#000000;
    height:38px;
    line-height:38px;
  }
  .regtxt{
    font-family:宋体,Arial;
    font-size:25px;
    color:#000000;
    line-height:25px;
    text-align:right;
    font-weight:bold;
  }
  #usernamemessage{
    font-size:12px;
    line-height:25px;
    color:#FF0000;
  }
  #pwdmessage{
    font-size:12px;
    line-height:25px;
    color:#FF0000;
  }
  h1{
    color:white; 
    text-shadow: 5px 5px 1px #000; 
    font-size:50px;
  }
  .sub{
    width:300px; 
    height:35px; 
    font-size:25px;
    background-color: #FFFFCC;
  }
  input{
    font-size:20px;
  }
</style>
<script type="text/javascript">
function checkUser(){
	var name=document.form1.username.value;
	var flag=document.form1.uflag.value;
	if((name==null)||(name.length==0)){
		document.getElementById("usernamemessage").innerHTML="用户名不能为空";
		return false;
	}else if(flag=="no"){
		document.forms["form1"].method="post";
		document.forms["form1"].username.value=name;
		document.forms["form1"].action="checkUser.jsp";
		document.forms["form1"].submit();
	}
	else{
		return true;
	}
}
function checkPassword(){
	var password=document.form1.password.value;
	if((password==null)||(password.length==0)){
		document.getElementById("pwdmessage").innerHTML="密码不能为空";
		return false;
	}else{
		return true;
	}
}
function submitForm(){
	return(checkUser())&&(checkPassword());
}
</script>
</head>
<body>
<h1 align="center">毕   业   生   就    业    信    息    管    理    系    统</h1>
<form name="form1" action="/jiuyeGL/register" method="post" onSubmit="return submitForm();">
   <table border=0 style="width:100% ;height:100%">
    <tr><td align="center" valign="middle">
   <table style=" margin:30px;auto">
   <h1 height="100px" align="center">用户注册</h1>
     <tr>
       <td width="25%" height="38px" align="right">
         <span class="regtxt">用户名：</span>
       </td>
       <td colspan="1">
       <%
         String flag="no";
         Object uflag=request.getAttribute("userflag");
         if(uflag!=null){
        	 flag=String.valueOf(uflag);
         }
       %>
       <input type="hidden" name="uflag" value="<%=flag%>">
       <%
         String uname="";
         Object username=request.getAttribute("uname");
         if(username!=null){
        	 uname=String.valueOf(username);
         }
       %>
       
       <input type="text" name="username" size="20" value="<%=uname %>" onblur="checkUser()">
       <%
         Object msgObj=request.getAttribute("usermessage");
         String msg="";
         if(msgObj!=null){
        	 msg=String.valueOf(msgObj);
         }
       %>
       <span id="usernamemessage"><%=msg %></span>
       </td>
     </tr>
     <tr>
       <td width="20%" height="38" align="right">
         <span class="regtxt">密  码：</span>
       </td>
       <td colspan="2">
       <input type="password" name="password" size="20" onblur="checkPassword();">
        <img alt="1" src="/jiuyeGL/images/luck.gif" width="19" height="18">
        <span id="pwdmessage"></span>
       </td>
     </tr>
     <tr>
       <td width="20%" height="38" align="right">
        <span class="regtxt">用户身份：</span>
       </td>
       <td colspan="2">
         <input type="radio" name="usertypes" value="student">
         <span class="regtxt">学生</span>&nbsp;&nbsp;&nbsp;
         <input type="radio" name="usertypes" value="company">
         <span class="regtxt">企业</span>&nbsp;&nbsp;&nbsp;
         <input type="radio" name="usertypes" value="admin">
         <span class="regtxt">管理员</span>&nbsp;&nbsp;&nbsp;
        </td>
      </tr>
      <tr>
       <td colspan="2" align="center">
         <input type="submit" class="sub" value=" 注       册 " >&nbsp;&nbsp;&nbsp;
       </td>
      </tr>
      <tr>
       <td colspan="2" class="regtxt">
       <a href="/jiuyeGL/public/login.jsp">已有注册用户，请登录</a>
      </tr>
   </table>
   </td>
   </tr>
   </table>
</form>
</body>
</html>
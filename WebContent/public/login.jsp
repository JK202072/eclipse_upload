<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function refresh(){
	document.getElementById("codeimage").src="/jiuyeGL/createImage?"+new Date();
}
</script>
<title>登录</title>
<style type="text/css">
  body{
    background-image:url("/jiuyeGL/images/bj.png");
    background-repeat: no-repeat;
    background-position: center 0;
    background-size:100% 100%;
    background-attachment: fixed;
  }
  #errorMsg{
    font-size:12px;
    line-height:25px;
    color:#FF0000;
  }
  .logtxt{
    font-family:宋体,Arial;
    font-size:25px;
    color:#000000;
    line-height:35px;
    text-align:right;
    font-weight:bold;
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
    background-color: #CCFFFF;
  }
  input{
    font-size:20px;
  }
</style>
</head>
<body>
<h1 align="center">毕   业   生   就    业    信    息    管    理    系    统</h1>
<form action="/jiuyeGL/checkCode" method="post" name="form1">
<table border=0 style="width:100% ;height:100%">
<tr><td align="center" valign="middle">
   <table style=" margin:30px;auto; width:500px">
   <h1 height="100px" align="center">用户登录</h1>
     <tr>
       <td width="30%" class="logtxt">用户名：</td>
       <td width="70%">
         <input name="username" size="20">
       </td>
     </tr>
     <tr>
       <td class="logtxt">密   码：</td>
       <td>
         <input type="password" size="20" name="password">
       </td>
     </tr>
     <tr>
       <td class="logtxt">用户身份：</td>
       <td>
         <input type="radio" value="student" name="usertypes" checked/>
          <span class="logtxt">学生</span>&nbsp;&nbsp;&nbsp;
         <input type="radio" value="company" name="usertypes" />
          <span class="logtxt">企业</span>&nbsp;&nbsp;&nbsp;
         <input type="radio" value="admin" name="usertypes" />
          <span class="logtxt">管理员</span>&nbsp;&nbsp;&nbsp;
       </td>
     </tr>
     <tr>
        <td class="logtxt"><span>验证码：</span></td>
        <td colspan="2"><input type="text" name="code" size="6">
        <img alt="*" src="/jiuyeGL/createImage" onclick="refresh()"id="codeimage" title="点击更换图片">
        <span class="errorcode">${codeMsg} </span> </td>
     </tr>
     <tr>
       <td class="logtxt"><a href="/jiuyeGL/public/register.jsp">用户注册:</a></td>
        <td colspan="3" height="35">
       <%
        Object errorMsg=request.getAttribute("errorMsg");
       String adm="";
       if(errorMsg!=null){
    	   adm=String.valueOf(errorMsg);
       }
       %>
       <samp id="errorMsg"><%=adm %> </samp>
       </td>
     </tr>
     <tr>
      <td colspan="2" align="center">
         <input name="Submiot" type="submit" class="sub" value=" 登        录 "/>
       </td>
     </tr>
   </table>
   </td>
   </tr>
   </table>
</form>
</body>
</html>
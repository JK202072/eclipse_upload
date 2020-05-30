<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>就业信息</title>
<style type="text/css">
   body{
     background-color: #e6e6fa;
   }
</style>
</head>
<body>
<form action="/jiuyeGL/employmentManage" method="post">
 <table width="500px" border="0" cellpadding="0" cellspacing="0" align="center">
   <tr>
     <td>
     <input type="hidden" name="action" value="add">
     </td>
   </tr>
   <h1>发布就业信息</h1>
          <tr>
              <td align="right" height="30">学生姓名：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="studentname" size="30"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">毕业学校：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="school" size="30"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">就职公司：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="companyname" size="30"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">就职岗位：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="position" size="30"/>
              </td>
          </tr>
           <tr>
       <td width="20%" height="38">&nbsp;</td>
       <td>
         <input name="Submit" type="submit" value="提交">&nbsp;&nbsp;&nbsp;
         <input name="cs" type="reset" value="重置">
       </td>
      </tr>
      
 </table>
</form>
</body>
</html>
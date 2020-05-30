<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生基本信息</title>
<link href="/jiuyeGL/css/stucss.css" rel="stylesheet" type="text/css">
</head>
<body>
   <table class="regtable" width="500" align="center" border="0" cellpadding="5" cellspcing="1">
     <caption class="txt">学生个人基本信息</caption>
     <tr>
       <td></td>
     </tr>
     <tr>
       <td valign="top" width="500" bgcolor="#f9f9f9" height="350">
         <table width="500" align="center" border="0" cellpadding="0" cellspcing="0">
         <tr>
            <td colspan="2" class="tdinfo" height="25">
              <span style="font-weight:bold;">学生基本信息</span>
            </td>
            <td colspan="2"></td>
         </tr>
         <tr>
            <td align="right" height="30" width="130">姓名：</td>
            <td width="370" align="left">
            <input type="text" readonly="readonly" name="sname" value="${student.sname}" size="30"/>
            </td>
         </tr>
          <tr>
            <td align="right" height="30" >性别：</td>
            <td width="370" >
            <input type="text" readonly="readonly" name="gender" value="${student.gender}" size="50"/>
            </td>
         </tr>
         <tr>
            <td align="right" height="30" width="130" >身份证号：</td>
            <td width="370" >
            <input type="text" readonly="readonly" name="idnumber" value="${student.idnumber}" size="50"/>
            </td>
         </tr>
         <tr>
            <td align="right" height="30" >学校：</td>
            <td >
            <input type="text" readonly="readonly" name="school" value="${student.school}" size="50"/>
            </td>
         </tr>
         <tr>
            <td align="right" height="30" >院系：</td>
            <td >
            <input type="text" readonly="readonly" name="department" value="${student.department}" size="50"/>
            </td>
         </tr>
         <tr>
            <td align="right" height="30" >专业：</td>
            <td>
            <input type="text" readonly="readonly" name="major" value="${student.major}" size="50"/>
            </td>
         </tr>
         <tr>
            <td align="right" height="30" >学历：</td>
            <td width="370" >
            <input type="text" readonly="readonly" name="education" value="${student.education}" size="20"/>
            </td>
         </tr>
         <tr>
            <td align="right" height="30" >入学时间：</td>
            <td >
            <input type="text" readonly="readonly" name="entrancedate" value="${student.entrancedate}"/>
            </td>
         </tr>
         <tr>
            <td align="right" height="30" width="130" >籍贯：</td>
            <td width="370" >
            <input type="text" readonly="readonly" name="nativeplacew" value="${student.nativeplace}" size="50"/>
            </td>
         </tr>
         <tr>
             <td colspan="2"></td>
         </tr>
   </table>
</body>
</html>
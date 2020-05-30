<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
  <meta charset="UTF-8"> 
    <title>企业查看学生简历投递情况</title>    
	<style type="text/css">
	   body{
	     background-color:#e6e6fa;
	   }
	   *{
	     font-size:12px;
	   }               
	   
	</style>
	
  </head>  
  <body>
     <form action="/jiuyeGL/recruitResumeManage" method="post">
        <table width="80%" border="1">
           <tr bgcolor="#DCDCDC">
              <th width="15%" height="30px">招聘部门</th>
              <th width="15%" height="30px">招聘人数</th>
              <th width="15%" height="30px">职位性质</th>
              <th width="15%" height="30px">工作地点</th>
              <th width="25%" height="30px">操作</th>              
           </tr>           
           <c:forEach var="recruit" items="${recruitlist}">
            <tr>
              <td align="center" height="26px">
                <c:out value="${recruit.branch}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${recruit.recruitment}"></c:out>
              </td>
               <td align="center" height="26px">
                <c:out value="${recruit.positiontype}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${recruit.workingplace}"></c:out>
              </td>
              <td align="center" height="26px">
                <a href="/jiuyeGL/recruitResumeManage?action=showresumes&rid=${recruit.rid}">查看</a>                              
              </td>
            </tr>
           </c:forEach>
        </table>
     </form>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>就业信息管理</title>
<style type="text/css">
   body{
     background-color: #e6e6fa;
   }
   *{
     font-size: 12px;
   }
</style>
</head>
<body>
 <form action="/jiuyeGL/employmentManage" method="post">
 <c:set var="dopage" value="${doPage }"></c:set>
 <c:set var="list" value="${dopage.list }"/>
    <table width="80%" border="1">
      <tr bgcolor="#DCDCDC">
       <c:choose>
        <c:when test="${user.usertypes eq 'admin'}">
         <th width="20%" height="30px">学生名字</th>
         <th width="20%" height="30px">学校名字</th>
         <th width="20%" height="30px">就业公司</th>
         <th width="20%" height="30px">就业岗位</th>
         <th width="20%" height="30px">操作</th>
        </c:when>
         <c:otherwise>
         <th width="25%" height="30px">学生名字</th>
         <th width="25%" height="30px">学校名字</th>
         <th width="25%" height="30px">就业公司</th>
         <th width="25%" height="30px">就业岗位</th>
         </c:otherwise>
       </c:choose>
      </tr>
      <c:forEach var="employment" items="${list }">
      <tr>
        <td align="center" height="26px">
           <c:out value="${employment.studentname }"></c:out>
        </td>
         <td align="center" height="26px">
           <c:out value="${employment.school }"></c:out>
        </td>
         <td align="center" height="26px">
           <c:out value="${employment.companyname }"></c:out>
        </td>
         <td align="center" height="26px">
           <c:out value="${employment.position }"></c:out>
        </td>
           <c:choose>
               <c:when test="${user.usertypes eq 'admin'}">
                  <td align="center" height="26px">
                    <a href="/jiuyeGL/employmentManage?action=employmentedit&eid=${employment.eid }">修改</a>
                    <a href="/jiuyeGL/employmentManage?action=delete&eid=${employment.eid }">删除</a>
                    </td>
               </c:when>
          </c:choose>
         
       </tr>
    </c:forEach>
    <tr>
	     <td colspan="6" align="right">                     
			 <a href="/jiuyeGL/employmentManage?action=list&page=1">首页</a> &nbsp;&nbsp;
			 <c:if test="${dopage.nowPage-1>0}">
			   <a href="/jiuyeGL/employmentManage?action=list&page=${dopage.nowPage-1}">上一页
				</a>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${dopage.nowPage+1<=dopage.totalPage}">
            &nbsp;&nbsp;&nbsp;
               <a href="/jiuyeGL/employmentManage?action=list&page=${dopage.nowPage+1}">下一页</a>
            </c:if>
			   &nbsp;&nbsp;
			     <a href="/jiuyeGL/employmentManage?action=list&page=${dopage.totalPage}">末页</a>
				&nbsp;&nbsp;
				共${dopage.totalPage }页
        </td>
     </tr>
           <tr>
            <td colspan="6" height="26px">按学生名模糊搜索
                <input type="hidden" name="action" value="list"/>
				<input type="text" name="sql"/>
				<input type="submit" value="搜索"/></td>           
           </tr>
 </table>
</form>
</body>
</html>
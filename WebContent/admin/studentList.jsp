<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理</title>
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
 <form action="/jiuyeGL/studentManage" method="post">
 <c:set var="dopage" value="${doPage }"></c:set>
 <c:set var="list" value="${dopage.list }"/>
    <table width="80%" border="1">
      <tr bgcolor="#DCDCDC">
        <th width="20%" height="30px">姓名</th>
       <th width="20%" height="30px">性别</th>
       <th width="20%" height="30px">毕业学校</th>
       <th width="20%" height="30px">专业</th>
       <th width="20%" height="30px">操作</th>
      </tr>
      <c:forEach var="student" items="${list }">
      <tr>
        <td align="center" height="26px">
           <c:out value="${student.sname }"></c:out>
        </td>
         <td align="center" height="26px">
           <c:out value="${student.gender }"></c:out>
        </td>
         <td align="center" height="26px">
           <c:out value="${student.school}"></c:out>
        </td>
         <td align="center" height="26px">
           <c:out value="${student.major }"></c:out>
        </td>
         <td align="center" height="26px">
           <a href="/jiuyeGL/studentManage?action=show&sid=${student.sid }">查看</a>
           <a href="/jiuyeGL/studentManage?action=delete&sid=${student.sid }">删除</a>
        </td>
       </tr>
      </c:forEach>
      <tr>
	     <td colspan="6" align="right">                     
			 <a href="/jiuyeGL/studentManage?action=studentlist&page=1">首页</a> &nbsp;&nbsp;
			 <c:if test="${dopage.nowPage-1>0}">
			   <a href="/jiuyeGL/studentManage?action=studentlist&page=${dopage.nowPage-1}">上一页
				</a>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${dopage.nowPage+1<=dopage.totalPage}">
            &nbsp;&nbsp;&nbsp;
               <a href="/jiuyeGL/studentManage?action=studentlist&page=${dopage.nowPage+1}">下一页</a>
            </c:if>
			   &nbsp;&nbsp;
			     <a href="/jiuyeGL/studentManage?action=studentlist&page=${dopage.totalPage}">末页</a>
				&nbsp;&nbsp;
				共${dopage.totalPage }页
        </td>
     </tr>
           <tr>
            <td colspan="6" height="26px">按姓名模糊搜索
                <input type="hidden" name="action" value="studentlist"/>
				<input type="text" name="sql"/>
				<input type="submit" value="搜索"/></td>           
           </tr>
    </table>
 </form>
</body>
</html>
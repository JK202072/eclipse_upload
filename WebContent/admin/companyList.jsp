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
 <form action="/jiuyeGL/companyManage" method="post">
 <c:set var="dopage" value="${doPage }"></c:set>
 <c:set var="list" value="${dopage.list }"/>
    <table width="80%" border="1">
      <tr bgcolor="#DCDCDC">
        <th width="20%" height="30px">公司名称</th>
       <th width="20%" height="30px">单位性质</th>
       <th width="20%" height="30px">营业执照号</th>
       <th width="20%" height="30px">所属行业</th>
       <th width="20%" height="30px">操作</th>
      </tr>
      <c:forEach var="comapny" items="${list }">
      <tr>
        <td align="center" height="26px">
           <c:out value="${comapny.companyname }"></c:out>
        </td>
         <td align="center" height="26px">
           <c:out value="${comapny.unitproperty }"></c:out>
        </td>
         <td align="center" height="26px">
           <c:out value="${comapny.licensenumber}"></c:out>
        </td>
         <td align="center" height="26px">
           <c:out value="${comapny.industry }"></c:out>
        </td>
         <td align="center" height="26px">
           <a href="/jiuyeGL/companyManage?action=show&cid=${comapny.cid }">查看</a>
           <a href="/jiuyeGL/companyManage?action=delete&cid=${comapny.cid }">删除</a>
           <a href="/jiuyeGL/companyManage?action=choose&cid=${comapny.cid }">发布招聘</a>
        </td>
       </tr>
      </c:forEach>
      <tr>
	     <td colspan="6" align="right">                     
			 <a href="/jiuyeGL/companyManage?action=companylist&page=1">首页</a> &nbsp;&nbsp;
			 <c:if test="${dopage.nowPage-1>0}">
			   <a href="/jiuyeGL/companyManage?action=companylist&page=${dopage.nowPage-1}">上一页
				</a>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${dopage.nowPage+1<=dopage.totalPage}">
            &nbsp;&nbsp;&nbsp;
               <a href="/jiuyeGL/companyManage?action=companylist&page=${dopage.nowPage+1}">下一页</a>
            </c:if>
			   &nbsp;&nbsp;
			     <a href="/jiuyeGL/companyManage?action=companylist&page=${dopage.totalPage}">末页</a>
				&nbsp;&nbsp;
				共${dopage.totalPage }页
        </td>
     </tr>
      <tr>
            <td colspan="6" height="26px">按公司名模糊搜索
                <input type="hidden" name="action" value="companylist"/>
				<input type="text" name="sql"/>
				<input type="submit" value="搜索"/></td>           
           </tr>
    </table>
 </form>
</body>
</html>
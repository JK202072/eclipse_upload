<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="ck" uri="http://ckeditor.com" %>
<!DOCTYPE html>
<html>
<head>

 <style type="text/css">	
      body{
         background-color: #e6e6fa;
      }  	 
	  .t1{
	     font-size:12px;
	     margin-top:15px;
	  }
	  .t1 tr{
	      line-height:30px;	    
	  }
	  .t1 th{
	       font-size:12px;
	       line-height:30px;
	       font-weight:bold;
	       text-align:left;
	  }
	  .t1 td{
	    font-size:12px;
	      text-align:left;
	  }	  
	  .pagediv{
	      font-size:12px;
	      float:right;
	      margin-right:180px;
	  }
	 
</style>
<script type="text/javascript" src="/jiuyeGL/ckeditor/ckeditor.js"></script>
<meta charset="UTF-8">
<title>查看留言</title>
</head>
<body>
<form action="/jiuyeGL/messageManage" method="post">
<table class="t1" border="0" cellpadding="0" cellspacing="0" width="60%" align="center">
<c:set var="dopage" value="${doPage }"></c:set>
<c:set var="list" value="${dopage.list }"/>
<c:forEach var="message" items="${list}">
<tr>
   		<td>
   		<table bgcolor="#F7F8F9" width="100%" frame="box" bordercolor="#000"/>
   			<tr>
   				<td width="20%">
   					<strong> 留言用户:</strong><c:out value="${message.username }"></c:out>
   				</td>
   				<td bgcolor="#F7F8F9" width="50%">
   					<strong> 留言标题:</strong><c:out value="${message.title }"></c:out>
   				</td>
   				<td width="30%">
   					<strong> 留言时间:</strong><c:out value="${message.msgtime }"></c:out>
   				</td>
   				</tr>
   				<tr>
   				<td colspan="3"><strong>留言内容:</strong></td>
   				</tr>
   				<tr>
   				<td colspan="3">
   					<c:out value="${message.content }" escapeXml="false"></c:out>
   				</td>
   				</tr>
   				<tr>
   				<td colspan="3"><strong>留言回复:</strong></td>
   				</tr>
   				<tr>
   				<td colspan="3">
   					<c:out value="${message.reply }" escapeXml="false"></c:out>
   				</td>
   				</tr>
   				<c:if test="${user.usertypes eq 'admin' }">
   					<tr>
   						<td colspan="3">
   						<a href="/jiuyeGL/messageManage?action=show&mid=${message.mid}">回复留言</a>
		                <a href="/jiuyeGL/messageManage?action=delete&mid=${message.mid}">删除留言</a>
   						</td>
   					</tr>
   				</c:if>
   		</table>
   		</td>
  </tr>
 </c:forEach>
	<tr>
	     <td>		                         
		 <div class="pagediv">
             <span>
			 <a href="/jiuyeGL/messageManage?action=list&page=1">首页</a> &nbsp;&nbsp;
			 <c:if test="${dopage.nowPage-1>0}">
			   <a href="/jiuyeGL/messageManage?action=list&page=${dopage.nowPage-1}">上一页
				</a>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${dopage.nowPage+1<=dopage.totalPage}">
            &nbsp;&nbsp;&nbsp;
               <a href="/jiuyeGL/messageManage?action=list&page=${dopage.nowPage+1}">下一页</a>
            </c:if>
			   &nbsp;&nbsp;
			     <a href="/jiuyeGL/messageManage?action=list&page=${dopage.totalPage}">末页</a>
				&nbsp;&nbsp;
				共${dopage.totalPage }页
		  </span>		  
        </div>
        </td>
     </tr>
  </table>
</form>
</body>
</html>

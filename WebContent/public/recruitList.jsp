<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>企业招聘信息管理</title>    
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
     <form action="/jiuyeGL/recruitManage" method="post">
        <c:set var="dopage" value="${doPage}" />
        <c:set var="list"  value="${dopage.list }"></c:set>	
        <table width="80%" border="1">
           <tr bgcolor="#DCDCDC">
              <th width="15%" height="30px">公司名称</th>
              <th width="15%" height="30px">招聘人数</th>
              <th width="15%" height="30px">工作地点</th>
              <th width="15%" height="30px">职位性质</th>
              <th width="15%" height="30px">学历要求</th>
              <th width="25%" height="30px">操作</th>              
           </tr>           
           <c:forEach var="recruit" items="${list}">
            <tr>
              <td align="center" height="26px">
                <c:out value="${recruit.companyname}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${recruit.recruitment}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${recruit.workingplace}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${recruit.positiontype}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${recruit.edurequire}"></c:out>
              </td>
              <td align="center" height="26px">
                <a href="/jiuyeGL/recruitManage?action=show&rid=${recruit.rid}">查看</a>|                
                <c:choose>
                   <c:when test="${user.usertypes eq 'student'}">
                      <a href="/jiuyeGL/recruitResumeManage?action=post&rid=${recruit.rid}&cid=${recruit.cid}&sid=${user.id}">投递简历</a>
                   </c:when>
                   <c:otherwise>
                      <a href="/jiuyeGL/recruitManage?action=recruitedit&rid=${recruit.rid}">修改</a>|
                      <a href="/jiuyeGL/recruitManage?action=delete&rid=${recruit.rid}">删除</a>
                   </c:otherwise>
                </c:choose>                
              </td>
            </tr>
           </c:forEach>
           <tr>
				<td colspan="6" align="right">
					<a href="/jiuyeGL/recruitManage?action=recruitlist&page=1&sql=${dopage.sql}">首页</a>
					&nbsp;&nbsp;
					<c:if test="${dopage.nowPage-1>0}">
						<SPAN class=Unable><a
							href="/jiuyeGL/recruitManage?action=recruitlist&page=${dopage.nowPage-1}&sql=${dopage.sql}">上一页
						</a> </SPAN>
					</c:if>
					&nbsp;&nbsp;
					<c:if test="${dopage.nowPage+1<=dopage.totalPage}">
            &nbsp;&nbsp;&nbsp;
              <a  href="/jiuyeGL/recruitManage?action=recruitlist&page=${dopage.nowPage+1}&sql=${dopage.sql}">下一页</a>
					</c:if>
					&nbsp;&nbsp;
					<a 	href="/jiuyeGL/recruitManage?action=recruitlist&page=${dopage.totalPage}&sql=${dopage.sql}">末页</a>
					&nbsp;&nbsp;共${dopage.totalPage}页
				</td>				
			</tr>
			<c:if test="${user.usertypes ne 'company'}">
           <tr>
            <td colspan="6" height="26px">按公司名模糊搜索
                <input type="hidden" name="action" value="recruitlist"/>
				<input type="text" name="sql"/>
				<input type="submit" value="搜索"/></td>           
           </tr>
           </c:if>
        </table>
     </form>
  </body>
</html>
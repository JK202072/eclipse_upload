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
        <%-- <c:set var="dopage" value="${doPage}" />
        <c:set var="list"  value="${dopage.list }"></c:set>	 --%>
        <table width="80%" border="1">
           <tr bgcolor="#DCDCDC">
              <th width="15%" height="30px">姓名</th>
              <th width="15%" height="30px">性别</th>
              <th width="15%" height="30px">毕业院校</th>
              <th width="15%" height="30px">专业</th>
              <th width="25%" height="30px">操作</th>              
           </tr>           
           <c:forEach var="resume" items="${resumelist}">
            <tr>
              <td align="center" height="26px">
                <c:out value="${resume.sname}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${resume.gender}"></c:out>
              </td>
               <td align="center" height="26px">
                <c:out value="${resume.school}"></c:out>
              </td>
              <td align="center" height="26px">
                <c:out value="${resume.major}"></c:out>
              </td>
              <td align="center" height="26px">
                <a href="/jiuyeGL/resumeManage?action=showsturesume&sid=${resume.sid}">查看简历</a>                              
              </td>
            </tr>
           <%--  <tr>
				<td colspan="6" align="right">
					<a href="/jiuyeGL/recruitResumeManage?action=showresumes&page=1&sql=${dopage.sql}">首页</a>
					&nbsp;&nbsp;
					<c:if test="${dopage.nowPage-1>0}">
						<SPAN class=Unable><a
							href="/jiuyeGL/recruitResumeManage?action=showresumes&page=${dopage.nowPage-1}&sql=${dopage.sql}">上一页
						</a> </SPAN>
					</c:if>
					&nbsp;&nbsp;
					<c:if test="${dopage.nowPage+1<=dopage.totalPage}">
            &nbsp;&nbsp;&nbsp;
              <a  href="/jiuyeGL/recruitResumeManage?action=showresumes&page=${dopage.nowPage+1}&sql=${dopage.sql}">下一页</a>
					</c:if>
					&nbsp;&nbsp;
					<a 	href="/jiuyeGL/recruitResumeManage?action=showresumes&page=${dopage.totalPage}&sql=${dopage.sql}">末页</a>
					&nbsp;&nbsp;共${dopage.totalPage}页
				</td>				
			</tr>
			<tr>
            <td colspan="6" height="26px">按公司名模糊搜索
                <input type="hidden" name="action" value="showresumes"/>
				<input type="text" name="sql"/>
				<input type="submit" value="搜索"/></td>           
           </tr> --%>
           </c:forEach>
        </table>
     </form>
  </body>
</html>
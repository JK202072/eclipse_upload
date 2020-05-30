<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="ck" uri="http://ckeditor.com" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回复留言</title>
<style type="text/css">
 body{
         background-color: #EEF2FB;
      } 
  td{
    font-size:12px;
  }
</style>
<script type="text/javascript" src="/jiuyeGL/ckeditor/ckeditor.js"></script>
</head>
<body bgcolor="eff2fb">
  <c:set var="u" value="${user }"></c:set>
  <form action="/jiuyeGL/messageManage" method="post">
     <input type="hidden" name="action" value="update">
     <input type="hidden" value="<c:out value="${message.mid }"/>" name="mid"/>
    <table width="66%" border="0" cellspacing="0" cellpadding="0">
     <tr>
    <td width="20%"><strong>留言用户：</strong></td>
    <td width="80%">
    <c:out value="${message.username }"></c:out>
    </td>
    </tr>
    <tr>
    <td><strong>留言标题：</strong></td>
    <td>
    <c:out value="${message.title }"></c:out>
    </td>
    </tr>
    <tr>
    <td><strong>留言内容：</strong></td>
    <td>
    <c:out value="${message.content }" escapeXml="false"></c:out>
    </td>
    </tr>
       <tr>
          <td><strong>留言回复：</strong></td>
          <td>
             <textarea rows="10" cols="80" name="reply" id="reply"></textarea>
             <ck:replace replace="reply" basePath=""></ck:replace>
          </td>
       </tr>
       <tr>
          <td colspan="2" align="center">
             <input type="submit" value="提交留言">
          </td>
       </tr>
     </table>
  </form>
</body>
</html>
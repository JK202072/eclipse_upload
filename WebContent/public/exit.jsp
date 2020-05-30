<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exit</title>
</head>
<body>
<%
    session.invalidate();
%>
<jsp:forward page="login.jsp"></jsp:forward>
</body>
</html>
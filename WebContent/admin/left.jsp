<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导航菜单</title>
<link rel="stylesheet" type="text/css" href="/jiuyeGL/css/leftmenu.css"/>
</head>
<body>
  <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
    <tr>
      <td width="182" valign="top">
        <div id="container">
          <h2 class="type"><a href="javascript:void(0)">管理员管理导航</a></h2>
          <div class="content">
            <ul class="menuitem">
              <li>
               <a href="/jiuyeGL/public/right.jsp" target="main">首页</a>
              </li>
              <li>
               <a href="/jiuyeGL/userManage?action=list" target="main">用户管理</a>
              </li>
              <li>
               <a href="/jiuyeGL/public/register.jsp" target="main">添加学生信息</a>
              </li>
              <li>
                <a href="/jiuyeGL/studentManage?action=studentlist" target="main">管理学生信息</a>
              </li>
              <li>
               <a href="/jiuyeGL/public/register.jsp" target="main">添加企业信息</a>
              </li>
               <li>
                <a href="/jiuyeGL/companyManage?action=companylist" target="main">管理企业信息</a>
              </li>
              <li>
                <a href="/jiuyeGL/recruitManage?action=recruitlist" target="main">管理招聘信息</a>
              </li>
              <li>
               <a href="/jiuyeGL/admin/publishEmployment.jsp" target="main">发布就业信息</a>
              </li>
              <li>
                <a href="/jiuyeGL/employmentManage?action=list" target="main">管理就业信息</a>
              </li>
              <li>
                <a href="/jiuyeGL/messageManage?action=list" target="main">留言管理</a>
              </li>
            </ul>
          </div>
        </div>
        </td>
        </tr>
  </table>
</body>
</html>
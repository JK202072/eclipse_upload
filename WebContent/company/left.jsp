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
  <table width="100%" height="319" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
    <tr>
      <td width="182" valign="top">
        <div id="container">
          <h2 class="type"><a href="javascript:void(0)">企业管理导航</a></h2>
          <div class="content">
            <ul class="menuitem">
              <li>
               <a href="/jiuyeGL/public/right.jsp" target="main">企业首页</a>
              </li>
              <li>
               <a href="/jiuyeGL/companyManage?action=companyedit" target="main">修改资料</a>
              </li>
              <li>
               <a href="/jiuyeGL/companyManage?action=choose" target="main">发布招聘信息</a>
              </li>
              <li>
                <a href="/jiuyeGL/recruitManage?action=recruitlist" target="main">管理招聘信息</a>
              </li>
              <li>
               <a href="/jiuyeGL/recruitResumeManage?action=list" target="main">查看学生简历</a>
              </li>
               <li>
                <a href="/jiuyeGL/employmentManage?action=list" target="main">查看就业信息</a>
              </li>
              <li>
                <a href="/jiuyeGL/public/message.jsp" target="main">给管理员留言</a>
              </li>
              <li>
               <a href="/jiuyeGL/messageManage?action=list" target="main">查看管理员回复</a>
              </li>
              <li>
                <a href="/jiuyeGL/public/updatepasssword.jsp" target="main">修改密码</a>
              </li>
            </ul>
          </div>
        </div>
        </td>
        </tr>
  </table>
</body>
</html>
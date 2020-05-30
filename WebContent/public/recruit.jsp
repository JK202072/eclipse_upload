<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布招聘信息</title>
</head>
<body bgcolor="e6e6fa">
<form action="/jiuyeGL/recruitManage" method="post" >
<table class="regtable" width="500" align="center" border="0" cellpadding="5" cellspacing="1">
   <tr>
        <td valign="top" width="500" bgcolor="#f9f9f9" height="350">
         <table width="500" align="center" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td colspan="2" align="center" height="25">
          <span style="font-weight:bold;">招聘信息</span>
            </td>
            <td colspan="2">&nbsp;</td>
          </tr>
    <tr>
    <td>
      <input type="hidden" name=cid value="${company.cid }"/>
      <input type="hidden" name="action" value="publish"/>
    </td>
  </tr>
  <tr>
       <td align="right" height="30" width="190">单位名称：</td>
       <td width="310" align="left">&nbsp;&nbsp;
       <input type="text" name="companyname" size="30" value="${company.companyname }" readonly="readonly"/>
      </td>
  </tr>
   <tr>
      <td align="right" height="30">单位地址：</td>
      <td>&nbsp;&nbsp;
      <input type="text" name="address" size="50" value="${company.address }" readonly="readonly"/>
      </td>
   </tr>
    <tr>
              <td align="right" height="30">邮政编码：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="postcode" size="50"/>
              </td>
          </tr>
           <tr>
              <td align="right" height="30">招聘人数：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="recruitment" size="50"/>
              </td>
          </tr>
           <tr>
              <td align="right" height="30">工作地点：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="workingplace" size="50"/>
              </td>
          </tr>
           <tr>
              <td align="right" height="30">职位性质：</td>
              <td height="30">&nbsp;&nbsp;
                <select name="positiontype">
                   <option value="00" selected="selected">请选择</option>
                   <option value="全职">全职</option>
                   <option value="兼职">兼职</option>
                   <option value="实习">实习</option>
                </select>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">学历要求：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="edurequire" size="50"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">职位描述及要求：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="description" size="50"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">使用部门：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="branch" size="50"/>
              </td>
          </tr>
          <tr>
             <td align="right" height="30">联系人：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="linkman" size="50"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">联系电话：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="telephone" size="50"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">单位主页：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="hostpage" size="50" value="http://www.sohu.com"/>
              </td>
          </tr>
           <tr>
              <td align="right" height="30">邮箱：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="email" size="50"/>
              </td>
          </tr>
          <tr>
            <td></td>
              <td align="left" height="30">
              <input name="imageField" src="/jiuyeGL/images/Login_but.gif" type="image" style="margin-left:50px">
              </td>
          </tr>
          </table>
</table>
</form>
</body>
</html>
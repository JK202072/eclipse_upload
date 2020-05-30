<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改企业信息</title>
<link href="/jiuyeGL/css/stucss.css" rel="stylesheet" type="text/css">
</head>
<body>
  <form method="post" action="/jiuyeGL/companyManage" style="margin:0pt;">
    <table class="regtable" width="500" align="center" border="0" cellpadding="5" cellspacing="1">
      <tr>
        <td valign="top" width="500" bgcolor="#f9f9f9" height="350">
         <table width="500" align="center" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td colspan="2" class="tdinfo" height="25">
            &nbsp;<span style="font-weight:bold;">公司基本信息</span>
            </td>
            <td colspan="2">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2" width="190">
           <%--  <%
             Object obj=request.getAttribute("cid");
             String comid="";
             if(obj!=null){
          	   comid=String.valueOf(obj);
             }
             %> --%>
            <input type="hidden" value="<c:out value="${company.cid }"/>" name="cid"/>
            </td>
            <td colspan="2" width="310">
              <input type="hidden" value="update" name="action"/>
            </td>
          </tr>
          <tr>
            <td align="right" height="30" width="190">公司名称：</td>
            <td width="310" align="left">&nbsp;&nbsp;
              <input type="text" name="companyname" size="30" value="${company.companyname }" readonly="readonly"/>
            </td>
          </tr>
          <tr>
            <td align="right" height="30">单位性质：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="unitproperty" size="50" value="${company.unitproperty }" readonly="readonly"/>
              </td>
           
          </tr>
          <tr>
              <td align="right" height="30">营业执照号：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="licensenumber" size="50" value="${company.licensenumber }" readonly="readonly"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">所属行业：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="industry" size="50" value="${company.industry }" readonly="readonly"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">单位规模：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="unitscale" size="50" value="${company.unitscale }"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">公司地址：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="address" size="50" value="${company.address }"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">网址：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="webaddress" size="50" value="${company.webaddress }"/>
              </td>
          </tr>
          <tr>
             <td align="right" height="30">联系人：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="linkman" size="50" value="${company.linkman }"/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">电话：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="telephone" size="50" value="${company.telephone }"/>
              </td>
          </tr>
           <tr>
              <td align="right" height="30">邮箱：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="email" size="50" value="${company.email }"/>
              </td>
          </tr>
           <tr>
              <td align="right" height="30">邮编：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="postcode" size="50" value="${company.postcode }"/>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>企业基本信息</title>
<link href="/jiuyeGL/css/stucss.css" rel="stylesheet" type="text/css">
</head>
<body>
   <table class="regtable" width="500" align="center" border="0" cellpadding="5" cellspcing="1">
     <caption class="txt">企业基本信息</caption>
     <tr>
       <td></td>
     </tr>
     <tr>
       <td valign="top" width="500" bgcolor="#f9f9f9" height="350">
         <table width="500" align="center" border="0" cellpadding="0" cellspcing="0">
         <tr>
            <td colspan="2" class="tdinfo" height="25">
              <span style="font-weight:bold;">企业基本信息</span>
            </td>
            <td colspan="2"></td>
         </tr>
         <tr>
            <td align="right" height="30" width="130">公司名称：</td>
            <td width="370" align="left">
            <input type="text" readonly="readonly" name="companyname" value="${company.companyname}" size="30"/>
            </td>
         </tr>
          <tr>
            <td align="right" height="30" >单位性质：</td>
            <td width="370" >
            <input type="text" readonly="readonly" name="unitproperty" value="${company.unitproperty}" size="50"/>
            </td>
         </tr>
          <tr>
              <td align="right" height="30">营业执照号：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="licensenumber" size="50" value="${company.licensenumber}" readonly/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">所属行业：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="industry" size="50" value="${company.industry}" readonly/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">单位规模：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="unitscale" size="50" value="${company.unitscale}" readonly/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">公司地址：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="address" size="50" value="${company.address}" readonly/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">网址：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="webaddress" size="50" value="${company.webaddress}" readonly/>
              </td>
          </tr>
          <tr>
             <td align="right" height="30">联系人：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="linkman" size="50" value="${company.linkman}" readonly/>
              </td>
          </tr>
          <tr>
              <td align="right" height="30">电话：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="telephone" size="50" value="${company.telephone}" readonly/>
              </td>
          </tr>
           <tr>
              <td align="right" height="30">邮箱：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="email" size="50" value="${company.email}" readonly/>
              </td>
          </tr>
           <tr>
              <td align="right" height="30">邮编：</td>
              <td>&nbsp;&nbsp;
                <input type="text" name="postcode" size="50" value="${company.postcode}" readonly/>
              </td>
          </tr>
         <tr>
             <td colspan="2"></td>
         </tr>
   </table>
</body>
</html>
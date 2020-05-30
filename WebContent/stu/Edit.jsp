<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生成简历</title>
<style type="text/css">
  td{
    font-size:12px;
  }
</style>
</head>
<script language="javascript" type="text/javascript">
     function check(){
    	 var contactWay=document.getElementById("phone").value;
    	 var email=document.getElementById("email").value;
    	 var i=email.indexOf("@");
    	 var j=email.indexOf(".");
    	 var flag=true;
    	 if((i<0)||(j<0)||((i-j)>0)){
    		 alert("Email错误");
        	 flag=false;
    	 }
    	 
     if(contactWay.isNaN()){
    	 alert("电话号码必须为数字");
    	 flag=false;
     }
     return flag;
     }
</script>
<script type="text/javascript" src="/jiuyeGL/js/datepicker.js"></script> 
<script type="text/javascript" src="/jiuyeGL/js/nationsel.js"></script>
<body bgcolor="e6e6fa">
<div id="main">
<form action="/jiuyeGL/resumeManage" method="post"  >
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="sid"  value="<c:out value="${resume.sid }"/>">
           <div id="top">
              <div id="wenzi">
                    简历信息
              </div>
              (*为必填项)
           </div> 
           </div>
          <table width="80%" border="0">
          <tr>
            <td width="15%">*姓名：</td>
              <td width="35%">
                <input type="text" name="sname" value="${resume.sname }" readonly="readonly"/>
              </td>
            <td width="15%">*性别：</td>
             <td width="35%" height="11">
                <input type="text" name="gender"  value="${resume.gender }" readonly="readonly"/>
              </td>
          </tr>
          <tr>
            <td >*出生日期：</td>
              <td>
                <input type="text" name="birthdate" size="width:70px" onfocus="HS_setDate(this)" value="${resume.birthdate }"/>
              </td>
            <td>*民族：</td>
             <td>
                <select name="nation" id="national" value="${resume.nation }"></select>
                <script type="text/javascript">nationselect();</script>
              </td>
          </tr>
           <tr>
            <td>*政治面貌：</td>
              <td>
                <input type="text" name="politics" value="${resume.politics }"/>
              </td>
            <td >毕业时间：</td>
             <td>
                <input type="text" name="graduation" size="width:70px" onfocus="HS_setDate(this)" value="${resume.graduation }"/>
              </td>
          </tr>
           <tr>
            <td >*毕业院校：</td>
              <td>
                <input type="text" name="school"  value="${resume.school }" readonly="readonly"/>
              </td>    
            <td>*所学专业：</td>
             <td>
                <input type="text" name="major"  value="${resume.major }" readonly="readonly"/>
              </td>
          </tr>
           <tr>
            <td>*学历：</td>
              <td>
                <input type="text" name="education" value="${resume.education }" readonly="readonly"/>
              </td>
              
            <td>*邮箱：</td>
             <td>
                <input type="text" name="email" id="email" value="${resume.email }"/>
              </td>
          </tr>
           <tr>
            <td>*联系电话：</td>
              <td>
                <input type="text" name="phone" id="phone" value="${resume.phone }"/>
              </td>
              
            <td>*外语水平：</td>
             <td>
                <input type="text" name="foreignlanguage" value="${resume.foreignlanguage }"/>
              </td>
          </tr>
          <tr>
          <td>特长及爱好：</td>
              <td>
                <textarea rows="2" cols="30" name="hobby">${resume.hobby }</textarea>
              </td>
          </tr>
 
          <tr>
          <td>社会实践经历：</td>
              <td>
                <textarea rows="2" cols="30" name="practice">${resume.practice }</textarea>
              </td>
          </tr>
          <tr>
          <td>在校期间担任职务：</td>
              <td>
               <textarea rows="2" cols="30"  name="position">${resume.position }</textarea>
              </td>
          </tr>
          
           <tr>
          <td>在校期间获奖：</td>
              <td>
                <textarea rows="2" cols="30" name="honor">${resume.honor }</textarea>
              </td>
          </tr>
          <tr>
           <td>科研成果：</td>
              <td>
               <textarea rows="2" cols="30" name="research">${resume.research }</textarea>
              </td>
          </tr>
          <tr>
           <td>自我评价：</td>
              <td>
                <textarea rows="2" cols="30" name="selfevaluation">${resume.selfevaluation }</textarea>
              </td>
          </tr>
          <tr>
            <td></td>
              <td align="left" height="30">
              <input name="imageField" src="/jiuyeGL/images/Login_but.gif" type="image" style="margin-left:50px">
              </td>
          </tr>
</table>
</form>
</body>
</html>
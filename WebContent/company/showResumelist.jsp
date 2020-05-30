<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看简历</title>
<style type="text/css">
  td{
    font-size:12px;
  }
</style>
</head>
<body bgcolor="eff2fb">
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
                <input type="text" name="birthdate"  value="${resume.birthdate }" readonly/>
              </td>
            <td>*民族：</td>
             <td>
                <input type="text" name="nation"  value="${resume.nation }" readonly/>
              </td>
          </tr>
           <tr>
            <td>*政治面貌：</td>
              <td>
                <input type="text" name="politics" value="${resume.politics }" readonly/>
              </td>
            <td >毕业时间：</td>
             <td>
                <input type="text" name="graduation"  value="${resume.graduation }" readonly/>
              </td>
          </tr>
           <tr>
            <td >*毕业院校：</td>
              <td>
                <input type="text" name="school"  value="${resume.school }" readonly/>
              </td>    
            <td>*所学专业：</td>
             <td>
                <input type="text" name="major"  value="${resume.major }" readonly/>
              </td>
          </tr>
           <tr>
            <td>*学历：</td>
              <td>
                <input type="text" name="education" value="${resume.education }" readonly/>
              </td>
              
            <td>*邮箱：</td>
             <td>
                <input type="text" name="email" id="email" value="${resume.email }" readonly/>
              </td>
          </tr>
           <tr>
            <td>*联系电话：</td>
              <td>
                <input type="text" name="phone" id="phone" value="${resume.phone }" readonly/>
              </td>
              
            <td>*外语水平：</td>
             <td>
                <input type="text" name="foreignlanguage" value="${resume.foreignlanguage }" readonly/>
              </td>
          </tr>
          <tr>
          <td>特长及爱好：</td>
              <td>
                <textarea rows="2" cols="30" name="hobby" readonly>${resume.hobby }</textarea>
              </td>
          </tr>
 
          <tr>
          <td>社会实践经历：</td>
              <td>
                <textarea rows="2" cols="30" name="practice" readonly>${resume.practice }</textarea>
              </td>
          </tr>
          <tr>
          <td>在校期间担任职务：</td>
              <td>
               <textarea rows="2" cols="30"  name="position" readonly>${resume.position }</textarea>
              </td>
          </tr>
          
           <tr>
          <td>在校期间获奖：</td>
              <td>
                <textarea rows="2" cols="30" name="honor" readonly>${resume.honor }</textarea>
              </td>
          </tr>
          <tr>
           <td>科研成果：</td>
              <td>
               <textarea rows="2" cols="30" name="research" readonly>${resume.research }</textarea>
              </td>
          </tr>
          <tr>
           <td>自我评价：</td>
              <td>
                <textarea rows="2" cols="30" name="selfevaluation" readonly>${resume.selfevaluation }</textarea>
              </td>
          </tr>
</table>
</form>
</body>
</html>
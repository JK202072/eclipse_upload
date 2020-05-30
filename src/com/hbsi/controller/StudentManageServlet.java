package com.hbsi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Student;
import com.hbsi.bean.User;
import com.hbsi.dao.StudentDao;
import com.hbsi.dao.service.StudentDaoImpl;
import com.oracle.jrockit.jfr.RequestDelegate;

@WebServlet("/StudentManageServlet")
public class StudentManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public StudentManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action =request.getParameter("action");
		StudentDao sd=new StudentDaoImpl();
		if(action.equals("sturegister")) {
			String id=request.getParameter("sid");
			int sid=0;
			try {
				sid=Integer.parseInt(id);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			String sname=request.getParameter("sname");
			String gender=request.getParameter("gender");
			String idnumber=request.getParameter("idnumber");
			String school=request.getParameter("school");
			String department=request.getParameter("department");
			String major=request.getParameter("major");
			String education=request.getParameter("education");
			String entrancedate=request.getParameter("entrancedate");
			String nativeplace=request.getParameter("nativeplace");
			
			Student student=new Student();
			
			student.setSid(sid);
			
			student.setSname(sname);
			student.setGender(gender);
			student.setIdnumber(idnumber);
			student.setSchool(school);
			student.setDepartment(department);
			student.setMajor(major);
			student.setEducation(education);
			student.setEntrancedate(entrancedate);
			student.setNativeplace(nativeplace);
			
			boolean flag=sd.addStudent(student);
			if(flag) {
				request.setAttribute("errorMsg", "学生用户注册成功，请联系管理员激活帐号");
				this.gotoPage("public/login.jsp",request,response);
			}else {
				request.setAttribute("sid", student.getSid());
				this.gotoPage("stu/studenInfo.jsp", request, response);
			}
			
			
		}
		if (action.equals("show")) {
			HttpSession session =request.getSession();
			User user=(User)session.getAttribute("user");
			int sid=0;
			if ("student".equals(user.getUsertypes())) {
				sid=user.getId();
			}else {
				String sidStr=request.getParameter("sid");
				try {
					sid=Integer.parseInt(sidStr);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			Student student=sd.lookStudent(sid);
			request.setAttribute("student", student);
			this.gotoPage("stu/showStudent.jsp", request, response);
		}
		if (action.equals("studentlist")) {
//			String sql=request.getParameter("sql");
//			List<Student> students=sd.doFindAll();
//			request.setAttribute("list", students);
//			this.gotoPage("admin/studentList.jsp?sql=", request, response);
			String pageStr=request.getParameter("page");
			int pageNo=0;
			if(pageStr==null){
				pageNo=1;
			}else{
				pageNo=Integer.parseInt(pageStr);
			}			
			DoPage dopage=new DoPage();
			dopage.setNowPage(pageNo);
			dopage.setPageSize(5);
			String sqlstr=request.getParameter("sql");
			
				if (sqlstr==null) {
					sqlstr="";
					dopage.setSql(sqlstr);
				}else {
					dopage.setSql("where sname like '%"+sqlstr+"%'");
				}
			
			
			dopage.setCount(sd.doCount(dopage));
			dopage.setTotalPage(sd.doTotalPage(dopage));
			
			dopage=sd.doFindAll(dopage);
			
			request.setAttribute("doPage", dopage);
		    this.gotoPage("admin/studentList.jsp", request, response);
		}
		
		if (action.equals("delete")) {
			String strsid=request.getParameter("sid");
			int sid;
			sid=Integer.parseInt(strsid);
			boolean flag=sd.delstudent(sid);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
	}

	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO 自动生成的方法存根
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

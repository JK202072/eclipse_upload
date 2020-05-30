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

import com.hbsi.bean.Company;
import com.hbsi.bean.DoPage;
import com.hbsi.bean.Employment;
import com.hbsi.bean.Recruit;
import com.hbsi.bean.Student;
import com.hbsi.bean.User;
import com.hbsi.dao.EmploymentDao;

import com.hbsi.dao.service.EmploymentDaoImpl;


@WebServlet("/EmploymentManageServlet")
public class EmploymentManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EmploymentManageServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		EmploymentDao ed=new EmploymentDaoImpl();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if (action.equals("add")) {
			Employment employment=new Employment();
			
			
			employment.setStudentname(request.getParameter("studentname"));
			employment.setSchool(request.getParameter("school"));
			employment.setCompanyname(request.getParameter("companyname"));
			employment.setPosition(request.getParameter("position"));
			boolean flag=ed.addEmployment(employment);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if (action.equals("list")) {
//			String sql=request.getParameter("sql");
//			List<Employment> employments=ed.doFindAll();
//			request.setAttribute("list", employments);
//			this.gotoPage("public/employmentList.jsp?sql=", request, response);
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
					dopage.setSql("where studentname like '%"+sqlstr+"%'");
				}
			
			
			dopage.setCount(ed.doCount(dopage));
			dopage.setTotalPage(ed.doTotalPage(dopage));
			
			dopage=ed.doFindAll(dopage);
			
			request.setAttribute("doPage", dopage);
		    this.gotoPage("public/employmentList.jsp", request, response);
		}
		
		if(action.equals("employmentedit")) {
	        	Employment employment=new Employment();
	        	String streid=request.getParameter("eid");
				int eid;
				eid=Integer.parseInt(streid);
				employment=ed.lookemployment(eid);
				request.setAttribute("employment", employment);
				this.gotoPage("public/employmentEdit.jsp", request, response);
		}
		if (action.equals("update")) {
			Employment employment=new Employment();
			String streid=request.getParameter("eid");
			int eid;
			eid=Integer.parseInt(streid);
			employment.setEid(eid);
			employment.setStudentname(request.getParameter("studentname"));
			employment.setSchool(request.getParameter("school"));
			employment.setCompanyname(request.getParameter("companyname"));
			employment.setPosition(request.getParameter("position"));
			//更新到数据库
			boolean flag=ed.UpdateEmployment(employment);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		
		if (action.equals("delete")) {
			String streid=request.getParameter("eid");
			int eid;
			eid=Integer.parseInt(streid);
			boolean flag=ed.delemployment(eid);
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

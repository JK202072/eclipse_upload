package com.hbsi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbsi.bean.User;
import com.hbsi.dao.UserDao;
import com.hbsi.dao.service.UserDaoImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        User user=new User();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
		
	    user.setUsername(username);
	    user.setPassword(password);
	    user.setUsertypes(usertypes);
	    
	    UserDao ud=new UserDaoImpl();
	    
	   
			user=ud.addUser(user);
			if (user.getUsertypes().equals("admin")) {
				request.setAttribute("errorMsg", "管理员用户注册成功，请联系管理员激活帐号");
				this.gotoPage("public/login.jsp",request,response);
			}
			if (user.getUsertypes().equals("student")) {
				request.setAttribute("sid", user.getId());
				this.gotoPage("stu/studentInfo.jsp",request,response);
			}
			if (user.getUsertypes().equals("company")) {
				request.setAttribute("cid", user.getId());
				this.gotoPage("company/companyInfo.jsp",request,response);
			}
		}
	
	private void gotoPage(String url,HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
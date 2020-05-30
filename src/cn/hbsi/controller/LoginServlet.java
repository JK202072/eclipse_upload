package cn.hbsi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbsi.bean.User;
import com.hbsi.dao.UserDao;
import com.hbsi.dao.service.UserDaoImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String usertypes=request.getParameter("usertypes");
		
		User user=new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setUsertypes(usertypes);
		
		UserDao ud=new UserDaoImpl();
		User u=ud.lookUser(user);
		
		if (u.getUsertypes().equals("error")) {
			 request.setAttribute("errorMsg", "用户名或密码不存在");
			 this.gotoPage("public/login.jsp",request,response);
		}else {
			if (u.getVerify().equals("1")) {
				 request.setAttribute("errorMsg", "用户未激活，请联系管理员");
				 this.gotoPage("public/login.jsp",request,response);
			}
			if (u.getVerify().equals("2")) {
				session.setAttribute("user",u);
				if (u.getUsertypes().equals("admin")) {
					this.gotoPage("admin/index.jsp", request, response);
				}
				if (u.getUsertypes().equals("student")) {
					this.gotoPage("stu/stuIndex.jsp", request, response);
				}
				if (u.getUsertypes().equals("company")) {
					this.gotoPage("company/companyIndex.jsp", request, response);
				}
			}
			if (u.getVerify().equals("3")) {
				request.setAttribute("errorMsg", "用户审核未通过，请重新注册，如实填写信息 ");
				 this.gotoPage("public/login.jsp",request,response);
			}
			
		}
	}
	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO 自动生成的方法存根
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
//2   	HttpSession session=request.getSession();
//		
//		session.setAttribute("username", name);
//		session.setAttribute("usertype", usertype);
//		if (name==null||name.trim().equals("")) {
//			response.sendRedirect("/jiuyeGL/error");
//			return;
//		}
//		if (passwd==null||passwd.trim().equals("")) {
//			response.sendRedirect("/jiuyeGL/error");
//			return;
//		}
//		response.sendRedirect("/jiuyeGL/success");
//		
//1		if("admin".equals(usertype)) {
//			if(("111".equals(name))&&("password".equals(passwd))) {
//				out.println("管理员"+name+"登录成功");
//			}else {
//				out.println("管理员"+name+"用户不存在或密码不正确");
//			}
//		}
//		if("student".equals(usertype)) {
//			if(("student".equals(name))&&("password".equals(passwd))) {
//				out.println("学生"+name+"登录成功!");
//			}else {
//				out.println("学生"+name+"用户不存在或密码不正确");
//			}
//		}
//		if("company".equals(usertype)) {
//			if(("company".equals(name))&&("password".equals(passwd))) {
//				out.println("企业"+name+"登录成功!");
//			}else {
//				out.println("企业"+name+"用户不存在或密码不正确");
//			}
//		}
//	
//		out.flush();
//		out.close();
		//doGet(request, response);
	


	

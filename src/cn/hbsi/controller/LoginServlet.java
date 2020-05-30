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
			 request.setAttribute("errorMsg", "�û��������벻����");
			 this.gotoPage("public/login.jsp",request,response);
		}else {
			if (u.getVerify().equals("1")) {
				 request.setAttribute("errorMsg", "�û�δ�������ϵ����Ա");
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
				request.setAttribute("errorMsg", "�û����δͨ����������ע�ᣬ��ʵ��д��Ϣ ");
				 this.gotoPage("public/login.jsp",request,response);
			}
			
		}
	}
	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO �Զ����ɵķ������
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
//				out.println("����Ա"+name+"��¼�ɹ�");
//			}else {
//				out.println("����Ա"+name+"�û������ڻ����벻��ȷ");
//			}
//		}
//		if("student".equals(usertype)) {
//			if(("student".equals(name))&&("password".equals(passwd))) {
//				out.println("ѧ��"+name+"��¼�ɹ�!");
//			}else {
//				out.println("ѧ��"+name+"�û������ڻ����벻��ȷ");
//			}
//		}
//		if("company".equals(usertype)) {
//			if(("company".equals(name))&&("password".equals(passwd))) {
//				out.println("��ҵ"+name+"��¼�ɹ�!");
//			}else {
//				out.println("��ҵ"+name+"�û������ڻ����벻��ȷ");
//			}
//		}
//	
//		out.flush();
//		out.close();
		//doGet(request, response);
	


	

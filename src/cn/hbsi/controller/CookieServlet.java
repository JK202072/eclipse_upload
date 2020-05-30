package cn.hbsi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	public void destroy() {
		super.destroy();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] allcookies=request.getCookies();
		Cookie ck=null;
		for(int i=0;allcookies!=null&&i<allcookies.length;i++) {
			String name=allcookies[i].getName();
			if("counts".equals(name)) {
				ck=allcookies[i];
			}
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("欢迎登录就业系统");
		out.println("<br>");
		if (ck!=null) {
			int n=Integer.parseInt(ck.getValue())+1;
			ck.setValue(n+"");
			ck.setMaxAge(30*24*60*60);
			response.addCookie(ck);
			out.println("This is the"+n+"login!");
		}else {
			Cookie cookie=new Cookie("counts","1");
			cookie.setMaxAge(30*34*60*60);
			response.addCookie(cookie);
			out.println("This is your first login");
		}
		out.println("<h1>");
		out.println("</body>");
		out.println("</html>");
	}
	public void init() throws ServletException {
		
	}

}

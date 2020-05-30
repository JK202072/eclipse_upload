package com.hbsi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.User;
import com.hbsi.dao.UserDao;
import com.hbsi.dao.service.UserDaoImpl;

@WebServlet("/UserManageServlet")
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UserManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		UserDao ud=new UserDaoImpl();
		if (action.equals("update")) {
			User user=new User();
			int id=0;
			try {
				id=Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			user.setId(id);
			user.setPassword(request.getParameter("password"));
			boolean flag=ud.updatePwd(user);
			if (flag) {
				HttpSession session=request.getSession();
				User loginUser=(User)session.getAttribute("user");
				System.out.println(loginUser.getUsername()+loginUser.getUsertypes());
				if (loginUser.getUsertypes().equals("admin")) {
						this.gotoPage("userManage?action=list", request, response);
					}else {
						this.gotoPage("public/success.jsp", request, response);
					}
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
				
			}
			if (action.equals("list")) {
				DoPage dopage=new DoPage();
				String pageNum=request.getParameter("page");
				int pageNo=0;
			    if (pageNum==null) {
					pageNo=1;
				}else {
					pageNo=Integer.parseInt(pageNum);
				}
			    dopage.setNowPage(pageNo);
			    String sqlStr=request.getParameter("sql");
			    if (sqlStr==null) {
					sqlStr="";
				} else if (sqlStr.equals("1")) {
					sqlStr="where verify='1'";
				}else if (sqlStr.equals("2")) {
					sqlStr="where verify='2'";
				}else if (sqlStr.equals("3")) {
					sqlStr="where verify='3'";
				}else {
					sqlStr="";
				}
			    dopage.setSql(sqlStr);
			    dopage.setPageSize(10);
			    int totalcount=ud.doCount(dopage);
			    dopage.setCount(totalcount);
			    int totalpage=ud.doTotalPage(dopage);
			    dopage.setTotalPage(totalpage);
			    dopage=ud.doFindAll(dopage);
			    request.setAttribute("doPage", dopage);
			    this.gotoPage("admin/userList.jsp", request, response);
			}
			if (action.equals("disable")) {
				//使用户不能登录
				int id=0;
				try {
					id=Integer.parseInt(request.getParameter("id"));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				ud.disableUser(id);
				this.gotoPage("userManage?action=list", request, response);
			}
			if (action.equals("invalid")) {
				//使用户不能通过审核
				int id=0;
				try {
					id=Integer.parseInt(request.getParameter("id"));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				ud.invalid(id);
				this.gotoPage("userManage?action=list", request, response);
			}
			if (action.equals("active")) {
				//使用户可以登录
				int id=0;
				try {
					id=Integer.parseInt(request.getParameter("id"));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				ud.activeUser(id);
				this.gotoPage("userManage?action=list", request, response);
			}
			if(action.equals("delete")) {
				User user=new User();
				int id=0;
				try {
					id=Integer.parseInt(request.getParameter("id"));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				ud.deleteUser(id);
				this.gotoPage("userManage?action=list", request, response);
			}
			
		}
	
	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO 自动生成的方法存根
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

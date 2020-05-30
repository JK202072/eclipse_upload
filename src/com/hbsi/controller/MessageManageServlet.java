package com.hbsi.controller;


import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Employment;
import com.hbsi.bean.Message;
import com.hbsi.bean.User;
import com.hbsi.dao.MessageDao;
import com.hbsi.dao.service.MessageDaoImpl;




@WebServlet("/MessageManageServlet")
public class MessageManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MessageManageServlet() {
        super();     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action =request.getParameter("action");
		MessageDao mDao=new MessageDaoImpl();
		if (action.equals("add")) {
			String username=request.getParameter("username");
			int id=Integer.parseInt(request.getParameter("id"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Date d=new Date();
			DateFormat df=DateFormat.getDateTimeInstance();
			String time=df.format(d);
			Message message=new Message();
			message.setId(id);
			message.setUsername(username);
			message.setTitle(title);
			message.setContent(content);
			message.setMsgtime(time);
			boolean flag=mDao.addMessage(message);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if (action.equals("list")) {
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
			String sql="";
			User user=(User)session.getAttribute("user");
			if(!user.getUsertypes().equals("admin")){
				sql=" where id="+user.getId();
			}			
			dopage.setSql(sql);
			
			dopage.setCount(mDao.doCount(dopage));
			dopage.setTotalPage(mDao.doTotalPage(dopage));
			
			dopage=mDao.doFindAll(dopage);
			
			request.setAttribute("doPage", dopage);
		    this.gotoPage("public/messageList.jsp", request, response);
		}
		if (action.equals("delete")) {
			String mtreid=request.getParameter("mid");
			int mid;
			mid=Integer.parseInt(mtreid);
			boolean flag=mDao.delmessage(mid);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if(action.equals("show")) {
			Message message=new Message();
        	int mid=Integer.parseInt(request.getParameter("mid"));
        	message=mDao.lookmessage(mid);
			request.setAttribute("message", message);
			this.gotoPage("public/messageshow.jsp", request, response);
	    }
		if (action.equals("update")) {
			int mid=Integer.parseInt(request.getParameter("mid"));
			String reply=request.getParameter("reply");
			Date d=new Date();
			DateFormat df=DateFormat.getDateTimeInstance();
			String replytime=df.format(d);
			Message message=new Message();
			message.setMid(mid);
			message.setReply(reply);
			message.setReplytime(replytime);
			boolean flag=mDao.UpdateMessage(message);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
	}
	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

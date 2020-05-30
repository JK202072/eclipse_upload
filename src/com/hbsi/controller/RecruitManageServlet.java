package com.hbsi.controller;

import java.io.IOException;

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
import com.hbsi.bean.User;
import com.hbsi.dao.RecruitDao;
import com.hbsi.dao.service.RecruitDaoImpl;


@WebServlet("/RecruitManageServlet")
public class RecruitManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RecruitManageServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		RecruitDao rd=new RecruitDaoImpl();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if (action.equals("publish")) {
			Recruit recruit=new Recruit();
			String id=request.getParameter("cid");
			int cid=0;
			cid=Integer.parseInt(id);
			
			recruit.setCid(cid);
			recruit.setCompanyname(request.getParameter("companyname"));
			recruit.setAddress(request.getParameter("address"));
			recruit.setPostcode(request.getParameter("postcode"));
			recruit.setRecruitment(request.getParameter("recruitment"));
			recruit.setWorkingplace(request.getParameter("workingplace"));
			recruit.setPositiontype(request.getParameter("positiontype"));
			recruit.setEdurequire(request.getParameter("edurequire"));
			recruit.setDescription(request.getParameter("description"));
			recruit.setBranch(request.getParameter("branch"));
			recruit.setLinkman(request.getParameter("linkman"));
			recruit.setTelephone(request.getParameter("telephone"));
			recruit.setHostpage(request.getParameter("hostpage"));
			recruit.setEmail(request.getParameter("email"));
			
			boolean flag=rd.addRecruit(recruit);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if (action.equals("recruitlist")) {
			DoPage dopage=new DoPage();
			String pageNum=request.getParameter("page");
			int pageNo=0;
		    if (pageNum==null) {
				pageNo=1;
			}else {
				pageNo=Integer.parseInt(pageNum);
			}
		    dopage.setNowPage(pageNo);
		    String sqlstr=request.getParameter("sql");
		    dopage.setSql(sqlstr);
		    dopage.setPageSize(10);
		    if (user.getUsertypes().equals("company")) {
				dopage.setSql("where cid="+user.getId());
			}else {
				if (sqlstr==null) {
					sqlstr="";
					dopage.setSql(sqlstr);
				}else if (sqlstr.endsWith("%")) {
					dopage.setSql(sqlstr);
				}else {
					dopage.setSql("where companyname like '%"+sqlstr+"%'");
				}
			}
		    int totalcount=rd.doCount(dopage);
		    dopage.setCount(totalcount);
		    int totalpage=rd.doTotalPage(dopage);
		    dopage.setTotalPage(totalpage);
		    dopage=rd.doFindAll(dopage);
		    request.setAttribute("doPage", dopage);
		    this.gotoPage("public/recruitList.jsp", request, response);
		}
		if (action.equals("show")) {
			String ridstr=request.getParameter("rid");
			int rid=0;
			rid=Integer.parseInt(ridstr);
			//用rid查找相应的招聘信息
			Recruit recruit=rd.lookRecruit(rid);
			request.setAttribute("recruit",recruit);
			this.gotoPage("public/showRecruit.jsp", request, response);
		}
		if (action.equals("delete")) {
			String ridstr=request.getParameter("rid");
			int rid=0;
			rid=Integer.parseInt(ridstr);
			boolean flag=rd.delrecruit(rid);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		
        if(action.equals("recruitedit")) {
        	Recruit recruit=new Recruit();
			if (user.getUsertypes().equals("company")) {
				recruit=rd.lookRecruit(user.getId());
			}else if (user.getUsertypes().equals("admin")) {
				String id=request.getParameter("rid");
				int rid=0;
				rid=Integer.parseInt(id);
				recruit=rd.lookRecruit(rid);
			}
			request.setAttribute("recruit", recruit);
			this.gotoPage("public/recruitEdit.jsp", request, response);
		}
    	if (action.equals("update")) {
			Recruit recruit=new Recruit();
			String ridstr=request.getParameter("rid");
			int rid=0;
			rid=Integer.parseInt(ridstr);
			recruit.setRid(rid);
			recruit.setCompanyname(request.getParameter("companyname"));
			recruit.setAddress(request.getParameter("address"));
			recruit.setPostcode(request.getParameter("postcode"));
			recruit.setRecruitment(request.getParameter("recruitment"));
			recruit.setWorkingplace(request.getParameter("workingplace"));
			recruit.setPositiontype(request.getParameter("positiontype"));
			recruit.setEdurequire(request.getParameter("edurequire"));
			recruit.setDescription(request.getParameter("description"));
			recruit.setBranch(request.getParameter("branch"));
			recruit.setLinkman(request.getParameter("linkman"));
			recruit.setTelephone(request.getParameter("telephone"));
			recruit.setHostpage(request.getParameter("hostpage"));
			recruit.setEmail(request.getParameter("email"));
			//更新到数据库
			boolean flag=rd.UpdateRecruit(recruit);
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

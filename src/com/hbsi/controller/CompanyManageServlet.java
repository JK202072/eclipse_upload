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
import com.hbsi.bean.Student;
import com.hbsi.bean.User;
import com.hbsi.dao.CompanyDao;

import com.hbsi.dao.service.CompanyDaoImpl;



@WebServlet("/CompanyManageServlet")
public class CompanyManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CompanyManageServlet() {
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
		CompanyDao cd=new CompanyDaoImpl();
		HttpSession session=request.getSession();
		if(action.equals("comregister")) {
			String id=request.getParameter("cid");
			int cid=0;
			try {
				cid=Integer.parseInt(id);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			String companyname=request.getParameter("companyname");
			String unitproperty=request.getParameter("unitproperty");
			String licensenumber=request.getParameter("licensenumber");
			String industry=request.getParameter("industry");
			String unitscale=request.getParameter("unitscale");
			String address=request.getParameter("address");
			String webaddress=request.getParameter("webaddress");
			String linkman=request.getParameter("linkman");
			String telephone=request.getParameter("telephone");
			String email=request.getParameter("email");
			String postcode=request.getParameter("postcode");
			
			Company company=new Company();
			
			company.setCid(cid);
			
			company.setCompanyname(companyname);
			company.setUnitproperty(unitproperty);
			company.setLicensenumber(licensenumber);
			company.setIndustry(industry);
			company.setUnitscale(unitscale);
			company.setAddress(address);
			company.setWebaddress(webaddress);
			company.setLinkman(linkman);
			company.setTelephone(telephone);
			company.setEmail(email);
			company.setPostcode(postcode);
			
			boolean flag=cd.addCompany(company);
			if(flag) {
				request.setAttribute("errorMsg", "企业用户注册成功，请联系管理员激活帐号");
				this.gotoPage("public/login.jsp",request,response);
			}else {
				request.setAttribute("cid", company.getCid());
				this.gotoPage("company/companyInfo.jsp", request, response);
			}
			
			
		}
		if(action.equals("companyedit")) {
			
			Company company=new Company();
			User user=(User)session.getAttribute("user");
			if (user.getUsertypes().equals("company")) {
				company=cd.lookCompany(user.getId());
			}else if (user.getUsertypes().equals("admin")) {
				String id=request.getParameter("cid");
				int cid=0;
				cid=Integer.parseInt(id);
				company=cd.lookCompany(cid);
			}
			request.setAttribute("company", company);
			this.gotoPage("company/CompanyEdit.jsp", request, response);
		}
		if (action.equals("update")) {
			Company company=new Company();
			String id=request.getParameter("cid");
			int cid=0;
			cid=Integer.parseInt(id);
			company.setCid(cid);
			company.setCompanyname(request.getParameter("companyname"));
			company.setUnitproperty(request.getParameter("unitproperty"));
			company.setLicensenumber(request.getParameter("licensenumber"));
			company.setIndustry(request.getParameter("industry"));
			company.setUnitscale(request.getParameter("unitscale"));
			company.setAddress(request.getParameter("address"));
			company.setWebaddress(request.getParameter("webaddress"));
			company.setLinkman(request.getParameter("linkman"));
			company.setTelephone(request.getParameter("telephone"));
			company.setEmail(request.getParameter("email"));
			company.setPostcode(request.getParameter("postcode"));
			//更新到数据库
			boolean flag=cd.UpdateCompany(company);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		if(action.equals("choose")) {
			Company company=new Company();
			User user=(User)session.getAttribute("user");
			if (user.getUsertypes().equals("company")) {
				company=cd.lookCompany(user.getId());
			}else if (user.getUsertypes().equals("admin")) {
				String id=request.getParameter("cid");
				int cid=0;
				cid=Integer.parseInt(id);
				company=cd.lookCompany(cid);
			}
			request.setAttribute("company", company);
			this.gotoPage("public/recruit.jsp", request, response);
		}
		if (action.equals("show")) {
			User user=(User)session.getAttribute("user");
			int cid=0;
			if ("company".equals(user.getUsertypes())) {
				cid=user.getId();
			}else {
				String cidStr=request.getParameter("cid");
				try {
					cid=Integer.parseInt(cidStr);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			Company company=cd.lookCompany(cid);
			request.setAttribute("company", company);
			this.gotoPage("company/showCompany.jsp", request, response);
		}
		if (action.equals("companylist")) {
//			String sql=request.getParameter("sql");
//			List<Company> companys=cd.doFindAll();
//			request.setAttribute("list", companys);
//			this.gotoPage("admin/companyList.jsp?sql=", request, response);
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
					dopage.setSql("where companyname like '%"+sqlstr+"%'");
				}
			
			
			dopage.setCount(cd.doCount(dopage));
			dopage.setTotalPage(cd.doTotalPage(dopage));
			
			dopage=cd.doFindAll(dopage);
			
			request.setAttribute("doPage", dopage);
		    this.gotoPage("admin/companyList.jsp", request, response);
		}
		
		if (action.equals("delete")) {
			String strcid=request.getParameter("cid");
			int cid;
			cid=Integer.parseInt(strcid);
			boolean flag=cd.delcompany(cid);
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

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
import com.hbsi.bean.Recruit;
import com.hbsi.bean.Resume;
import com.hbsi.bean.Student;
import com.hbsi.bean.User;
import com.hbsi.dao.ResumeDao;
import com.hbsi.dao.StudentDao;
import com.hbsi.dao.service.ResumeDaoImpl;
import com.hbsi.dao.service.StudentDaoImpl;

@WebServlet("/ResumeManageServlet")
public class ResumeManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ResumeManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		ResumeDao rd=new ResumeDaoImpl();
		if (action.equals("create")) {
			StudentDao sd=new StudentDaoImpl();
			Student student=sd.lookStudent(user.getId());
			request.setAttribute("student", student);
			this.gotoPage("stu/resume.jsp", request, response);
		}
		
		if(action.equals("add")) {
			Resume resume=new Resume();
			int sid= Integer.parseInt(request.getParameter("sid"));
			resume.setSid(sid);
			resume.setSname(request.getParameter("sname"));
			resume.setGender(request.getParameter("gender"));
			resume.setBirthdate(request.getParameter("birthdate"));
			resume.setNation(request.getParameter("nation"));
			resume.setPolitics(request.getParameter("politics"));
			resume.setGraduation(request.getParameter("graduation"));
			resume.setSchool(request.getParameter("school"));
			resume.setMajor(request.getParameter("major"));
			resume.setEducation(request.getParameter("education"));
			resume.setEmail(request.getParameter("email"));
			resume.setPhone(request.getParameter("phone"));
			resume.setForeignlanguage(request.getParameter("foreignlanguage"));
			resume.setHobby(request.getParameter("hobby"));
			resume.setPractice(request.getParameter("practice"));
			resume.setPosition(request.getParameter("position"));
			resume.setHonor(request.getParameter("honor"));
			resume.setResearch(request.getParameter("research"));
			resume.setSelfevaluation(request.getParameter("selfevaluation"));
			
			boolean flag=rd.addResume(resume);
			if(flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
		
        if(action.equals("edit")) {
			Resume resume=new Resume();
			if (user.getUsertypes().equals("student")) {
				resume=rd.lookResume(user.getId());
			}else if (user.getUsertypes().equals("admin")) {
				String sidstr=request.getParameter("sid");
				int sid=0;
				sid=Integer.parseInt(sidstr);
				resume=rd.lookResume(sid);
			}
			request.setAttribute("resume", resume);
			this.gotoPage("stu/Edit.jsp", request, response);
		}
        if (action.equals("update")) {
			Resume resume=new Resume();
			int sid= Integer.parseInt(request.getParameter("sid"));
			resume.setSid(sid);
			resume.setSname(request.getParameter("sname"));
			resume.setGender(request.getParameter("gender"));
			resume.setBirthdate(request.getParameter("birthdate"));
			resume.setNation(request.getParameter("nation"));
			resume.setPolitics(request.getParameter("politics"));
			resume.setGraduation(request.getParameter("graduation"));
			resume.setSchool(request.getParameter("school"));
			resume.setMajor(request.getParameter("major"));
			resume.setEducation(request.getParameter("education"));
			resume.setEmail(request.getParameter("email"));
			resume.setPhone(request.getParameter("phone"));
			resume.setForeignlanguage(request.getParameter("foreignlanguage"));
			resume.setHobby(request.getParameter("hobby"));
			resume.setPractice(request.getParameter("practice"));
			resume.setPosition(request.getParameter("position"));
			resume.setHonor(request.getParameter("honor"));
			resume.setResearch(request.getParameter("research"));
			resume.setSelfevaluation(request.getParameter("selfevaluation"));
			//更新到数据库
			boolean flag=rd.UpdateResume(resume);
			System.out.println(flag);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}
		}
        if (action.equals("showsturesume")) {
			String sidstr=request.getParameter("sid");
			int sid=0;
			sid=Integer.parseInt(sidstr);
			Resume resume=rd.lookResume(sid);
			request.setAttribute("resume",resume);
			this.gotoPage("company/showResumelist.jsp", request, response);
		}
	}
	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO 自动生成的方法存根
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

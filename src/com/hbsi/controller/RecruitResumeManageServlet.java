package com.hbsi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbsi.bean.Company;
import com.hbsi.bean.Recruit;
import com.hbsi.bean.RecruitResume;
import com.hbsi.bean.Resume;
import com.hbsi.bean.User;
import com.hbsi.dao.RecruitDao;
import com.hbsi.dao.RecruitResumeDao;
import com.hbsi.dao.ResumeDao;
import com.hbsi.dao.service.RecruitDaoImpl;
import com.hbsi.dao.service.RecruitResumeDaoImpl;
import com.hbsi.dao.service.ResumeDaoImpl;

@WebServlet("/RecruitResumeManageServlet")
public class RecruitResumeManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RecruitResumeManageServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		RecruitResumeDao rrDao=new RecruitResumeDaoImpl();
		if (action.equals("post")) {
			int rid=0;
			int cid=0;
			int sid=0;
			String ridstr=request.getParameter("rid");
			rid=Integer.parseInt(ridstr);
			String cidstr=request.getParameter("cid");
			cid=Integer.parseInt(cidstr);
			String sidstr=request.getParameter("sid");
			sid=Integer.parseInt(sidstr);
			RecruitResume recres=new RecruitResume();
			recres.setRid(rid);
			recres.setCid(cid);
			recres.setSid(sid);
			boolean flag=rrDao.addRecruitResume(recres);
			if (flag) {
				this.gotoPage("public/success.jsp", request, response);
			}else {
				this.gotoPage("public/error.jsp", request, response);
			}		
					
		}
		if (action.equals("list")) {
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("user");
			int cid=user.getId();
			List<Integer> cidlist=rrDao.LookRecruitBycid(cid);
			List<Recruit> recruitlist=new ArrayList<Recruit>();
			RecruitDao rDao=new RecruitDaoImpl();
			for(Integer id:cidlist){
				Recruit recruit=rDao.lookRecruit(id);
				recruitlist.add(recruit);
			}
			request.setAttribute("recruitlist", recruitlist);
			this.gotoPage("company/replayRecruitlist.jsp", request, response);
		}
		if (action.equals("showresumes")) {
			String ridstr=request.getParameter("rid");
			int rid=0;
			rid=Integer.parseInt(ridstr);
			List<Integer> ridlist=rrDao.LookRecruitByrid(rid);
			List<Resume> resumelist=new ArrayList<Resume>();
			ResumeDao rDao=new ResumeDaoImpl();
			for(Integer sid:ridlist){
				Resume resume=rDao.lookResume(sid);
				resumelist.add(resume);
			}
			request.setAttribute("resumelist", resumelist);
			this.gotoPage("company/replayResumelist.jsp", request, response);
		}
	}
	private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

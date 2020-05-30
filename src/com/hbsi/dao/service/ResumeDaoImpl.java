package com.hbsi.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hbsi.bean.Company;
import com.hbsi.bean.DoPage;
import com.hbsi.bean.Recruit;
import com.hbsi.bean.Resume;
import com.hbsi.bean.User;
import com.hbsi.dao.ResumeDao;
import com.hbsi.db.ConnectionFactory;
import com.hbsi.db.DBClose;

public class ResumeDaoImpl implements ResumeDao{
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;

	@Override
	public boolean addResume(Resume resume) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="insert into resume values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setInt(1, resume.getSid());
			pstat.setString(2, resume.getSname());
			pstat.setString(3, resume.getGender());
			pstat.setString(4, resume.getBirthdate());
			pstat.setString(5, resume.getNation());
			pstat.setString(6, resume.getPolitics());
			pstat.setString(7, resume.getGraduation());
			pstat.setString(8, resume.getSchool());
			pstat.setString(9, resume.getMajor());
			pstat.setString(10,resume.getEducation());
			pstat.setString(11, resume.getEmail());
			pstat.setString(12, resume.getPhone());
			pstat.setString(13, resume.getForeignlanguage());
			pstat.setString(14, resume.getHobby());
			pstat.setString(15, resume.getPractice());
			pstat.setString(16, resume.getPosition());
			pstat.setString(17, resume.getHonor());
			pstat.setString(18, resume.getResearch());
			pstat.setString(19, resume.getSelfevaluation());
			int i=pstat.executeUpdate();
			if(i>0) {
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBClose.close(pstat, con);
		}
		return flag;
	}

	@Override
	public Resume lookResume(int sid) {
		con=ConnectionFactory.getConnection();
		String sql="select * from resume Where sid="+sid;
		Resume resume=new Resume();
		try {
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			if (rs.next()) {
				resume.setSid(rs.getInt("sid"));
				resume.setSname(rs.getString("sname"));
				resume.setGender(rs.getString("gender"));
				resume.setBirthdate(rs.getString("birthdate"));
				resume.setNation(rs.getString("nation"));
				resume.setPolitics(rs.getString("politics"));
				resume.setGraduation(rs.getString("graduation"));
				resume.setSchool(rs.getString("school"));
				resume.setMajor(rs.getString("major"));
				resume.setEducation(rs.getString("education"));
				resume.setEmail(rs.getString("email"));
				resume.setPhone(rs.getString("phone"));
				resume.setForeignlanguage(rs.getString("foreignlanguage"));
				resume.setHobby(rs.getString("hobby"));
				resume.setPractice(rs.getString("practice"));
				resume.setPosition(rs.getString("position"));
				resume.setHonor(rs.getString("honor"));
				resume.setResearch(rs.getString("research"));
				resume.setSelfevaluation(rs.getString("selfevaluation"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBClose.close(rs,pstat, con);
		}
		return resume;
	}

	@Override
	public boolean UpdateResume(Resume resume) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("update resume set sname=?,gender=?,birthdate=?,nation=?,politics=?,graduation=?,school=?,major=?,education=?,email=?,phone=?,foreignlanguage=?,hobby=?,practice=?,position=?,honor=?,research=?,selfevaluation=? where sid=?");
			pstat.setString(1, resume.getSname());
			pstat.setString(2, resume.getGender());
			pstat.setString(3, resume.getBirthdate());
			pstat.setString(4, resume.getNation());
			pstat.setString(5, resume.getPolitics());
			pstat.setString(6, resume.getGraduation());
			pstat.setString(7, resume.getSchool());
			pstat.setString(8, resume.getMajor());
			pstat.setString(9,resume.getEducation());
			pstat.setString(10, resume.getEmail());
			pstat.setString(11, resume.getPhone());
			pstat.setString(12, resume.getForeignlanguage());
			pstat.setString(13, resume.getHobby());
			pstat.setString(14, resume.getPractice());
			pstat.setString(15, resume.getPosition());
			pstat.setString(16, resume.getHonor());
			pstat.setString(17, resume.getResearch());
			pstat.setString(18, resume.getSelfevaluation());
			pstat.setInt(19, resume.getSid());
			int i=pstat.executeUpdate();
			
			if (i>0) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBClose.close(pstat, con);
		}
		return flag;
	}

	

}

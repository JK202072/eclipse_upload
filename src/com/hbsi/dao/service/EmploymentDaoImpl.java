package com.hbsi.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hbsi.bean.Company;
import com.hbsi.bean.DoPage;
import com.hbsi.bean.Employment;
import com.hbsi.dao.EmploymentDao;
import com.hbsi.db.ConnectionFactory;
import com.hbsi.db.DBClose;

public class EmploymentDaoImpl implements EmploymentDao {
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;

	@Override
	public boolean addEmployment(Employment employment) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="insert into employment(studentname,school,companyname,position) values(?,?,?,?)";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setString(1, employment.getStudentname());
			pstat.setString(2, employment.getSchool());
			pstat.setString(3, employment.getCompanyname());
			pstat.setString(4, employment.getPosition());
			
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

//	@Override
//	public List<Employment> doFindAll() {
//		List<Employment> list=new ArrayList<Employment>();
//		con=ConnectionFactory.getConnection();
//		try {
//			String sql="select * from employment";
//			pstat=con.prepareStatement(sql);
//			rs=pstat.executeQuery();
//			while(rs.next()) {
//				Employment employment=new Employment();
//				employment.setEid(rs.getInt("eid"));
//				employment.setStudentname(rs.getString("studentname"));
//				employment.setSchool(rs.getString("school"));
//				employment.setCompanyname(rs.getString("companyname"));
//				employment.setPosition(rs.getString("position"));
//				list.add(employment);
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBClose.close(rs, pstat, con);
//		}
//		return list;
//	}

	@Override
	public boolean delemployment(int eid) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="delete from employment where eid="+eid;
		try {
			pstat=con.prepareStatement(sql);
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

	@Override
	public Employment lookemployment(int eid) {
		con=ConnectionFactory.getConnection();
		String sql="select * from employment Where eid="+eid;
		Employment employment=new Employment();
		try {
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			if (rs.next()) {
				employment.setEid(rs.getInt("eid"));
				employment.setStudentname(rs.getString("studentname"));
				employment.setSchool(rs.getString("school"));
				employment.setCompanyname(rs.getString("companyname"));
				employment.setPosition(rs.getString("position"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBClose.close(rs,pstat, con);
		}
		return employment;
	}

	@Override
	public boolean UpdateEmployment(Employment employment) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("update employment set studentname=?,school=?,companyname=?,position=? Where eid=?");
			pstat.setString(1, employment.getStudentname());
			pstat.setString(2, employment.getSchool());
			pstat.setString(3, employment.getCompanyname());
			pstat.setString(4, employment.getPosition());
			pstat.setInt(5, employment.getEid());
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

	@Override
	public DoPage doFindAll(DoPage dopage) {
		List list=new ArrayList();
		con=ConnectionFactory.getConnection();
		try {
			String sql="select * from employment "+dopage.getSql()+" limit "+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize();
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				Employment employment=new Employment();
				employment.setEid(rs.getInt("eid"));
				employment.setStudentname(rs.getString("studentname"));
				employment.setSchool(rs.getString("school"));
				employment.setCompanyname(rs.getString("companyname"));
				employment.setPosition(rs.getString("position"));
				list.add(employment);
			}
			dopage.setList(list);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(rs, pstat, con);
		}
		return dopage;
	}

	@Override
	public int doCount(DoPage doPage) {//获取总记录数
		int count=0;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select count(*) from employment"+doPage.getSql());
			rs=pstat.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(null, pstat, con);
		}
		return count;
	}
	@Override
	public int doTotalPage(DoPage doPage) {//获取总页数
		int totalPage=0;
		int m=doCount(doPage)/doPage.getPageSize();
		if (doCount(doPage)%doPage.getPageSize()>0) {
			totalPage=m+1;
		} else {
			totalPage=m;
		}
		return totalPage;
	}


}

package com.hbsi.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Employment;
import com.hbsi.bean.Student;
import com.hbsi.dao.StudentDao;
import com.hbsi.db.ConnectionFactory;
import com.hbsi.db.DBClose;

import jdk.nashorn.internal.objects.annotations.Where;
import sun.text.resources.cldr.om.FormatData_om;

public class StudentDaoImpl implements StudentDao {
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;

	@Override
	public boolean addStudent(Student student) {
		// TODO 自动生成的方法存根
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="insert into student values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setInt(1, student.getSid());
			pstat.setString(2, student.getSname());
			pstat.setString(3, student.getGender());
			pstat.setString(4, student.getIdnumber());
			pstat.setString(5, student.getSchool());
			pstat.setString(6, student.getDepartment());
			pstat.setString(7, student.getMajor());
			pstat.setString(8, student.getEducation());
			pstat.setString(9, student.getEntrancedate());
			pstat.setString(10, student.getNativeplace());
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
	public Student lookStudent(int sid) {
		// TODO 自动生成的方法存根
		con=ConnectionFactory.getConnection();
		String sql="select * from student Where sid="+sid;
		Student student=new Student();
		try {
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			if (rs.next()) {
				student.setSid(rs.getInt("sid"));
				student.setSname(rs.getString("sname"));
				student.setGender(rs.getString("gender"));
				student.setIdnumber(rs.getString("idnumber"));
				student.setSchool(rs.getString("school"));
				student.setDepartment(rs.getString("department"));
				student.setMajor(rs.getString("major"));
				student.setEducation(rs.getString("education"));
				student.setEntrancedate(rs.getString("entrancedate"));
				student.setNativeplace(rs.getString("nativeplace"));
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBClose.close(rs, pstat, con);
		}
		return student;
	}

//	@Override
//	public List<Student> doFindAll() {
//		// TODO 自动生成的方法存根
//		List<Student> studentlist=new ArrayList<Student>();
//		con=ConnectionFactory.getConnection();
//		try {
//			String sql="select * from student";
//			pstat=con.prepareStatement(sql);
//			rs=pstat.executeQuery();
//			while(rs.next()) {
//				Student student=new Student();
//				student.setSid(rs.getInt("sid"));
//				student.setSname(rs.getString("sname"));
//				student.setGender(rs.getString("gender"));
//				student.setIdnumber(rs.getString("idnumber"));
//				student.setSchool(rs.getString("school"));
//				student.setDepartment(rs.getString("department"));
//				student.setMajor(rs.getString("major"));
//				student.setEducation(rs.getString("education"));
//				student.setEntrancedate(rs.getString("entrancedate"));
//				student.setNativeplace(rs.getString("nativeplace"));
//				studentlist.add(student);
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBClose.close(rs, pstat, con);
//		}
//		return studentlist;
//	}

	@Override
	public boolean delstudent(int sid) {
		// TODO 自动生成的方法存根
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="delete from student where sid="+sid;
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
	public DoPage doFindAll(DoPage dopage) {
		List list=new ArrayList();
		con=ConnectionFactory.getConnection();
		try {
			String sql="select * from student "+dopage.getSql()+" limit "+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize();
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				Student student=new Student();
				student.setSid(rs.getInt("sid"));
				student.setSname(rs.getString("sname"));
				student.setGender(rs.getString("gender"));
				student.setIdnumber(rs.getString("idnumber"));
				student.setSchool(rs.getString("school"));
				student.setDepartment(rs.getString("department"));
				student.setMajor(rs.getString("major"));
				student.setEducation(rs.getString("education"));
				student.setEntrancedate(rs.getString("entrancedate"));
				student.setNativeplace(rs.getString("nativeplace"));
				list.add(student);
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
			pstat=con.prepareStatement("select count(*) from student"+doPage.getSql());
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

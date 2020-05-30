package com.hbsi.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Recruit;
import com.hbsi.bean.RecruitResume;
import com.hbsi.dao.RecruitResumeDao;
import com.hbsi.db.ConnectionFactory;
import com.hbsi.db.DBClose;

public class RecruitResumeDaoImpl implements RecruitResumeDao {
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;

	@Override
	public boolean addRecruitResume(RecruitResume rr) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("insert into recruitresume value(?,?,?)");
			pstat.setInt(1, rr.getRid());
			pstat.setInt(2, rr.getCid());
			pstat.setInt(3, rr.getSid());
			int i=pstat.executeUpdate();
			if (i>0) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(pstat, con);
		}
		return flag;
	}

	@Override
	public List<Integer> LookRecruitBycid(int cid) {
		List<Integer> list=new ArrayList<Integer>();
		con=ConnectionFactory.getConnection();
		String sql="select * from recruit where cid="+cid;
		try {
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			while (rs.next()) {
				int rid=rs.getInt("rid");
				list.add(rid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(rs, pstat, con);
		}
 		return list;
	}

	@Override
	public List<Integer> LookRecruitByrid(int rid) {
		List<Integer> list=new ArrayList<Integer>();
		con=ConnectionFactory.getConnection();
		String sql="select * from recruitresume where rid="+rid;
		try {
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			while (rs.next()) {
				int sid=rs.getInt("sid");
				list.add(sid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(rs, pstat, con);
		}
 		return list;
	}

}

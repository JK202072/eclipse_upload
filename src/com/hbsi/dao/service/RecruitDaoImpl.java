package com.hbsi.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Recruit;
import com.hbsi.dao.RecruitDao;
import com.hbsi.db.ConnectionFactory;
import com.hbsi.db.DBClose;

public class RecruitDaoImpl implements RecruitDao{
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;

	@Override
	public boolean addRecruit(Recruit recruit) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="insert into recruit(cid,companyname,address,postcode,recruitment,workingplace,positiontype,edurequire,description,branch,linkman,telephone,hostpage,email) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setInt(1, recruit.getCid());
			pstat.setString(2, recruit.getCompanyname());
			pstat.setString(3, recruit.getAddress());
			pstat.setString(4, recruit.getPostcode());
			pstat.setString(5, recruit.getRecruitment());
			pstat.setString(6, recruit.getWorkingplace());
			pstat.setString(7, recruit.getPositiontype());
			pstat.setString(8, recruit.getEdurequire());
			pstat.setString(9, recruit.getDescription());
			pstat.setString(10, recruit.getBranch());
			pstat.setString(11, recruit.getLinkman());
			pstat.setString(12, recruit.getTelephone());
			pstat.setString(13, recruit.getHostpage());
			pstat.setString(14, recruit.getEmail());
			
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
	public int doCount(DoPage dopage) {
		int count=0;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select count(*) from recruit"+dopage.getSql());
			rs=pstat.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBClose.close(null, pstat, con);
		}
		return count;
	}

	@Override
	public int doTotalPage(DoPage dopage) {
		int totalPage=0;
		int m=doCount(dopage)/dopage.getPageSize();
		if (doCount(dopage)%dopage.getPageSize()>0) {
			totalPage=m+1;
		}else {
			totalPage=m;
		}
		return totalPage;
	}

	@Override
	public DoPage doFindAll(DoPage dopage) {
		List list=new ArrayList();
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select * from recruit "+dopage.getSql()+" limit "+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize());
			rs=pstat.executeQuery();
			while (rs.next()) {
				Recruit recruit=new Recruit();
				recruit.setRid(rs.getInt("rid"));
				recruit.setCid(rs.getInt("cid"));
				recruit.setCompanyname(rs.getString("companyname"));
				recruit.setAddress(rs.getString("address"));
				recruit.setPostcode(rs.getString("postcode"));
				recruit.setRecruitment(rs.getString("recruitment"));
				recruit.setWorkingplace(rs.getString("workingplace"));
				recruit.setPositiontype(rs.getString("positiontype"));
				recruit.setEdurequire(rs.getString("edurequire"));
				recruit.setDescription(rs.getString("description"));
				recruit.setBranch(rs.getString("branch"));
				recruit.setLinkman(rs.getString("linkman"));
				recruit.setTelephone(rs.getString("telephone"));
				recruit.setHostpage(rs.getString("hostpage"));
				recruit.setEmail(rs.getString("email"));
				list.add(recruit);
			}
			dopage.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(rs, pstat, con);
		}
		return dopage;
	}
	@Override
	public Recruit lookRecruit(int rid) {
		Recruit recruit=new Recruit();
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select * from recruit where rid="+rid);
			rs=pstat.executeQuery();
			if (rs.next()) {
				recruit.setRid(rs.getInt("rid"));
				recruit.setCid(rs.getInt("cid"));
				recruit.setCompanyname(rs.getString("companyname"));
				recruit.setAddress(rs.getString("address"));
				recruit.setPostcode(rs.getString("postcode"));
				recruit.setRecruitment(rs.getString("recruitment"));
				recruit.setWorkingplace(rs.getString("workingplace"));
				recruit.setPositiontype(rs.getString("positiontype"));
				recruit.setEdurequire(rs.getString("edurequire"));
				recruit.setDescription(rs.getString("description"));
				recruit.setBranch(rs.getString("branch"));
				recruit.setLinkman(rs.getString("linkman"));
				recruit.setTelephone(rs.getString("telephone"));
				recruit.setHostpage(rs.getString("hostpage"));
				recruit.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return recruit;
	}
	@Override
	public boolean delrecruit(int rid) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="delete from recruit where rid="+rid;
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
	public boolean UpdateRecruit(Recruit recruit) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="update recruit set companyname=?,address=?,postcode=?,recruitment=?,workingplace=?,positiontype=?,edurequire=?,description=?,branch=?,linkman=?,telephone=?,hostpage=?,email=? where rid=?";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setString(1, recruit.getCompanyname());
			pstat.setString(2, recruit.getAddress());
			pstat.setString(3, recruit.getPostcode());
			pstat.setString(4, recruit.getRecruitment());
			pstat.setString(5, recruit.getWorkingplace());
			pstat.setString(6, recruit.getPositiontype());
			pstat.setString(7, recruit.getEdurequire());
			pstat.setString(8, recruit.getDescription());
			pstat.setString(9, recruit.getBranch());
			pstat.setString(10, recruit.getLinkman());
			pstat.setString(11, recruit.getTelephone());
			pstat.setString(12, recruit.getHostpage());
			pstat.setString(13, recruit.getEmail());
			pstat.setInt(14, recruit.getRid());
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

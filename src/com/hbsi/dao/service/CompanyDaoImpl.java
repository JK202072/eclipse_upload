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
import com.hbsi.bean.Student;
import com.hbsi.dao.CompanyDao;
import com.hbsi.db.ConnectionFactory;
import com.hbsi.db.DBClose;

public class CompanyDaoImpl implements CompanyDao{
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;

	@Override
	public boolean addCompany(Company company) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="insert into company values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setInt(1, company.getCid());
			pstat.setString(2, company.getCompanyname());
			pstat.setString(3, company.getUnitproperty());
			pstat.setString(4, company.getLicensenumber());
			pstat.setString(5, company.getIndustry());
			pstat.setString(6, company.getUnitscale());
			pstat.setString(7, company.getAddress());
			pstat.setString(8, company.getWebaddress());
			pstat.setString(9, company.getLinkman());
			pstat.setString(10, company.getTelephone());
			pstat.setString(11, company.getEmail());
			pstat.setString(12, company.getPostcode());
			int i=pstat.executeUpdate();
			if(i>0) {
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
	public Company lookCompany(int cid) {
		con=ConnectionFactory.getConnection();
		String sql="select * from company Where cid="+cid;
		Company company=new Company();
		try {
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			if (rs.next()) {
				company.setCid(rs.getInt("cid"));
				company.setAddress(rs.getString("address"));
				company.setCompanyname(rs.getString("companyname"));
				company.setEmail(rs.getString("email"));
				company.setIndustry(rs.getString("industry"));
				company.setLicensenumber(rs.getString("licensenumber"));
				company.setLinkman(rs.getString("linkman"));
				company.setPostcode(rs.getString("postcode"));
				company.setTelephone(rs.getString("telephone"));
				company.setUnitproperty(rs.getString("unitproperty"));
				company.setUnitscale(rs.getString("unitscale"));
				company.setWebaddress(rs.getString("webaddress"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(rs,pstat, con);
		}
		return company;
	}

	@Override
	public boolean UpdateCompany(Company company) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("update company set companyname=?,unitproperty=?,licensenumber=?,industry=?,unitscale=?,address=?,webaddress=?,linkman=?,telephone=?,email=?,postcode=? Where cid=?");
			pstat.setString(1, company.getCompanyname());
			pstat.setString(2, company.getUnitproperty());
			pstat.setString(3, company.getLicensenumber());
			pstat.setString(4, company.getIndustry());
			pstat.setString(5, company.getUnitscale());
			pstat.setString(6, company.getAddress());
			pstat.setString(7, company.getWebaddress());
			pstat.setString(8, company.getLinkman());
			pstat.setString(9, company.getTelephone());
			pstat.setString(10, company.getEmail());
			pstat.setString(11, company.getPostcode());
			pstat.setInt(12, company.getCid());
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
	public boolean delcompany(int cid) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="delete from company where cid="+cid;
		try {
			pstat=con.prepareStatement(sql);
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
	public DoPage doFindAll(DoPage dopage) {
		List list=new ArrayList();
		con=ConnectionFactory.getConnection();
		try {
			String sql="select * from company "+dopage.getSql()+" limit "+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize();
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				Company company=new Company();
				company.setCid(rs.getInt("cid"));
				company.setAddress(rs.getString("address"));
				company.setCompanyname(rs.getString("companyname"));
				company.setEmail(rs.getString("email"));
				company.setIndustry(rs.getString("industry"));
				company.setLicensenumber(rs.getString("licensenumber"));
				company.setLinkman(rs.getString("linkman"));
				company.setPostcode(rs.getString("postcode"));
				company.setTelephone(rs.getString("telephone"));
				company.setUnitproperty(rs.getString("unitproperty"));
				company.setUnitscale(rs.getString("unitscale"));
				company.setWebaddress(rs.getString("webaddress"));
				list.add(company);
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
	public int doCount(DoPage doPage) {
		int count=0;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select count(*) from company"+doPage.getSql());
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
	public int doTotalPage(DoPage doPage) {
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

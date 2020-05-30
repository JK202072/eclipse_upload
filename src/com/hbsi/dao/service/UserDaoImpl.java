package com.hbsi.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.User;
import com.hbsi.dao.UserDao;
import com.hbsi.db.ConnectionFactory;
import com.hbsi.db.DBClose;

public class UserDaoImpl implements UserDao {
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;

	@Override
	public User lookUser(User user) {
		// TODO 自动生成的方法存根
		con=ConnectionFactory.getConnection();
		String sql="select * from user where username=? and password=? and usertypes=?";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setString(3, user.getUsertypes());
			rs=pstat.executeQuery();
			
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUsertypes(rs.getString("usertypes"));
				user.setVerify(rs.getString("verify"));
			}else {
				user.setUsertypes("error");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBClose.close(rs, pstat, con);
		}
		return user;
	}

	@Override
	public boolean checkUsername(String username) {
		// TODO 自动生成的方法存根
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="select * from user where username='"+username+"'";
		try {
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			if (rs.next()) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			DBClose.close(rs, pstat, con);
		}
		return flag;
	}

	@Override
	public User addUser(User user) {
		// TODO 自动生成的方法存根
		con=ConnectionFactory.getConnection();
		String sql="insert into user(username,password,usertypes,verify) values(?,?,?,?)";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setString(3, user.getUsertypes());
			pstat.setInt(4, 1);
			int i=pstat.executeUpdate();
			if (i>0) {
				user=this.lookUser(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return user;
	}

	public boolean updatePwd(User user) {

		// TODO 自动生成的方法存根
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("update user set password=? where id=?");
			pstat.setString(1, user.getPassword());
			pstat.setInt(2, user.getId());
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
	public int doCount(DoPage dopage) {
		int count=0;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select count(*) from user"+dopage.getSql());
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
	//定义方法获取总页数
	public int doTotalPage(DoPage dopage) {
		// TODO 自动生成的方法存根
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
	//定义方法查询某一页要显示的数据
	public DoPage doFindAll(DoPage dopage) {
		List list=new ArrayList();
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select * from user "+dopage.getSql()+" limit "+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize());
			rs=pstat.executeQuery();
			while (rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUsertypes(rs.getString("usertypes"));
				user.setVerify(rs.getString("verify"));
				list.add(user);
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
	public boolean deleteUser(int id) {
		boolean flag=false;
		User user=this.lookUserById(id);
		con=ConnectionFactory.getConnection();
		try {
			if ("admin".equals(user.getUsertypes())) {
				pstat=con.prepareStatement("delete from user where id="+id);
				int i=pstat.executeUpdate();
				if (i>0) {
					flag=true;
				}
			}
			if ("student".equals(user.getUsertypes())) {
				pstat=con.prepareStatement("delete from user where id="+id);
				
				int i=pstat.executeUpdate();
				pstat=con.prepareStatement("delete from student where sid="+id);
				int j=pstat.executeUpdate();
				pstat=con.prepareStatement("delete from resume where sid="+id);
				int k=pstat.executeUpdate();
				pstat=con.prepareStatement("delete from recruitresume where sid="+id);
				int m=pstat.executeUpdate();
				pstat=con.prepareStatement("delete from message where id="+id);
				int n=pstat.executeUpdate();
				if (i>0) {
					flag=true;
				}
			}
			if ("company".equals(user.getUsertypes())) {
				pstat=con.prepareStatement("delete from user where id="+id);
				
				int i=pstat.executeUpdate();
				pstat=con.prepareStatement("delete from company where cid="+id);
				int j=pstat.executeUpdate();
				pstat=con.prepareStatement("delete from recruit where cid="+id);
				int k=pstat.executeUpdate();
				pstat=con.prepareStatement("delete from recruitresume where cid="+id);
				int m=pstat.executeUpdate();
				pstat=con.prepareStatement("delete from message where id="+id);
				int n=pstat.executeUpdate();
				if (i>0) {
					flag=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(pstat, con);
		}
		return flag;
	}

	@Override
	//禁用用户
	public boolean disableUser(int id) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("update user set verify='1' where id="+id);
			
			int n=pstat.executeUpdate();
			if (n!=0) {
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
	//激活用户
	public boolean activeUser(int id) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("update user set verify='2' where id="+id);
			int n=pstat.executeUpdate();
			if (n!=0) {
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
	//设置用户审核未通过
	public boolean invalid(int id) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("update user set verify='3' where id="+id);
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
	//根据id查询用户
	public User lookUserById(int id) {
		User user=new User();
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select * from user where id="+id);
			
			rs=pstat.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUsertypes(rs.getString("usertypes"));
				user.setVerify(rs.getString("verify"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBClose.close(rs, pstat, con);
		}
		return user;
	}

}

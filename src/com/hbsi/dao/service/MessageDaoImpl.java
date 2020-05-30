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
import com.hbsi.bean.Message;
import com.hbsi.dao.MessageDao;
import com.hbsi.db.ConnectionFactory;
import com.hbsi.db.DBClose;

public class MessageDaoImpl implements MessageDao {
	Connection con=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;

	@Override
	public boolean addMessage(Message message) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="insert into message(id,username,title,msgtime,content) values(?,?,?,?,?)";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setInt(1, message.getId());
			pstat.setString(2, message.getUsername());
			pstat.setString(3, message.getTitle());
			pstat.setString(4, message.getMsgtime());
			pstat.setString(5, message.getContent());
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
	public DoPage doFindAll(DoPage dopage) {//查询某一页要显示的数据
		List list=new ArrayList();
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select * from message "+dopage.getSql()+" limit "+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize());
			rs=pstat.executeQuery();
			while (rs.next()) {
				Message message=new Message();
				message.setMid(rs.getInt("mid"));
				message.setId(rs.getInt("id"));
				message.setUsername(rs.getString("username"));
				message.setTitle(rs.getString("title"));
				message.setMsgtime(rs.getString("msgtime"));
				message.setContent(rs.getString("content"));
				message.setReply(rs.getString("reply"));
				message.setReplytime(rs.getString("replytime"));
				list.add(message);
			}
			dopage.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return dopage;
	}

	@Override
	public boolean delmessage(int mid) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="delete from message where mid="+mid;
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
	public boolean UpdateMessage(Message message) {
		boolean flag=false;
		con=ConnectionFactory.getConnection();
		String sql="update message set reply=?,replytime=? where mid=?";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setString(1, message.getReply());
			pstat.setString(2, message.getReplytime());
			pstat.setInt(3, message.getMid());
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
	public Message lookmessage(int mid) {
		con=ConnectionFactory.getConnection();
		String sql="select * from message Where mid="+mid;
		Message message=new Message();
		try {
			pstat=con.prepareStatement(sql);
			rs=pstat.executeQuery();
			if (rs.next()) {
				message.setMid(rs.getInt("mid"));
				message.setReply(rs.getString("reply"));
				message.setReplytime(rs.getString("replytime"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBClose.close(rs,pstat, con);
		}
		return message;
	}
	@Override
	public int doCount(DoPage doPage) {//获取总记录数
		int count=0;
		con=ConnectionFactory.getConnection();
		try {
			pstat=con.prepareStatement("select count(*) from message"+doPage.getSql());
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

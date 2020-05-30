package com.hbsi.dao;

import java.util.List;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Message;

public interface MessageDao {
	boolean addMessage(Message message);
	int doCount(DoPage doPage);
	int doTotalPage(DoPage doPage);
	DoPage doFindAll(DoPage dopage);
	boolean UpdateMessage(Message message);
	boolean delmessage(int mid);
	Message lookmessage(int mid);
}

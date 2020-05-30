package com.hbsi.bean;

import java.util.List;

public class DoPage {
	private int nowPage;//表示当前是第几页
	private int pageSize;//表示每一页有多少条记录
	private int totalPage;//表示总共有多少页
	private List list;//List列表对象list用来封装某一页要显示的所有记录
	private String sql;//一个sql表示子查询条件
	private int count;//表示总共有多少条记录
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}

package com.hbsi.bean;

import java.util.List;

public class DoPage {
	private int nowPage;//��ʾ��ǰ�ǵڼ�ҳ
	private int pageSize;//��ʾÿһҳ�ж�������¼
	private int totalPage;//��ʾ�ܹ��ж���ҳ
	private List list;//List�б����list������װĳһҳҪ��ʾ�����м�¼
	private String sql;//һ��sql��ʾ�Ӳ�ѯ����
	private int count;//��ʾ�ܹ��ж�������¼
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

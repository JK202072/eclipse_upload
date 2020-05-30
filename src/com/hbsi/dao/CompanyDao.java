package com.hbsi.dao;

import java.util.List;

import com.hbsi.bean.Company;
import com.hbsi.bean.DoPage;

public interface CompanyDao {
	boolean addCompany(Company company);
	Company lookCompany(int cid);
	boolean UpdateCompany(Company company);
//	List<Company> doFindAll();
	boolean delcompany(int cid);
	int doCount(DoPage dopage);
	int doTotalPage(DoPage dopage);
	DoPage doFindAll(DoPage dopage);

}

package com.hbsi.dao;

import java.util.List;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Employment;

public interface EmploymentDao {
 boolean addEmployment(Employment employment);

boolean delemployment(int eid);

Employment lookemployment(int eid);

boolean UpdateEmployment(Employment employment);

DoPage doFindAll(DoPage dopage);
int doCount(DoPage doPage);
int doTotalPage(DoPage dopage);
}

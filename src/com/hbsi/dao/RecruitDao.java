package com.hbsi.dao;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Recruit;

public interface RecruitDao {
 boolean addRecruit(Recruit recruit);
 int doCount(DoPage dopage);

	int doTotalPage(DoPage dopage);

	DoPage doFindAll(DoPage dopage);
	
	Recruit lookRecruit(int rid);
	boolean delrecruit(int rid);
	boolean UpdateRecruit(Recruit recruit);
}

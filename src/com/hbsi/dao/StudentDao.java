package com.hbsi.dao;

import java.util.List;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Student;

public interface StudentDao {
	boolean addStudent(Student student);
	//定义方法查询学生基本信息
	Student lookStudent(int sid);
	//查询所有的学生数据
//	public List<Student> doFindAll();
	
	boolean delstudent(int sid);
	DoPage doFindAll(DoPage dopage);
	int doCount(DoPage doPage);
	int doTotalPage(DoPage dopage);

}

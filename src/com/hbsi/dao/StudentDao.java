package com.hbsi.dao;

import java.util.List;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Student;

public interface StudentDao {
	boolean addStudent(Student student);
	//���巽����ѯѧ��������Ϣ
	Student lookStudent(int sid);
	//��ѯ���е�ѧ������
//	public List<Student> doFindAll();
	
	boolean delstudent(int sid);
	DoPage doFindAll(DoPage dopage);
	int doCount(DoPage doPage);
	int doTotalPage(DoPage dopage);

}

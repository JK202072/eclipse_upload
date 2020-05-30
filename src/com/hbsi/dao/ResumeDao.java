package com.hbsi.dao;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.Resume;

public interface ResumeDao {

	boolean addResume(Resume resume);

	Resume lookResume(int sid);

	boolean UpdateResume(Resume resume);

}

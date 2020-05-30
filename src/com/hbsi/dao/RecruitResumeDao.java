package com.hbsi.dao;

import java.util.List;

import com.hbsi.bean.DoPage;
import com.hbsi.bean.RecruitResume;

public interface RecruitResumeDao {
 boolean addRecruitResume(RecruitResume rr);

List<Integer> LookRecruitBycid(int cid);
List<Integer> LookRecruitByrid(int rid);

}

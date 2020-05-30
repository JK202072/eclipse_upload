package com.hbsi.dao;


import com.hbsi.bean.DoPage;
import com.hbsi.bean.User;

public interface UserDao {
	//���巽����ѯ�û���¼��Ϣ�Ƿ����
	User lookUser(User user);
    //����û����Ƿ����
	boolean checkUsername(String username);
   //���û�ע����Ϣ��ӵ����ݿ���
	User addUser(User user);
	//���巽�����޸��û�����
	boolean updatePwd(User user);
	//���巽����ȡ�ܼ�¼��
	int doCount (DoPage dopage);
	//���巽����ȡ��ҳ��
	int doTotalPage(DoPage dopage);
	//���巽����ѯĳһҳҪ��ʾ������
	DoPage doFindAll(DoPage dopage);
	//ɾ���û�
	boolean deleteUser(int id);
	//����
	boolean disableUser(int id);
	//����
	boolean activeUser(int id);
	//�����û����δͨ��
	boolean invalid(int id);
    //����id��ѯ
	User lookUserById(int id);
	

}

package com.hbsi.dao;


import com.hbsi.bean.DoPage;
import com.hbsi.bean.User;

public interface UserDao {
	//定义方法查询用户登录信息是否存在
	User lookUser(User user);
    //检查用户名是否存在
	boolean checkUsername(String username);
   //将用户注册信息添加到数据库中
	User addUser(User user);
	//定义方法，修改用户密码
	boolean updatePwd(User user);
	//定义方法获取总记录数
	int doCount (DoPage dopage);
	//定义方法获取总页数
	int doTotalPage(DoPage dopage);
	//定义方法查询某一页要显示的数据
	DoPage doFindAll(DoPage dopage);
	//删除用户
	boolean deleteUser(int id);
	//禁用
	boolean disableUser(int id);
	//激活
	boolean activeUser(int id);
	//设置用户审核未通过
	boolean invalid(int id);
    //根据id查询
	User lookUserById(int id);
	

}

package cn.tedu.dao;

import java.util.Map;

import cn.tedu.entity.User;

public interface UserDao {

	/**
	 * �˽ӿ����ڷ���cn_user���е�����
	 */
	
	User findByName(String name);
	
	 void addUser(User user);
	 
	
}

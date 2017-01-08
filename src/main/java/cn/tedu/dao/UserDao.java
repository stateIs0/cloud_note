package cn.tedu.dao;

import java.util.Map;

import cn.tedu.entity.User;

public interface UserDao {

	/**
	 * 此接口用于访问cn_user表中的数据
	 */
	
	User findByName(String name);
	
	 void addUser(User user);
	 
	
}

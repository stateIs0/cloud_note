package cn.tedu.service;

import cn.tedu.entity.User;
import cn.tedu.exception.NameException;
import cn.tedu.exception.PasswordException;

public interface UserService {

	/**
	 * 此接口用来定义检查登录功能的方法
	 */
	
	User login(String name,String password)throws NameException,PasswordException;
	
	public User regist(String name,String password,String nick,String confirm)
			throws NameException,PasswordException;
	
}

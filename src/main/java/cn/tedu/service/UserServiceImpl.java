package cn.tedu.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.exception.NameException;
import cn.tedu.exception.PasswordException;
import cn.tedu.util.Util;

@Service("userService")
public  class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	public User login(String name, String password) throws NameException, PasswordException {
		if(name==null || name.trim().isEmpty()){
			throw new NameException("不能为空");
		}
		if(password==null || password.trim().isEmpty()){
			throw new PasswordException("不能为空");
		}
		User user=userDao.findByName(name);
		if(user==null){
			throw new NameException("用户不存在");
		}
		
		if(user.getPassword().equals(Util.getMd5(password))){
			return user;
		}
		new Object();
		
		throw new PasswordException("密码错误");
	}
	
	public User regist(String name,String password,String nick,String confirm)
	throws NameException,PasswordException{
		if(name==null || name.trim().isEmpty()){
			throw new NameException("不能是空");
		}
		if(password==null || password.trim().isEmpty()){
			throw new PasswordException("不能是空");
		}
		if(!password.equals(confirm)){
			throw new PasswordException("密码不一致");
		}
		User user=userDao.findByName(name);
		if(user!=null){
			throw new NameException("该用户已存在");
		}
		String id=UUID.randomUUID().toString();
		if(nick==null || nick.trim().isEmpty()){
			nick=name;
		}
		String token="";
		/**
		 * 使用加密技术
		 */
		String pwd=Util.getMd5(password);
		System.out.println(password);
		User user2=new User(id,name,pwd,token,nick);
		userDao.addUser(user2);
		return user2;
	}

}

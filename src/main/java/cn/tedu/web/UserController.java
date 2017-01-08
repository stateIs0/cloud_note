package cn.tedu.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.entity.User;
import cn.tedu.exception.NameException;
import cn.tedu.exception.PasswordException;
import cn.tedu.service.UserService;
import cn.tedu.util.ResultJson;

@Controller
@RequestMapping("user")
public class UserController extends AbstractController{

	@Resource
	private UserService userService;
	
	
	@RequestMapping("login.do")
	@ResponseBody
	public ResultJson login(String name,String password){
		System.out.println(name+","+password);
			User user=userService.login(name, password);
			return new ResultJson(user);
	
		
	}
	@ExceptionHandler(NameException.class)
	@ResponseBody
	public ResultJson nameexe(NameException e){
		e.printStackTrace();
		return new ResultJson("2",e);
	}
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public ResultJson passwordexe(PasswordException e){
		e.printStackTrace();
		return new ResultJson("3",e);
	
	}
	
	@RequestMapping("regist.do")
	@ResponseBody
	public ResultJson regist(String name,String password,String nick,String confirm){
		User user=userService.regist(name, password, nick, confirm);
		return new ResultJson(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

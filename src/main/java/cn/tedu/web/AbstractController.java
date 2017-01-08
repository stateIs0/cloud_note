package cn.tedu.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.util.ResultJson;

public class AbstractController {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResultJson exe(Exception e){
		e.printStackTrace();
		return new ResultJson(e);
		
	}
	
}

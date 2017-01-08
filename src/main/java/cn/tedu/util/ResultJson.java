package cn.tedu.util;

import java.io.Serializable;

public class ResultJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用来封装返回客户端的json结果.
	 */
	private String state;
	private String msg;
	private Object data;
	
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResultJson(String state, String msg, Object data) {
		super();
		this.state = state;
		this.msg = msg;
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return "ResultJson [state=" + state + ", msg=" + msg + ", data=" + data + "]";
	}
	

	public  static final  String SUCCESS="0";
	public static final String ERROR="1";
	
	public ResultJson(String state, Throwable e) {
		this.state = state;
		this.msg = e.getMessage();
		this.data = null;
	}
	public ResultJson(Object data) {
		this.state = SUCCESS;
		this.msg = null;
		this.data = data;
	}
	public ResultJson(Throwable e){
		this.state=ERROR;
		this.data=null;
		this.msg=e.getMessage();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


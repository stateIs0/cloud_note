package cn.tedu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.dao.NotebookDao;
import cn.tedu.exception.UserNotFoundException;

@Service("notebookService")
public class NotebookServiceImpl implements NotebookService {
	
	@Resource
	private NotebookDao notebookDao;
	
	public List<Map<String, Object>> list(String userId, int pageNum) throws UserNotFoundException {
		if(userId==null || userId.trim().isEmpty()){
			throw new UserNotFoundException("id不能是空");
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("tableName", "cn_notebook");
		param.put("userId", userId);
		int size=6;
		pageNum=pageNum*size; 
		
		param.put("start", pageNum);
		param.put("rows", size);
		List<Map<String,Object>>list=notebookDao.findByParam(param);
		if(list==null || list.isEmpty()){
			throw new UserNotFoundException("id不正确");
		}
		
		return list;
	}

}

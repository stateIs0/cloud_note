package cn.tedu.service;

import java.util.List;
import java.util.Map;

import cn.tedu.exception.UserNotFoundException;

public interface NotebookService {

	List<Map<String,Object>> list(String userId,int pageNum)throws UserNotFoundException;
}

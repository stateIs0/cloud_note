package cn.tedu.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.entity.NoteBook;
import cn.tedu.entity.User;

public interface NotebookDao {

	/**
	 * 笔记本Dao
	 */
	//查询
	List<Map<String,Object>> findByParam(Map<String,Object> param);
	//删除
	void deleteNotebook(NoteBook noteBook);
	//增加
	int addNotebook(NoteBook noteBook);
	
	
}


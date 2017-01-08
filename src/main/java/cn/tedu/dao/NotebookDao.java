package cn.tedu.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.entity.NoteBook;
import cn.tedu.entity.User;

public interface NotebookDao {

	/**
	 * �ʼǱ�Dao
	 */
	//��ѯ
	List<Map<String,Object>> findByParam(Map<String,Object> param);
	//ɾ��
	void deleteNotebook(NoteBook noteBook);
	//����
	int addNotebook(NoteBook noteBook);
	
	
}


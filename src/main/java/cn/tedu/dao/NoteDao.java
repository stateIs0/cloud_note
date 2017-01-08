package cn.tedu.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.entity.Note;

public interface NoteDao {

	List<Map<String,Object>> findByParam(Map<String,Object> param);
	
	int add(Note note);
	
	int delete(Note note);
	
	int update(Note note);
	
	Note findById(String noteId);
}

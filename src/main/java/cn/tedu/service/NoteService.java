package cn.tedu.service;

import java.util.List;
import java.util.Map;

import cn.tedu.entity.Note;
import cn.tedu.exception.NoteException;
import cn.tedu.exception.NotebookNotFoundException;

public interface NoteService {

	List<Map<String,Object>> listNote(String notebookId,int pageNum)throws NotebookNotFoundException;
	
	Note get(String noteId)throws NoteException;
	
	boolean updateNote(String noteId,String title,String body)throws NoteException;
	
	Note addNote(String userId,String notebookId,String title,String body)throws NoteException;
}

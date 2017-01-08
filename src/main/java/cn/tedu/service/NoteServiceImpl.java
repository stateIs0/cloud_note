package cn.tedu.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.dao.NoteDao;
import cn.tedu.dao.NotebookDao;
import cn.tedu.entity.Note;
import cn.tedu.exception.NoteException;
import cn.tedu.exception.NotebookNotFoundException;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Resource
	private NoteDao noteDao;
	@Resource
	private NotebookDao notebookDao;
	
	public List<Map<String, Object>> listNote(String notebookId, int pageNum) throws NotebookNotFoundException {
		if(notebookId==null || notebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("不能是空");
		}
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("tableName", "cn_note");
		param.put("notebookId",notebookId);
		int size=100;
		int start=pageNum*size;
		param.put("start", start);
		param.put("rows", size);
		List<Map<String,Object>>list=noteDao.findByParam(param);
//		if(list==null || list.isEmpty()){
//			throw new NotebookNotFoundException("id不存在或者没有这个id没有笔记");
//		}
		return list;
	}


	public Note get(String noteId) throws NoteException {
		
		if(noteId==null || noteId.trim().isEmpty()){
			throw new NotebookNotFoundException("noteId不能是空");
		}
		Note note=noteDao.findById(noteId);
		if(note==null){
			throw new NotebookNotFoundException("id不存在");
		}
		return note;
	}


	public boolean updateNote(String noteId, String title, String body) throws NoteException {
		Note note=noteDao.findById(noteId);
		if(note==null){
			throw new NoteException("id错误");
		}
		note.setId(noteId);
		note.setBody(body);
		note.setTitle(title);
		int i = noteDao.update(note);
		return i==1;
	}


	public Note addNote(String userId,String notebookId,String title, String body) throws NoteException {
		
		if(title==null || title.trim().isEmpty()){
			String reg="<p>[^<>]+</p>";
			Pattern p=Pattern.compile(reg);
			Matcher m=p.matcher(body);
			if(m.find()){
				String str=m.group();
				title=str.substring(3, str.length()>17?13:str.length()-4).trim();
				if(title.isEmpty()){
					title="无标题";
				}
			}
		}
		if(body==null){
			body="";
		}
		Note note=new Note();
		note.setBody(body);
		note.setTitle(title);
		note.setId(UUID.randomUUID().toString());
		note.setNotebookId(notebookId);
		note.setUserId(userId);
		note.setStatusId("");
		int i=noteDao.add(note);
		if(i!=1){
			throw new NotebookNotFoundException("保存失败");
		}
		return note;
	}

}

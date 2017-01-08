package cn.tedu.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.entity.Note;
import cn.tedu.service.NoteService;
import cn.tedu.util.ResultJson;

@Controller
@RequestMapping("note")
public class NoteController {
	
	@Resource
	private NoteService noteService;

	
	@RequestMapping("list.do")
	@ResponseBody
	public ResultJson list(String notebookId,int pageNum){
		List<Map<String,Object>> list=noteService.listNote(notebookId, pageNum);
		return new ResultJson(list);
	}
	
	@RequestMapping("get.do")
	@ResponseBody
	public ResultJson get(String noteId){
		Note note=noteService.get(noteId);
		return new ResultJson(note);
		
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public ResultJson save(String noteId,String title,String body){
		System.out.println(noteId+","+title+","+body);
		Boolean n=noteService.updateNote(noteId, title, body);
		return new ResultJson(n);
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public ResultJson add(String userId,String notebookId,String title,String body){
		Note note = noteService.addNote(userId, notebookId, title, body);
		return new ResultJson(note);
		
	}
}

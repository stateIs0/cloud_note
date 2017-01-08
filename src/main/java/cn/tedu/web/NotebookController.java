package cn.tedu.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.service.NotebookService;
import cn.tedu.util.ResultJson;

@Controller
@RequestMapping("notebook")
public class NotebookController extends AbstractController{

	@Resource
	private NotebookService notebookService;
	
	@RequestMapping("list.do")
	@ResponseBody
	public ResultJson list(String userId,int pageNum){
		System.out.println(userId+","+pageNum);
		System.out.println("notebook/list.do");
		List<Map<String,Object>> list=notebookService.list(userId, pageNum);
		return new ResultJson(list);
	}
	
}

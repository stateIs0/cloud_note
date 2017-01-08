package cloud_note;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.NoteDao;
import cn.tedu.dao.NotebookDao;
import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.service.NoteService;
import cn.tedu.service.NotebookService;
import cn.tedu.service.UserService;
import cn.tedu.util.ResultJson;
import cn.tedu.web.NoteController;
import cn.tedu.web.UserController;

public class Cloud_Note_Test {
	
	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init()	{
		ctx=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mybatis.xml");
		
	}
	
	@Test
	public void testUser(){
		System.out.println(ctx);
		UserDao dao=ctx.getBean("userDao",UserDao.class);
		//User u=dao.findByName("zhoujia");
		//System.out.println(u);
		dao.addUser(new User("111","111","111","111","1111"));
	}
	
	@Test
	public void testServcie(){
		UserService u=ctx.getBean("userService",UserService.class);
	//	System.out.println(u.login("zhoujia", "92538b3c4bcbabf7ab3fd502f0f8ab55"));
		u.regist("zhouj", "  ", "1", "111");
	}

	@Test
	public void testSservcie(){
		User c=new User("cxs",",",",",",",",");
		
		System.out.println(c);
		i(c);
		System.out.println(c);
		
	}
	
	public void i(User a){
		a.setId("id");
		
	}
	
	@Test
	public void reljfdlj(){
		UserController u=ctx.getBean("userController",UserController.class);
		System.out.println(u.regist("zhouia", "111", "","111"));
		
		
	}
	
	
	@Test
	public  void fljdlfjd(){
		NotebookDao dao=ctx.getBean("notebookDao",NotebookDao.class);
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("tableName", "cn_notebook");
		m.put("userId","52f9b276-38ee-447f-a3aa-0d54e7a736e4" );
		m.put("start", 1);
		m.put("rows", 6);
		List<Map<String,Object>> list=dao.findByParam(m);
		for(Map<String,Object> s:list){
			System.out.println(s);
		}
	}
	
	@Test
	public void fjdklfjdj(){
		NotebookService n=ctx.getBean("notebookService",NotebookService.class);
		List<Map<String,Object>> list =n.list("39295a3d-cc9b-42b4-b206-a2e7fab7e77c",1);
		for(Map<String,Object> m:list){
			System.out.println(m);
		}
	}
	
	@Test
	public void fldjlfdjl(){
		NoteDao n=ctx.getBean("noteDao",NoteDao.class);
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("tableName", "cn_note");
				m.put("notebookId", "6d763ac9-dca3-42d7-a2a7-a08053095c08");
				m.put("start", 1);
				m.put("rows", 10);
				List<Map<String,Object>> list=n.findByParam(m);
		for(Map<String,Object> u:list){
			System.out.println(u);
		}
	}
	
	@Test
	public void fjdlfd(){
		NoteService n=ctx.getBean("noteService",NoteService.class);
		List<Map<String,Object>>list =n.listNote("d0b0727f-a233-4a1f-8600-f49fc1f25bc9", 1);
		for(Map<String,Object> u:list){
			System.out.println(u);
		}
	}
	
	@Test
	public void fdljfldj(){
		NoteController n=ctx.getBean("noteController",NoteController.class);
		ResultJson r=n.list("d0b0727f-a233-4a1f-8600-f49fc1f25bc9", 1);
		System.out.println(r);
	}
	
	@Test
	public void fldjfldj(){
		NoteDao d=ctx.getBean("noteDao",NoteDao.class);
		System.out.println(d.findById("c347f832-e2b2-4cb7-af6f-6710241bcdf6"));
	}
	
	
	@Test
	public void fdljfdfldj(){
		NoteController n=ctx.getBean("noteController",NoteController.class);
		ResultJson r=n.save("77f61ff8-e7a1-43ac-9740-5d60b8b15b76", "fdjlf", "fjd;"	);
		System.out.println(r);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package org.tarena.note.service.test;

import org.junit.Test;
import org.tarena.note.service.UserService;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.SpringTest;

public class TestUserService extends SpringTest{

	@Test
	public void testcheckLogin(){
		UserService service = getContext().getBean(
			"userServiceImpl",UserService.class);
		NoteResult result = 
			service.checkLogin("scott", "1234");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
	
}

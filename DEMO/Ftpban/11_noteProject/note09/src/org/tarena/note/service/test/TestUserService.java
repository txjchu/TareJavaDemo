package org.tarena.note.service.test;

import junit.framework.Assert;

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
//		System.out.println(result.getStatus());
//		System.out.println(result.getMsg());
		//����
		Assert.assertEquals(1, result.getStatus());
		Assert.assertEquals("�û�������", result.getMsg());
	}
	
	@Test
	public void testcheckLogin1(){
		UserService service = getContext().getBean(
			"userServiceImpl",UserService.class);
		NoteResult result = 
			service.checkLogin("demo", "1234");
		//����
		Assert.assertEquals(2, result.getStatus());
		Assert.assertEquals("�������", result.getMsg());
	}
	
	@Test
	public void testcheckLogin2(){
		UserService service = getContext().getBean(
			"userServiceImpl",UserService.class);
		NoteResult result = 
			service.checkLogin("demo", "123456");
		//����
		Assert.assertEquals(0, result.getStatus());
		Assert.assertEquals("�û�����������ȷ", result.getMsg());
	}
	
}

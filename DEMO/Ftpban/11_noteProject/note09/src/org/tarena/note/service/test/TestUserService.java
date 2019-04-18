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
		//断言
		Assert.assertEquals(1, result.getStatus());
		Assert.assertEquals("用户不存在", result.getMsg());
	}
	
	@Test
	public void testcheckLogin1(){
		UserService service = getContext().getBean(
			"userServiceImpl",UserService.class);
		NoteResult result = 
			service.checkLogin("demo", "1234");
		//断言
		Assert.assertEquals(2, result.getStatus());
		Assert.assertEquals("密码错误", result.getMsg());
	}
	
	@Test
	public void testcheckLogin2(){
		UserService service = getContext().getBean(
			"userServiceImpl",UserService.class);
		NoteResult result = 
			service.checkLogin("demo", "123456");
		//断言
		Assert.assertEquals(0, result.getStatus());
		Assert.assertEquals("用户名和密码正确", result.getMsg());
	}
	
}

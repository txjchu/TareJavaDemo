package org.tarena.note.controller.user;

import org.junit.Test;
import org.tarena.note.util.SpringTest;

public class TestUserLoginController extends SpringTest{

	@Test
	public void test1(){
		UserLoginController controller = 
			getContext().getBean(
				"userLoginController",
				UserLoginController.class);
		
		System.out.println(
			controller.getClass().getName());
	}
	
}

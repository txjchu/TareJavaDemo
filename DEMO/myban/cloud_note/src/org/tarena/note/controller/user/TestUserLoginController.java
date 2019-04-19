package org.tarena.note.controller.user;

import org.junit.Test;
import org.tarena.note.util.SpringTest;

public class TestUserLoginController extends SpringTest {
	
	@Test
	public void test(){
		UserLoginController controller = 
			getContext().getBean("userLoginController",UserLoginController.class);
		System.out.println("");
	}
}

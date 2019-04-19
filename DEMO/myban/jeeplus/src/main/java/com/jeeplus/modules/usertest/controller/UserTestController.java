package com.jeeplus.modules.usertest.controller;

import org.springframework.stereotype.Controller;

import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.usertest.entity.UserTest;
import com.jeeplus.modules.usertest.service.UserTestService;

/**
 * userTest的控制层
 * @author Administrator
 *
 */
@Controller
public class UserTestController extends BaseController{
	
	public String testAC(UserTest userTest){
		UserTestService userTestService = new UserTestService();
		UserTest ut = userTestService.getUserTest(userTest);
		return ut.getName();
	}

}

package com.jeeplus.modules.usertest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeeplus.common.service.BaseService;
import com.jeeplus.modules.usertest.dao.UserTestDaoImpl;
import com.jeeplus.modules.usertest.entity.UserTest;

/**
 * UserTest的service组件
 * @author Administrator
 *
 */
@Service
public class UserTestService extends BaseService{
	
//	@Resource
	@Autowired
	private UserTestDaoImpl userTestDao;
	
	public UserTest getUserTest(UserTest userTest){
		UserTest ut = userTestDao.getUserTestByName(userTest);
		return ut;
	}

}

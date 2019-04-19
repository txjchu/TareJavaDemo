package com.jeeplus.modules.usertest.dao;

import java.util.List;

import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.usertest.entity.UserTest;

@MyBatisDao
public class UserTestDaoImpl implements UserTestDao{

	@Override
	public UserTest getUserTestByName(UserTest userTest) {
		
		return userTest;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UserTest entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByLogic(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByLogic(UserTest entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserTest> findAllList(UserTest entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTest> findAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTest> findList(UserTest entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTest findUniqueByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTest get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTest get(UserTest entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(UserTest entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserTest entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

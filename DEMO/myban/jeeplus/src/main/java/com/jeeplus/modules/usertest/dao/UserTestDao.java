package com.jeeplus.modules.usertest.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.usertest.entity.UserTest;

/**
 * UserTest的Dao组件
 * @author Administrator
 *
 */
@MyBatisDao
public interface UserTestDao extends CrudDao<UserTest>{
	public UserTest getUserTestByName(UserTest userTest);

}

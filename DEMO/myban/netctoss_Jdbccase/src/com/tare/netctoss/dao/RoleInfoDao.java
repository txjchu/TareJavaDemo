package com.tare.netctoss.dao;

import java.sql.SQLException;
import java.util.List;

import com.tare.netctoss.entity.RoleInfo;

/**
 * 职员表实体类的Dao接口，定义了增删改查的方法
 * @author Administrator
 *
 */

public interface RoleInfoDao  {
	
	/**
	 * 查：查出表中所有记录
	 * @return
	 */
	List<RoleInfo> findAll() throws SQLException;
		
	/**
	 * 增：向表中插入数据，数据为RoleInfo对象
	 * @param ri	要插入表中的RoleInfo对象
	 * @return		将插入后的对象返回
	 */
	RoleInfo save(RoleInfo ri) throws SQLException;
	
	/**
	 * 改：修改表中指定数据
	 * @param ri	指定的将要修改的记录对象
	 * @return		修改后的记录对象
	 */
	RoleInfo modify(RoleInfo ri) throws SQLException;
}

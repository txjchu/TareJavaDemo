package org.tarena.dao;

import org.tarena.entity.Admin;
import org.tarena.util.MyBatisDao;

/**
 * 和AdminMapper.xml中<mapper namespace="org.tarena.dao.AdminDao">对应
 * @author Administrator
 *
 */
@MyBatisDao
public interface AdminDao {
	public Admin findByCode(String adminCode);
	
	
	
}

package org.tarena.dao;

import org.tarena.entity.Admin;
import org.tarena.util.MyBatisDao;

/**
 * ��AdminMapper.xml��<mapper namespace="org.tarena.dao.AdminDao">��Ӧ
 * @author Administrator
 *
 */
@MyBatisDao
public interface AdminDao {
	public Admin findByCode(String adminCode);
	
	
	
}

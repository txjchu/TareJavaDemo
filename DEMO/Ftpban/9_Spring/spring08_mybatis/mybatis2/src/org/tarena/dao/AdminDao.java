package org.tarena.dao;

import org.tarena.entity.Admin;
//对应AdminMapper.xml SQL文件
public interface AdminDao {
	public Admin findByCode(String adminCode);
}

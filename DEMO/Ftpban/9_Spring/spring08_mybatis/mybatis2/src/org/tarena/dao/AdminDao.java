package org.tarena.dao;

import org.tarena.entity.Admin;
//��ӦAdminMapper.xml SQL�ļ�
public interface AdminDao {
	public Admin findByCode(String adminCode);
}

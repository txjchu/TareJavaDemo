package com.tare.netctoss.dao;

import java.sql.SQLException;
import java.util.List;

import com.tare.netctoss.entity.RoleInfo;

/**
 * ְԱ��ʵ�����Dao�ӿڣ���������ɾ�Ĳ�ķ���
 * @author Administrator
 *
 */

public interface RoleInfoDao  {
	
	/**
	 * �飺����������м�¼
	 * @return
	 */
	List<RoleInfo> findAll() throws SQLException;
		
	/**
	 * ��������в������ݣ�����ΪRoleInfo����
	 * @param ri	Ҫ������е�RoleInfo����
	 * @return		�������Ķ��󷵻�
	 */
	RoleInfo save(RoleInfo ri) throws SQLException;
	
	/**
	 * �ģ��޸ı���ָ������
	 * @param ri	ָ���Ľ�Ҫ�޸ĵļ�¼����
	 * @return		�޸ĺ�ļ�¼����
	 */
	RoleInfo modify(RoleInfo ri) throws SQLException;
}

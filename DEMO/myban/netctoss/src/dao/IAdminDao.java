package dao;

import entity.Admin;

public interface IAdminDao {
	/**
	 * �����˺Ų�ѯ����Ա
	 * @param adminCode �˺�
	 * @return ����Ա(���ص�ֵ�ǹ���Ա����)
	 */
	Admin findByCode(String adminCode);
	
	
}

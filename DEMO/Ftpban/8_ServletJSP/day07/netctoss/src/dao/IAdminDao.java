package dao;

import entity.Admin;

public interface IAdminDao {

	/**
	 * 根据账号查询管理员。
	 * @param adminCode 账号
	 * @return 管理员
	 */
	Admin findByCode(String adminCode);
	
}

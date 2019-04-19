package netctoss.dao;

import netctoss.entity.Admin;

/**
 * 管理员dao接口
 * @author Administrator
 *
 */
public interface AdminDAO {

	//登录模块-按照管理员账号查找记录
	Admin findByCode(String adminCode);
}

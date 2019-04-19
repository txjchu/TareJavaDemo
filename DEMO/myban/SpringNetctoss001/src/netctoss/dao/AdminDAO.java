package netctoss.dao;

import java.util.List;

import netctoss.entity.Admin;

/**
 * 管理员dao接口
 * @author Administrator
 *
 */
public interface AdminDAO {
	
	//登录模块--按照用户账号查询
	Admin findByCode(String adminCode);
	
	List<Admin> findAll();
}

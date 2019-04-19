package netctoss.dao;

import java.util.List;

import netctoss.entity.Admin;

/**
 * 用户表的操作DAO接口
 * @author Administrator
 *
 */
public interface LoginDAO {
	
	//根据管理员账号查管理员
	Admin findByCode(String code);
	List<Admin> findAll();
}

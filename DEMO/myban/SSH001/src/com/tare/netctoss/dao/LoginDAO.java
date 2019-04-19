package com.tare.netctoss.dao;

import java.util.List;

import com.tare.netctoss.entity.Admin;

/**
 * 实体类Admin对应的DAO接口
 * @author Administrator
 *
 */
public interface LoginDAO {
	
	Admin findByCode(String admin_code);
	
	List<Admin> findAll();
}

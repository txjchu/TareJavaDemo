package com.tare.netctoss.dao;

import java.util.List;

import com.tare.netctoss.entity.Admin;

/**
 * ʵ����Admin��Ӧ��DAO�ӿ�
 * @author Administrator
 *
 */
public interface LoginDAO {
	
	Admin findByCode(String admin_code);
	
	List<Admin> findAll();
}

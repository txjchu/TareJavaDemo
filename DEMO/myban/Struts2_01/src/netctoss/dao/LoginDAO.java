package netctoss.dao;

import java.util.List;

import netctoss.entity.Admin;

/**
 * �û���Ĳ���DAO�ӿ�
 * @author Administrator
 *
 */
public interface LoginDAO {
	
	//���ݹ���Ա�˺Ų����Ա
	Admin findByCode(String code);
	List<Admin> findAll();
}

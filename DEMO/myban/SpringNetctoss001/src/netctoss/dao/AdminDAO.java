package netctoss.dao;

import java.util.List;

import netctoss.entity.Admin;

/**
 * ����Աdao�ӿ�
 * @author Administrator
 *
 */
public interface AdminDAO {
	
	//��¼ģ��--�����û��˺Ų�ѯ
	Admin findByCode(String adminCode);
	
	List<Admin> findAll();
}

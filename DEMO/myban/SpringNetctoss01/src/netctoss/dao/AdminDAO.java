package netctoss.dao;

import netctoss.entity.Admin;

/**
 * ����Աdao�ӿ�
 * @author Administrator
 *
 */
public interface AdminDAO {

	//��¼ģ��-���չ���Ա�˺Ų��Ҽ�¼
	Admin findByCode(String adminCode);
}

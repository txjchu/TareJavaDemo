package com.tare.cloudnote.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tare.cloudnote.entity.User;

/**
 * �û��˺�DAO����ӿ�
 * @author Administrator
 *
 */
@Repository
public interface UserDAO {

	List<User> findAll();
	
	User findByName(String name);	//���˺Ų�ѯ�û���Ϣ����¼����
	
	int save(User user);	//�����û���ע�Ṧ��ʹ��
}

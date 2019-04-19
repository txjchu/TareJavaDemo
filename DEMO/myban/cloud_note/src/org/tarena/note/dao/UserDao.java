package org.tarena.note.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tarena.note.entity.User;
@Repository
public interface UserDao {
	
	public int save(User user);				//����������Ӱ���¼��
	public User findByName(String name);	//�飬
	
	public List<User> findAll();
}

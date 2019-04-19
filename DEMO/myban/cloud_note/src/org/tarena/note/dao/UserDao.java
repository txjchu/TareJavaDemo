package org.tarena.note.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tarena.note.entity.User;
@Repository
public interface UserDao {
	
	public int save(User user);				//增，返回受影响记录数
	public User findByName(String name);	//查，
	
	public List<User> findAll();
}

package com.tare.cloudnote.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tare.cloudnote.entity.User;

/**
 * 用户账号DAO组件接口
 * @author Administrator
 *
 */
@Repository
public interface UserDAO {

	List<User> findAll();
	
	User findByName(String name);	//按账号查询用户信息，登录功能
	
	int save(User user);	//保存用户，注册功能使用
}

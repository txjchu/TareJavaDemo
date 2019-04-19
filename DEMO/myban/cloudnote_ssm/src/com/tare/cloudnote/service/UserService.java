package com.tare.cloudnote.service;

import com.tare.cloudnote.entity.User;
import com.tare.cloudnote.util.NoteResult;

/**
 * 用户功能相关的service接口
 * @author Administrator
 *
 */
public interface UserService {

	public NoteResult checkLogin(String username, String password);//用户登录业务方法
	
	public NoteResult registUser(String username, String password, String nickname);//注册账号的业务
}

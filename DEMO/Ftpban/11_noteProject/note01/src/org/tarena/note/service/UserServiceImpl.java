package org.tarena.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.User;
import org.tarena.note.util.NoteResult;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	public NoteResult checkLogin(
		String username, String password) {
		NoteResult result = new NoteResult();
		//检测用户
		User user = userDao.findByName(username);
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户不存在");
//			result.setData(null);
			return result;
		}
		//检测密码
		if(!user.getCn_user_password().equals(password)){
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		return result;
	}

}

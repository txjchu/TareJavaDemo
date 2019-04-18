package org.tarena.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.User;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;

@Service
@Transactional
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
		//将用户收入的密码加密
		String md5_password = NoteUtil.md5(password);
		//将加密结果和数据表中的密文对比
		if(!user.getCn_user_password().equals(md5_password)){
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		result.setData(user.getCn_user_id());
		return result;
	}

	public NoteResult registUser(
			String username, 
			String password,
			String nickname) {
		NoteResult result = new NoteResult();
		//检测用户名是否注册
		User dbUser = userDao.findByName(username);
		if(dbUser != null){
			result.setStatus(1);
			result.setMsg("用户名已存在");
			return result;
		}
		//注册操作
		User user = new User();
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);//设置ID
		user.setCn_user_name(username);//设置用户名
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);//设置密码
		user.setCn_user_desc(nickname);//设置昵称
		user.setCn_user_token(null);//设置令牌
		userDao.save(user);//保存到cn_user表
		result.setStatus(0);
		result.setMsg("注册成功");
		
		//模拟一个异常
		String s = null;
		s.length();
		return result;
	}

}

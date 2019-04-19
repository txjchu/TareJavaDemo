package com.tare.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tare.cloudnote.dao.UserDAO;
import com.tare.cloudnote.entity.User;
import com.tare.cloudnote.util.NoteResult;
import com.tare.cloudnote.util.NoteUtil;

/**
 * UserService的实现类，定义其中方法的具体逻辑。
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDAO userDao;	//因为使用持久注解了userDAO的实现类，所以此处注入的是其实现类的对象。
	
	public NoteResult checkLogin(String username, String password) {
		NoteResult noteResult = new NoteResult();
		User user = userDao.findByName(username);
		if(user == null){//若按照输入的用户名查找不出记录
			noteResult.setStatus(1);
			noteResult.setMsg("账号不存在");
			return noteResult;//返回NoteResult对象，不需要返回其他Object类型的数据。
		} else if( !user.getCn_user_password().equals(NoteUtil.md5(password))){//判断密码是否正确，判断之前先晶用户输入的密码使用摘要算法再进行判断，因为数据库中存入的是加密后的密码。
			noteResult.setStatus(2);
			noteResult.setMsg("密码不正确");
			return noteResult;
		} else {
			noteResult.setStatus(0);
			noteResult.setMsg("登录成功！");
			noteResult.setData(user.getCn_user_id());//将用户的id存入返回对象中，返回以备后续使用。
			return noteResult;
		}
	}

	public NoteResult registUser(String username, String password, String nickname) {
		NoteResult result = new NoteResult();
		if(userDao.findByName(username) != null){
			result.setMsg("用户名已存在！");
			result.setStatus(1);//账号已存在的，注册不成功状态码
			return result;
		} else {
			User user = new User();
			user.setCn_user_id(NoteUtil.createId());
			user.setCn_user_name(username);
			user.setCn_user_password(NoteUtil.md5(password));
			user.setCn_user_token(null);
			user.setCn_user_desc(nickname);
			userDao.save(user);
			result.setMsg("注册成功！");
			result.setStatus(0);//注册成功的状态码
//			result.setData(user);
			return result;
		}
	}

	
}

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
		//����û�
		User user = userDao.findByName(username);
		if(user == null){
			result.setStatus(1);
			result.setMsg("�û�������");
//			result.setData(null);
			return result;
		}
		//�������
		if(!user.getCn_user_password().equals(password)){
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		result.setStatus(0);
		result.setMsg("�û�����������ȷ");
		return result;
	}

}

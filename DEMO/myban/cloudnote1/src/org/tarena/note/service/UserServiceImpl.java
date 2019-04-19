package org.tarena.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.User;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;

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
		//���û�������������
		String md5_password = NoteUtil.md5(password);
		//�����ܽ�������ݱ��е����ĶԱ�
		if(!user.getCn_user_password().equals(md5_password)){
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		result.setStatus(0);
		result.setMsg("�û�����������ȷ");
		return result;
	}

}

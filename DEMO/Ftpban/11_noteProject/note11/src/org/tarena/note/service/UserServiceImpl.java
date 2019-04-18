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
		result.setData(user.getCn_user_id());
		return result;
	}

	public NoteResult registUser(
			String username, 
			String password,
			String nickname) {
		NoteResult result = new NoteResult();
		//����û����Ƿ�ע��
		User dbUser = userDao.findByName(username);
		if(dbUser != null){
			result.setStatus(1);
			result.setMsg("�û����Ѵ���");
			return result;
		}
		//ע�����
		User user = new User();
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);//����ID
		user.setCn_user_name(username);//�����û���
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);//��������
		user.setCn_user_desc(nickname);//�����ǳ�
		user.setCn_user_token(null);//��������
		userDao.save(user);//���浽cn_user��
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		
		//ģ��һ���쳣
		String s = null;
		s.length();
		return result;
	}

}

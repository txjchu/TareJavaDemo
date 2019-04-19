package com.tare.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tare.cloudnote.dao.UserDAO;
import com.tare.cloudnote.entity.User;
import com.tare.cloudnote.util.NoteResult;
import com.tare.cloudnote.util.NoteUtil;

/**
 * UserService��ʵ���࣬�������з����ľ����߼���
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDAO userDao;	//��Ϊʹ�ó־�ע����userDAO��ʵ���࣬���Դ˴�ע�������ʵ����Ķ���
	
	public NoteResult checkLogin(String username, String password) {
		NoteResult noteResult = new NoteResult();
		User user = userDao.findByName(username);
		if(user == null){//������������û������Ҳ�����¼
			noteResult.setStatus(1);
			noteResult.setMsg("�˺Ų�����");
			return noteResult;//����NoteResult���󣬲���Ҫ��������Object���͵����ݡ�
		} else if( !user.getCn_user_password().equals(NoteUtil.md5(password))){//�ж������Ƿ���ȷ���ж�֮ǰ�Ⱦ��û����������ʹ��ժҪ�㷨�ٽ����жϣ���Ϊ���ݿ��д�����Ǽ��ܺ�����롣
			noteResult.setStatus(2);
			noteResult.setMsg("���벻��ȷ");
			return noteResult;
		} else {
			noteResult.setStatus(0);
			noteResult.setMsg("��¼�ɹ���");
			noteResult.setData(user.getCn_user_id());//���û���id���뷵�ض����У������Ա�����ʹ�á�
			return noteResult;
		}
	}

	public NoteResult registUser(String username, String password, String nickname) {
		NoteResult result = new NoteResult();
		if(userDao.findByName(username) != null){
			result.setMsg("�û����Ѵ��ڣ�");
			result.setStatus(1);//�˺��Ѵ��ڵģ�ע�᲻�ɹ�״̬��
			return result;
		} else {
			User user = new User();
			user.setCn_user_id(NoteUtil.createId());
			user.setCn_user_name(username);
			user.setCn_user_password(NoteUtil.md5(password));
			user.setCn_user_token(null);
			user.setCn_user_desc(nickname);
			userDao.save(user);
			result.setMsg("ע��ɹ���");
			result.setStatus(0);//ע��ɹ���״̬��
//			result.setData(user);
			return result;
		}
	}

	
}

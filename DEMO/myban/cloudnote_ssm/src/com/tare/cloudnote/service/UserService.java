package com.tare.cloudnote.service;

import com.tare.cloudnote.entity.User;
import com.tare.cloudnote.util.NoteResult;

/**
 * �û�������ص�service�ӿ�
 * @author Administrator
 *
 */
public interface UserService {

	public NoteResult checkLogin(String username, String password);//�û���¼ҵ�񷽷�
	
	public NoteResult registUser(String username, String password, String nickname);//ע���˺ŵ�ҵ��
}

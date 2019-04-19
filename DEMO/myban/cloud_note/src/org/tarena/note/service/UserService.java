package org.tarena.note.service;

import org.tarena.note.util.NoteResult;

public interface UserService {
	public NoteResult registUser(String username,String password,String nickname);		//×¢²áÕËºÅ----regist×¢²á nicknameêÇ³Æ
	public NoteResult checkLogin(String username,String password);						//µÇÂ¼ÕËºÅ
}

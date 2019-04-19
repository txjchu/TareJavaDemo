package org.tarena.note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.UserService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody			//��ע�����ڴ�����Ӧajax����ʱ��������ת��Ϊjson��ʽ�ַ�������������jspҳ�档
	public NoteResult execute(String username,String password){	//����NoteResult,������MVCתΪJSON������Ӧ���
		//����ҵ���������
		NoteResult result = userService.checkLogin(username, password);
		return result;
	}
}

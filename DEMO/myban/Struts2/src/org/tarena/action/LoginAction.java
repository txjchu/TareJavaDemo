package org.tarena.action;
/**
 * Struts2��
 * ��ν���������Ϣ����δ�����Ϣ
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	
	//�����������
	private String username;//��ҳ��<inpub type="text" >
	private String password;
	//��������
	private String msg;//---JSP��${msg}ȡ����ʾ
	
	public String execute(){		
		//��ȡ�������������Service��Dao����
		System.out.println(username+":"+password);
		if("scott".equals(username) && "123456".equals(password)){
			
			//��һ�֣�����Map�ṹ��ȡ��session
			ActionContext ctx = ActionContext.getContext();
			Map<String,Object> session = ctx.getSession();
			session.put("use", username);//�ȼ���session.setAttribute();
//			ctx.getApplication();  ���ص�Ҳ��session�ṹ��
//			ctx.get("request");
//			ctx.get("Application");
			
			//�ڶ��֣�����HttpSerletRequest
				//--����servlet��AOP
			HttpServletRequest httpRequest = ServletActionContext.getRequest();
			HttpSession httpSession = httpRequest.getSession();
			httpSession.setAttribute("user",username);
			
				
			
			return "success";
		}
		msg="��¼����";
		return "error";		
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

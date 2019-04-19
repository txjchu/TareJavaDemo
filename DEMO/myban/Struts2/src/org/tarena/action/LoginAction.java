package org.tarena.action;
/**
 * Struts2中
 * 如何接收请求信息，如何带出信息
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	
	//接收请求参数
	private String username;//跟页面<inpub type="text" >
	private String password;
	//传出参数
	private String msg;//---JSP用${msg}取出显示
	
	public String execute(){		
		//获取请求参数，调用Service，Dao处理
		System.out.println(username+":"+password);
		if("scott".equals(username) && "123456".equals(password)){
			
			//第一种：利用Map结构获取的session
			ActionContext ctx = ActionContext.getContext();
			Map<String,Object> session = ctx.getSession();
			session.put("use", username);//等价于session.setAttribute();
//			ctx.getApplication();  返回的也是session结构的
//			ctx.get("request");
//			ctx.get("Application");
			
			//第二种：利用HttpSerletRequest
				//--摆脱servlet的AOP
			HttpServletRequest httpRequest = ServletActionContext.getRequest();
			HttpSession httpSession = httpRequest.getSession();
			httpSession.setAttribute("user",username);
			
				
			
			return "success";
		}
		msg="登录错误";
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

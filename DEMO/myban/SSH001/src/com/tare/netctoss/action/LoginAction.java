package com.tare.netctoss.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ILoginDAO;
import com.tare.netctoss.entity.Admin;

/**
 * 处理去登录页面的请求逻辑，Action
 * 继承基础Action，用于使用session存取数据。
 * 取：取出验证码图片Action在其中存放的验证码
 * 存：登录完成后，将用户信息存入session，以备后续页面操作的登录验证，验证用户是否登录。 
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class LoginAction extends BaseAction{

	@Resource
	private ILoginDAO loginDao;
	
	//input
	private String adminCode;
	private String password;
	private String verifyCode;//接收用户输入的验证码
	//output
	private String errormsg;//向页面输出验证结果提示信息
	
	public String login(){
		//验证验证码是否输入正确
		String imageCode = (String) session.get("imageCode");//获取session中存储的验证码。
		System.out.println("-->loginAction:imageCode="+ imageCode);
		if(!imageCode.equalsIgnoreCase(verifyCode)){	//equalsIgnoreCase 忽略大小写
			errormsg = "验证码输入有误！请重新输入！";
			return "fail";
		}
		
		//验证账号和密码是否为空
		if("".equals(adminCode)){
			errormsg = "用户名为空！请输入用户名！";
			return "fail";
		} else if("".equals(password)){
			errormsg = "密码为空，请输入密码！";
			return "fail";
		}
		//验证账号和密码是否输入正确
		Admin admin = null; 
		try {
			admin = loginDao.findByCode(adminCode);
		} catch (Exception e) {
			e.printStackTrace();
			errormsg = "查询数据库异常了！";
			return "error";
		}
		if(admin == null || !password.equals(admin.getPassword())){
			errormsg = "账号不存在或密码不正确！请重新输入！";
		} else if(adminCode.equals(admin.getAdmin_code()) && password.equals(admin.getPassword())){
			session.put("admin", admin);//登录成功，将用户信息放入session中，以备后续的登录验证。
			return "success";
		}
		return "fail";
	}
	
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}

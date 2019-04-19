package netctoss.action;

import netctoss.dao.DAOFactory;
import netctoss.dao.LoginDAO;
import netctoss.entity.Admin;

/**
 * 登录 + 验证模块的Action
 * @author Administrator
 *
 */
public class LoginAction extends BaseAction{//继承Action基类，获取session
	//input
	private String adminCode;
	private String password;
	//output
	private String errormsg;//输出给页面的信息，提示登录验证结果
	//接收用户输入的验证码
	private String verifyCode;
	
	public String checkLogin(){
		//现验证用户输入的验证码是否正确
		String imageCode = (String) session.get("imageCode");
		System.out.println("LoginAction中获取到的验证码："+ imageCode);
		System.out.println("用户输入的验证码是："+ verifyCode);
		if(verifyCode == null || !imageCode.equalsIgnoreCase(verifyCode)){//使用确定字符串的equals方法，防止空指针异常。
			//验证码没有输入，或者与生成的验证码不匹配
			errormsg = "验证码输入有误！";
			return "fail";
		}
		if("".equals(adminCode)){
			errormsg = "用户名为空！请输入账号和密码！";
			return "fail";
		}
		LoginDAO loginDAO = DAOFactory.getLoginDAO();
		Admin admin = null;
		try {
			admin = loginDAO.findByCode(adminCode);
			System.out.println("LoginAction中调用DAO的方法获取到的admin:"+ admin);
		} catch (Exception e) {//若通过账号获取用户出异常
			e.printStackTrace();
			System.out.println("DAO获取用户信息出异常..");
			return "error";//跳转到异常界面
		}
		if(admin != null && adminCode.equals(admin.getAdminCode())){	// 若账号不等于空字符串。别忘了非!
			if(!password.equals("") && password.equals(admin.getPassword())){
				session.put("admin", admin);
				return "success";
			} else {
				errormsg = "密码不正确！！";
				return "fail";
			}
		} else {
			errormsg = "用户名不存在！！";
			return "fail";	// fail失败
		}
		
	}
	
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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
	
}

package netctoss.service;

import java.io.Serializable;

import javax.annotation.Resource;

import netctoss.dao.AdminDAO;
import netctoss.entity.Admin;
import netctoss.exception.AdminCodeException;
import netctoss.exception.PasswordException;

import org.springframework.stereotype.Service;
/**
 * 登录业务组件
 * @author Administrator
 *
 */
@Service
public class LoginService implements Serializable {
	
	@Resource	//依赖注入
	private AdminDAO adminDao;
	/*
	 * 检验账号密码是否输入错误
	 */
	public Admin checkAdminCodeAndPwd(String adminCode, String password)
								throws AdminCodeException, PasswordException {
		Admin admin = null;
			/*
			 * 异常分为两大类：
			 * 1.系统异常：比如数据库服务暂停，网络中断，系统异常发生后，程序无法恢复，只能通知用户稍后再试。
			 * 2.应用异常：由用户的问题产生的异常，比如输入错误的账号密码，应该提示用户进行正确的操作。
			 */
		
			admin = adminDao.findByCode(adminCode);
			if(admin == null){
				throw new AdminCodeException("账号不存在！");
			} else if(!admin.getPwd().equals(password)){
				throw new PasswordException("密码错误！");
			} else {
				return admin;
			}					
	}
}













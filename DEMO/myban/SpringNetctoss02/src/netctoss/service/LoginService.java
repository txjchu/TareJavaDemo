package netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import netctoss.dao.AdminMapper;
import netctoss.entity.Admin;
import netctoss.exception.AdminCodeException;
import netctoss.exception.PasswordException;
/**
 * 用户登录的业务层组件
 * @author Administrator
 *
 */
@Service("loginService")
public class LoginService {
	
	@Resource				//依赖注入一个AdminMapper映射器对象
	private AdminMapper mapper;
	
	public Admin login(String adminCode,String password)  {//----
		Admin admin = null;
		admin = mapper.findByAdminCode(adminCode);
			if(admin == null){
				/**
				 * 异常分为两大类：
				 * 1.系统异常：比如数据库服务暂停、网络中断，系统异常发生之后，程序无法恢复，只能通知用户稍后重试。
				 * 2.应用异常：因为用户的问题产生的异常，比如输入错误的账号密码，应该提示用户进行正确的操作。
				 */
				throw new AdminCodeException("账号输入有误！"); //----应用异常，因为用户输入错误等产生
			}
			if(!admin.getPwd().equals(password)){			//密码验证，别忘了“!”
				throw new PasswordException("密码错误！");
			}
		return admin;	
	}
}

package netctoss.service;

import java.io.Serializable;

import javax.annotation.Resource;

import netctoss.Exception.AdminCodeException;
import netctoss.Exception.PasswordException;
import netctoss.dao.AdminDAO;
import netctoss.dao.AdminDAOImpl;
import netctoss.entity.Admin;

import org.springframework.stereotype.Service;
/**
 * 登录模块的业务层组件
 * @author Administrator
 *
 */
@Service	//业务层组件
public class LoginService implements Serializable {
	@Resource	//依赖注入		使用Spring的DI依赖注入，实现IOC控制反转，降低组件的耦合度。
	private AdminDAO adminDao;
	
	//验证账号密码
	public Admin checkAdminCodeAndPwd(String adminCode, String password)
							throws AdminCodeException, PasswordException{

		Admin admin = adminDao.findByCode(adminCode);
//		System.out.println("service方法中输出："+ admin);
		if(admin == null){//按照用户输入的adminCode查询到的结果为空
			throw new AdminCodeException("账号输入错误！！");
		} else if(!admin.getPassword().equals(password)){//用户输入的密码与数据库中的密码不对应
			throw new PasswordException("密码输入错误！！");
		} else {
			return admin;
		}	
	}
}

package netctoss.service;

import javax.annotation.Resource;

import netctoss.dao.AdminDAO;
import netctoss.entity.Admin;

import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {
	private AdminDAO adminDAO;
	
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	@Resource(name="adminDAO")
	public void setAdminDAO(AdminDAO adminDAO) {
		System.out.println(
				"注入了adminDAO:" + adminDAO);
		this.adminDAO = adminDAO;
	}

	public Admin login(String adminCode,
			String password) throws Exception{
		Admin admin = null;
		try {
			admin = 
				adminDAO.findByAdminCode(
						adminCode);
			/*
			 * 异常分为两大类：
			 * 系统异常：比如数据库服务暂停，网络
			 * 		中断，系统异常发生之后，程序
			 * 		无法恢复，只能通知用户稍后重试。
			 * 应用异常: 用户的问题产生的异常，比如
			 * 		输入错误的帐号密码，应该提示用
			 * 		户进行正确的操作。
			 */
			if(admin == null){
				throw 
				new ApplicationException(
						"帐号不存在");
			}
			if(!admin.getPwd().equals(password)){
				throw 
				new ApplicationException(
						"密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return admin;
	}
}

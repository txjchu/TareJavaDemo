package netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import netctoss.dao.AdminDAO;
import netctoss.entity.Admin;
@Service("loginService")
public class LoginService {
	private AdminDAO adminDAO;
	
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}
	@Resource(name="adminDAO")
	public void setAdminDAO(AdminDAO adminDAO) {
		//通过依赖注入，给业务层LoginService注入一个对象
		System.out.println("注入了adminDAO:"+adminDAO);//----跟踪一下，是否注入成功。
		this.adminDAO = adminDAO;
	}

	public Admin login(String adminCode,String password) throws Exception {
		Admin admin = null;
		try {
			admin = adminDAO.findByAdminCode(adminCode);
			if(admin == null){
				/**
				 * 异常分为两大类：
				 * 1.系统异常：比如数据库服务暂停、网络中断，系统异常发生之后，程序无法恢复，只能通知用户稍后重试。
				 * 2.应用异常：因为用户的问题产生的异常，比如输入错误的账号密码，应该提示用户进行正确的操作。
				 */
				throw new ApplicationException("账号不存在"); //----应用异常，因为用户输入错误等产生
			}
			if(!admin.getPwd().equals(password)){			//密码验证，别忘了“!”
				throw new ApplicationException("密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return admin;	
	}
}

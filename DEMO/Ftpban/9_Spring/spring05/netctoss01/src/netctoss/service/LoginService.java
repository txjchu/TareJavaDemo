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
				"ע����adminDAO:" + adminDAO);
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
			 * �쳣��Ϊ�����ࣺ
			 * ϵͳ�쳣���������ݿ������ͣ������
			 * 		�жϣ�ϵͳ�쳣����֮�󣬳���
			 * 		�޷��ָ���ֻ��֪ͨ�û��Ժ����ԡ�
			 * Ӧ���쳣: �û�������������쳣������
			 * 		���������ʺ����룬Ӧ����ʾ��
			 * 		��������ȷ�Ĳ�����
			 */
			if(admin == null){
				throw 
				new ApplicationException(
						"�ʺŲ�����");
			}
			if(!admin.getPwd().equals(password)){
				throw 
				new ApplicationException(
						"�������");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return admin;
	}
}

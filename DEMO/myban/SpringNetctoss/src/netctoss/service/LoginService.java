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
		//ͨ������ע�룬��ҵ���LoginServiceע��һ������
		System.out.println("ע����adminDAO:"+adminDAO);//----����һ�£��Ƿ�ע��ɹ���
		this.adminDAO = adminDAO;
	}

	public Admin login(String adminCode,String password) throws Exception {
		Admin admin = null;
		try {
			admin = adminDAO.findByAdminCode(adminCode);
			if(admin == null){
				/**
				 * �쳣��Ϊ�����ࣺ
				 * 1.ϵͳ�쳣���������ݿ������ͣ�������жϣ�ϵͳ�쳣����֮�󣬳����޷��ָ���ֻ��֪ͨ�û��Ժ����ԡ�
				 * 2.Ӧ���쳣����Ϊ�û�������������쳣���������������˺����룬Ӧ����ʾ�û�������ȷ�Ĳ�����
				 */
				throw new ApplicationException("�˺Ų�����"); //----Ӧ���쳣����Ϊ�û��������Ȳ���
			}
			if(!admin.getPwd().equals(password)){			//������֤�������ˡ�!��
				throw new ApplicationException("�������");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return admin;	
	}
}

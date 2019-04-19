package netctoss.service;

import java.io.Serializable;

import javax.annotation.Resource;

import netctoss.dao.AdminDAO;
import netctoss.entity.Admin;
import netctoss.exception.AdminCodeException;
import netctoss.exception.PasswordException;

import org.springframework.stereotype.Service;
/**
 * ��¼ҵ�����
 * @author Administrator
 *
 */
@Service
public class LoginService implements Serializable {
	
	@Resource	//����ע��
	private AdminDAO adminDao;
	/*
	 * �����˺������Ƿ��������
	 */
	public Admin checkAdminCodeAndPwd(String adminCode, String password)
								throws AdminCodeException, PasswordException {
		Admin admin = null;
			/*
			 * �쳣��Ϊ�����ࣺ
			 * 1.ϵͳ�쳣���������ݿ������ͣ�������жϣ�ϵͳ�쳣�����󣬳����޷��ָ���ֻ��֪ͨ�û��Ժ����ԡ�
			 * 2.Ӧ���쳣�����û�������������쳣���������������˺����룬Ӧ����ʾ�û�������ȷ�Ĳ�����
			 */
		
			admin = adminDao.findByCode(adminCode);
			if(admin == null){
				throw new AdminCodeException("�˺Ų����ڣ�");
			} else if(!admin.getPwd().equals(password)){
				throw new PasswordException("�������");
			} else {
				return admin;
			}					
	}
}













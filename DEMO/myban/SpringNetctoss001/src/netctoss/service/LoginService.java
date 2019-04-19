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
 * ��¼ģ���ҵ������
 * @author Administrator
 *
 */
@Service	//ҵ������
public class LoginService implements Serializable {
	@Resource	//����ע��		ʹ��Spring��DI����ע�룬ʵ��IOC���Ʒ�ת�������������϶ȡ�
	private AdminDAO adminDao;
	
	//��֤�˺�����
	public Admin checkAdminCodeAndPwd(String adminCode, String password)
							throws AdminCodeException, PasswordException{

		Admin admin = adminDao.findByCode(adminCode);
//		System.out.println("service�����������"+ admin);
		if(admin == null){//�����û������adminCode��ѯ���Ľ��Ϊ��
			throw new AdminCodeException("�˺�������󣡣�");
		} else if(!admin.getPassword().equals(password)){//�û���������������ݿ��е����벻��Ӧ
			throw new PasswordException("����������󣡣�");
		} else {
			return admin;
		}	
	}
}

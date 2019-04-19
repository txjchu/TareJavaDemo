package netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import netctoss.dao.AdminMapper;
import netctoss.entity.Admin;
import netctoss.exception.AdminCodeException;
import netctoss.exception.PasswordException;
/**
 * �û���¼��ҵ������
 * @author Administrator
 *
 */
@Service("loginService")
public class LoginService {
	
	@Resource				//����ע��һ��AdminMapperӳ��������
	private AdminMapper mapper;
	
	public Admin login(String adminCode,String password)  {//----
		Admin admin = null;
		admin = mapper.findByAdminCode(adminCode);
			if(admin == null){
				/**
				 * �쳣��Ϊ�����ࣺ
				 * 1.ϵͳ�쳣���������ݿ������ͣ�������жϣ�ϵͳ�쳣����֮�󣬳����޷��ָ���ֻ��֪ͨ�û��Ժ����ԡ�
				 * 2.Ӧ���쳣����Ϊ�û�������������쳣���������������˺����룬Ӧ����ʾ�û�������ȷ�Ĳ�����
				 */
				throw new AdminCodeException("�˺���������"); //----Ӧ���쳣����Ϊ�û��������Ȳ���
			}
			if(!admin.getPwd().equals(password)){			//������֤�������ˡ�!��
				throw new PasswordException("�������");
			}
		return admin;	
	}
}

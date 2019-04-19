package test;

import java.util.Arrays;
import java.util.List;

import netctoss.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import dao.AccountDAO;
import dao.ServiceDAO;
import entity.Account;
import entity.Service;

/**
 * ����ServiceDAO
 * @author Administrator
 *
 */
public class TestServiceDAO {

	@Test
	public void testFindAll(){
		ServiceDAO dao = new ServiceDAO();
		List<Service> ss = dao.findAll();
		for(Service s : ss){
			System.out.println(s);
		}
	}
	@Test
	public void testFindById(){//����findById,����many-to-one�������Բ�ѯ
		ServiceDAO dao = new ServiceDAO();
		Service s = dao.findById(2001);
		System.out.println(s.getService_id() +","+ s.getUnix_host() +","+ s.getOs_username() +","+ s.getLogin_passwd());
		System.out.println("�Ƿ�ʹ�����ӳټ��أ��������ԵĲ�ѯ��Ĭ���ӳټ��ص�-----");//��findById()�����йر���session����ȥ���ʹ������ԣ��������쳣��no session or session close.
		Account a = s.getAccount();
		System.out.println(a);
	}
	@Test
	public void testFindByName(){//��������ѯ
		ServiceDAO dao = new ServiceDAO();
		List<Service> ss = dao.findByName("192.168.1.1");
		for(Service s : ss){
			System.out.println(s);
		}
	}
	@Test
	public void testSave(){
		//��ȡһ�������˺�
		AccountDAO aDao = new AccountDAO();
		Account a = aDao.findById(2028); //�÷����в��ܹر�session.���ر��������Ĳ�����Ӧ������ͬһ�����ݿ���ʶԻ�session�У�������session�ر��쳣��

		ServiceDAO dao = new ServiceDAO();
		Service s1 = new Service();
		s1.setAccount(a);
        s1.setOs_username("gg1");
        s1.setLogin_passwd("123");
        s1.setUnix_host("192.168.1.1");
        s1.setCost_id(5);
        s1.setStatus(0);
        dao.save(s1);
	}
	
	@Test
	public void testSomeColumn(){//��ѯ�����ֶ�
		Session session = HibernateUtil.getSession();
		String hql = "select service_id, unix_host, os_username, login_passwd " +
					"from Service where unix_host = ?";
		Query query = session.createQuery(hql);
		query.setString(0, "192.168.0.20");
		List<Object[]> ss = query.list();
		for(Object[] s : ss){
//			System.out.println(s);//[Ljava.lang.Object;@b1e7b5	�������s�������Object[]��������õ�ַ��
//			System.out.println(s[0] +","+ s[1] +","+ s[2] +","+ s[3]);
			System.out.println(Arrays.toString(s));//���������ַ�����ʽ�����
		}
	}
	
}

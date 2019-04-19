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
 * 测试ServiceDAO
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
	public void testFindById(){//测试findById,测试many-to-one关联属性查询
		ServiceDAO dao = new ServiceDAO();
		Service s = dao.findById(2001);
		System.out.println(s.getService_id() +","+ s.getUnix_host() +","+ s.getOs_username() +","+ s.getLogin_passwd());
		System.out.println("是否使用了延迟加载？关联属性的查询是默认延迟加载的-----");//当findById()方法中关闭了session后，再去访问关联属性，则会出现异常，no session or session close.
		Account a = s.getAccount();
		System.out.println(a);
	}
	@Test
	public void testFindByName(){//按条件查询
		ServiceDAO dao = new ServiceDAO();
		List<Service> ss = dao.findByName("192.168.1.1");
		for(Service s : ss){
			System.out.println(s);
		}
	}
	@Test
	public void testSave(){
		//获取一个账务账号
		AccountDAO aDao = new AccountDAO();
		Account a = aDao.findById(2028); //该方法中不能关闭session.若关闭了则后面的操作（应该是在同一个数据库访问对话session中）则会出现session关闭异常。

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
	public void testSomeColumn(){//查询部分字段
		Session session = HibernateUtil.getSession();
		String hql = "select service_id, unix_host, os_username, login_passwd " +
					"from Service where unix_host = ?";
		Query query = session.createQuery(hql);
		query.setString(0, "192.168.0.20");
		List<Object[]> ss = query.list();
		for(Object[] s : ss){
//			System.out.println(s);//[Ljava.lang.Object;@b1e7b5	输出的是s所代表的Object[]数组的引用地址。
//			System.out.println(s[0] +","+ s[1] +","+ s[2] +","+ s[3]);
			System.out.println(Arrays.toString(s));//将数组以字符串形式输出。
		}
	}
	
}

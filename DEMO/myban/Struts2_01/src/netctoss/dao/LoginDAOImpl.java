package netctoss.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import netctoss.entity.Admin;
import netctoss.util.HibernateUtil;

/**
 * �û�AdminDAO��ʵ����
 * @author Administrator
 *
 */
public class LoginDAOImpl implements LoginDAO{

	
	public List<Admin> findAll() {
		Session session = HibernateUtil.getSession();
		String hql = "from Admin";
		Query query = session.createQuery(hql);
		List<Admin> admins = query.list();	// infer �ƶ�����
		
		return admins;
	}

	public Admin findByCode(String code) {
        Admin admin = null;
        Session session = HibernateUtil.getSession();
        String hql = "from Admin where adminCode = ?";
        Query query = session.createQuery(hql);
        query.setString(0, code);
        Iterator<Admin> admins = query.list().iterator();
        if(admins.hasNext()){
        	admin = admins.next();
        }
        return admin;
	}

	
}

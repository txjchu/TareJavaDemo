package test;

import java.sql.Date;

import netctoss.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.Emp;

/**
 * ����Hibernate�ж��������״̬��
 * ��ʱ̬���־�̬��Persistent��������̬
 * @author Administrator
 *
 */
public class TestPersistent {
	
	@Test
	public void test1(){
//		Emp emp = (Emp) session.get(Emp.class, 3739);//ͨ��get��load��list��iterate������ȡ���Ķ����ǳ־�̬�ġ�
//		System.out.println("��ѯ����Emp:"+ emp);
		Emp emp = new Emp();
		emp.setEmpno(111);
		emp.setEname("ţħ��");
		emp.setJob("ɽ����");
		emp.setMgr(1);
		emp.setDeptno(10);
		emp.setSal(2222.22);
		emp.setComm(222.22);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();//����session���������
		try {
			session.save(emp);//save�����󣬶������ʱ̬ת��Ϊ�־�̬��
			tx.commit();
			session.clear();//���һ��һ�����棬�۲�û�гɹ������¼ʱ�����ݿ����Ƿ��м�¼���ٴβ�ѯʱ��һ��������û�м�¼�ܷ�����ݿ��в�ѯ����¼��
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������쳣��֧��û�����һ������");
			tx.rollback();
		} finally {
			Emp emp1 = (Emp) session.get(Emp.class, emp.getEmpno());
			System.out.println("������ٴβ�ѯemp���۲��Ƿ�Ϊ�־�̬�Ķ������һ�������У�"+ emp1);
			session.close();
		}
	}
	@Test
	public void test3(){
		Emp emp = new Emp();
		emp.setEmpno(111);
		emp.setEname("���ȹ������������������ȹ���������������");// ename��󳤶�Ϊ10��GBK����һ������3���ַ���
		emp.setJob("����");
		emp.setSal(2222.22);
		emp.setComm(222.22);
		emp.setMgr(3744);
		emp.setDeptno(10);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();//��������
		try {
			session.save(emp);//û���ύ����ʱ��������һ�������У����ڳ־�̬����ʱ�޸����ݺ����ύ���۲����޸ĺ�����ݡ�
			emp.setEname("�캢���Ӱ������������캢���Ӱ�����������");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();//Ϊʲô�����쳣���ܹ������¼�����������ô�������ã����������������ˡ����ݱ���û�в����ϱ�ṹԼ���ļ�¼��
			System.out.println("�������쳣��֧");
			tx.rollback();
		} finally {
//			session.clear();//���һ������
			session.evict(emp);//��һ���������Ƴ�����
			/*
			 * ���һ��������ٴβ�ѯ�ö��󣬹۲��Ƿ��޸ĳɹ�����Ȼ���Բ鵽������¼���Ҳ����Ǵ����ݱ��в鵽�ġ�
			 * ��Ϊ���ݱ���û�и�����¼����ô����������̬�ĸö��󱻷����������أ�
			 * �����ڴ���û�б�GC���գ�
			 */			
			Emp emp2 = (Emp) session.get(Emp.class, emp.getEmpno());
			System.out.println(emp);
			session.close();
		}
	}
	@Test
	public void test4(){
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();//��������
		Emp emp = (Emp) session.get(Emp.class, 3744);
		System.out.println(emp);
		emp.setEname("�Ʒ��");
		session.flush();//ֻ�Ǵ����˸��²�������û���ύ�����������ݱ��еļ�¼��û�иı䡣
		session.close();
	}
}

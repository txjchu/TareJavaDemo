package web.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import web.dao.EmpDAO;
import web.dao.SpringJdbcEmpDAO;
import web.entity.Emp;

/**
 * ������
 * @author Administrator
 *
 */
public class TestEmpDAO {

	/*
	 * �˴����Ա��봴��spring����������Ϊû��ͨ������������DispatcherServlet��û�д�spring������
	 * �����Ҫ�ֶ�����һ���������󣬲��ܻ�ȡ��ע���˳�Ա���Ե�dao��������Լ�newһ��dao����
	 * ��dao�е�Jdbctemplate������Ϊû������ע��������Ե�������query����ʱ����ֿ�ָ���쳣��
	 */
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	EmpDAO dao = ac.getBean("springJdbcEmpDAO", EmpDAO.class);
	
	@Test
	public void testFindAll(){
		List<Emp> list = dao.findAll();
		for(Emp e : list){
			System.out.println(e.getEmpno() +","+ e.getEname() +","+ e.getJob() +","+ e.getSal());
		}
	}
	@Test
	public void testFindByNo(){
		Emp emp = dao.findByNo(3724);
		System.out.println(emp);
	}
	@Test
	public void testSave(){
		Emp e = new Emp();
		e.setEname("�����");			//������empnoΪ3724
        e.setJob("SALESMAN");
        e.setMgr(3);
        e.setHiredate(new Date(System.currentTimeMillis()));
        e.setSal(3000.0);
        e.setDeptno(30);
        dao.save(e);
	}
	@Test
	public void testUpdate(){
		Emp emp = new Emp();
		emp.setEmpno(3724);
		emp.setEname("��ɮ");
		emp.setJob("manager");
		emp.setMgr(10);
		emp.setHiredate(new Date(System.currentTimeMillis()));//��ȡ��ǰϵͳʱ��
		emp.setSal(6000.0);
		emp.setComm(2000.22);
		emp.setDeptno(1);
		
		Emp e = dao.findByNo(emp.getEmpno());
		System.out.println("-----------�޸�ǰ������--------------");
		System.out.println(e);
		dao.update(emp);
		System.out.println("-----------�޸ĺ������--------------");
		System.out.println(dao.findByNo(emp.getEmpno()));
	}
}

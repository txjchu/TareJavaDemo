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
 * 测试类
 * @author Administrator
 *
 */
public class TestEmpDAO {

	/*
	 * 此处测试必须创建spring容器对象，因为没有通过浏览器请求打开DispatcherServlet，没有打开spring容器，
	 * 因此需要手动开启一个容器对象，才能获取到注入了成员属性的dao对象。如果自己new一个dao对象，
	 * 则dao中的Jdbctemplate对象因为没有容器注入对象，所以当调用其query方法时会出现空指针异常。
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
		e.setEname("孙悟空");			//插入后的empno为3724
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
		emp.setEname("唐僧");
		emp.setJob("manager");
		emp.setMgr(10);
		emp.setHiredate(new Date(System.currentTimeMillis()));//获取当前系统时间
		emp.setSal(6000.0);
		emp.setComm(2000.22);
		emp.setDeptno(1);
		
		Emp e = dao.findByNo(emp.getEmpno());
		System.out.println("-----------修改前的数据--------------");
		System.out.println(e);
		dao.update(emp);
		System.out.println("-----------修改后的数据--------------");
		System.out.println(dao.findByNo(emp.getEmpno()));
	}
}

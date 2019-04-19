package web.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import web.dao.EmpMapper;
import web.entity.Emp;

/**
 * ����EmpMapper
 * @author Administrator
 *
 */
public class TestEmpMapper {

	EmpMapper mapper = null;
	@Before
	public void test1(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		mapper = ac.getBean("empMapper", EmpMapper.class);//������ͨ��ɨ��ע�⣬�Զ�ע������һ��empMapper��bean����
	}
	@Test
	public void testFindAll(){
		List<Emp> emps = mapper.findAllEmp();
		for(Emp emp : emps){
			System.out.println(emp);
		}
	}
	@Test
	public void testFindById(){
		Emp emp = mapper.findById(3731);
		System.out.println(emp);
	}
	@Test
	public void testUpdate(){
		Emp emp = mapper.findById(3731);
		emp.setEname("�����");
		emp.setJob("�����");
		mapper.update(emp);
		System.out.println(mapper.findById(3731));
	}
	@Test
	public void testDelete(){
		mapper.delete(3731);
	}
}

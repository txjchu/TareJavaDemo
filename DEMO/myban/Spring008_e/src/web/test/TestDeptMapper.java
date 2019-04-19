package web.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import web.dao.DeptMapper;
import web.entity.Dept;

/**
 * ≤‚ ‘¿‡£∫≤‚ ‘DeptMapper «∑Ò≈‰÷√≥…π¶
 * @author Administrator
 *
 */
public class TestDeptMapper {
	
	DeptMapper mapper = null;
	@Before
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		mapper = ac.getBean("deptMapper", DeptMapper.class);
	}
	@Test
	public void testFindAll(){
		List<Dept> depts = mapper.findAllDept();
		for(Dept dept : depts){
			System.out.println(dept);
		}
	}
}

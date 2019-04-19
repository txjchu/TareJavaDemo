package org.tare.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tare.dao.EmpMapper;
import org.tare.entity.Emp;

/**
 * 测试
 * @author Administrator
 *
 */
public class TestEmpMapper {
	
	@Test
	public void testFindAll(){
		/*
		 * java.lang.NoClassDefFoundError:org/springframework/aop/support/AopUtils
		 * 
		 * 当MapperScannerConfigurer中指定了annotitionClass属性后，扫描器之会扫描带了指定注解的Mapper,
		 * 因此，EmpMapper没有被扫描后注册，所以再次产生异常。
		 * org.springframework.beans.factory.NoSuchBeanDefinitionException:No bean named 'empMapper' is defined 有定义的明确的
		 */	
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);//创建容器
		EmpMapper mapper = ac.getBean("empMapper", EmpMapper.class);
		List<Emp> emps = mapper.findAll();
		for(Emp emp : emps){
			System.out.println(emp);
		}
		
	}
}

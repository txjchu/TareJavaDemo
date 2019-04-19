package org.tare.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tare.dao.EmpMapper;
import org.tare.entity.Emp;

/**
 * ����
 * @author Administrator
 *
 */
public class TestEmpMapper {
	
	@Test
	public void testFindAll(){
		/*
		 * java.lang.NoClassDefFoundError:org/springframework/aop/support/AopUtils
		 * 
		 * ��MapperScannerConfigurer��ָ����annotitionClass���Ժ�ɨ����֮��ɨ�����ָ��ע���Mapper,
		 * ��ˣ�EmpMapperû�б�ɨ���ע�ᣬ�����ٴβ����쳣��
		 * org.springframework.beans.factory.NoSuchBeanDefinitionException:No bean named 'empMapper' is defined �ж������ȷ��
		 */	
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);//��������
		EmpMapper mapper = ac.getBean("empMapper", EmpMapper.class);
		List<Emp> emps = mapper.findAll();
		for(Emp emp : emps){
			System.out.println(emp);
		}
		
	}
}

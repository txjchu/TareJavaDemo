package test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import factory.Student;

/**
 * ���Դ���ApplicationContext����
 * @author Administrator
 *
 */
public class testCase {
	
	/*
	 * ʵ��������
	 */
	@Test
	public void test1(){
		//����ʱ��·��һ��Ҫ��ȷ��xml�ļ���·��ɨ���Ǵ�src�ļ��¿�ʼ�ġ����ڰ����棬��·��Ӧ�ü��ϰ���/��
		String config = "test/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		System.out.println(ac);
	}
	
	/*
	 * bean��ʵ����������������̬������������̬��������
	 */
	@Test
	public void test3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		Calendar cal1 = (Calendar) ac.getBean("obj");
		System.out.println(cal1);
		
		Calendar cal2 = (Calendar) ac.getBean("obj1");
		System.out.println(cal2);
		
		Date obj3 = (Date) ac.getBean("obj3");
		System.out.println(obj3);
	}
	/*
	 * bean��������
	 * Ĭ��singleton����ģʽ�����ܻ�ȡ���ٴΣ���ȡ��beanֻҪ��ʶ��һ�£�����ͬһ������
	 * prototype����ģʽ����ÿһ�λ�ȡ��bean������һ���µ�bean����
	 */
	@Test
	public void test4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		Calendar cal1 = (Calendar) ac.getBean("obj4");
		Calendar cal2 = (Calendar) ac.getBean("obj4");
		System.out.println(cal1 == cal2);		//true	����ģʽ	false	����ģʽ
		System.out.println(cal1.equals(cal2));	//true	����ģʽ	true	����ģʽ
	}
	/*
	 * bean���������ڻص�
	 * 
	 */
	@Test
	public void test5(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		System.out.println("--------�ָ��ߣ������Ѿ����������趨���ӳ�ʵ���������ʱbean��δʵ������----------");
		ExampleBean b1 = (ExampleBean) ac.getBean("exampleBean");
		System.out.println(b1);
		b1.execute();//ִ������bean�е�ִ�з���
		ac.close();
	}
	/*
	 * bean��:ͨ��setter��ʽע��
	 */
	@Test
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		Computer computer = ac.getBean("computer", Computer.class);
		System.out.println(computer);
	}
	/*
	 * ������ע��
	 */
	@Test
	public void test6(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		MobilePhone mp = ac.getBean("mobilePhone", MobilePhone.class);
		System.out.println(mp);
	}
	/*
	 * �Զ�װ�ؾ���������ϵ��bean
	 */
	@Test
	public void test7(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("test/applicationContext.xml");
		Student s = ac.getBean("student", Student.class);
		System.out.println(s);
	}
	
	
}











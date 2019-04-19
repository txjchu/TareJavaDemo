package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StudentDAO;
import entity.Student;

public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDAO dao = ac.getBean("studentDAO",StudentDAO.class);
		Student stu = new Student();
		stu.setName("huahua");
		stu.setAge(22);
		dao.save(stu);
	}
	@Test
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDAO dao = ac.getBean("studentDAO",StudentDAO.class);
		Student s = dao.findById(1);
		System.out.println(s);
	}
	@Test
	public void test3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDAO dao = ac.getBean("studentDAO",StudentDAO.class);
		List<Student> stus = dao.findAll();
		System.out.println(stus);
	}
	@Test
	public void test4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDAO dao = ac.getBean("studentDAO",StudentDAO.class);
		Student s = dao.findById(1);
		s.setAge(s.getAge()*2);
		dao.modify(s);
	}	
	@Test
	public void test5(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDAO dao = ac.getBean("studentDAO",StudentDAO.class);
		Student s = dao.findById(1);
		dao.delete(1);
	}
}

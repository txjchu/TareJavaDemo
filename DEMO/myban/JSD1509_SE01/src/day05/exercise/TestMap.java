package day05.exercise;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * ����2		����Emp
 * @author Administrator
 *
 */
public class TestMap {
	Map<Emp, String> emps = new HashMap<Emp, String>();//����map����
	
	@Before
	//@Beforeע�⣬��JUnit�и�ע���ʾÿ�����Է�����@Test���εķ�����ִ��ʱ����ִ��һ���������η������������ݵĳ�ʼ����
//	@Test
	public void testPut(){
		//��map�����Ԫ��
		emps.put((new Emp("����", 22, "��", 4000)), "����");
		emps.put((new Emp("����", 23, "Ů", 5000)), "����");
		System.out.println(emps);
	}
	
	@Test
	public void testGet(){
		Emp zhangsan = new Emp("����", 22, "��", 4000);
		String name = emps.get(zhangsan);
		System.out.println(name);
	}
	
	@Test
	public void testContainsKey(){
		Emp lisi = new Emp("����", 23, "Ů", 5000);
		boolean flag = emps.containsKey(lisi);
		System.out.println("�����Ƿ������emps�У�"+ flag);
	}
}

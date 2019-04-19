package day02.homeWork;

import org.junit.Test;

/** ����Emp�� */
public class testEmp {
	
	Emp emp1 = new Emp("����", 22, "��", 3333);
	@Test
	//���Դ�ӡ��Ϣ����
	public void testPaintInfo(){
		emp1.paintInfo();
	}
	
	@Test
	//����toString����
	public void testToString(){
		String str = emp1.toString();
		System.out.println(str);//����,22,��,3333.0
	}
	
	@Test
	//����equals()����
	public void testEquals(){
		Emp emp2 = new Emp("����", 23, "Ů", 2222);
		Emp emp3 = new Emp("����", 24, "Ů", 5555);
		System.out.println(emp2.equals(emp1));//false
		System.out.println(emp3.equals(emp1));//true
	}
}

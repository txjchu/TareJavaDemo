package day02.homeWork;

import org.junit.Test;

/** 测试Emp类 */
public class testEmp {
	
	Emp emp1 = new Emp("张三", 22, "男", 3333);
	@Test
	//测试打印信息方法
	public void testPaintInfo(){
		emp1.paintInfo();
	}
	
	@Test
	//测试toString方法
	public void testToString(){
		String str = emp1.toString();
		System.out.println(str);//张三,22,男,3333.0
	}
	
	@Test
	//测试equals()方法
	public void testEquals(){
		Emp emp2 = new Emp("李四", 23, "女", 2222);
		Emp emp3 = new Emp("张三", 24, "女", 5555);
		System.out.println(emp2.equals(emp1));//false
		System.out.println(emp3.equals(emp1));//true
	}
}

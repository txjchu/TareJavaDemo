package a02;
/**
 * day01_c01_Emp 
 * @author Administrator
 *
 */
public class Emp {
	String name;//姓名
	int age;//年龄
	char gender;//性别
	double salary;//工资
	public void printInfo(Emp emp){//打印员工信息的方法
		System.out.println("--------------");
		System.out.println("姓名："+ emp.name);
		System.out.println("年龄："+ emp.age);
		System.out.println("性别："+ emp.gender);
		System.out.println("工资："+ emp.salary);
	}
}

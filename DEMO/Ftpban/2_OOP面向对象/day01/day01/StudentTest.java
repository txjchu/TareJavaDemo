package oo.day01;
//学生类测试类
public class StudentTest {
	public static void main(String[] args) {
		Student zs = new Student(); //创建一个学生对象
		zs.name = "zhangsan";
		zs.age = 25;
		zs.address = "河北廊坊";
		zs.study();
		zs.sayHi();
		
		Student ls = new Student();
		ls.name = "lisi";
		ls.age = 18;
		ls.address = "黑龙江佳木斯";
		ls.study();
		ls.sayHi();
		
		Student ww = new Student();
		ww.study();
		ww.sayHi(); //默认初始化
		
	}
}











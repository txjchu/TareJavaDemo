package day06;
//方法的演示
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		
		//sayHi(); //编译错误，有参则必须传参
		//sayHi(250); //编译错误，参数类型必须匹配
		//sayHi("zhangsan"); //String name="zhangsan"
		//sayHi("lisi"); //String name="lisi"
		//sayHi("wangwu"); //String name="wangwu"
		
		//int num = getNum(); //getNum()的值就是return后的250
		//System.out.println(num);
		
		//double a = plus(5.5,6.6); //double num1=5.5,double num2=6.6
		//System.out.println(a);
		
		//变量是一个代词，代表的是它里面存的那个数
		//double a = 5.5;
		//double b = 6.6;
		//double c = plus(a,b); //double num1=5.5,double num2=6.6
		//System.out.println(c);
		
		//方法的嵌套调用(方法中调方法)
		a();//222,444,333,111,
		
		System.out.println("over");
	}
	
	public static void a(){
		b();
		System.out.println(111);
	}
	public static void b(){
		System.out.println(222);
		c();
		System.out.println(333);
	}
	public static void c(){
		System.out.println(444);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//有参有返回值
	public static double plus(double num1,double num2){
		//double num=num1+num2;
		//return num;
		return num1+num2;
	}
	
	//无参有返回值
	public static int getNum(){
		//return; //编译错误，必须返回一个值
		//return 25.6; //编译错误，返回值类型必须匹配
		return 250; //1.结束方法的执行  2.返回结果给调用方
	}
	
	//有参无返回值
	public static void sayHi(String name){
		System.out.println("大家好，我叫"+name);
		return; //1.结束方法的执行
	}
	
	//无参无返回值
	public static void say(){
		System.out.println("大家好，我叫WKJ");
	}
	
}













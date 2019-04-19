package day06;
//方法的演示	
public class MethodDemo {
	public static void main(String[] args) {
		say();
	
		System.out.println("over");
	}
	
	//方法的嵌套，方法中调用方法
	
	//有参数有返回值
	public static double plus(double num1,double num2){
		double num=num1+num2;
		return num;
	}
	
	//方法有返回值的，调用的时候必须声明一个变量，接收参数
	//无参数有返回值
	public static double getNum(){
		//return;//编译错误，必须反回一个值
		//return "abc";
		return 25.6;//编译错误，返回值类型必须相符  //1.结束方法的执行 2.返回结果给调用方
		//return 25;
	}
	
	//有参数无返回值
	public static void sayHi(String name){
		
	}
	
	//无参数无返回值
	public static void say(){
		System.out.println("大家好，我叫WKJ");
	}
}

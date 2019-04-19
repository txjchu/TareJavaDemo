package day03;
/**
 * 抛出异常
 * throw关键字可以主动抛出一个异常的实例
 * 通常有两种情况我们会主动向方法外抛出一个异常：
 * 1.当前代码不负责异常处理(责任制问题，通知调用者出错了)
 * 2.出现了一个满足语法要求，但是不满足业务逻辑要求时。
 * @author Administrator
 *
 */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		Person p=new Person();
		try {
			/*
			 * 当调用一个含有throws声明抛出检查异常的方法时，编译器在编译代码过程中
			 * 会检查我们调用该方法时是否有处理异常的手段，处理手段有两种：
			 * 1.使用try-catch 捕获并处理该异常，
			 * 2.在当前方法上继续使用throws抛出该异常。
			 * 
			 */
			
			p.setAge(291);
		} catch (IllegalAgeException e) {
		
			e.printStackTrace();
		}
		System.out.println("年龄是："+p.getAge());
		
		
		
		
	}
	
	
}

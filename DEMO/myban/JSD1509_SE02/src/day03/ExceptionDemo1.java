package day03;
/**
 * java异常捕获机制中try-cath
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		
		System.out.println("程序开始啦！");

		try{					//-----	try
		
		String str="a223";
		/*
		 * 当虚拟机运行中发现异常时，会创建一个该类异常的实例来表示该错误，
		 * 然后将代码的执行过程全部封装到该错误中，并将异常抛出。
		 */
		System.out.println(str.length());
		
		System.out.println(str.charAt(0));
		
		System.out.println(Integer.parseInt(str));
		
//		程序开始啦！
//		Exception in thread "main" java.lang.NullPointerException
//			at day03.ExceptionDemo1.main(ExceptionDemo1.java:12)
		}catch(NullPointerException e){				//捕获异常
			System.out.println("出现了一个空指针！");		//有异常的解决的方法
		
		
		//catch 可以写多个，来分别捕获不同异常并做处理
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("字符串下标越界了！");
		
		
		/*
		 * 应当养成一个良好的习惯，就是在最后一个catch上去捕获Exception,
		 * 这样至少不会因为出现一个未补获的异常而导致程序终端。
		 * catch 捕获异常的顺序：
		 * 若捕获的不同异常之间没有继承关系，谁在上面都可以。
		 * 但是若有继承关系的异常之间，一定是子类异常线性捕获，然后再捕获父类异常。
		 */
		}catch(Exception e){
			System.out.println("反正就是有个错误，但是程序还是能进行下去了！");
		}
		
		
		System.out.println("程序结束啦！");
	}
}

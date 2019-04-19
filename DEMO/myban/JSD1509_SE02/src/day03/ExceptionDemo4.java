package day03;
/**
 * Exception常用API
 * @author Administrator
 *
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		try {
			String str="";
			System.out.println(str.charAt(0));
		} catch (StringIndexOutOfBoundsException e) {
			/*
			 * 输出该错误的堆栈信息
			 * 就是输出程序执行到出错代码的整个过程，有助于快速定位出错的代码所在行，
			 * 以便于调整代码。
			 */
			
			e.printStackTrace();//-------第一个方法
			
			String message = e.getMessage();//------第二个语法
			System.out.println(message);
			
		}
		
		
		
		
		
	}
}

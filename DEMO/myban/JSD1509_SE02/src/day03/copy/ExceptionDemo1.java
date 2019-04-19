package day03.copy;
/**
 * java异常捕获机制中的try-catch
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("程序开始！");
		try{
			String str = "a";
			/*
			 * 当虚拟机运行中发现异常时，会创建一个该类异常的实例来表示该错误，然后将代码的执行过程全部封装到该错误中，
			 * 并将异常抛出。
			 */
			System.out.println(str.charAt(4));
			System.out.println(str.length());
			System.out.println(Integer.parseInt(str));
			
		}catch(NullPointerException e){
			System.out.println("出现一个空指针异常！");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("字符串下标越界了！");
			/*
			 * 应该养成一个良好的习惯，就是在最后一个catch上去捕获Exception，这样至少不会因为出现一个未捕获的异常
			 * 而导致程序中断。
			 * catch捕获异常的顺序：
			 * 若捕获的不同异常之间没有继承关系，谁在上面都可以，但若有继承关系的异常之间，一定是子类异常先行捕获，
			 * 然后再捕获父类异常。
			 */
		}catch(Exception e){
			/*
			 * -----若出现上面未捕获的异常，则最终捕获顶级父类异常Exception。
			 * 
			 * 若捕获了一个异常，则不会再捕获其他异常？？？ 并且异常语句后面的代码都不再执行。
			 */
			System.out.println("反正就是出了个错！");
		}
		System.out.println("程序结束了!");
	}
}
















package day03;
/**
 * java异常捕获机制中的try-cath
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("程序开始了!");
		
		try{
			String str = "a";
			/*
			 * 当虚拟机运行中发现异常时，会创建一个
			 * 该类异常的实例来表示该错误，然后将
			 * 代码的执行过程全部封装到该错误中，并将
			 * 异常抛出。
			 */
			System.out.println(str.length());
			
			System.out.println(str.charAt(0));
			
			System.out.println(Integer.parseInt(str));
		}catch(NullPointerException e){
			System.out.println("出现了一个空指针!");
			
		//catch可以写多个，来分别捕获不同异常并做处理
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("字符串下标越界了!");
		
		/*
		 * 应当养成一个良好的习惯，就是在最后一个catch
		 * 上去捕获Exception,这样至少不会因为出现一个
		 * 未捕获的异常而导致程序中断。
		 * catch捕获异常的顺序:
		 * 若捕获的不同异常之间没有继承关系，谁在上都可以。
		 * 但是若有继承关系的异常之间，一定是子类异常先行
		 * 捕获，然后再捕获父类异常。	
		 */
		}catch(Exception e){
			System.out.println("反正就是出了个错");
		}
		
		
		System.out.println("程序结束了!");
	}
}







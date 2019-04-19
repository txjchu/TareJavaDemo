package day03.copy;
/**
 * Exception的API
 * void  printStackTrace()	输出异常事件发生时的执行堆栈的信息
 * String  getMessage()		得到有关异常事件的信息
 * Throwable  getCause()	获取异常出现的原因 
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		try{
			String str = "";
			System.out.println(str.charAt(0));
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			
		}
	}
}

















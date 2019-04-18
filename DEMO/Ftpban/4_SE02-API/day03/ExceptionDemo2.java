package day03;
/**
 * finally块
 * finally块只能定义在异常捕获机制的最后:
 * 最后一个catch之后。或者直接跟在try之后。
 * 
 * finally块可以保证其中的代码无论try块中的代码
 * 是否出错都一定可以执行。
 * 所以通常把诸如释放资源等操作放入finally块中保证
 * 执行。
 * @author Administrator
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = null;
			if(str == null){
				return;
			}
			System.out.println(str.length());
		} catch (Exception e) {
			System.out.println("出错了");
		} finally{
			System.out.println("finally中的代码");
		}
		
		System.out.println("程序结束了");
	}
}






package day03.copy;
/**
 * finally块
 * finally语句块只能定义在异常捕获机制的最后，最后一个catch之后，或者直接在try之后。
 * finally块可以保证其中的代码无论try块中的代码是否出错都一定可以执行。
 * 所以通常把诸如释放资源等操作放入finally语句块中保证执行。
 * @author Administrator
 *
 */
public class ExcepitonDemo2 {
	public static void main(String[] args) {
		System.out.println("程序开始！");
		try{
			String str = null;
//			if(str == null){
//				return;//-----
//			}
			System.out.println(str.length());
		}catch(Exception e){
			System.out.println("出错了!");
		}finally{
			System.out.println("finally中的代码");
		}
		System.out.println("程序结束了");
	}
}














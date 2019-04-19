package day04;
/**
 * java1.5之后推出了一个新特性
 * 新循环，又名：增强for循环，增强循环，for each
 * 
 * 作用：不能取代传统循环的工作，仅用于遍历集合或数组。
 * @author Administrator
 *
 */
public class NewFor {
	public static void main(String[] args) {
		String[] array
		=new String[]{"one","two","three","four"};//----静态初始化
//		={"one","two","three","four"};  ------另一种写法
		
		for(int i=0;i<array.length;i++){
			String str=array[i];
			System.out.println(str);//------传统循环
		}
		
		for(String str:array){
			System.out.println(str);//-------增强循环
		}
		
		
	}
}

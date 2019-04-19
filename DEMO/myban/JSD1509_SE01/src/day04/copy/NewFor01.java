package day04.copy;
/**
 * java1.5之后推出了一个新特性
 * 新循环，又名：增强for循环，增强循环，for each
 * 作用：不能取代传统循环的工作，仅用于遍历集合或数组。
 * @author Administrator
 *
 */
public class NewFor01 {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three", "four"};
		for(int i = 0; i < array.length; i ++){
			String str = array[i];
			System.out.print(str +" ");
		}
		
		for(String str : array){
			System.out.print(str +" ");
		}
	}
}













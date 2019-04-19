package day02;
/**
 * 包装类最常用的方法：
 * 提供了静态方法parseXXX(String str)
 * 可以将字符串内容解析为对应的基本类型数据。
 * 前提是这个字符串能正确描述基本类型的值。
 * @author Administrator
 *
 */
public class IntegerDemo3 {
	public static void main(String[] args) {
		String str="123";;
		//将其转换为整数
		int i=Integer.parseInt(str);//-----------???
		i++;
		System.out.println(i);
		
		//将其转换为小数
		double d=Double.parseDouble(str);
		
		System.out.println(d);
		
	}

}

package day01;
/**
 * java.lang.StringBuilder
 * 内部维护一个可变的字符数组，该类的作用是解决字符串内容修改带来的资源消耗问题；
 * 该类提供了用于编辑字符串内容的相关方法。
 * 增：append
 * 删：delete
 * 改：replace
 * 插：insert
 * @author Administrator
 *
 */
public class StringBuilderDemo1 {
	public static void main(String[] args) {
		String str="努力学习java";
		//先转换为StringBuilder
		StringBuilder builder=new StringBuilder(str);//------不传参数的话直接是空字符串
		
//		//StringBuilder转换为String
//		str=builder.toString();
//		System.out.println(str);
//		System.out.println(builder);
//		
//		/**
//		 * 努力学习java，为了找个好工作
//		 * StringBuilder append(String str)
//		 * 在当前字符串末尾追加指定字符串，返回值还是当前StringBuilder对象。
//		 */
//		builder.append(",为了找个好工作");
//		System.out.println(builder.toString());
//		
//		/**
//		 * 努力学习java，就是为了改变世界！
//		 * StringBuilder replace(int start,int end,String str)
//		 * 将指定范围内的字符串替换为给定内容
//		 */
//		builder.replace(9,builder.length(),"就是为了改变世界！");
//		System.out.println(builder.toString());
//		
//		/**
//		 * ，就是为了改变世界！
//		 * StringBuilder delete(int start,int end)
//		 * 
//		 */
//		//builder.delete(8, builder.length());
//		//System.out.println(builder.toString());
//		
//		builder.delete(0,8);
//		System.out.println(builder.toString());
//		
//		/**
//		 * 活着，就是为了改变世界！
//		 * StringBuilder insert(int i,String j);
//		 * 将给定的字符串插入到指定位置处，原位置及后续字符都顺序向后移动。
//		 */
//		builder.insert(0, "活着");
//		System.out.println(builder.toString());
		
		//翻转字符串
//		builder.replace(2, 5, str);//----------------------------
		
		builder.reverse();
		System.out.println(builder.toString());
		
		
	}
}

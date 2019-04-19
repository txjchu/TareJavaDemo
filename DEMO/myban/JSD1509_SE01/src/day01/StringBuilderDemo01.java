package day01;
/**
 * java.lang.StringBuilder
 * 内部维护一个可变的字符数组，该类的作用解决字符串内容修改带来的资源消耗问题。
 * 增：append
 * 删：delete
 * 改：replace
 * 插：insert
 * @author Administrator
 *
 */
public class StringBuilderDemo01 {
	public static void main(String[] args) {
		String str = "努力学习java";
		//先转换为StringBuilder
		StringBuilder builder = new StringBuilder(str);
		
		//StringBuilder转换为String
		str = builder.toString();
		System.out.println(str);//努力学习java
		
		/*
		 * 努力学习java，为了找个好工作
		 * StringBuilder append(String str)
		 * 在当前字符串末尾追加指定字符串，返回值还是当前StringBuilder对象。
		 */
		builder.append("，为了找个好工作");
		System.out.println(builder);//努力学习java，为了找个好工作
		System.out.println(builder.toString());//努力学习java，为了找个好工作
		
		/*
		 * 努力学习java，就是为了改变世界
		 * StringBuilder replace(int start, int end, String str)
		 * 将指定范围内的字符串替换为给定内容
		 */
		builder.replace(9, builder.length(), "就是为了改变世界!");
		System.out.println(builder.toString());//努力学习java，就是为了改变世界!
		
		/*
		 * 需要输出：，就是为了改变世界！
		 * StringBuilder delete(int start, int end)
		 * 将指定范围内的字符串删除
		 */
		builder.delete(0, 8);
		System.out.println(builder.toString());//，就是为了改变世界!
		
		/*
		 * 活着，就是为了改变世界！
		 * StringBuilder insert(int i, String str)
		 * 将给定的字符串插入到指定位置处，原位置及后续字符都顺序后移。
		 */
		builder.insert(0, "活着");
		System.out.println(builder.toString());//活着，就是为了改变世界!
		
		//翻转字符串
		builder.reverse();
		System.out.println(builder.toString());//!界世变改了为是就，着活
	}
}



















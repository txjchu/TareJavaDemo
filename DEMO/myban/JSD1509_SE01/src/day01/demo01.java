package day01;
/** �ַ���String */
public class demo01 {
	public static void main(String[] args) {
		String s1 = "123abc";
		String s2 = "123abc";
		System.out.println(s1 == s2);
		String s4 = new String("123abc");
		System.out.println(s1 == s4);
		String s5 = "123" + "abc";//������һ������ʽ�������������������Ϊ�����������ֱ�ӽ������Ľ�����뵽class�ļ���.
		System.out.println(s1 == s5);
		String str = "123";
		String s6 = str + "abc";
		System.out.println(s1 == s6);
	}
}

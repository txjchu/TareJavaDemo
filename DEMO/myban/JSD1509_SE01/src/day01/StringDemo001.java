package day01;
/**
 * String �Ĳ�������
 * String ����һ������������ʾ�ַ��������޷��ı�ģ�����ı���봴���¶���
 * @author Administrator
 *
 */
public class StringDemo001 {
	public static void main(String[] args) {
		//������  ֱ����
		String s1 = "123abc";
		String s2 = "123abc";
		String s3 = "123abc";
		String s4 = new String("123abc");
		/**  
		 *	�޸�s1��s1�ᴴ��һ���µ��ַ������󣬵������ã�����Ӱ��s2ԭ�е����á�
		 */
		System.out.println(s1 == s2);//true
		s1 = s1 +"!";
		System.out.println(s1);//123abc!
		System.out.println(s2);
		/**
		 * ʹ����������ֵ�����ö���ʹ��new�ؼ�����ᴴ���µĶ���
		 */
		s1 = s2;
		System.out.println(s1 == s2);//true
		System.out.println(s1 == s3);//true
		System.out.println(s1 == s4);//false
		
		/**
		 * �������ڱ���Դ����ʱ��������һ��������ʽ���Ҽ�����ʽ�������ݶ��������������ֱ�ӽ������Ľ�����뵽class�ļ�
		 * �С�����JVM�����������ǣ�
		 * String s5 = "123abc";
		 */
		String s5 = "123" + "abc";
		System.out.println(s2 == s5);//true
		String str = "123";
		String s6 = str + "abc";
		System.out.println(s1 == s6);//false
	}
}














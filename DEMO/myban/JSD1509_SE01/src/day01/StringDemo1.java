package day01;
/**
 * String�Ĳ�������
 * String ����һ����������ʾ���ַ����������޷��ı��
 * ����ı���봴���¶���
 * ԭ��
 * �����ڿ����з����ַ������ñ��޸ļ��ʴ�ܶ࣬����Java��ʹ�������������Ķ���������һ��������
 * ֮ǰ�Ķ��󣬱��ⴴ���ظ������������ڴ濪����
 * �⵼���ַ������������ǡ����õġ���
 * @author Administrator
 *
 */

public class StringDemo1 {
	public static void main(String[] args){
		//������   ֱ����
//		String str = "HelloWorld";
		
		String s1="123abc";
		String s2="123abc";
		String s3="123abc";
		String s4=new String("123abc");
		/*
		 * �޸�s1��s1�ᴴ��һ���µ��ַ�������
		 * �������ã�����Ӱ��s2��ԭ�����ã�
		 */
//		System.out.println(s1==s2);
//		s1 = s1+"!";
//		System.out.println(s1);
//		System.out.println(s2);
		/*
		 * ʹ����������ֵ�����ö���
		 */
		System.out.print(s1==s2);//true
		System.out.print(s1==s3);//true
		System.out.print(s1==s4);//false
	
		/*
		 * �������ڱ���Դ����ʱ������һ��������ʽ
		 * ������������ߵ������������������ֱ�ӽ�
		 * �����Ľ�����뵽class�ļ��С�����JVM
		 * ������������:
		 * String s5 = "123abc";
		 */	
		String s5 = "123"+"abc";
		System.out.println(s1==s5);//true
		
		String str = "123";
		String s6 = str + "abc";
		System.out.println(s1==s6);//false
		System.out.println(s6);



		
	}
}

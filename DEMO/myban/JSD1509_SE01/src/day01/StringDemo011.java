package day01;
/**
 * static String valueOf(...)
 * �ַ����ṩ��һϵ�еľ�̬����valueOf()
 * ��Ҫ�������������ת��Ϊ�ַ�����
 * 
 * String���ǻ������ͣ����������ͣ�������������������
 * @author Administrator
 *
 */
public class StringDemo011 {
	public static void main(String[] args) {
		int a = 1;
		String s1 = String.valueOf(a);
		System.out.println(a);//1
		System.out.println(s1);//1
		
		System.out.println(s1 + 1);//11
		double d = 1.1;
		String s2 = String.valueOf(d);
		System.out.println(s2 + 1);//1.11
		
		String s3 = a + "";
		System.out.println(s3);//1
	}
}
















package day01;
/**
 * static String valueOf(...)
 * �ַ����ṩ��һϵ�еľ�̬����valueOf()
 * ��Ҫ�������������ת��Ϊ�ַ���
 * @author Administrator
 *
 */
public class StringDemo11 {
	public static void main(String[] arge){
		int a=1;
		String s1=String.valueOf(a);
		
		System.out.println(s1+1);
		
		double d=1.1;
		String s2=String.valueOf(d);
		System.out.println(s2+1);
		
		String s3=a+"";//-------������
		
        double pi = 3.1415926;    
        int value = 123;
        boolean flag = true;
        char[] charArr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' }; 
        String str = String.valueOf(pi);
        System.out.println(str); 
        
        str = String.valueOf(value);
        System.out.println(str); 
        
        str = String.valueOf(flag);
        System.out.println(str); 
        
        str = String.valueOf(charArr);
        System.out.println(str);
	}
}

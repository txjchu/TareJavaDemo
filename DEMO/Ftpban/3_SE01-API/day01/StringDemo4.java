package day01;
/**
 * String substring(int start,int end)
 * ��ȡ�ַ���
 * ��startָ����λ�ý�ȡ��endָ����λ��(����end)
 * java API��һ���ص㣬ͨ�������ʹ���������ֱ�ʾ
 * һ����Χʱ���Ǻ�ͷ����β�ġ�
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		//            01234567890123
		String str = "www.oracle.com";
		//��ȡoracle
		String sub = str.substring(4, 10);
		System.out.println(sub);
		
		/*
		 * ���ط���:
		 * String substring(int start)
		 * ��ָ��λ�ÿ�ʼ������ȡ���ַ���ĩβ
		 */
		sub = str.substring(4);
		System.out.println(sub);
		
		
		
	}
}







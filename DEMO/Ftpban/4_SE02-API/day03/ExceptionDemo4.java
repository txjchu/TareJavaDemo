package day03;
/**
 * Exception����API
 * @author Administrator
 *
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		try {
			String str="";
			System.out.println(str.charAt(0));
		} catch (StringIndexOutOfBoundsException e) {
			/*
			 * ����ô���Ķ�ջ��Ϣ
			 * �����������ִ�е����������������̣������ڿ��ٶ�λ����Ĵ��������У�
			 * �Ա��ڵ������롣
			 */
			
			e.printStackTrace();//-------��һ������
			
			String message = e.getMessage();//------�ڶ����﷨
			System.out.println(message);
			
		}
		
		
		
		
		
	}
}

package day03.copy;
/**
 * Exception��API
 * void  printStackTrace()	����쳣�¼�����ʱ��ִ�ж�ջ����Ϣ
 * String  getMessage()		�õ��й��쳣�¼�����Ϣ
 * Throwable  getCause()	��ȡ�쳣���ֵ�ԭ�� 
 */
public class ExceptionDemo4 {
	public static void main(String[] args) {
		try{
			String str = "";
			System.out.println(str.charAt(0));
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			
		}
	}
}

















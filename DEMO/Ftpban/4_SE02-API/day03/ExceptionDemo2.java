package day03;
/**
 * finally��
 * finally��ֻ�ܶ������쳣������Ƶ����:
 * ���һ��catch֮�󡣻���ֱ�Ӹ���try֮��
 * 
 * finally����Ա�֤���еĴ�������try���еĴ���
 * �Ƿ����һ������ִ�С�
 * ����ͨ���������ͷ���Դ�Ȳ�������finally���б�֤
 * ִ�С�
 * @author Administrator
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try {
			String str = null;
			if(str == null){
				return;
			}
			System.out.println(str.length());
		} catch (Exception e) {
			System.out.println("������");
		} finally{
			System.out.println("finally�еĴ���");
		}
		
		System.out.println("���������");
	}
}






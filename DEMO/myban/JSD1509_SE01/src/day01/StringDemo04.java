package day01;
/**
 * String substring(int start, int end)
 * ��ȡ�ַ�������
 * ��startָ��λ�ý�ȡ��endָ��λ�ã���ͷ����β�������ؽ�ȡ�����ַ�����
 * @author Administrator
 *
 */
public class StringDemo04 {
	public static void main(String[] args) {
		//			  01234567890123	
		String str = "www.oracle.com";
		//��ȡoracle
		String sub = str.substring(4,10);//��ͷ����β
		System.out.println(sub);//oracle
		/**
		 * ���ط���
		 * String substring(int start)
		 * ��ָ��λ�ÿ�ʼ������ȡ���ַ���ĩβ��
		 * 
		 */
		sub = str.substring(4);
		System.out.println(sub);//oracle.com
	}
}













package day01;
/**
 * String substring(int start,int end)
 * ��ȡ�ַ���
 * ��startָ����λ�ý�ȡ��endָ����λ�ã�����end��
 * Java API��һ���ص㣬ͨ�������ʹ���������ֱ�ʾһ����Χʱ���ǡ���ͷ����β���ġ�
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
	//			01234567890123	
	String str="www.oracle.com";
	//��ȡoracle
	String sub=str.substring(4,10);
	System.out.println(sub);
	
	/**
	 * ���ط�����
	 * String substring(int start)
	 * ��ָ��λ�ÿ�ʼ������ȡ���ַ���ĩβ
	 */
	sub=str.substring(4);
	System.out.println(sub);
}
}
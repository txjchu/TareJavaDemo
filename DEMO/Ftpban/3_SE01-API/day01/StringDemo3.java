package day01;
/**
 * int indexOf(String str)
 * ���ҷ������÷�����������:
 * ���ظ����ַ����ڵ�ǰ�ַ����е�λ�á�
 * @author Administrator
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		//            0123456789012345
		String str = "thinking in java";
		/*
		 * �鿴��ǰ�ַ����е�һ�γ��ָ����ַ�����
		 * λ�á���û���ҵ��򷵻�-1.
		 */
		int index = str.indexOf("in");
		System.out.println(index);
		
		/*
		 * ���ط���
		 * int indexOf(String str,int i)
		 * �Ӹ���λ�ô���ʼ���Ҹ����ַ�����һ��
		 * ���ֵ�λ�á�
		 */
		
		index = str.indexOf("in", 3);
		System.out.println(index);
		
		
		/*
		 * int lastIndexOf(String str)
		 * ���Ҹ����ַ����ڵ�ǰ�ַ��������һ��
		 * ���ֵ�λ��
		 */
		index = str.lastIndexOf("in");
		System.out.println(index);
		
	}
}











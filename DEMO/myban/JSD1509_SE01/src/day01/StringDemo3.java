package day01;
/**
 * int indexOf(String str)
 *���ҷ������÷����������ǣ�
 *���ظ����ַ����ڵ�ǰ�ַ����е�λ�á�
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		//			  0123456789012345
		String str = "thinking in java";
		/*
		 * �鿴��ǰ�ַ����е�һ�γ��ָ����ַ�����λ�ã���û���ҵ��򷵻�-1��
		 */
		int index=str.indexOf("in");//In,�ϸ����ִ�Сд
		System.out.println(index);//��ӡ��2
		
		int k = str.indexOf("k");
		System.out.println(k);
		/*
		 * ���ط���
		 * int indexOf(String str,int i)
		 * �Ӹ���λ�ô���ʼ���Ҹ����ַ�����һ�γ��ֵ�λ�á�
		 */
		index=str.indexOf("in",3);
		System.out.println(index);
		/**
		 * int lastIndexOf(String str)
		 * ���Ҹ����ַ����ڵ�ǰ�ַ��������һ�γ��ֵ�λ��
		 */
		index=str.lastIndexOf("in");
		System.out.println(index);
	}

}

package day01;
/**
 * int indexOf(String str)
 * ���ҷ������÷����������ǣ����ظ����ַ����ڵ�ǰ�ַ����е�λ�á�
 * @author Administrator
 *
 */
public class StringDemo03 {
	public static void main(String[] args) {
		//			  0123456789012345	
		String str = "thinking in java";
		/**
		 * �鿴��ǰ�ַ����е�һ�γ��ָ����ַ�����λ�á���û���ҵ��򷵻�-1��
		 */
		int index = str.indexOf("in");
		System.out.println(index);//2
		/**
		 * ���ط���
		 * int indexOf(String str , int i)
		 * �Ӹ���λ�ô���ʼ���Ҹ����ַ�����һ�γ��ֵ�λ�á�
		 */
		index = str.indexOf("in", 3);
		System.out.println(index);//5
		
		/** ====��ҪӦ��==== */
		/**
		 * ���һ���ַ���һ���ַ���λ��֮���һ�γ��ֵ�λ�á�
		 */
		index = str.indexOf("in");//in��һ�γ��ֵ�λ�ã�
		index = str.indexOf("i", index + "in".length());
		System.out.println("in֮��i���ֵ�λ�ã�"+ index);//�����in֮��i���ֵ�λ�ã�5
		
		/**
		 * int lastIndexOf(String str)
		 * ���Ҹ����ַ����ڵ�ǰ�ַ��������һ�γ��ֵ�λ�á�
		 */
		index = str.lastIndexOf("in");
		System.out.println(index);
	}
}















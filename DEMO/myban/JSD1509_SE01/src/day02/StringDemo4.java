package day02;
/**
 * String replaceAll(String regex,String str)
 * ����ǰ�ַ������������������ʽ�Ĳ����滻Ϊָ�����ַ�������
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		String str="aaa111bbb222ccc333ddd4444eee";
		/*
		 * �����ֲ����滻Ϊ��#NUMBER#��
		 */
		str=str.replaceAll("[0-9]+","#NUMBER#");//----+��ʾ�滻һ�Σ����û�мӺ����滻3��
		System.out.println(str);
	}
}

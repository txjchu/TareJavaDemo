package day02;
/**
 * String replaceAll(String regex, String str)
 * ����ǰ�ַ�������������������ʽ�Ĳ����滻Ϊָ�����ַ������ݡ�
 * @author Administrator
 *
 */
public class StringDemo04 {
	public static void main(String[] args) {
		String str = "aaa111bbb222ccc333ddd444eee";
		/*
		 * �����ֲ����滻Ϊ��#NUMBER#��
		 */
		str = str.replaceAll("[0-9]+", "#NUMBER#");
		System.out.println(str);
	}
}








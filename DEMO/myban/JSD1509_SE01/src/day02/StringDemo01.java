package day02;
/**
 * String֧��������ʽ����ط���1��
 * boolean matches(String regex)
 * �жϵ�ǰ�ַ����Ƿ����������������ʽ�ĸ�ʽҪ��
 * ��Ҫע�⵽�ǣ�������ʽ�в����Ƿ��С�^����$��ָ��������ȫƥ����֤��
 * @author Administrator
 *
 */
public class StringDemo01 {
	public static void main(String[] args) {
		String mail = "fancq@tedu.cn";
		/*
		 * �����������ʽ��\w+@\w+(\.[a-zA-Z]+)+
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\.[a-zA-Z]+)+
		 * + �Ӻű�ʾ����1������������
		 */
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";
		String regexNext = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean matches = mail.matches(regex);
		boolean matchesNext = mail.matches(regexNext);
		if(matches){
			System.out.println("������");
		}else{
			System.out.println("��������");
		}
		if(matchesNext){
			System.out.println("�����䣡");
		}else{
			System.out.println("�������䣡");
		}
	}
}















package day02;
/**
 * String֧��������ʽ����ط���1:
 * boolean matches(String regex)
 * �жϵ�ǰ�ַ����Ƿ����������������ʽ
 * �ĸ�ʽҪ����Ҫע�⣬������ʽ�в���
 * �Ƿ���"^","$"ָ��������ȫƥ����֤��
 * @author Administrator
 *
 */
public class StringDemo1 {
	public static void main(String[] args) {
		String mail = "fancq@tedu.cn";
		/*
		 * �����������ʽ:
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\.[a-zA-Z]+)+
		 */
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";
		
		boolean matches = mail.matches(regex);
		
		if(matches){
			System.out.println("������");
		}else{
			System.out.println("��������");
		}
	}
}








package day02;
/**
 * String֧��������ʽ����ط���1��
 * boolean matches(String regex)
 * �жϵ�ǰ�ַ����Ƿ����������������ʽ�ĸ�ʽҪ��
 * ��Ҫע����ǣ�������ʽ�в����Ƿ��С�^������$��ָ��������ȫƥ����֤����
 * @author Administrator
 *
 */
public class StringDemo1 {
	public static void main(String[] args) {
		String mail="fancq@tedu.cn";
		/*
		 * �����������ʽ��
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+[\.[a-zA-Z]+)+
		 */
		String regex="[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";//-----\.����Java�б�ʾ��ǰ���ټ�\
		//-----Java��Ĭ��ǰ�����^����$,��ȫƥ��
		boolean matches=mail.matches(regex);
		
		if(matches){
			System.out.println("������");
		}else{
			System.out.println("��������");
		}
		String emailRegEx = "^[a-zA-Z0-9_.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,4}$";
		String email = "bjliyi@tarena.com.cn";
		System.out.println(email.matches(emailRegEx));
		
		
		String regex1 = "\\w{8,10}";
		String str1 = "abcd24_abcd";//----8��true��10��true,
		System.out.println(str1.matches(regex1));
		
	}
	public void email(){
//		String emailRegEx = "^[a-zA-Z0-9_.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,4}$";
//		String email = "bjliyi@tarena.com.cn";
//		System.out.println(email.matches(emailRegEx));
	}
}

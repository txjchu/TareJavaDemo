package day03;
/**
 * java�쳣���������try-cath
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		
		System.out.println("����ʼ����");

		try{					//-----	try
		
		String str="a223";
		/*
		 * ������������з����쳣ʱ���ᴴ��һ�������쳣��ʵ������ʾ�ô���
		 * Ȼ�󽫴����ִ�й���ȫ����װ���ô����У������쳣�׳���
		 */
		System.out.println(str.length());
		
		System.out.println(str.charAt(0));
		
		System.out.println(Integer.parseInt(str));
		
//		����ʼ����
//		Exception in thread "main" java.lang.NullPointerException
//			at day03.ExceptionDemo1.main(ExceptionDemo1.java:12)
		}catch(NullPointerException e){				//�����쳣
			System.out.println("������һ����ָ�룡");		//���쳣�Ľ���ķ���
		
		
		//catch ����д��������ֱ𲶻�ͬ�쳣��������
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("�ַ����±�Խ���ˣ�");
		
		
		/*
		 * Ӧ������һ�����õ�ϰ�ߣ����������һ��catch��ȥ����Exception,
		 * �������ٲ�����Ϊ����һ��δ������쳣�����³����նˡ�
		 * catch �����쳣��˳��
		 * ������Ĳ�ͬ�쳣֮��û�м̳й�ϵ��˭�����涼���ԡ�
		 * �������м̳й�ϵ���쳣֮�䣬һ���������쳣���Բ���Ȼ���ٲ������쳣��
		 */
		}catch(Exception e){
			System.out.println("���������и����󣬵��ǳ������ܽ�����ȥ�ˣ�");
		}
		
		
		System.out.println("�����������");
	}
}

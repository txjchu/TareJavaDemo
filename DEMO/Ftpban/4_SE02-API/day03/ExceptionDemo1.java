package day03;
/**
 * java�쳣��������е�try-cath
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("����ʼ��!");
		
		try{
			String str = "a";
			/*
			 * ������������з����쳣ʱ���ᴴ��һ��
			 * �����쳣��ʵ������ʾ�ô���Ȼ��
			 * �����ִ�й���ȫ����װ���ô����У�����
			 * �쳣�׳���
			 */
			System.out.println(str.length());
			
			System.out.println(str.charAt(0));
			
			System.out.println(Integer.parseInt(str));
		}catch(NullPointerException e){
			System.out.println("������һ����ָ��!");
			
		//catch����д��������ֱ𲶻�ͬ�쳣��������
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("�ַ����±�Խ����!");
		
		/*
		 * Ӧ������һ�����õ�ϰ�ߣ����������һ��catch
		 * ��ȥ����Exception,�������ٲ�����Ϊ����һ��
		 * δ������쳣�����³����жϡ�
		 * catch�����쳣��˳��:
		 * ������Ĳ�ͬ�쳣֮��û�м̳й�ϵ��˭���϶����ԡ�
		 * �������м̳й�ϵ���쳣֮�䣬һ���������쳣����
		 * ����Ȼ���ٲ������쳣��	
		 */
		}catch(Exception e){
			System.out.println("�������ǳ��˸���");
		}
		
		
		System.out.println("���������!");
	}
}







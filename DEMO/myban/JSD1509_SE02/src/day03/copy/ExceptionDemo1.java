package day03.copy;
/**
 * java�쳣��������е�try-catch
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try{
			String str = "a";
			/*
			 * ������������з����쳣ʱ���ᴴ��һ�������쳣��ʵ������ʾ�ô���Ȼ�󽫴����ִ�й���ȫ����װ���ô����У�
			 * �����쳣�׳���
			 */
			System.out.println(str.charAt(4));
			System.out.println(str.length());
			System.out.println(Integer.parseInt(str));
			
		}catch(NullPointerException e){
			System.out.println("����һ����ָ���쳣��");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("�ַ����±�Խ���ˣ�");
			/*
			 * Ӧ������һ�����õ�ϰ�ߣ����������һ��catch��ȥ����Exception���������ٲ�����Ϊ����һ��δ������쳣
			 * �����³����жϡ�
			 * catch�����쳣��˳��
			 * ������Ĳ�ͬ�쳣֮��û�м̳й�ϵ��˭�����涼���ԣ������м̳й�ϵ���쳣֮�䣬һ���������쳣���в���
			 * Ȼ���ٲ������쳣��
			 */
		}catch(Exception e){
			/*
			 * -----����������δ������쳣�������ղ��񶥼������쳣Exception��
			 * 
			 * ��������һ���쳣���򲻻��ٲ��������쳣������ �����쳣������Ĵ��붼����ִ�С�
			 */
			System.out.println("�������ǳ��˸���");
		}
		System.out.println("���������!");
	}
}
















package homework01;
/**
 * ��ҵ5
 * ʹ��StringBuilderʵ��
 * @author Administrator
 *
 */
public class Test05 {
	public static void main(String[] args) {
		String str = "�Ϻ�����ˮ���Ժ���";
		StringBuilder builder
			= new StringBuilder(str);
		
		builder.reverse();
		String str1 = builder.toString();
		
		if(str.equals(str1)){
			System.out.println("�ǻ���");
		}else{
			System.out.println("���ǻ���");
		}
	}
}








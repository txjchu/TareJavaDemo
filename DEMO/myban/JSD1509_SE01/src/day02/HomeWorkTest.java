package day02;
//������ҵ  	��ҵ5
public class HomeWorkTest {
	public static void main(String[] args) {
		String str="�Ϻ�����ˮ���Ժ���";
		StringBuilder builder = new StringBuilder(str);
		builder.reverse();//��ת�ַ���
		String str1=builder.toString();
		
		if(str.equals(str1)){
			System.out.println("�ǻ���");
		}else{
			System.out.println("���ǻ���");
		}
	}
}

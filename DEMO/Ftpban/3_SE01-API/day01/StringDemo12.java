package day01;
/**
 * �ַ���ƴ�ӵ�Ч�������Լ���Դ����
 * @author Administrator
 *
 */
public class StringDemo12 {
	public static void main(String[] args) {
		String str = "a";
		for(int i=0;i<10000000;i++){
			str += str;
		}
		
	}
}

package day01;
/**
 * �ַ���ƴ�ӵ�Ч�������Լ���Դ����
 * @author Administrator
 *
 */
public class StringDemo12 {
	public static void main(String[] args) {
		String str = "a";
		for(int i=0;i<23;i++){// i����������ΪС��23�������8388608
			str += str;
			//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		}
		System.out.println(str.length());//��i=10ʱ��str.length()=1024;
	}
}

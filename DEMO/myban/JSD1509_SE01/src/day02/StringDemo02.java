package day02;
/**
 * ����ַ���
 * String[] split(String regex)
 * ����ǰ�ַ���������������ʽ�Ĳ��֡��е���������ʣ���ÿ�����ݣ������ַ�������ķ�ʽ���淵�ء�
 * @author Administrator
 *
 */
public class StringDemo02 {
	public static void main(String[] args) {
		String str = "abc,def,hig,,asda,dfgas,asdf,ao";
		/*
		 * ����������ƥ���룬�м���ֳ�һ�����ַ������������ַ���ĩβ������ƥ����ᱻ���ԡ�
		 */
		String[] arr = str.split(",");
		System.out.println(arr.length);//8
		for(int i = 0; i < arr.length; i ++){
			System.out.println(arr[i]);
		}
	}
}



















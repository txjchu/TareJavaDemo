package day02;
/**
 * ����ַ���
 * String[] split(String regex)
 * ����ǰ�ַ���������������ʽ�Ĳ��֡��е���������ʣ���ÿ�����ݣ�
 * @author Administrator
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
		String str="abc,,def,,,hig,asda,dfg";//-----����м���.�Ļ���������\\.,����,�Ļ�������һ����վλ�ַ���
		/*
		 * ����������ƥ����м���ֳ�һ�����ַ������������ַ���ĩβ����ƥ����ᱻ���ԣ�
		 */
		String[] arr=str.split(",");
		System.out.println(arr.length);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}		
	}
}

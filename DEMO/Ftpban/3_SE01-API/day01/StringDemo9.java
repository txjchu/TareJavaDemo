package day01;
/**
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * 
 * �жϵ�ǰ�ַ����Ƿ����Ը����ַ�����ͷ�Ļ��β��
 * @author Administrator
 *
 */
public class StringDemo9 {
	public static void main(String[] args) {
		String str = "thinking in java";
		
		boolean starts = str.startsWith("th");
		System.out.println("starts:"+starts);
		
		boolean ends = str.endsWith("ava");
		System.out.println("ends:"+ends);
		
	}
}









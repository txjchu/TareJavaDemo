package day04;
/**
 * java1.5֮���Ƴ���һ��������
 * ��ѭ��������:��ǿforѭ������ǿѭ����for each
 * 
 * ����:����ȡ����ͳѭ���Ĺ����������ڱ������ϻ�����
 * @author Administrator
 *
 */
public class NewFor {
	public static void main(String[] args) {
		String[] array 
		  = {"one","two","three","four"};
		
		for(int i=0;i<array.length;i++){
			String str = array[i];
			System.out.println(str);
		}
		
		for(String str:array){
			System.out.println(str);
		}
		
		
	}
}	





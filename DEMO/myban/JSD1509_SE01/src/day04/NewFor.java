package day04;
/**
 * java1.5֮���Ƴ���һ��������
 * ��ѭ������������ǿforѭ������ǿѭ����for each
 * 
 * ���ã�����ȡ����ͳѭ���Ĺ����������ڱ������ϻ����顣
 * @author Administrator
 *
 */
public class NewFor {
	public static void main(String[] args) {
		String[] array
		=new String[]{"one","two","three","four"};//----��̬��ʼ��
//		={"one","two","three","four"};  ------��һ��д��
		
		for(int i=0;i<array.length;i++){
			String str=array[i];
			System.out.println(str);//------��ͳѭ��
		}
		
		for(String str:array){
			System.out.println(str);//-------��ǿѭ��
		}
		
		
	}
}

package day04.copy;
/**
 * java1.5֮���Ƴ���һ��������
 * ��ѭ������������ǿforѭ������ǿѭ����for each
 * ���ã�����ȡ����ͳѭ���Ĺ����������ڱ������ϻ����顣
 * @author Administrator
 *
 */
public class NewFor01 {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three", "four"};
		for(int i = 0; i < array.length; i ++){
			String str = array[i];
			System.out.print(str +" ");
		}
		
		for(String str : array){
			System.out.print(str +" ");
		}
	}
}













package day01;
/**
 * ������
 * @author Administrator
 *
 */
public class StringDemo8 {

	public static void main(String[] args) {
		String str="�Ϻ�����ˮ���Ժ���";
		/**
		 * ˼·��
		 * ����λ���ϵ��ַ��뵹��λ���ϵ��ַ���һ�����ǻ��ģ�
		 */
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(str.length()-1-i)){
				System.out.println("���ǻ��ģ�");
				return;
			}
		}
		System.out.println("�ǻ��ģ�");
	}
}

		/**
		 * boolean tf=true;-----�ÿ���
		 * return false��
		 * if(tf){
		 * System.out.println("�ǻ��ģ�");
		 */
			
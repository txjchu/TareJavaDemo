package day01;
/** 
 * ��ϰ������ 
 * ��ȡ�����ַ������һ����/��֮����ַ�����ȡ���ַ�����
 */
public class exercise03 {
	public static void main(String[] args) {
		String str = "someapp/manager/emplist.action";
		int endSite = str.lastIndexOf("/");
		String newStr = str.substring(endSite + 1);
		System.out.println(newStr);
		
		/**
		 * ��ϰ�������
		 * ������
		 */
		str = "able was i ere i saw elba";
		for(int i = 0; i < str.length() / 2; i ++){
			if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
				System.out.println(str + "���ǻ��ģ�");
				return;
			}
		}
		System.out.println(str +"�ǻ��ģ�");
	}
}

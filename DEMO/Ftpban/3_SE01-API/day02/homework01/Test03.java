package homework01;
/**
 * ��ҵ3
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) {
		String str = "someapp/manager/emplist.action";
		
		//�ҵ����һ��"/"��λ��
		int index = str.lastIndexOf("/");
		
		//�����һ��"/"֮��ĵ�һ���ַ���ʼ��ȡ��ĩβ
		String sub = str.substring(index+1);
		System.out.println(sub);
	}
}








package day01;
/**
 * ��ϰ����ȡ����
 * @author Administrator
 *
 */
public class StringDemo05 {
	public static void main(String[] args) {
		/*
		 * www.baidu.com
		 * www.tarena.com.cn
		 */
		String url = "www.baidu.com";
		
		//��ʼλ���ǵ�һ����.��֮��ĵ�һ���ַ���λ��
		int start = url.indexOf(".") + 1;
		//����λ���ǵڶ�����.����λ��
		int end = url.indexOf(".", start);
		String name = url.substring(start, end);
		System.out.println(name);//baidu
	}
}













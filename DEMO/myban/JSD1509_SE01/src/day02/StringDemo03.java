package day02;
/**
 * ͼƬ������
 * @author Administrator
 *
 */
public class StringDemo03 {
	public static void main(String[] args) {
		String imgName = "123.jpg";
		String[] arr= imgName.split("\\.");//���ַ�����.Ϊ���޷ָ�����浽�ַ��������С�
		imgName = System.currentTimeMillis()+ "." +arr[1];//���ַ����е�һ��������ϵͳʱ�����
		System.out.println(imgName);
	}
}














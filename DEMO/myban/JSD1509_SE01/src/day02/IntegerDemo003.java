package day02;
/**
 * ��װ����õķ�����
 * �ṩ�˾�̬����parseXXX(String str)
 * ���Խ��ַ������ݽ���Ϊ��Ӧ�Ļ����������ݡ�ǰ��������ַ�������ȷ�����������͵�ֵ��
 * @author Administrator
 *
 */
public class IntegerDemo003 {
	public static void main(String[] args) {
		String str = "123";
		//����ת��Ϊ����
		int i = Integer.parseInt(str);
		i++;
		System.out.println(i);//124
		
		double d = Double.parseDouble(str);
		System.out.println(d);//123.0
	}
}












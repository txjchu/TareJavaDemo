package day02;
/**
 * ��װ����õķ�����
 * �ṩ�˾�̬����parseXXX(String str)
 * ���Խ��ַ������ݽ���Ϊ��Ӧ�Ļ����������ݡ�
 * ǰ��������ַ�������ȷ�����������͵�ֵ��
 * @author Administrator
 *
 */
public class IntegerDemo3 {
	public static void main(String[] args) {
		String str="123";;
		//����ת��Ϊ����
		int i=Integer.parseInt(str);//-----------???
		i++;
		System.out.println(i);
		
		//����ת��ΪС��
		double d=Double.parseDouble(str);
		
		System.out.println(d);
		
	}

}

package day02;

public class IntegerDemo4 {
	public static void main(String[] args) {
		/*
		 * JAVA1.5�Ժ��Ƴ���һ���µ����ԣ��Զ���װ
		 * �䡣�Զ���װ�䲻��JVM�Ͽɵģ����Ǳ�����
		 * �Ͽɵġ�
		 * ����������������Ĵ���ʱ����Ϊ������Ҫ��
		 * ��������ת��Ϊ��������ʱ���Զ��ڱ�����
		 * class�ļ��в����˴��룬��������Ĵ���
		 * ��class�е�������:
		 * int i = new Integer(1).intValue()
		 * ��������Ὣ��������ת��Ϊ�������ͣ����
		 * �ͳ�Ϊ�Զ����䡣
		 */
		int i = new Integer(1);
		/*
		 * ����������������Ĵ���ʱ��������Ҫ������
		 * ����ת��Ϊ��������ʱ�����Զ���ȫ����:
		 * Integer a = Integer.valueOf(1);
		 * ������̳�Ϊ�Զ�װ�䡣
		 */
		Integer a = 1;
		
		dosome(1);
	}
	
	public static void dosome(Object o){
		
	}
}

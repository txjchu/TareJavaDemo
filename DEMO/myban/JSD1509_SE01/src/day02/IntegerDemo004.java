package day02;

public class IntegerDemo004 {
	public static void main(String[] args) {
		/*
		 * JAVA1.5�Ժ��Ƴ�һ���µ����ԣ��Զ���װ�䡣�Զ���װ�䲻��JVM�Ͽɵģ����Ǳ������Ͽɵġ�
		 * ����������������Ĵ���ʱ����Ϊ������Ҫ����������ת��Ϊ��������ʱ���Զ��ڱ�����class�ļ��в����˴��룬
		 * ��������Ĵ�����class�ļ��е������ǣ�
		 * int i = new Integer(1).intValue();
		 * ��������Ὣ��������ת��Ϊ�������ͣ�����ͳ�Ϊ�Զ����䡣
		 */
		int i  = new Integer(1);
		/*
		 * ����������������Ĵ���ʱ��������Ҫ����������ת��Ϊ��������ʱ�����Զ�����ȫ���룺
		 * Integer a = Integer.valueOf(1);
		 * ������̾ͳ�Ϊ�Զ�װ�䡣
		 */
		Integer a = 1;
		dosome(1);//���ھͿ���Ӧ�õ��������Ŀ����������ˡ�
		System.out.println(a);
		
	}
	public static void dosome(Object o){
		
	}
}













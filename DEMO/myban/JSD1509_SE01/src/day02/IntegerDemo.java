package day02;
/**
 * ��װ��
 * ����Java��8���������Ͷ��ԣ�����������ֱ����ֵ����ʽ�������ڴ��У�
 * ����û�������������ԡ�
 * Ϊ�˽�����ǲ��ܲ���������󿪷������⣬JavaΪ�����ṩ�˶�Ӧ�İ�װ�ࡣ
 * 
 * ���������������ֵİ�װ�඼�̳���Number��
 * Number��һ�������࣬�ṩ�˿��Խ���ǰ�����ʾ������ת��Ϊ��6���������͵�ֵ��
 * 
 * @author Administrator
 *
 */
public class IntegerDemo {
	public static void main(String[] args){
		int a=100000;
		/*
		 * ����������ת��Ϊ��װ�������ַ�ʽ��
		 * 1.ֱ��ʹ�ù��췽����
		 * 2.ʹ�ð�װ��ľ�̬����valueOf(�Ƽ�����
		 */
		//1
		Integer i1=new Integer(a);
		
		//2
		Integer i2=Integer.valueOf(a);
		
		System.out.println(i1.equals(i2));
		System.out.println(i1==i2);
		
		/*
		 * valueOf��һЩ��װ���У�����������һ���Ķ���
		 * ����new��һ��Ҫ�����¶���ġ�
		 */
		//����װ�������ת��Ϊintֵ
		int n=i1.intValue();//------value?�ϴ�
		System.out.println(n);
		
		//����װ�������ת��Ϊdoubleֵ
		double d=i1.doubleValue();
		System.out.println(d);
	}		
//		
//		dosome("abc");
//		dosome(new Point(1,2));
//		int a=1+1;
//		dosome(a);

	
	public static void dosome(Object o){
		
	}
}
//class Integer{
//	private int i;
//	
//	public Integer(int i){
//		this.i=i;
//	}


package day03;
/**
 * 1.java��ȡ������
 * �������������롣
 * 2.double�������ֵ�������
 * @author Administrator
 *
 */
public class IntDoubleDemo {
	public static void main(String[] args) {
		int a = 10, b = 3;
		System.out.println(a / b);//3
		double a1 = 10, b1 = 3;
		System.out.println(a1 / b1);//3.3333333333333335
		double a2 = 10.0, b2 = 3;
		System.out.println(a2 / b2);//3.3333333333333335
		int c =(int) (a2 / b2);//ǿ������ת������double����ת��Ϊint��
		System.out.println(c);//3
		int a3 = -5;
		double b3 = (double)a3 / 2.0;
		int c1 = a3 >> 1; 
		System.out.println(b3 +" , c1 = "+ c1);//-2.5 , c1 = -3
		System.out.println((int)b3 +", c1 = "+ c1);//-2, c1 = -3	doubleת��Ϊint�Ͷ�ʧ���ȡ�
		
		double i = -5.0;
		int j = (int) i / 2;//-2
		int l = -1 >> 13;//-1����ѧ��λ���㣨<<��>>����������
		System.out.println(j +","+ l);//-2,-1
		System.out.println(Double.toHexString(i));//-0x1.4p2	double���͵�16���Ʊ����ʽ
		
		
		double m = 3;
		double n = 2.7;
		System.out.println( m - n);//0.10000000000000009	 2.9
								   //0.2999999999999998		 2.7	
								   //0.2200000000000002      2.78		
	}
}
















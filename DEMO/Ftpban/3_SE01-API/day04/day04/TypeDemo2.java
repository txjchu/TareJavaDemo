package day04;
/**
 * ���͵�ʵ��������Object
 * ֻ����ʹ��ʱ�����������鴫��Ĳ����Ƿ����
 * ����Ҫ�󣬲���������벻ͨ�����ڻ�ȡ��������
 * ��Ӧ��ֵʱ���Զ�������ת�����ѡ�
 * ��û��ָ�����͵ľ��������ǣ���ʹ��ԭ��Object.
 * 
 * @author Administrator
 *
 */
public class TypeDemo2 {
	public static void main(String[] args) {
		Point<Integer> p = new Point<Integer>(1,2);
		//����������ʵ�������뷺���Ƿ�ƥ��
		p.setX(1);
		//���Զ�����ΪInteger�󷵻ء�
		int x = p.getX();
		System.out.println(x);
		//��p1�Ƕȿ�������ʹ��ԭ��Object
		Point p1 = p;
		//��x�ı�ΪString���͵�ֵ
		p1.setX("һ");
		/*
		 * ������p�ĽǶȿ�x��Integer,���������
		 * �ڽ�������ת��ʱ��Stringֵ"һ"ת��Ϊ
		 * Integerʱ������!
		 */
		//ClassCastException
		x = p.getX();
		System.out.println(x);
		
	}
}









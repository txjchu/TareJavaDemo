package day04.copy;
/**
 * ���͵�ʵ��������Object��ֻ����ʹ��ʱ�����������鴫��Ĳ����Ƿ���Ϸ��͵�Ҫ�󣬲���������벻ͨ����
 * �ڻ�ȡ�������Ͷ�Ӧ��ֵʱ�����Զ�������ת�����ѡ�
 * ��û��ָ�����͵ľ�������ʱ����ʹ��ԭ��Object��
 * @author Administrator
 *
 */
public class TypeDemo02 {
	public static void main(String[] args) {
		Point01<Integer> p = new Point01<Integer>(1, 2);
		//����������ʵ�������뷺���Ƿ�ƥ�䡣
		p.setX(1);
		//���Զ�����ΪInteger�󷵻ء�
		System.out.println(p.getX().getClass());//class java.lang.Integer
		int x = p.getX();
		System.out.println(x);//1
		//��p1�Ƕȿ�������ʹ��ԭ��Object
		Point01 p1 = p;
		//��x�ı�ΪString���͵�ֵ
		p1.setX("һ");
		/*
		 * ������p�ĽǶȿ�x��Integer������������ڽ�������ת��ʱ����Stringֵ"һ"ת��ΪIntegerʱ�����ˣ�
		 */
		//ClassCastException
		x = p.getX();
		System.out.println(x);
	}
}





















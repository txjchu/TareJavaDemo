package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * �жϼ������Ƿ��и���Ԫ��
 * boolean contains(E e)
 * �����жϸ���Ԫ���Ƿ񱻰��������ݸ���Ԫ���뼯������Ԫ���Ƿ����equals�Ƚ�Ϊtrue�����������true����Ϊ������
 * @author Administrator
 *
 */
public class CollectionDemo02 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		Emp e1 = new Emp("����", 25, "��", 5000);
		c.add(e1);
		c.add(new Emp("����", 24, "Ů", 4000));
		c.add(new Emp("����", 23, "��", 4000));
		System.out.println(c);
		
		Emp e2 = new Emp("����", 26, "��", 7000);
		System.out.println(e1 == e2);//false
		/*
		 * ��Ϊe2�뼯���еĵ�һ��Ԫ�أ�Ҳ����e1��equals�Ƚ�Ϊtrue,������Ϊ���ϰ���e2
		 */
		boolean contains = c.contains(e2);
		System.out.println("�Ƿ������"+ contains);
	}
}














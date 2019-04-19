package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection
 * ���ϣ����Ա���һ��Ԫ�أ����ṩ�˱��ڲ���Ԫ�ص���ط�����
 * ���������������
 * List�����ظ���
 * Set�������ظ���
 * �ж�Ԫ���Ƿ����ظ�������Ԫ�������equals()�����ȽϵĽ����Ҳ����˵Set�����в������2��Ԫ��equals���Ϊtrue�������
 * Ԫ�ص�equals�������صĽ���Լ��ϵĺܶ�����Ľ������Ӱ�졣
 * @author Administrator
 *
 */
public class CollectionDemo01 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/*
		 * boolean add(E e)
		 * �򼯺������һ����Ԫ�ء����ɹ��򷵻�true��
		 * ͨ�������в�����벻ͬ����Ԫ�أ���Ϊȡ��ʱ���÷ǳ������㡣
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		/*
		 * ���϶���д��toString������
		 * ��ʽ��[Ԫ��1.toString(), Ԫ��2.toString(),...]
		 */
		System.out.println(c);//[one, two, three, four]

		/*
		 * int size()
		 * �鿴��ǰ�����е�Ԫ������
		 */
		int size = c.size();
		System.out.println("size:"+ size);
		
		/*
		 * boolean isEmpty()
		 * �鿴��ǰ�����Ƿ񲻺����κ�Ԫ�ء�
		 */
		boolean isEmpty = c.isEmpty();
		System.out.println("c�����Ƿ�Ϊ�գ�"+ isEmpty);
		/*
		 * void clean()
		 * ��յ�ǰ����
		 */
		c.clear();
		System.out.println("size:"+ c.size());
		System.out.println("isEmpty:"+ c.isEmpty());
	}
}












package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection
 * ���ϣ����Ա���һ��Ԫ�أ����ṩ�˱��ڲ���Ԫ�ص���ط�����
 * ���������������
 * List:���ظ�����  		Set:�����ظ���
 * �ж�Ԫ���Ƿ����ظ���������Ԫ������equals�����ȽϵĽ����Ҳ����˵Set�����в���
 * ����2��Ԫ��equals�Ƚ�Ϊtrue�������
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		
		/*
		 * boolean add(E e)
		 * �򼯺�������һ����Ԫ�ء�
		 * ���ɹ������򷵻�true
		 * 
		 * ͨ�������в�����벻ͬ����Ԫ�أ���Ϊȡ��ʱ���÷ǳ������㡣
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		/*
		 * ���϶���д��toString����
		 * ��ʽ��
		 * [Ԫ��1.toString(),Ԫ��2.toString(),����]		 * 
		 */
		System.out.println(c);
		/*
		 * int size()
		 * �鿴��ǰ�����е�Ԫ������
		 */
		int size=c.size();
		System.out.println("size:"+size);
		/*
		 * boolean isEmpty()
		 * �鿴��ǰ�����Ƿ񲻺����κ�Ԫ��
		 * ��������һ��Ԫ�ض�û�е�ʱ�򣬷���true��
		 */
		boolean isEmpty=c.isEmpty();
		System.out.println("isEmpty:"+isEmpty);
		/*
		 * void clear()
		 * ��յ�ǰ����
		 */
		c.clear();
		
		System.out.println("size:"+c.size());
		
		System.out.println("isEmpty:"+c.isEmpty());
		
		
		
	}
}
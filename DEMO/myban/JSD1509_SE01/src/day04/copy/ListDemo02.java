package day04.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * List�ṩ�ķ�����
 * void add(int index, E e)
 * ��ָ��λ�ò���һ��Ԫ�أ�ԭλ�ü�����Ԫ��˳������ƶ���
 * 
 * E remove(int index)
 * ɾ��ָ��λ���ϵ�Ԫ�أ�������ɾ����Ԫ�ط��ء�
 * @author Administrator
 *
 */
public class ListDemo02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);//[one, two, three, four]
		list.add(1, "2");
		System.out.println(list);//[one, 2, two, three, four]
		
		String old = list.remove(2);
		System.out.println(list);//[one, 2, three, four]
		System.out.println("old:"+ old);//old:two
	}
}














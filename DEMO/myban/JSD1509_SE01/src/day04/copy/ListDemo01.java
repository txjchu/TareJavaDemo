package day04.copy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List�ǿ��ظ�����������
 * �ص㣺����ͨ���±����Ԫ�ء�
 * ����ʵ���ࣺ
 * ArrayList���ڲ�������ʵ�֣����ڲ�ѯ��
 * LinkedList���ڲ�������ʵ�֣�������ɾ��
 * 
 * List�ṩ��һЩ�����±����Ԫ�ص� ������
 * @author Administrator
 *
 */
public class ListDemo01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
//		List<String> list = new LinkedList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);//[one, two, three, four]
		
		/*
		 * E get(int index)��ȡָ���±�λ�ö�Ӧ��Ԫ�ء�
		 */
		String str = list.get(1);
		System.out.println(str);//two
		
		for(int i = 0; i < list.size(); i ++){
			str = list.get(i);
			System.out.println(str);
		}
		/*
		 * E set(int index, E e)
		 * ��������Ԫ�����õ�������λ���ϣ�����ֵΪԭλ���ϵ��Ǹ�Ԫ�ء��������滻Ԫ�ز�����
		 */
		//[ont, two, three, four]
		String old = list.set(1, "2");
		System.out.println(list);//[one, 2, three, four]
		System.out.println("old:"+ old);//old:two
		
		List<String> list1 = new ArrayList<String>();
		list1.add("one");
		list1.add("two");
		list1.add("three");
		list1.set(1, list1.set(2, list1.get(1)));
		System.out.println(list1);
	}
}















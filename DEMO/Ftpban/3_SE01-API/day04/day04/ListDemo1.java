package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List�ǿ��ظ�����������
 * �ص�:����ͨ���±����Ԫ��
 * ����ʵ����:
 * ArrayList:�ڲ�������ʵ�֣����ڲ�ѯ��
 * LinkedList:�ڲ�������ʵ�֣�������ɾ��
 * 
 * List�ṩ��һЩ�����±����Ԫ�صķ�����
 * @author Administrator
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		List<String> list 
			= new ArrayList<String>();
//		List<String> list 
//			= new LinkedList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		System.out.println(list);
		
		/*
		 * E get(int index)
		 * ��ȡָ���±�λ�ö�Ӧ��Ԫ��
		 */
		String str = list.get(1);
		System.out.println(str);
		
		for(int i=0;i<list.size();i++){
			str = list.get(i);
			System.out.println(str);
		}
		
		/*
		 * E set(int index,E e)
		 * ��������Ԫ�����õ�������λ���ϣ�
		 * ����ֵΪԭλ���ϵ�Ԫ�ء�
		 * �������滻Ԫ�ز�����
		 */
		//[one,two,three,four]
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+old);
	}
}








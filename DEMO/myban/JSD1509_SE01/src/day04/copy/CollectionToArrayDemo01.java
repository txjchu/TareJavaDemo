package day04.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * ����ת��Ϊ����
 * ����Collection�ṩ��һ������toArray(arr)�����Խ���ǰ����ת��Ϊһ�����顣
 * 
 * @author Administrator
 *
 */
public class CollectionToArrayDemo01 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);//[one, two, three, four]
		
		/*
		 * ���ڷ��ص��Ƕ������飬����ʹ�����������㡣
		 */
//		Object[] array = c.toArray();
		/*
		 * <T>T[] toArray(T[] a)
		 * ��������������Դ��¼����е�����Ԫ�أ���ʹ�ø��������飬���治�£���ᴴ��һ��ͬ�������顣
		 */
		String[] array = c.toArray(new String[c.size()]);
		for(String str : array){//ʹ����ǿforѭ����������
			System.out.println(str);
		}
		System.out.println(Arrays.toString(array));//�ܹ��ɹ����������toString������[one, two, three, four]
	}
}














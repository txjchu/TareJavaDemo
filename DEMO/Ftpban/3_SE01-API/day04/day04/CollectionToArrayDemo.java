package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ����ת��Ϊ����
 * ����Collection�ṩ��һ������toArray()
 * ���Խ���ǰ����ת��Ϊһ������
 * @author Administrator
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c
			= new ArrayList<String>();
		
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		/*
		 * ���ڷ��ص��Ƕ������飬����ʹ������
		 * ������
		 */
//		Object[] array = c.toArray();
		/*
		 * ��������������Դ��¼���������Ԫ�أ���
		 * ʹ�ø��������飬���治�£��ᴴ��һ��ͬ
		 * �������顣
		 */
		String[] array
			= c.toArray(new String[c.size()]);
		for(String str : array){
			System.out.println(str);
		}
		
		
	}
}








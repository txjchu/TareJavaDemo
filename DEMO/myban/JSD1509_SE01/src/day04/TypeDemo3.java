package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * �����ڼ����е�Ӧ����Լ��������Ԫ�ص����͵ġ�
 * @author Administrator
 *
 */
public class TypeDemo3 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		/*
		 * �������ķ�����������ļ��ϵķ�������һ�¼���
		 */
		Iterator<String> it=c.iterator();
		while(it.hasNext()){
			String str=it.next();
			System.out.println(str);
		}
		
		for(String str :c){
			System.out.println(str);
		}
	}
}
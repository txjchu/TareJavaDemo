package day03;

import homework02.Emp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���ϴ�ŵ���Ԫ�ص�����
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Emp e = new Emp("����",25,"��",5000);
		c.add(e);
		
		System.out.println(c);
		
		e.setName("����");
		
		System.out.println(c);
		
	}
}





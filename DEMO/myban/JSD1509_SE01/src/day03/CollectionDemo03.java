package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * �����д�ŵ���Ԫ�ص����á�
 * @author Administrator
 *
 */
public class CollectionDemo03 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Emp e = new Emp("����", 26, "��", 5000);
		c.add(e);
		System.out.println(c);//[����,26,��,5000.0,]
		
		e.setName("����");
		System.out.println(c);//[����,26,��,5000.0,]
		
		Collection<Emp> cc = new ArrayList();
		c.add(e);
		System.out.println(c);
		System.out.println(c.size());
		int i = 3;
		c.add(i);
		System.out.println(c);
		int size = c.size();
		System.out.println(size);
	}
}














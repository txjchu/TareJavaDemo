package day04;

import homework02.Emp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ɾ������Ԫ��
 * boolean remove(E e)
 * �Ӽ�����ɾ������Ԫ�ء�
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Emp("����",22,"��",5000));
		c.add(new Emp("����",23,"Ů",6000));
		c.add(new Emp("����",24,"��",7000));
		c.add(new Emp("����",25,"Ů",8000));
		c.add(new Emp("����",22,"��",5000));
		
		System.out.println(c);
		
		Emp e = new Emp("����",22,"��",5000);
		/*
		 * �÷�����ɾ�������е�һ�������Ԫ��equals
		 * �Ƚ�Ϊtrue��Ԫ�ء����Ժ���������equals
		 * �Ƚ�Ϊtrue��Ԫ���ǲ���ɾ���ġ� 
		 */
		c.remove(e);
		
		System.out.println(c);
		
		
	}
}





package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * �жϼ������Ƿ��и���Ԫ��
 * 
 * boolean contains(E e)
 * �����жϸ���Ԫ���Ƿ񱻰��������ݸ���Ԫ���뼯������Ԫ���Ƿ����equals�Ƚ�Ϊtrue�������
 * ������Ϊ������
 *  
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		
		Emp e1=new Emp("����",25,"��",5000);
		c.add(e1);
		c.add(new Emp("����",24,"Ů",8000));
		c.add(new Emp("����",26,"��",9000));
		
		System.out.println(c);
		
		Emp e2=new Emp("����",25,"��",5000);
		
		System.out.println(e1==e2);
		/*
		 * ��Ϊe2�뼯���е�һ��Ԫ�أ�Ҳ����e1��equals�Ƚ�Ϊtrue��
		 * ���Լ�����Ϊ����e2
		 */
		boolean contains=c.contains(e2);
		System.out.println("������"+contains);
		
		
		
	}
}

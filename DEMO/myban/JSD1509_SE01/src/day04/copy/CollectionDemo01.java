package day04.copy;

import java.util.ArrayList;
import java.util.Collection;

import day03.Emp;

/**
 * ɾ������Ԫ��
 * boolean remove(E e)
 * �Ӽ�����ɾ������Ԫ�ء�
 * @author Administrator
 *
 */
public class CollectionDemo01 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Emp("����", 22, "��", 5000));
		c.add(new Emp("����", 23, "Ů", 6000));
		c.add(new Emp("����", 24, "��", 7000));
		c.add(new Emp("����", 25, "Ů", 8000));
		c.add(new Emp("����", 22, "��", 5000));
		
		System.out.println(c);
		//[����,22,��,5000.0,, ����,23,Ů,6000.0,, ����,24,��,7000.0,, ����,25,Ů,8000.0,, ����,22,��,5000.0,]
		Emp e = new Emp("����", 22, "��", 5000);
		/*
		 * �÷�����ɾ�������е�һ�����ϸ���Ԫ��equals�Ƚ�Ϊtrue��Ԫ�ء����Ժ���������equals�Ƚ�
		 * Ϊtrue��Ԫ���ǲ���ɾ���ġ�
		 */
		c.remove(e);
		System.out.println(c);
		//[����,23,Ů,6000.0,, ����,24,��,7000.0,, ����,25,Ů,8000.0,, ����,22,��,5000.0,]
	}
}
















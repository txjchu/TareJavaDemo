package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ʹ����ѭ����������
 * @author Administrator
 *
 */
public class NewFor2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		
		/*
		 * ��ѭ�������µ��﷨����ѭ���Ǳ������Ͽɵ�
		 * �����������
		 * �������ڱ���Դ����ʱ������ʹ����ѭ������
		 * ����ʱ���Ὣ����ı�Ϊʹ�õ�������
		 * ������ѭ���������Ͼ��ǵ�������������,
		 * �ǾͲ�Ҫ�ڱ������ϵĹ�����ͨ�����ϵķ���
		 * ɾ��Ԫ�ء�
		 */
		for(Object o:c){
//		Iterator it = c.iterator();
//		while(it.hasNext()){
//			Object o = it.next();
			String str = (String)o;
			if("#".equals(str)){
				c.remove(str);
			}
		}
		System.out.println(c);
	}
}


package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ʹ����ѭ����������
 * 
 * @author Administrator
 *
 */
public class NewFor2 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		
		/*
		 * ��ѭ�������µķ�������ѭ���Ǳ������Ͽɵģ������������
		 * �������ڱ���Դ����ʱ������ʹ����ѭ����������ʱ���Ὣ����ı�Ϊʹ�õ�������
		 * ������ѭ���������Ͼ��ǵ������������ϣ�
		 * �ǾͲ�Ҫ�ڱ������ϵĹ�����ͨ�����ϵķ���ɾ��Ԫ�ء�
		 * 
		 * ���Ҫɾ��Ԫ�أ����Լ�д����
		 */
		for(Object o:c){
//		Iterator it=c.iterator();
//		while(it.hasNext()){
//			Object o=it.next();
		
			String str=(String)o;
//			if("#".equals(str)){
//				c.remove(str);
//			}			
		}		
		System.out.println(c);
	}
}



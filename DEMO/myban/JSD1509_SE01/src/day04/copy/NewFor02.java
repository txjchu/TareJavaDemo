package day04.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ʹ����ѭ����������========??????????�Լ�дɾ������
 * @author Administrator
 *
 */
public class NewFor02 {
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
		 * ��ѭ�������µ��﷨����ѭ���Ǳ������Ͽɵģ������������
		 * �������ڱ���Դ����ʱ��������ʹ����ѭ����������ʱ���Ὣ����ı�Ϊʹ�õ�������
		 * ������ѭ���������Ͼ��ǵ������������ϣ��ǾͲ�Ҫ�ڱ������ϵĹ�����ͨ�����ϵķ���ɾ��Ԫ�ء�
		 * 
		 * ���Ҫɾ��Ԫ�أ����Լ�д������
		 */
		for(Object o : c){
//			Iterator it = c.iterator();
//			while(it.hasNext()){
//				Object o = it.next();
				String str = (String) o;
				if("#".equals(str)){
				
					c.remove(str);//��ʹ�õ�������������ʱ������ʹ�ü��ϵ�remove()�����������쳣��
				
//					it.remove();//ʹ�õ�������remove()����ɾ��Ԫ��
				}
//			}
		}
		System.out.println(c);	
	}
}

















package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ��������Ԫ��
 * 
 * �����ṩ��һ������
 * Iterator iterator()
 * �÷������ȡһ�����Ա�����ǰ����Ԫ�صĵ�������Ȼ��ͨ�������õ������ﵽ��ȡ
 * ��������Ԫ�ص�Ŀ�ġ�
 * 
 * Iterator��һ���ӿڣ��ṩ�˱���������
 * ʹ�õ�������������Ԫ����Ҫ��ѭ��
 * �ʣ�ȡ��ɾ��ԭ������ɾ��Ԫ�ز��Ǳ��������
 * 
 * ��ͬ�ļ���ʵ���඼�ṩ�����ڱ�������ĵ�����ʵ����
 * ���������סÿһ��ʵ��������֣�ֻ�����ǵ���Iterator�������ɡ�
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		
		Iterator it=c.iterator();
		/*
		 * boolean hasNext()
		 * �жϼ������Ƿ�����һ��Ԫ��
		 */
		
		while(it.hasNext()){
			/*
			 * E next()
			 * ȡ����һ��Ԫ��
			 */
			String str=(String)it.next();
			//ɾ�����е�#
			/*
			 * ���ж�һ���ַ���������ֵ�Ƿ���һ��������ֵ��ͬʱ��Ӧ��ʹ����������equals����
			 * ������Ƚϣ������Ͳ���������ָ���쳣��
			 */
			if("#".equals(str)){
				/*
				 * ��ʹ�õ�������������ʱ����Ҫʹ�ü��ϵķ����޸�Ԫ��������
				 * ������������쳣��
				 * add()��remove()--ɾ����
				 */
				//c.remove(str);
				/*
				 * �������ṩ��remove����������ɾ�������е�Ԫ�أ���ɾ��������ͨ��next����
				 * ȡ������Ԫ�ء�
				 * ����һ��next���ܵ���һ��remove.
				 */
				it.remove();//-----û�в����ķ�����				
			}			
			//System.out.println(c);//---Ҫ��ѭ�����棬���������Ļ��ͻ������Ρ�
		}	
		System.out.println(c);	
	}
}

package day04.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * ���ϵ�������
 * @author Administrator
 *
 */
public class CollectionDemo02 {
	public static void main(String[] args) {
		//HashSet��Set���ϵ�ʵ���ࡣ
//		Collection c1 = new HashSet();//�����ظ�����
		Collection c1 = new ArrayList();
		c1.add("cpp");
		c1.add("java");
		c1.add("php");
		
		Collection c2 = new ArrayList();
		c2.add("c#");
		c2.add("oc");
		c2.add("java");
		/*
		 * ��c2Ԫ��ȫ����ӵ�c1��:
		 * boolean addAll(Collection c)
		 * �÷����������ǽ����������е�����Ԫ����ӵ���ǰ�����У�ֻҪ��ǰ���ϵ�Ԫ�ظ��������˸ı䣬�ͷ���true��
		 */
		c1.addAll(c2);
		System.out.println(c1);//[cpp, java, php, c#, oc, java]
		
		Collection c3 = new ArrayList();
		/*
		 * boolean containsAll(Collection c)
		 * �жϵ�ǰ�������Ƿ�������������е�����Ԫ�ء�ȫ�������򷵻�true���жϰ�����Ȼ����������Ԫ�ص�equals�����ıȽϽ����
		 */
		c3.add("php");
		c3.add("c#");
//		c3.add("c");
		System.out.println(c3);//[php, c#]
		boolean contains = c1.containsAll(c3);
		System.out.println("�Ƿ�ȫ������"+ contains);//�Ƿ�ȫ������true
	}
}





















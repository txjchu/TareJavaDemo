package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * ���ϵ���������������������
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		
		//HashSet��һ��Set���ϵ�ʵ����
		//Collection c1=new HashSet();
		Collection c1=new HashSet();
		//Collection c1=new ArrayList();
		c1.add("cpp");		//==c++	==	c plas p
		c1.add("java");
		c1.add("php");
		
		Collection c2=new ArrayList();
		c2.add("c#");
		c2.add("oc");
		c2.add("java");
		
		/*
		 * ��c2��Ԫ��ȫ���ŵ�c1��
		 * boolean addAll(Collection c)
		 * �÷����������ǽ����������е�����Ԫ����ӵ���ǰ�����У�ֻҪ��ǰ���ϵ�Ԫ�ظ���
		 * �����˸ı䣬�ͻ᷵��true��     //------��Ҫ���HashSet�����ظ�Ԫ�أ�
		 */
		c1.addAll(c2);
		System.out.println(c1);
		
		Collection c3=new ArrayList();
		/*
		 * boolean containsAll(Collection c)
		 * �жϵ�ǰ�������Ƿ�������������е�����Ԫ�ء�ȫ�������򷵻�true��
		 * ������Ȼ����������Ԫ�ص�equals�����ıȽϽ����
		 */
		c3.add("php");
		c3.add("c#");
//		c3.add("c");
		
		boolean contains=c1.containsAll(c3);
		System.out.println("c3����c1�Ƿ�ȫ������"+contains);
		
	}
}

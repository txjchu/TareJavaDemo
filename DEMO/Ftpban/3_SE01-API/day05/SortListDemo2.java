package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * �������Զ���Ԫ�ص�List����
 * @author Administrator
 *
 */
public class SortListDemo2 {
	public static void main(String[] args) {
		List<Point> list
			= new ArrayList<Point>();
		
		list.add(new Point(7,5));
		list.add(new Point(2,3));
		list.add(new Point(1,2));
		list.add(new Point(4,9));
		list.add(new Point(8,6));
		
		System.out.println(list);
		/*
		 * ��ϣ��ʹ��Collections��sort����
		 * ����List�е�Ԫ�ر���ʵ����Comparable
		 * �ӿڡ��ýӿڱ����������ǿ��ԱȽϴ�С�ġ�
		 * java�ṩ�����඼ʵ���˸ýӿڡ�
		 * ����:
		 * Integer,Double,String�ȵȡ�
		 */
		Collections.sort(list);
		
		System.out.println(list);
		
	}
}




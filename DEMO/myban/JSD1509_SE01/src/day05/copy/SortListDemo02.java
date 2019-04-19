package day05.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * �������Զ���Ԫ�ص�List���ϡ�
 * @author Administrator
 *
 */
public class SortListDemo02 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(7, 5));
		list.add(new Point(2, 3));
		list.add(new Point(8, 6));
		list.add(new Point(1, 2));
		list.add(new Point(4, 9));
		System.out.println(list);//[7,5, 2,3, 8,6, 1,2, 4,9]
		/*
		 * ��ϣ��ʹ��Collections��sort��������List�е�Ԫ�ر���ʵ����Comparable�ӿڡ�
		 * �ýӿڱ����������ǿ��ԱȽϴ�С�ġ�
		 * java�ṩ����������ʵ���˸ýӿڡ����磺Integer,Double,String�ȡ�
		 */
		Collections.sort(list);
		System.out.println(list);//[1,2, 2,3, 7,5, 4,9, 8,6]
		
	}
}















package day04.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����ת��Ϊ����
 * ֻ��ת��ΪList���ϣ���ΪSet�����в��ܴ���ظ�Ԫ�ء�
 * ת����������Ĺ�����Arrays�ṩ�ľ�̬������
 * asList()
 * @author Administrator
 *
 */
public class ArrayToListDemo01 {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three", "four"};
		List<String> list = Arrays.asList(array);//������ת��Ϊ����
		System.out.println(list);//[one, two, three, four]
		
		list.set(0, "1");
		System.out.println(list);//[1, two, three, four]
		
		//�鿴ԭ�������е�����
		for(String str : array){
			System.out.println(str);
		}
		/*
		 * �޸ļ����е�����Ԫ�أ��͵����޸���ԭ�����ж�Ӧ��Ԫ�أ����ǲ��ܶԼ��Ͻ�����ɾ������
		 * ���������Ԫ�أ���Ҫ����һ���¼��ϡ�
		 */
//		list.add("five");//���׳��쳣
		/*
		 * ���ƹ�����
		 * �ù��췽���ڴ������ϵ�ͬʱ���Ὣ�����ļ����е�����Ԫ�ش��뵽��ǰ�����У����Ծ��൱�ڸ�����һ�����ϡ�
		 */
		List<String> list1 = new ArrayList<String>(list);
		System.out.println(list1);//[1, two, three, four]
		list1.add("five");
		System.out.println(list1);//[1, two, three, four, five]
		
	}
}



















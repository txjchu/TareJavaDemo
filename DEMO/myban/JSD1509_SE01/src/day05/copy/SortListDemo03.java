package day05.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ���򼯺�
 * @author Administrator
 *
 */
public class SortListDemo03 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("terry");
		list.add("tom");
		list.add("allen");
		list.add("smith");
		list.add("jarry");
		list.add("Ada");
		list.add("Jack");
		System.out.println(list);//[terry, tom, allen, smith, jarry, Ada, Jack]
		Collections.sort(list);
		System.out.println(list);//[Ada, Jack, allen, jarry, smith, terry, tom]
		
		/*
		 * �ַ����ıȽϷ�ʽ�ǰ��յ�һ���ַ��ı����С�����˳�����У���һ���ַ���һ������Ƚϵڶ����ַ����Դ����ơ�
		 */
		List<String> list1 = new ArrayList<String>();
		list1.add("����ʦ");
		list1.add("С����ʦ");
		list1.add("����ʦ");
		list1.add("");
		list1.add("");
		list1.add("");
		list1.add("");
		/*
		 * ϣ�������ַ���Ĵ��ַ��ٵ�С����
		 */
		System.out.println(list1);//[����ʦ, С����ʦ, ����ʦ, , , , ]
		//�ַ�������ıȽϴ�С�������������������
		Collections.sort(list1);
		System.out.println(list1);//[, , , , С����ʦ, ����ʦ, ����ʦ]
		
		//ʹ���Զ���ıȽϹ���
		MyComparator com = new MyComparator();
		/*
		 * ���ص�sort�����������Ǵ���һ���Ƚ�����Ȼ���ձȽ����ıȽϴ�С��ʽ���������е�Ԫ�ذ��մ�С�����˳������
		 * ���Ҹ÷�����Ҫ�󼯺�Ԫ�ر���ʵ��Comparable�ӿڣ���Ϊ�����õ���	 
		 */
		
		Collections.sort(list1, com);
		System.out.println(list1);//[, , , , ����ʦ, ����ʦ, С����ʦ]
	}
}

/**
 * Ϊ�ַ����������ıȽϹ���
 * �Զ���Ƚ�����Ҫʵ��Comparator�ӿڡ�
 */
class MyComparator implements Comparator<String>{
	/*
	 * �Զ����ַ����ıȽϹ���
	 * ����ֵ��Comparable��comparaTo����һ�¡�
	 */
	public int compare(String o1, String o2){
		return o1.length() - o2.length();
	}
}
















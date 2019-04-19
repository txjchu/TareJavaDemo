package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ���򼯺�
 * @author Administrator
 *
 */
public class SortListDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("terry");
		list.add("tom");
		list.add("allen");
		list.add("smith");
		list.add("jarry");
		list.add("Ada");
		list.add("Jack");
		
		System.out.println(list);
		
		Collections.sort(list);
		
		System.out.println(list);
		/*
		 * �ַ����ıȽϷ�ʽ�ǰ��յ�һ���ַ��ı����С�����˳�����У���һ����һ��
		 * �򿴵ڶ������Դ����ơ�A-65 a-97 
		 */
		List<String> list1 = new ArrayList<String>();
		
		list1.add("����ʦ");
		list1.add("С����ʦ");
		list1.add("����ʦ");
		/**
		 * ������ϣ�������ַ���Ĵ��ַ��ٵ�С����
		 */
		System.out.println(list1);
		//�ַ�������ıȽϴ�С����������������
		Collections.sort(list1);		
		System.out.println(list1);
		
		//���Զ���ıȽϹ���
		MyComparator com=new MyComparator();
		/*
		 * ���ص�sort�����������Ǵ���һ���Ƚ�����
		 * Ȼ���ձȽ����ıȽϴ�С��ʽ���������е�Ԫ�ذ��մ�С�����˳�����У�
		 * ���Ҹ÷�����Ҫ�󼯺�Ԫ�ر���ʵ��Comparable�ӿڣ���Ϊ�����õ���
		 */
		Collections.sort(list1,com);
		
		System.out.println(list1);
	}
}
/**
 * Ϊ�ַ����������ıȽϹ���
 * �Զ���Ƚ�����Ҫʵ��Comparator�ӿ�
 * @author Administrator
 *
 */
class MyComparator implements Comparator<String>{
	/**
	 * �Զ����ַ����ıȽϹ���
	 * ����ֵ��Comparable��comparaTo����һ�¡�
	 * ����ֵ>0��o1��o2��
	 * ����ֵ<0��o1��o2С
	 * ����ֵ=0��o1��o2��ȡ�
	 * @param o1
	 * @param o2
	 * @return
	 */
	public int compare(String o1,String o2){
	
		return o1.length()-o2.length();
	}
}





package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����ת��Ϊ����
 * ֻ��ת��ΪList���ϣ���ΪSet�����в��ܴ���ظ�
 * Ԫ�ء�
 * ת����������Ĺ�����Arrays�ṩ�ľ�̬����:
 * asList()
 * @author Administrator
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array 
			= {"one","two","three","four"};
		
		List<String> list
			= Arrays.asList(array);
		
		System.out.println(list);
		
		list.set(0, "1");
		System.out.println(list);
		
		//�鿴ԭ����������
		for(String str : array){
			System.out.println(str);
		}
		/*
		 * �޸ļ���������Ԫ�أ��͵����޸���
		 * ԭ�����ж�Ӧ��Ԫ�ء����ǲ��ܶԼ���
		 * ������ɾ������
		 * ����������Ԫ�أ���Ҫ����һ���¼���
		 */
//		list.add("five");
		/*
		 * ���ƹ�����
		 * �ù��췽���ڴ������ϵ�ͬʱ�Ὣ�����ļ���
		 * ������Ԫ�ش��뵱ǰ�����С����Ծ��൱��
		 * ������һ�����ϡ�
		 */
		List<String> list1
			= new ArrayList<String>(list);
		
		System.out.println(list1);
		list1.add("five");
		System.out.println(list1);
	}
}





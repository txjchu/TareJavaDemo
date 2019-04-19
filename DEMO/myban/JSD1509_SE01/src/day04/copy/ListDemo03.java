package day04.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * List subList(int start, int end)
 * ��ȡ��ǰ���ϵ��Ӽ�
 * @author Administrator
 *
 */
public class ListDemo03 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i ++){
			list.add(i);
		}
		System.out.println(list);//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		//ȡ��3-7
		List<Integer> subList = list.subList(3, 8);
		System.out.println(subList);//[3, 4, 5, 6, 7]
		
		/*
		 * ���Ӽ���ÿ��Ԫ������10��
		 */
		for(int i = 0; i < subList.size(); i ++){
			int n = subList.get(i);
			n = n * 10;
			subList.set(i, n);
		}
		System.out.println(subList);//[30, 40, 50, 60, 70]
		/*
		 * ���Ӽ��ϵĲ�����Ӱ��ԭ���϶�Ӧ��Ԫ��
		 */
		System.out.println(list);//[0, 1, 2, 30, 40, 50, 60, 70, 8, 9]
		list.subList(2, 3).clear();//��ȡ�Ӽ��ϣ���ɾ��
		System.out.println(list);//[0, 1, 30, 40, 50, 60, 70, 8, 9]
	}
}











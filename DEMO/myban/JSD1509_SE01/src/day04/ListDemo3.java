package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List subList(int start,int end)
 * ��ȡ��ǰ�ַ������Ӽ���
 * 
 * @author Administrator
 *
 */
public class ListDemo3 {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<10;i++){
			list.add(i);
		}
		//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println(list);
		
		//ȡ��3-7
		List<Integer> subList=list.subList(3,8);//-----��ͷ����β
		System.out.println(subList);
		
		/*
		 * ���Ӽ���ÿ��Ԫ������10��
		 */
		for(int i=0;i<subList.size();i++){
			int n=subList.get(i);
			n=n*10;
			subList.set(i,n);//����д��һ�䣺subList.set(i,subList.get(i)*10);
//			subList.set(i,subList.get(i)*10);
		}
		System.out.println(subList);
		
		/*
		 * ���Ӽ��Ĳ�����Ӱ��ԭ���϶�Ӧ��Ԫ�ء����
		 */
		System.out.println(list);
		
		//��3-7�Ӽ�����ɾ��
		list.subList(3,8).clear();//----ɾ���Ӽ���ԭ����Ҳɾ����ӦԪ��
		System.out.println(list);
		
	}
}

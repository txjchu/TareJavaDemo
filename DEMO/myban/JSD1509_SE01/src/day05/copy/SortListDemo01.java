package day05.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * ���ϵ�����
 * ����һ��������Ҫʹ�ü��ϵĹ�����Collections.���ṩ��һ����̬����sort()�������������򼯺ϡ�
 * ��Ҫע����ǣ�����ֻ������List���ϣ���ΪSet���ϵ�ʵ�ֲ���������ġ�
 * @author Administrator
 *
 */
public class SortListDemo01 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random ran = new Random();
		for(int i = 0; i < 10; i ++){
			list.add(ran.nextInt(100));
		}
		//��׮
		System.out.println(list);
		/*
		 * ��Ȼ���򣬴�С�����˳���������С�
		 */
		Collections.sort(list);//[6, 4, 68, 96, 53, 29, 17, 15, 94, 59]
		System.out.println(list);//[4, 6, 15, 17, 29, 53, 59, 68, 94, 96]
	}
}














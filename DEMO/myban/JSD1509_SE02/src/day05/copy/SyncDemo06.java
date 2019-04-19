package day05.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ͨ��Collections���Խ����м��ϻ�Mapת��Ϊ�̰߳�ȫ�ġ�
 * @author Administrator
 *
 */
public class SyncDemo06 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);		
		/*
		 * ������List����ת��Ϊ�̰߳�ȫ�ģ�����List������һ���̰߳�ȫ�ģ����Ұ���ԭ�����е�����Ԫ�ء�
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		//HashSetҲ�����̰߳�ȫ��
		Set<String> set = new HashSet<String>(list);
									//���ƹ���������List���Ϸ���Set���캯���У���List�е�����Ҳ�����ƽ�Set.
		System.out.println(set);
		//��������Set����ת��Ϊһ���̰߳�ȫ��
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		//HashMapҲ�����̰߳�ȫ��
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("����", 99);
		map.put("��ѧ", 98);
		//ת��Ϊ�̰߳�ȫ��Map
		map = Collections.synchronizedMap(map);
		System.out.println(map);
		
	}
}















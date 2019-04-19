package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * ����Map
 * ����Map�����ַ�ʽ��
 * 1.�������е�key
 * 2.����ÿһ��key-value��
 * 3.��������value(��Բ�����)
 * @author Administrator
 *
 */
public class MapDemo3 {
	public static void main(String[] args) {
		
		/**
		 * HashMap������˳��put��ȥ��˳�����������ʱ��˳��һ�¡�
		 * ��ϣ��˳��һ�£�����ʹ��LinkedHashMap
		 * ���ڲ�ʹ����һ��LinkedList��¼��˳��
		 */
		Map<String,Integer> map=new LinkedHashMap<String,Integer>();
//		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("����",99);
		map.put("��ѧ",98);
		map.put("Ӣ��",97);
		map.put("����",96);
		map.put("��ѧ",95);
		
		System.out.println(map);
		/*
		 * �������е�key
		 * 
		 * Set<K> keySet()
		 * �÷����Ὣ��ǰMap�����е�key����һ��Set�����У�
		 * ���Ա������صļ��ϼ����ڱ��������е�key��
		 */
		
		Set<String> keySet=map.keySet();
		
		for(String key : keySet){				//----
			System.out.println("key:"+key);
		}
		
//		Iterator<String> it=keySet.iterator();	//-----����������
//		while(it.hasNext()){		
//			String str=it.next();
//			System.out.println(str);
//		}
		/*
		 * ����ÿһ���ֵ��
		 * Map��ÿһ���ֵ��ʹ��һ��Entry��ʵ�����棬Entry�ṩ��������ȡ���ʾ
		 * ��ֵ�Եķ���getKey,getValue
		 * Set<Entry>  entrySet()
		 * �÷����ὫMap��ÿһ���ֵ�ԣ�����Entryʵ��������һ������Ȼ�󷵻ء�
		 * 
		 * EntryҲ֧���������ͣ��ֱ��ʾkey��value�����ͣ�ֻҪ���Ӧ��Map�ķ���һ�¼��ɡ�
		 */
		
		Set<Entry<String,Integer>> entrySet=map.entrySet();
		
		for(Entry<String,Integer> entry : entrySet){
			String key=entry.getKey();
			Integer value=entry.getValue();
			System.out.println(key+":"+value);
		}
		/*
		 * �������е�value
		 * Collection<V> values()
		 * �÷����Ὣ��ǰMap�����е�value����һ�����Ϻ󷵻أ�֮���Է��صĲ���Set���ϣ�
		 * ����Ϊvalue�����ظ���
		 */
		Collection<Integer> values=map.values();
		
		for(Integer value : values){
			Integer values1=value;
			System.out.println("values:"+values1);
		}
	
		
	}
}

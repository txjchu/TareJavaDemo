package day05.copy;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * ����Map	���ַ�ʽ��
 * 1.�������е�key
 * 2.����ÿһ��key-value��
 * 3.�������е�value(��Բ�����)
 * @author Administrator
 *
 */
public class MapDemo03 {
	public static void main(String[] args) {
		/*
		 * HashMap������˳��put��ȥ��˳�������������˳��һ�¡�
		 * ��ϣ��˳��һ�£�����ʹ��LinkedHashMap�����ڲ�ʹ����һ��LinkedList��¼��˳��
		 */
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("����", 99);
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 95);
		/*
		 * �������е�key
		 * 
		 * Set<K> keySet()
		 * �÷����Ὣ��ǰMap�����е�key����һ��Set�����У����Ա������صļ��ϼ����ڱ��������е�key��
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+ key);
		}
		/*
		 * ����ÿһ���ֵ��
		 * Map��ÿһ���ֵ��ʹ��һ��Entry��ʵ�����棬Entry�ṩ��������ȡ���ʾ�ļ�ֵ�Եķ�����
		 * getKey(),getValue()
		 * Set<Entry>  entrySet()
		 * �÷����ὫMap��ÿһ���ֵ�ԣ�����Entryʵ�����󣩴���һ�����ϲ����ء�
		 * EntryҲ֧��˫���ͣ��ֱ��ʾkey��value�����ͣ�ֻҪ���Ӧ��Map�ķ���һ�¼��ɡ�
		 */
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		for(Entry<String, Integer> entry : entrySet){
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key +":"+ value);
		}
		
		/*
		 * �������е�value
		 * Collection<V>  vlaues()
		 * �÷����Ὣ��ǰMap�����е�value����һ�����Ϻ󷵻ء�֮���Է��صĲ���Set���ϣ�����Ϊvalue�ǿ����ظ��ġ�
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println("values:"+ value);
		}
		
	}
}



















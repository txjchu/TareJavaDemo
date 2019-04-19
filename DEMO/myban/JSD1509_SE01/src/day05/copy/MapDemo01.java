package day05.copy;

import java.util.HashMap;
import java.util.Map;

/**
 * Map �ֽв��ұ�
 * ��key-value �Ե���ʽ�洢���ݡ�
 * MapҪ��key�������ظ����Ƿ��ظ�����equals�ȽϽ��������
 * ���õ�ʵ���ࣺ
 * HashMap(����ɢ�б�)��ʹ��ɢ���㷨ʵ�֣���ѯ�ٶȿ죬 �ڴ����������м�����ʱʹ���������롣
 * @author Administrator
 *
 */
public class MapDemo01 {
	public static void main(String[] args) {
		//����java.util����
		Map<String, Integer> map = new HashMap<String,Integer>();
		/*
		 * V put(K k, V v)
		 * ��������key��value����Map�С�
		 * ��������key��Map���Ѿ����ڣ������滻value���������滻��value���ء����������򷵻�ֵΪNULL��
		 * ���շ���ֵʱ����value�ǰ�װ��Ļ���ע�����ʱ������Ӧ��Ҳ�ð�װ�࣬��Ҫ�û������͡�
		 * ��Ϊ��������key�����ڣ�����ֵ��ΪNull���û������ͽ��������Ϊ�Զ���װ��������ָ���쳣��
		 */
		Integer old = map.put("����", 99);
		System.out.println("old:"+ old);//old:null
		
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 95);
		
		System.out.println(map);//{����=96, ����=99, Ӣ��=97, ��ѧ=98, ��ѧ=95}
		old = map.put("����", 88);//����"����"���key�Ѿ����ڣ��������滻value
		System.out.println(map);//{����=96, ����=88, Ӣ��=97, ��ѧ=98, ��ѧ=95}
		System.out.println("old:"+ old);//old:99
		
		/*
		 * V get(K k)
		 * ���ݸ�����key��ȡ��Ӧ��value����������key�����ڣ���᷵��null.
		 */
		Integer value = map.get("��ѧ");
		System.out.println("��ѧ��"+ value);//��ѧ��98
		
		value = map.get("����");
		System.out.println("������"+ value);//������null
		
		/*
		 * V remove(K k)
		 * ��������Key��Ӧ��������¼ɾ��������ֵΪ������¼�е�value��
		 */
		System.out.println("ɾ��Map��Ӣ��....");
		old = map.remove("Ӣ��");
		System.out.println("old:"+ old);
		System.out.println(map);
		
		boolean contains = map.containsKey("��ѧ");
		System.out.println(contains);//true
	}
}

















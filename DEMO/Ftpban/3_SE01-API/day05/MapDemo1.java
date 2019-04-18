package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * Map �ֽ������ұ�
 * ��key-value�Ե���ʽ�洢���ݡ�
 * MapҪ��key�������ظ����Ƿ��ظ�����equals�ȽϽ������
 * ���õ�ʵ����:
 * HashMap(����ɢ�б�):ʹ��ɢ���㷨ʵ�֣���ѯ�ٶȿ죬
 * �ڴ����������м�����ʱʹ���������롣
 * 
 * @author Administrator
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		/*
		 * ������java.util����
		 */
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		/*
		 * V put(K k,V v)
		 * ��������key��value����Map�С�
		 * ��������key��Map�д��������滻value��
		 * ���Ὣ���滻��value���ء����������򷵻�
		 * ֵΪNULL��
		 * ���շ���ֵʱ����value�ǰ�װ��Ļ���ע��
		 * ����ʱ������Ӧ��Ҳ�ð�װ�࣬��Ҫ�û�������
		 * ��Ϊ��������key�����ڣ��ǲ�����value���滻
		 * �ģ�����ֵ��Ϊnull,�������Զ���������
		 * ��ָ���쳣��
		 */
		Integer old = map.put("����", 99);
		System.out.println("old:"+old);
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 95);
		
		System.out.println(map);
		//����"����"���key�����ˣ��������滻value
		old = map.put("����", 80);
		System.out.println(map);
		System.out.println("old:"+old);
		
		/*
		 * V get(K k)
		 * ���ݸ�����key��ȡ��Ӧ��value.
		 * ��������key�����ڣ��򷵻�ֵΪnull
		 */
		Integer value = map.get("��ѧ");
		System.out.println("��ѧ:"+value);
		
		value = map.get("����");
		System.out.println("����:"+value);
		
		
		/*
		 * V remove(K k)
		 * ��������key��Ӧ��������¼ɾ����
		 * ����ֵΪ������¼�е�value
		 */
		System.out.println("ɾ��Map�е�Ӣ��..");
		old = map.remove("Ӣ��");
		System.out.println("old:"+old);
		System.out.println(map);
		
	}
}






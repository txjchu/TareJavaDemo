package day05.copy;

import java.util.HashMap;
import java.util.Map;

/**
 * Map�ṩ�˿��Բ鿴�Ƿ�����������ݵķ���
 * containsKey()
 * containsValue() 
 * @author Administrator
 *
 */
public class MapDemo02 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("����", 99);
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 95);
		/*
		 * boolean containsKey(K k)
		 * �жϵ�ǰMap���Ƿ����������key
		 * �������ж���׼������key��equals�Ľ��
		 */
		boolean ck = map.containsKey("����");
		System.out.println("key�Ƿ������"+ ck);//key�Ƿ������true
		
		boolean cv = map.containsValue(99);
		System.out.println("value�Ƿ������"+ cv);//value�Ƿ������true
		
	}
}
















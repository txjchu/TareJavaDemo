package day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

//�ڶ���
public class HomeWorkTest {
	public static void main(String[] args) {
	String str="good good study,day day up.";
	str = str.replaceAll("[^a-zA-Z]+", ""); 
	Map<Character,Integer> map=new HashMap<Character,Integer>();
	/*
	 * ���ȴ���һ��Map���ڱ���ÿ���ַ����ֵĴ���
	 * Ȼ��˳��ȡ���ַ�����ÿһ���ַ�
	 * �鿴���ַ���Map����ΪKey�Ƿ���ڣ�
	 * ��������˵����һ��ͳ�ƣ�value����1��������˵��ͳ�ƹ�����valueȡ������1���ٴ��롣
	 */
	for(int i=0;i<str.length();i++){
		char c=str.charAt(i);
		if (map.containsKey(c)){
			map.put(c, map.get(c)+1);
		}else{
			map.put(c, 1);
		}
	}
	System.out.println("ͳ����ϣ�");
	System.out.println(map);
	
	
	
	//��ҵ��6
	/*
	 * ����key����ʽ����Map
	 */
	System.out.println("��������key��ֵ��");
	Set<Character> keySet=map.keySet();
	for(Character key : keySet){
		Integer value=map.get(key);
		System.out.println(key+":"+value);
	}
	/*
	 * ����Entry����ʽ����Map
	 */
	System.out.println("��������Entry");
	Set<Entry<Character,Integer>> entrys=map.entrySet();
	for(Entry<Character,Integer> entry : entrys){
		 System.out.println(entry.getKey() + ":" + entry.getValue());         } 
	}
}

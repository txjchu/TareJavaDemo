package day05.exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * ����
 * @author Administrator
 *
 */
public class CASE {
	
	@Test
	//����1	�ҳ�Map��ÿһ��value�����ֵ��
	public void test1(){
		/*
		 * ͳ�Ƹ������վ�������PM2.5ֵ
		 */
		String pm25 = "ũչ��=423,����=378,��̨��԰=406,��̳=322,����������=398,"
                + "��԰=406,ͨ��=366,��ƽ��=248,������=306,����=231,ǰ��=422,"
                + "���ֵ�=368,�ų�=268,��ƽ��=423,������=267,����=377,ǰ��=299,"
                + "���ֵ�=285,��ˮ��=277,ũչ��=348,����=356,��̨��԰=179,��̳=277,"
                + "����������=270,��԰=268,ͨ��=315";
		String[] strs = pm25.split("[,=]");//ʹ��������ʽ���ַ��������и�
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();//��������map
		for(int i = 0; i < strs.length; i += 2){//�����ַ������飬ÿ��1���±�Ϊ���վ����
			if(!map.containsKey(strs[i]) || Integer.parseInt(strs[i + 1]) > map.get(strs[i])){
				map.put(strs[i], Integer.parseInt(strs[i + 1]));
			}
/*����
			map.put(strs[i], 0);//�����վ������Ϊkey����map��
			for(int j = 1; j < strs.length; j +=2){
				int value = Integer.parseInt(strs[j]);//���ַ����е�����Ԫ��ת��Ϊint����
				if(value > map.get(strs[i])){
					map.put(strs[i], value);
				}
			}
*/			
		}
		System.out.println(map.toString());
			//{ũչ��=423, ����=378, ��̨��԰=406, ��̳=322, ����������=398, ��԰=406, ͨ��=366, ��ƽ��=423, ������=306, ����=377, ǰ��=422, ���ֵ�=368, �ų�=268, ��ˮ��=277}
		
		//����3	ʹ�õ���key�͵���entry���ַ�������map
		Set<String> setKey = map.keySet();//ʹkey����setKey������
		for(String str : setKey){
			System.out.print(str +"="+ map.get(str) +" ");
		}
		System.out.println();
		
		Set<Entry<String, Integer>> setEntry = map.entrySet();//ʹmap��ÿһ��Ԫ�ش���setEntry��
		for(Entry e : setEntry){//����setEntry
			System.out.print(e +" ");
		}
		
	}
	

}
















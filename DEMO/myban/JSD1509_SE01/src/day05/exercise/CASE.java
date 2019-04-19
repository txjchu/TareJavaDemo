package day05.exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * 案例
 * @author Administrator
 *
 */
public class CASE {
	
	@Test
	//案例1	找出Map中每一个value的最高值。
	public void test1(){
		/*
		 * 统计各个监测站检测的最高PM2.5值
		 */
		String pm25 = "农展馆=423,东四=378,丰台花园=406,天坛=322,海淀区万柳=398,"
                + "官园=406,通州=366,昌平镇=248,怀柔镇=306,定陵=231,前门=422,"
                + "永乐店=368,古城=268,昌平镇=423,怀柔镇=267,定陵=377,前门=299,"
                + "永乐店=285,秀水街=277,农展馆=348,东四=356,丰台花园=179,天坛=277,"
                + "海淀区万柳=270,官园=268,通州=315";
		String[] strs = pm25.split("[,=]");//使用正则表达式对字符串进行切割
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();//创建有序map
		for(int i = 0; i < strs.length; i += 2){//遍历字符串数组，每隔1个下标为监测站名称
			if(!map.containsKey(strs[i]) || Integer.parseInt(strs[i + 1]) > map.get(strs[i])){
				map.put(strs[i], Integer.parseInt(strs[i + 1]));
			}
/*错误
			map.put(strs[i], 0);//将监测站地名作为key存入map中
			for(int j = 1; j < strs.length; j +=2){
				int value = Integer.parseInt(strs[j]);//将字符串中的数字元素转换为int类型
				if(value > map.get(strs[i])){
					map.put(strs[i], value);
				}
			}
*/			
		}
		System.out.println(map.toString());
			//{农展馆=423, 东四=378, 丰台花园=406, 天坛=322, 海淀区万柳=398, 官园=406, 通州=366, 昌平镇=423, 怀柔镇=306, 定陵=377, 前门=422, 永乐店=368, 古城=268, 秀水街=277}
		
		//案例3	使用迭代key和迭代entry两种方法遍历map
		Set<String> setKey = map.keySet();//使key存入setKey集合中
		for(String str : setKey){
			System.out.print(str +"="+ map.get(str) +" ");
		}
		System.out.println();
		
		Set<Entry<String, Integer>> setEntry = map.entrySet();//使map中每一个元素存入setEntry中
		for(Entry e : setEntry){//遍历setEntry
			System.out.print(e +" ");
		}
		
	}
	

}
















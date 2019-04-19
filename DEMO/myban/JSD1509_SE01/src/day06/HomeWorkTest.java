package day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

//第二题
public class HomeWorkTest {
	public static void main(String[] args) {
	String str="good good study,day day up.";
	str = str.replaceAll("[^a-zA-Z]+", ""); 
	Map<Character,Integer> map=new HashMap<Character,Integer>();
	/*
	 * 首先创建一个Map用于保存每个字符出现的次数
	 * 然后顺序取出字符串中每一个字符
	 * 查看该字符在Map中作为Key是否存在：
	 * 不存在则说明第一次统计，value存入1，存在则说明统计过，将value取出并加1后再存入。
	 */
	for(int i=0;i<str.length();i++){
		char c=str.charAt(i);
		if (map.containsKey(c)){
			map.put(c, map.get(c)+1);
		}else{
			map.put(c, 1);
		}
	}
	System.out.println("统计完毕！");
	System.out.println(map);
	
	
	
	//作业题6
	/*
	 * 遍历key的形式遍历Map
	 */
	System.out.println("遍历所有key的值：");
	Set<Character> keySet=map.keySet();
	for(Character key : keySet){
		Integer value=map.get(key);
		System.out.println(key+":"+value);
	}
	/*
	 * 遍历Entry的形式遍历Map
	 */
	System.out.println("遍历所有Entry");
	Set<Entry<Character,Integer>> entrys=map.entrySet();
	for(Entry<Character,Integer> entry : entrys){
		 System.out.println(entry.getKey() + ":" + entry.getValue());         } 
	}
}

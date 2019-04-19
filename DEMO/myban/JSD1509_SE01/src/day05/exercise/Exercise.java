package day05.exercise;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 课后作业
 * 
 * @author Administrator
 *
 */
public class Exercise {
//	Map<Character, Integer> map = new HashMap<Character, Integer>();//无须散列表
	Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
	@Before
	//课后题2		计算每个字符出现的次数
	public void Summary(){
		String str = "good good study, day day up.";
		str = str.replaceAll("[^a-zA-Z]+", "");//去除除字母之外的其他字符。
		System.out.println(str);
		for(int i = 0; i < str.length(); i++){
			Character c = str.charAt(i);//获取每一个字符
			Integer count = 1;//用于字符出现次数计数
			if(map.containsKey(c)){
//				Integer value = map.get(c);
//				value ++;
//				map.put(c, value);//将每一个字符与出现的次数作为键值对，存入map中。
				map.put(c, map.get(c) + 1);
			}else{
				map.put(c, count);
				
			}
		}
		System.out.println(map.toString());
				//{g=2, o=4, d=5, s=1, t=1, u=2, y=3, a=2, p=1}
		
/*		
		str = str.trim();//去除空格
		int sum = 0;//用于计算出现的次数
		char c = '.';
		int index = str.indexOf(c);//g第一次出现的下标
		if(index != -1){
			sum ++;
		}
		int a;
		do{
			a = str.indexOf(c, index + 1);
			if(a != -1){
				sum ++;
				index = a; 
			}			
		}while(a != -1);//ture则继续执行do，false则停止。
		System.out.println(c + "在字符串中出现了:"+ sum +"次。");
*/		
	}
	
	@Test
	//习题6	两种方式遍历map
	public void test2(){
		Set<Character> setKey = map.keySet();
		for(Character c : setKey){
			System.out.print(c +"="+ map.get(c) +", ");
		}
		System.out.println();
		Set<Entry<Character, Integer>> entrys = map.entrySet();
		for(Entry<Character, Integer> e : entrys){
			System.out.print(e +", ");
		}
	}
	
	@Test
	//习题8	获取一个文件的大小
	public void testSizeOf() throws IOException{
		File file = new File("demo"+ File.separator +"HelloWorld.txt");
		if(!file.exists()){
//			File dir = new File("demo");
//			dir.mkdir();
			file.createNewFile();
			
		}
		if(file.exists()){
			System.out.println(file +"占字节空间为："+ file.length() +"字节.");
//			long size = FileUtils.sizeOf(file);//?????
//			long size = FileUtils.sizeOf(file);
//			System.out.println(size);
		}
	}
	
	@Test
	//习题9
	public void testSizeOfDir(){
		File dir = new File("src");
		if(dir.exists() && dir.isDirectory()){
			long size = FileUtils.sizeOfDirectory(dir);
			System.out.println(size +"字节");//158322字节
		}
		System.out.println(dir + "占磁盘空间为："+ dir.length() +"字节。");
					//src占磁盘空间为：0字节。 	file.length()方法只能用于文件，不能用于目录。
	}
	
	@Test
	//习题10
	public void testForceMkdir() throws IOException{
		File dirs = new File("a"+ File.separator +"b"+ File.separator +"c");
		if(!dirs.exists()){
			FileUtils.forceMkdir(dirs);
			if(dirs.exists()){
				System.out.println("创建完毕");				
			}
		}else{
			System.out.println("dirs已经存在！删除重建中...");
		}
	}
	
	@Test
	//习题11
	public void testDeleteDir() throws IOException{
		File dir = new File("a");
		if(dir.exists()){
			FileUtils.deleteDirectory(dir);//删除目录（文件夹）
			if(!dir.exists()){
				System.out.println("目录删除成功！");
			}
		}
	}
	
	@Test
	public void testExists(){//检测当前路径是指哪个文件夹----项目根目录指的是src上级目录
		File file = new File(".");//指代根目录
		File[] list = file.listFiles();//获取根目录下的所有文件
		for(File f : list){
			if(f.isDirectory()){
				System.out.println("目录："+ f.toString() +" "+ FileUtils.sizeOfDirectory(f) +"字节");//file对象的toString打印出来的是其路径
			}else{
				System.out.println("文件："+ f.getName() +" "+ f.length() +"字节");//打印出来的是file对象的名称
			}
		}		
	}
}
















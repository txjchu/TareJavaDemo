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
 * �κ���ҵ
 * 
 * @author Administrator
 *
 */
public class Exercise {
//	Map<Character, Integer> map = new HashMap<Character, Integer>();//����ɢ�б�
	Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
	@Before
	//�κ���2		����ÿ���ַ����ֵĴ���
	public void Summary(){
		String str = "good good study, day day up.";
		str = str.replaceAll("[^a-zA-Z]+", "");//ȥ������ĸ֮��������ַ���
		System.out.println(str);
		for(int i = 0; i < str.length(); i++){
			Character c = str.charAt(i);//��ȡÿһ���ַ�
			Integer count = 1;//�����ַ����ִ�������
			if(map.containsKey(c)){
//				Integer value = map.get(c);
//				value ++;
//				map.put(c, value);//��ÿһ���ַ�����ֵĴ�����Ϊ��ֵ�ԣ�����map�С�
				map.put(c, map.get(c) + 1);
			}else{
				map.put(c, count);
				
			}
		}
		System.out.println(map.toString());
				//{g=2, o=4, d=5, s=1, t=1, u=2, y=3, a=2, p=1}
		
/*		
		str = str.trim();//ȥ���ո�
		int sum = 0;//���ڼ�����ֵĴ���
		char c = '.';
		int index = str.indexOf(c);//g��һ�γ��ֵ��±�
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
		}while(a != -1);//ture�����ִ��do��false��ֹͣ��
		System.out.println(c + "���ַ����г�����:"+ sum +"�Ρ�");
*/		
	}
	
	@Test
	//ϰ��6	���ַ�ʽ����map
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
	//ϰ��8	��ȡһ���ļ��Ĵ�С
	public void testSizeOf() throws IOException{
		File file = new File("demo"+ File.separator +"HelloWorld.txt");
		if(!file.exists()){
//			File dir = new File("demo");
//			dir.mkdir();
			file.createNewFile();
			
		}
		if(file.exists()){
			System.out.println(file +"ռ�ֽڿռ�Ϊ��"+ file.length() +"�ֽ�.");
//			long size = FileUtils.sizeOf(file);//?????
//			long size = FileUtils.sizeOf(file);
//			System.out.println(size);
		}
	}
	
	@Test
	//ϰ��9
	public void testSizeOfDir(){
		File dir = new File("src");
		if(dir.exists() && dir.isDirectory()){
			long size = FileUtils.sizeOfDirectory(dir);
			System.out.println(size +"�ֽ�");//158322�ֽ�
		}
		System.out.println(dir + "ռ���̿ռ�Ϊ��"+ dir.length() +"�ֽڡ�");
					//srcռ���̿ռ�Ϊ��0�ֽڡ� 	file.length()����ֻ�������ļ�����������Ŀ¼��
	}
	
	@Test
	//ϰ��10
	public void testForceMkdir() throws IOException{
		File dirs = new File("a"+ File.separator +"b"+ File.separator +"c");
		if(!dirs.exists()){
			FileUtils.forceMkdir(dirs);
			if(dirs.exists()){
				System.out.println("�������");				
			}
		}else{
			System.out.println("dirs�Ѿ����ڣ�ɾ���ؽ���...");
		}
	}
	
	@Test
	//ϰ��11
	public void testDeleteDir() throws IOException{
		File dir = new File("a");
		if(dir.exists()){
			FileUtils.deleteDirectory(dir);//ɾ��Ŀ¼���ļ��У�
			if(!dir.exists()){
				System.out.println("Ŀ¼ɾ���ɹ���");
			}
		}
	}
	
	@Test
	public void testExists(){//��⵱ǰ·����ָ�ĸ��ļ���----��Ŀ��Ŀ¼ָ����src�ϼ�Ŀ¼
		File file = new File(".");//ָ����Ŀ¼
		File[] list = file.listFiles();//��ȡ��Ŀ¼�µ������ļ�
		for(File f : list){
			if(f.isDirectory()){
				System.out.println("Ŀ¼��"+ f.toString() +" "+ FileUtils.sizeOfDirectory(f) +"�ֽ�");//file�����toString��ӡ����������·��
			}else{
				System.out.println("�ļ���"+ f.getName() +" "+ f.length() +"�ֽ�");//��ӡ��������file���������
			}
		}		
	}
}
















package day05.exercise;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * ����	����File
 * @author Administrator
 *
 */
public class TestFile {
	
	
	@Test
	//����5	���Ի�ȡ�ļ���С
	public void testLength() throws IOException{
		File file = new File("demo"+ File.separator +"HelloWorld.txt");//��demoĿ¼�����ڣ���txt�ļ��������ɹ���
		file.createNewFile();
//		file.delete();
		System.out.println(file.exists());
		System.out.println(file +"ռ���ֽ���Ϊ"+ file.length() +"�ֽ�.");//���з�ռ2�ֽ�
	}
	
	@Test
	//����6	�����ļ�
	public void testCreateNewFile() throws IOException{
		File file = new File("demo"+ File.separator +"Hello.txt");
		if(!file.exists()){//���ļ�������
			file.createNewFile();//
		}		
	}
	
	@Test
	//����7
	public void testDelete(){
		File file = new File("demo"+ File.separator +"Hello.txt");
		if(file.exists()){//������
			file.delete();
		}
	}
	
	@Test
	//����8
	public void testMkDir(){
		File dir = new File("mydir");
		dir.mkdir();
	}
	
	@Test
	//����9	�����༶Ŀ¼���ļ��У�
	public void testMkDirs(){
		File dirs = new File("a" +File.separator +"b"+ File.separator +"c");
		dirs.mkdirs();
	}
	
	@Test
	//����10
	public void testDeleteDir(){
		File dir = new File("demo");
		System.out.println(dir.delete());
	}
}
















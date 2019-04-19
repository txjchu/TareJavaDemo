package day05.exercise;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 案例	测试File
 * @author Administrator
 *
 */
public class TestFile {
	
	
	@Test
	//案例5	测试获取文件大小
	public void testLength() throws IOException{
		File file = new File("demo"+ File.separator +"HelloWorld.txt");//若demo目录不存在，则txt文件创建不成功。
		file.createNewFile();
//		file.delete();
		System.out.println(file.exists());
		System.out.println(file +"占用字节量为"+ file.length() +"字节.");//换行符占2字节
	}
	
	@Test
	//案例6	创建文件
	public void testCreateNewFile() throws IOException{
		File file = new File("demo"+ File.separator +"Hello.txt");
		if(!file.exists()){//若文件不存在
			file.createNewFile();//
		}		
	}
	
	@Test
	//案例7
	public void testDelete(){
		File file = new File("demo"+ File.separator +"Hello.txt");
		if(file.exists()){//若存在
			file.delete();
		}
	}
	
	@Test
	//案例8
	public void testMkDir(){
		File dir = new File("mydir");
		dir.mkdir();
	}
	
	@Test
	//案例9	创建多级目录（文件夹）
	public void testMkDirs(){
		File dirs = new File("a" +File.separator +"b"+ File.separator +"c");
		dirs.mkdirs();
	}
	
	@Test
	//案例10
	public void testDeleteDir(){
		File dir = new File("demo");
		System.out.println(dir.delete());
	}
}
















package day01;

import java.io.File;

/**
 * 删除一个现有文件
 * @author Administrator
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		/*
		 * 将项目根目录下的文件test.txt删除
		 */
		File file=new File("test.txt");
		if(file.exists()){
			file.delete();
			System.out.println("删除完毕！");
		}
		
		
	}
}

package day01.copy;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 * 
 * @author Administrator
 *
 */
public class FileDemo02 {
	public static void main(String[] args) throws IOException {
		/*
		 * 在项目根目录下创建一个新文件test.txt。若不写“./”默认也是在当前项目根目录下创建。
		 */
		File file = new File("test.txt");
		/*
		 * boolean exists()
		 * 判断File表示的文件或目录是否真实存在。存在则返回true。
		 */
		System.out.println(file.exists());
		if(!file.exists()){//若不存在
			//创建该文件
			file.createNewFile();
			System.out.println("文件创建完毕！");
		}
	}
}

















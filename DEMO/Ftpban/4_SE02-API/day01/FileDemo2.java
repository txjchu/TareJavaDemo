package day01;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 在项目根目录下创建一个新文件test.txt
		 * 
		 * 若不写"./"默认也是在当前项目根目录下
		 */
		File file = new File(
			"test.txt"
		);
		/*
		 * boolean exists()
		 * 判断File表示的文件或目录是否真实存在
		 * 存在则返回true
		 */
		if(!file.exists()){
			//创建该文件
			file.createNewFile();
			System.out.println("文件创建完毕!");
		}
	}
	
}









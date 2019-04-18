package day01;

import java.io.File;

/**
 * 创建一个目录
 * @author Administrator
 *
 */
public class FileDemo4 {
	public static void main(String[] args) {
		/*
		 * 在当前项目根目录下创建目录demo
		 */
		File dir = new File("demo");
		
		if(!dir.exists()){
			/*
			 * 创建一个目录
			 */
			dir.mkdir();
			System.out.println("目录创建完毕!");
		}
		
		
	}
}








package day01.copy;

import java.io.File;

/**
 * 创建一个多级目录
 * @author Administrator
 *
 */
public class FileDemo05 {
	public static void main(String[] args) {
		/*
		 * 在当前项目根目录下创建目录：a/b/c/d/e/f
		 */
		File dir = new File("a"+ File.separator +
							 "b"+ File.separator +
							 "c"+ File.separator +
							 "d"+ File.separator +
							 "e"+ File.separator +
							 "f");
		if(!dir.exists()){
			/*
			 * mkdir()在创建目录时，有一个前提条件，即要创建的目录所在的父目录必须存在，否则创建不成功。
			 * mkdirs()在可以创建当前目录的同时，将所有不存在的父目录一同创建出来。
			 */
			dir.mkdirs();
			System.out.println("创建目录dir完毕！");
		}
	}
}

















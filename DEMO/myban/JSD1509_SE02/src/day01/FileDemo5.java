package day01;

import java.io.File;

/**
 * 创建一个多级目录
 * @author Administrator
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * 在当前项目根目录下创建多级目录
		 * a/b/c/d/e/f
		 */
		File dir= new File(
			"a"+File.separator+
			"b"+File.separator+
			"c"+File.separator+
			"d"+File.separator+
			"e"+File.separator+
			"f"
			);
		
		if(!dir.exists()){
			/*
			 * mkdir在创建目录时有一个前提条件，那就是要创建的目录所在的父目录
			 * 必须存在，否则创建不成功的。
			 * mkdirs方法则可以在创建当前目录的同时，将所有不存在的父目录
			 * 一同创建出来。
			 */
			dir.mkdirs();
			System.out.println("目录创建完毕！");
		}
		
		
		
	}
}

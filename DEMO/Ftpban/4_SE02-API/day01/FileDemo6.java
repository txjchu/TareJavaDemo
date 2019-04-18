package day01;

import java.io.File;

/**
 * 删除目录
 * @author Administrator
 *
 */
public class FileDemo6 {
	public static void main(String[] args) {
		File dir = new File("a");
		if(dir.exists()){
			/*
			 * delete若删除目录，前提是该目录
			 * 必须是一个空目录(不含有任何子项)。
			 */
			dir.delete();
			System.out.println("删除目录完毕!");
		}
	}
}







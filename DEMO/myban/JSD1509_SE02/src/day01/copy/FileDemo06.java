package day01.copy;

import java.io.File;

/**
 * 删除目录
 * @author Administrator
 *
 */
public class FileDemo06 {
	public static void main(String[] args) {
		File dir = new 	File("a");
		System.out.println(dir.exists());
		if(dir.exists()){
			/*
			 * delete若删除目录，前提是该目录必须是一个空目录（不包含任何子项）
			 */
			
			System.out.println("删除目录完毕！"+ dir.delete());
		}
	}
}

















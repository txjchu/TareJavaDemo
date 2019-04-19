package day01;

import java.io.File;

/**
 * 获取一个目录下的所有子项
 * @author Administrator
 *
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * 获取当前目录（项目根目录）下的所有子项
		 */
		File dir = new File(".");
		//只有目录才可以获取子项
		if(dir.isDirectory()){
			/*
			 * File[] listFiles()
			 * 该方法会将当前目录下的每一个子项用一个File对象表示，
			 * 然后将这些子项以数组的形式返回。
			 */
			File[] subs =dir.listFiles();
			for(File sub : subs){
			
				System.out.println((sub.isFile()?"文件":"目录")+":"+sub.getName());
			}
			
		}
		
		
	}
}

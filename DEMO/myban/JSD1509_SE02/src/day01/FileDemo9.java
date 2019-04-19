package day01;

import java.io.File;

/**
 * 删除任何给定的File对象所表示的文件（目录）
 * 包含：删除含有的子项文件（目录）
 * 【递归★★★】
 * @author Administrator
 *
 */
public class FileDemo9 {
	public static void main(String[] args) {
		File dir=new File("a");
		deleteFile(dir);
		
	}
	/*
	 * 将给定的File对象所表示的文件（目录）删除
	 */
	public static void deleteFile(File f){
		if(f.isDirectory()){
			//先将所有子项删除----判断
			File[] subs = f.listFiles();
			for(File sub : subs){
				deleteFile(sub);
			}
		}
		f.delete();
	}
	
	
}
